package com.sii.Pages;

import com.sii.Utilities.WebElementManipulator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class FinishedOrderPage extends WebElementManipulator {

    private ArrayList<String> productOrderDetails;
    private List<WebElement> orderProducts;

    @FindBy(css = ".total>strong>span")
    private WebElement totalPrice;

    @FindBy(xpath = "//th[contains(text(), 'Shipping')]/following-sibling::td")
    private WebElement shippingMethod;

    public FinishedOrderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getTotalPrice() {
        return totalPrice.getText().substring(1);
    }

    public String getShippingMethod() {
        return shippingMethod.getText();
    }

    public ArrayList<String> loadProductsFromFinishedOrderPage() {
        waitForPageToLoad();
        productOrderDetails = new ArrayList<>();
        orderProducts = driver.findElements(By.cssSelector(".order_item"));
        System.out.println(orderProducts.size());
        for (WebElement product : orderProducts) {
            String productPartialName = product.findElement(By.cssSelector("td.product-name>a")).getText().substring(0,15);
            String productPrice = product.findElement(By.cssSelector("td.product-total>span")).getText().substring(1);
            String productQuantity = product.findElement(By.cssSelector(".product-quantity")).getText().substring(2);
            productOrderDetails.add(productPartialName + " " + productPrice + " " + productQuantity);
        }
        return productOrderDetails;
    }

}
