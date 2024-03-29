package com.ada.demo.tests.Demo;

import com.ada.demo.apiActions.CartApi;
import com.ada.demo.apiActions.SignUpApi;
import com.ada.base.BaseTest;
import com.ada.demo.dataObjects.Product;
import com.ada.demo.dataObjects.User;
import com.ada.utils.FakerUtils;
import com.ada.demo.pages.CheckoutPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

	@Test
	public void loginDuringCheckout() throws Exception {
		String username = "demouser" + new FakerUtils().generateRandomNumber();
		User user = new User()
				.setUsername(username)
				.setPassword("demopwd")
				.setEmail(username+"@demo.com");
		SignUpApi signUpApi = new SignUpApi();
		signUpApi.register(user);


		CartApi cartApi = new CartApi();
		Product product = new Product(1215);
		cartApi.addToCart(product.getId(), 1);


		CheckoutPage checkoutPage = new CheckoutPage(getDriver()).load();
		Thread.sleep(5000);
		injectCookiesToBrowser(cartApi.getCookies());
		checkoutPage.load();
		checkoutPage.clickHereToLoginLink().login(user);
		Thread.sleep(5000);
		Assert.assertTrue(checkoutPage.getProductName().contains(product.getName()));
	}
}
