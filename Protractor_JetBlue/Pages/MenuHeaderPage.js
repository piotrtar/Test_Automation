const Helper = require("../Helpers/Helper");

const MenuHeaderPage = function () {
    //declaring the fields = elements on the page
    const logoButton = element(By.css("a.jbLogo.logo"));
    const firstHeaderButton = element(By.xpath("//*[@class='first submenu']/a"));
    const flightsButton = element(By.xpath("//*[@class='plan-a-trip-submenu']/ul/li[1]/a"));

    this.clickLogoButton = () => {
        return Helper.waitForElementToBeClickable(logoButton)
            .then(() => logoButton.click());
    }


    //This method move the cursor to the firstHeaderButton
    this.dropPlanATripButton = () => {
        return browser.actions().
        mouseMove(firstHeaderButton).
        perform();
    }

    //This method waits for the dropdown menu to drop and if element flightsButton
    //will be clickable, then it clicks it   
    this.clickFlightButton = () => {
        return Helper.waitForElementToBeClickable(flightsButton)
                .then(() => flightsButton.click());
    }
}

module.exports = new MenuHeaderPage();