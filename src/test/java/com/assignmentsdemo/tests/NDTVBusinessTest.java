package com.assignmentsdemo.tests;
import java.util.List;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.assignmentsdemo.autoconstants.AutoConfigs;
import com.assignmentsdemo.utils.BaseTest;
import com.ndtv.pages.NDTVHomePage;

public class NDTVBusinessTest extends BaseTest{
	
	NDTVHomePage ndtvHomePage;

	@BeforeTest
	public void setUp() {
		
		launchApplication(AutoConfigs.ndtvBusinessAppUrl);
		ndtvHomePage=PageFactory.initElements(getDriver(), NDTVHomePage.class);
	}
	
	@Test
	public void allMovieTest() throws InterruptedException {
		
		Thread.sleep(6000);
		
		//Capurting ther screen of the nifty button which is adjacent to the adjacent to MARKET INDICATORS
		captureScreenshot(getDriver(),"nifty");
		
		//getting all the top stories and printing in the console
		List<String> topStoriesLst=ndtvHomePage.getTopStoriesText();
		for (String string : topStoriesLst) {
			System.out.println("the top stories::"+string);
		}

		String niftyColor= ndtvHomePage.getNiftyBtnColor();
		System.out.println("the color of the nifty is::"+niftyColor);
		Assert.assertTrue(niftyColor.contains("green"), "the color is not green");
		
	}
	
	@AfterTest
	public void quiteDriver() {
		getDriver().quit();
	}

}
