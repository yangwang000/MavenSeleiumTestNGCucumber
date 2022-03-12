package com.ada.demo.tests.Demo;

import com.ada.base.BaseTest;
import com.ada.demo.dataObjects.BillingAddress;
import com.ada.demo.dataObjects.Product;
import com.ada.demo.pages.CartPage;
import com.ada.demo.pages.CheckoutPage;
import com.ada.demo.pages.HomePage;
import com.ada.demo.pages.StorePage;
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

        StorePage storePage = new HomePage(getDriver()).
                load().getMyHeader().navigateToStoreUsingMenu();
        Thread.sleep(2000);
        storePage.search(searchFor);
        Thread.sleep(2000);
        Assert.assertEquals(storePage.getTitle(), "Search results: “" + searchFor + "”");

        storePage.getProductThumbnail().clickAddToCartBtn(product.getName());
        Thread.sleep(2000);
        CartPage cartPage = storePage.getProductThumbnail().clickViewCart();
        Assert.assertEquals(cartPage.getProductName(), product.getName());
        CheckoutPage checkoutPage = cartPage.clickCheckoutBtn();
        checkoutPage.setBillingAddress(billingAddress);
        checkoutPage.placeOrder();
        Thread.sleep(2000);
        Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");
    }

//    @Test
    public void testSth(){

    }
}