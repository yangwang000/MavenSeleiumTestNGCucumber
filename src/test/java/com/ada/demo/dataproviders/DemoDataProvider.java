package com.ada.demo.dataproviders;

import com.ada.demo.dataobjects.Product;
import com.ada.demo.utils.JsonUtils;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DemoDataProvider {

    @DataProvider(name = "getFeaturedProducts", parallel = false)
    public Object[] getFeaturedProducts() throws IOException {
        return JsonUtils.deserializeJson("products.json", Product[].class);
    }
}
