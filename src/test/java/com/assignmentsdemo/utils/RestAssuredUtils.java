package com.assignmentsdemo.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredUtils {
	
	public Response restAPIPost(String url) {
		 
	    Response response = null;
	    final RequestSpecification httpRequest = RestAssured.given();
	    httpRequest.header("Content-Type", "application/json");
	    
	    try {
	      response = httpRequest.post(url);

	      if (response.statusCode() == 201) {
	        System.out.println("Passed : HTTP Status code : " + response.statusCode());
	      }
	      System.out.println("Response JSON Output is===>> " + response.asString());
	    } catch (final Exception e) {
	      // TODO Auto-generated catch block
	      throw new RuntimeException("Failed : HTTP error code : " + response.statusCode());
	    }
	    return response;
	  }

}
