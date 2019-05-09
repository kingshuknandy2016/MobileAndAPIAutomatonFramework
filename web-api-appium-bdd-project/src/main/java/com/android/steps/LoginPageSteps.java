package com.android.steps;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;

import com.android.pages.LoginPage;
import com.backend.executor.WebDriverManager;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class LoginPageSteps {
	static WebDriver driver;
	static WebDriverManager manager;
	static LoginPage loginPage;

	@Given("^Launch Application$")
	public static void launch() throws MalformedURLException {
		manager=new WebDriverManager();
		driver=manager.getDriver();
	}
	
	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public static void user_enters_and(String arg1, String arg2) throws Throwable {
	   loginPage=new LoginPage();
	   loginPage.enterUserNamePass(arg1, arg2);
	}
	
	@When("^User clicks on signin$")
	public static void user_clicks_on_signin() throws Throwable {
	    loginPage.clickLogin();
	}
	
	public static void userEntersUserNamePassword(String username, String password) throws Throwable {
		   loginPage=new LoginPage();
		   loginPage.enterUserNamePass(username, password);
		   loginPage.clickLogin();
		   loginPage.validateSuccessfullLogin();
		}
}
