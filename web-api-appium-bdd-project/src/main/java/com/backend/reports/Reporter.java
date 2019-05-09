package com.backend.reports;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.backend.executor.WebDriverManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reporter {
	static Map extentTestMap = new HashMap();
	static ExtentReports extent/* = ExtentManager.getReporter()*/;
	static ExtentTest parent;
	static ExtentTest child;
	static ArrayList<ExtentTest> childArray;
	
	public static void getReporter() {
		if (extent == null) {
			// Set HTML reporting file location
			String workingDir = System.getProperty("user.dir");
			extent = new ExtentReports(workingDir + "\\Reports\\Results.html", true);
		}
	}

	public static synchronized ExtentTest getTest() {
		return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
	}
//
//	public static synchronized void endTest() {
//		extent.endTest((ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId())));
//	}
//
//	public static synchronized ExtentTest startTest(String testName, String desc) {
//		ExtentTest test = extent.startTest(testName, desc);
//		extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
//		return test;
//	}

	public static String captureScreen(String imageName) {
		String workingDir = System.getProperty("user.dir");
		TakesScreenshot screenShot = (TakesScreenshot) WebDriverManager.getDriver();
		File oScnShot = screenShot.getScreenshotAs(OutputType.FILE);
		File oDest = new File(workingDir + "\\Reports\\Images\\" + imageName + ".jpg");

		try {
			FileUtils.copyFile(oScnShot, oDest);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return workingDir + "\\Reports\\Images\\" + imageName + ".jpg";
		
	}
	
	public static void startParent(String testName,String description){
		parent=extent.startTest(testName, description);
		childArray=new ArrayList<ExtentTest>();
	}
	
	public static void startStep(String stepName,String stepDescription){
		
		child=extent.startTest(stepName, stepDescription);
	}
	
	public static void logStatus(LogStatus status,String description){
		child.log(status, description);
	}
	
	public static void logMessage(String description){
		child.log(LogStatus.INFO, description);
	}
	public static void logStatusWithScreenshot(LogStatus logStatus,String desString){
		 //Take base64Screenshot screenshot.
        String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot) WebDriverManager.getDriver()).
                getScreenshotAs(OutputType.BASE64);

        //Extentreports log and screenshot operations for failed tests.
//        Reporter.logStatusWithScreenshot(logStatus.,"Test Failed",
//                Reporter.getTest().addBase64ScreenShot(base64Screenshot));
	}
	
	public static void endStep(){
		extent.endTest(child);
		childArray.add(child);
	}
	
	public static void endParent(){
		for (ExtentTest test:childArray) {
			parent.appendChild(test);
		}
		extent.endTest(parent);
	}
	
	public static void endReport(){
		extent.flush();
	}
	public static void main(String[] args) {
	
//		ExtentReports extent1 = new ExtentReports(System.getProperty("user.dir") + "\\Reports\\Results.html", true);
//		ExtentTest testParent = extent1.startTest("Test Case 1","Initial Test Case");
//		ExtentTest testNode1=extent1.startTest("Node 1", "Node 1 Details");
//		testNode1.log(LogStatus.FAIL, "Trst case succes  fu passes");
//		extent1.endTest(testNode1);
//		testParent.appendChild(testNode1);
//		testParent.log(LogStatus.PASS, "Failed");
//		extent1.endTest(testParent);
//		extent1.flush();
//		
//		ExtentTest testParent2 = extent1.startTest("Test Case 2","Second Test Scenario");
//		ExtentTest testNode2=extent1.startTest("Node A", "Node A Details");
//		System.out.println(captureScreen("demoImg"));
//		testNode2.addScreenCapture(captureScreen("demoImg"));
//		testNode2.log(LogStatus.PASS, "Trst case succes  fu passes");
//		extent1.endTest(testNode2);
//		testParent2.appendChild(testNode2);
//		ExtentTest testNode3=extent1.startTest("Node B", "Node B Details");
//		testNode3.log(LogStatus.FATAL, "Trst case succes  fu passes");
//		extent1.endTest(testNode3);
//		testParent2.appendChild(testNode3);
//		testParent2.log(LogStatus.PASS, "Failed");
//		extent1.endTest(testParent2);
//		extent1.flush();
		getReporter();
		startParent("1st Scenario", "Scenario 1");
		startStep("StepA", "");
		//logStatus(LogStatus.PASS, "");
		logMessage("Hi I am");
		logMessage("I want to go");
		endStep();
		startStep("StepB", "");
		logStatus(LogStatus.PASS, "");
		endStep();
		startStep("StepC", "");
		logStatus(LogStatus.PASS, "");
		endStep();
		endParent();
		
		startParent("1st Scenario", "Scenario 1");
		endParent();
		endReport();
	}
}
