package ourvirtualmarket.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import ourvirtualmarket.pages.BasePage;
import ourvirtualmarket.pages.ProductComparisonPage;
import ourvirtualmarket.pages.SearchPage;
import ourvirtualmarket.utilities.Driver;

import java.util.List;

public class alternativeSearchButtonFuncStepDefs extends BasePage {
    ProductComparisonPage productComparisonPage = new ProductComparisonPage();
    SearchPage searchPage = new SearchPage();

    @When("The user observes the alternative search button on the page")
    public void the_user_observes_the_alternative_search_button_on_the_page() {
//????????????
    }

    @Then("The alternative search button is visible at the middle-right")
    public void the_alternative_search_button_is_visible_at_the_middle_right() {
        Assert.assertTrue(l_alternativeSearchBtn.isDisplayed());
    }

    @When("The user hovers the mouse over the alternative search button")
    public void the_user_hovers_the_mouse_over_the_alternative_search_button() {
        Actions actions = new Actions(Driver.get());
        WebElement alternativeSearchBtn = productComparisonPage.l_alternativeSearchBtn;
        actions.moveToElement(alternativeSearchBtn).perform();
    }

    @Then("The {string} text appears next to the button when the mouse hovers over it")
    public void the_text_appears_next_to_the_button_when_the_mouse_hovers_over_it(String string) {
        String text = l_searchText.getText();
        Assert.assertEquals("Search", text);
    }

    @When("The user clicks on the alternative search button")
    public void the_user_clicks_on_the_alternative_search_button() {
        l_alternativeSearchBtn.click();
    }

    @Then("A search bar where the user can enter any product name")
    public void a_search_bar_where_the_user_can_enter_any_product_name() {
        //     String text = productComparisonPage.searchArea.getAttribute("Search");
        Assert.assertTrue(l_searchArea.isEnabled());
    }

    @Then("A search button that navigates the user to the page with product-related items")
    public void a_search_button_that_navigates_the_user_to_the_page_with_product_related_items() {
        Assert.assertTrue(l_searchBoxBtn.isEnabled());
    }

    @Then("An {string} button at the top-right corner that returns the user to the homepage")
    public void an_button_at_the_top_right_corner_that_returns_the_user_to_the_homepage(String string) {
        l_toCloseSearchBox.click();
        String text = l_welcomeMessage.getText();
        Assert.assertEquals("Welcome to Our Virtual Market !", text);
    }
    @When("The user enters a product name : {string}")
    public void the_user_enters_a_product_name(String productName) throws InterruptedException {
        l_searchArea.clear();
      searchProduct(productName);
      Thread.sleep(5000);
    }
    @When("The user enters a product name into the search box : {string}")
    public void the_user_enters_a_product_name_into_the_search_box(String productName) {
        searchPage.searchProduct(productName);
    }
    @When("The user clicks on the search button")
    public void the_user_clicks_on_the_search_button() {
        searchPage.clickOnSearchButton();
    }

}