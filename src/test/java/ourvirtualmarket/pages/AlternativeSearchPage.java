package ourvirtualmarket.pages;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ser.Serializers;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ourvirtualmarket.utilities.BrowserUtils;

import java.util.List;

public class AlternativeSearchPage extends BasePage {

    SearchPage searchPage = new SearchPage();
    @FindBy(xpath = "(//i[@class='fa fa-search'])[3]")
    public WebElement l_alternativeSearchBtn;

    @FindBy(xpath = "(//span[text()='Search'])[1]")
    public WebElement l_searchText;
    @FindBy(xpath = "(//input[@type='text'])[3]")
    public WebElement l_searchArea;

    @FindBy(xpath = "(//input[@name='search'])[2]")
    public WebElement l_searchBoxBtn;

    @FindBy(id = "button-search")
    public WebElement l_searchBtn;

    @FindBy(xpath = "(//a[@class='popup-close'])[4]")
    public WebElement l_toCloseSearchBox;

    @FindBy(xpath = "(//div[@class='row']//b)[1]")
    public WebElement l_welcomeMessage;

    @FindBy (xpath = "//p[contains(text(),'There is no product')]")
    private WebElement l_errorMessage;


    public void searchProduct(String productName) {
        l_searchArea.sendKeys(productName);
        l_searchBtn.click();
    }

    public void verifyProduct(String searchData) {
        List<String> productList = BrowserUtils.getElementsText(searchPage.productNames);
        for (String products : productList) {
            if (products.contains(searchData)) {
                Assert.assertEquals(products, searchData);
                return;
            }
        }
        Assert.fail();
    }

    public void verifyErrorMessage() {
        String expectedMessage = "There is no product that matches the search criteria.";
        String actualMessage =l_errorMessage.getText();
                Assert.assertEquals(expectedMessage,actualMessage);

    }
}
