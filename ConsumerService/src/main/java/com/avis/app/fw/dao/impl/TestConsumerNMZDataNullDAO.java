package com.avis.app.fw.dao.impl;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.avis.app.nmz.kafka.model.NormalizedMsg;
import com.avis.app.util.JsonParserUtil;

@Component
public class TestConsumerNMZDataNullDAO extends DAO 
{
	private static final Logger logger = LoggerFactory.getLogger(TestConsumerNMZDataNullDAO.class);

	
	@Autowired JsonParserUtil jsonParserUtil;

	@Override
	public boolean insertRecord(ConsumerRecord<String, String> record) throws Exception 
	{
		logger.debug("In TestConsumerNMZDataNullDAO");
		NormalizedMsg dao = (NormalizedMsg)jsonParserUtil.getDataObject(record.value(), NormalizedMsg.class);
		System.out.println(dao);
		return true;
	}

}
