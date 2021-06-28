package com.dummyapi.tag;

import java.util.Random;

import org.testng.annotations.DataProvider;

import com.dummyapi.base.BaseSetUp;

import io.restassured.RestAssured;

public class FetchTag extends BaseSetUp{

	public void getTagList(int page,int limit) {	
		resp = RestAssured.given().relaxedHTTPSValidation().
				header(getHeader()).
				queryParams(setQueryParams(page, limit)).
				when().log().all().get();	
	}	
	
	public void getTagList() {	
		resp = RestAssured.given().relaxedHTTPSValidation().
				header(getHeader()).
				when().log().all().get();	
	}
	
	/**
	 * To pass different set of data in terms of pages and limit
	 */
	@DataProvider
	public Object[][] tagParam(){
		Object[][] data = {{0,5},{1,8},{2,5},{3,12},{10,5}};
		return data;
	}
	
	@DataProvider
	public Object[][] tagTagTitlePostParam(){
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
