package ourvirtualmarket.pages;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ser.Serializers;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ourvirtualmarket.step_definitions.GetNewsLetterStepDefs;
import ourvirtualmarket.utilities.BrowserUtils;

import java.util.List;

public class AlternativeSearchPage extends BasePage {

    SearchPage searchPage = new SearchPage();
    @FindBy(xpath = "(//i[@class='fa fa-search'])[3]")
    private WebElement l_alternativeSearchBtn;

    @FindBy(xpath = "(//span[text()='Search'])[1]")
    private WebElement l_searchText;
    @FindBy(xpath = "(//input[@type='text'])[3]")
    private WebElement l_searchArea;

    @FindBy(xpath = "(//input[@name='search'])[2]")
    private WebElement l_searchBoxBtn;

    @FindBy(id = "button-search")
    private WebElement l_searchBtn;

    @FindBy(xpath = "(//a[@class='popup-close'])[4]")
    private WebElement l_toCloseSearchBox;

    @FindBy(xpath = "(//div[@class='row']//b)[1]")
    private WebElement l_welcomeMessage;

    @FindBy(xpath = "//p[contains(text(),'There is no product')]")
    private WebElement l_errorMessage;

    public void hoveringTheSearchButton() {
        WebElement alternativeSearchBtn = l_alternativeSearchBtn;
        BrowserUtils.hover(alternativeSearchBtn);
    }

    public void verifyingTheSearchText() {
        String text = l_searchText.getText();
        Assert.assertEquals("Search", text);
    }

    public void clickOnTheAlternativeSearchBtn() {
        l_alternativeSearchBtn.click();
    }

    public void verifyTheSearchAreaIsEnabled() {
        Assert.assertTrue(l_searchArea.isEnabled());
    }

    public void verifyTheSearchButtonIsEnabled() {
        Assert.assertTrue(l_searchBoxBtn.isEnabled());
    }

    public void returnToHomePage() {
        l_toCloseSearchBox.click();
        String text = l_welcomeMessage.getText();
        Assert.assertEquals("Welcome to Our Virtual Market !", text);
    }

    public void searchProduct(String productName) {
        l_searchArea.sendKeys(productName);
        l_searchBtn.click();
    }

    public void verifyProduct(String searchData) {
        List<String> productList = BrowserUtils.getElementsText(searchPage.productNames);
        for (String products : productList) {
            if (products.contains(searchData)) {
                Assert.assertTrue(searchData, true);
                return;
            }
        }
        Assert.fail();
    }

    public void verifyErrorMessage() {
        String expectedMessage = "There is no product that matches the search criteria.";
        String actualMessage = l_errorMessage.getText();
        Assert.assertEquals(expectedMessage, actualMessage);

    }

}
