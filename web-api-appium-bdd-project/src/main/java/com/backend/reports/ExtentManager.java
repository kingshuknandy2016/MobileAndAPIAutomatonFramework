package com.backend.reports;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

	private static ExtentReports extent;

	public synchronized static ExtentReports getReporter() {
		if (extent == null) {
			// Set HTML reporting file location
			String workingDir = System.getProperty("user.dir");
			extent = new ExtentReports(workingDir + "\\Reports\\Results.html", true);
		}
		return extent;
	}

}
