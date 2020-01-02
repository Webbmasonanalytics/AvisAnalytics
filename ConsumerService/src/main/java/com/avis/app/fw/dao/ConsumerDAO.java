package com.avis.app.fw.dao;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface ConsumerDAO {
	
	public boolean insertRecord(ConsumerRecord<String, String> record) throws Exception;
}
