package com.avis.app.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;

public class RedshiftUtil 
{

	@Value("${telemetry.toyota.raw.accessKey}")
	private String accessKey;
	
	@Value("${telemetry.toyota.raw.secretKey}")
	private String secretKey;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	public int executeCopyCommand(String tableName, String s3Path) 
	{
        String command = "COPY "+tableName+" FROM '"+s3Path+"' JSON 'auto' TIMEFORMAT 'auto' CREDENTIALS 'aws_access_key_id="+accessKey+";aws_secret_access_key="+secretKey+"'";
        return jdbcTemplate.update(command);
	}

}
