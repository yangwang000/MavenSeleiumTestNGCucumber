package com.ada.demo.tests.Demo;

import com.ada.demo.base.BasePage;
import com.ada.demo.pages.components.MyHeader;
import com.ada.demo.pages.components.ProductThumbnail;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public MyHeader getMyHeader() {
        return myHeader;
    }

    public ProductThumbnail getProductThumbnail() {
        return productThumbnail;
    }

    private MyHeader myHeader;
    private ProductThumbnail productThumbnail;

    public HomePage(WebDriver driver) {
        super(driver);
        myHeader = new MyHeader(driver);
        productThumbnail = new ProductThumbnail(driver);
    }

    public HomePage load(){
        load("/");
        return this;
    }
}
