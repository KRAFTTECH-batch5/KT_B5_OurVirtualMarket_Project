package ourvirtualmarket.pages;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ourvirtualmarket.utilities.Driver;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }
    Faker faker=new Faker();


    @FindBy(xpath = "//button[@class='popup-close']")
    private WebElement subsPopupClose;
    @FindBy(xpath = "//input[@name='hidden-popup']")
    private WebElement subsCheckBox;
    @FindBy(xpath = "//div[@class='signin-w font-title hidden-sm hidden-xs']//a[text()='Register']")
    private WebElement registerBtn;
    @FindBy(xpath = "//button[@name='submit_search']")
    private WebElement searchBtn;
    @FindBy(xpath = "//input[@name='search'][@class='autosearch-input form-control']")
    private WebElement searchBar;

    /**
     * This method closes the "popup" on the main page.
     */
    public void closePopUp() {
        subsCheckBox.click();
        subsPopupClose.click();
    }

    public void closePopUpWithoutCheckbox(){
        subsPopupClose.click();
    }

    public void navigateToRegisterPage(){
        registerBtn.click();
    }
    /**
     * This method verifies that the search button is displayed.
     */
    public void isSearchBtnDisplay(){Assert.assertTrue(searchBtn.isDisplayed());}

    /**
     * This method verifies that the search bar is displayed.
     */
    public void isSearchBarDisplay(){Assert.assertTrue(searchBar.isDisplayed());}

    /**
     * This method verifies that the search bar default text.
     */
    public void verifySearchBarDefaultText(String defaultText){
        String expectedDefaultText= searchBar.getAttribute("placeholder");
        String actualDefaultText= defaultText;
        Assert.assertEquals(expectedDefaultText,actualDefaultText);
    }
    public void searchMethod(String SearchData){
       searchBar.sendKeys(SearchData);
       searchBtn.click();
    }
}


