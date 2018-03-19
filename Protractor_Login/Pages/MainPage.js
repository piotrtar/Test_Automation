const MainPage = function() {
  //@MichalOzi - spoko korzystasz z constant :)
      const loginButton = element(by.css('.btn.btn-primary.btn-lg'));
  //@MichalOzi - taka metoda powinna być w beforeall to nie jest funkcjonalność tego paga
      this.loadPage = (page) => {
        return browser.get(page);
      };
      
      this.clickLoginButton = () => {
        return loginButton.click();
      };
  };
  
  module.exports = MainPage;