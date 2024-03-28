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

    @When("The user enters a valid email address in the subscription form and clicks Subscribe button")
    public void the_user_enters_a_valid_email_address_in_the_subscription_form_and_clicks_subscribe_button() {
        loginPage.subscribeTo();
    }
    @Then("The user verifies that message Subscription was successful is displayed")
    public void the_user_verifies_that_message_subscription_was_successful_is_displayed(){
        loginPage.verifySuccessfulSubs();
    }
    @When("The user scrolls down the page to the bottom")
    public void the_user_scrolls_down_the_page_to_the_bottom() {
        loginPage.scrollsDownThePageToTheBottom();
    }
    @Then("The user verifies a subscription option is present")
    public void the_user_verifies_a_subscription_option_is_present() {
        loginPage.verifyBottomSubsIsVisible();
    }
    @When("The user enters the email address {string} previously subscribed and clicks subscribe")
    public void the_user_enters_the_email_address_previously_subscribed_and_clicks_subscribe(String email) {
        loginPage.subscribeToBottomSubs(email);
    }
    @Then("The user verifies that a message saying Email has already exist is displayed")
    public void the_user_verifies_that_a_message_saying_email_has_already_exist_is_displayed() {
        loginPage.verifySameEmailMessage();
    }
    @When("The user does not enter data in the email input box and only clicks the subscribe button")
    public void the_user_does_not_enter_data_in_the_email_input_box_and_only_clicks_the_subscribe_button() {
        loginPage.clickToBottomSubsWithoutEmail();
    }
    @Then("The user verifies that a alert error message saying Email required exist is displayed")
    public void the_user_verifies_that_a_alert_error_message_saying_email_required_exist_is_displayed() {
        loginPage.verifyEmptyEmailAlertMessage();
    }
    @When("The user enters the invalid email {string} in the email input box and clicks the subscribe button")
    public void the_user_enters_the_invalid_email_in_the_email_input_box_and_clicks_the_subscribe_button(String invalidEmail) {
        loginPage.subscribeToBottomSubs(invalidEmail);
    }
    @Then("The user verifies that an error message saying Invalid Email is displayed")
    public void the_user_verifies_that_an_error_message_saying_invalid_email_is_displayed() {
        loginPage.verifyInvalidEmailMessage();
    }


}
