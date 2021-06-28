package com.dummyapi.tests.post;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dummyapi.common.ResponseValidation;
import com.dummyapi.post.FetchPost;

/*
 * Get posts list
 */

public class GetPostListTests extends FetchPost{
	
	@BeforeMethod
	public void setUp() {
		setURIAndPath("post");
		System.out.println("========================== Test Starts ===================================");
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("========================== Test Ends ===================================");
	}
	
	@Test(priority=2)
	public void testDefaultPaginationForPosts() {
		System.out.println("-------------------Test without pages and limit----------------------");
		getPostList();
		ResponseValidation.printOutputInJsonFormat(resp);
		ResponseValidation.validateReturnedJSONSchema(resp, "src/test/resources/listOfPostsSchema.json");
		ResponseValidation.validateStatusCode(resp, 200);
	}
	
	/**
	 * Below test can be run different set of data by using DataProvider method
	 * @param pages
	 * @param limit
	 */
	@Test(priority=1,dataProvider = "postParam")
	public void testPaginationWithDataSetForPosts(int page,int limit) {
		System.out.println("-------------------Test with pages: "+page+" and limit: "+limit+"----------------------");
		getPostList(page, limit);
		ResponseValidation.printOutputInJsonFormat(resp);
		ResponseValidation.validateReturnedJSONSchema(resp, "src/test/resources/listOfPostsSchema.json");
		ResponseValidation.validateStatusCode(resp, 200);
	}
}
