package com.sii.Models;

import java.util.*;

public class Order {

    private Random randomGenerator = new Random();

    Map<Product, Integer> products;
    public Order() {
        this.products =  new LinkedHashMap<>();
    }

    public void addProduct(Product product) {
        if (this.products.containsKey(product)) {
            int quantity = this.products.get(product);
            this.products.put(product, quantity +1);
        } else {
            this.products.put(product, 1);
        }
    }

    public void removeProduct(Product product) {
        if (this.products.containsKey(product)) {
            int quantity = this.products.get(product);
            if (quantity == 1) {
                this.products.remove(product);
            } else {
                this.products.put(product, quantity - 1);
            }
        }
    }

    public float getTotalPrice() {
        float totalPrice = 0;
        for (Product product : this.products.keySet()) {
            totalPrice += product.getPrice() * this.products.get(product);
        }
        return totalPrice;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public Product getRandomProductFromOrder() {
        List<Product> productList = new ArrayList<>(this.products.keySet());
        int randomProductIndex = randomGenerator.nextInt(productList.size());
        return productList.get(randomProductIndex);
    }
}
