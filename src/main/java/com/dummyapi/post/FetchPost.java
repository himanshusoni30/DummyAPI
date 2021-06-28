package com.dummyapi.post;

import java.util.Random;

import org.testng.annotations.DataProvider;

import com.dummyapi.base.BaseSetUp;

import io.restassured.RestAssured;

public class FetchPost extends BaseSetUp{

	public void getPostList(int page,int limit) {	
		resp = RestAssured.given().relaxedHTTPSValidation().
				header(getHeader()).
				queryParams(setQueryParams(page, limit)).
				when().log().all().get();	
	}	
	
	public void getPostList() {	
		resp = RestAssured.given().relaxedHTTPSValidation().
				header(getHeader()).
				when().log().all().get();	
	}
	
	/**
	 * To pass different set of data in terms of pages and limit
	 */
	@DataProvider
	public Object[][] postParam(){
		Object[][] data = {{0,0},{1,50},{5,45},{15,30},{17,50},{18,50}};
		return data;
	}
	
	@DataProvider
	public Object[][] userCreatePostParam(){
		Object[][] data = {{0,0},{1,5},{2,7},{3,5}};
		return data;
	}
	
	@DataProvider
	public Object[][] postByTagTitleParam(){
		Object[][] data = {{0,0},{1,5},{0,10},{1,20}};
		return data;
	}
	
	public String getPostId(){
		Random rand = new Random();
		int num = rand.nextInt(20);
		String data = RestAssured.given().relaxedHTTPSValidation().
				header(getHeader()).
				when().get("https://dummyapi.io/data/api/post").jsonPath().getString("data["+num+"].id");
		return data;
	}
}
