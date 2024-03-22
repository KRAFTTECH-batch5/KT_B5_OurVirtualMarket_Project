package ourvirtualmarket.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ourvirtualmarket.pages.FilteringFuncsPage;


public class Filtering_Functions_StepDefs {

    FilteringFuncsPage filteringFuncsPage = new FilteringFuncsPage();

    @Given("The user lands on the main product options")
    public void the_user_lands_on_the_main_product_options() throws InterruptedException {
        filteringFuncsPage.clickOnMainProductOpts();
        Thread.sleep(2000);
    }

    @Given("The user clicks on any {string}")
    public void the_user_clicks_on_any(String mainProduct) {
        filteringFuncsPage.megaMenu(mainProduct);
    }

    @When("I click the first down arrow")
    public void i_click_the_first_down_arrow() {

    }

    @Then("the search functionality should be hidden or shown")
    public void the_search_functionality_should_be_hidden_or_shown() {

    }

    @When("I click the second down arrow")
    public void i_click_the_second_down_arrow() {

    }

    @Then("the number of products should be hidden or shown")
    public void the_number_of_products_should_be_hidden_or_shown() {

    }

    @When("I click the third down arrow")
    public void i_click_the_third_down_arrow() {

    }

    @Then("the price range tabs should be hidden or shown")
    public void the_price_range_tabs_should_be_hidden_or_shown() {

    }
}
