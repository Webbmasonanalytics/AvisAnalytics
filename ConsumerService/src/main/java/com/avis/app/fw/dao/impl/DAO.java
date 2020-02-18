package com.avis.app.fw.dao.impl;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Component;

import com.avis.app.fw.dao.ConsumerDAO;

@Component
public abstract class DAO implements ConsumerDAO {

	@Override
	public boolean insertRecord(ConsumerRecord<String, String> record) throws Exception {
		return false;
	}
	
	// topicName_timestamp_partition_offset
	
	@Override
	public String getLocalFileName(ConsumerRecord<String, String> record) throws Exception {

		String localFileName = record.topic()+"_"+record.timestamp()+"_"+record.partition()+"_"+record.offset();
		
		return localFileName;
	}

}
