package com.ada.tests.WebdriverDemo;

import java.io.*;
import java.util.Date;
import java.util.StringTokenizer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Cookie;

public class CookieHandlerDemo {

    public static void main(String[] args){
        readCookie();
        /*
        System.setProperty("webdriver.chrome.driver","/Users/yangwang/Documents/Utils/chromedriver");
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("http://www.example.com");

            // Adds the cookie into current browser context
            driver.manage().addCookie(new Cookie("key", "value"));
        } finally {
            driver.quit();
        }
        */
    }

    public static void writeCookie(String[] args)
    {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver","/Users/yangwang/Documents/Utils/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/test/cookie/selenium_aut.php");


        // Input Email id and Password If you are already Register
        driver.findElement(By.name("username")).sendKeys("abc123");
        driver.findElement(By.name("password")).sendKeys("123xyz");
        driver.findElement(By.name("submit")).click();

        // create file named Cookies to store Login Information
        File file = new File("Cookies.data");
        try
        {
            // Delete old file if exists
            file.delete();
            file.createNewFile();
            FileWriter fileWrite = new FileWriter(file);
            BufferedWriter Bwrite = new BufferedWriter(fileWrite);
            // loop for getting the cookie information

            // loop for getting the cookie information
            for(Cookie ck : driver.manage().getCookies())
            {
                Bwrite.write((ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure()));
                Bwrite.newLine();
            }
            Bwrite.close();
            fileWrite.close();

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public static void readCookie(){
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver","/Users/yangwang/Documents/Utils/chromedriver");
        driver=new ChromeDriver();
        driver.get("http://demo.guru99.com/");
        try{

            File file = new File("Cookies.data");
            FileReader fileReader = new FileReader(file);
            BufferedReader Buffreader = new BufferedReader(fileReader);
            String strline;
            while((strline=Buffreader.readLine())!=null){
                StringTokenizer token = new StringTokenizer(strline,";");
                while(token.hasMoreTokens()){
                    String name = token.nextToken();
                    String value = token.nextToken();
                    String domain = token.nextToken();
                    String path = token.nextToken();
                    Date expiry = null;

                    String val;
                    if(!(val=token.nextToken()).equals("null"))
                    {
                        expiry = new Date(val);
                    }
                    Boolean isSecure = new Boolean(token.nextToken()).
                            booleanValue();
                    Cookie ck = new Cookie(name,value,domain,path,expiry,isSecure);
                    System.out.println(ck);
                    driver.manage().addCookie(ck); // This will add the stored cookie to your current session
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        driver.get("http://demo.guru99.com/test/cookie/selenium_aut.php");
    }
}