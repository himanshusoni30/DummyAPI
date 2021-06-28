package com.dummyapi.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseSetUp {
	public Response resp;
	public RequestSpecification rs;
	
	protected Properties prop;

	public BaseSetUp() {
		try {
			prop = System.getProperties();
			prop.load(new FileInputStream(new File("src/test/resources/config.properties")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setBaseURI() {
		RestAssured.baseURI = prop.getProperty("baseURI");
	}

	public Header getHeader() {
		Header header = new Header("app-id", prop.getProperty("api_id"));
		return header;
	}

	public String setBasePath(String path) {
		return RestAssured.basePath = path;
	}

	public HashMap<String, Integer> setQueryParams(int pages, int limit) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("page", pages);
		map.put("limit", limit);
		return map;
	}

	public void setURIAndPath(String path) {
		setBaseURI();
		setBasePath(path);
	}
}
