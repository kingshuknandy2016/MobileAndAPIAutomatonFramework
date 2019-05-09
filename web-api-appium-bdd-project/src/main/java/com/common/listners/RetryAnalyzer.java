package com.common.listners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.backend.executor.WebDriverManager;
import com.backend.reports.Reporter;
import com.relevantcodes.extentreports.LogStatus;

public class RetryAnalyzer implements IRetryAnalyzer {

	int counter = 0;
	int retrylimit = 3;

	@Override
	public boolean retry(ITestResult result) {
		if (counter < retrylimit) {
			counter++;
			return true;
		}
		return false;
	}
	
	   public void extendReportsFailOperations (ITestResult iTestResult) {
	        Object testClass = iTestResult.getInstance();
	        WebDriver webDriver = ((WebDriverManager) testClass).getDriver();
	        String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)webDriver).getScreenshotAs(OutputType.BASE64);
	        Reporter.getTest().log(LogStatus.FAIL,"Test Failed",
	                Reporter.getTest().addBase64ScreenShot(base64Screenshot));
	    }

}
