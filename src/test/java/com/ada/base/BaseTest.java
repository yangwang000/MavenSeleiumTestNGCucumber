package com.ada.base;

import com.ada.factory.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
	protected WebDriver driver;

	@Parameters("browser")
	@BeforeMethod
	public void startDriver(String browser){
		driver = new DriverManager().initializeDriver(browser);
	}

	@AfterMethod
	public void quitDriver(){
		driver.quit();
	}
}
