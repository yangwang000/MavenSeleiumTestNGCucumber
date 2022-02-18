package com.ada.demo.pages;

import com.ada.demo.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {
	private final By productName = By.cssSelector("td[class='product-name'] a");
	private final By checkoutBtn = By.cssSelector(".checkout-button");

	public CartPage(WebDriver driver) {
		super(driver);
	}

	public String getProductName(){
		return waitShort.until(ExpectedConditions.visibilityOfElementLocated(productName)).getText();
	}

	public CheckoutPage clickCheckoutBtn(){
		waitShort.until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();
		return new CheckoutPage(driver);
	}
}
