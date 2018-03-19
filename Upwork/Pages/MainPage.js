const WaitHelper = require("../Helpers/WaitHelper");

const MainPage = function () {

    //declaring the fields/variables which are the elements on the page https://www.upwork.com/
    const dropDownSearchFieldArrow = element(by.css("div>span.air-icon-arrow-expand"));
    const searchOptionFindJobs = element(by.css("div.open>ul>li.active>a"));
    const searchOptionFindFreelancers = element(by.css("div.open>ul>li:nth-child(1)>a"));
    const placeHolderHeader = element(by.css("#q"));
    const angularDeveloperSkill = element(by.cssContainingText('.col-md-offset-0>li', 'AngularJS'));
    
    let waitHelper = new WaitHelper();

    this.clickDropDownArrow = () => {
        waitHelper.waitForElementToBeClickable(dropDownSearchFieldArrow);
        return dropDownSearchFieldArrow.click();
    };

    this.clickFindJobsButton = () => {
        return searchOptionFindJobs.click();
    };

    this.clickFindFreelancers = () => {
        return searchOptionFindFreelancers.click();
    };

    this.getPlaceHolderText = () => {
        return placeHolderHeader.getAttribute('placeholder');
    };

    this.clickAngularDeveloperSkill = () => {
        waitHelper.waitForElementToBeClickable(angularDeveloperSkill);        
        return angularDeveloperSkill.click();
    };
};

module.exports = MainPage;