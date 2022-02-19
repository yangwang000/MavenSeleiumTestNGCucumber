package com.ada.demo.tests.Demo;

import com.ada.demo.base.BaseDemoTest;
import com.ada.demo.pages.StoreDemoPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchDemoTest extends BaseDemoTest {

	@Test
	public void searchWithPartialMatch(){
		String searchFor = "Blue";
		StoreDemoPage storePage = new StoreDemoPage(getDriver())
				.load().search(searchFor);
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.urlContains(searchFor));
		Assert.assertEquals(storePage.getTitle(), "Search results: “" + searchFor + "”");
	}
}
