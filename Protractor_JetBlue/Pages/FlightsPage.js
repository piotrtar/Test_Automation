var element = require("protractor").element;

const Helper = require("../Helpers/Helper");

const FlightsPage = function () {

    const pageTitleText = element(By.xpath("//*[@class='page-title']/h1"));
    const oneWayButton = element(By.xpath("//*[contains(text(),'One-way')]/preceding-sibling::span"));
    const fromButton = element(By.xpath("//input[@id='jbBookerDepart']/../a/span"));
    const fromInputElem = element(By.css('#jbBookerDepart'));
    const ToButton = element(By.xpath("//input[@id='jbBookerArrive']/../a/span"));    
    const departDateInput = element(By.id("jbBookerCalendarDepart"));
    const returnDateInput = element(By.id("jbBookerCalendarReturn"));
    
    const findItButton = element(By.xpath("//*[@class='piejs']"));
    const searchMessage = element(By.xpath("//*[@class='warning_message_container'][1]"));
    const okButton = element(By.xpath("//input[@value='OK']"));
    const errorMessage = element(By.xpath("//table//td[@class='errorText']/p"));
    const listOfInvalidInputMsgs = element.all(by.binding("errorMessage"));


    this.getPageTitleText = () => {
        return  Helper.waitForElementToBeVisible(pageTitleText)
                .then(() => pageTitleText.getText());
    }

    this.selectOneWayBookingFlight = () => {
        return Helper.waitForElementToBeClickable(oneWayButton)
                .then(() => oneWayButton.click());
    }

    this.clearTextFromElem = () => {
        return Helper.waitForElementToBeClickable(fromInputElem)
                .then(() => fromInputElem.clear());
    }

    this.getListOfInvalidInputMsgs = () => {
        return listOfInvalidInputMsgs.getText();
    }

    this.selectPlaceToFlyFrom = (fromContinent, fromCity) => {
        
        const continentFromElem = element(by.xpath("//div[@class='region-list-container']/a[contains(text(), \'" + fromContinent + "\')]"));
        const cityFromElem = element(by.xpath("//ul/li/a[contains(text(), \'" + fromCity + "\')]"));
        return Helper.waitForElementToBeClickable(fromButton)
                .then(() => fromButton.click())
                .then(() => continentFromElem.click())
                .then(() => cityFromElem.click())
    }

    this.selectPlaceToFlyTo = (toContinent, toCity) => {
        const continentToElem = element(by.xpath("//div[@class='region-list-container']/a[contains(text(), \'" + toContinent + "\')]"));
        const cityToElem = element(by.xpath("//ul/li/a[contains(text(), \'" + toCity + "\')]"));
        return Helper.waitForElementToBeClickable(ToButton)
                .then(() => ToButton.click())
                .then(() => continentToElem.click())
                .then(() => cityToElem.click())
    }

    this.provideDepartDate = (departureDate) => {
        return Helper.waitForElementToBeClickable(departDateInput)
                .then(() => departDateInput.sendKeys(departureDate));
    }

    this.provideReturnDate = (returnDate) => {
        return Helper.waitForElementToBeClickable(returnDateInput)
                .then(() => returnDateInput.sendKeys(returnDate));
    }

    this.clickFindItButton = () => {
        return Helper.waitForElementToBeVisible(findItButton)
                .then(() => browser.executeScript("arguments[0].scrollIntoView();", findItButton))
                .then(() => findItButton.click());
    }

    this.fillBookFlightForm = (fromContinent, fromCity, toContinent, toCity) => {
        return this.selectOneWayBookingFlight()
                .then(() => this.selectPlaceToFlyFrom(fromContinent, fromCity))
                .then(() => this.selectPlaceToFlyTo(toContinent, toCity))
                // .then(() => this.provideDepartDate(departureDate))
                // .then(() => this.clickFindItButton());
    }

    this.getSearchMessage = () => {
        return Helper.waitForElementToBeVisible(searchMessage)
                .then(() => searchMessage.getText());
    }

    this.clickOKButton = () => {
        return okButton.click();
    }

    this.getErrorMessage = () => {
        return errorMessage.getText();
    }

}

module.exports = new FlightsPage();