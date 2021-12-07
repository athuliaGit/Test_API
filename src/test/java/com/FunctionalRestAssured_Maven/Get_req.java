package com.FunctionalRestAssured_Maven;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get_req {
	Response resp;

	@BeforeMethod
	public void get_req() {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		RequestSpecification rSpec = RestAssured.given();

		rSpec.headers("User-Agent", "PostmanRuntime/7.28.4");
		rSpec.contentType(ContentType.JSON);
		// Response Object

		resp = rSpec.get("/posts/1");
	
	}

	@Test
	public void ValidateContent_type() {
		String expected_content_type = "application/json; charset=utf-8";
		String Actual_content_type = resp.getContentType();
		if (Actual_content_type.contentEquals(expected_content_type)) {
			Reporter.log("Assertion passed . Expected Content_type " + expected_content_type
					+ "does match with but Actual Result " + Actual_content_type);
		} else {
			Assert.fail("Assertion is failed. Expected Content_type " + expected_content_type
					+ "doesnt match with but Actual Result " + Actual_content_type);

		}

	}

	@Test
	public void Validate_StatusCode() {
		int Expected_StatusCode = 200;
		int Actual_StatusCode = resp.getStatusCode();
		if (Expected_StatusCode == Actual_StatusCode) {
			Reporter.log("Assertion passed . Expected StatusCode " + Expected_StatusCode
					+ "does match with but Actual Result " + Actual_StatusCode);
		} else {
			Assert.fail("Assertion is failed. Expected StatusCode " + Expected_StatusCode
					+ "doesnt match with but Actual Result " + Actual_StatusCode);
		}

	}

	@Test
	public void Validate_StatusLine() {
		String Expected_StatusLine = "HTTP/1.1 200 OK";
		String Actual_StatusLine = resp.getStatusLine();
		if (Actual_StatusLine.contentEquals(Expected_StatusLine)) {
			Reporter.log("Assertion passed . Expected StatusLine " + Expected_StatusLine
					+ "does match with but Actual Result " + Actual_StatusLine);
		} else {
			Assert.fail("Assertion is failed. Expected StatusLine" + Expected_StatusLine
					+ "doesnt match with but Actual Result " + Actual_StatusLine);
		}

	}
	
	@Test
	public void Validate_ResponseBody() {
		//Validating response id
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

	}

}
