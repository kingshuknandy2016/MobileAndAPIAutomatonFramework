package com.common.tests;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestSuite1 {
//	@Test(retryAnalyzer=RetryAnalyzer.class)
//	public void Test1(){
//		Assert.assertEquals(false, true);
//	}
//	
//	@Test
//	public void Test2(){
//		Assert.assertEquals(false, true);
//	}
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities capabilities=new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		//apabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"65e9e0450803");
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.automationtest");
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.automationtest.MainActivity");

		@SuppressWarnings("rawtypes")
		AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		driver.findElement(By.id("com.automationtest:id/editTextEmail")).click();
		driver.findElement(By.id("com.automationtest:id/editTextEmail")).sendKeys("test");
		driver.findElement(By.id("com.automationtest:id/editTextPassword")).click();
		driver.findElement(By.id("com.automationtest:id/editTextPassword")).sendKeys("test");
		driver.findElement(By.id("com.automationtest:id/buttonLogin")).click();
		//driver.findElement(By.id("")).sendKeys("test");
		Thread.sleep(7000);
	}
}
