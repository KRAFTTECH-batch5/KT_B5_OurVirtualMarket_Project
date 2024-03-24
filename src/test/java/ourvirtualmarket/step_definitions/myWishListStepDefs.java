package ourvirtualmarket.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ourvirtualmarket.pages.LoginPage;
import ourvirtualmarket.utilities.ConfigurationReader;
import ourvirtualmarket.utilities.Driver;

public class myWishListStepDefs {
    LoginPage loginPage = new LoginPage();

    @Given("The user is logged in with valid credentials")
    public void the_user_is_logged_in_with_valid_credentials() {
        Driver.get().get(ConfigurationReader.get("url"));
        loginPage.closePopUp();
        loginPage.clickLoginButton();
        loginPage.login("karakastugba.1@hotmail.com", "230797");
        loginPage.navigateToHomePage();

    }

    @When("The user hovers the mouse over an item of interest,small buttons appear next to the item.")
    public void the_user_hovers_the_mouse_over_an_item_of_interest_small_buttons_shortcuts_appear_next_to_the_item() {
        loginPage.hoverAndClickWishList();
    }

    @Then("The user clicks on the Add to my wishlist button among the small buttons.")
    public void the_user_clicks_on_the_button_among_the_small_buttons() {

    }

    @Then("The user sees a success message at the top of the page confirming that the item has been added to the wishlist.")
    public void the_user_sees_a_success_message_at_the_top_of_the_page_confirming_that_the_item_has_been_added_to_the_wishlist() {

    }

    @When("The user clicks on the Heart Icon in the upper right corner of the page")
    public void the_user_clicks_on_the_heart_icon_in_the_upper_right_corner_of_the_page() {

    }

    @Then("The user is redirected to the My Wishlist page.")
    public void the_user_is_redirected_to_the_page(String string) {

    }

    @Then("The user sees the products that have already been added to the wish list.")
    public void the_user_sees_the_products_that_have_already_been_added_to_the(String string) {

    }

}
