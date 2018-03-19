const TopBarPage = function() {

  const pageHeader = element(by.css('div.navbar-header>a'));
  const aboutButton = element(by.css('div.navbar-ex1-collapse>ul:nth-child(1)>li:nth-child(1)>a'));
  // const feedsButton = element(by.css('div.navbar-ex1-collapse>ul:nth-child(1)>li:nth-child(2)>a'));
  const feedsButton = element(by.css('div.navbar-ex1-collapse>ul.navbar-nav>li.active>a'));
  const itemsRolledButton = element(by.css('div.navbar-ex1-collapse>ul:nth-child(1)>li:nth-child(3)>a'));
  const markAllReadButton = element(by.css('div.navbar-ex1-collapse>ul:nth-child(1)>li:nth-child(4)>button:nth-child(1)'));
  const refreshButton = element(by.css('div.navbar-ex1-collapse>ul:nth-child(1)>li:nth-child(4)>button:nth-child(2)'));
  const upArrowButton = element(by.css('div.navbar-ex1-collapse>ul:nth-child(1)>li:nth-child(4)>div>button:nth-child(1)'));
  const downArrowButton = element(by.css('div.navbar-ex1-collapse>ul:nth-child(1)>li:nth-child(4)>div>button:nth-child(2)'));
  const viewRolledButton = element(by.css('div.navbar-ex1-collapse>ul:nth-child(1)>li:nth-child(4)>div>a'));

  const emailBoxButton = element(by.css('div.navbar-ex1-collapse>ul.navbar-right>li>a'));
  const logoutButton = element(by.css('ul.navbar-right>li>ul>li:nth-child(7)>a'));
//@MichalOzi - nie jest to funkcja tego page do przeniesienia
  this.waitForElementToBeVisible = (element) => {
    return browser.wait(ExpectedConditions.visibilityOf(element), browser.params.Shortwait);        
  }

  this.emailBoxIsVisible = () => {
    this.waitForElementToBeVisible(emailBoxButton);
    return emailBoxButton.isPresent();
  };

  this.getEmailBoxText = () => {
    return emailBoxButton.getText();
  };

  this.pageHeaderIsVisible = () => {
    this.waitForElementToBeVisible(pageHeader);    
    return pageHeader.isPresent();
  };

  this.clickLogoutButton = () => {
    emailBoxButton.click();
    logoutButton.click();
  };

};

module.exports = TopBarPage;