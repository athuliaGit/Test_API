package com.FunctionalRestAssured_Maven;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Patch_req {
	Response resp;
	
	@BeforeTest
	public void patch_posts_req() {
		
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		Map<String, Object> Map_param = new HashMap<>();
		Map_param.put("title", "Patch  title");
		

		JSONObject request_param = new JSONObject(Map_param);

		
		RequestSpecification rSpec=  RestAssured.given();
		rSpec.body(request_param.toJSONString());
		rSpec.headers("User-Agent", "PostmanRuntime/7.28.4");
		rSpec.contentType(ContentType.JSON);
		
		resp = rSpec.patch("/posts/1");
		
		
	}
	@Test
	public void ValidateContent_type() {
		String expected_content_type="application/json; charset=utf-8";
		String Actual_content_type=resp.getContentType();
		if(Actual_content_type.contentEquals(expected_content_type)) {
			Reporter.log("Assertion passed . Expected Content_type " + expected_content_type + "does match with but Actual Result "
					+ Actual_content_type);
		} else {
			Assert.fail("Assertion is failed. Expected Content_type " + expected_content_type + "doesnt match with but Actual Result "
					+ Actual_content_type);
		
	}
}
	
	@Test
	public void Validate_StatusCode() {
		int Expected_StatusCode=200;
		int Actual_StatusCode=resp.getStatusCode();
		if(Expected_StatusCode==Actual_StatusCode) {
			Reporter.log("Assertion passed . Expected StatusCode " + Expected_StatusCode + "does match with but Actual Result "
					+ Actual_StatusCode);
		} else {
			Assert.fail("Assertion is failed. Expected StatusCode " + Expected_StatusCode + "doesnt match with but Actual Result "
					+ Actual_StatusCode);}
		
		
	}
	@Test
	public void Validate_StatusLine() {
		String Expected_StatusLine="HTTP/1.1 200 OK";
		String Actual_StatusLine=resp.getStatusLine();
		if(Actual_StatusLine.contentEquals(Expected_StatusLine)) {
			Reporter.log("Assertion passed . Expected StatusLine " + Expected_StatusLine + "does match with but Actual Result "
					+ Actual_StatusLine);
		} else {
			Assert.fail("Assertion is failed. Expected StatusLine" + Expected_StatusLine + "doesnt match with but Actual Result "
					+ Actual_StatusLine);}
		
		
	}
	@Test
	public void Validate_ResponseBody() {
		// validating response id
				int expected_id = 1;
				int actual_id = resp.jsonPath().getInt("id");
				if (expected_id == actual_id) {
		          Reporter.log("Assertion is passed. Expected id " + expected_id + "does match with  Actual Result "+ actual_id );
				} else {
					Assert.fail("Assertion is failed. Expected id " + expected_id + "doesnt match with but Actual Result "
							+ actual_id);
				}
				
				// validating response userId
				int expected_userid = 1;
				int actual_userid = resp.jsonPath().getInt("userId");
				if (expected_userid == actual_userid) {
					Reporter.log("Assertion is passed. Expected userid " + expected_userid + "does match with  Actual Result "+ actual_userid );
				} else {
					Assert.fail("Assertion is failed. Expected id " + expected_userid + "doesnt match with but Actual Result "
							+ actual_userid);
				}
				// validating response title
				String expected_title = "Patch  title";

				String actual_title = resp.jsonPath().getString("title");
				if (expected_title.contentEquals(actual_title)) {
					Reporter.log("Assertion passed . Expected title " + expected_title + "does match with but Actual Result "
							+ actual_title);
				} else {
					Assert.fail("Assertion is failed. Expected title " + expected_title + "doesnt match with but Actual Result "
							+ actual_title);
				}
				
				
		      
	}
	
}
