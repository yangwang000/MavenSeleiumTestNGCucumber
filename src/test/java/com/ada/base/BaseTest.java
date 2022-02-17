package com.ada.base;

import com.ada.factory.DriverManager;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
	private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	private void setDriver(WebDriver driver){
		this.driver.set(driver);
	}

	protected WebDriver getDriver(){
		return this.driver.get();
	}

	@Parameters("browser")
	@BeforeMethod
	public void startDriver(@Optional String browser){
		if(browser == null)
			browser = "CHROME";
		setDriver(new DriverManager().initializeDriver(browser));
		System.out.println("CURRENT THREAD : " + Thread.currentThread().getId());
	}

	@AfterMethod
	public void quitDriver(){
		getDriver().quit();
	}
}
