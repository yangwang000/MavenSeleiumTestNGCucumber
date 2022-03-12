package com.ada.webDriverFactory.abstractFactory;

import com.ada.constants.BrowserType;

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
