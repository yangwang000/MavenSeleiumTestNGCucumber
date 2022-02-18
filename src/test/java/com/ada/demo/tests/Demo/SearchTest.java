package com.ada.demo.tests.Demo;

import com.ada.demo.base.BaseTest;
import com.ada.demo.pages.StorePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

	@Test
	public void searchWithPartialMatch(){
		String searchFor = "Blue";
		StorePage storePage = new StorePage(getDriver())
				.load()
				.enterTextInSearchFld(searchFor)
				.clickSearchBtn();
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.urlContains(searchFor));
		Assert.assertEquals(storePage.getTitle(), "Search results: “" + searchFor + "”");
	}
}
