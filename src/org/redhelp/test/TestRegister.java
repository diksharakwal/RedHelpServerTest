package org.redhelp.test;

import org.redhelp.common.RegisterRequest;
import org.redhelp.test.constants.Constants;
import org.redhelp.test.util.ServiceCalls;

import com.google.gson.Gson;

public class TestRegister {

    public static void main(String args[]) {

	RegisterRequest registerRequest = new RegisterRequest();
	registerRequest.setName(Constants.TEST_NAME);
	registerRequest.setEmail(Constants.TEST_EMAIL_ID);
	registerRequest.setPassword(Constants.TEST_PASSWORD);
	registerRequest.setPhoneNo(Constants.TEST_PHONE_NO);
	
	Gson gson = new Gson();
	String json_register_info = gson.toJson(registerRequest);
	String output = ServiceCalls.registerUserCall(json_register_info);
	System.out.print("register output received :" + output);

    }

}
