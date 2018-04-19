package com.sii.Pages.Demoqa;

import com.sii.Utilities.WebElementManipulator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TooltipPage extends WebElementManipulator {

    @FindBy(id = "age")
    private WebElement ageTextBoxField;

    @FindBy(css = ".ui-tooltip-content")
    private WebElement toolTipContent;

    public TooltipPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void moveMouseToAgeTexBoxField() {
        waitUntillElementIsClickable(ageTextBoxField);
        Actions action = new Actions(driver);
        action.moveToElement(ageTextBoxField).build().perform();
    }

    public String getToolTipText() {
        moveMouseToAgeTexBoxField();
        return toolTipContent.getText();
    }
}
