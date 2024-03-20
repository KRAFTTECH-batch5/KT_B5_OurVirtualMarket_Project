package ourvirtualmarket.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ourvirtualmarket.pages.BasePage;
import ourvirtualmarket.pages.LoginPage;
import ourvirtualmarket.utilities.BrowserUtils;
import ourvirtualmarket.utilities.ConfigurationReader;
import ourvirtualmarket.utilities.Driver;

public class GetNewsLetterStepDefs {

    LoginPage loginPage = new LoginPage();
    @Given("The user closes the pop-up without checkbox")
    public void the_user_closes_the_pop_up_without_checkbox() {
        loginPage.closePopUpWithoutCheckbox();
    }
    @Given("The user enters the e-mail and password information and clicks the LOGIN button")
    public void the_user_enters_the_e_mail_and_password_information_and_clicks_the_login_button() {
        loginPage.login("cumlirefyo@gufum.com","emre1234");
    }
    @When("The user clicks to HOME button")
    public void the_user_clicks_to_home_button() {
        loginPage.navigateToHomePage();
    }
    @Then("The user should verify a pop-up message offering to subscribe to the mailing list")
    public void the_user_should_verify_a_pop_up_message_offering_to_subscribe_to_the_mailing_list() {
        loginPage.verifySubsPopUpIsVisible();
    }
    @When("The user clicks on the X close button on the pop-up")
    public void the_user_clicks_on_the_x_close_button_on_the_pop_up() {
        loginPage.closePopUpWithoutCheckbox();
    }
    @Then("The user should verify that the pop-up window disappears")
    public void the_user_should_verify_that_the_pop_up_window_disappears() {
        loginPage.verifySubsPopUpIsNotVisible();
    }
    @Then("The user should be able to continue subscribing using the banner at the bottom")
    public void the_user_should_be_able_to_continue_subscribing_using_the_banner_at_the_bottom() {
        loginPage.verifyBottomSubsIsVisible();
    }

}
