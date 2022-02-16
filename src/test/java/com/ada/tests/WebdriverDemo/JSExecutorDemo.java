package com.ada.tests.WebdriverDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JSExecutorDemo {

    @Test
    public void LoginAsync()
    {
        System.setProperty("webdriver.chrome.driver","/Users/yangwang/Documents/Utils/chromedriver");
        WebDriver driver= new ChromeDriver();
        //Creating the JavascriptExecutor interface object by Type casting
        JavascriptExecutor js = (JavascriptExecutor)driver;
        //Launching the Site.
        driver.get("http://demo.guru99.com/V4/");
        //Maximize window
        driver.manage().window().maximize();
        //Set the Script Timeout to 20 seconds
        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
        //Declare and set the start time
        long start_time = System.currentTimeMillis();
        //Call executeAsyncScript() method to wait for 5 seconds
        js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");
        //Get the difference (currentTime - startTime)  of times.
        System.out.println("Passed time: " + (System.currentTimeMillis() - start_time));
        driver.quit();
    }

    @Test
    public void LoginJSClick()
    {
        System.setProperty("webdriver.chrome.driver","/Users/yangwang/Documents/Utils/chromedriver");
        WebDriver driver= new ChromeDriver();

        //Creating the JavascriptExecutor interface object by Type casting
        JavascriptExecutor js = (JavascriptExecutor)driver;
        //Launching the Site.
        driver.get("http://demo.guru99.com/V4/");
        WebElement button =driver.findElement(By.name("btnLogin"));
        //Login to Guru99
        driver.findElement(By.name("uid")).sendKeys("mngr289215");
        driver.findElement(By.name("password")).sendKeys("gYterEt");

        //Perform Click on LOGIN button using JavascriptExecutor
        js.executeScript("arguments[0].click();", button);

        //To generate Alert window using JavascriptExecutor. Display the alert message
        js.executeScript("alert('Welcome to Guru99');");
    }

    @Test
    public void login()
    {
        System.setProperty("webdriver.chrome.driver","/Users/yangwang/Documents/Utils/chromedriver");
        WebDriver driver= new ChromeDriver();

        //Creating the JavascriptExecutor interface object by Type casting
        JavascriptExecutor js = (JavascriptExecutor)driver;

        //Launching the Site.
        driver.get("http://demo.guru99.com/V4/");

        //Fetching the Domain Name of the site. Tostring() change object to name.
        String DomainName = js.executeScript("return document.domain;").toString();
        System.out.println("Domain name of the site = "+DomainName);

        //Fetching the URL of the site. Tostring() change object to name
        String url = js.executeScript("return document.URL;").toString();
        System.out.println("URL of the site = "+url);

        //Method document.title fetch the Title name of the site. Tostring() change object to name
        String TitleName = js.executeScript("return document.title;").toString();
        System.out.println("Title of the page = "+TitleName);


        //Navigate to new Page i.e to generate access page. (launch new url)
        js.executeScript("window.location = 'http://demo.guru99.com/'");
    }

    @Test
    public void JSScroll()
    {
        System.setProperty("webdriver.chrome.driver","/Users/yangwang/Documents/Utils/chromedriver");
        WebDriver driver= new ChromeDriver();

        //Creating the JavascriptExecutor interface object by Type casting
        JavascriptExecutor js = (JavascriptExecutor)driver;

        //Launching the Site.
        driver.get("http://moneyboats.com/");

        //Maximize window
        driver.manage().window().maximize();

        //Vertical scroll down by 600  pixels
        js.executeScript("window.scrollBy(0,600)");
    }
}