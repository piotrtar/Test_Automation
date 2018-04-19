package com.sii.BaseTest;

import com.sii.Factory.DriverFactory;
import com.sii.Helpers.DriverType;
import com.sii.Pages.Demoqa.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class TestBaseDemoqa {

    protected WebDriver driver;
    protected SideMenuBarPage sideMenuBarPage;
    protected AutocompletePage autocompletePage;
    protected TooltipPage tooltipPage;
    protected DatepickerPage datepickerPage;
    protected SortablePage sortablePage;


    @BeforeTest
    public void setUp() {
        driver = DriverFactory.getWebDriver(DriverType.CHROME);
        driver.get("http://demoqa.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        sideMenuBarPage = new SideMenuBarPage(driver);
        autocompletePage = new AutocompletePage(driver);
        tooltipPage = new TooltipPage(driver);
        datepickerPage = new DatepickerPage(driver);
        sortablePage = new SortablePage(driver);
    }

    @AfterTest
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}
