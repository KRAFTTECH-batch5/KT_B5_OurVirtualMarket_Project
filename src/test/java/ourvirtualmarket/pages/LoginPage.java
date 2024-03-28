package ourvirtualmarket.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ourvirtualmarket.utilities.ConfigurationReader;
import ourvirtualmarket.utilities.Driver;

public class LoginPage extends BasePage {

    @FindBy(css = ".link-lg")
    private WebElement loginBtnHomePage;

    @FindBy(xpath = "//strong[.='Sign in Or Register']")
    private WebElement signInOrRegister;

    @FindBy(id = "email")
    private WebElement emailBar;

    @FindBy(id = "pass")
    private WebElement passwordBar;

    @FindBy(css = ".control-label")
    private WebElement socialAccountBar;

    @FindBy(css = ".btn-google-plus")
    private WebElement googleBtn;

    @FindBy(css = ".btn-facebook")
    private WebElement facebookBtn;

    @FindBy(css = ".btn-twitter")
    private WebElement twitterBtn;

    @FindBy(css = ".btn-linkdin")
    private WebElement linkedInBtn;

    @FindBy(id = "send2")
    private WebElement loginBtn;

    @FindBy(css = ".btn-reg-popup")
    private WebElement createAnAccountBtn;

    @FindBy(css = ".close-login")
    private WebElement exitBtn;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    private WebElement errorMessage;

    @FindBy(xpath = "//div[@class='well ']")
    private WebElement newCustomerTable;

    @FindBy(xpath = "//div[@class='well col-sm-12']")
    private WebElement returningCustomerTable;


    /**
     * This method verifies the login button on the home page.
     */
    public void verifyLoginButtonHomePage() {
        Assert.assertTrue(loginBtnHomePage.isDisplayed());
    }

    /**
     * This method clicks on the login button on the home page.
     */
    public void clickLoginButton() {
        loginBtnHomePage.click();
    }

    /**
     * This method verifies the pop-up message.
     *
     * @param string
     */
    public void verifyPopUp(String string) throws InterruptedException {
        Thread.sleep(2000);
        String actual = signInOrRegister.getText();
        String expected = string;
        Assert.assertEquals(expected, actual);
    }

    /**
     * This method verifies the email bar.
     */
    public void verifyEmailBar() {
        Assert.assertTrue(emailBar.isDisplayed());
    }

    /**
     * This method verifies the password bar.
     */
    public void verifyPasswordBar() {
        Assert.assertTrue(passwordBar.isDisplayed());
    }


    /**
     * This method verifies the social accounts.
     *
     * @param string
     */
    public void verifySocialMediaButtons(String string) {
        String actual = socialAccountBar.getText();
        String expected = string;
        Assert.assertEquals(expected, actual);
        Assert.assertTrue(googleBtn.isDisplayed());
        Assert.assertTrue(facebookBtn.isDisplayed());
        Assert.assertTrue(twitterBtn.isDisplayed());
        Assert.assertTrue(linkedInBtn.isDisplayed());
    }

    /**
     * This method verifies the login button.
     */
    public void verifyLoginButton() {
        Assert.assertTrue(loginBtn.isDisplayed());
    }

    /**
     * This method verifies the social account button.
     *
     * @param string
     */
    public void verifyCreateAnAccountButton(String string) {
        String actual = createAnAccountBtn.getText();
        String expected = string;
        Assert.assertEquals(expected, actual);
    }

    /**
     * This method logs in with valid credentials.
     */
    public void login() {
        emailBar.sendKeys(ConfigurationReader.get("username1"));
        passwordBar.sendKeys(ConfigurationReader.get("password1"));
        loginBtn.click();
    }

    public void login(String email, String password) {
        emailBar.sendKeys(email);
        passwordBar.sendKeys(password);
        loginBtn.click();
    }

    /**
     * This method verifies the exit button.
     */
    public void verifyExitButton() {
        Assert.assertTrue(exitBtn.isDisplayed());
    }

    /**
     * This method verifies the successful login.
     */
    public void verifySuccessLogin() {
        String actual = Driver.get().getCurrentUrl();
        String expected = "https://ourvirtualmarket.com/index.php?route=account/account";
        Assert.assertEquals(expected, actual);
    }

    /**
     * This method verifies the unsuccessful login.
     */
    public void verifyUnsuccessfulLogin() {
        String actual = Driver.get().getCurrentUrl();
        String expected = "https://ourvirtualmarket.com/index.php?route=account/login";
        Assert.assertEquals(expected, actual);
    }

    /**
     * This method verifies the error message.
     *
     * @param string
     */
    public void verifyErrorMessage(String string) {
        String actual = errorMessage.getText();
        String expected = string;
        Assert.assertEquals(expected, actual);
    }

    /**
     * This method verifies the new customer table.
     */
    public void verifyNewCustomerTable() {
        Assert.assertTrue(newCustomerTable.isDisplayed());
    }

    /**
     * This method verifies the returning customer table.
     */
    public void verifyReturningCustomerTable() {
        Assert.assertTrue(returningCustomerTable.isDisplayed());
    }

    public void verifyBottomSubsIsVisible() {
    }
}
