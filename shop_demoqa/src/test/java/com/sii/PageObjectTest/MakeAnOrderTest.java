package com.sii.PageObjectTest;

import com.sii.BaseTest.TestBaseShopDemoqa;
import com.sii.Controller.OrderController;
import com.sii.Models.Order;
import com.sii.Models.Product;
import com.sii.Pages.ProductPage;
import org.testng.annotations.*;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class MakeAnOrderTest extends TestBaseShopDemoqa {

    private ProductPage productPage;
    private OrderController orderController;
    private ArrayList<String> productInCartList;
    private ArrayList<String> productsInCartPage;
    private Order order;

    @BeforeMethod
    public void goToProductsPage() {
        topMenuPage.goToWomanJacketsPage().waitFor(5);
        productPage = new ProductPage(driver);
        productPage.loadProductsFromPage();
        order = new Order();
        orderController = new OrderController(order, productPage);

    }

    @AfterMethod
    public void clearShoppingCart() {
        topMenuPage.goToShoppingCartPage()
                    .clickEmptyCartButton();
    }

    @Test(priority = 1)
    public void addProductsToCartAndCheckPrice() throws InterruptedException {
        orderController.selectAndAddToCartRandomProduct()
                        .selectAndAddToCartRandomProduct()
                        .addToCartLastAddedProduct();
        float expected = order.getTotalPrice();
        float actual = topMenuPage.getTotalCartPrice();
        assertEquals(expected, actual);
    }

    @Test(priority = 2)
    public void checkIfCartContainsValidProductsAfterAddingThemToIt() throws InterruptedException {
        orderController.selectAndAddToCartRandomProduct()
                        .selectAndAddToCartRandomProduct()
                        .addToCartLastAddedProduct();
        checkIfProductsInCartAreValid();
    }

    @Test(priority = 3)
    public void checkIfCartContainsValidProductsDataInCartPage() throws InterruptedException {
        orderController.selectAndAddToCartRandomProduct()
                        .selectAndAddToCartRandomProduct()
                        .addToCartLastAddedProduct();
        topMenuPage.goToShoppingCartPage();
        checkIfProductsAreValidInCartPage();
    }

    @Test(priority = 4)
    public void checkIncreaseAndDecreaseOfAmountOfRandomProductInCartPage() throws InterruptedException {
        orderController.selectAndAddToCartRandomProduct()
                .selectAndAddToCartRandomProduct()
                .addToCartLastAddedProduct();
        topMenuPage.goToShoppingCartPage();
        increaseQuantityOfRandomProductInCartPage();
        checkIfProductsAreValidInCartPage();
        decreaseQuantityOfRandomProductInCartPage();
        checkIfProductsAreValidInCartPage();
    }

    public void checkIfProductsInCartAreValid() {
        productInCartList = productPage.loadProductsDetailsFromCart();
        int counter = 0;
        for (Product product : this.order.getProducts().keySet()) {
            String expected = product.getPartialName() + " " + this.order.getProducts().get(product).toString();
            String actual = productInCartList.get(counter);
            System.out.println(expected);
            System.out.println(actual);
            assertEquals(expected, actual);
            counter ++;
        }
    }

    public void checkIfProductsAreValidInCartPage() {
        productsInCartPage = cartPage.loadProductsFromCartPage();
        int counter = 0;
        for (Product product : this.order.getProducts().keySet()) {
            String expected = product.getPartialName() + " " + (Float.toString(product.getPrice()) + "0") + " " + this.order.getProducts().get(product).toString();
            String actual = productsInCartPage.get(counter);
            System.out.println("expected - " + expected);
            System.out.println("actual - " + actual);
            assertEquals(expected, actual);
            counter ++;
        }
    }

    public void increaseQuantityOfRandomProductInCartPage() {
        Product randomProduct = order.getRandomProductFromOrder();
        cartPage.increaseQuantityOfRandomProduct(randomProduct)
                .clickUpdateShoppingCartButton();
        order.addProduct(randomProduct);
    }

    public void decreaseQuantityOfRandomProductInCartPage() {
        Product randomProduct = order.getRandomProductFromOrder();
        cartPage.decreaseQuantityOfRandomProduct(randomProduct)
                .clickUpdateShoppingCartButton();
        order.removeProduct(randomProduct);
    }
}
