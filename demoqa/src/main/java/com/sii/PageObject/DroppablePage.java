package com.sii.PageObject;

import com.sii.Utilities.WebElementManipulator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DroppablePage extends WebElementManipulator{

    @FindBy(css = "div#draggableview")
    WebElement elementToDrop;
    @FindBy(css = "div#droppableview")
    WebElement dropArea;

    public DroppablePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public DroppablePage dragAndDropElement() {
        Actions builder = new Actions(driver);
        Action dragAndDrop = builder.clickAndHold(elementToDrop)
                                    .moveToElement(dropArea)
                                    .release(dropArea)
                                    .build();
        dragAndDrop.perform();
        return this;
    }


}
