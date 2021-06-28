package com.dummyapi.tests.post;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dummyapi.common.ResponseValidation;
import com.dummyapi.post.FetchPost;
import com.dummyapi.tag.FetchTag;

/*
 * Get posts list by tag title
 */

public class GetPostByTagTitleTests extends FetchPost{
	
	@BeforeMethod
	public void setUp() {
		FetchTag ft = new FetchTag();
		setURIAndPath("tag/"+ft.getTagId()+"/post");
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
	@Test(priority=1,dataProvider = "postByTagTitleParam")
	public void testPaginationWithDataSetForPostByTagTitle(int page,int limit) {
		System.out.println("-------------------Test with pages: "+page+" and limit: "+limit+"----------------------");
		getPostList(page, limit);
		ResponseValidation.printOutputInJsonFormat(resp);
		ResponseValidation.validateStatusCode(resp, 200);
		ResponseValidation.validateReturnedJSONSchema(resp, "src/test/resources/postByTagTitleSchema.json");
	}
	
	@Test(priority=2)
	public void testDefaultPaginationForPostByTagTitle() {
		System.out.println("-------------------Test without pages and limit----------------------");
		getPostList();
		ResponseValidation.printOutputInJsonFormat(resp);
		ResponseValidation.validateStatusCode(resp, 200);
		ResponseValidation.validateReturnedJSONSchema(resp, "src/test/resources/postByTagTitleSchema.json");
	}
}
