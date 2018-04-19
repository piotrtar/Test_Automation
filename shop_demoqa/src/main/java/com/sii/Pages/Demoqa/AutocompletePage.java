package com.sii.Pages.Demoqa;

import com.sii.Utilities.WebElementManipulator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AutocompletePage extends WebElementManipulator {

    private ArrayList<String> filteredTags;
    private ArrayList<String> filteredTagCategories;
    private ArrayList<String> expectedCategories;
    private ArrayList<String> expectedCategoriesTags;

    @FindBy(css = "[id='tabs-1']>div>div>.ui-autocomplete-input")
    private WebElement defaultFunctionalityInputTagField;

    @FindBy(css = "[id='tabs-2']>div>div>.ui-autocomplete-input")
    private WebElement multipleValuesInputTagField;

    @FindBy(css = "[id='tabs-3']>div>.ui-autocomplete-input")
    private WebElement categoriesInputField;

    @FindBys(@FindBy(css = ".ui-menu-item"))
    private List<WebElement> tagList;

    @FindBys(@FindBy(css = "[id=\"ui-id-3\"]>.ui-autocomplete-category"))
    private List<WebElement> tagCategoriesList;

    @FindBy(css = ".ui-tabs-nav>li:nth-child(1)>a")
    private WebElement defaultFunctionalityButton;

    @FindBy(css = ".ui-tabs-nav>li:nth-child(2)>a")
    private WebElement multipleValuesButton;

    @FindBy(css = ".ui-tabs-nav>li:nth-child(3)>a")
    private WebElement categoriesButton;

    public AutocompletePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public AutocompletePage sendTextToInputTagField(String text) {
        waitUntillElementIsClickable(defaultFunctionalityInputTagField);
        defaultFunctionalityInputTagField.click();
        defaultFunctionalityInputTagField.sendKeys(text);
        return this;
    }

    public AutocompletePage sendTextToMultipleValuesInputTagField(String text) {
        waitUntillElementIsClickable(multipleValuesInputTagField);
        multipleValuesInputTagField.sendKeys(text);
        return this;
    }

    public AutocompletePage clickEveryTagFromDropDownListInMultipleValues(String text) throws InterruptedException {
        for (int i = 0 ; i < 3 ; i++) {
            sendTextToMultipleValuesInputTagField(text);
            for (int j = 0; j < i+1; j++) {
                Thread.sleep(300);
                multipleValuesInputTagField.sendKeys(Keys.ARROW_DOWN);
            }
            multipleValuesInputTagField.sendKeys(Keys.ENTER);
        }
        return this;
    }

    public String getTextFromMultipleValuesInputTagField() {
        return multipleValuesInputTagField.getAttribute("value");
    }

    public ArrayList<String> getFilteredTags() {
        filteredTags = new ArrayList<>();

        for (WebElement tag : tagList) {
            String filteredTag = tag.getText();
            filteredTags.add(filteredTag);
        }
        return filteredTags;
    }

    public ArrayList<String> getCategories() {
        filteredTagCategories = new ArrayList<>();

        for (WebElement category : tagCategoriesList) {
            String tagCategory = category.getText();
            filteredTagCategories.add(tagCategory);
        }
        return filteredTagCategories;
    }

    public AutocompletePage clickDefaultFunctionalityButton() {
        waitUntillElementIsClickable(defaultFunctionalityButton);
        defaultFunctionalityButton.click();
        return this;
    }

    public AutocompletePage clickMultipleValuesButton() {
        waitUntillElementIsClickable(multipleValuesButton);
        multipleValuesButton.click();
        return this;
    }

    public AutocompletePage clickCategoriesButton() {
        waitUntillElementIsClickable(categoriesButton);
        categoriesButton.click();
        return this;
    }

    public AutocompletePage sendTextToCategoriesInputField(String text) {
        waitUntillElementIsClickable(categoriesInputField);
        categoriesInputField.sendKeys(text);
        return this;
    }


    public ArrayList<String> getExcpectedCategories() {
        expectedCategories = new ArrayList<>(Arrays.asList("Products", "People"));
        return expectedCategories;
    }

    public ArrayList<String> getExpectedCategoriesTags() {
        expectedCategoriesTags = new ArrayList<>(Arrays.asList("anders",
                                                                "andreas",
                                                                "antal",
                                                                "annhhx10",
                                                                "annk K12",
                                                                "annttop C13",
                                                                "anders andersson",
                                                                "andreas andersson",
                                                                "andreas johnson"));
        return expectedCategoriesTags;
    }

    public List<WebElement> getListOfTags() {
        waitUntillElementIsVisible(By.cssSelector(".ui-menu-item"));
        return driver.findElements(By.cssSelector(".ui-menu-item"));
    }

}
