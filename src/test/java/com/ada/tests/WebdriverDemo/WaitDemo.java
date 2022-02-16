package com.ada.tests.WebdriverDemo;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.util.function.Function;


public class WaitDemo {

    protected WebDriver driver;
    @Test
    public void implicitWait() throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver", "/Users/yangwang/Documents/Utils/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
        String eTitle = "Demo Guru99 Page";
        String aTitle = "" ;
        driver.get("http://demo.guru99.com/test/guru99home/" );
        driver.manage().window().maximize() ;
        aTitle = driver.getTitle();
        if (aTitle.equals(eTitle))
        {
            System.out.println( "Test Passed") ;
        }
        else {
            System.out.println( "Test Failed" );
        }
        driver.close();
    }
    @Test
    public void explicitWait() throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver", "/Users/yangwang/Documents/Utils/chromedriver");
        driver = new ChromeDriver();
        WebDriverWait wait=new WebDriverWait(driver, 20);
        String eTitle = "Demo Guru99 Page";
        String aTitle = "" ;
        driver.get("http://demo.guru99.com/test/guru99home/" );
        driver.manage().window().maximize() ;
        aTitle = driver.getTitle();
        //compare the actual title with the expected title
        if (aTitle.contentEquals(eTitle))
        {
            System.out.println( "Test Passed") ;
        }
        else {
            System.out.println( "Test Failed" );
        }
        WebElement guru99seleniumlink;
        guru99seleniumlink= wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath(
                        "/html/body/div[1]/section/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/div/a/i")));
        guru99seleniumlink.click();
    }

    @Test
    public void fluentWait() throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver", "/Users/yangwang/Documents/Utils/chromedriver");
        String eTitle = "Demo Guru99 Page";
        String aTitle = "" ;
        driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/test/guru99home/" );
        driver.manage().window().maximize() ;
        aTitle = driver.getTitle();
        if (aTitle.contentEquals(eTitle))
        {
            System.out.println( "Test Passed") ;
        }
        else {
            System.out.println( "Test Failed" );
        }

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        WebElement clickseleniumlink = wait.until(new Function<WebDriver, WebElement>(){
            public WebElement apply(WebDriver driver ) {
                return driver.findElement(By.xpath(
                        "/html/body/div[1]/section/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/div/a/i"));
            }
        });
        clickseleniumlink.click();
        driver.close() ;
    }
}