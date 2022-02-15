package com.ada.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {
	public WebDriver initializeDriver(){
		System.setProperty("webdriver.chrome.driver", "/Users/yangwang/Documents/Utils/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
}
