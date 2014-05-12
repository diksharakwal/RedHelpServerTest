package org.redhelp.test;

import org.junit.Test;
import org.redhelp.common.GetUserAccountResponse;
import org.redhelp.common.RegisterRequest;
import org.redhelp.common.RegisterResponse;
import org.redhelp.test.constants.Constants;
import org.redhelp.test.util.ServiceCalls;

import com.google.gson.Gson;

public class MyAccountTests {

    private RegisterResponse register() {
	RegisterRequest registerRequest = new RegisterRequest();
	registerRequest.setName(Constants.TEST_NAME);
	registerRequest.setEmail(Constants.TEST_EMAIL_ID);
	registerRequest.setPassword(Constants.TEST_PASSWORD);
	registerRequest.setPhoneNo(Constants.TEST_PHONE_NO);
	
	Gson gson = new Gson();
	String json_register_info = gson.toJson(registerRequest);
	String output = ServiceCalls.registerUserCall(json_register_info);
	RegisterResponse registerResponse = gson.fromJson(output, RegisterResponse.class);
	
	return registerResponse;
    }
    @Test
    public void getUserTest() {
	String output = ServiceCalls.getUserCall(25l);
	Gson gson = new Gson();
	System.out.println("output"+output);
	GetUserAccountResponse response = null;
	try{
	 response = gson.fromJson(output, GetUserAccountResponse.class);
	}catch(Exception e) {
	   e.printStackTrace();
	}
	System.out.println(response.getEmail());
	System.out.println(response.getName());
	System.out.println(response.getU_id());
	System.out.println(response.getPhoneNo());
	System.out.println(response.getPasswordEncrypted());
	
	System.out.println(response.toString());
    }
    
    @Test
    public void testRegister() {
	//RegisterResponse registerResponse = register();
//	System.out.print("register output received :" + registerResponse.toString());
    }
    
   /* @Test
    public void testEditMyAccount() {
	//RegisterResponse registerResponse = register();
	
	EditUserAccountRequest editUserRequest = new EditUserAccountRequest();
	editUserRequest.setEmail(Constants.TEST_EDIT_EMAIL_ID);
	editUserRequest.setName(Constants.TEST_EDIT_NAME);
	editUserRequest.setPassword(Constants.TEST_PASSWORD_EDIT);
	editUserRequest.setPhoneNo(Constants.TEST_PHONE_NO_EDIT);
	editUserRequest.setU_id(25l);
	Gson gson = new Gson();
	String json_edit_request = gson.toJson(editUserRequest);
	
	String output = ServiceCalls.editUserCall(json_edit_request);
	EditUserAccountResponse editUserAccountResponse = gson.fromJson(output, EditUserAccountResponse.class);
	System.out.print("edit response :" + editUserAccountResponse);
    }*/

   

}
