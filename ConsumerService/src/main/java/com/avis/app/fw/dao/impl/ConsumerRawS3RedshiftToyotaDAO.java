package com.avis.app.fw.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.avis.app.fw.kafka.model.DataObject;
import com.avis.app.raw.kafka.model.TelematicsRawMessage;
import com.avis.app.redshift.model.RawTelemtryToyota;
import com.avis.app.util.AwsS3Util;
import com.avis.app.util.FileUtils;
import com.avis.app.util.JsonParserUtil;

@Component
public class ConsumerRawS3RedshiftToyotaDAO extends DAO {
	private Logger logger = LoggerFactory.getLogger(ConsumerRawS3RedshiftToyotaDAO.class);

	@Autowired
	JsonParserUtil jsonParserUtil;

	@Autowired
	FileUtils fileUtils;

	@Autowired
	AwsS3Util awsS3Util;
	
//	@Autowired
//	RedshiftUtil redshiftUtil;

	
	
	@Value("${telematics.toyota.raw.localfile.directory}")
	private String localDir;

	
	@Value("${telematics.toyota.raw.aws.bucketName}")
	private String bucketName;

	@Value("${telematics.toyota.raw.aws.fileName}")
	private String fileName;

	@Value("${telematics.toyota.raw.aws.directory.inbox}")
	private String inboxDir;

	@Value("${telematics.toyota.raw.aws.directory.archive}")
	private String archiveDir;

	@Value("${telematics.toyota.raw.aws.directory.failed}")
	private String failedDir;

	@Value("${telematics.toyota.raw.aws.fileName.format}")
	private String format;
	
	@Value("${telematics.toyota.raw.redshift.tableName}")
	private String tableName;
	
	@Override
	public boolean insertRecord(ConsumerRecord<String, String> record) throws Exception {

		long startTime = System.currentTimeMillis();
		List<DataObject> dos = jsonParserUtil.getListDataObject(record.value(), TelematicsRawMessage.class);
		final int partition = record.partition();
		final long offset = record.offset();
		final long timestamp = record.timestamp();

		logger.debug("Writing data for partition {}, offset {}", partition, offset);

		String generatedFileName = fileName + "_" + partition + "_" + offset + "." + format;
		String localFile = localDir+"/"+generatedFileName;
		logger.debug("Writing to local file {}",localFile);

		if (dos != null && dos.size() != 0) {
			List<String> content = new ArrayList<String>();
			for (DataObject kafkaMessage : dos) {

				RawTelemtryToyota redshiftData = convertKafkaToRedshiftData((TelematicsRawMessage) kafkaMessage);
				redshiftData.setPartition(partition);
				redshiftData.setOffset(offset);
				redshiftData.setTimestamp(timestamp);
				redshiftData.setTopicName(record.topic());
				String message = jsonParserUtil.getJsonString(redshiftData);
				content.add(message);
			}
			
			//TODO handle failure and parallesim
			logger.debug("s3 Write Data {}",content);
			
			fileUtils.writeDataToFile(content, localFile, false);
			final String s3PutObjectKey =inboxDir + "/" + generatedFileName;
			awsS3Util.uploadObject(bucketName, s3PutObjectKey, localFile);
			
			final String s3MovePath = archiveDir+ "/" + generatedFileName;
			int count = 0;//redshiftUtil.executeCopyCommand(tableName, s3Path);
			logger.debug("effected rows in redshift {}",count);
			logger.info("Move Path :"+s3PutObjectKey);
			logger.info("Archive Path :"+s3MovePath);
			awsS3Util.moveObject(bucketName, s3PutObjectKey, s3MovePath);
		}
		
		
		
		long endTime = System.currentTimeMillis();
		logger.info("Total Time take for partition {}, offset {} is {} milliseconds", partition, offset,
				(endTime - startTime));
		return true;
	}

