package com.sii.Pages.Demoqa;

import com.sii.Utilities.WebElementManipulator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

public class SortablePage extends WebElementManipulator {

    private List<WebElement> shuffledItems;
    private List<WebElement> actualShuffledItemsOnPage;

    @FindBys(@FindBy(css = "[id='sortable']>li"))
    private List<WebElement> items;

    public SortablePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public SortablePage loadAndShuffleItemsList() {
        shuffledItems = new ArrayList<>(items);
        Collections.shuffle(shuffledItems);
        return this;
    }

    public List<WebElement> getShuffledItemsList() {
        return shuffledItems;
    }

    public List<WebElement> getItemsList() {
        return items;
    }

    public SortablePage shuffleItemsOnPage() {
        List<WebElement> items = getItemsList();
        List<WebElement> shuffledItems = getShuffledItemsList();
        int counter = 0;
        for (WebElement item : shuffledItems) {
            int targetLocationY = items.get(counter).getLocation().y;
            int actualLocationY = item.getLocation().y;
            int differenceLocationY = targetLocationY - actualLocationY;
            dragAndDropToPlace(item, differenceLocationY);
            counter++;
        }
        System.out.println("Shuffling done \n");
        return this;
    }

    public List<WebElement> getActualItemsOnPage() {
        actualShuffledItemsOnPage = driver.findElements(By.cssSelector("[id='sortable']>li"));
        return actualShuffledItemsOnPage;
    }

}
//        Item 1 - (397, 339)
//        Item 2 - (397, 372)
//        Item 3 - (397, 405)
//        Item 4 - (397, 438)
//        Item 5 - (397, 471)
//        Item 6 - (397, 504)
//        Item 7 - (397, 537)
