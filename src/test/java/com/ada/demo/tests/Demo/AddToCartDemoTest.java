package com.ada.demo.tests.Demo;

import com.ada.demo.base.BaseDemoTest;
import com.ada.demo.dataObjects.Product;
import com.ada.demo.dataProviders.DemoDataProvider;
import com.ada.demo.pages.CartDemoPage;
import com.ada.demo.pages.HomeDemoPage;
import com.ada.demo.pages.StoreDemoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddToCartDemoTest extends BaseDemoTest {

    @Test
    public void addToCartFromStorePage() throws IOException {
        Product product = new Product(1215);
        CartDemoPage cartPage = new StoreDemoPage(getDriver()).load().
                getProductThumbnail().clickAddToCartBtn(product.getName()).
                clickViewCart();
        Assert.assertEquals(cartPage.getProductName(), product.getName() + "aaa");
    }

    @Test(dataProvider = "getFeaturedProducts", dataProviderClass = DemoDataProvider.class)
    public void addToCartFeaturedProducts(Product product){
            CartDemoPage cartPage = new HomeDemoPage(getDriver()).load().
                    getProductThumbnail().
                    clickAddToCartBtn(product.getName()).
                    clickViewCart();
            Assert.assertEquals(cartPage.getProductName(), product.getName());
    }
}
