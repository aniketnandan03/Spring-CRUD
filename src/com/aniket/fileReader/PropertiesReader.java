package com.aniket.fileReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.stereotype.Component;

@Component("propReader")
public class PropertiesReader {
	public static String getDatabaseType(){
		Properties prop = new Properties();
		InputStream inStream = null;
		
		try {
			inStream = new FileInputStream("database.properties");
			prop.load(inStream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop.getProperty("databaseLocation");
	}
}