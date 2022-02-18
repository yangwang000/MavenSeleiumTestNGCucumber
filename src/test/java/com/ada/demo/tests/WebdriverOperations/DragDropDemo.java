package com.ada.demo.tests.WebdriverOperations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDropDemo {
    WebDriver driver;

//    @Test
    public void DragDropByElement()
    {
        System.setProperty("webdriver.chrome.driver", "/Users/yangwang/Documents/Utils/chromedriver");
        driver= new ChromeDriver();
        driver.get("http://demo.guru99.com/test/drag_drop.html");

        //Element which needs to drag.
        WebElement fromElement=driver.findElement(By.xpath("//*[@id='credit2']/a"));
        //Element on which need to drop.
        WebElement toElement=driver.findElement(By.xpath("//*[@id='bank']/li"));

        //Using Action class for drag and drop.
        Actions act=new Actions(driver);
        //Dragged and dropped.
        act.dragAndDrop(fromElement, toElement).build().perform();
    }

//    @Test
    public void DragDropByPixel()
    {
        System.setProperty("webdriver.chrome.driver", "/Users/yangwang/Documents/Utils/chromedriver");
        driver= new ChromeDriver();
        driver.get("http://demo.guru99.com/test/drag_drop.html");

        //Element(BANK) which need to drag.
        WebElement fromElement=driver.findElement(By.xpath("//*[@id='credit2']/a"));

        //Using Action class for drag and drop.
        Actions act=new Actions(driver);

        //Drag and Drop by Pixel.
        act.dragAndDropBy(fromElement,135, 40).build().perform();
    }

//    @Test
    public void DragDropVerify()
    {
        System.setProperty("webdriver.chrome.driver", "/Users/yangwang/Documents/Utils/chromedriver");
        driver= new ChromeDriver();
        driver.get("http://demo.guru99.com/test/drag_drop.html");

        //Element(BANK) which need to drag.
        WebElement bankElement=driver.findElement(By.xpath("//*[@id='credit2']/a"));
        //Element(DEBIT SIDE) on which need to drop.
        WebElement bankToElement=driver.findElement(By.xpath("//*[@id='bank']/li"));
        //Element(SALES) which need to drag.
        WebElement salesElement=driver.findElement(By.xpath("//*[@id='credit1']/a"));
        //Element(CREDIT SIDE) on which need to drop.
        WebElement salesToElement=driver.findElement(By.xpath("//*[@id='loan']/li"));
        //Element(500) which need to drag.
        WebElement numberElement=driver.findElement(By.xpath("//*[@id='fourth']/a"));
        //Element(DEBIT SIDE) on which need to drop.
        WebElement numberToElement=driver.findElement(By.xpath("//*[@id='amt7']/li"));
        //Element(500) which need to drag.
        WebElement numberElement2=driver.findElement(By.xpath("//*[@id='fourth']/a"));
        //Element(CREDIT SIDE) on which need to drop.
        WebElement numberElement2To=driver.findElement(By.xpath("//*[@id='amt8']/li"));
        //Using Action class for drag and drop.
        Actions act=new Actions(driver);
        //BANK drag and drop.
        act.dragAndDrop(bankElement, bankToElement).build().perform();
        //SALES drag and drop.
        act.dragAndDrop(salesElement, salesToElement).build().perform();
        //500 drag and drop debit side.
        act.dragAndDrop(numberElement, numberToElement).build().perform();
        //500 drag and drop credit side.
        act.dragAndDrop(numberElement2, numberElement2To).build().perform();

        //Verifying the Perfect! message.
        if(driver.findElement(By.xpath("//a[contains(text(),'Perfect')]")).isDisplayed())
        {
            System.out.println("Perfect Displayed !!!");
        }
        else
        {
            System.out.println("Perfect not Displayed !!!");
        }
    }
}