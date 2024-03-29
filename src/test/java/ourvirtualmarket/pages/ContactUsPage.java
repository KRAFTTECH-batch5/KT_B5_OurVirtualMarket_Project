package ourvirtualmarket.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ourvirtualmarket.utilities.BrowserUtils;
import ourvirtualmarket.utilities.Driver;

public class ContactUsPage extends BasePage{

    WebDriver driver;

    Actions actions = new Actions(Driver.get());

    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailBar;

    @FindBy(xpath = "//input[@id='pass']")
    public WebElement passwordBar;

    @FindBy(xpath = "//button[@name='send']/span[.='Login']")
    public WebElement loginBtn;

    @FindBy (xpath = "//strong[contains(.,'Home')]")
    public WebElement l_homeBtn;

    @FindBy (xpath = "//div[@class='box-service box-footer']//a[.='Contact Us']")
    public WebElement l_contactUsBtn;

    @FindBy (id = "input-name")
    public WebElement l_nameText;

    @FindBy (id = "input-email")
    public WebElement l_emailText;

    @FindBy(id = "input-enquiry")
    public WebElement l_enquiry;

    @FindBy(xpath = "//span[contains(.,'Submit')]")
    public WebElement l_submitBtn;

    @FindBy(xpath = "//p[.='Your enquiry has been successfully sent to the store owner!']")
    public WebElement l_successMessage;

    @FindBy(css = ".text-danger")
    public WebElement l_warningMessage;

    public void clickHomeBtn() {
        l_homeBtn.click();
    }

    public void scrollDownContactUs() {
        actions.moveToElement(l_contactUsBtn).perform();
    }

    public void clickContactUs() {
        l_contactUsBtn.click();
    }

    public void login(String email,String password){
        emailBar.sendKeys(email);
        passwordBar.sendKeys(password);
        loginBtn.click();
    }

    public void verifyNameEmail(){
        BrowserUtils.waitFor(2);
        String actualName = l_nameText.getAttribute("value");
        String expectedName = "Ryan";
        Assert.assertEquals(expectedName,actualName);

        BrowserUtils.waitFor(2);
        String actualEmail = l_emailText.getAttribute("value");
        String expectedEmail = "rgosling@gmail.com";
        Assert.assertEquals(expectedEmail,actualEmail);
    }

    public void inputEnquiry1() {
        String inputComplaining = faker.lorem().characters(2500);
        l_enquiry.sendKeys(inputComplaining);
        BrowserUtils.waitFor(2);
        l_submitBtn.click();
    }

    public void verifySuccessMsg1() {
        BrowserUtils.waitFor(2);
        String actualSuccessMsg = l_successMessage.getText();
        String expectedSuccessMsg = "Your enquiry has been successfully sent to the store owner!";
        Assert.assertEquals(expectedSuccessMsg,actualSuccessMsg);
    }

    public void inputEnquiry2() {
        String inputComplaining = faker.lorem().characters(9);
        l_enquiry.sendKeys(inputComplaining);
        BrowserUtils.waitFor(2);
        l_submitBtn.click();
    }

    public void verifyFailMsg2() {
        BrowserUtils.waitFor(2);
        String actualFailMsg = l_warningMessage.getText();
        String expectedFailMsg = "Enquiry must be between 10 and 3000 characters!";
        Assert.assertEquals(expectedFailMsg,actualFailMsg);
    }

    public void inputEnquiry3() {
        String inputComplaining = faker.lorem().characters(3005);
        l_enquiry.sendKeys(inputComplaining);
        BrowserUtils.waitFor(2);
        l_submitBtn.click();
    }

}
