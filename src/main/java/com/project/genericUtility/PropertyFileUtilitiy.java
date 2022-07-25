package com.project.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * this class contains generic methods of property file
 * @author sandeep
 *
 */
public final class PropertyFileUtilitiy {

	private FileInputStream fis;
	private Properties properties;
	
	/**
	 * this method is used to load the property file
	 * @param filePath
	 */
	public void loadPropertyFile(String filePath) {
		try {
			fis= new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		properties= new Properties();
		try {
			properties.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * this method is used to get the data from the property file
	 * @param data
	 * @return
	 */
	public String getData(String key) {
		return properties.getProperty(key);
	}
}
