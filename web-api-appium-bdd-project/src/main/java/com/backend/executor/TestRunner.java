package com.backend.executor;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.backend.utils.ConfigurationManager;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;


@Parameters({"features","glue"})
@CucumberOptions(features = "Scenarios/Mobile/android", 
			glue = {"com.android.steps"}, 
					format = { "pretty", "html:target/cucumber-reports/cucumber-pretty",
								"json:target/cucumber-reports/CucumberTestReport.json", 
									"rerun:target/cucumber-reports/re-run.txt" })

public class TestRunner {
private TestNGCucumberRunner testRunner = new TestNGCucumberRunner(TestRunner.class);
	
	@BeforeSuite
	public void init(){
		//MIN_VALUE="";
		ConfigurationManager.getBundle();
		//final String feature1=ConfigurationManager.getBundle().getProperty("").toString();
		
	}
	
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
