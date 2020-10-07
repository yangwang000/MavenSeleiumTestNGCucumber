package com.ada.WebdriverDemo;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class PhantomJSDemo {
    public static void main(String[] args) {
        System.setProperty("phantomjs.binary.path", "/Users/yangwang/Documents/Utils/phantomjs-2.1.1-macosx/bin/phantomjs");
        WebDriver driver = new PhantomJSDriver();
        driver.get("http://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Guru99");
        element.submit();
        System.out.println("Page title is: " + driver.getTitle());
        driver.quit();
    }
}
