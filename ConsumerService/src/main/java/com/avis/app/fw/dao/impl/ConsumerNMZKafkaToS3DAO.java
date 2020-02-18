package com.avis.app.fw.dao.impl;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.avis.app.nmz.kafka.model.NormalizedMsg;
import com.avis.app.util.AwsS3Util;
import com.avis.app.util.FileUtils;
import com.avis.app.util.JsonParserUtil;

@Component
public class ConsumerNMZKafkaToS3DAO extends DAO {
	private static final Logger logger = LoggerFactory.getLogger(TestConsumerNMZDataToyotaNullDAO.class);

	
	@Autowired JsonParserUtil jsonParserUtil;
	
	@Autowired
	FileUtils fileUtils;

	@Autowired
	AwsS3Util awsS3Util;
	@Value("${telematics.nmz.aws.s3.directory.inbox}")
	private String inboxDir;
	
	@Value("${telematics.nmz.aws.s3.fileName}")
	private String fileName;
	
	@Value("${telematics.nmz.aws.s3.bucketName}")
	private String testBucket;

	@Value("${telematics.nmz.local.directory}")
	private String localDir;
	
	@Value("${telematics.nmz.aws.s3.storage.format}")
	private String format; //Identify the different implementations for storing different formats
	
	@Override
	public boolean insertRecord(ConsumerRecord<String, String> record) throws Exception 
	{
		logger.info("In ConsumerNMZKafkaToS3DAO");
		long currentTimeInMillis = System.currentTimeMillis();
		NormalizedMsg dao = (NormalizedMsg)jsonParserUtil.getDataObject(record.value(), NormalizedMsg.class);
		int partition=record.partition();
		long offset=record.offset();
		logger.debug("Source = {},partition={},offset={}",dao.getSource(),partition,offset);
				logger.debug("Writing data for partition {}, offset {}", partition, offset);
				String generatedFileName = fileName + "_" + partition + "_" + offset + "." + format;
				String localFile = localDir+"/"+generatedFileName;
				logger.debug("Writing to local file {}",localFile);
				fileUtils.writeDataToFile(record.toString(), localFile, false);
				final String s3PutObjectKey =inboxDir + "/" + generatedFileName;
				awsS3Util.uploadObject(testBucket, s3PutObjectKey, localFile);
		long endTimeInMillis = System.currentTimeMillis();
		logger.debug("Total time in millis:{}",(endTimeInMillis-currentTimeInMillis));
		return true;
	}

}
