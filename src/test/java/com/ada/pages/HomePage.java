package com.ada.pages;

import com.ada.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
	private final By storeMenuLink = By.cssSelector("#menu-item-1227 > a");

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public StorePage navigateToStoreUsingMenue(){
		driver.findElement(storeMenuLink).click();
		return new StorePage(driver);
	}

	public HomePage load(){
		load("/");
		return this;
	}
}
