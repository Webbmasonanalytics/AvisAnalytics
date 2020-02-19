package com.avis.app.fw.dao.impl;

import java.io.File;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.avis.app.nmz.kafka.model.Acceleration;
import com.avis.app.nmz.kafka.model.Battery12v;
import com.avis.app.nmz.kafka.model.BrainImmobilizer;
import com.avis.app.nmz.kafka.model.DTC;
import com.avis.app.nmz.kafka.model.DoorsAjar;
import com.avis.app.nmz.kafka.model.ElectricCharge;
import com.avis.app.nmz.kafka.model.Fuel;
import com.avis.app.nmz.kafka.model.GPS;
import com.avis.app.nmz.kafka.model.IgnitionSensor;
import com.avis.app.nmz.kafka.model.Odometer;
import com.avis.app.nmz.kafka.model.OilLife;
import com.avis.app.nmz.kafka.model.RentalData;
import com.avis.app.nmz.kafka.model.Revision;
import com.avis.app.nmz.kafka.model.Speed;
import com.avis.app.nmz.kafka.model.Telemetry;
import com.avis.app.nmz.kafka.model.TelemetryNormalizedMsg;
import com.avis.app.nmz.kafka.model.TirePressure;
import com.avis.app.nmz.kafka.model.TrakaSensor;
import com.avis.app.nmz.kafka.model.Transmission;
import com.avis.app.nmz.kafka.model.VehicleDetails;
import com.avis.app.nmz.kafka.model.VehicleState;
import com.avis.app.redshift.model.NormalizeTelematics;
import com.avis.app.util.AwsS3Util;
import com.avis.app.util.FileUtils;
import com.avis.app.util.JsonParserUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Component
public class ConsumerNMZKafkaToS3DAO extends DAO {
	private static final Logger logger = LoggerFactory.getLogger(TestConsumerNMZDataToyotaNullDAO.class);

	@Autowired
	JsonParserUtil jsonParserUtil;

	@Autowired
	FileUtils fileUtils;

	@Value("${file.name.seperator}")
	private String fileNameSeperator;

	@Autowired
	AwsS3Util awsS3Util;
	@Value("${telematics.nmz.aws.s3.directory.inbox}")
	private String inboxDir;

	@Value("${telematics.nmz.aws.s3.fileName}")
	private String fileName;

	@Value("${telematics.nmz.aws.s3.bucketName}")
	private String telematicsBucketName;

	@Value("${telematics.nmz.local.directory}")
	private String localDir;

	@Value("${telematics.nmz.aws.s3.storage.format}")
	private String format; // Identify the different implementations for storing different formats

	@Override
	public boolean insertRecord(ConsumerRecord<String, String> record) throws Exception {
		logger.info("In ConsumerNMZKafkaToS3DAO");
		long currentTimeInMillis = System.currentTimeMillis();
		NormalizeTelematics dataObject = (NormalizeTelematics)getStorageDataObject(record);
		long dataConvertionMillis= System.currentTimeMillis();
		logger.debug("Time Taken for Data Conversion {} in Millis",(dataConvertionMillis-currentTimeInMillis));
		int partition = record.partition();
		long offset = record.offset();

		if (dataObject != null) 
		{
			logger.debug("Writing data for Source = {} , partition {}, offset {}", dataObject.getSource(), partition, offset);
			String generatedFileName = getLocalFileName(record);
			String localFile = localDir + File.separator + generatedFileName;
			final String outputData = jsonParserUtil.getJsonString(dataObject);
			fileUtils.writeDataToFile(outputData, localFile, false);
			final long localWriteTimeEndMillis = System.currentTimeMillis();
			logger.debug("Time Taken for Data Write to Local file{} is {} in Millis",localFile,(localWriteTimeEndMillis-dataConvertionMillis));
			final String s3PutObjectKey = inboxDir + "/" + generatedFileName;
			awsS3Util.uploadObject(telematicsBucketName, s3PutObjectKey, localFile);
			final long s3WriteEndMillis = System.currentTimeMillis();
			logger.debug("Time Taken for Data Write to S3 file {}, is {} in Millis",s3PutObjectKey,(s3WriteEndMillis-localWriteTimeEndMillis));
			
		} else {
			logger.error("No data found for partition {}, offset {}", partition, offset);
		}
		long endTimeInMillis = System.currentTimeMillis();
		logger.debug("Total time of execution in millis:{}", (endTimeInMillis - currentTimeInMillis));

		return true;
	}

	@Override
	public String getLocalFileName(ConsumerRecord<String, String> record) throws Exception {
		String localFileName = fileName + fileNameSeperator + record.partition() + fileNameSeperator + record.offset()
				+ "." + format;
		return localFileName;
	}

