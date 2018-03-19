package com.sii.Controller;


import com.sii.Utilities.WebElementManipulator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MenuController extends WebElementManipulator {

    @FindBy(css="a[href='http://demoqa.com/registration/']")
    WebElement registrationButton;

    @FindBy(css="a[href='http://demoqa.com/droppable/']")
    WebElement droppableButton;

    @FindBy(css="a[href='http://demoqa.com/frames-and-windows/']")
    WebElement framesAndWindowsButton;


    public MenuController(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MenuController goToRegistrationPage() {
        registrationButton.click();
        return this;
    }

    public MenuController goToDroppAblePage() {
        droppableButton.click();
        return this;
    }

    public MenuController goToFramesAnWindows() {
        framesAndWindowsButton.click();
        return this;
    }
}
