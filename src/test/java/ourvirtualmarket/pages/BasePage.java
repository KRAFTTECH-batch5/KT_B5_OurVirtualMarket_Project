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

    Faker faker = new Faker();
    JavascriptExecutor js;

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
    private WebElement subsAlertMessage;
    @FindBy(xpath = "//input[@id='txtemail']")
    private WebElement emailInputBoxBottomSubs;
    @FindBy(xpath = "//button[normalize-space()='Subscribe']")
    private WebElement subBtnBottom;

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
    /**
     * This method is used to go to the home page.
     */
    public void navigateToHomePage(){
        homeBtn.click();
    }
    /**
     * This method is used to verify that the subscription pop-up has been opened.
     */
    public void verifySubsPopUpIsVisible(){
        subsPopUp.isDisplayed();
    }
    /**
     * Bu yöntemi inşallah bir gün kullanacağız.
     */
    public void verifySubsPopUpIsNotVisible(){
        //burayı yapamadım kafayı yicem sabahın 5'inde
    }
    /**
     * This method is used to verify that the subscription banner appears at the bottom of the page.
     */
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
    /**
     * This method is used to verify the valid subscription message.
     */
    public void verifySuccessfulSubs(){
        String expectedMessage = " × Subcription was successfull";
        String actualMessage = subsAlertMessage.getAttribute("textContent");
        Assert.assertEquals(expectedMessage,actualMessage);
    }
    /**
     * This method is used to scroll the page to the bottom.
     */
    public void scrollsDownThePageToTheBottom(){
        js = (JavascriptExecutor) Driver.get();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
    /**
     * This method is used to subscribe via the subscription at the bottom of the page.
     */
    public void subscribeToBottomSubs(String email){
        emailInputBoxBottomSubs.sendKeys(email);
        subBtnBottom.click();
    }
    /**
     * This method is used to verify the incoming message when trying to subscribe with the same e-mail.
     */
    public void verifySameEmailMessage(){
        String expectedMessage = " × Email has already exist";
        String actualMessage = subsAlertMessage.getAttribute("textContent");
        Assert.assertEquals(expectedMessage,actualMessage);
    }
}
