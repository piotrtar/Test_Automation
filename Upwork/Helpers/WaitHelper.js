const WaitHelper = function () {

    //declaring the field
    let EC = protractor.ExpectedConditions;
    const time = browser.params.Time_to_wait_for_element_to_be_clickable;

    this.waitForElementToBeClickable = (element) => {
        return browser.wait(EC.elementToBeClickable(element, time));
    };
};

module.exports = WaitHelper;