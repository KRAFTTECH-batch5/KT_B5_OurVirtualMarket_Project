package ourvirtualmarket.pages;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlternativeSearchPage extends BasePage {
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


    public void searchProduct(String productName) {
        l_searchArea.sendKeys(productName);
        l_searchBtn.click();
    }
}
