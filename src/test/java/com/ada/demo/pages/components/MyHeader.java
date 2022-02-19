package com.ada.demo.pages.components;

import com.ada.demo.base.BaseDemoPage;
import com.ada.demo.pages.StoreDemoPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyHeader extends BaseDemoPage {
    private final By storeMenuLink = By.cssSelector("#menu-item-1227 > a");

    public MyHeader(WebDriver driver) {
        super(driver);
    }

    public StoreDemoPage navigateToStoreUsingMenu(){
        waitLong.until(ExpectedConditions.elementToBeClickable(storeMenuLink)).click();
        return new StoreDemoPage(driver);
    }
}
