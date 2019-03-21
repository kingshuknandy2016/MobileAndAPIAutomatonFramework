package com.backend.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.configuration.XMLConfiguration;

public class PropertyUtil extends XMLConfiguration {
	public String propertyFileName;
	public Properties properties = new Properties();;

	public PropertyUtil(String propetyFileName) {
		this.propertyFileName = propetyFileName;
	}

	public Object setProperty(String propertyName) {
		return null;
	}

	public String getProperty(String propertyName) {
		InputStream inputStream = null;
		try {
			System.err.println(propertyFileName);
			inputStream = new FileInputStream(propertyFileName);
			properties.load(inputStream);
			return properties.getProperty(propertyName);
		} catch (FileNotFoundException e) {
			System.out.println("Proerty File Not Found. Exception:" + e.getLocalizedMessage());
			return "property not found";
		} catch (IOException e1) {
			System.out.println("Exception:" + e1.getLocalizedMessage());
			return "property not found";
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e3) {
					System.out.println("Exception:" + e3.getLocalizedMessage());
				}
			}
		}
	}

	public String[] getStringArray(String key, String... defaultValue) {
		String[] retVal = super.getStringArray(key);
		return (retVal != null) && (retVal.length > 0) ? retVal : defaultValue == null ? new String[] {} : defaultValue;
	}

}
