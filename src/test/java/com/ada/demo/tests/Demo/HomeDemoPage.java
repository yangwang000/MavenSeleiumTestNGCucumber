package com.ada.demo.tests.Demo;

import com.ada.demo.base.BaseDemoPage;
import com.ada.demo.pages.components.MyHeader;
import com.ada.demo.pages.components.ProductThumbnail;
import org.openqa.selenium.WebDriver;

public class HomeDemoPage extends BaseDemoPage {
    public MyHeader getMyHeader() {
        return myHeader;
    }

    public ProductThumbnail getProductThumbnail() {
        return productThumbnail;
    }

    private MyHeader myHeader;
    private ProductThumbnail productThumbnail;

    public HomeDemoPage(WebDriver driver) {
        super(driver);
        myHeader = new MyHeader(driver);
        productThumbnail = new ProductThumbnail(driver);
    }

    public HomeDemoPage load(){
        load("/");
        return this;
    }
}
