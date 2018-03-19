package com.sii.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WebElementManipulator {

    protected WebDriver driver;
    protected int timeoutInSeconds;


    public WebElementManipulator(WebDriver driver) {

        this.driver = driver;
    }

    public void waitUntillClickable(String locator) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
    }

    public void waitFor(int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }
}
