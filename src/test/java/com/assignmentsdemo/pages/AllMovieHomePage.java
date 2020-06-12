package com.assignmentsdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.assignmentsdemo.utils.BasePage;

public class AllMovieHomePage extends BasePage{
	
	WebDriver driver;
	
	public AllMovieHomePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	By searchTxt = By.xpath("//input[@class='site-search-input']");
	
	By searchBtn = By.xpath("//input[@class='site-search-button']");
	
	public void enterMovieNameIntoSearchBox(String data) throws InterruptedException {
		safeTypeAndPressTAB(searchTxt, data);
		safeClick(searchBtn);
	}
	
	

}
