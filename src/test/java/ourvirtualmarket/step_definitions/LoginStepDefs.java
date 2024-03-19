package ourvirtualmarket.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ourvirtualmarket.pages.LoginPage;
import ourvirtualmarket.pages.RegisterPage;
import ourvirtualmarket.utilities.ConfigurationReader;
import ourvirtualmarket.utilities.Driver;

public class LoginStepDefs {
    LoginPage loginPage = new LoginPage();
    @Given("The user is on the home page")
    public void the_user_is_on_the_home_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }
    @Given("The user closes the pop-up")
    public void the_user_closes_the_pop_up() {
        loginPage.closePopUp();
    }
    @Then("The user should see the login button at the top right corner")
    public void the_user_should_see_the_login_button_at_the_top_right_corner() {
        loginPage.verifyLoginButtonHomePage();
    }
    @When("The user clicks on the login button on the home page")
    public void the_user_clicks_on_the_login_button_on_the_home_page() {
        loginPage.clickLoginButton();
    }
    @Then("The user should see the {string} pop-up")
    public void the_user_should_see_the_pop_up(String string) throws InterruptedException {
        loginPage.verifyPopUp(string);
    }
    @Then("The user should see the email address bar")
    public void the_user_should_see_the_email_address_bar() {
        loginPage.verifyEmailBar();
    }
    @Then("The user should see the password bar")
    public void the_user_should_see_the_password_bar() {
        loginPage.verifyPasswordBar();
    }
    @Then("The user should see the {string} bar with options such as google, Facebook, Twitter, LinkedIn")
    public void the_user_should_see_the_bar_with_options_such_as_google_facebook_twitter_linked_in(String string) {
        loginPage.verifySocialMediaButtons(string);
    }
    @Then("The user should see the Login button")
    public void the_user_should_see_the_login_button() {
        loginPage.verifyLoginButton();
    }
    @Then("The user should see the {string} button")
    public void the_user_should_see_the_button(String string) {
        loginPage.verifyCreateAnAccountButton(string);
    }
    @Then("The user should see the exit button at the top right corner")
    public void the_user_should_see_the_exit_button_at_the_top_right_corner() {
        loginPage.verifyExitButton();
    }
    @When("The user provides valid credentials")
    public void the_user_provides_valid_credentials() {
        loginPage.login();
    }
    @Then("The user should be able to log in")
    public void the_user_should_be_able_to_log_in() {
        loginPage.verifySuccessLogin();
    }
}
