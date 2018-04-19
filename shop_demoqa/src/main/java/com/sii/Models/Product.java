package com.sii.Models;

import java.util.ArrayList;

public class Product {

    public static ArrayList<Product> productListObj = new ArrayList<>();

    private String name;
    private float price;

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        productListObj.add(this);
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public String getPartialName() {
        return name.substring(0,15);
    }

}
