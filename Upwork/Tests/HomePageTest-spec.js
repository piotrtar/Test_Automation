//HomePageTest-spec.js

//This test tests if user is on correct page after going to https://www.upwork.com/ -
//and after clicking in "AngularJS Developers" in section - 
//"BROWSE TOP SKILLS" if user is in correct subpage.
const MainPage = require("../Pages/MainPage");
const HirePage = require("../Pages/HirePage");

let mainPage;
const url = browser.params.HomeURL;
const jobType = browser.params.JobType;
const expectedText = browser.params.expectedTextOnHirePage;
const pageTitle = browser.params.PageTitle;

beforeAll(function () {
    browser.get(url);
    mainPage = new MainPage();
    hirePage = new HirePage();
});

describe("Checks Home page and go to the job description subpage", function () {

    it("Should have correct title", function () {
        expect(browser.getTitle()).toEqual(pageTitle);
    });

    it("Should select Job Type from the dropdown search list", function () {
        mainPage.clickDropDownArrow()
        .then(() => mainPage.clickFindFreelancers())
        .then(() => expect(mainPage.getPlaceHolderText()).toEqual(jobType));
    });

    it('Should be on the angularjs-developers subpage', function () {
        mainPage.clickAngularDeveloperSkill()
        .then(() => expect(hirePage.getHeadlineLowerText()).toContain(expectedText));
    });

});