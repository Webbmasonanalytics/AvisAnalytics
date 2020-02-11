package com.avis.app.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.avis.app.fw.manage.ProcessConsumer;

@Component
public class AvisConsumer {
	
	@Autowired
	ProcessConsumer coordinator;

	private static final Logger logger = LoggerFactory.getLogger(AvisConsumer.class);

	@KafkaListener(topics = "#{'${avis.cdc.topics}'.split(',')}")
	public void eventsListener(ConsumerRecord<String, String> record) 
	{
		final String topicName = record.topic();
		logger.info("processing the topicName='{}',partition='{}', offset='{}'", topicName,record.partition(),record.offset());
		try {
			coordinator.process(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
