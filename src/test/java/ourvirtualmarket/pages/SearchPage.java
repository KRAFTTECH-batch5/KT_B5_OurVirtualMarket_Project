package ourvirtualmarket.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ourvirtualmarket.utilities.BrowserUtils;
import java.util.List;
public class SearchPage extends BasePage{
    @FindBy (xpath = "(//input[@name='search'])[2]")
    private WebElement l_searchTextArea;

    @FindBy (id = "button-search")
    private WebElement l_searchButton;

    public void searchProduct(String productName) {
        l_searchButton.clear();
        l_searchTextArea.sendKeys(productName);

    }
    public void clickOnSearchButton(){
        l_searchButton.click();
    }

    @FindBy(xpath = "//h4/a")
    public List<WebElement> productNames;

    @FindBy(xpath = "//div/p[.='There is no product that matches the search criteria.']")
    public WebElement invalidProductMessage;


    /**
     * This method verifies the product names in the search results.
     */
    public void verifyThatTheSearchPageContainsValidProducts(String searchData) {
        List<String> productNameList = BrowserUtils.getElementsText(productNames);
        for (String productName : productNameList) {
            if (productName.contains(searchData)) {
                Assert.assertTrue(searchData, true);
                return; // Doğrulama başarılı olduğu için fonksiyondan çık
            }   Assert.fail(searchData);
        }
    }
    /**
     * This method verifies the message you receive if you search for a product that is not on the site.
     */
    public void verifyThatInvalidSearchMessage(String expectedMessage){
    String actualMessage = invalidProductMessage.getText();
    Assert.assertEquals(actualMessage,expectedMessage);
   }
}
