package ourvirtualmarket.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import ourvirtualmarket.pages.LoginPage;
import ourvirtualmarket.utilities.BrowserUtils;
import ourvirtualmarket.utilities.ConfigurationReader;
import ourvirtualmarket.utilities.Driver;

public class quickViewStepDefs {

    LoginPage loginPage = new LoginPage();

    @Given("the user must be logged in and on the home page with at least one product in their cart")
    public void the_user_is_logged_in_and_on_the_home_page_with_at_least_one_product_in_the_cart() {

        Driver.get().get(ConfigurationReader.get("url"));
        loginPage.closePopUp();
        loginPage.clickLoginButton();
        loginPage.login("muhammedincesu27@gmail.com", "230797.");

        loginPage.productControl();
        BrowserUtils.waitFor(2);
    }

    @When("the user hovers over a product and clicks quick view")
    public void the_user_hovers_over_a_product_and_clicks() {
        loginPage.navigateToHomePage();
        loginPage.quickViewAndAddToCard();
    }
    @When("adds the product to the cart and the cart total should be updated correctly in the pop-up")
    public void adds_the_product_to_the_cart() {
        loginPage.addToCardbtnClick();
    }

    @Then("the user sees the updated total on the home page")
    public void the_user_sees_the_updated_total_on_the_home_page() {
        loginPage.totalPayments();
    }

}
