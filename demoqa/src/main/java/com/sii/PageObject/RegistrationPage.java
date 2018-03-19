package com.sii.PageObject;

import com.sii.Utilities.WebElementManipulator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends WebElementManipulator{

    @FindBy(name = "first_name")
    private WebElement firstNameInput;

    @FindBy(name = "last_name")
    private WebElement lastNameInput;

    @FindBy(css = "input[value='single']")
    private WebElement maritalStatusSingle;

    @FindBy(css = "input[value='married']")
    private WebElement maritalStatusMarried;

    @FindBy(css = "input[value='divorced']")
    private WebElement maritalStatusDivorced;

    @FindBy(css = "input[value='dance']")
    private WebElement hobbyDance;

    @FindBy(css = "input[value='reading']")
    private WebElement hobbyReading;

    @FindBy(css = "input[value='cricket']")
    private WebElement hobbyCricket;

    @FindBy(css = "select[id='dropdown_7']")
    private WebElement countrySelect;

    @FindBy(css = "select[id='mm_date_8']")
    private WebElement monthSelect;

    @FindBy(css = "select[id='dd_date_8']")
    private WebElement daySelect;

    @FindBy(css = "select[id='yy_date_8']")
    private WebElement yeatSelect;

    @FindBy(css = "input[id='phone_9']")
    private WebElement numberInput;

    @FindBy(css = "input[id='username']")
    private WebElement userNameInput;

    @FindBy(name = "e_mail")
    private WebElement emailInput;

    @FindBy(id = "description")
    private WebElement descriptionInput;

    @FindBy(css = "input[id='password_2']")
    private WebElement passwordInput;

    @FindBy(css = "input[id='confirm_password_password_2']")
    private WebElement confirmPasswordInput;

    @FindBy(name = "pie_submit")
    private WebElement submitButton;


    public RegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public RegistrationPage launch() {
        driver.get("http://demoqa.com/registration/");
        driver.manage().window().maximize();
        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        this.firstNameInput.sendKeys(firstName);
        return this;
    }

    public RegistrationPage setLastNameInput(String lastNameInput) {
        this.lastNameInput.sendKeys(lastNameInput);
        return this;
    }

    public RegistrationPage markMaritalStatusSingle() {
        this.maritalStatusSingle.click();
        return this;
    }

    public RegistrationPage markMaritalStatusMarried() {
        this.maritalStatusMarried.click();
        return this;
    }

    public RegistrationPage markMaritalStatusDivorced() {
        this.maritalStatusDivorced.click();
        return this;
    }

    public RegistrationPage markHobbyDance() {
        this.hobbyDance.click();
        return this;
    }

    public RegistrationPage markHobbyReading() {
        this.hobbyReading.click();
        return this;
    }

    public RegistrationPage markHobbyCricket() {
        this.hobbyCricket.click();
        return this;
    }

    public RegistrationPage selectCountry(String country) {
        Select select = new Select(this.countrySelect);
        select.selectByVisibleText(country);
        return this;
    }

    public RegistrationPage selectBirthDate(String month, String day, String year) {
        Select selectMonth = new Select(this.monthSelect);
        selectMonth.selectByVisibleText(month);

        Select selectDay = new Select(this.daySelect);
        selectDay.selectByVisibleText(day);

        Select selectYear = new Select(this.yeatSelect);
        selectYear.selectByVisibleText(year);

        return this;
    }

    public RegistrationPage setPhoneNumber(String phoneNumber) {
        this.numberInput.sendKeys(phoneNumber);
        return this;
    }

    public RegistrationPage setUserName(String userName) {
        this.userNameInput.sendKeys(userName);
        return this;
    }

    public RegistrationPage setEmail(String email) {
        this.emailInput.sendKeys(email);
        return this;
    }

    public RegistrationPage setDescription(String description) {
        this.descriptionInput.sendKeys(description);
        return this;
    }

    public RegistrationPage setPassword(String password) {
        this.passwordInput.sendKeys(password);
        return this;
    }

    public RegistrationPage confirmPassword(String password) {
        this.confirmPasswordInput.sendKeys(password);
        return this;
    }

    public RegistrationPage clickSubmitButton() {
        this.submitButton.click();
        return this;
    }

}
