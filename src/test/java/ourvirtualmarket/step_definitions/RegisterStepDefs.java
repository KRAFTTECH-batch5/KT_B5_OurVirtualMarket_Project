package ourvirtualmarket.step_definitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ourvirtualmarket.pages.RegisterPage;
import ourvirtualmarket.utilities.ConfigurationReader;
import ourvirtualmarket.utilities.Driver;

public class RegisterStepDefs {
    RegisterPage registerPage=new RegisterPage();
    @Given("User is on the home page")
    public void user_is_on_the_home_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }
    @When("User closes the subscribe popup")
    public void user_closes_the_subscribe_popup() {
        registerPage.closePopUp();
    }
    @When("User navigates to registration page")
    public void user_navigates_to_registration_page() {
        registerPage.navigateToRegisterPage();
    }
    @When("User fills form and clicks continue")
    public void user_fills_form_and_clicks_continue() {
        registerPage.fillForm();
    }
    @Then("User should be able to create a new account")
    public void user_should_be_able_to_create_a_new_account() {
       registerPage.verifySuccessAccountCreation();
    }
    @When("User fills form with {string}, {string},{string}, {string}, {string}, {string}, {string}")
    public void user_fills_form_with(String firstName, String lastName, String email, String telNumber, String password, String passwordConfirm, String privacy) {
      //for conversion string parameter to boolean variable
        boolean pri = false;
       if (privacy.equals("true")){
            pri=true;
       } else if (privacy.equals("false")) {
           pri=false;
       }
        registerPage.fillForm(firstName,lastName,email,telNumber,password,passwordConfirm,pri);
    }
    @Then("User verifies that error messages is displayed")
    public void user_verifies_that_error_messages_is_displayed() {
        registerPage.verifyBlankEntryErrorMessages();
    }
}
