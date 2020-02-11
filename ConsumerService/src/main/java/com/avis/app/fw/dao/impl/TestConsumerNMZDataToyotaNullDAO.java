package com.avis.app.fw.dao.impl;

import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.avis.app.nmz.kafka.model.NormalizedMsg;
import com.avis.app.util.JsonParserUtil;

@Component
public class TestConsumerNMZDataToyotaNullDAO extends DAO 
{
	private static final Logger logger = LoggerFactory.getLogger(TestConsumerNMZDataToyotaNullDAO.class);

	
	@Autowired JsonParserUtil jsonParserUtil;
	@Value("${telemetry.toyota.nmz.test.aws.directory.inbox}")
	private String inboxDir;
	
	@Value("${telemetry.toyota.nmz.test.aws.bucketName}")
	private String testBucket;

	@Value("${telemetry.toyota.raw.localfile.directory}")
	private String localDir;
	
	@Value("${source.toyota}")
	private String toyotaSource;

	@Override
	public boolean insertRecord(ConsumerRecord<String, String> record) throws Exception 
	{
		logger.debug("In TestConsumerNMZDataToyotaNullDAO");
		NormalizedMsg dao = (NormalizedMsg)jsonParserUtil.getDataObject(record.value(), NormalizedMsg.class);
		if(StringUtils.equalsIgnoreCase(dao.getSource(),toyotaSource)) {
			if(dao.getTelemetry()==null) {
				logger.debug("Writing data for partition {}, offset {}", record.partition(), record.offset());
				logger.info(record.toString());
			}
		}
		return true;
	}

}
