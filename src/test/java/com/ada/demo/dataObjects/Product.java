package com.ada.demo.dataObjects;

import com.ada.utils.JsonUtils;

import java.io.IOException;

public class Product {
	private int id;
	private String name;

	public Product() {}

	public Product(int id) throws IOException {
		Product[] products = JsonUtils.deserializeJson("products.json", Product[].class);
		for(Product product : products){
			if(product.id == id){
				this.id = id;
				this.name = product.getName();
			}
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
