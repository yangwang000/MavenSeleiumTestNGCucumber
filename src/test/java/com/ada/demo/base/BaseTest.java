package com.ada.demo.base;

import com.ada.demo.factory.DriverManager;
import com.ada.demo.utils.CookiesUtil;
import io.restassured.http.Cookies;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.List;

public class BaseTest {
	private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	private void setDriver(WebDriver driver){
		this.driver.set(driver);
	}

	protected WebDriver getDriver(){
		return this.driver.get();
	}

	@Parameters("browser")
	@BeforeMethod
	public void startDriver(@Optional String browser){
		if(browser == null)
			browser = "CHROME";
		setDriver(new DriverManager().initializeDriver(browser));
		System.out.println("CURRENT THREAD : " + Thread.currentThread().getId());
	}

	@AfterMethod
	public void quitDriver(){
		getDriver().quit();
	}

	public void injectCookiesToBrowser(Cookies cookies){
		List<Cookie> seleniumCookies = new CookiesUtil().convertRestAssuredCookiesToSeleniumCookies(cookies);
		for(Cookie cookie : seleniumCookies){
			getDriver().manage().addCookie(cookie);
		}
	}
}
