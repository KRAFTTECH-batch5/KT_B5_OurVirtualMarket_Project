package ourvirtualmarket.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ourvirtualmarket.pages.LoginPage;
import ourvirtualmarket.pages.ProductComparisonPage;
import ourvirtualmarket.utilities.Driver;

import java.util.List;

public class Logout_stepDefs {

    ProductComparisonPage productComparisonPage=new ProductComparisonPage();


    @Then("The user verifies that logout button is displayed")
    public void the_user_verifies_that_logout_button_is_displayed() {
        productComparisonPage.verifyLogoutButtonIsDisplayed();

    }
    @When("The user clicks to Logout button")
    public void the_user_clicks_to_logout_button() {
        productComparisonPage.clickToLogoutButton();
    }
    @Then("The user verifies Logout page with following messages")
    public void the_user_verifies_logout_page_with_following_messages(List<String> list) {
        productComparisonPage.verifyLogoutPageMessagesAfterLogout(list);

    }
    @When("The user clicks on page-back button")
    public void the_user_clicks_on_page_back_button() {
        Driver.get().navigate().back();
    }
    @Then("The user verifies that can not back to his personal page")
    public void the_user_verifies_that_can_not_back_to_his_personal_page() {
        productComparisonPage.verifyThatUserCantComeBackHisPersonalPage();
    }



}
