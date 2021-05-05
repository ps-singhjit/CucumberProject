package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private Properties prop;
	
	public Properties init_prop() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(ip);
			 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return prop;

	}
	
	public Properties init_Extprop() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/extent.properties");
			prop.load(ip);
			 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return prop;

	}

	public void writeToExtentProperty(String key, String value) {
		// Instantiating the properties file
		try {
			String path = "./src/test/resources/extent.properties";
			Properties props = new Properties();
			FileInputStream ip = new FileInputStream(path);
			props.load(ip);
			String oldValue = props.getProperty(key);
			ip.close();
			System.out.println("old value==> " +oldValue);
			
			
			props.replace(key, oldValue, value);
			
			// Instantiating the FileInputStream for output file
			
			FileOutputStream outputStream = new FileOutputStream(path);
			// Storing the properties file
//			props.store(outputStream, "This is a sample properties file");
			props.store(outputStream, "new value saved");
			outputStream.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Extent Properties file updated......");

	}

}
