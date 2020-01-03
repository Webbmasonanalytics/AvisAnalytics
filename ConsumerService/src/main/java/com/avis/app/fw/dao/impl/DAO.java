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

}
