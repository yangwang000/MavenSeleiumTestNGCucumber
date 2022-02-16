package com.ada.tests.WebdriverDemo;

import com.ada.base.BaseTest;
import com.ada.objects.BillingAddress;
import com.ada.objects.Product;
import com.ada.pages.CartPage;
import com.ada.pages.CheckoutPage;
import com.ada.pages.HomePage;
import com.ada.pages.StorePage;
import com.ada.utils.JsonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class NewTest extends BaseTest {
    @Test
    public void testEasy() throws IOException, InterruptedException {
        String searchFor = "Blue";
        BillingAddress billingAddress = JsonUtils.deserializeJson("BillingAddress.json", BillingAddress.class);
        Product product = new Product(1215);

        StorePage storePage = new HomePage(driver).
                load().navigateToStoreUsingMenue();
        Thread.sleep(2000);
        storePage.enterTextInSearchFld(searchFor).clickSearchBtn();
        Thread.sleep(2000);
        Assert.assertEquals(storePage.getTitle(), "Search results: “" + searchFor + "”");

        storePage.clickAddToCartBtn(product.getName());
        Thread.sleep(2000);
        CartPage cartPage = storePage.clickViewCart();
        Assert.assertEquals(cartPage.getProductName(), product.getName());
        CheckoutPage checkoutPage = cartPage.clickCheckoutBtn();
        checkoutPage.setBillingAddress(billingAddress);
        checkoutPage.clickPlaceOrderBtn();
        Thread.sleep(2000);
        Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");
    }

    @Test
    public void testSth(){

    }
}