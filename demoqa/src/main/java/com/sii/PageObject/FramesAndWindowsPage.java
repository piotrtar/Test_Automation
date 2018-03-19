package com.sii.PageObject;

import com.sii.Utilities.WebElementManipulator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramesAndWindowsPage extends WebElementManipulator {

    @FindBy(css="a[href='#'][target='_blank']")
    WebElement link;

    public FramesAndWindowsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public FramesAndWindowsPage clickOnLink() {
        this.link.click();
        return this;
    }
}
