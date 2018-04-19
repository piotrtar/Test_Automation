package com.sii.Controller;


import com.sii.Models.Order;
import com.sii.Models.Product;
import com.sii.Pages.ProductPage;

import java.util.ArrayList;

public class OrderController {

    private Order order;
    private ProductPage productPage;
    private int index;
    private int potentialIndex;
    private ArrayList<Integer> alreadyDrawedIndexes = new ArrayList<>();

    public OrderController(Order order, ProductPage productPage) {
        this.order = order;
        this.productPage = productPage;
    }

    public OrderController selectAndAddToCartRandomProduct() throws InterruptedException {
        drawRandomProductWithProtectionFromDrawingSameProduct();
        productPage.clickAddToCartSelectedProduct(index);
        Product orderProduct = Product.productListObj.get(index);
        order.addProduct(orderProduct);
        return this;
    }

    public OrderController addToCartLastAddedProduct() throws InterruptedException {
        productPage.clickAddToCartLastAddedProduct(index);
        Product orderProduct = Product.productListObj.get(index);
        order.addProduct(orderProduct);
        return this;
    }

    public void drawRandomProductWithProtectionFromDrawingSameProduct() throws InterruptedException {
        potentialIndex = productPage.getRandomProductNumber();
        if (!alreadyDrawedIndexes.contains(potentialIndex)) {
            index = potentialIndex;
            alreadyDrawedIndexes.add(index);
        } else {
            selectAndAddToCartRandomProduct();
        }
    }

}
