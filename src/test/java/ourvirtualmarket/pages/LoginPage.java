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

    @FindBy(id = "password")
    private WebElement passwordBar;

    @FindBy(xpath = "//label[@text()='Login with your social account']")
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



    /**
     * This method verifies the login button on the home page.
     */
    public void verifyLoginButtonHomePage() {
        loginBtnHomePage.isDisplayed();
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
    public void verifyPopUp(String string) {
        String actual = signInOrRegister.getText();
        String expected = string;
        Assert.assertEquals(expected, actual);
    }

    /**
     * This method verifies the email bar.
     */
    public void verifyEmailBar() {
        emailBar.isDisplayed();
    }

    /**
     * This method verifies the password bar.
     */
    public void verifyPasswordBar() {
        passwordBar.isDisplayed();
    }

    /**
     * This method verifies the social accounts.
     * @param string
     */
    public void verifySocialMediaButtons(String string) {
        String actual = socialAccountBar.getText();
        String expected = string;
        Assert.assertEquals(expected, actual);
        googleBtn.isDisplayed();
        facebookBtn.isDisplayed();
        twitterBtn.isDisplayed();
        linkedInBtn.isDisplayed();
    }

    /**
     * This method verifies the login button.
     */
    public void verifyLoginButton() {
        loginBtn.isDisplayed();
    }

    /**
     * This method verifies the social account button.
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
        emailBar.sendKeys(ConfigurationReader.get("username"));
        passwordBar.sendKeys(ConfigurationReader.get("password"));
        loginBtn.click();
    }

    /**
     * This method verifies the exit button.
     */
    public void verifyExitButton(){
        exitBtn.isDisplayed();
    }

    /**
     * This method verifies the successful login.
     */
    public void verifySuccessLogin() {
        String actual = Driver.get().getCurrentUrl();
        String expected = "https://ourvirtualmarket.com/index.php?route=account/account";
        Assert.assertEquals(expected, actual);
    }
}
