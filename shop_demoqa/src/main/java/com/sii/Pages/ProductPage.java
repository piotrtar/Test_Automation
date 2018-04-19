package com.sii.Pages;

import com.sii.Models.Order;
import com.sii.Models.Product;
import com.sii.Utilities.WebElementManipulator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductPage extends WebElementManipulator{

    private Random randomGenerator = new Random();
    List<WebElement> listOfProducts;
    List<WebElement> cartProducts;
    ArrayList<String> productsInCartDetails;
    private int numberOfTotalProducts;
    private List<WebElement> filteredProducts;
    private ArrayList<Float> filteredProductsPrices;

    @FindBy(css = ".cart-count")
    private WebElement numberOfProducts;

    @FindBy(css = ".added-to-cart>a")
    private WebElement continueShoppingButton;

    @FindBy(css = ".cart-item")
    private WebElement cartIcon;

    @FindBy(css = ".price_slider>.ui-slider-handle:nth-child(2)")
    private WebElement leftSliderPoint;

    @FindBy(css = ".price_slider>.ui-slider-handle:nth-child(3)")
    private WebElement rightSliderPoint;

    @FindBy(css = ".price_slider")
    private WebElement slider;

    @FindBy(css = ".price_label>span")
    private WebElement minFilterPrice;

    @FindBy(css = ".price_label>span:nth-child(2)")
    private WebElement maxFilterPrice;

    @FindBy(css = ".price_slider_amount>button")
    private WebElement filterButton;

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ArrayList<String> loadProductsDetailsFromCart() {
        productsInCartDetails = new ArrayList<>();
        moveCursorToElement(cartIcon);
        cartProducts = driver.findElements(By.cssSelector(".cart-product"));
        for(WebElement product : cartProducts) {
            String productPartialName = product.findElement(By.cssSelector("div.cart-product-title>a")).getText().substring(0,15);
            String fullProductQuantity = product.findElement(By.cssSelector("div.cart-product-quantity")).getText();
            String productQuantity = fullProductQuantity.substring(fullProductQuantity.lastIndexOf(' ') + 1);
            productsInCartDetails.add(productPartialName + " " + productQuantity);
        }
        return productsInCartDetails;
    }

    public void loadProductsFromPage() {
        listOfProducts = driver.findElements(By.cssSelector(".noo-product-item"));
        numberOfTotalProducts = listOfProducts.size();
        for(WebElement product : listOfProducts) {
            String productName = product.findElement(By.cssSelector("h3>a")).getText();
            Float productPrice;
            try {
                productPrice = Float.parseFloat(product.findElement(By.cssSelector("div>span>ins>span")).getText().substring(1));
            } catch (Exception e) {
                productPrice = Float.parseFloat(product.findElement(By.cssSelector("div>span>span")).getText().substring(1));
            }
            new Product(productName, productPrice);
        }
    }

    public ProductPage clickAddToCartSelectedProduct(int index) throws InterruptedException {
        scrollUp();
        WebElement product = getProduct(index);
        return clickAddProductToCartButton(product);
    }

    public ProductPage clickAddToCartLastAddedProduct(int index) throws InterruptedException {
        WebElement product = getProduct(index);
        return clickAddProductToCartButton(product);
    }

    public int getRandomProductNumber() {
        int productNumber = randomGenerator.nextInt(numberOfTotalProducts);
        return productNumber;
    }

    public WebElement getProduct(int productNumber) {
        return listOfProducts.get(productNumber);
    }

    public ProductPage clickAddProductToCartButton(WebElement product) throws InterruptedException {
        waitUntillElementIsClickable(product);
        moveCursorToElement(product);
        WebElement shopCart = product.findElement(By.cssSelector(".add_to_cart_button"));
        Thread.sleep(200);
        waitUntillElementIsClickable(shopCart);
        moveCursorToElement(shopCart);
        shopCart.click();
        continueShopping();
        return this;
    }

    public ProductPage continueShopping() {
        waitUntillElementIsClickable(continueShoppingButton);
        continueShoppingButton.click();
        return this;
    }

    public ProductPage moveRightSliderByNumber(int number) {
        waitUntillElementIsClickable(rightSliderPoint);
        for (int i = 1; i <= number ; i++) {
            rightSliderPoint.sendKeys(Keys.ARROW_LEFT);
        }
        return this;
    }

    public ProductPage moveLeftSliderByNumber(int number) {
        waitUntillElementIsClickable(leftSliderPoint);
        int width = slider.getSize().getWidth();
        Actions move = new Actions(driver);
        move.dragAndDropBy(leftSliderPoint, (width*number/100), 0).click();
        move.build().perform();
        return this;
    }

    public Float getMinFilerPrice() {
        String minPrice = minFilterPrice.getText().replace("£", "");
        Float minFilterPrice = Float.parseFloat(minPrice);
        return minFilterPrice;
    }

    public Float getMaxFilterPrice() {
        String maxPrice = maxFilterPrice.getText().replace("£", "");
        Float maxFilterPrice = Float.parseFloat(maxPrice);
        return maxFilterPrice;
    }

    public ProductPage clickFilterButton() {
        waitUntillElementIsClickable(filterButton);
        filterButton.click();
        return this;
    }

    public ArrayList<Float> loadFilteredProductsPrices() {
        filteredProductsPrices = new ArrayList<>();
        filteredProducts = driver.findElements(By.cssSelector(".noo-product-item"));
        for(WebElement product : filteredProducts) {
            Float productPrice;
            try {
                productPrice = Float.parseFloat(product.findElement(By.cssSelector("div>span>ins>span")).getText().substring(1));
            } catch (Exception e) {
                productPrice = Float.parseFloat(product.findElement(By.cssSelector("div>span>span")).getText().substring(1));
            }
            filteredProductsPrices.add(productPrice);
        }
        return filteredProductsPrices;
    }

}