package com.sii.Pages;

import com.sii.Models.Product;
import com.sii.Utilities.WebElementManipulator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends WebElementManipulator {

    private ArrayList<String> productDetailsInCart;
    private List<WebElement> cartProducts;

    @FindBy(css = "td.actions>input.button")
    private WebElement updateShoppingCartButton;

    @FindBy(css = "form>div.blockOverlay")
    private WebElement loadingChangesAfterUpdateAnimationSign;

    @FindBy(css = "[id='shipping_method']>li:nth-child(2)>input")
    private WebElement freeShippingButton;

    @FindBy(css = ".wc-proceed-to-checkout>a")
    private WebElement proceedToCheckoutButton;


    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ArrayList<String> loadProductsFromCartPage() {
        productDetailsInCart = new ArrayList<>();
        cartProducts = driver.findElements(By.cssSelector(".cart_item"));
        for (WebElement product : cartProducts) {
            String productPartialName = product.findElement(By.cssSelector("td.product-name>a")).getText().substring(0,15);
            String productPrice = product.findElement(By.cssSelector("td.product-price>span")).getText().substring(1);
            String productQuantity = product.findElement(By.cssSelector("div.noo-quantity-attr>input")).getAttribute("value");
            productDetailsInCart.add(productPartialName + " " + productPrice + " " + productQuantity);
        }
        return productDetailsInCart;
    }

    public CartPage decreaseQuantityOfRandomProduct(Product randomProduct) {
        cartProducts = driver.findElements(By.cssSelector(".cart_item"));
        for (WebElement product : cartProducts) {
            if (product.findElement(By.cssSelector("td.product-name>a")).getText().equals(randomProduct.getName())) {
                WebElement decreaseProductQuantityButton = product.findElement(By.cssSelector(".icon_minus-06"));
                decreaseProductQuantityButton.click();
            }
        }
        return this;
    }

    public CartPage clickUpdateShoppingCartButton() {
        waitUntillElementIsClickable(updateShoppingCartButton);
        updateShoppingCartButton.click();
        waitUntilElementDisapear("form>div.blockOverlay");
        return this;
    }

    public CartPage increaseQuantityOfRandomProduct(Product randomProduct) {
        cartProducts = driver.findElements(By.cssSelector(".cart_item"));
        for (WebElement product : cartProducts) {
            if (product.findElement(By.cssSelector("td.product-name>a")).getText().equals(randomProduct.getName())) {
                WebElement increaseProductQuantityButton = product.findElement(By.cssSelector(".icon_plus"));
                increaseProductQuantityButton.click();
            }
        }
        return this;
    }

    public CartPage clickFreeShippingButton() {
        freeShippingButton.click();
        waitUntilElementDisapear("form>div.blockOverlay");
        return this;
    }

    public CartPage clickProceedToCheckoutButton() {
        waitUntilBlockUIDisappear();
        waitUntillElementIsClickable(proceedToCheckoutButton);
        proceedToCheckoutButton.click();
        return this;
    }
}
