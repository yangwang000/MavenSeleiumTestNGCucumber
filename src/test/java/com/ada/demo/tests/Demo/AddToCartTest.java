package com.ada.demo.tests.Demo;

import com.ada.demo.base.BaseTest;
import com.ada.demo.dataobjects.Product;
import com.ada.demo.dataproviders.DemoDataProvider;
import com.ada.demo.pages.CartPage;
import com.ada.demo.pages.HomePage;
import com.ada.demo.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddToCartTest extends BaseTest {

    @Test
    public void addToCartFromStorePage() throws IOException {
        Product product = new Product(1215);
        CartPage cartPage = new StorePage(getDriver()).load().
                getProductThumbnail().clickAddToCartBtn(product.getName()).
                clickViewCart();
        Assert.assertEquals(cartPage.getProductName(), product.getName());
    }

    @Test(dataProvider = "getFeaturedProducts", dataProviderClass = DemoDataProvider.class)
    public void addToCartFeaturedProducts(Product product){
            CartPage cartPage = new HomePage(getDriver()).load().
                    getProductThumbnail().
                    clickAddToCartBtn(product.getName()).
                    clickViewCart();
            Assert.assertEquals(cartPage.getProductName(), product.getName());
    }
}
