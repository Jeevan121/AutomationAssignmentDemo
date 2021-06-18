package com.assignmentsdemo.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.assignmentsdemo.autoconstants.AutoConfigs;
import com.assignmentsdemo.pages.AllMovieHomePage;
import com.assignmentsdemo.pages.AllMovieSearchPage;
import com.assignmentsdemo.pages.MoviePage;
import com.assignmentsdemo.utils.BaseTest;
import com.assignmentsdemo.utils.RestAssuredUtils;

import io.restassured.response.Response;

public class AllMovieTest extends BaseTest{
	
	AllMovieHomePage allMovieHomePage;
	AllMovieSearchPage allMovieSearchPage;
	MoviePage moviePage;
	RestAssuredUtils restAssuredUtils;
	
	@BeforeTest
	public void setUp() {
		
		launchApplication(AutoConfigs.allMovieUrl);
		allMovieHomePage=PageFactory.initElements(getDriver(), AllMovieHomePage.class);
		allMovieSearchPage=PageFactory.initElements(getDriver(), AllMovieSearchPage.class);
		moviePage = PageFactory.initElements(getDriver(), MoviePage.class);
	}
	
	@Test
	public void allMovieTest() throws InterruptedException {
		
		RestAssuredAPITest obj = new RestAssuredAPITest();
		
		String testInputData = obj.getID();
		
		///=======================================================================
		allMovieHomePage.enterMovieNameIntoSearchBox(testInputData);
		
		//allMovieHomePage.enterMovieNameIntoSearchBox("The Godfather");
		String movieResultCount = allMovieSearchPage.getMovieResultTypeCount();
		System.out.println("The Retrieved Count is ::"+movieResultCount);
		allMovieSearchPage.clickFirtsMovieLnk();
		moviePage.clickOnCastAndCrewTab();
		
		String movieGenresType = moviePage.getMovieGenresType();
		System.out.println("the movie genres type is::"+movieGenresType);
		Assert.assertEquals(movieGenresType, "Crime","movie genres type is not matching");
		
		
		String mpaaRatingType = moviePage.getmpaaRatingType();
		System.out.println("the mpaaRating type is::"+mpaaRatingType);
		Assert.assertEquals(mpaaRatingType.trim().toString(), "R","MPAA Rating type is not matching");
		
		String directorName = moviePage.getDirectorName();
		System.out.println("the director name is::"+directorName);
		Assert.assertEquals(directorName, "Francis Ford Coppola","Director Name is not matching");
		
	}
	
	@AfterTest
	public void quiteDriver() {
		getDriver().quit();
	}
	

}
