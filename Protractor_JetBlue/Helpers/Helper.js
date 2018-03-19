const Helper = function () {

    //declaring the field
    let EC = protractor.ExpectedConditions;
    const time = browser.params.TimeToWaitForElementToBeClickable;

    this.waitForElementToBeClickable = (element) => {
        return browser.wait(EC.elementToBeClickable(element, time));
    };

    this.waitForElementToBeVisible = (element) => {
        return browser.wait(EC.visibilityOf(element, time));
    };
};

module.exports = new Helper();