package com.android.steps;

import java.net.MalformedURLException;

import com.backend.executor.WebDriverManager;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LoginPageSteps {

	@Given("^Launch Application$")
	public static void launch() throws MalformedURLException {
		WebDriverManager manager=new WebDriverManager();
		manager.getDriver();
	}
	
//	@Then("^verify response code \"([^\"]*)\"$")
//	public void verifyResponseCode(String code) {		
//		System.out.println("Response:"+OrderServices.getResponse().getStatus().getStatusCode());
//	}
}
