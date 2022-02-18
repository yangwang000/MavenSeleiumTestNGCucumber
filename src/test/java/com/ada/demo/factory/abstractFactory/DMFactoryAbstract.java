package com.ada.demo.factory.abstractFactory;

import com.ada.demo.constants.BrowserType;
import com.ada.demo.factory.ChromeDriverManager;
import com.ada.demo.factory.DriverManager;
import com.ada.demo.factory.FirefoxDriverManager;

public class DMFactoryAbstract {
	public static DMAbstract getManager(BrowserType browserType){
		switch (browserType){
			case CHROME:
				return new ChromeDMAbstract();
			case FIREFOX:
				return new FirefoxDMAbstract();
			default:
				throw new IllegalStateException("Invalid browser: " + browserType);
		}
	}
}
