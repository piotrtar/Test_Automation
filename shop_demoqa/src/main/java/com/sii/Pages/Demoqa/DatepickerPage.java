package com.sii.Pages.Demoqa;

import com.sii.Factory.DateTimeFormatterFactory;
import com.sii.Utilities.WebElementManipulator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DatepickerPage extends WebElementManipulator {

    private DateTimeFormatter formatter = DateTimeFormatterFactory.getDateTimeFormatter();

    @FindBy(css = ".ui-tabs-nav>li:nth-child(1)>a")
    private WebElement defaultFunctionalityButton;

    @FindBy(css = ".ui-tabs-nav>li:nth-child(3)>a")
    private WebElement displayMonthAndYearButton;

    @FindBy(css = "[id='tabs-1']>div>p>.hasDatepicker")
    private WebElement defaultFunctionalityInputField;

    @FindBy(css = ".ui-datepicker-month")
    private WebElement defaultFunctionalityMonth;

    @FindBy(css = ".ui-datepicker-year")
    private WebElement defaultFunctionalityYear;

    @FindBy(xpath = "//*[@title='Previous']")
    private WebElement previousMonthButton;

    @FindBy(xpath = "//*[@title='Next']")
    private WebElement nextMonthButton;

    @FindBy(css = "[class='ui-state-default ui-state-highlight']")
    private WebElement todayDay;

    @FindBys(@FindBy(css = "[class='ui-state-default']"))
    private List<WebElement> daysInMonthList;

    public DatepickerPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public DatepickerPage clickDisplayMonthAndYearButton() {
        waitUntillElementIsClickable(displayMonthAndYearButton);
        displayMonthAndYearButton.click();
        return this;
    }

    public DatepickerPage clickDefaultFunctionalityInputField() {
        waitUntillElementIsClickable(defaultFunctionalityInputField);
        defaultFunctionalityInputField.click();
        return this;
    }

    public String getDefaultFunctionalityMonth() {
        return defaultFunctionalityMonth.getText();
    }

    public String getDefaultFunctionalityYear() {
        return defaultFunctionalityYear.getText();
    }

    public void clickNextMonthButton() {
        waitUntillElementIsClickable(nextMonthButton);
        nextMonthButton.click();
    }

    public void clickPreviousMonthButton() {
        waitUntillElementIsClickable(previousMonthButton);
        previousMonthButton.click();
    }

    public DatepickerPage selectGivenDateBetter(String date) {

        LocalDate givenDate = LocalDate.parse(date, formatter);

        int givenDay = givenDate.getDayOfMonth();
        int actualYear = Integer.parseInt(driver.findElement(By.cssSelector(".ui-datepicker-year")).getText());
        String actualMonth = driver.findElement(By.cssSelector(".ui-datepicker-month")).getText();
        int actualMonthInt = Month.valueOf(actualMonth.toUpperCase()).getValue();

        YearMonth givenYearMonth = YearMonth.from(givenDate);
        YearMonth actualYearMonth = YearMonth.of(actualYear, actualMonthInt);

        if (givenYearMonth.isBefore(actualYearMonth)) {
            while (!givenYearMonth.equals(getActualYearMonth())) {
                waitUntillElementIsClickable(previousMonthButton);
                clickPreviousMonthButton();
                defaultFunctionalityMonth.click();
            }
        } else if (givenYearMonth.isAfter(actualYearMonth)) {
            while (!givenYearMonth.equals(getActualYearMonth())) {
                waitUntillElementIsClickable(nextMonthButton);
                clickNextMonthButton();
                defaultFunctionalityMonth.click();
            }
        }
        WebElement selectedDay = daysInMonthList.get(givenDay - 1);
        waitUntillElementIsClickable(selectedDay);
        selectedDay.click();
        return this;
    }

    public YearMonth getActualYearMonth() {
        return YearMonth.of(Integer.parseInt(driver.findElement(By.cssSelector(".ui-datepicker-year")).getText()),
                Month.valueOf(driver.findElement(By.cssSelector(".ui-datepicker-month")).getText().toUpperCase()).getValue());
    }


    public String getDefaultFunctionalityInputFieldText() {
        return defaultFunctionalityInputField.getAttribute("value");
    }

}
