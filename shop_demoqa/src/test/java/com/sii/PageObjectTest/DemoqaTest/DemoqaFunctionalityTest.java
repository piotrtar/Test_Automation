package com.sii.PageObjectTest.DemoqaTest;

import com.sii.BaseTest.TestBaseDemoqa;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class DemoqaFunctionalityTest extends TestBaseDemoqa {

    private ArrayList<String> filteredTags;
    private String multipleValuesTag = "j";
    private String categoryTag = "a";
    private ArrayList<String> actualCategoriesTags;
    private ArrayList<String> actualCategories;
    private ArrayList<String> expectedCategoriesTags;
    private ArrayList<String> expectedCategories;


    @Test(priority = 1)
    public void checkDefaultFunctionalityOnAutocompletePage() {
        sideMenuBarPage.goToAutocompletePage();
        autocompletePage.sendTextToInputTagField(multipleValuesTag);
        checkIfTagsAreValid();
    }

    @Test(priority = 2)
    public void checkMultipleValuesOnAutocompletePage() throws InterruptedException {
        sideMenuBarPage.goToAutocompletePage();
        autocompletePage.clickMultipleValuesButton()
                        .clickEveryTagFromDropDownListInMultipleValues(multipleValuesTag);

        String expected = "Clojure, Java, JavaScript, ";
        String actual = autocompletePage.getTextFromMultipleValuesInputTagField();

        assertEquals(actual, expected);
    }

    @Test(priority = 3)
    public void checkCategoriesOnAutocompletePage() {
        sideMenuBarPage.goToAutocompletePage();
        autocompletePage.clickCategoriesButton()
                        .sendTextToCategoriesInputField(categoryTag);
        checkIfCategoriesTagsAreValid();
        checkIfCategoriesAreValid();
    }

    @Test(priority = 4)
    public void checkIfToolTipIsValid() {
        sideMenuBarPage.goToTooltipPage();
        String actualToolTipText = tooltipPage.getToolTipText();
        String expectedToolTipText = "We ask for your age only for statistical purposes.";
        assertEquals(actualToolTipText, expectedToolTipText);
    }

    @Test(priority = 5)
    public void checkDefaultFunctionalityDatepickerPage() {
        sideMenuBarPage.goToDatepickerPage();

        String givenDate = "12-Dec-2018";
        datepickerPage.clickDefaultFunctionalityInputField()
                        .selectGivenDateBetter(givenDate);
        String actualDate = datepickerPage.getDefaultFunctionalityInputFieldText(); //Month dd, yyyy
        String actualDateFinal = adjustDateToExpectedFormat(actualDate);
        assertEquals(givenDate, actualDateFinal);
    }

    @Test(priority = 6)
    public void reorderElementsDefaultFunctionalitySortablePage() {
        sideMenuBarPage.goToSortablePage();

        sortablePage.loadAndShuffleItemsList()
                    .shuffleItemsOnPage();
        checkIfItemsAreShuffledCorrectly();
    }

    public void checkIfItemsAreShuffledCorrectly() {
        List<WebElement> actualShuffledItemsOnPage = sortablePage.getActualItemsOnPage();
        List<WebElement> expectedShuffledItemsOnPage = sortablePage.getShuffledItemsList();

        int counter = 0;
        System.out.println("Final result: \n");
        for (WebElement item : actualShuffledItemsOnPage) {
            String actualItem = item.getText();
            String expetedItem = expectedShuffledItemsOnPage.get(counter).getText();
            System.out.println(actualItem);
            assertEquals(actualItem, expetedItem);
            counter++;
        }
    }

    public String adjustDateToExpectedFormat(String date) {
        String temporaryEditedActualDate = date.replaceAll(",", "");
        String[] actualDateParts = temporaryEditedActualDate.split(" ");
        String actualDateFinal = actualDateParts[1] + "-" + actualDateParts[0].substring(0,3) + "-" + actualDateParts[2];
        return actualDateFinal;
    }


    public void checkIfTagsAreValid() {
        filteredTags = autocompletePage.getFilteredTags();
        ArrayList<String> expectedTags = new ArrayList<>(Arrays.asList("Clojure", "Java", "JavaScript"));
        int counter = 0;
        for (String tag : filteredTags) {
            String expected = expectedTags.get(counter);
            String actual = tag;
            System.out.println("expected - " + expected);
            System.out.println("actual - " + actual);
            assertEquals(expected, actual);
            counter ++;
        }
    }

    public void checkIfCategoriesTagsAreValid() {
        actualCategoriesTags = autocompletePage.getFilteredTags();
        expectedCategoriesTags = autocompletePage.getExpectedCategoriesTags();
        int counter = 0;
        for (String tag : actualCategoriesTags) {
            String actualCategoryTag = tag;
            String expectedCategoryTag = expectedCategoriesTags.get(counter);
            System.out.println("actual - " + actualCategoryTag);
            System.out.println("expected - " + expectedCategoryTag);
            assertEquals(actualCategoryTag, expectedCategoryTag);
            counter ++;
        }
    }

    public void checkIfCategoriesAreValid() {
        actualCategories = autocompletePage.getCategories();
        expectedCategories = autocompletePage.getExcpectedCategories();
        int counter = 0;
        for (String category : actualCategories) {
            String actualCategory = category;
            String expectedCategory = expectedCategories.get(counter);
            System.out.println("actual - " + actualCategory);
            System.out.println("expected - " + expectedCategory);
            assertEquals(actualCategory, expectedCategory);
            counter++;
        }
    }
}
