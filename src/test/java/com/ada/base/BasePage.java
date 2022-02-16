package com.ada.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class BasePage {
	protected WebDriver driver;
	protected WebDriverWait waitLong;
	protected WebDriverWait waitShort;

	public BasePage(WebDriver driver){
		this.driver = driver;
		waitLong = new WebDriverWait(driver, 30);
		waitShort = new WebDriverWait(driver, 5);
	}

	public void load(String endPoint){
		driver.get("https://askomdch.com" + endPoint);
	}

	public void waitForOverlaysToDisappear(By overlay){
		List<WebElement> overlays = driver.findElements(overlay);
		System.out.println("OVERLAY SIZE" + overlays.size());
		if(overlays.size() > 0){
			waitShort.until(ExpectedConditions.invisibilityOfAllElements(overlays));
			System.out.println("OVERLAYS INVISIBLE");
		} else{
			System.out.println("OVERLAY NOT FOUND");
		}
	}

	public WebElement waitForElementToBeVisible(By element){
		return waitShort.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
}
