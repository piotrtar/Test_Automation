let SpecReporter = require('jasmine-spec-reporter').SpecReporter;

exports.config = {
    seleniumAddress: 'http://localhost:4444/wd/hub',

    capabilities: {
        browserName: 'chrome',
        },
        
// To run test on multiple browsers, uncomment ths code
    // multiCapabilities: [
    //     {'browserName': 'chrome'},
    //     {'browserName': 'firefox'},
    //     {'browserName': 'phantomjs'}
    // ],

    onPrepare: function() {
        browser.driver.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(5000);
        browser.manage().timeouts().pageLoadTimeout(10000);
        jasmine.getEnv().addReporter(new SpecReporter({
            spec: {
              displayStacktrace: true
            }
        }));
        },

    // specs: [
    //     // './*/*spec.js'
    //     // './*/HomePageTest-spec.js',
    //     // './*/HirePageTest-spec.js'
    // ],

    suites: {
        test1:"./Tests/HomePageTest-spec.js",
        test2:"./Tests/HirePageTest-spec.js"
    },

    params: require('./Configuration/configurationFile'),

    jasmineNodeOpts: {
        print: function () { }
    }
  };