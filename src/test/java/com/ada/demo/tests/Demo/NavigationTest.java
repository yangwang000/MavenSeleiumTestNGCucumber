package com.ada.demo.tests.Demo;

import com.ada.demo.base.BaseTest;
import com.ada.demo.pages.HomePage;
import com.ada.demo.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {

	@Test
	public void navigateFromHomeToStoreUsingMainMenu(){
		StorePage storePage = new HomePage(getDriver()).
				load().getMyHeader().navigateToStoreUsingMenu();
		Assert.assertEquals(storePage.getTitle(), "Store");
	}
}
