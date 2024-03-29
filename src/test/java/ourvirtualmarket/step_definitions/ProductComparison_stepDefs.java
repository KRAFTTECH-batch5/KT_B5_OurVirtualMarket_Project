package ourvirtualmarket.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ourvirtualmarket.pages.ProductComparisonPage;

import java.util.List;

public class ProductComparison_stepDefs {

    ProductComparisonPage productComparisonPage=new ProductComparisonPage();


    @Given("The user navigates to {string} category")
    public void the_user_navigates_to_category(String categoryName) {
        productComparisonPage.navigatesToGivenCategory(categoryName);

    }
    @Given("The user adds two products on the product comparison list")
    public void the_user_adds_two_products_on_the_product_comparison_list() {
        productComparisonPage.addTwoProductsOnComparisonList();

    }

    @When("The user is able to put any product into the comparison list")
    public void the_user_is_able_to_put_any_product_into_the_comparison_list() {
        productComparisonPage.addProductToCompareList();
    }

    @Then("The user verifies the {string} message on the top of page")
    public void the_user_verifies_the_message_on_the_top_of_page(String message) {
        productComparisonPage.verifyAddingProductToCompareListMessage(message);
    }

    @When("The user clicks on the Compare button")
    public void the_user_clicks_on_the_compare_button() {
        productComparisonPage.clickToCompareButton();
    }

    @Then("The user verifies that the Compare page is displayed")
    public void the_user_verifies_that_the_compare_page_is_displayed() {
        productComparisonPage.comparisonPageVerify();
    }

    @Then("The user verifies that the products are compared to each other in the following ways")
    public void the_user_verifies_that_the_products_are_compared_to_each_other_in_the_following_ways(List<String> list) {
        productComparisonPage.verifyComparisonTerms(list);
    }

    @When("The user adds third product to Comparison list")
    public void the_user_adds_third_product_to_comparison_list() {
        productComparisonPage.addThirdProductToComparisonList();
    }
    @When("The user adds fourth product to Comparison list")
    public void the_user_adds_fourth_product_to_comparison_list() {
        productComparisonPage.addFourthProductToComparisonList();
    }
    @When("The user tries add to fifth product to Comparison list")
    public void the_user_tries_add_to_fifth_product_to_comparison_list() {
        productComparisonPage.addFifthProductToComparisonList();
    }

    @Then("The user verifies the warning {string} that product fifth cannot be added to the Comparison list")
    public void the_user_verifies_the_warning_that_product_fifth_cannot_be_added_to_the_comparison_list(String message) {
        productComparisonPage.verifyWarningMessageThatProductFifthCannotBeAddedToComparisonList(message);
    }















}
