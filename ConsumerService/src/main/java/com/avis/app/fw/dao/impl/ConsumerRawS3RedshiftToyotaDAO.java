package com.avis.app.fw.dao.impl;

import java.util.List;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.avis.app.fw.kafka.model.DataObject;
import com.avis.app.raw.kafka.model.TelemetryRawMessage;
import com.avis.app.util.JsonParserUtil;

@Component
public class ConsumerRawS3RedshiftToyotaDAO extends DAO 
{
	
	@Autowired 
	ResourceLoader resourceLoader;

	@Autowired JsonParserUtil jsonParserUtil;
	@Override
	public boolean insertRecord(ConsumerRecord<String, String> record) throws Exception {
		
		List<DataObject> dos = jsonParserUtil.getListDataObject(record.value(), TelemetryRawMessage.class);
		
		return true;
	}

}
