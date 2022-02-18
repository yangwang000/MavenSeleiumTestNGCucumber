package com.ada.demo.utils.TestScreenshot;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import java.awt.image.BufferedImage;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class TakeScreenshotAshotAPI {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","/Users/yangwang/Documents/Utils/chromedriver");
        WebDriver driver  = new ChromeDriver();

        try {
            ImageComaprison(driver);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void FullpageScreenshot(WebDriver driver) throws IOException {
        driver.get("http://demo.guru99.com/test/guru99home/");
        driver.manage().window().maximize();
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        ImageIO.write(screenshot.getImage(), "jpg", new File("/Users/yangwang/IdeaProjects/MavenSeleiumTestNG/target/screenshots/FullpageScreenshot.jpg"));
        driver.quit();
    }

    public static void ElementScreenshot(WebDriver driver) throws IOException{
        driver.get("http://demo.guru99.com/test/guru99home/");
        driver.manage().window().maximize();
        // Find the element to take a screenshot
        WebElement element = driver.findElement(By.xpath ("//*[@id=\"site-name\"]/a[1]/img"));
        // Along with driver pass element also in takeScreenshot() method.
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver,element);
        ImageIO.write(screenshot.getImage(), "jpg", new File("/Users/yangwang/IdeaProjects/MavenSeleiumTestNG/target/screenshots/ElementScreenshot.jpg"));
        driver.quit();
    }

    public static void ImageComaprison(WebDriver driver) throws IOException{
        driver.get("http://demo.guru99.com/test/guru99home/");
        // Find the element and take a screenshot
        WebElement logoElement = driver.findElement(By.xpath("//*[@id=\"site-name\"]/a[1]/img"));
        Screenshot logoElementScreenshot = new AShot().takeScreenshot(driver, logoElement);
        // read the image to compare
        BufferedImage expectedImage = ImageIO.read(new File("/Users/yangwang/IdeaProjects/MavenSeleiumTestNG/target/screenshots/ElementScreenshot.jpg"));
        BufferedImage actualImage = logoElementScreenshot.getImage();
        // Create ImageDiffer object and call method makeDiff()
        ImageDiffer imgDiff = new ImageDiffer();
        ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
        if (diff.hasDiff() == true) {
            System.out.println("Images are same");
        } else {
            System.out.println("Images are different");
        }
        driver.quit();
    }
}