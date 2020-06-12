package com.assignmentsdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.assignmentsdemo.utils.BasePage;

public class CastAndCrewPage extends BasePage{
	
	//div[@class='director_container']//dt[@class='name artist-name']/a
	
WebDriver driver;
	
	public CastAndCrewPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	By castAndCrewTab = By.xpath("//li[@class='tab cast-crew']/a");
	
	By moviGenresLnk = By.xpath("//span[@class='header-movie-genres']/a");
	
	By mpaaRating = By.xpath("//span[text()[contains(., 'MPAA Rating')]]");
	
	
	
	
	public void clickOnCastAndCrewTab() {
		
		safeClick(castAndCrewTab);
		
	}
	
	public String getMovieGenresType() {
		waitForElementPresent(moviGenresLnk);
		String movieGenresType = getText(moviGenresLnk);
		return movieGenresType;
	}

}
