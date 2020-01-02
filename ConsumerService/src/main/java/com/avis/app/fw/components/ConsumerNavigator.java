package com.avis.app.fw.components;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.avis.app.fw.dao.ConsumerDAO;
import com.avis.app.fw.manage.ProcessConsumer;

@Component
public class ConsumerNavigator implements ProcessConsumer {

	@Autowired Environment env;
	@Override
	public boolean process(ConsumerRecord<String, String> record) throws Exception {
		final String topicName = record.topic();
		
		try {
			// get operation and perform steps
			List<ConsumerDAO> daos = getDaos(topicName);
			for (ConsumerDAO consumerDAO : daos) {
				consumerDAO.insertRecord(record); // How to achieve parallelism
			}
			
		} finally {

		}
		return true;
	}

	public List<ConsumerDAO> getDaos(String topicName) throws Exception {
		String className = env.getProperty(topicName+".classname");
		if(StringUtils.isBlank(className)) {
			throw new Exception("Please provide the entry in the properties files for "+className);
		}
		List<ConsumerDAO> daos = new ArrayList<ConsumerDAO>();
		final String[] classes = StringUtils.splitPreserveAllTokens(className, ",");
		ConsumerDAO dao = null;
		for (String inputClass : classes) {
			dao = (ConsumerDAO)Class.forName(inputClass).newInstance(); //Need to handle multiple
			daos.add(dao);
		}
		 
		return daos;
	}

}
