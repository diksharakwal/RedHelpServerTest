package org.redhelp.test.util;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class ServiceCalls {

    public static String registerUserCall(String registerRequestJson) {
	ClientConfig config = new DefaultClientConfig();
	Client client = Client.create(config);
	WebResource service = client.resource(getBaseURI());
	
	ClientResponse response = service.path("rest").path("userAccount").path("registerUser")
	        .type(MediaType.APPLICATION_JSON_TYPE).post(ClientResponse.class, registerRequestJson);

	String output = response.getEntity(String.class);
	return output;
    }
    
    public static String editUserCall(String editRequestJson) {
	ClientConfig config = new DefaultClientConfig();
	Client client = Client.create(config);
	WebResource service = client.resource(getBaseURI());
	
	ClientResponse response = service.path("rest").path("userAccount").path("editUserAccount")
	        .type(MediaType.APPLICATION_JSON_TYPE).post(ClientResponse.class, editRequestJson);

	String output = response.getEntity(String.class);
	return output;
    }

    public static String deleteUserCall(String deleteRequestJson) {
	ClientConfig config = new DefaultClientConfig();
	Client client = Client.create(config);
	WebResource service = client.resource(getBaseURI());
	
	ClientResponse response = service.path("rest").path("userAccount")
		.type(MediaType.APPLICATION_JSON_TYPE)
		.delete(ClientResponse.class, deleteRequestJson);

	String output = response.getEntity(String.class);
	return output;
    }
    
    public static String getUserCall(Long u_id) {
	ClientConfig config = new DefaultClientConfig();
	Client client = Client.create(config);
	WebResource service = client.resource(getBaseURI());
	
	String path = "userAccount/"+u_id;
	System.out.print("path:"+path);
	ClientResponse response = service.path("rest").path(path)
		.type(MediaType.APPLICATION_JSON_TYPE)
		.get(ClientResponse.class);

	String output = response.getEntity(String.class);
	return output;
    }
    
    private static URI getBaseURI() {
	return UriBuilder.fromUri("http://localhost:8080/RedHelpServer").build();
    }
}
