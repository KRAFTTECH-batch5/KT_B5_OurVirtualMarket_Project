package ourvirtualmarket.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ourvirtualmarket.pages.LoginPage;
import ourvirtualmarket.utilities.ConfigurationReader;
import ourvirtualmarket.utilities.Driver;

public class CurrencyTypes_StepDefs {
    LoginPage loginPage=new LoginPage();
    @Given("the user is logged in with valid credentials")
    public void the_user_is_logged_in_with_valid_credentials() {
        Driver.get().get(ConfigurationReader.get("url"));
        loginPage.closePopUp();
        loginPage.clickLoginButton();
        loginPage.login();
    }
    @When("Default currency must be Dollar")
    public void default_currency_must_be() {
        loginPage.verifytoDollar();
    }
    @When("the user clicks on the currency button")
    public void the_user_clicks_on_the_currency_button() {
        loginPage.clickcurrencybtn();
    }
    @When("selects Euro")
    public void selects_euro() {
     loginPage.clicktoeurobtn();

    }
    @Then("all prices should be displayed in Euro")
    public void all_prices_should_be_displayed_in_euro() {
      loginPage.verifytoeuro();
    }
    @When("selects Pound Sterling")
    public void selects_pound_sterling() {
        loginPage.clicktopoundSterlinbtn();
    }
    @Then("all prices should be displayed in Pound Sterling")
    public void all_prices_should_be_displayed_in_pound_sterling() {
          loginPage.verifytopoundSterlin();
    }
}
