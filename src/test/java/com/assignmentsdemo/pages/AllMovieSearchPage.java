package com.assignmentsdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.assignmentsdemo.utils.BasePage;

public class AllMovieSearchPage extends BasePage{
	
	WebDriver driver;
	
	public AllMovieSearchPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	By firstSearchResultLnk = By.xpath("//div[text()[contains(., '1972')]]");
	
	By movieResultTypeFilterLnk = By.xpath("//h3[text()='Result Type']/..//li[@class='filter-movies']/a");
	
	public void clickFirtsMovieLnk() {
		
		safeClick(firstSearchResultLnk);
		
	}
	
	public String getMovieResultTypeCount() {
		waitForElementPresent(movieResultTypeFilterLnk);
		String movieResultTypeCount = getText(movieResultTypeFilterLnk);
		return movieResultTypeCount;
	}
	
	//div[@class='market-indicator-right']//a[contains(@href,'nifty')]
	
	//div[@class='market-indicator-right']//a[@class='bx-prev']

}
