package com.assignmentsdemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.assignmentsdemo.autoconstants.AutoConfigs;
import com.assignmentsdemo.utils.RestAssuredUtils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RestAssuredAPITest {
	
	//RestAssuredUtils restAssuredUtils;
	
	/*
	 * @Test public void restAssuredAPITest() { restAssuredUtils = new
	 * RestAssuredUtils(); Response res =
	 * restAssuredUtils.restAPIPost(AutoConfigs.uri+AutoConfigs.endPoint+"?"+
	 * AutoConfigs.queryParam); int statusCode = res.getStatusCode();
	 * Assert.assertEquals(statusCode,
	 * 201,"the status code is not matching as expected");
	 * 
	 * }
	 */
	
	/*
	 * public static void main(String[] args) { RestAssuredUtils restAssuredUtils =
	 * new RestAssuredUtils(); Response res =
	 * restAssuredUtils.restAPIPost(AutoConfigs.uri+AutoConfigs.endPoint+"?"+
	 * AutoConfigs.queryParam); int statusCode = res.getStatusCode();
	 * System.out.println("the status code is ::"+statusCode); JsonPath jp =
	 * res.jsonPath(); String id = jp.getString("id");
	 * System.out.println("the id retrive from res::"+id);
	 * 
	 * }
	 */
	
	public String getID() {
		
		RestAssuredUtils restAssuredUtils = new RestAssuredUtils();
		Response res = restAssuredUtils.restAPIPost(AutoConfigs.uri+AutoConfigs.endPoint+"?"+AutoConfigs.queryParam);
		int statusCode = res.getStatusCode();
		System.out.println("the status code is ::"+statusCode);
		JsonPath jp =  res.jsonPath();
		String id = jp.getString("id");
		System.out.println("the id retrive from res::"+id);
		return id;
	}

}
