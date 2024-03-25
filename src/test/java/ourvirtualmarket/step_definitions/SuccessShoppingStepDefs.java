package ourvirtualmarket.step_definitions;

import io.cucumber.java.en.*;
import ourvirtualmarket.pages.CheckoutPage;

import java.util.ArrayList;
import java.util.List;


public class SuccessShoppingStepDefs {
    String productName1="Noerden Minimi Smart Body Scale";
    CheckoutPage checkoutPage = new CheckoutPage();
    @Given("The user puts product or products into his or her shopping cart")
    public void the_user_puts_some_products_into_his_her_shopping_cart() {
        checkoutPage.addProductToCart(productName1);
    }
    @When("The user is landed on the shopping cart page")
    public void the_user_is_landed_on_the_shopping_cart_page() {
        checkoutPage.navigateToCart();
    }
    @Then("The user verifies that the products displayed on the cart page match the items previously added to the shopping cart.")
    public void the_user_verifies_that_the_products_displayed_on_the_cart_page_match_the_items_previously_added_to_the_shopping_cart() {
        checkoutPage.verifyProductInCart(productName1);
    }
    @Then("The user verifies that Checkout button at the right-bottom of the page")
    public void the_user_verifies_that_button_at_the_right_bottom_of_the_page() {
        checkoutPage.verifyCheckoutButton();
    }
    @When("The user clicks on the {string} button")
    public void the_user_clicks_on_the_button(String string) {
        checkoutPage.clickCheckoutButton();
    }
    @Then("The user is navigated to the {string} menu")
    public void the_user_is_navigated_to_the_menu(String menu) {
        checkoutPage.verifyMenu(menu);
    }
    @When("The user fills in all the necessary menus and clicks on the Continue button")
    public void the_user_fills_in_all_the_necessary_menus_and_clicks_on_the_button() {
        checkoutPage.fillInAllMenus();
    }
    @Then("The user verifies that the current address is shown selected as default")
    public void the_user_verifies_that_the_current_address_is_shown_selected_as_default() {
        checkoutPage.verifyCurrentAddress();
    }
    @Then("The user verifies that the address can be updated by tapping on the second button")
    public void the_user_verifies_that_the_address_can_be_updated_by_tapping_on_the_second_button() {
        checkoutPage.verifyUpdateAddressButton();
    }
    @When("The user selects the delivery address and clicks on the Continue button")
    public void the_user_selects_the_delivery_address_and_clicks_on_the_button() {
        checkoutPage.selectDeliveryAddress();
    }
    @Then("The user verifies that {string}")
    public void the_user_verifies_that(String flatShippingRate) {
        checkoutPage.verifyDeliveryMethod(flatShippingRate);
    }
    @Then("The user verifies that a space that allows the user can add some comments about the order")
    public void the_user_verifies_that_a_space_that_allows_the_user_can_add_some_comments_about_the_order() {
        checkoutPage.verifyCommentSpace();
    }
    @Then("The user verifies that {string} option that is selected as default")
    public void the_user_verifies_that_option_that_is_selected_as_default(String string) {
    }
    @Then("The user verifies that {string} button")
    public void the_user_verifies_that_button(String string) {
    }
    @When("The user accepts Terms & Conditions and clicks on the Continue button")
    public void the_user_accepts_and_clicks_on_the_button() {
    }
    @Then("The user verifies that the product names, models, quantities, unit prices, total price for each different product, sub-total, flat shipping rate, total")
    public void the_user_verifies_that_the_product_names_models_quantities_unit_prices_total_price_for_each_different_product_sub_total_flat_shipping_rate_total() {
    }
    @Then("The user verifies the following messages:")
    public void the_user_verifies_the_following_messages() {
    }
    @When("The user goes to the home page")
    public void the_user_goes_to_the_home_page() {
    }
    @Then("The user verifies that there is a {string} button that allows following the product")
    public void the_user_verifies_that_there_is_a_button_that_allows_following_the_product(String string) {
    }
    @When("The user goes to the order history page")
    public void the_user_goes_to_the_order_history_page() {
    }
    @Then("The user verifies the status and details of shopping")
    public void the_user_verifies_the_status_and_details_of_shopping() {
    }

}
