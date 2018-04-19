package com.sii.Pages;

import com.sii.Utilities.WebElementManipulator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginRegistrationPage extends WebElementManipulator{

    @FindBy(css = "#reg_email")
    private WebElement emailInput;

    @FindBy(css = "#reg_password")
    private WebElement passwordInput;

    @FindBy(css = "#username")
    private WebElement userNameLogin;

    @FindBy(css = "#password")
    private WebElement passwordLogin;

    @FindBy(css = "input[name='register']")
    private WebElement registerButton;

    @FindBy(css = "input[name='login']")
    private WebElement loginButton;

    @FindBy(css = "div.woocommerce-MyAccount-content>p:nth-child(1)>a")
    private WebElement logoutButton;

    @FindBy(css = "div.woocommerce-MyAccount-content>p")
    private WebElement welcomeMessage;

    @FindBy(css = ".woocommerce-error>li")
    private WebElement errorRegistrationExistingUserMessage;

    @FindBy(css = "div.woocommerce-MyAccount-content>p>strong")
    private WebElement userName;

    public LoginRegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LoginRegistrationPage setRegistrationEmail(String registrationEmail) {
        this.emailInput.sendKeys(registrationEmail);
        return this;
    }

    public LoginRegistrationPage setRegistrationPassword(String registrationPassword) {
        this.passwordInput.sendKeys(registrationPassword);
        return this;
    }

    public LoginRegistrationPage provideLoginEmail(String loginEmail) {
        this.userNameLogin.sendKeys(loginEmail);
        return this;
    }

    public LoginRegistrationPage provideLoginPassword(String loginPassword) {
        this.passwordLogin.sendKeys(loginPassword);
        return this;
    }

    public LoginRegistrationPage clickRegisterButton() {
        this.registerButton.click();
        return this;
    }

    public LoginRegistrationPage clickLoginButton() {
        this.loginButton.click();
        return this;
    }

    public LoginRegistrationPage clickLogoutButton() {
        this.logoutButton.click();
        return this;
    }

    public WebElement getWelcomeMessage() {
        waitUntillElementIsVisible(welcomeMessage);
        return welcomeMessage;
    }

    public WebElement getErrorRegistrationExistingUserMessage() {
        waitUntillElementIsVisible(errorRegistrationExistingUserMessage);
        return errorRegistrationExistingUserMessage;
    }

    public WebElement getUserName() {
        return userName;
    }
}
