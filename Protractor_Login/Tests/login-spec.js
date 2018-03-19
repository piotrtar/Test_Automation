//@MichalOzi - krótki komentarz w stylu 
//inicialization required page
const MainPage = require('../Pages/MainPage');
const ProvideEmailPage = require('../Pages/ProvideEmailPage');
const ProvidePasswordPage = require('../Pages/ProvidePasswordPage');
const topBarPage = require('../Pages/topBarPage');

let mainPageObj;
let emailPage;
let passwordPage;
let topBarPageObj;

beforeAll(function () {
    mainPageObj = new MainPage();
    emailPage = new ProvideEmailPage();
    passwordPage = new ProvidePasswordPage();
    topBarPageObj = new topBarPage();
});

//@MichalOzi - nazwa sugeruje że się tylko logujesz co jest nie prawdą
// może być coś ogólnego w stylu: base test for gored web page
describe('Login to the goread.io page', function() {
  //@MichalOzi -wywalenie niepotrzebnych enterów by kod nie wyglądał jak szkic  
  
    it('should have correct title and click loginButton', function() {
      //@MichalOzi - podobnie jak u kolegów test powinien najpierw mieć wywołanie, później expect i na tym się kończyć
      // jest na odwrót 
      expect(browser.getTitle()).toEqual(browser.params.PageTitle);
      mainPageObj.clickLoginButton();      
    });
  
    it('should check email field exist, fill it and click nextButton', function() {
      //@MichalOzi - logika testu zostałą w poprzednim test case
        expect(emailPage.findEmailField()).toBe(true);
        emailPage.fillEmailField(browser.params.Email);
        emailPage.clickNextButton();
      });

    it('should check passsword field exist, fill it and click nextButton', function() {
      //@MichalOzi - logika testu zostałą w poprzednim test case
        expect(passwordPage.findPasswordField()).toBe(true);
        passwordPage.fillPasswordField(browser.params.Password);
        passwordPage.clickNextButton();
      });

    it('should be logged in', function () {
        expect(topBarPageObj.emailBoxIsVisible()).toBe(true);
        expect(topBarPageObj.getEmailBoxText()).toEqual(browser.params.Email);
        expect(topBarPageObj.pageHeaderIsVisible()).toEqual(true);
      });

  });