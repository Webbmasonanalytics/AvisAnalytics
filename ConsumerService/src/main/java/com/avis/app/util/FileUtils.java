package com.avis.app.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class FileUtils {
	
	
	
	public void writeDataToFile(final List<String> content,final String fileName, boolean append) throws IOException 
	{
		
		if(append) {
		Files.write(
			      Paths.get(fileName), 
			      content, 
			      StandardOpenOption.APPEND);
		}else {
			Files.write(
				      Paths.get(fileName), 
				      content, 
				      StandardOpenOption.TRUNCATE_EXISTING);
				
		}
		
	}

}
