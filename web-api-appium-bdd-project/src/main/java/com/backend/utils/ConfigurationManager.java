package com.backend.utils;

public class ConfigurationManager {
	private static final ConfigurationManager INSTANCE = new ConfigurationManager();

	 public static PropertyUtil getBundle() {
	 return new
	 PropertyUtil(System.getProperty("user.dir")+System.getProperty("application.properties.file",
	 "\\resources\\application.properties"));
	 }

	public static void main(String[] args) {
		ConfigurationManager.getBundle().getProperty("env.url");
		System.out.println(ConfigurationManager.getBundle().getProperty("db.properties"));
	}
}
