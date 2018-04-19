package com.sii.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebElementManipulator {

    protected WebDriver driver;
    protected final Wait<WebDriver> wait;
    protected int timeoutInSeconds = 40;
    private JavascriptExecutor js;

    public WebElementManipulator(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, timeoutInSeconds);
        js = (JavascriptExecutor) driver;
    }

    public void waitUntillElementIsVisible(WebElement locator) {
        wait.until(ExpectedConditions.visibilityOf(locator));
    }

    public void waitUntillElementIsVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitUntillElementIsClickable(WebElement locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitFor(int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public void moveCursorToElement(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    public void dragAndDropToPlace(WebElement element, int y) {
        Actions actions = new Actions(driver);
        waitUntillElementIsClickable(element);
        actions.dragAndDropBy(element, 0, y).build().perform();
    }


    public void scrollUpToHalfOfThePage() {
        js.executeScript("window.scrollBy(0,-350)", "");
    }

    public void scrollUp() {
        //This will scroll the page till the element is found
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
    }

    public void scrollToElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void waitUntilElementDisapear(String path){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(path)));
    }

    public void waitUntilBlockUIDisappear() {
        try {
            List<WebElement> listOfBlocks = driver.findElements(By.cssSelector("div[class*='blockUI']"));
            for (WebElement e : listOfBlocks) {
                wait.until(ExpectedConditions.invisibilityOf(e));
            }
        } catch (Exception e) {
        }
    }

    public void waitForPageToLoad() {
        wait.until(p -> js.executeScript("return document.readyState").toString().equals("complete"));
    }
}
