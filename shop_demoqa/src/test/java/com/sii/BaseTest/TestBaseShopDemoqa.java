package com.sii.BaseTest;

import com.sii.Factory.DriverFactory;
import com.sii.Helpers.DriverType;
import com.sii.Models.Order;
import com.sii.Pages.CartPage;
import com.sii.Pages.CheckoutPage;
import com.sii.Pages.TopMenuPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class TestBaseShopDemoqa {

    protected WebDriver driver;
    protected TopMenuPage topMenuPage;
    protected CartPage cartPage;
    protected CheckoutPage checkoutPage;

    @BeforeTest
    public void setUp() {
        driver = DriverFactory.getWebDriver(DriverType.CHROME);
        driver.get("http://shop.demoqa.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        topMenuPage = new TopMenuPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @AfterTest
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}
