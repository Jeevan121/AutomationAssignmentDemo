package com.assignmentsdemo.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class BasePage {
	
	private WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public WebDriver getDriver() {
		return driver;
	}
	
	
	public void safeType(By locator, String value) {
		waitForElementToBeClickable(locator,40);
	    driver.findElement(locator).clear();
	    driver.findElement(locator).sendKeys(value);
	  }
	
	public void safeTypeAndPressTAB(By locator, String value) {
		waitForElementToBeClickable(locator,40);
	    driver.findElement(locator).clear();
	    driver.findElement(locator).sendKeys(value);
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    driver.findElement(locator).sendKeys(Keys.TAB);
	  }
	
	public void safeClick(By locator) {
	    try {
	      waitForElementToBeClickable(locator,40);
	      driver.findElement(locator).click();
	    } catch (final WebDriverException e) {
	      final Actions action = new Actions(driver);
	      action.moveToElement(driver.findElement(locator)).perform();
	      action.click().perform();
	    }
	  }
	
	public void pressTAB(By locator) throws InterruptedException {
		Thread.sleep(2000);
	   driver.findElement(locator).sendKeys(Keys.TAB);
	  }
	
	public void waitForElementToBeClickable(By by,int time) {
		 final WebDriverWait wait = new WebDriverWait(driver, time);
	      wait.until(ExpectedConditions.elementToBeClickable(by));
	}
	
	public void waitForElementPresent(By locator) {
	    final WebDriverWait wait = new WebDriverWait(driver, 120);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
  }

	public Actions getActions() {
	    return new Actions(this.driver);
	}
  
	public void log(String message) {
	    Reporter.log(message, true);
	}
	
	protected String getText(By locator) {
	    return driver.findElement(locator).getText();
	  }
}
