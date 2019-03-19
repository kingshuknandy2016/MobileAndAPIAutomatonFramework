package com.api.backend.base;

public class CookiesFilter extends ClientFilter{

	@Override
	public ClientResponse handle(ClientRequest request) throws ClientHandlerException {
		System.out.println("Request URL:  " + request.getURI());
		ClientResponse clientResponse = getNext().handle(request);
		Response response=new Response(clientResponse);
		System.out.println("Response Code:  " + response.getStatus().getStatusCode());
		System.out.println("Response Phrase:  " + response.getStatus().getReasonPhrase());
		System.out.println("Response Body:  " + response.getMessageBody());
		WebServiceTestBase.setResponse(response);
		return clientResponse;
	}

}

