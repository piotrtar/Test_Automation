package com.sii.PageObjectTest;

import com.sii.BaseTest.TestBaseShopDemoqa;
import com.sii.Controller.OrderController;
import com.sii.Factory.UserFactory;
import com.sii.Models.Order;
import com.sii.Models.Product;
import com.sii.Models.User;
import com.sii.Pages.FinishedOrderPage;
import com.sii.Pages.ProductPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class CheckOutTest extends TestBaseShopDemoqa {

    private User user = UserFactory.getTestUser();
    private ProductPage productPage;
    private OrderController orderController;
    private Order order;
    private FinishedOrderPage finishedOrderPage;
    private ArrayList<String> productsInFinishedOrderPage;
    private float totalPrice = 0;

    @BeforeMethod
    public void goToProductsPage() {
        topMenuPage.goToWomanJacketsPage().waitFor(5);
        productPage = new ProductPage(driver);
        productPage.loadProductsFromPage();
        order = new Order();
        orderController = new OrderController(order, productPage);
        finishedOrderPage = new FinishedOrderPage(driver);
    }

    @Test(priority = 0)
    public void addProductsToCartAndCheckCorrectnessOfCheckout() throws InterruptedException {
        orderController.selectAndAddToCartRandomProduct()
                .selectAndAddToCartRandomProduct()
                .addToCartLastAddedProduct();
        topMenuPage.goToShoppingCartPage();

        cartPage.clickFreeShippingButton()
                .clickProceedToCheckoutButton();
        fillCheckOutForm();
        checkoutPage.clickCheckBoxWithAcceptTerms()
                    .clickPlaceOrderButton();

        String expected = "Thank you. Your order has been received.";
        String actual = checkoutPage.getReceivedOrderMessage();
        assertEquals(expected, actual);

        checkIfProductsAreValidInFinishedOrderPage();
        checkTotalPrice();
        checkShippingMethod();
    }

    public void fillCheckOutForm() {
        checkoutPage.typeBillingFirstName(user.getFirstName())
                    .typeBillingLastName(user.getLastName())
                    .typeBillingEmailAddress(user.getEmail())
                    .typeBillingPhoneNumber(user.getPhoneNumber())
                    .clickBillingCountryDropDownList()
                    .typeBillingCountry(user.getCountry())
                    .typeBillingAddress(user.getBillingAddress())
                    .typeBillingCity(user.getBillingCity())
                    .typeBillingPostcode(user.getBillingPostCode())
                    .typeShippingFistName(user.getFirstName())
                    .typeShippingLastName(user.getLastName())
                    .clickShippingCountryDropDownList()
                    .typeShippingCountry(user.getCountry())
                    .typeShippingAddress(user.getShippingAddress())
                    .typeShippingPostcode(user.getShippingPostCode())
                    .typeShippingCity(user.getShippingCity());
    }

    public void checkIfProductsAreValidInFinishedOrderPage() {
        productsInFinishedOrderPage = finishedOrderPage.loadProductsFromFinishedOrderPage();
        int counter = 0;
        for (Product product : this.order.getProducts().keySet()) {
            String expected = product.getPartialName() + " " + (Float.toString(product.getPrice() * this.order.getProducts().get(product)) + "0") + " " + this.order.getProducts().get(product).toString();
            String actual = productsInFinishedOrderPage.get(counter);
            totalPrice += product.getPrice() * this.order.getProducts().get(product);
            System.out.println("expected - " + expected);
            System.out.println("actual - " + actual);
            assertEquals(expected, actual);
            counter ++;
        }
    }

    public void checkTotalPrice() {
        String expected = Float.toString(totalPrice) + "0";
        String actual = finishedOrderPage.getTotalPrice();
        assertEquals(expected, actual);
    }

    public void checkShippingMethod() {
        String expected = "Free Shipping";
        String actual = finishedOrderPage.getShippingMethod();
        assertEquals(expected, actual);
    }
}
