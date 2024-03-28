package ourvirtualmarket.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import ourvirtualmarket.pages.CheckoutPage;
import ourvirtualmarket.pages.ProductReturnsPage;
import ourvirtualmarket.utilities.Driver;

import java.util.List;

public class ProductReturnsStepDefs {
    CheckoutPage checkoutPage = new CheckoutPage();
    ProductReturnsPage productReturnsPage = new ProductReturnsPage();
    @Given("The user puts {string} into his or her shopping cart")
    public void the_user_puts_into_his_or_her_shopping_cart(String productName) {
       checkoutPage.addProductToCart(productName);
    }
    @Given("The user clicks Contınue button and completes the purchase")
    public void the_user_clicks_contınue_button_and_completes_the_purchase() {
        checkoutPage.continueButtonInSuccessShop.click();
    }
    @Given("The user goes to end of the home page")
    public void the_user_goes_to_end_of_the_home_page() {

    }
    @Then("The user should verify that the two Returns and Orders and Returns links are visible at the bottom of the page")
    public void the_user_should_verify_that_the_and_links_are_visible_at_the_bottom_of_the_page() {
    productReturnsPage.verifyReturnsButtonsIsVisible();
    }
    @Then("The user clicks on the Returns button and should navigate to Product Returns page")
    public void the_user_clicks_on_the_returns_button_and_should_navigate_to_product_returns_page() {
    productReturnsPage.navigateToProductReturnPage();
    productReturnsPage.verifyNavigateToProductReturnPage();
    }
    @Then("The user should Verify that First Name , Last Name, and E-Mail fields are automatically filled with the customer's information.")
    public void the_user_should_verify_that_first_name_last_name_and_e_mail_fields_are_automatically_filled_with_the_customer_s_information() {
    productReturnsPage.getCustomerInformationAndVerifyWithFormInfo("email");
    productReturnsPage.getCustomerInformationAndVerifyWithFormInfo("firstname");
    productReturnsPage.getCustomerInformationAndVerifyWithFormInfo("lastname");
    }

    @Then("The user should click on the Submit button.")
    public void the_user_should_click_on_the_submit_button() {
    productReturnsPage.clickSubmitButtonFromReturns();
    }
    @Then("The user should fill in all necessary information correctly")
    public void the_user_should_fill_in_all_necessary_information_correctly() {
    productReturnsPage.fillInAllNecessaryInformationFromReturnsForm();

    }

    @Then("The user should verify the message {string}")
    public void the_user_should_verify_the_message(String expectedMessage) {
    productReturnsPage.verifySuccessFormMessage(expectedMessage);
    }


    @And("The user should choose reason for return {string}")
    public void theUserShouldChooseReasonForReturn(String options) {
        productReturnsPage.clickRadioButton(options);
    }
}
