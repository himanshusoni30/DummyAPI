package com.dummyapi.comment;

import java.util.Random;

import org.testng.annotations.DataProvider;

import com.dummyapi.base.BaseSetUp;

import io.restassured.RestAssured;

public class FetchComment extends BaseSetUp{

	public void getCommentList(int page,int limit) {	
		resp = RestAssured.given().relaxedHTTPSValidation().
				header(getHeader()).
				queryParams(setQueryParams(page, limit)).
				when().log().all().get();	
	}	
	
	public void getCommentList() {	
		resp = RestAssured.given().relaxedHTTPSValidation().
				header(getHeader()).
				when().log().all().get();	
	}
	
	@DataProvider
	public Object[][] commentParam(){
		Object[][] data = {{0,0},{1,5},{2,7},{3,5}};
		return data;
	}
	
	public String getTagId(){
		Random rand = new Random();
		int num = rand.nextInt(20);
		String data = RestAssured.given().relaxedHTTPSValidation().
				header(getHeader()).
				when().get("https://dummyapi.io/data/api/tag").jsonPath().getString("data["+num+"]");
		return data;
	}
}
