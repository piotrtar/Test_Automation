package com.sii.Pages;

import com.sii.Utilities.WebElementManipulator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends WebElementManipulator{

    @FindBy(css = "nav>ul#menu-main-menu>li:nth-child(4)>a")
    private WebElement myAccountButton;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage goToMyAccount() {
        this.myAccountButton.click();
        return this;
    }
}
