package com.ada.demo.pages;

import com.ada.demo.base.BaseDemoPage;
import com.ada.demo.pages.components.ProductThumbnail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StoreDemoPage extends BaseDemoPage {
    private final By searchFld = By.id("woocommerce-product-search-field-0");
    private final By searchBtn = By.cssSelector("button[value='Search']");
    private final By title = By.cssSelector(".woocommerce-products-header__title.page-title");

    public ProductThumbnail getProductThumbnail() {
        return productThumbnail;
    }

    private ProductThumbnail productThumbnail;

    public StoreDemoPage(WebDriver driver) {
        super(driver);
        productThumbnail = new ProductThumbnail(driver);
    }

    private StoreDemoPage enterTextInSearchFld(String txt){
        waitLong.until(ExpectedConditions.visibilityOfElementLocated(searchFld)).sendKeys(txt);
        return this;
    }

    public StoreDemoPage load(){
        load("/store");
        return this;
    }

    public StoreDemoPage search(String txt){
        enterTextInSearchFld(txt).clickSearchBtn();
        return this;
    }

    private StoreDemoPage clickSearchBtn(){
        waitLong.until(ExpectedConditions.elementToBeClickable(searchBtn)).click();
        return this;
    }

    public String getTitle(){
        return waitLong.until(ExpectedConditions.visibilityOfElementLocated(title)).getText();
    }
}
