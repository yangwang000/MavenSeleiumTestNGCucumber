package com.ada.DataPropertiesOperation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.*;
import org.dom4j.*;
import org.dom4j.io.SAXReader;


public class PropertiesOperation {

    public static void main(String[] args){
        try {
            readXMLFile();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public static void readPropertiesFile() throws IOException {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "/Users/yangwang/Documents/Utils/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/test/guru99home/");
        driver.manage().window().maximize();

        Properties obj = new Properties();
        FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"/application.properties");
        obj.load(objfile);

        driver.findElement(By.xpath(obj.getProperty("MobileTesting"))).click();
        driver.navigate().back();
        driver.findElement(By.id(obj.getProperty("EmailTextBox"))).sendKeys("testguru99@gmail.com");
        driver.findElement(By.id(obj.getProperty("SignUpButton"))).click();
    }

    public static void readXMLFile() throws DocumentException {

        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "/Users/yangwang/Documents/Utils/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/test/guru99home/");
        driver.manage().window().maximize();
        // Reading XML File
        File inputFile = new File(System.getProperty("user.dir") +"/properties.xml");
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(inputFile);
        String mobileTesting = document.selectSingleNode("//menu/mobiletesting").getText();
        String emailTextBox = document.selectSingleNode("//menu/email").getText();
        String signUpButton = document.selectSingleNode("//menu/signup").getText();


        driver.findElement(By.xpath(mobileTesting)).click();
        driver.navigate().back();
        driver.findElement(By.id(emailTextBox)).sendKeys("testguru99@gmail.com");
        driver.findElement(By.id(signUpButton)).click();
    }
}