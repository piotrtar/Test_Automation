package com.sii.PageObjectTest;

import com.sii.BaseTest.TestBase;
import com.sii.PageObject.DroppablePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DroppablePageTest extends TestBase {

    private DroppablePage droppablePage;

    @BeforeTest
    public void setUpPage() {
        droppablePage = new DroppablePage(driver);
    }

    @Test
    public void testDroppableAction() {
//        menuController.waitUntillClickable("a[href='http://demoqa.com/droppable/']");
        menuController.goToDroppAblePage().waitFor(5);
        droppablePage.dragAndDropElement();

        String expected = "Dropped!";
        String actual = driver.findElement(By.id("droppableview")).getText();
        Assert.assertEquals(expected, actual);
    }


}