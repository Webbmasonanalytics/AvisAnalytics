package com.avis.app.fw.dao.impl;

import org.apache.commons.lang3.StringUtils;
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
public class TestConsumerNMZDataToyotaNullDAO extends DAO 
{
	private static final Logger logger = LoggerFactory.getLogger(TestConsumerNMZDataToyotaNullDAO.class);

	
	@Autowired JsonParserUtil jsonParserUtil;
	
	@Autowired
	FileUtils fileUtils;

	@Autowired
	AwsS3Util awsS3Util;
	@Value("${telemetry.toyota.nmz.test.aws.directory.inbox}")
	private String inboxDir;
	
	@Value("${telemetry.toyota.nmz.test.aws.fileName}")
	private String fileName;
	
	@Value("${telemetry.toyota.nmz.test.aws.bucketName}")
	private String testBucket;

	@Value("${telemetry.toyota.nmz.test.localfile.directory}")
	private String localDir;
	
	@Value("${telemetry.toyota.nmz.test.aws.fileName.format}")
	private String format;
	
	@Value("${source.toyota}")
	private String toyotaSource;

	@Override
	public boolean insertRecord(ConsumerRecord<String, String> record) throws Exception 
	{
		logger.info("In TestConsumerNMZDataToyotaNullDAO");
		long currentTimeInMillis = System.currentTimeMillis();
		NormalizedMsg dao = (NormalizedMsg)jsonParserUtil.getDataObject(record.value(), NormalizedMsg.class);
		int partition=record.partition();
		long offset=record.offset();
		logger.debug("Source = {},partition={},offset={}",dao.getSource(),partition,offset);
		if(StringUtils.equalsIgnoreCase(dao.getSource(),toyotaSource)) {
			logger.debug("Toyota_Data, partition={},offset={}",partition,offset);
			if(dao.getTelemetry()==null) {
				logger.debug("Writing data for partition {}, offset {}", partition, offset);
				String generatedFileName = fileName + "_" + partition + "_" + offset + "." + format;
				String localFile = localDir+"/"+generatedFileName;
				logger.debug("Writing to local file {}",localFile);
				fileUtils.writeDataToFile(record.toString(), localFile, false);
				final String s3PutObjectKey =inboxDir + "/" + generatedFileName;
				awsS3Util.uploadObject(testBucket, s3PutObjectKey, localFile);
			}
		}
		long endTimeInMillis = System.currentTimeMillis();
		logger.debug("Total time in millis:{}",(endTimeInMillis-currentTimeInMillis));
		return true;
	}

}

