package com.dummyapi.common;

import java.io.File;

import com.dummyapi.base.BaseSetUp;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class ResponseValidation extends BaseSetUp{	
	public static void validateReturnedJSONSchema(Response resp, String fileName) {
		resp.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File(fileName)));
	}
	
	public static void validateStatusCode(Response resp, int statusCode) {
		resp.then().assertThat().statusCode(statusCode);
	}
	
	public static void printOutputInJsonFormat(Response resp) {
		System.out.println(resp.asPrettyString());
	}
}
