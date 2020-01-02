package com.avis.app.fw.dao.impl;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import com.avis.app.fw.dao.ConsumerDAO;

public abstract class DAO implements ConsumerDAO {

	@Override
	public boolean insertRecord(ConsumerRecord<String, String> record) throws Exception {
		return false;
	}

}
