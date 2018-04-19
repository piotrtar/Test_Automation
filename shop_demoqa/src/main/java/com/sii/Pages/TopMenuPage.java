package com.sii.Pages;

import com.sii.Utilities.WebElementManipulator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopMenuPage extends WebElementManipulator{

    @FindBy(css = "nav.noo-main-menu>ul>li:nth-child(1)>a")
    private WebElement womanButton;

    @FindBy(css = "nav.noo-main-menu>ul>li:nth-child(2)>a")
    private WebElement manButton;

    @FindBy(css = "nav.noo-main-menu>ul>li:nth-child(3)>a")
    private WebElement homeButton;

    @FindBy(css = "nav.noo-main-menu>ul>li:nth-child(4)>a")
    private WebElement myAccountButton;

    @FindBy(css = "nav.noo-main-menu>ul>li:nth-child(5)>a")
    private WebElement saleButton;

    @FindBy(css = "nav.noo-main-menu>ul>li:nth-child(1)>ul>li:nth-child(2)>ul>li:nth-child(1)")
    private WebElement womanJacketsButton;

    @FindBy(css = ".minicart-total>span")
    private WebElement totalCartPrice;

    @FindBy(css = ".cart-item")
    private WebElement cartIcon;

    @FindBy(css = ".empty-cart")
    private WebElement emptyCartButton;

    public TopMenuPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public TopMenuPage goToLoginRegistrationPage() {
        this.myAccountButton.click();
        return this;
    }

    public TopMenuPage goToWomanPage() {
        this.womanButton.click();
        return this;
    }

    public TopMenuPage goToHomePage() {
        this.homeButton.click();
        return this;
    }

    public TopMenuPage goToSalePage() {
        this.saleButton.click();
        return this;
    }

    public TopMenuPage goToShoppingCartPage() {
        this.cartIcon.click();
        return this;
    }

    public TopMenuPage clickEmptyCartButton() {
        waitUntillElementIsClickable(emptyCartButton);
        this.emptyCartButton.click();
        return this;
    }

    public TopMenuPage goToWomanJacketsPage() {
        moveCursorToElement(womanButton);
        waitUntillElementIsClickable(womanJacketsButton);
        this.womanJacketsButton.click();
        return this;
    }

    public Float getTotalCartPrice() {
        moveCursorToElement(cartIcon);
        return Float.parseFloat(this.totalCartPrice.getText().substring(1));
    }
}
