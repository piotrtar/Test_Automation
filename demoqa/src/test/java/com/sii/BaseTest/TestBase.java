package com.sii.BaseTest;

import com.sii.Controller.MenuController;
import com.sii.Factory.DriverFactory;
import com.sii.Helpers.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {

    protected WebDriver driver;
    protected MenuController menuController;

    @BeforeTest
    public void setUp() {
        driver = DriverFactory.getWebDriver(DriverType.CHROME);
        driver.get("http://demoqa.com/");
        driver.manage().window().maximize();
        menuController = new MenuController(driver);
    }

    @AfterTest
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}
