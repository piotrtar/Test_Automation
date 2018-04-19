package com.sii.PageObjectTest;

import com.sii.BaseTest.TestBaseShopDemoqa;
import com.sii.Models.Order;
import com.sii.Pages.ProductPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class SliderTest extends TestBaseShopDemoqa {

    private ProductPage productPage;
    private Order order;
    private ArrayList<Float> filteredProductPrices;

    @BeforeMethod
    public void goToProductPage() {
        topMenuPage.goToWomanJacketsPage().waitFor(5);
        productPage = new ProductPage(driver);
        order = new Order();
    }

    @Test
    public void checkTheAmountOfProductsAfterUsingSlider() throws InterruptedException {
        productPage.moveLeftSliderByNumber(20)
                    .moveRightSliderByNumber(30)
                    .clickFilterButton();
        checkIfProductPricesAreValid();

    }

    public void checkIfProductPricesAreValid() {
        Float minPrice = productPage.getMinFilerPrice();
        Float maxPrice = productPage.getMaxFilterPrice();
        System.out.println("expected minPrice- " + minPrice);
        System.out.println("expected maxPrice- " + maxPrice);

        filteredProductPrices = productPage.loadFilteredProductsPrices();
        int counter = 0;
        for (Float productPrice : filteredProductPrices) {
            Float actualPrice = productPrice;
            System.out.println("actualProductPrice - " + actualPrice);
            boolean isActualPriceInRange = checkIfPriceIsInRange(actualPrice, minPrice, maxPrice);
            assertEquals(isActualPriceInRange, true);
            counter ++;
        }
    }

    public boolean checkIfPriceIsInRange(Float actualPrice, Float minPrice, Float maxPrice) {

        if (actualPrice > minPrice && actualPrice < maxPrice) {
            return true;
        } else {
            return false;
        }
    }
}
