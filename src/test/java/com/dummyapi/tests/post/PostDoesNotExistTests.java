package com.dummyapi.tests.post;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dummyapi.common.ResponseValidation;
import com.dummyapi.user.FetchUser;

/*
 * Get post that does not exist
 */

public class PostDoesNotExistTests extends FetchUser{
	public final String POST_ID = "60d21b4667d0d8992e610c8a";
	
	@BeforeMethod
	public void setUp()
	{
		System.out.println("========================== Test Starts ===================================");
		setURIAndPath("post/"+POST_ID);
	}
	
	@Test
	public void testPostDoesNotExists() {
		
		System.out.println("-------------------Test with PostId: "+POST_ID+"----------------------");
		getUserList();
		ResponseValidation.printOutputInJsonFormat(resp);
		ResponseValidation.validateStatusCode(resp, 404);
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("========================== Test Ends ===================================");
	}
}
