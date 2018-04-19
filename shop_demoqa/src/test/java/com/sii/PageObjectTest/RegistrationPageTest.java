package com.sii.PageObjectTest;

import com.sii.BaseTest.TestBaseShopDemoqa;
import com.sii.Factory.UserFactory;
import com.sii.Models.User;
import com.sii.Pages.LoginRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegistrationPageTest extends TestBaseShopDemoqa {

    private User user = UserFactory.getTestUser();
    private LoginRegistrationPage loginRegistrationPage;

    @BeforeClass
    public void RegistrationPageSetUp(){
        loginRegistrationPage = new LoginRegistrationPage(driver);
        topMenuPage.goToLoginRegistrationPage().waitFor(5);
    }

    @Test(priority=1)
    public void registerNewUserTest() throws InterruptedException {
        provideValuesInRegistrationForm();
        checkIfLoginRegistrationSucceeded();
        loginRegistrationPage.clickLogoutButton();
    }

    @Test(priority=2)
    public void registerExistingUserTest() throws InterruptedException {
        topMenuPage.goToLoginRegistrationPage().waitFor(5);
        provideValuesInRegistrationForm();
        registerExistingUser();
    }

    @Test(priority=3)
    public void loginUserTest(){
        topMenuPage.goToLoginRegistrationPage().waitFor(5);
        provideValuesInLoginForm();
        checkIfLoginRegistrationSucceeded();
        checkIfCorrectUserLoggedIn();
        loginRegistrationPage.clickLogoutButton();
    }
    
    public void provideValuesInRegistrationForm() throws InterruptedException {
        loginRegistrationPage.setRegistrationEmail(user.getEmail());
        Thread.sleep(2000);
        loginRegistrationPage.setRegistrationPassword(user.getPassword())
                .clickRegisterButton();
    }

    public void checkIfLoginRegistrationSucceeded(){
        String expected = "Hello";
        String actual = loginRegistrationPage.getWelcomeMessage().getText();
        Assert.assertTrue(actual.contains(expected));
    }

    public void registerExistingUser() {
        String expected = "Error: An account is already registered with your email address. Please login.";
        String actual = loginRegistrationPage.getErrorRegistrationExistingUserMessage().getText();
        Assert.assertTrue(actual.contains(expected));
    }

    public void provideValuesInLoginForm() {
        loginRegistrationPage.provideLoginEmail(user.getEmail());
        loginRegistrationPage.provideLoginPassword(user.getPassword())
                .clickLoginButton();
    }

    public void checkIfCorrectUserLoggedIn() {
        int index = user.getEmail().indexOf("@");
        String expectedUsername = user.getEmail().substring(0,index);
        String actualUsername = loginRegistrationPage.getUserName().getText();
        Assert.assertEquals(expectedUsername, actualUsername);
    }
}
