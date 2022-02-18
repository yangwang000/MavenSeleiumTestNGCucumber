package com.ada.demo.base;

import com.ada.demo.constants.BrowserType;
import com.ada.demo.factory.abstractFactory.DMAbstract;
import com.ada.demo.factory.abstractFactory.DMFactoryAbstract;
import com.ada.demo.utils.CookiesUtil;
import io.restassured.http.Cookies;
import org.apache.commons.io.FileUtils;
import org.apache.commons.net.ntp.TimeStamp;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.sql.Timestamp;

public class BaseTest {
	private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	private void setDriver(WebDriver driver){
		this.driver.set(driver);
	}
	protected WebDriver getDriver(){
		return this.driver.get();
	}

	private ThreadLocal<DMAbstract> driverManager = new ThreadLocal<>();
	private void setDriverManager(DMAbstract driverManager) {this.driverManager.set(driverManager);}
	protected DMAbstract getDriverManager() {return this.driverManager.get();};

	@Parameters("browser")
	@BeforeMethod
	public synchronized void startDriver(@Optional String browser){
		if(browser == null)
			browser = "CHROME";
//		setDriver(new DriverManagerOriginal().initializeDriver(browser));
//		setDriver(DriverManagerFactory.getManager(BrowserType.valueOf(browser)).createDriver());
		setDriverManager(DMFactoryAbstract.getManager(BrowserType.valueOf(browser)));
		setDriver(getDriverManager().getDriver());
		System.out.println("CURRENT THREAD : " + Thread.currentThread().getId());
	}

	@Parameters("browser")
	@AfterMethod
	public synchronized void quitDriver(ITestResult result,@Optional String browser) throws InterruptedException, IOException {
		if(browser == null)
			browser = "CHROME";
		Thread.sleep(1000);
		if(result.getStatus() == ITestResult.FAILURE){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			File destFile = new File("src" + File.separator + browser + File.separator +
					result.getTestClass().getRealClass().getSimpleName() + "_" +
					result.getMethod().getMethodName() + "_" + sdf.format(timestamp) + ".png");
			takeScreenShotUsingAShot(destFile);
		}
		getDriver().quit();
	}

	public void injectCookiesToBrowser(Cookies cookies){
		List<Cookie> seleniumCookies = new CookiesUtil().convertRestAssuredCookiesToSeleniumCookies(cookies);
		for(Cookie cookie : seleniumCookies){
			getDriver().manage().addCookie(cookie);
		}
	}

	private void takeScreenShot(File destFile) throws IOException {
		TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver();
		File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, destFile);
	}

	private void takeScreenShotUsingAShot(File destFile){
		Screenshot screenshot = new AShot()
				.shootingStrategy(ShootingStrategies.viewportPasting(100))
				.takeScreenshot(getDriver());
		try{
			ImageIO.write(screenshot.getImage(), "PNG", destFile);
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
