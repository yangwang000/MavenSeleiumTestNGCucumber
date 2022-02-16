package com.ada.factory;

import com.ada.constants.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {
	public WebDriver initializeDriver(String browser){
		WebDriver driver;
//		browser = System.setProperty("browser", browser);
		switch (BrowserType.valueOf(browser)){
			case CHROME:
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case FIREFOX:
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			default:
				throw new IllegalStateException("Invalid browser name: "+browser);
		}
		driver.manage().window().maximize();
		return driver;
	}
}
