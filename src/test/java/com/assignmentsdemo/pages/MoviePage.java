package com.assignmentsdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.assignmentsdemo.utils.BasePage;

public class MoviePage extends BasePage {
	
	WebDriver driver;
	
	public MoviePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	By castAndCrewTab = By.xpath("//li[@class='tab cast-crew']/a");
	
	By moviGenresLnk = By.xpath("//span[@class='header-movie-genres']/a");
	
	By mpaaRating = By.xpath("//span[text()[contains(., 'MPAA Rating')]]");
	
	By directorNameLnk = By.xpath("//div[@class='director_container']//dt[@class='name artist-name']/a");
	
	
	
	
	
	public void clickOnCastAndCrewTab() {
		
		safeClick(castAndCrewTab);
		
	}
	
	public String getMovieGenresType() {
		waitForElementPresent(moviGenresLnk);
		String movieGenresType = getText(moviGenresLnk);
		return movieGenresType;
	}
	
	public String getmpaaRatingType() {
		waitForElementPresent(mpaaRating);
		String mpaaRatingType = getText(mpaaRating);
		String [] data = mpaaRatingType.split("-");
		return data[1];
	}
	
	public String getDirectorName() {
		waitForElementPresent(directorNameLnk);
		String directorName = getText(directorNameLnk);
		return directorName;
	}
	
	
	

}
