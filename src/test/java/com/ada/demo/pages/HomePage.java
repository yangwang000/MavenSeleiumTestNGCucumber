package com.ada.demo.pages;

import com.ada.demo.base.BasePage;
import com.ada.demo.pages.components.MyHeader;
import com.ada.demo.pages.components.ProductThumbnail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
	private MyHeader myHeader;
	private ProductThumbnail productThumbnail;

	public MyHeader getMyHeader() {
		return myHeader;
	}

	public ProductThumbnail getProductThumbnail() {
		return productThumbnail;
	}
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
