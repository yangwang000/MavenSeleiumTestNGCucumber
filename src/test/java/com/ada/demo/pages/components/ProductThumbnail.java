package com.ada.demo.pages.components;

import com.ada.demo.base.BaseDemoPage;
import com.ada.demo.pages.CartDemoPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductThumbnail extends BaseDemoPage {
    private final By viewCartLink = By.cssSelector("a[title='View cart']");

    public ProductThumbnail(WebDriver driver) {
        super(driver);
    }

    private By getAddToCartBtnElement(String productName){
        return By.cssSelector("a[aria-label='Add “" + productName + "” to your cart']");
    }

    public ProductThumbnail clickAddToCartBtn(String productName){
        By addToCartBtn = getAddToCartBtnElement(productName);
        waitShort.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
        return this;
    }

    public CartDemoPage clickViewCart(){
        waitShort.until(ExpectedConditions.elementToBeClickable(viewCartLink)).click();
        return new CartDemoPage(driver);
    }
}
