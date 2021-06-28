package com.dummyapi.tests.post;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dummyapi.common.ResponseValidation;
import com.dummyapi.post.FetchPost;

/*
 * Get single post
 */

public class GetPostDetailsTests extends FetchPost{
	public final String POST_ID = getPostId();
	
	@BeforeMethod
	public void setUp()
	{
		System.out.println("========================== Test Starts ===================================");
		setURIAndPath("post/"+POST_ID);
	}
	
	@Test
	public void testPostDetails() {
		
		System.out.println("-------------------Test with PostId: "+POST_ID+"----------------------");
		getPostList();
		ResponseValidation.printOutputInJsonFormat(resp);
		ResponseValidation.validateReturnedJSONSchema(resp, "src/test/resources/postDetailsSchema.json");
		ResponseValidation.validateStatusCode(resp, 200);
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("========================== Test Ends ===================================");
	}
}
