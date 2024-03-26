package ourvirtualmarket.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ourvirtualmarket.pages.FilteringFuncsPage;
import ourvirtualmarket.utilities.BrowserUtils;
import ourvirtualmarket.utilities.Driver;

import java.time.Duration;


public class Filtering_Functions_StepDefs {
    FilteringFuncsPage filteringFuncsPage = new FilteringFuncsPage();

    String minPrice = "150";
    String maxPrice = "250";

    @Given("The user lands on the main product options")
    public void the_user_lands_on_the_main_product_options() {
        filteringFuncsPage.clickOnMainProductOpts();

    }

    @Given("The user clicks on any {string}")
    public void the_user_clicks_on_any(String mainProduct) {
        filteringFuncsPage.megaMenu(mainProduct);
    }

    @When("I click the first down arrow")
    public void i_click_the_first_down_arrow() {
        filteringFuncsPage.getArrowBtn1();
    }

    @Then("the search functionality should be hidden or shown")
    public void the_search_functionality_should_be_hidden_or_shown() {
        filteringFuncsPage.isSearchBarVisible();
    }

    @When("I click the second down arrow")
    public void i_click_the_second_down_arrow() {
        filteringFuncsPage.getArrowBtn2();
    }

    @Then("the number of products should be hidden or shown")
    public void the_number_of_products_should_be_hidden_or_shown() {
        filteringFuncsPage.isManufacturerTabVisible();
    }

    @When("I click the third down arrow")
    public void i_click_the_third_down_arrow() {
        filteringFuncsPage.getArrowBtn3();
    }

    @Then("the price range tabs should be hidden or shown")
    public void the_price_range_tabs_should_be_hidden_or_shown() {
        filteringFuncsPage.isRangeTabVisible();
    }

    @When("The user searches any product on the search bar as {string}")
    public void the_user_searches_any_product_on_the_search_bar_as(String productName) {
        filteringFuncsPage.searchProduct(productName);
    }

    @Then("The user should navigate to a page containing {string}")
    public void the_user_should_be_redirected_to_the_search_page_related_to(String string) throws InterruptedException {
        filteringFuncsPage.verifyValidProducts(string);
    }

    @Then("The user expects to see the total number of items displayed without any filtering applied as default")
    public void the_user_expects_to_see_the_total_number_of_items_displayed_without_any_filtering_applied_as_default() {
        filteringFuncsPage.verifyPalmNumber();
    }

    @When("The user sets the price range from minPrice to maxPrice")
    public void the_user_sets_the_price_range_from_to() {
        filteringFuncsPage.setPriceRange(minPrice, maxPrice);

    }

    @Then("The user sees the results should only contain products within the specified price range")
    public void the_user_sees_the_results_should_only_contain_products_within_the_specified_price_range() {
        filteringFuncsPage.getProductPrices();
    }

    @When("The user clicks on the Reset All button all settings should return to default values")
    public void the_user_clicks_on_the_Reset_All_button_all_settings_should_return_to_default_values() {
        filteringFuncsPage.clickResetAllBtn();
    }

    @Then("The user sees search bar should be empty")
    public void the_user_sees_search_bar_should_be_empty() {
        filteringFuncsPage.checkSearchBarIsEmpty();
    }

    @Then("The user verifies no filter should be selected")
    public void the_user_verifies_no_filter_should_be_selected() {
        filteringFuncsPage.palmIsSelected();
    }

    @Then("The user verifies the minimum price and the maximum price as ranges")
    public void the_user_verifies_the_minimum_price_and_the_maximum_price_as_ranges() {
        filteringFuncsPage.verifyMinMaxPrice();
    }

    @Then("The user should see an Not product message")
    public void the_user_should_see_an_not_product_message() {
        filteringFuncsPage.verifyNotProduct();
    }

}
