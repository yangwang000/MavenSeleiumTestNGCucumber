package com.ada.demo.pages;

import com.ada.demo.base.BasePage;
import com.ada.demo.pages.components.ProductThumbnail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StorePage extends BasePage {
	private final By searchFld = By.cssSelector("#woocommerce-product-search-field-0");
	private final By searchBtn = By.cssSelector("button[value='Search']");
	private final By title = By.cssSelector(".woocommerce-products-header__title.page-title");
	private ProductThumbnail productThumbnail;

	public ProductThumbnail getProductThumbnail() {
		return productThumbnail;
	}

	public StorePage(WebDriver driver) {
		super(driver);
		productThumbnail = new ProductThumbnail(driver);
	}

	public StorePage enterTextInSearchFld(String txt){
		WebElement searchFldElement = driver.findElement(searchFld);
		waitShort.until(
				ExpectedConditions.visibilityOf(searchFldElement)
		);
		searchFldElement.clear();
		searchFldElement.sendKeys(txt);
		return this;
	}

	public StorePage clickSearchBtn(){
		driver.findElement(searchBtn).click();
		return this;
	}

	public String getTitle(){
		return driver.findElement(title).getText();
	}

	public StorePage load(){
		load("/store");
		return this;
	}
}
