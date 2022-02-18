package com.ada.demo.utils;

import io.restassured.http.Cookies;
import org.openqa.selenium.Cookie;

import java.util.ArrayList;
import java.util.List;

public class CookiesUtil {

	public List<Cookie> convertRestAssuredCookiesToSeleniumCookies(Cookies cookies){
		List<io.restassured.http.Cookie> restAssuredCookies = new ArrayList<>();
		restAssuredCookies = cookies.asList();
		List<Cookie> seleniumCookies = new ArrayList<>();
		for(io.restassured.http.Cookie cookie: restAssuredCookies){
			seleniumCookies.add(new Cookie(cookie.getName(), cookie.getValue(), cookie.getDomain(),
					cookie.getPath(), cookie.getExpiryDate(), cookie.isSecured(), cookie.isHttpOnly()));
		}
		return seleniumCookies;
	}
}