package com.ada.tests.WebdriverDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

public class ClickDemo {
	@Test
	public void doubleClick() throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "/Users/yangwang/Documents/Utils/chromedriver");
		driver= new ChromeDriver();
		driver.get("http://demo.guru99.com/test/simple_context_menu.html");
		driver.manage().window().maximize();

		Actions action = new Actions(driver);
		WebElement link =driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
		action.doubleClick(link).perform();
		//Switch to the alert box and click on OK button
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert Text\n" +alert.getText());
		alert.accept();
		//driver.quit();
	}

	@Test
	public void rightClick() throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "/Users/yangwang/Documents/Utils/chromedriver");
		driver= new ChromeDriver();
		driver.get("http://demo.guru99.com/test/simple_context_menu.html");
		driver.manage().window().maximize();

		Actions action = new Actions(driver);
		WebElement link = driver.findElement(By.cssSelector(".context-menu-one"));
		action.contextClick(link).perform();
		WebElement element = driver.findElement(By.cssSelector(".context-menu-icon-copy"));
		element.click();
		//driver.switchTo().alert().accept();
		//driver.quit();
	}
}
