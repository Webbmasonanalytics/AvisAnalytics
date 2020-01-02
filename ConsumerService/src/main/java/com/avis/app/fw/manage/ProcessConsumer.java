package com.avis.app.fw.manage;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.ConsumerSeekAware;

public interface ProcessConsumer extends ConsumerSeekAware{
	
	public boolean process(ConsumerRecord<String, String> record) throws Exception;

}
