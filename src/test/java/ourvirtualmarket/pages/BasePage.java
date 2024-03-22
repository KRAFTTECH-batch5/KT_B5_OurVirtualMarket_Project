package ourvirtualmarket.pages;

import com.github.javafaker.Faker;
import io.cucumber.java.zh_cn.假如;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ourvirtualmarket.utilities.BrowserUtils;
import ourvirtualmarket.utilities.Driver;

import java.util.List;


public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    Faker faker = new Faker();

    @FindBy(xpath = "//button[@class='popup-close']")
    private WebElement subsPopupClose;
    @FindBy(xpath = "//input[@name='hidden-popup']")
    private WebElement subsCheckBox;
    @FindBy(xpath = "//div[@class='signin-w font-title hidden-sm hidden-xs']//a[text()='Register']")
    private WebElement registerBtn;
    @FindBy(xpath = "//strong[normalize-space()='Home']")
    private WebElement homeBtn;
    @FindBy(xpath = "//div[@id='test-popup']//div[@class='popup-content']")
    private WebElement subsPopUp;
    @FindBy(xpath = "//div[@class='input-box']")
    private WebElement bottomSubs;
    @FindBy(xpath = "//button[@name='submit_search']")
    private WebElement searchBtn;
    @FindBy(xpath = "//input[@name='search'][@class='autosearch-input form-control']")
    private WebElement searchBar;
    @FindBy(xpath = "(//input[@type='email'])[2]")
    private WebElement emailBoxToSubs;
    @FindBy(xpath = "//button[@class='btn btn-primary btn-default']")
    private WebElement subsBtn;
    @FindBy(xpath = "//div[@role='alert']")
    private WebElement validPopUpMessage;

    @FindBy(xpath = "//button[@class='btn-link dropdown-toggle']")
    private WebElement currencyswitchingBtn;

    @FindBy(xpath = "//button[contains(text(),'$ US Dollar')]")
    private WebElement displayedtodollar;

    @FindBy(xpath = "//button[@name='EUR']")
    private WebElement EuroBtn;

    @FindBy(xpath = "//button[normalize-space()='£ Pound Sterling']")
    private WebElement PoundSterlingBtn;

    @FindBy(xpath = "//span[@class='items_carts']")
    private WebElement verifytoprice;




    /**
     * This method closes the "popup" on the main page.
     */
    public void closePopUp() {
        subsCheckBox.click();
        subsPopupClose.click();
    }

    /**
     * This method closes the "popup" on the main page without ticking the box.
     */
    public void closePopUpWithoutCheckbox(){
        subsPopupClose.click();
    }

    public void navigateToRegisterPage() {
        registerBtn.click();
    }

    public void navigateToHomePage(){
        homeBtn.click();
    }
    public void verifySubsPopUpIsVisible(){
        subsPopUp.isDisplayed();
    }
    public void verifySubsPopUpIsNotVisible(){
        //burayı yapamadım kafayı yicem sabahın 5'inde
    }
    public void verifyBottomSubsIsVisible(){
        bottomSubs.isDisplayed();
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
    /**
     * This method is used to subscribe via the pop-up.
     */
    public void subscribeTo(){
        emailBoxToSubs.sendKeys(faker.internet().emailAddress());
        subsBtn.click();
    }
    public void verifySuccessfulSubs() throws InterruptedException {
        String expectedMessage = " × Subcription was successfull";
        String actualMessage = validPopUpMessage.getAttribute("textContent");
        Assert.assertEquals(expectedMessage,actualMessage);
    }

    public void verifytoDollar() {
        String expected = displayedtodollar.getText();
        String actual = "$";
        Assert.assertTrue(expected.contains(actual));
    }

    public void clickcurrencybtn(){
        currencyswitchingBtn.click();

    }
    public void clicktoeurobtn(){
        EuroBtn.click();
        homeBtn.click();
    }

    public void verifytoeuro() {
        String expected = verifytoprice.getText();
        String actual = "€";
        Assert.assertTrue(expected.contains(actual));
    }

    public void clicktopoundSterlinbtn(){
        PoundSterlingBtn.click();
        homeBtn.click();
    }

    public void verifytopoundSterlin() {
        String expected = verifytoprice.getText();
        String actual = "£";
        Assert.assertTrue(expected.contains(actual));
    }

}
