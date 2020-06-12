package com.ndtv.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.assignmentsdemo.utils.BasePage;

public class NDTVHomePage extends BasePage{
	
	WebDriver driver;
	
	public NDTVHomePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	By topStoriesLnk = By.xpath("//div[@class='widcont_topstories']//a[@class='item-title']");
	
	
	

	
	public List<String> getTopStoriesText() {
		List<String> topHeadLinesLst= new ArrayList<String>();
		List<WebElement> topStoriesLst=getDriver().findElements(topStoriesLnk);
		for (WebElement webElement : topStoriesLst) {
			topHeadLinesLst.add(webElement.getText().toString().toString());
			
		}
		return topHeadLinesLst;
	}
	
	
	
	By nextBtn = By.xpath("//div[@class='market-indicator-right']//a[text()='next']");
	
	
	public String getNiftyBtnColor() {
		
		getDriver().switchTo().frame(1);
		
		List<WebElement> marketLst =getDriver().findElements(By.cssSelector("div[id*='header-data'] a h5"));
		
		String color = null;

		for (int i = 0; i < marketLst.size(); i++) {
			
			String mark = "return document.querySelectorAll(\"div[id*='header-data'] a h5\")["+i+"].innerText";
			
			JavascriptExecutor executor = (JavascriptExecutor) getDriver();
			final String markValue = executor.executeScript(mark).toString();
			
			System.out.println("==="+markValue);
			
			if (markValue.contains("NIFTY")) {
				
				By niftyBtnColor=By.xpath("(//div[@class='market-indicator-right']//div[@id='header-data']//a//h5[contains(text(),'NIFTY')])[1]/..//span/following-sibling::span");
				
				color=getDriver().findElement(niftyBtnColor).getAttribute("class");
				
				System.out.println(color);
				
				break;
			
			 }
			
			safeClick(nextBtn);
			
					
		}
		
		return color;
		
	}
	
}
