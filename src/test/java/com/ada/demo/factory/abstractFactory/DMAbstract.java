package com.ada.demo.factory.abstractFactory;

import org.openqa.selenium.WebDriver;

public abstract class DMAbstract {
	protected WebDriver driver;

	protected abstract void startDriver();

	public void quitDriver(){
		if(driver != null){
			driver.quit();
			driver = null;
		}
	}

	public WebDriver getDriver(){
		if(driver == null)
			startDriver();
		return driver;
	}
}
