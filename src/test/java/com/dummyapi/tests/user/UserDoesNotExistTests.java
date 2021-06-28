package com.dummyapi.tests.user;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dummyapi.common.ResponseValidation;
import com.dummyapi.user.FetchUser;

/**
 * Get user that does not exist
 */

public class UserDoesNotExistTests extends FetchUser{
	public final String USER_ID = "60d21b4667d0d8992e610c8a";
	
	@BeforeMethod
	public void setUp()
	{
		System.out.println("========================== Test Starts ===================================");
		setURIAndPath("user/"+USER_ID);
	}
	
	@Test
	public void testUserDoesNotExists() {
		
		System.out.println("-------------------Test with UserId: "+USER_ID+"----------------------");
		getUserList();
		ResponseValidation.printOutputInJsonFormat(resp);
		ResponseValidation.validateStatusCode(resp, 404);
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("========================== Test Ends ===================================");
	}
}
