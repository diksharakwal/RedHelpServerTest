package org.redhelp.test;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.redhelp.common.LoginRequest;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class TestLogin {

	public static void main(String args[]) {
	    ClientConfig config = new DefaultClientConfig();
	    Client client = Client.create(config);
	    WebResource service = client.resource(getBaseURI());
	    String email = "rakwalolol@gmail.com";
	    Gson gson = new Gson();
	    
	  
		LoginRequest loginRequest = new LoginRequest();
		loginRequest.setEmail(email);
		loginRequest.setPassword("pass");
		
		String json_login_request = gson.toJson(loginRequest);
		
		ClientResponse response = service.path("rest").path("userAccount").path("loginUser")
				.type(MediaType.APPLICATION_JSON_TYPE)
				.post(ClientResponse.class, json_login_request);
		
		String output = response.getEntity(String.class);
		System.out.print("login response :"+output);
		
	}
	
	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/RedHelpServer").build();
		
		
	}
}