	public Object getStorageDataObject(ConsumerRecord<String, String> record)
			throws JsonMappingException, JsonProcessingException {

		NormalizeTelematics data = null;
		TelemetryNormalizedMsg dao = (TelemetryNormalizedMsg) jsonParserUtil.getDataObject(record.value(),
				TelemetryNormalizedMsg.class);
		if (dao != null) {
			data = new NormalizeTelematics();
			// Kafka Metadata
			data.setTopicName(record.topic());
			data.setPartition(record.partition());
			data.setOffset(record.offset());
			data.setKafkaTimeStamp(record.timestamp());

			// Flattening data for redshift

			if (dao.getLastCommDate() != null) {
				data.setLastCommDate(dao.getLastCommDate());
			}

			if (dao.getLastUpdate() != null) {
				data.setLastUpdate(dao.getLastUpdate());
			}

			if (dao.getMVA() != null) {
				data.setMVA(dao.getMVA());
			}
			data.setRevisionNumber(dao.getRevisionNumber());
			data.setSource(dao.getSource());
			data.setStatus(dao.getStatus());

			// Telemetry
			if (dao.getTelemetry() != null) {
				Telemetry telemetry = dao.getTelemetry();
				if (telemetry.getAcceleration() != null) {
					Acceleration acceleration = telemetry.getAcceleration();
					data.setTelemetryAccelerationLevel(acceleration.getLevel());
					data.setTelemetryAccelerationMagnitude(acceleration.getMagnitude());
					data.setTelemetryAccelerationRecorded(acceleration.getRecorded());
					data.setTelemetryAccelerationSource(acceleration.getSource());
				}

				if (telemetry.getBattery12v() != null) {
					Battery12v battery12v = telemetry.getBattery12v();
					data.setTelemetryBattery12vRecorded(battery12v.getRecorded());
					data.setTelemetryBattery12vSource(battery12v.getSource());
					data.setTelemetryBattery12vVoltage(battery12v.getVoltage());
				}
				if (telemetry.getBrainImmobilizer() != null) {
					BrainImmobilizer brainImmobilizer = telemetry.getBrainImmobilizer();
					data.setTelemetryBrainImmobilizerRecorded(brainImmobilizer.getRecorded());
					data.setTelemetryBrainImmobilizerValue(brainImmobilizer.getValue());
				}

				if (telemetry.getDoorsAjar() != null) {
					DoorsAjar doorsAjar = telemetry.getDoorsAjar();
					data.setTelemetryDoorsAjarRecorded(doorsAjar.getRecorded());
					data.setTelemetryDoorsAjarSource(doorsAjar.getSource());
					data.setTelemetryDoorsAjarValue(doorsAjar.getValue());
				}

				if (telemetry.getDTC() != null) {
					DTC dtc = telemetry.getDTC();
					data.setTelemetryDTCCode(dtc.getCode());
					data.setTelemetryDTCDescription(dtc.getDescription());
					data.setTelemetryDTCRecorded(dtc.getRecorded());
					data.setTelemetryDTCSource(dtc.getSource());
				}
				if (telemetry.getElectricCharge() != null) {

					ElectricCharge electricCharge = telemetry.getElectricCharge();
					data.setTelemetryElectricChargeLevel(electricCharge.getLevel());
					data.setTelemetryElectricChargeRecorded(electricCharge.getRecorded());
					data.setTelemetryElectricChargeSource(electricCharge.getSource());
					data.setTelemetryElectricChargeUnits(electricCharge.getUnits());
				}

				data.setTelemetryEncryptedData(telemetry.getEncryptedData());
				data.setTelemetryEngineOff(telemetry.getEngineOff());

				if (telemetry.getFuel() != null) {
					Fuel fuel = telemetry.getFuel();
					data.setTelemetryFuelLevel(fuel.getLevel());
					data.setTelemetryFuelPercentage(fuel.getPercentage());
					data.setTelemetryFuelRecorded(fuel.getRecorded());
					data.setTelemetryFuelSource(fuel.getSource());
					data.setTelemetryFuelUnits(fuel.getUnits());
				}

				if (telemetry.getGPS() != null) {
					GPS gps = telemetry.getGPS();
					data.setTelemetryGPSAccuracy(gps.getAccuracy());
					data.setTelemetryGPSAltitude(gps.getAltitude());
					data.setTelemetryGPSBearing(gps.getBearing());
					data.setTelemetryGPSLatitude(gps.getLatitude());
					data.setTelemetryGPSLongitude(gps.getLongitude());
					data.setTelemetryGPSRecorded(gps.getRecorded());
					data.setTelemetryGPSSource(gps.getSource());

					if (gps.getSpeed() != null) {
						Speed speed = gps.getSpeed();
						data.setTelemetryGPSSpeedSource(speed.getSource());
						data.setTelemetryGPSSpeedUnits(speed.getUnits());
						data.setTelemetryGPSSpeedValue(speed.getValue());
					}
				}

				data.setTelemetryID(telemetry.getID());

				if (telemetry.getIgnitionSensor() != null) {
					IgnitionSensor ignitionSensor = telemetry.getIgnitionSensor();
					data.setTelemetryIgnitionSensorRecorded(ignitionSensor.getRecorded());
					data.setTelemetryIgnitionSensorSource(ignitionSensor.getSource());
					data.setTelemetryIgnitionSensorValue(ignitionSensor.getValue());
				}

				if (telemetry.getOdometer() != null) {
					Odometer odometer = telemetry.getOdometer();
					data.setTelemetryOdometerRecorded(odometer.getRecorded());
					data.setTelemetryOdometerSource(odometer.getSource());
					data.setTelemetryOdometerValue(odometer.getValue());
				}

				if (telemetry.getOilLife() != null) {
					OilLife oilLife = telemetry.getOilLife();
					data.setTelemetryOilLifeLevel(oilLife.getLevel());
					data.setTelemetryOilLifeRecorded(oilLife.getRecorded());
					data.setTelemetryOilLifeSource(oilLife.getSource());
					data.setTelemetryOilLifeUnits(oilLife.getUnits());
				}
				data.setTelemetrySource(telemetry.getSource());

				if (telemetry.getTirePressure() != null) {
					TirePressure tirePressure = telemetry.getTirePressure();
					data.setTelemetryTirePressureFrontLeft(tirePressure.getFrontLeft());
					data.setTelemetryTirePressureFrontRight(tirePressure.getFrontRight());
					data.setTelemetryTirePressureRearLeft(tirePressure.getRearLeft());
					data.setTelemetryTirePressureRearRight(tirePressure.getRearRight());
					data.setTelemetryTirePressureRecorded(tirePressure.getRecorded());
					data.setTelemetryTirePressureSource(tirePressure.getSource());
					data.setTelemetryTirePressureUnits(tirePressure.getUnits());
				}

				if (telemetry.getTrakaSensor() != null) {
					TrakaSensor trakaSensor = telemetry.getTrakaSensor();
					data.setTelemetryTrakaSensorEnabled(trakaSensor.getEnabled());
					data.setTelemetryTrakaSensorIDCode(trakaSensor.getIDCode());
					data.setTelemetryTrakaSensorPlugged(trakaSensor.getPlugged());
					data.setTelemetryTrakaSensorRecorded(trakaSensor.getRecorded());
				}
				if (telemetry.getTransmission() != null) {
					Transmission transmission = telemetry.getTransmission();
					data.setTelemetryTransmissionRecorded(transmission.getRecorded());
					data.setTelemetryTransmissionSource(transmission.getSource());
					data.setTelemetryTransmissionState(transmission.getState());
				}

				data.setTelemetryVIN(telemetry.getVIN());
			}

			// VehicleDetails
			if (dao.getVehicleDetails() != null) {

				VehicleDetails vehicleDetails = dao.getVehicleDetails();

				data.setVehicleDetailsMake(vehicleDetails.getMake());
				data.setVehicleDetailsModel(vehicleDetails.getModel());

				if (vehicleDetails.getRevision() != null) {
					Revision revision = vehicleDetails.getRevision();
					data.setVehicleDetailsRevisionEngineType(revision.getEngineType());
					data.setVehicleDetailsRevisionFuelType(revision.getFuelType());
					data.setVehicleDetailsRevisionTankCapacity(revision.getTankCapacity());
					data.setVehicleDetailsRevisionTankCapacityUnit(revision.getTankCapacityUnit());
					data.setVehicleDetailsRevisionYear(revision.getYear());
				}
				data.setVehicleDetailsWizardMakeCode(vehicleDetails.getWizardMakeCode());
			}

			if (dao.getVehicleState() != null) {
				VehicleState vehicleState = dao.getVehicleState();

				data.setVehicleStateEngineOff(vehicleState.getEngineOff());
				data.setVehicleStateFleetFuelCapacityGals(vehicleState.getFleetFuelCapacityGals());
				data.setVehicleStateGPSCountry(vehicleState.getGPSCountry());
				data.setVehicleStateLotState(vehicleState.getLotState());

				if (vehicleState.getRentalData() != null) {
					RentalData rentalData = vehicleState.getRentalData();
					data.setVehicleStateRentalDataBrand(rentalData.getBrand());
					data.setVehicleStateRentalDataCheckInDue(rentalData.getCheckInDue());
					data.setVehicleStateRentalDataDiscount(rentalData.getDiscount());
					data.setVehicleStateRentalDataMiniLease(rentalData.getMiniLease());
					data.setVehicleStateRentalDataRANumber(rentalData.getRANumber());
					data.setVehicleStateRentalDataRentalType(rentalData.getRentalType());
					data.setVehicleStateRentalDataTimestamp(rentalData.getTimestamp());
					data.setVehicleStateRentalDataWifiEnabled(rentalData.getWifiEnabled());
				}
			}

			if (dao.getVendorIds() != null) {
				data.setVendorIdsPID(dao.getVendorIds().getPID());
			}
			
			data.setVIN(dao.getVIN());

		}
		return data;
	}
}
