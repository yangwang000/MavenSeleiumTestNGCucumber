package com.ada.tests.Demo;

import com.ada.base.BaseTest;
import com.ada.pages.HomePage;
import com.ada.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {

	@Test
	public void navigateFromHomeToStoreUsingMainMenu(){
		StorePage storePage = new HomePage(getDriver()).
				load().navigateToStoreUsingMenue();
		Assert.assertEquals(storePage.getTitle(), "Store");
	}
}
