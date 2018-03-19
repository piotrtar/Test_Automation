
const WaitHelper = require("../Helpers/WaitHelper");

const HirePage = function () {

    //declaring the fields/variables which are the elements on the page https://www.upwork.com/hire/angularjs-developers/
    const head_line_Upper_Text = element(by.cssContainingText('h1.font-gotham-bold', 'AngularJS'));
    const head_line_Lower_Text = element(by.cssContainingText('h1.font-gotham-bold', 'Hire'));
    const field_main_mainTitle = element(by.css('h1.font-gotham-bold'));
    const button_main_mainLocationBar = element(by.css('a.ng-scope>span:nth-child(3)'));
    const input_main_locationBar = element(by.css('div.select2-drop-active>ul>li>ul>li:nth-child(13)'));
    const button_main_mainSuccessJobBar = element(by.css('div>div:nth-child(2)>div>div>button.dropdown-toggle>span:nth-child(2)'));
    const input_main_successJobBar = element(by.css('div.open>ul>li:nth-child(1)>a'));
    const button_main_mainHourRateBar = element(by.css('div>div:nth-child(3)>div>div>button.dropdown-toggle>span:nth-child(2)'));
    const input_main_hourRateBar = element(by.css('div.open>ul.ng-scope>li:nth-child(5)>a'));

    const country = browser.params.Country;
    const button_main_backToMainPage = element(by.css('a.logo>img'));
    
    let waitHelper = new WaitHelper();

    this.clickAngularDeveloperSkill = () => {
        waitHelper.waitForElementToBeClickable(angularDeveloperSkill);        
        return angularDeveloperSkill.click();
    };

    this.getHeadlineLowerText = () => {
        return head_line_Lower_Text.getText();
    };

    this.headlineUpperText = () => {
        return head_line_Upper_Text.getText();
    }
};

module.exports = HirePage;