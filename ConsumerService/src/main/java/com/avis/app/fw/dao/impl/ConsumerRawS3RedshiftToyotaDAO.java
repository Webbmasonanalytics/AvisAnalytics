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
import com.avis.app.raw.kafka.model.TelemetryRawMessage;
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

	
	
	@Value("${telemetry.toyota.raw.localfile.directory}")
	private String localDir;

	
	@Value("${telemetry.toyota.raw.aws.bucketName}")
	private String bucketName;

	@Value("${telemetry.toyota.raw.aws.fileName}")
	private String fileName;

	@Value("${telemetry.toyota.raw.aws.directory.inbox}")
	private String inboxDir;

	@Value("${telemetry.toyota.raw.aws.directory.archive}")
	private String archiveDir;

	@Value("${telemetry.toyota.raw.aws.directory.failed}")
	private String failedDir;

	@Value("${telemetry.toyota.raw.aws.fileName.format}")
	private String format;
	
	@Value("${telemetry.toyota.raw.redshift.tableName}")
	private String tableName;
	
	@Override
	public boolean insertRecord(ConsumerRecord<String, String> record) throws Exception {

		long startTime = System.currentTimeMillis();
		List<DataObject> dos = jsonParserUtil.getListDataObject(record.value(), TelemetryRawMessage.class);
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

				RawTelemtryToyota redshiftData = convertKafkaToRedshiftData((TelemetryRawMessage) kafkaMessage);
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
		logger.debug("Total Time take for partition {}, offset {} is {} milliseconds", partition, offset,
				(endTime - startTime));
		return true;
	}

	public RawTelemtryToyota convertKafkaToRedshiftData(TelemetryRawMessage kafkaTelemtryRawMessage) {

		RawTelemtryToyota redshiftData = new RawTelemtryToyota();

		redshiftData.setCorrelationId(kafkaTelemtryRawMessage.getCorrelationId());
		redshiftData.setLastTimestamp(kafkaTelemtryRawMessage.getLastTimestamp());
		redshiftData.setVehicleName(kafkaTelemtryRawMessage.getVehicleName());
		redshiftData.setVin(kafkaTelemtryRawMessage.getVin());

		// set location data
		if (kafkaTelemtryRawMessage.getLocation() != null) {
			if (kafkaTelemtryRawMessage.getLocation().getCoordinates() != null
					&& kafkaTelemtryRawMessage.getLocation().getCoordinates().size() != 0) {
				redshiftData.setLocation_coordinates_0(kafkaTelemtryRawMessage.getLocation().getCoordinates().get(0));
				redshiftData.setLocation_coordinates_1(kafkaTelemtryRawMessage.getLocation().getCoordinates().get(1));
			}

			redshiftData.setLocation_type(kafkaTelemtryRawMessage.getLocation().getType());
		}

		// set Fuel Data
		if (kafkaTelemtryRawMessage.getFuelLevel() != null) {
			redshiftData.setFuelLevel_value(kafkaTelemtryRawMessage.getFuelLevel().getValue());
		}

		// set Telemetry Data
		if (kafkaTelemtryRawMessage.getTelemetry() != null) {
			// set Driver Window data
			if (kafkaTelemtryRawMessage.getTelemetry().getDriverWindow() != null) {
				redshiftData.setTelemetry_driverWindow_value(
						kafkaTelemtryRawMessage.getTelemetry().getDriverWindow().getValue());
			}
			// set EstimatedFuel Data
			if (kafkaTelemtryRawMessage.getTelemetry().getEstimatedFuelLevel() != null) {
				redshiftData.setTelemetry_estimatedFuelLevel_value(
						kafkaTelemtryRawMessage.getTelemetry().getEstimatedFuelLevel().getValue());
			}

			// set FlTirePressure() data
			if (kafkaTelemtryRawMessage.getTelemetry().getFlTirePressure() != null) {
				redshiftData.setTelemetry_flTirePressure_unit(
						kafkaTelemtryRawMessage.getTelemetry().getFlTirePressure().getUnit());
				redshiftData.setTelemetry_flTirePressure_value(
						kafkaTelemtryRawMessage.getTelemetry().getFlTirePressure().getValue());
			}

			// set FrTirePressure
			if (kafkaTelemtryRawMessage.getTelemetry().getFrTirePressure() != null) {
				redshiftData.setTelemetry_frTirePressure_unit(
						kafkaTelemtryRawMessage.getTelemetry().getFrTirePressure().getUnit());
				redshiftData.setTelemetry_frTirePressure_value(
						kafkaTelemtryRawMessage.getTelemetry().getFrTirePressure().getValue());
			}
			// set Odometer
			if (kafkaTelemtryRawMessage.getTelemetry().getOdometer() != null) {
				redshiftData.setTelemetry_odometer_unit(kafkaTelemtryRawMessage.getTelemetry().getOdometer().getUnit());
				redshiftData
						.setTelemetry_odometer_value(kafkaTelemtryRawMessage.getTelemetry().getOdometer().getValue());
			}
			// set Passenger Window
			if (kafkaTelemtryRawMessage.getTelemetry().getPassengerWindow() != null) {
				redshiftData.setTelemetry_passengerWindow_value(
						kafkaTelemtryRawMessage.getTelemetry().getPassengerWindow().getValue());
			}
			// set RlTirePressure
			if (kafkaTelemtryRawMessage.getTelemetry().getRlTirePressure() != null) {
				redshiftData.setTelemetry_rlTirePressure_unit(
						kafkaTelemtryRawMessage.getTelemetry().getRlTirePressure().getUnit());
				redshiftData.setTelemetry_rlTirePressure_value(
						kafkaTelemtryRawMessage.getTelemetry().getRlTirePressure().getValue());
			}
			// set RlWindow
			if (kafkaTelemtryRawMessage.getTelemetry().getRlWindow() != null) {
				redshiftData
						.setTelemetry_rlWindow_value(kafkaTelemtryRawMessage.getTelemetry().getRlWindow().getValue());
			}

			// set RrWindow
			if (kafkaTelemtryRawMessage.getTelemetry().getRrWindow() != null) {
				redshiftData
						.setTelemetry_rrWindow_value(kafkaTelemtryRawMessage.getTelemetry().getRrWindow().getValue());
			}
			// Set SparkTirePressure
			if (kafkaTelemtryRawMessage.getTelemetry().getSpareTirePressure() != null) {
				redshiftData.setTelemetry_spareTirePressure_unit(
						kafkaTelemtryRawMessage.getTelemetry().getSpareTirePressure().getUnit());
				redshiftData.setTelemetry_spareTirePressure_value(
						kafkaTelemtryRawMessage.getTelemetry().getSpareTirePressure().getValue());
			}
			if (kafkaTelemtryRawMessage.getTelemetry().getSunRoof() != null) {
				redshiftData.setTelemetry_sunRoof_value(kafkaTelemtryRawMessage.getTelemetry().getSunRoof().getValue());
			}
		}

		return redshiftData;
	}

}
