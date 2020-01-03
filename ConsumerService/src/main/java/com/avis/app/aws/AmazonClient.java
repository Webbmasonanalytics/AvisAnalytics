package com.avis.app.aws;

import java.io.File;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.auth.InstanceProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Service
public class AmazonClient {

	private AmazonS3 s3client;

	@Value("${telemetry.aws.regionName}")
	private String regionName;

	@PostConstruct
	private void initializeAmazon() 
	{
		this.s3client = AmazonS3ClientBuilder.standard().withRegion(regionName).withCredentials(InstanceProfileCredentialsProvider.getInstance()).build();
//		this.s3client.setRegion(Region.getRegion(Regions.fromName(regionName)));

	}
	
	public void uploadFile(String bucketName, String awsS3Key, String uploadFileWithLocation) {
		this.s3client.putObject(bucketName, awsS3Key, new File(uploadFileWithLocation));
		
		
	}

	public void moveFile(String sourceBucket,String awsS3SourceLoc, String awsS3DestLoc) {
		this.s3client.copyObject(sourceBucket, awsS3SourceLoc, sourceBucket, awsS3DestLoc);
		this.s3client.deleteObject(sourceBucket, awsS3SourceLoc);
	}
}