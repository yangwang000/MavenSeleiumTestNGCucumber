package com.ada.demo.pages.components;

import com.ada.base.BasePage;
import com.ada.demo.pages.StorePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyHeader extends BasePage {
    private final By storeMenuLink = By.cssSelector("#menu-item-1227 > a");

    public MyHeader(WebDriver driver) {
        super(driver);
    }

    public StorePage navigateToStoreUsingMenu(){
        waitLong.until(ExpectedConditions.elementToBeClickable(storeMenuLink)).click();
        return new StorePage(driver);
    }
}
