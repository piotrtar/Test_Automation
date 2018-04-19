package com.sii.Factory;

import com.sii.Helpers.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    private static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();

    public static WebDriver getWebDriver(DriverType browser) {

        WebDriver driver = null;

        switch (browser) {
            case CHROME:
                driver = drivers.get("Chrome");
                if(driver == null) {
                    System.setProperty("webdriver.chrome.driver", "C:/Users/ptarczon/Desktop/Sii Repository/tester03/shop_demoqa/src/main/resources/WebDriver/chromedriver.exe");
                    driver = new ChromeDriver();
                    drivers.put("Chrome", driver);
                }
                break;
            case FIREFOX:
                driver = drivers.get("Firefox");
                if(driver == null) {
                    driver = new FirefoxDriver();
                    drivers.put("Firefox", driver);
                }
                break;
            case IE:
                driver = drivers.get("IE");
                if(driver == null) {
                    driver = new InternetExplorerDriver();
                    drivers.put("IE", driver);
                }
                break;
            default:
                driver = drivers.get("Chrome");
                break;
        }
        return driver;

    }
}
