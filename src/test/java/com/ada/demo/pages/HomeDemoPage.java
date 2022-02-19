package com.ada.demo.pages;

import com.ada.demo.base.BaseDemoPage;
import com.ada.demo.pages.components.MyHeader;
import com.ada.demo.pages.components.ProductThumbnail;
import org.openqa.selenium.WebDriver;

public class HomeDemoPage extends BaseDemoPage {
	private MyHeader myHeader;
	private ProductThumbnail productThumbnail;

	public MyHeader getMyHeader() {
		return myHeader;
	}

	public ProductThumbnail getProductThumbnail() {
		return productThumbnail;
	}
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
