package com.ada.tests.WebdriverDemo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class XpathDemo {

    @Test
    public void testSiblingAndParentInXpath() {
        WebDriver driver;
        String driverPath = "/Users/yangwang/Documents/Utils/chromedriver";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/test/guru99home/");

        List<WebElement> dateBox = driver.findElements(By.xpath("//h2[contains(text(),'A few of our most popular courses')]/parent::div//div[//a[text()='SELENIUM']]/following-sibling::div[@class='rt-grid-2 rt-omega']"));
        for (WebElement webElement : dateBox) {
            System.out.println(webElement.getText());
        }
        driver.close();
    }

    @Test
    public void testAncestorInXpath(){
        String driverPath = "/Users/yangwang/Documents/Utils/chromedriver";
        System.setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/test/guru99home/");

        List <WebElement> dateBox = driver.findElements(By.xpath("//div[.//a[text()='SELENIUM']]/ancestor::div[@class='rt-grid-2 rt-omega']/following-sibling::div"));
        for (WebElement webElement : dateBox) {
            System.out.println(webElement.getText());
        }
        driver.quit();
    }

    @Test
    public void testAndOrInXpath() {
        WebDriver driver;
        WebElement w,x;
        System.setProperty("webdriver.chrome.driver","/Users/yangwang/Documents/Utils/chromedriver");
        driver= new ChromeDriver();

        driver.get("http://demo.guru99.com/test/guru99home/");
        w=driver.findElement(By.xpath("//*[@type='submit' OR @name='btnReset']"));
        System.out.println(w.getText());
        x=driver.findElement(By.xpath("//input[@type='submit' and @name='btnLogin']"));
        System.out.println(x.getText());
        driver.quit();
    }

    @Test
    public void starsWith() {
        WebDriver driver;
        WebElement w;
        System.setProperty("webdriver.chrome.driver","/Users/yangwang/Documents/Utils/chromedriver");
        driver= new ChromeDriver();

        driver.get("http://demo.guru99.com/V4/");
        //Search the element by using starts-with
        //this meas find element with id starts with message, like "message1" "message2"
        w=driver.findElement(By.xpath("//label[starts-with(@id,'message')]"));
        System.out.println(w.getText());
        driver.quit();
    }

    @Test
    public void following() {
        WebDriver driver;
        WebElement w;
        System.setProperty("webdriver.chrome.driver","/Users/yangwang/Documents/Utils/chromedriver");
        driver= new ChromeDriver();

        // Launch the application
        driver.get("http://demo.guru99.com/V4/");
        //Search the element by using Following method
        w=driver.findElement(By.xpath("//*[@type='text']//following::input"));
        System.out.println(w.getText());
        driver.quit();
    }

    @Test
    public void preceding() {
        WebDriver driver;
        WebElement w;
        System.setProperty("webdriver.chrome.driver","/Users/yangwang/Documents/Utils/chromedriver");
        driver= new ChromeDriver();

        // Launch the application
        driver.get("http://demo.guru99.com/V4/");
        //Search the element by using preceding method
        w=driver.findElement(By.xpath("//*[@type='submit']//preceding::input"));
        System.out.println(w.getText());
        driver.quit();
    }

    @Test
    public void descendant() {
        WebDriver driver;
        WebElement w;
        System.setProperty("webdriver.chrome.driver","/Users/yangwang/Documents/Utils/chromedriver");
        driver= new ChromeDriver();

        // Launch the application
        driver.get("http://demo.guru99.com/test/guru99home/");

        //Search the element by using descendant method
        w=driver.findElement(By.xpath("//*[@id='rt-feature']//descendant::a"));
        //Print the searched element
        System.out.println(w.getText());
        //Close the browser
        driver.quit();
    }
}
