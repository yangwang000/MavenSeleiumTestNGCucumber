package com.ada.demo.tests.Demo;

import com.ada.demo.api.actions.CartApi;
import com.ada.demo.api.actions.SignUpApi;
import com.ada.demo.base.BaseDemoTest;
import com.ada.demo.dataObjects.BillingAddress;
import com.ada.demo.dataObjects.Product;
import com.ada.demo.dataObjects.User;
import com.ada.demo.utils.FakerUtils;
import com.ada.demo.pages.CheckoutDemoPage;
import com.ada.demo.utils.JsonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class CheckoutDemoTest extends BaseDemoTest {

    @Test
    public void GuestCheckoutUsingDirectBankTransfer() throws IOException, InterruptedException {
        BillingAddress billingAddress = JsonUtils.deserializeJson("BillingAddress.json", BillingAddress.class);
        CheckoutDemoPage checkoutPage = new CheckoutDemoPage(getDriver()).load();

        CartApi cartApi = new CartApi();
        cartApi.addToCart(1215, 1);
        injectCookiesToBrowser(cartApi.getCookies());

        checkoutPage.load().
        setBillingAddress(billingAddress).
                selectDirectBankTransfer().
                placeOrder();
        Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");
    }

    @Test
    public void LoginAndCheckoutUsingDirectBankTransfer() throws IOException, InterruptedException {
        BillingAddress billingAddress = JsonUtils.deserializeJson("BillingAddress.json", BillingAddress.class);
        String username = "demouser" + new FakerUtils().generateRandomNumber();
        User user = new User().
                setUsername(username).
                setPassword("demopwd").
                setEmail(username + "@askomdch.com");

        SignUpApi signUpApi = new SignUpApi();
        signUpApi.register(user);
        CartApi cartApi = new CartApi(signUpApi.getCookies());
        Product product = new Product(1215);
        cartApi.addToCart(product.getId(), 1);

        CheckoutDemoPage checkoutPage = new CheckoutDemoPage(getDriver()).load();
        injectCookiesToBrowser(signUpApi.getCookies());
        checkoutPage.load();
        checkoutPage.setBillingAddress(billingAddress).
                selectDirectBankTransfer().
                placeOrder();
        Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");
    }
}
