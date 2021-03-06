package com.backend.executor;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(features = "Scenarios/api", 
					glue = {"com.api.steps"}, 
					format = { "pretty", "html:target/cucumber-reports/cucumber-pretty",
								"json:target/cucumber-reports/CucumberTestReport.json", 
									"rerun:target/cucumber-reports/re-run.txt" })

public class TestRunner {
private TestNGCucumberRunner testRunner = new TestNGCucumberRunner(TestRunner.class);

	@DataProvider(name = "features")
	public Object[][] getFeatures() {
		return testRunner.provideFeatures();
	}

	@Test(dataProvider = "features")
	public void startExecution(CucumberFeatureWrapper cFeature) {
		testRunner.runCucumber(cFeature.getCucumberFeature());
	}
	
	@AfterSuite
	public void tearDown() {
		testRunner.finish();
	}
}
