package com.dummyapi.user;

import java.util.Random;

import org.testng.annotations.DataProvider;

import com.dummyapi.base.BaseSetUp;

import io.restassured.RestAssured;

public class FetchUser extends BaseSetUp{

	public void getUserList(int page,int limit) {	
		resp = RestAssured.given().relaxedHTTPSValidation().
				header(getHeader()).
				queryParams(setQueryParams(page, limit)).
				when().log().all().get();	
	}	
	
	public void getUserList() {	
		resp = RestAssured.given().relaxedHTTPSValidation().
				header(getHeader()).
				when().log().all().get();	
	}
	
	/**
	 * To pass different set of data in terms of pages and limit
	 */
	@DataProvider
	public Object[][] parameters(){
		Object[][] data = {{0,0},{1,5},{1,50},{5,10},{7,12},{10,9},{10,10}};
		return data;
	}
	
	public String getUserId(){
		Random rand = new Random();
		int num = rand.nextInt(20);
		String data = RestAssured.given().relaxedHTTPSValidation().
				header(getHeader()).
				when().get("https://dummyapi.io/data/api/user").jsonPath().getString("data["+num+"].id");
		return data;
	}
}
