package com.coffee.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;

@Component
public class FileManager {

	public final static String DEFAULT_NAME = "modelX";

	public File createFile(String content) throws IOException {

		File file = new File("./hlvl/" + DEFAULT_NAME + ".hlvl");
		FileOutputStream fop = new FileOutputStream(file);

		file.createNewFile();

		byte[] contentInBytes = content.getBytes();

		fop.write(contentInBytes);
		fop.flush();
		fop.close();
		return file;
	}

	public String fileReader() throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(RestController.DIR + "\\src-gen\\CommonTest_generated.mzn"));
		String mzn = new String(encoded, "UTF-8");

		encoded = Files.readAllBytes(Paths.get(RestController.DIR + "\\src-gen\\CommonTest_generated.mzn"));
		String json = new String(encoded, "UTF-8");

		return mzn + "separadorcoffee" + json;
	}
}
