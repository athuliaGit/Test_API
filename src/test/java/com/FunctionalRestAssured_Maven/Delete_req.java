package com.FunctionalRestAssured_Maven;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Delete_req {
	Response resp;
@BeforeMethod
public void delete_post_req() {
	
    RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
	RequestSpecification rSpec = RestAssured.given();

	rSpec.headers("User-Agent", "PostmanRuntime/7.28.4");
	rSpec.contentType(ContentType.JSON);
	// Response Object

	resp = rSpec.delete("/posts/1");

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
	
}
