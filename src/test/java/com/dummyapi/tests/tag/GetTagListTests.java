package com.dummyapi.tests.tag;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dummyapi.common.ResponseValidation;
import com.dummyapi.tag.FetchTag;

/*
 * Get tags list
 */

public class GetTagListTests extends FetchTag{
	
	@BeforeMethod
	public void setUp() {
		setURIAndPath("tag");
		System.out.println("========================== Test Starts ===================================");
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("========================== Test Ends ===================================");
	}
	
	/**
	 * Below test can be run different set of data by using DataProvider method
	 * @param pages
	 * @param limit
	 */
	@Test(priority=1,dataProvider = "tagParam")
	public void testPaginationWithDataSetForTagList(int page,int limit) {
		System.out.println("-------------------Test with pages: "+page+" and limit: "+limit+"----------------------");
		getTagList(page, limit);
		ResponseValidation.printOutputInJsonFormat(resp);
		ResponseValidation.validateReturnedJSONSchema(resp, "src/test/resources/tagListSchema.json");
		ResponseValidation.validateStatusCode(resp, 200);
	}
	
	@Test(priority=2)
	public void testDefaultPaginationForTagList() {
		System.out.println("-------------------Test without pages and limit----------------------");
		getTagList();
		ResponseValidation.printOutputInJsonFormat(resp);
		ResponseValidation.validateReturnedJSONSchema(resp, "src/test/resources/tagListSchema.json");
		ResponseValidation.validateStatusCode(resp, 200);
	}
}
