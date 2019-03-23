package com.backend.android;

import java.net.MalformedURLException;
import java.net.URL;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverInitializer {

	public void init() throws MalformedURLException {
		DesiredCapabilities capabilities=new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		//apabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"65e9e0450803");
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.automationtest");
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.automationtest.MainActivity");

		AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		System.out.println("Driver Launch");
		
	}
	
	public static void main(String[] args) throws MalformedURLException {
		DriverInitializer abc=new DriverInitializer();
		abc.init();
	}
}
