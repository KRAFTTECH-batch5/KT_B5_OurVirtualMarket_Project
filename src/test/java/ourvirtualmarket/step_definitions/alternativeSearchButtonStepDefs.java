package ourvirtualmarket.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import ourvirtualmarket.pages.AlternativeSearchPage;
import ourvirtualmarket.pages.SearchPage;
import ourvirtualmarket.utilities.BrowserUtils;


public class alternativeSearchButtonStepDefs {
    AlternativeSearchPage alternativeSearchPage = new AlternativeSearchPage();
    SearchPage searchPage = new SearchPage();

    @When("The user hovers the mouse over the alternative search button")
    public void the_user_hovers_the_mouse_over_the_alternative_search_button() {
        alternativeSearchPage.hoveringTheSearchButton();
    }

    @Then("The search text appears next to the button when the mouse hovers over it")
    public void the_search_text_the_text_appears_next_to_the_button_when_the_mouse_hovers_over_it() {
        alternativeSearchPage.verifyingTheSearchText();
    }

    @When("The user clicks on the alternative search button")
    public void the_user_clicks_on_the_alternative_search_button() {
        alternativeSearchPage.clickOnTheAlternativeSearchBtn();
    }

    @Then("A search bar where the user can enter any product name")
    public void a_search_bar_where_the_user_can_enter_any_product_name() {
        alternativeSearchPage.verifyTheSearchAreaIsEnabled();
    }

    @Then("A search button that navigates the user to the page with product-related items")
    public void a_search_button_that_navigates_the_user_to_the_page_with_product_related_items() {
        alternativeSearchPage.verifyTheSearchButtonIsEnabled();
    }

    @Then("An X button at the top-right corner that returns the user to the homepage")
    public void an_x_button_at_the_top_right_corner_that_returns_the_user_to_the_homepage() {
        alternativeSearchPage.returnToHomePage();
    }

    @When("The user enters a product name {string}")
    public void the_user_enters_a_product_name(String productName) throws InterruptedException {
        alternativeSearchPage.searchProduct(productName);
    }

    @When("The user clicks on the search button")
    public void the_user_clicks_on_the_search_button() {
        searchPage.clickOnSearchButton();
    }

    @Then("The user should be redirected to a page containing {string}")
    public void the_user_should_be_redirected_to_a_page_containing(String ProductName) {
        alternativeSearchPage.verifyProduct(ProductName);
    }

    @When("The user enters an invalid product name {string}")
    public void the_user_enters_an_invalid_product_name(String productName) {
        alternativeSearchPage.searchProduct(productName);
    }

    @Then("The user should see an error message or notification indicating the invalid search attempt.")
    public void the_user_should_see_an_error_message_or_notification_indicating_the_invalid_search_attempt() {
        alternativeSearchPage.verifyErrorMessage();
    }
}