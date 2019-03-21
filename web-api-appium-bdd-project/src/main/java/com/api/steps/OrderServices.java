package com.api.steps;

import com.backend.api.WebServiceTestBase;
import com.sun.jersey.api.client.ClientResponse;

public class OrderServices extends WebServiceTestBase{
public static void getOrders() {
		getWebResource("/orders.json").get(ClientResponse.class);
	}
	
	public static void addOrders(String clientName,String amount) {
		String entity=String.format("{'clientName':'%s','amount':'%s'}", clientName,amount);
		getWebResource("/orders.json").entity(entity).post(ClientResponse.class);
	}
	
	public static void deleteOrder(String orderId) {
		String entity=String.format("/orders/%s.json", orderId);
		getWebResource(entity).delete(ClientResponse.class);
	}
	
	public static void editOrder(String orderId,String clientName,String amount) {
		String entity=String.format("{'clientName':'%s','amount':'%s'}", clientName,amount);
		String resource=String.format("/orders/%s.json", orderId);
		getWebResource(resource).entity(entity).put(ClientResponse.class);
	}
}
