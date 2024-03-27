package ourvirtualmarket.pages;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
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
    Alert alert;

    @FindBy(xpath = "//button[@class='popup-close']")
    private WebElement subsPopupClose;
    @FindBy(xpath = "//input[@name='hidden-popup']")
    private WebElement subsCheckBox;
    @FindBy(xpath = "//div[@class='signin-w font-title hidden-sm hidden-xs']//a[text()='Register']")
    private WebElement registerBtn;
    @FindBy(xpath = "//strong[normalize-space()='Home']")
    private WebElement homeBtn;
    @FindBy(xpath = "//div[@class='so-custom-popup so-custom-oca-popup']/div[@class='modcontent']")
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
     * This method is used to verify that the subscription pop-up window is closed.
     */
    public void verifySubsPopUpIsNotVisible(){
        try {
            subsPopUp.isDisplayed();
        }
        catch (NoSuchElementException e) {
            Assert.assertTrue(true);
        }
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
    /**
     * This method is used to click the subscribe button without entering an email in the subscription banner below.
     */
    public void clickToBottomSubsWithoutEmail(){
        subBtnBottom.click();
    }
    /**
     * This method is used to verify the alert error message that appears when the subscribe button is clicked
     * without entering an e-mail in the subscription header below.
     */
    public void verifyEmptyEmailAlertMessage(){
        alert = Driver.get().switchTo().alert();
        String expectedMessage = "Email is required";
        String actualMessage = alert.getText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }
    /**
     * This method is used to validate the warning error message displayed when an invalid email is entered
     * in the subscription header below and the subscribe button is clicked.
     */
    public void verifyInvalidEmailMessage(){
        String expectedMessage = " × Invalid Email ";
        String actualMessage = subsAlertMessage.getAttribute("textContent");
        Assert.assertEquals(expectedMessage,actualMessage);
    }

}
