//HirePageTest-spec.js

//This test tests if user is on correct page after going to https://www.upwork.com/hire/angularjs-developers/ -
//and if fields are filled correctly which results in -
//filtering proper developer's profiles.
const HirePage = require("../Pages/HirePage");

let hirePage;
const url = browser.params.HirePageURL;
const expectedHeadLine = browser.params.expectedHeadlineOnHirePage;

// beforeAll(function () {
//     browser.get(url);
//     hirePage = new HirePage();
// });

describe("Checks Hire page and filering the freelancers after filling the data", function () {
    hirePage = new HirePage();
    it("Should have correct HeadLine", function () {
        browser.get(url);  
        expect(hirePage.headlineUpperText()).toContain(expectedHeadLine);
    });

    // it('should change page to hire page', function () {
    //     mainPage.clickAngularJSButton()
    //     .then(() => expect(hirePage.getTextFromMainTitle()).toContain(expectedHeader))
    //     .then(()=> hirePage.clickCountryDropdown())
    //     .then(() => hirePage.chooseCountry())
    //     .then(() => hirePage.clickSuccessJobDropdown())
    //     .then(() => hirePage.chooseSuccessJobOption())
    //     .then(() => hirePage.clickSuccessHourRateDropdown())
    //     .then(() => hirePage.chooseSuccessHourRateOption())
    //     // .then(() => hirePage.goBackToMainPage());
    //   })

});