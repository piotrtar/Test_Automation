package com.sii.PageObjectTest;

import com.sii.BaseTest.TestBase;
import com.sii.PageObject.FramesAndWindowsPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class FramesAndWindowsPageTest extends TestBase {

    private FramesAndWindowsPage framesAndWindowsPage;

    @BeforeTest
    public void framesAndWindowsPageSetUp(){
        framesAndWindowsPage = new FramesAndWindowsPage(driver);
    }

    @Test
    public void testFramesAndWindowsPage() {
        menuController.goToFramesAnWindows().waitFor(10);
        framesAndWindowsPage.clickOnLink().waitFor(15);
    }
}