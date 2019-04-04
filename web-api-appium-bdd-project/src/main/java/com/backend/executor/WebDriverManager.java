package com.backend.executor;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.backend.utils.ConfigurationManager;

public class WebDriverManager {
	private static WebDriver driver=null;
	private static DriverType driverType;
	private static String url;
	
	public WebDriverManager() throws MalformedURLException {
		driverType=DriverConfig.getDriverType();
		url=DriverConfig.getEnvUrl();
	}
	
	public static WebDriver initializeDriver(){
		switch (driverType) {
		case FIREFOX:System.setProperty("webdriver.firefox.driver", ConfigurationManager.getBundle().getProperties("").toString());
					driver=new FirefoxDriver();
					driver.get(url);
			break;
		case CHROME:System.setProperty("webdriver.chrome.driver", "");
					driver=new ChromeDriver();	
					driver.get(url);
		case ANDROID:
			DesiredCapabilities capabilities=new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
			//apabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"65e9e0450803");
			capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.automationtest");
			capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.automationtest.MainActivity");
			try {
				driver=new AndroidDriver(new URL(url),capabilities);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			//driver.get(url);
			break;
		default:
			break;
		}
		return driver;
	}
	public static WebDriver getDriver(){
//		switch (driverType) {
//		case FIREFOX:System.setProperty("webdriver.firefox.driver", ConfigurationManager.getBundle().getProperties("").toString());
//					driver=new FirefoxDriver();
//					driver.get(url);
//			break;
//		case CHROME:System.setProperty("webdriver.chrome.driver", "");
//					driver=new ChromeDriver();	
//					driver.get(url);
//		case ANDROID:
//			DesiredCapabilities capabilities=new DesiredCapabilities();
//			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
//			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
//			//apabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"");
//			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"65e9e0450803");
//			capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.automationtest");
//			capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.automationtest.MainActivity");
//			try {
//				driver=new AndroidDriver(new URL(url),capabilities);
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//			
//			//driver.get(url);
//			break;
//		default:
//			break;
//		}
		if(driver==null){
			driver=initializeDriver();
		}	
		return driver;
	}
	
	public void closeDriver(){
		driver.close();
		 driver.quit();
	}
	
	public static void pause(long millisecs){
		try {
			Thread.sleep(millisecs);
		} catch (InterruptedException e) {
		}
	}
}
