const ProvideEmailPage = function() {

    const emailField = element(by.id('identifierId'));
    const nextButton = element(by.className('RveJvd snByac'));
//@MichalOzi - to też nie jest funkcjonalność tego paga
// przeniść do pliku np. common.js
    this.waitForElementToBeVisible = (element) => {
        return browser.wait(ExpectedConditions.visibilityOf(element), browser.params.Shortwait);        
    }
    //@MichalOzi - dodać komentarze do każdej metody
    // jak kod przyrośnie mogą się przydać
    this.findEmailField = () => {
        this.waitForElementToBeVisible(emailField);
        return emailField.isPresent();
    };

    this.fillEmailField = (email) => {
        return emailField.sendKeys(email);
    };

    this.clickNextButton = () => {
        this.waitForElementToBeVisible(nextButton);
        return nextButton.click();
    };
};

module.exports = ProvideEmailPage;