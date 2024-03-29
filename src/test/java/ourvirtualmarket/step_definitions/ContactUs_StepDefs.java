package ourvirtualmarket.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ourvirtualmarket.pages.ContactUsPage;

import java.util.Map;

public class ContactUs_StepDefs {
    ContactUsPage contactUsPage = new ContactUsPage();

    @Given("The user logins with valid credentials :")
    public void the_user_logins_with_valid_credentials(Map<String, String> credentials) {
        contactUsPage.login(credentials.get("email"), credentials.get("password"));
    }

    @Given("The user clicks on the home button")
    public void the_user_clicks_on_the_home_button() {
        contactUsPage.clickHomeBtn();
    }

    @When("The user lands on the bottom of the site")
    public void the_user_lands_on_the_bottom_of_the_site() {
        contactUsPage.scrollDownContactUs();
    }

    @When("The user clicks on the Contact Us Button")
    public void the_user_clicks_on_the_contact_us_button() {
        contactUsPage.clickContactUs();
    }

    @Then("The user's name and email should be pre-filled")
    public void the_user_s_name_and_email_should_be_pre_filled() {
        contactUsPage.verifyNameEmail();
    }

    @When("The user submits a complaint message with valid length")
    public void the_user_submits_a_complaint_message_with_valid_length() {
        contactUsPage.inputEnquiry1();
    }

    @Then("The user should see a success message confirming the message has been sent")
    public void the_user_should_see_a_success_message_confirming_the_message_has_been_sent() {
        contactUsPage.verifySuccessMsg1();
    }

    @When("The user sends a complaint message containing fewer than ten characters")
    public void the_user_sends_a_complaint_message_containing_fewer_than_ten_characters() {
        contactUsPage.inputEnquiry2();
    }

    @Then("The user sees fail message")
    public void the_user_sees_fail_message() {
        contactUsPage.verifyFailMsg2();
    }

    @When("The user sends a complaint message containing more than three thousand characters")
    public void the_user_sends_a_complaint_message_containing_more_than_three_thousand_characters() {
        contactUsPage.inputEnquiry3();
    }

}
