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

//    @Then("The user should be redirected to the search page related to {string}.")
//    public void the_user_should_be_redirected_to_the_search_page_related_to(String string) {
//        filteringFuncsPage.verifyThatTheSearchPageContainsValidProducts(string);
//    }


}