	public RawTelemtryToyota convertKafkaToRedshiftData(TelematicsRawMessage kafkaTelematicsRawMessage) {

		RawTelemtryToyota redshiftData = new RawTelemtryToyota();

		redshiftData.setCorrelationId(kafkaTelematicsRawMessage.getCorrelationId());
		redshiftData.setLastTimestamp(kafkaTelematicsRawMessage.getLastTimestamp());
		redshiftData.setVehicleName(kafkaTelematicsRawMessage.getVehicleName());
		redshiftData.setVin(kafkaTelematicsRawMessage.getVin());

		// set location data
		if (kafkaTelematicsRawMessage.getLocation() != null) {
			if (kafkaTelematicsRawMessage.getLocation().getCoordinates() != null
					&& kafkaTelematicsRawMessage.getLocation().getCoordinates().size() != 0) {
				redshiftData.setLocation_coordinates_0(kafkaTelematicsRawMessage.getLocation().getCoordinates().get(0));
				redshiftData.setLocation_coordinates_1(kafkaTelematicsRawMessage.getLocation().getCoordinates().get(1));
			}

			redshiftData.setLocation_type(kafkaTelematicsRawMessage.getLocation().getType());
		}

		// set Fuel Data
		if (kafkaTelematicsRawMessage.getFuelLevel() != null) {
			redshiftData.setFuelLevel_value(kafkaTelematicsRawMessage.getFuelLevel().getValue());
		}

		// set Telemetry Data
		if (kafkaTelematicsRawMessage.getTelemetry() != null) {
			// set Driver Window data
			if (kafkaTelematicsRawMessage.getTelemetry().getDriverWindow() != null) {
				redshiftData.setTelemetry_driverWindow_value(
						kafkaTelematicsRawMessage.getTelemetry().getDriverWindow().getValue());
			}
			// set EstimatedFuel Data
			if (kafkaTelematicsRawMessage.getTelemetry().getEstimatedFuelLevel() != null) {
				redshiftData.setTelemetry_estimatedFuelLevel_value(
						kafkaTelematicsRawMessage.getTelemetry().getEstimatedFuelLevel().getValue());
			}

			// set FlTirePressure() data
			if (kafkaTelematicsRawMessage.getTelemetry().getFlTirePressure() != null) {
				redshiftData.setTelemetry_flTirePressure_unit(
						kafkaTelematicsRawMessage.getTelemetry().getFlTirePressure().getUnit());
				redshiftData.setTelemetry_flTirePressure_value(
						kafkaTelematicsRawMessage.getTelemetry().getFlTirePressure().getValue());
			}

			// set FrTirePressure
			if (kafkaTelematicsRawMessage.getTelemetry().getFrTirePressure() != null) {
				redshiftData.setTelemetry_frTirePressure_unit(
						kafkaTelematicsRawMessage.getTelemetry().getFrTirePressure().getUnit());
				redshiftData.setTelemetry_frTirePressure_value(
						kafkaTelematicsRawMessage.getTelemetry().getFrTirePressure().getValue());
			}
			// set Odometer
			if (kafkaTelematicsRawMessage.getTelemetry().getOdometer() != null) {
				redshiftData.setTelemetry_odometer_unit(kafkaTelematicsRawMessage.getTelemetry().getOdometer().getUnit());
				redshiftData
						.setTelemetry_odometer_value(kafkaTelematicsRawMessage.getTelemetry().getOdometer().getValue());
			}
			// set Passenger Window
			if (kafkaTelematicsRawMessage.getTelemetry().getPassengerWindow() != null) {
				redshiftData.setTelemetry_passengerWindow_value(
						kafkaTelematicsRawMessage.getTelemetry().getPassengerWindow().getValue());
			}
			// set RlTirePressure
			if (kafkaTelematicsRawMessage.getTelemetry().getRlTirePressure() != null) {
				redshiftData.setTelemetry_rlTirePressure_unit(
						kafkaTelematicsRawMessage.getTelemetry().getRlTirePressure().getUnit());
				redshiftData.setTelemetry_rlTirePressure_value(
						kafkaTelematicsRawMessage.getTelemetry().getRlTirePressure().getValue());
			}
			// set RlWindow
			if (kafkaTelematicsRawMessage.getTelemetry().getRlWindow() != null) {
				redshiftData
						.setTelemetry_rlWindow_value(kafkaTelematicsRawMessage.getTelemetry().getRlWindow().getValue());
			}

			// set RrWindow
			if (kafkaTelematicsRawMessage.getTelemetry().getRrWindow() != null) {
				redshiftData
						.setTelemetry_rrWindow_value(kafkaTelematicsRawMessage.getTelemetry().getRrWindow().getValue());
			}
			// Set SparkTirePressure
			if (kafkaTelematicsRawMessage.getTelemetry().getSpareTirePressure() != null) {
				redshiftData.setTelemetry_spareTirePressure_unit(
						kafkaTelematicsRawMessage.getTelemetry().getSpareTirePressure().getUnit());
				redshiftData.setTelemetry_spareTirePressure_value(
						kafkaTelematicsRawMessage.getTelemetry().getSpareTirePressure().getValue());
			}
			if (kafkaTelematicsRawMessage.getTelemetry().getSunRoof() != null) {
				redshiftData.setTelemetry_sunRoof_value(kafkaTelematicsRawMessage.getTelemetry().getSunRoof().getValue());
			}
		}

		return redshiftData;
	}

}
