package com.ada.demo.factory;

import com.ada.demo.constants.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManagerOriginal {
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
