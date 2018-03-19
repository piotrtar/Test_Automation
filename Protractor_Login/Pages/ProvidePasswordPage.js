const ProvidePasswordPage = function() {
//@MichalOzi - co za kosmos ten css :)
    const passwordField = element(by.css("div.fZA7Dc>div.Tyc9J>div.oJeWuf>div.Wic03c>div.Xb9hP>input.zHQkBf"));
    const nextButton = element(by.className('CwaK9'));

    //@MichalOzi - nie jest to funkcja tego page do przeniesienia
    this.waitForElementToBeVisible = (element) => {
        return browser.wait(ExpectedConditions.visibilityOf(element), browser.params.Shortwait);        
    }

    this.findPasswordField = () => {
        this.waitForElementToBeVisible(passwordField);
        return passwordField.isPresent();
    };

    this.fillPasswordField = (password) => {
        return passwordField.sendKeys(password);
    };

    this.clickNextButton = () => {
        this.waitForElementToBeVisible(nextButton);      
        return nextButton.click();
    };

};

module.exports = ProvidePasswordPage;