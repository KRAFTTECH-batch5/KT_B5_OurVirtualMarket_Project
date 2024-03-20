package ourvirtualmarket.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
}
