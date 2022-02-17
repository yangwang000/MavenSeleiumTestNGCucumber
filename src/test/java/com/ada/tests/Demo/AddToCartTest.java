package com.ada.tests.Demo;

import com.ada.base.BaseTest;
import com.ada.dataobjects.Product;
import com.ada.pages.CartPage;
import com.ada.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddToCartTest extends BaseTest {
	@Test
	public void addToCartFromStorePage() throws IOException, InterruptedException {
		Product product = new Product(1215);
		CartPage cartPage = new StorePage(getDriver())
				.load()
						.clickAddToCartBtn(product.getName())
								.clickViewCart();
		Assert.assertEquals(cartPage.getProductName(), product.getName());
	}
}
