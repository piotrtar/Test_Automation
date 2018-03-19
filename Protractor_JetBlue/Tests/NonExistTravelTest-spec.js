//NonExistTravelTest-spec.js

//This test checks if user can find non existing flight

var element = require("jasmine").element;

const menuHeaderPage = require("../Pages/MenuHeaderPage");
const flightsPage = require("../Pages/FlightsPage");

const homeUrl = browser.params.HomeURL;
const homePageTitle = browser.params.HomePageTitle;
const flightsPageTitle = browser.params.FlightsPageTitle;
const flightsPageHeader = browser.params.FlightsPageHeader;
const expectedSearchText = browser.params.SearchMsg;
const expectedErrorText = browser.params.ErrorMessage;

const invalidDepartCityMsg = browser.params.InvalidDepartCityMsg;
const invalidArrivalCityMsg = browser.params.InvalidArrivalCityMsg;
const invalidDepartDateMsg = browser.params.InvalidDepartDateMsg;
const invalidReturnDateMsg = browser.params.InvalidReturnDateMsg;
const fromContinent = browser.params.FromContinent;
const fromCity = browser.params.FromCity;
const toContinent = browser.params.ToContinent;
const toCity = browser.params.ToCity;
const departureDate = browser.params.DepartureDate;
const returnDate = browser.params.ReturnDate;


describe("From home page go to subpage and find non existing flight", function () {

    beforeEach(function () {
        browser.get(homeUrl);
        menuHeaderPage.dropPlanATripButton()
            .then(() => menuHeaderPage.clickFlightButton());
    });

    it("Should have correct title", function () {
        expect(browser.getTitle()).toEqual(flightsPageTitle);
    });

    it("Should check all fields validation in Book a flight form", function() {
        let allInvalidInputMessages;
        flightsPage.clickFindItButton()
            .then(() => flightsPage.getListOfInvalidInputMsgs())
            .then( (allAlertMessages) => {
                allInvalidInputMessages = allAlertMessages;
                })
            .then(() => expect(allInvalidInputMessages).toContain(invalidDepartCityMsg))
            .then(() => expect(allInvalidInputMessages).toContain(invalidArrivalCityMsg))
            .then(() => expect(allInvalidInputMessages).toContain(invalidDepartDateMsg))
            .then(() => expect(allInvalidInputMessages).toContain(invalidReturnDateMsg));
    });


    it("Should check 3 fields validation in Book a flight form", function() {
        let allInvalidInputMessages;
        flightsPage.clearTextFromElem()
            .then(() => flightsPage.selectPlaceToFlyFrom(fromContinent, fromCity))
            browser.sleep(2000)
            .then(() => flightsPage.clickFindItButton())
            .then(() => flightsPage.getListOfInvalidInputMsgs())
            .then( (allAlertMessages) => {
                allInvalidInputMessages = allAlertMessages;
                })
            .then(() => expect(allInvalidInputMessages).toContain(invalidArrivalCityMsg))
            .then(() => expect(allInvalidInputMessages).toContain(invalidDepartDateMsg))
            .then(() => expect(allInvalidInputMessages).toContain(invalidReturnDateMsg));
    });

    it("Should check 2 fields validation in Book a flight form", function() {
        let allInvalidInputMessages;
        flightsPage.clearTextFromElem()
            .then(() => flightsPage.selectPlaceToFlyFrom(fromContinent, fromCity))
            .then(() => flightsPage.selectPlaceToFlyTo(toContinent, toCity))
            .then(() => flightsPage.clickFindItButton())
            .then(() => flightsPage.getListOfInvalidInputMsgs())
            .then( (allAlertMessages) => {
                allInvalidInputMessages = allAlertMessages;
                })
            .then(() => expect(allInvalidInputMessages).toContain(invalidDepartDateMsg))
            .then(() => expect(allInvalidInputMessages).toContain(invalidReturnDateMsg));
    });

    it("Should check 1 fields validation in Book a flight form", function() {
        let allInvalidInputMessages;
        flightsPage.clearTextFromElem()
            .then(() => flightsPage.selectPlaceToFlyFrom(fromContinent, fromCity))
            .then(() => flightsPage.selectPlaceToFlyTo(toContinent, toCity))
            .then(() => flightsPage.provideDepartDate(departureDate))            
            .then(() => flightsPage.clickFindItButton())
            .then(() => flightsPage.getListOfInvalidInputMsgs())
            .then( (allAlertMessages) => {
                allInvalidInputMessages = allAlertMessages;
                })
            .then(() => expect(allInvalidInputMessages).toContain(invalidReturnDateMsg));
    });

    // it("Should check filling all fields validation in Book a flight form", function() {
    //     let allInvalidInputMessages;
    //     flightsPage.clearTextFromElem()
    //         .then(() => flightsPage.selectPlaceToFlyFrom(fromContinent, fromCity))
    //         .then(() => flightsPage.selectPlaceToFlyTo(toContinent, toCity))
    //         .then(() => flightsPage.provideDepartDate(departureDate))
    //         .then(() => flightsPage.provideReturnDate(returnDate))
    //         .then(() => flightsPage.clickFindItButton())
    // });

    it("Should fill the Book a flight form and search", function() {
        flightsPage.fillBookFlightForm(fromContinent, fromCity, toContinent, toCity)
            .then(() => flightsPage.provideDepartDate(departureDate))
            .then(() => flightsPage.clickFindItButton())
            .then(() => flightsPage.getSearchMessage())
            .then((messageText) => expect(messageText).toContain(expectedSearchText))
            .then(() => flightsPage.clickOKButton());
    });
    
});