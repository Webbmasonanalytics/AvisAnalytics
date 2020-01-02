package com.avis.app.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.avis.app.fw.kafka.model.DataObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JsonParserUtil {
	
	ObjectMapper mapper = new ObjectMapper();
	
	/**
	 * 
	 * @param cdcMessage
	 * @param className should extend @DataObject
	 * @return List of DataObjects
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	public List<DataObject> getListDataObject(String cdcMessage, Class<? extends DataObject> className) throws JsonMappingException, JsonProcessingException 
	{
		JsonNode node = mapper.readTree(cdcMessage);
		Iterator<JsonNode> itr = node.iterator();
		List<DataObject> dos=new ArrayList<>();
		while(itr.hasNext()) 
		{
			DataObject obj = getDataObject(itr.next().asText(), className);
			dos.add(obj);
		}
		return dos;
	}
	
	/**
	 * 
	 * @param cdcMessage
	 * @param className should extend @DataObject
	 * @return DataObect
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	public DataObject getDataObject(String cdcMessage, Class<? extends DataObject> className) throws JsonMappingException, JsonProcessingException 
	{
		DataObject DO = (DataObject)mapper.treeToValue(mapper.readTree(cdcMessage), className);
		return DO;
	}

}
