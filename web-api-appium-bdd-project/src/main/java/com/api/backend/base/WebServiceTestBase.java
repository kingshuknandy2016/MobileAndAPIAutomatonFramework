package com.api.backend.base;

public class WebServiceTestBase {
private static Response response;

	public static Response getResponse() {
		return response;
	}

	public static void setResponse(Response response) {
		WebServiceTestBase.response = response;
	}

	public static Client getClient() {
		Client client=Client.create();
		client.addFilter(new CookiesFilter());
		return client;
	}
	
	public static WebResource getWebResource(String resource) {
		return  getClient().resource(ConfigurationManager.getBundle().getProperty("env.url")).path(resource);
	}
}
