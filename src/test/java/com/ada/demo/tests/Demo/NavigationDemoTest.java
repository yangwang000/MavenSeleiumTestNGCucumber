package com.ada.demo.tests.Demo;

import com.ada.demo.base.BaseDemoTest;
import com.ada.demo.pages.HomeDemoPage;
import com.ada.demo.pages.StoreDemoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationDemoTest extends BaseDemoTest {

	@Test
	public void navigateFromHomeToStoreUsingMainMenu(){
		StoreDemoPage storePage = new HomeDemoPage(getDriver()).
				load().getMyHeader().navigateToStoreUsingMenu();
		Assert.assertEquals(storePage.getTitle(), "Store");
	}
}
