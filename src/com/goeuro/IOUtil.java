package com.goeuro;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class IOUtil 
{
	public static void writeCsvToFile(String csv, String outputFile) 
	{
		try {
			File file = new File(outputFile);
			FileUtils.writeStringToFile(file, csv);
		} catch (IOException e) {
			System.err.println(e.getMessage());
			throw new BusinessException(e);
		}
	}
	
	public static String getJsonString(String endpoint) 
	{
		String jsonString = null;
		try {
			jsonString = IOUtils.toString(new URL(endpoint));
		} catch (MalformedURLException e) {
			System.err.println(e.getMessage());
			throw new BusinessException(e);
		} catch (IOException e) {
			System.err.println(e.getMessage());
			throw new BusinessException(e);
		}
		return jsonString;
	}
}
