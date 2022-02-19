package com.ada.demo.tests.Demo;

import com.ada.demo.base.BaseDemoTest;
import com.ada.demo.dataObjects.BillingAddress;
import com.ada.demo.dataObjects.Product;
import com.ada.demo.pages.CartDemoPage;
import com.ada.demo.pages.CheckoutDemoPage;
import com.ada.demo.pages.HomeDemoPage;
import com.ada.demo.pages.StoreDemoPage;
import com.ada.demo.utils.JsonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class NewDemoTest extends BaseDemoTest {
    @Test
    public void testEasy() throws IOException, InterruptedException {
        String searchFor = "Blue";
        BillingAddress billingAddress = JsonUtils.deserializeJson("BillingAddress.json", BillingAddress.class);
        Product product = new Product(1215);

        StoreDemoPage storePage = new HomeDemoPage(getDriver()).
                load().getMyHeader().navigateToStoreUsingMenu();
        Thread.sleep(2000);
        storePage.search(searchFor);
        Thread.sleep(2000);
        Assert.assertEquals(storePage.getTitle(), "Search results: “" + searchFor + "”");

        storePage.getProductThumbnail().clickAddToCartBtn(product.getName());
        Thread.sleep(2000);
        CartDemoPage cartPage = storePage.getProductThumbnail().clickViewCart();
        Assert.assertEquals(cartPage.getProductName(), product.getName());
        CheckoutDemoPage checkoutPage = cartPage.clickCheckoutBtn();
        checkoutPage.setBillingAddress(billingAddress);
        checkoutPage.placeOrder();
        Thread.sleep(2000);
        Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");
    }

//    @Test
    public void testSth(){

    }
}