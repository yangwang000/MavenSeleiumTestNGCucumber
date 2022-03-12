package com.ada.demo.tests.Demo;

import com.ada.webDriverFactory.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

/*
*  These examples are from Selenium Document:
*  https://www.selenium.dev/documentation/
* */
public class SeleniumDocExamples {
	ChromeDriverManager cdm = new ChromeDriverManager();
	WebDriver driver = cdm.createDriver();

	@Test
	public void findElementsFromElement() {
		try {
			driver.get("https://example.com");

			// Get element with tag name 'div'
			WebElement element = driver.findElement(By.tagName("div"));

			// Get all the elements available with tag name 'p'
			List<WebElement> elements = element.findElements(By.tagName("p"));
			for (WebElement e : elements) {
				System.out.println(e.getText());
			}
		} finally {
			driver.quit();
		}
	}

	@Test
	public void activeElementTest(){
		try {
			driver.get("http://www.google.com");
			driver.findElement(By.cssSelector("[name='q']")).sendKeys("webElement");

			// Get attribute of current active element
			String attr = driver.switchTo().activeElement().getAttribute("title");
			System.out.println(attr);
		} finally {
			driver.quit();
		}
	}
}
