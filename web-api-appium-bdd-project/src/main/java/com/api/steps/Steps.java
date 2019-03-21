package com.api.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Steps {
	@Given("^Get order details$")
	public static void get_Orders() {
		OrderServices.getOrders();
	}
	
	@Then("^verify response code \"([^\"]*)\"$")
	public void verifyResponseCode(String code) {		
		System.out.println("Response:"+OrderServices.getResponse().getStatus().getStatusCode());
	}
}
