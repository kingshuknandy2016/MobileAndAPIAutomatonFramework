package com.backend.executor;

import java.net.MalformedURLException;

import com.backend.utils.ConfigurationManager;

public class DriverConfig {

	public static DriverType getDriverType(){
		System.out.println(ConfigurationManager.getBundle().getProperty("driver.name").toString());
		switch (ConfigurationManager.getBundle().getProperty("driver.name").toString()) {
		case "chromeDriver":return DriverType.CHROME;			    
		case "firefoxDriver":return DriverType.FIREFOX;
		case "androidDriver":return DriverType.ANDROID;
		default:
			break;
		}
		return null;	
	}
	
	public static String getEnvUrl() throws MalformedURLException{
		return ConfigurationManager.getBundle().getProperty("env.url").toString();
	}
}
