package com.sii.PageObjectTest;

import com.sii.BaseTest.TestBase;
import com.sii.Helpers.NameGenerator;
import com.sii.PageObject.RegistrationPage;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegistrationPageTest extends TestBase{

    private RegistrationPage registrationPage;
    private NameGenerator nameGenerator = new NameGenerator();
    private String userName;
    private String email;


    @BeforeClass
    public void RegistrationPageSetUp(){
        registrationPage = new RegistrationPage(driver);
        userName = nameGenerator.getRandomName();
        email = nameGenerator.getRandomEmail();
    }


    @Test
    public void registerNewUserTest() {
        menuController.goToRegistrationPage().waitFor(5);
        provideValuesInRegistrationForm();
        checkRegistrationComplete();
    }

    @Test
    public void registerExistingUserTest() {
        menuController.goToRegistrationPage().waitFor(5);
        provideValuesInRegistrationForm();
        checkRegistrationFail();

    }

    public void provideValuesInRegistrationForm() {
        registrationPage.setFirstName("TestName")
                .setLastNameInput("TestSurname")
                .markMaritalStatusSingle()
                .markHobbyDance().selectCountry("Poland")
                .selectBirthDate("1", "2", "2000")
                .setPhoneNumber("2234567893")
                .setUserName(userName)
                .setEmail(email)
                .setDescription("Nothing. just doing stuff!")
                .setPassword("abcd1234")
                .confirmPassword("abcd1234")
                .clickSubmitButton();
    }


    public void checkRegistrationComplete() {
        String expected = "Thank you for your registration";
        String actual = driver.findElement(By.className("piereg_message")).getText();
        Assert.assertEquals(expected, actual);
    }

    public void checkRegistrationFail() {
        String expected = ": Username already exists";
        String expected2 = ": E-mail address already exists";
        String actual = driver.findElement(By.className("piereg_login_error")).getText();
        Assert.assertTrue(actual.contains(expected)||actual.contains(expected2));
    }
}
