package com.common.listners;

import java.net.MalformedURLException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.backend.executor.WebDriverManager;
import com.backend.reports.Reporter;
import com.relevantcodes.extentreports.LogStatus;

public class TestNgListners extends WebDriverManager implements ITestListener{

	public TestNgListners() throws MalformedURLException {
		super();
	}

	private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onStart(ITestContext iTestContext) {
//        System.out.println("I am in onStart method " + iTestContext.getName());
//        iTestContext.setAttribute("WebDriver", getDriver());
    	Reporter.getReporter();
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("I am in onFinish method " + iTestContext.getName());
        //Do tier down operations for extentreports reporting!
//        Reporter.endTest();
//        ExtentManager.getReporter().flush();
        Reporter.endReport();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
//        System.out.println("I am in onTestStart method " +  getTestMethodName(iTestResult) + " start");
//        //Start operation for extentreports.
//        Reporter.startTest(iTestResult.getMethod().getMethodName(),"");
    	Reporter.startParent("1st Scenario", "Scenario 1");
    	
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("I am in onTestSuccess method " +  getTestMethodName(iTestResult) + " succeed");
        //Extentreports log operation for passed tests.
        Reporter.getTest().log(LogStatus.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("I am in onTestFailure method " +  getTestMethodName(iTestResult) + " failed");

        //Get driver from BaseTest and assign to local webdriver variable.
        Object testClass = iTestResult.getInstance();
        WebDriver webDriver = ((WebDriverManager) testClass).getDriver();

        //Take base64Screenshot screenshot.
        String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)webDriver).
                getScreenshotAs(OutputType.BASE64);

        //Extentreports log and screenshot operations for failed tests.
        Reporter.getTest().log(LogStatus.FAIL,"Test Failed",
                Reporter.getTest().addBase64ScreenShot(base64Screenshot));
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("I am in onTestSkipped method "+  getTestMethodName(iTestResult) + " skipped");
        //Extentreports log operation for skipped tests.
        Reporter.getTest().log(LogStatus.SKIP, "Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }

}
