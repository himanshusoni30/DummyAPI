package com.dummyapi.tests.user;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dummyapi.common.ResponseValidation;
import com.dummyapi.user.FetchUser;

/**
 * Get users list
 */

public class GetUserListTests extends FetchUser{
	
	@BeforeMethod
	public void setUp() {
		setURIAndPath("user");
		System.out.println("========================== Test Starts ===================================");
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("========================== Test Ends ===================================");
	}
	
	@Test(priority=2)
	public void testDefaultPaginationForUserList() {
		System.out.println("-------------------Test without pages and limit----------------------");
		getUserList();
		ResponseValidation.printOutputInJsonFormat(resp);
		ResponseValidation.validateReturnedJSONSchema(resp, "src/test/resources/listOfUsersSchema.json");
		ResponseValidation.validateStatusCode(resp, 200);
	}
	
	/**
	 * Below test can be run different set of data by using DataProvider method
	 * @param pages
	 * @param limit
	 */
	@Test(priority=1,dataProvider = "parameters")
	public void testPaginationWithDataSetForUserList(int page,int limit) {
		System.out.println("-------------------Test with pages: "+page+" and limit: "+limit+"----------------------");
		getUserList(page, limit);
		ResponseValidation.printOutputInJsonFormat(resp);
		ResponseValidation.validateReturnedJSONSchema(resp, "src/test/resources/listOfUsersSchema.json");
		ResponseValidation.validateStatusCode(resp, 200);
	}
}
