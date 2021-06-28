package com.dummyapi.tests.user;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dummyapi.common.ResponseValidation;
import com.dummyapi.user.FetchUser;

/**
 * Get user Full profile
 *
 */

public class GetUserDetailsTests extends FetchUser{
	public final String USER_ID = getUserId();
	
	@BeforeMethod
	public void setUp()
	{
		System.out.println("========================== Test Starts ===================================");
		setURIAndPath("user/"+USER_ID);
	}
	
	@Test
	public void testUserDetails() {
		
		System.out.println("-------------------Test with UserId: "+USER_ID+"----------------------");
		getUserList();
		ResponseValidation.printOutputInJsonFormat(resp);
		ResponseValidation.validateReturnedJSONSchema(resp, "src/test/resources/userDetailsSchema.json");
		ResponseValidation.validateStatusCode(resp, 200);
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("========================== Test Ends ===================================");
	}
}
