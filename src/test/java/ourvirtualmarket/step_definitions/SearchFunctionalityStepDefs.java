package ourvirtualmarket.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ourvirtualmarket.pages.BasePage;
import ourvirtualmarket.pages.SearchPage;

public class SearchFunctionalityStepDefs {
    SearchPage searchPage = new SearchPage();

    @Then("The user should be able to see if there is a search bar and search button on the top middle of the page.")
    public void the_user_should_be_able_to_see_if_there_is_a_search_bar_and_search_button_on_the_top_middle_of_the_page() {
    searchPage.isSearchBtnDisplay();
    searchPage.isSearchBarDisplay();
    }
    @Then("The user should be able to see the search bar contains the text {string} by default.")
    public void the_user_should_be_able_to_see_the_search_bar_contains_the_text_by_default(String defaultText) {
    searchPage.verifySearchBarDefaultText(defaultText);
    }
    @When("The user should enter a valid keyword {string} in the search bar and click on the search button.")
    public void the_user_should_enter_a_valid_keyword_in_the_search_bar(String searchData) {
        searchPage.searchMethod(searchData);
    }
    @Then("The user should be directed to the search page related to {string}.")
    public void the_user_should_be_directed_to_the_search_page_related_to(String searchData) {
       searchPage.verifyThatTheSearchPageContainsValidProducts(searchData);
    }
    @When("The user should enter a invalid keyword {string} in the search bar and click on the search button.")
    public void the_user_should_enter_a_invalid_keyword_in_the_search_bar_and_click_on_the_search_button(String searchData) {
      searchPage.searchMethod(searchData);
    }
    @Then("The user should see {string} message")
    public void the_user_should_see_message(String message) {
    searchPage.verifyThatInvalidSearchMessage(message);
    }




}
