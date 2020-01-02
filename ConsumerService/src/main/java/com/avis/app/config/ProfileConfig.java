package com.avis.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
public class ProfileConfig {

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigurer() 
	{
		Resource resource;
		String activeProfile;

		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();

		// get active profile
		activeProfile = System.getProperty("spring.profiles.active");

		// choose different property files for different active profile
		if ("PROD".equalsIgnoreCase(activeProfile)) {
			resource = new ClassPathResource("/application-PROD.properties");
		} else if ("QA".equalsIgnoreCase(activeProfile)) {
			resource = new ClassPathResource("/application-QA.properties");
		} else {
			resource = new ClassPathResource("/application-DEV.properties");
		}

		propertySourcesPlaceholderConfigurer.setLocation(resource);

		return propertySourcesPlaceholderConfigurer;
	}

}
