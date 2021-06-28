package com.dummyapi.tests.post;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dummyapi.common.ResponseValidation;
import com.dummyapi.post.FetchPost;
import com.dummyapi.user.FetchUser;

/*
 * Get posts list created by user
 */

public class GetPostsListCreatedByUserTests extends FetchPost{
	public String USER_ID;
	
	@BeforeMethod
	public void setUp() {
		FetchUser fud = new FetchUser();
		USER_ID=fud.getUserId();
		setURIAndPath("user/"+USER_ID+"/post");
		System.out.println("========================== Test Starts ===================================");
	}
	
	@Test(priority=1)
	public void testPostListCreatedByUser() {
		
		System.out.println("-------------------Test with UserId: "+USER_ID+"----------------------");
		getPostList();
		ResponseValidation.printOutputInJsonFormat(resp);
		ResponseValidation.validateStatusCode(resp, 200);
		ResponseValidation.validateReturnedJSONSchema(resp, "src/test/resources/postsCreatedByUser.json");
	}
	
	@Test(priority=2,dataProvider="userCreatePostParam")
	public void testPostListCreatedByUserWithPagination(int page,int limit) {
		System.out.println("-------------------Test with pages: "+page+" and limit: "+limit+"----------------------");
		getPostList(page, limit);
		ResponseValidation.printOutputInJsonFormat(resp);
		ResponseValidation.validateStatusCode(resp, 200);
		ResponseValidation.validateReturnedJSONSchema(resp, "src/test/resources/postsCreatedByUser.json");
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("========================== Test Ends ===================================");
	}

}
