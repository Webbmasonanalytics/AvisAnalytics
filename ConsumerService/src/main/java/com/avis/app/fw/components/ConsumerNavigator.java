package com.avis.app.fw.components;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.avis.app.fw.dao.ConsumerDAO;
import com.avis.app.fw.dao.impl.ConsumerNMZS3RedhiftDAO;
import com.avis.app.fw.dao.impl.ConsumerRawS3RedshiftToyotaDAO;
import com.avis.app.fw.manage.ProcessConsumer;

@Component
public class ConsumerNavigator implements ProcessConsumer {

	@Autowired
	Environment env;
	@Value("${telemetry.toyota.raw.topicName}")
	private String telemetryRawToyotaTopicName;
	
	@Value("${telemetry.nmz.topicName}")
	private String telemetryNMZTopicName;
	
	@Value("${telemetry.test.NMZ.nulls}")
	private boolean testTelemetryNMZNulls;
	
	@Autowired
	ConsumerRawS3RedshiftToyotaDAO rawS3RedshiftToyotaDAO;
	
	@Autowired
	ConsumerNMZS3RedhiftDAO nmzS3RedhiftDAO;

	public List<ConsumerDAO> getDaos(String topicName) throws Exception {
		String className = env.getProperty(topicName + ".classname");
		if (StringUtils.isBlank(className)) {
			throw new Exception("Please provide the entry in the properties files for " + className);
		}
		List<ConsumerDAO> daos = new ArrayList<ConsumerDAO>();
		final String[] classes = StringUtils.splitPreserveAllTokens(className, ",");
		ConsumerDAO dao = null;
		for (String inputClass : classes) {
			dao = (ConsumerDAO) Class.forName(inputClass).newInstance(); // Need to handle multiple
			daos.add(dao);
		}

		return daos;
	}

	@Override
	public boolean process(ConsumerRecord<String, String> record) throws Exception {

		final String topicName = record.topic();
		if(StringUtils.equalsIgnoreCase(topicName, telemetryRawToyotaTopicName)) {
			rawS3RedshiftToyotaDAO.insertRecord(record);
		}else if(StringUtils.equalsIgnoreCase(topicName, telemetryNMZTopicName)) {
			if(!testTelemetryNMZNulls) 
			{
			nmzS3RedhiftDAO.insertRecord(record);
			}else {
				
			}
		}
		return false;
	}

}
