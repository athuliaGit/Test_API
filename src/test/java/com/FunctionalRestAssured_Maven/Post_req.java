package com.FunctionalRestAssured_Maven;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Post_req {
	Response resp ;
	
	@BeforeMethod
	public void creat_post1() {
        //request payload
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		Map<String, Object> Map_param = new HashMap<>();
		Map_param.put("title", "Fun");
		Map_param.put("body", "Body of the request");
		Map_param.put("userId", 2);

		JSONObject request_param = new JSONObject(Map_param);

		//Request Object
		RequestSpecification rSpec=  RestAssured.given();
		rSpec.body(request_param.toJSONString());
		rSpec.headers("User-Agent", "PostmanRuntime/7.28.4");
		rSpec.contentType(ContentType.JSON);
		//Response Object
		resp = rSpec.post("/posts");
		

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
		int Expected_StatusCode=201;
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
		String Expected_StatusLine="HTTP/1.1 201 Created";
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
				int expected_id = 101;
				int actual_id = resp.jsonPath().getInt("id");
				if (expected_id == actual_id) {
		          Reporter.log("Assertion is passed. Expected id " + expected_id + "does match with  Actual Result "+ actual_id );
				} else {
					Assert.fail("Assertion is failed. Expected id " + expected_id + "doesnt match with but Actual Result "
							+ actual_id);
				}
				
				// validating response userId
				int expected_userid = 2;
				int actual_userid = resp.jsonPath().getInt("userId");
				if (expected_userid == actual_userid) {
					Reporter.log("Assertion is passed. Expected userid " + expected_userid + "does match with  Actual Result "+ actual_userid );
				} else {
					Assert.fail("Assertion is failed. Expected userid " + expected_userid + "doesnt match with but Actual Result "
							+ actual_userid);
				}
				// validating response title
				String expected_title = "Fun";

				String actual_title = resp.jsonPath().getString("title");
				if (expected_title.contentEquals(actual_title)) {
					Reporter.log("Assertion passed . Expected title " + expected_title + "does match with but Actual Result "
							+ actual_title);
				} else {
					Assert.fail("Assertion is failed. Expected title " + expected_title + "doesnt match with but Actual Result "
							+ actual_title);
				}
				// validating response body
				String expected_body = "Body of the request";

				String actual_body = resp.jsonPath().getString("body");
				if (expected_body.contentEquals(actual_body)) {
		          Reporter.log("Assertion is failed. Expected  " + expected_body + "does match with but Actual Result "
		          		+ actual_body);
				} else {
					Assert.fail("Assertion is failed. Expected " + expected_body + " doesnt match with but Actual Result "
							+ actual_body);
				}
		      
	}
	
}
