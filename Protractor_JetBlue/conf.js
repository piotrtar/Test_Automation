let SpecReporter = require('jasmine-spec-reporter').SpecReporter;
let AllureReporter = require('jasmine-allure-reporter');

exports.config = {
    // seleniumAddress: 'http://localhost:4444/wd/hub',

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
        browser.driver.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(5000);
        browser.manage().timeouts().pageLoadTimeout(10000);
        jasmine.getEnv().addReporter(new SpecReporter({
            spec: {
              displayStacktrace: true
            }
        }));
        jasmine.getEnv().addReporter(new AllureReporter({
            resultsDir: 'allure-results'
          }));

        jasmine.getEnv().afterEach(function (done) {
            browser.takeScreenshot().then(function (png) {
                allure.createAttachment('Screenshot', function () {
                    return new Buffer(png, 'base64')
                }, 'image/png')();
                done();
            })
        });
    },

    suites: {
        test1:"./Tests/NonExistTravelTest-spec.js"
    },

    params: require('./Configuration/configurationFile'),

    jasmineNodeOpts: {
        print: function () { }
    }
  };