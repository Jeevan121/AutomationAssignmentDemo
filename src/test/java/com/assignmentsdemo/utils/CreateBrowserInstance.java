package com.assignmentsdemo.utils;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateBrowserInstance {
	
WebDriver driver;
	
	public WebDriver launchBrowser(String url) {
		final String driverPath = System.getProperty("user.dir") + File.separator+"drivers"+File.separator+"chromedriver.exe";
	    System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	    return driver;
		
	}

}
