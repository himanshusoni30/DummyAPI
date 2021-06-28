package com.dummyapi.tests.comment;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dummyapi.comment.FetchComment;
import com.dummyapi.common.ResponseValidation;
import com.dummyapi.post.FetchPost;

/*
 * Get post comments list
 */

public class GetCommentByPostIdTests extends FetchComment{
	@BeforeMethod
	public void setUp() {
		FetchPost fp = new FetchPost();
		setURIAndPath("post/"+fp.getPostId()+"/comment");
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
	@Test(priority=1,dataProvider = "commentParam")
	public void testPaginationWithDataSetForForPostByTagTitle(int page,int limit) {
		System.out.println("-------------------Test with pages: "+page+" and limit: "+limit+"----------------------");
		getCommentList(page, limit);
		ResponseValidation.printOutputInJsonFormat(resp);
		ResponseValidation.validateStatusCode(resp, 200);
		ResponseValidation.validateReturnedJSONSchema(resp, "src/test/resources/commentByPostIdSchema.json");
	}
	
	@Test(priority=2)
	public void testDefaultPaginationForPostByTagTitle() {
		System.out.println("-------------------Test without pages and limit----------------------");
		getCommentList();
		ResponseValidation.printOutputInJsonFormat(resp);
		ResponseValidation.validateStatusCode(resp, 200);
		ResponseValidation.validateReturnedJSONSchema(resp, "src/test/resources/commentByPostIdSchema.json");
	}
}
