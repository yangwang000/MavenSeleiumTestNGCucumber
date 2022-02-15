package com.ada.pages;

import com.ada.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StorePage extends BasePage {
	private final By searchFld = By.cssSelector("#woocommerce-product-search-field-0");
	private final By searchBtn = By.cssSelector("button[value='Search']");
	private final By title = By.cssSelector(".woocommerce-products-header__title.page-title");
	private final By viewCartLink = By.cssSelector("a[title='View cart']");

	private By getAddToCartBtn(String productName){
		return By.cssSelector("a[aria-label='Add “" + productName + "” to your cart']");
	}

	public StorePage(WebDriver driver) {
		super(driver);
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

	public StorePage clickAddToCartBtn(String productName){
		By addToCartBtn = getAddToCartBtn(productName);
		WebElement addToCartBtnElement = driver.findElement(addToCartBtn);
		waitShort.until(
				ExpectedConditions.visibilityOf(addToCartBtnElement)
		);
		addToCartBtnElement.click();
		return this;
	}

	public CartPage clickViewCart(){
		WebElement viewCartLinkElement = driver.findElement(viewCartLink);
		waitShort.until(
				ExpectedConditions.visibilityOf(viewCartLinkElement)
		);
		viewCartLinkElement.click();
		return new CartPage(driver);
	}
}
