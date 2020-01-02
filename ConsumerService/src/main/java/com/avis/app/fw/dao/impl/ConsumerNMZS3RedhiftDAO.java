package com.avis.app.fw.dao.impl;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.avis.app.nmz.kafka.model.NormalizedMsg;
import com.avis.app.util.JsonParserUtil;

@Component
public class ConsumerNMZS3RedhiftDAO extends DAO {
	
	@Autowired JsonParserUtil jsonParserUtil;

	@Override
	public boolean insertRecord(ConsumerRecord<String, String> record) throws Exception 
	{
		NormalizedMsg dao = (NormalizedMsg)jsonParserUtil.getDataObject(record.key(), NormalizedMsg.class);
		System.out.println(dao);
		return true;
	}

}
