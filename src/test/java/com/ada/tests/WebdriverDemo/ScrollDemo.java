package com.ada.tests.WebdriverDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ScrollDemo {
    WebDriver driver;

    @Test
    public void ByPixel() {
        System.setProperty("webdriver.chrome.driver", "/Users/yangwang/Documents/Utils/chromedriver");
        driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("http://demo.guru99.com/test/guru99home/");
        driver.manage().window().maximize();
        // This  will scroll down the page by  1000 pixel vertical
        js.executeScript("window.scrollBy(0,1000)");
    }
    @Test
    public void ByVisibleElement() {
        System.setProperty("webdriver.chrome.driver", "/Users/yangwang/Documents/Utils/chromedriver");
        driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("http://demo.guru99.com/test/guru99home/");
        WebElement Element = driver.findElement(By.linkText("Linux"));
        //This will scroll the page till the element is found
        js.executeScript("arguments[0].scrollIntoView();", Element);
    }
    @Test
    public void ByPage() {
        System.setProperty("webdriver.chrome.driver", "/Users/yangwang/Documents/Utils/chromedriver");
        driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("http://demo.guru99.com/test/guru99home/");
        //This will scroll the web page till end.
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
    @Test
    public void ScrollHorizontally() {
        System.setProperty("webdriver.chrome.driver", "/Users/yangwang/Documents/Utils/chromedriver");
        driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("http://demo.guru99.com/test/guru99home/scrolling.html");
        WebElement Element = driver.findElement(By.linkText("VBScript"));
        //This will scroll the page Horizontally till the element is found
        js.executeScript("arguments[0].scrollIntoView();", Element);
    }
}
