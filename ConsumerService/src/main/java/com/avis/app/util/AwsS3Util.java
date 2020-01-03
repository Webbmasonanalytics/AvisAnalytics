package com.avis.app.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.avis.app.aws.AmazonClient;

@Component
public class AwsS3Util {
	
	@Autowired
	AmazonClient awsClient;
	
	public void uploadObject(String bucketName, String awsS3Key, String uploadFileWithLocation) 
	{
		awsClient.uploadFile(bucketName, awsS3Key, uploadFileWithLocation);
	}

}
