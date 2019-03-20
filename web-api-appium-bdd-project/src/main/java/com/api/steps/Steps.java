package com.api.steps;

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
