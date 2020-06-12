package com.assignmentsdemo.utils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseTest {
	
	WebDriver driver;
	
	BasePage basePage;

	public void launchApplication(String url) {
		
		driver = new CreateBrowserInstance().launchBrowser(url);
	}
	
	
	
	 public Response jsonClientPost(String url) {
		 
		    Response response = null;
		    final RequestSpecification httpRequest = RestAssured.given();
		    httpRequest.header("Content-Type", "application/json");
		    
		    try {
		      response = httpRequest.post(url);

		      if (response.statusCode() != 201) {
		        System.out.println("Failed : RestAssured error code : " + response.statusCode());
		      }
		      System.out.println("Response JSON Output is===>> " + response.asString());
		    } catch (final Exception e) {
		      // TODO Auto-generated catch block
		      throw new RuntimeException("Failed : HTTP error code : " + response.statusCode());
		    }
		    return response;
		  }
	
	public WebDriver getDriver() {
		return driver;
	}
	
	 public BasePage getBasePage() {
		    if (basePage == null) {
		      basePage = new BasePage(getDriver());
		    }
		    return basePage;
		  }
	 
	 public static void captureScreenshot(WebDriver driver, String screenshotname) {
		    try {
		      final String timestamp = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date());
		      final String timeStamp1 = (timestamp.replaceAll("/", "_")).replaceAll(":", "_").replace(" ", "_");
		      final TakesScreenshot screenshot = (TakesScreenshot) driver;
		      final File source = screenshot.getScreenshotAs(OutputType.FILE);
		      FileUtils.copyFile(source, new File("./Screenshots/" + screenshotname + timeStamp1 + ".png"));
		      System.out.println("Screenshot Taken");
		    } catch (final Exception excep) {
		      System.out.println("Throwing exception while taking screenshot" + excep.getMessage());
		    }
		  }
}
