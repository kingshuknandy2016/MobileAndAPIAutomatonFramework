package com.backend.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.configuration.XMLConfiguration;

public class PropertyUtil extends XMLConfiguration {
	public String propertyFileName;
	public Properties properties = new Properties();
	public static Map<String,Object> map=new HashMap();

	public PropertyUtil(String propetyFileName) {
		this.propertyFileName = propetyFileName;
		InputStream inputStream = null;
		try {
			System.err.println(propertyFileName);
			inputStream = new FileInputStream(propertyFileName);
			properties.load(inputStream);
			Set<Map.Entry<Object, Object>> entrySet=properties.entrySet();
			for(Map.Entry<Object, Object> entry:entrySet){
				map.put(entry.getKey().toString(), entry.getValue());
			}
			if(map.get("env.resources").toString().contains(";")){
				String arr[]=map.get("env.resources").toString().split(";");
				for (int i = 1; i < arr.length; i++) {
					inputStream = new FileInputStream(System.getProperty("user.dir")+"/"+arr[i]+"/env.properties");
					properties.load(inputStream);
					entrySet=properties.entrySet();
					for(Map.Entry<Object, Object> entry:entrySet){
						//if (map.containsKey(entry.getKey().toString())) {
							map.put(entry.getKey().toString(), entry.getValue());
						//}
					
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Proerty File Not Found. Exception:" + e.getLocalizedMessage());
		} catch (IOException e1) {
			System.out.println("Exception:" + e1.getLocalizedMessage());
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

	public Object setProperty(String propertyName) {
		return null;
	}

//	public String getProperty(String propertyName) {
//		InputStream inputStream = null;
//		try {
//			System.err.println(propertyFileName);
//			inputStream = new FileInputStream(propertyFileName);
//			properties.load(inputStream);
//			return properties.getProperty(propertyName);
//		} catch (FileNotFoundException e) {
//			System.out.println("Proerty File Not Found. Exception:" + e.getLocalizedMessage());
//			return "property not found";
//		} catch (IOException e1) {
//			System.out.println("Exception:" + e1.getLocalizedMessage());
//			return "property not found";
//		} finally {
//			if (inputStream != null) {
//				try {
//					inputStream.close();
//				} catch (IOException e3) {
//					System.out.println("Exception:" + e3.getLocalizedMessage());
//				}
//			}
//		}
//	}

	public Object getProperty(String propertyName) {
		try {
			if (map.get(propertyName) instanceof String) {
				return (String) map.get(propertyName);
			}else if(map.get(propertyName) instanceof Integer){
				return (int) map.get(propertyName);
			}else
				return map.get(propertyName);
		} catch(Exception e){
			System.out.println("Error:"+e.getMessage());
			return "Property Value not found";
		}
		
	}
	public String[] getStringArray(String key, String... defaultValue) {
		String[] retVal = super.getStringArray(key);
		return (retVal != null) && (retVal.length > 0) ? retVal : defaultValue == null ? new String[] {} : defaultValue;
	}

}
