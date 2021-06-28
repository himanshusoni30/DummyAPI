package com.dummyapi.tests.post;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dummyapi.common.ResponseValidation;
import com.dummyapi.post.FetchPost;

/*
 * Get posts list by tag title that does not exist
 */

public class GetPostByTagTitleThatDoesNotExist extends FetchPost{
	
	@BeforeMethod
	public void setUp() {
		setURIAndPath("tag/blabla/post");
		System.out.println("========================== Test Starts ===================================");
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("========================== Test Ends ===================================");
	}
	
	@Test(priority=1)
	public void testPostByTagTitleThatDoesNotExist() {
		getPostList();
		ResponseValidation.printOutputInJsonFormat(resp);
		ResponseValidation.validateStatusCode(resp, 200);
		ResponseValidation.validateReturnedJSONSchema(resp, "src/test/resources/postByTagTitleSchema.json");
	}
}
