exports.config = {
    seleniumAddress: 'http://localhost:4444/wd/hub',

    capabilities: {
        browserName: 'chrome',
        'chromeOptions': { 'args': ['incognito'] }
        },
        
// To run test on multiple browsers, uncomment ths code
    // multiCapabilities: [
    //     {'browserName': 'chrome'},
    //     {'browserName': 'firefox'},
    //     {'browserName': 'phantomjs'}
    // ],

    onPrepare: function() {
        browser.ignoreSynchronization = true
        browser.driver.manage().window().maximize();
        //@MichalOzi - browser.get przenieś do pliku testu before all
        //tutaj tylko parametr z url lub w zew pliku tak jak masz
        browser.get(browser.params.HomeURL);
        browser.manage().timeouts().implicitlyWait(5000);
        browser.manage().timeouts().pageLoadTimeout(10000);
        },

    specs: ['./*/*spec.js'],
    params: require('./Configuration/configurationFile')
  };