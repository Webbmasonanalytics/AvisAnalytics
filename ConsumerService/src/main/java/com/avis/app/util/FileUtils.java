package com.avis.app.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class FileUtils {

	public void writeDataToFile(final List<String> content, final String fileNameWithLocation, boolean append)
			throws IOException {

		File f = new File(fileNameWithLocation);
		if (!f.getParentFile().exists()) {
			f.getParentFile().mkdirs();
		}

		if (!f.exists()) {
			f.createNewFile();
		}

		if (append) {
			Files.write(Paths.get(fileNameWithLocation), content, StandardOpenOption.APPEND);
		} else {
			Files.write(Paths.get(fileNameWithLocation), content, StandardOpenOption.TRUNCATE_EXISTING);

		}

	}

}
