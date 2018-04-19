package com.sii.Pages;

import com.sii.Helpers.DataGenerator;
import com.sii.Utilities.WebElementManipulator;
import net.jodah.failsafe.Failsafe;
import net.jodah.failsafe.RetryPolicy;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class CheckoutPage extends WebElementManipulator {

    private DataGenerator dataGenerator = new DataGenerator();

    @FindBy(css = "[name='terms']")
    private WebElement checkBoxTerms;

    @FindBy(css = "[id='billing_first_name']")
    private WebElement billingFirstNameInputField;

    @FindBy(css = "[id='billing_last_name']")
    private WebElement billingLastNameInputField;

    @FindBy(css = "[id='billing_email']")
    private WebElement billingEmailAddressInputField;

    @FindBy(css = "[id='billing_phone']")
    private WebElement billingPhoneInputField;

    @FindBy(css = "[id='billing_country_field']>.select2-container>a")
    private WebElement billingDropDownCountryList;

    @FindBy(css = "[id='s2id_autogen1_search']")
    private WebElement billingCountryInputField;

    @FindBy(css = "[id='billing_address_1']")
    private WebElement billingAddress;

    @FindBy(css = "[id='billing_city']")
    private WebElement billingCity;

    @FindBy(css = "[id='billing_postcode']")
    private WebElement billingPostcode;

    @FindBy(css = "[id='shipping_first_name']")
    private WebElement shippingFirstName;

    @FindBy(css = "[id='shipping_last_name']")
    private WebElement shippingLastName;

    @FindBy(css = "[id='shipping_country_field']>.select2-container>a")
    private WebElement shippingDropDownCountryList;

    @FindBy(css = "[id='s2id_autogen2_search']")
    private WebElement shippingCountryInputField;

    @FindBy(css = "[id='shipping_address_1']")
    private WebElement shippingAddress;

    @FindBy(css = "[id='shipping_postcode']")
    private WebElement shippingPostcode;

    @FindBy(css = "[id='shipping_city']")
    private WebElement shippingCity;

    @FindBy(css = "[id='place_order']")
    private WebElement placeOrderButton;

    @FindBy(css = ".woocommerce-thankyou-order-received")
    private WebElement receivedOrderMessage;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public CheckoutPage clickCheckBoxWithAcceptTerms() {
        scrollUpToHalfOfThePage();
        waitUntilBlockUIDisappear();
        tryToClickAcceptTermsCheckBox();
        waitUntilBlockUIDisappear();
        return this;
    }

    public CheckoutPage typeBillingFirstName(String firstName) {
        billingFirstNameInputField.sendKeys(firstName);
        return this;
    }

    public CheckoutPage typeBillingLastName(String lastName) {
        billingLastNameInputField.sendKeys(lastName);
        return this;
    }

    public CheckoutPage typeBillingEmailAddress(String email) {
        billingEmailAddressInputField.sendKeys(email);
        return this;
    }

    public CheckoutPage typeBillingPhoneNumber(String phoneNumber) {
        billingPhoneInputField.sendKeys(phoneNumber);
        return this;
    }

    public CheckoutPage clickBillingCountryDropDownList() {
        billingDropDownCountryList.click();
        return this;
    }

    public CheckoutPage typeBillingCountry(String country) {
        billingCountryInputField.sendKeys(country, Keys.RETURN);
        return this;
    }

    public CheckoutPage typeBillingAddress(String address) {
        billingAddress.sendKeys(address);
        return this;
    }

    public CheckoutPage typeBillingCity(String city) {
        billingCity.sendKeys(city);
        return this;
    }

    public CheckoutPage typeBillingPostcode(String postcode) {
        billingPostcode.sendKeys(postcode);
        return this;
    }

    public CheckoutPage typeShippingFistName(String name) {
        shippingFirstName.sendKeys(name);
        return this;
    }

    public CheckoutPage typeShippingLastName(String lastName) {
        shippingLastName.sendKeys(lastName);
        return this;
    }

    public CheckoutPage clickShippingCountryDropDownList() {
        shippingDropDownCountryList.click();
        return this;
    }

    public CheckoutPage typeShippingCountry(String country) {
        shippingCountryInputField.sendKeys(country, Keys.RETURN);
        return this;
    }

    public CheckoutPage typeShippingAddress(String address) {
        shippingAddress.sendKeys(address);
        return this;
    }

    public CheckoutPage typeShippingPostcode(String postcode) {
        shippingPostcode.sendKeys(postcode);
        return this;
    }

    public CheckoutPage typeShippingCity(String city) {
        shippingCity.sendKeys(city);
        return this;
    }

    public CheckoutPage clickPlaceOrderButton() {
        waitUntilBlockUIDisappear();
        waitUntillElementIsClickable(placeOrderButton);
        placeOrderButton.click();
        return this;
    }

    public String getReceivedOrderMessage() {
        waitUntillElementIsVisible(receivedOrderMessage);
        return receivedOrderMessage.getText();
    }

    public void tryToClickAcceptTermsCheckBox() {
        RetryPolicy retryPolicy = new RetryPolicy()
                .retryOn(WebDriverException.class)
                .withDelay(4, TimeUnit.SECONDS)
                .withMaxRetries(5);
        Failsafe.with(retryPolicy).run(() -> checkBoxTerms.click());
    }

}
