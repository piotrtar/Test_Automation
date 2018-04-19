package com.sii.Pages.Demoqa;

import com.sii.Utilities.WebElementManipulator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SideMenuBarPage extends WebElementManipulator {

    @FindBy(css = "a[href='http://demoqa.com/sortable/']")
    private WebElement sortableButton;

    @FindBy(css = "a[href='http://demoqa.com/autocomplete/']")
    private WebElement autocompleteButton;

    @FindBy(css = "a[href='http://demoqa.com/datepicker/']")
    private WebElement datepickerButton;

    @FindBy(css = "a[href='http://demoqa.com/tooltip/']")
    private WebElement tooltipButton;

    public SideMenuBarPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public SideMenuBarPage goToSortablePage() {
        waitUntillElementIsClickable(sortableButton);
        sortableButton.click();
        return this;
    }

    public SideMenuBarPage goToAutocompletePage() {
        waitUntillElementIsClickable(autocompleteButton);
        autocompleteButton.click();
        return this;
    }

    public SideMenuBarPage goToDatepickerPage() {
        waitUntillElementIsClickable(datepickerButton);
        datepickerButton.click();
        return this;
    }

    public SideMenuBarPage goToTooltipPage() {
        waitUntillElementIsClickable(tooltipButton);
        tooltipButton.click();
        return this;
    }

}
