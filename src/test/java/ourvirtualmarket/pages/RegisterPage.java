package ourvirtualmarket.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegisterPage extends BasePage {
    @FindBy(id = "input-firstname")
    private WebElement firstnameInbox;
    @FindBy(id = "input-lastname")
    private WebElement lastnameInbox;
    @FindBy(id = "input-email")
    private WebElement emailInbox;
    @FindBy(id = "input-telephone")
    private WebElement telInbox;
    @FindBy(id = "input-password")
    private WebElement passwordInbox;
    @FindBy(id = "input-confirm")
    private WebElement passConfirmInbox;
    @FindBy(css = "[type='checkbox']")
    private WebElement privacyCheckBox;
    @FindBy(css = "[value='Continue']")
    private WebElement continueBtn;
    @FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
    private WebElement accountCreationText;
    @FindBy(xpath = "//div[text()=' Warning: You must agree to the Privacy Policy!']")
    private WebElement msg_privacyError;
    @FindBy(xpath = "//div[text()='First Name must be between 1 and 32 characters!']")
    private WebElement msg_firstnameError;
    @FindBy(xpath = "//div[text()='Last Name must be between 1 and 32 characters!']")
    private WebElement msg_lastnameError;
    @FindBy(xpath = "//div[text()='E-Mail Address does not appear to be valid!']")
    private WebElement msg_emailError;
    @FindBy(xpath = "//div[text()='Telephone must be between 3 and 32 characters!']")
    private WebElement msg_telNumberError;
    @FindBy(xpath = "//div[text()='Password must be between 4 and 20 characters!']")
    private WebElement msg_passwordError;
    @FindBy(xpath = "//div[text()='Password confirmation does not match password!']")
    private WebElement msg_passwordConfirmError;
    private String firstnameValue;
    private String lastnameValue;
    private String emailValue;
    private String telNumberValue;
    private String passwordValue;
    private String passwordConfirmValue;
    private boolean privacyPolicy;
    private String errorMessage;

    public void fillForm() {
        firstnameInbox.sendKeys(faker.name().firstName());
        lastnameInbox.sendKeys(faker.name().lastName());
        emailInbox.sendKeys(faker.internet().emailAddress());
        telInbox.sendKeys(faker.phoneNumber().phoneNumber());
        passwordInbox.sendKeys("1234asdf");
        passConfirmInbox.sendKeys("1234asdf");
        privacyCheckBox.click();
        continueBtn.click();
    }

    public void verifySuccessAccountCreation() {
        assertTrue(accountCreationText.isDisplayed());
    }

    public void fillForm(String firstName, String lastName, String email, String telNumber, String password, String passwordConfirm, boolean privacy) {
        // this part of code allows us to store the entry data
        if (firstName.isBlank()) {
            firstnameValue = firstName;
        }
        if (lastName.isBlank()) {
            lastnameValue = lastName;
        }
        if (email.isBlank()) {
            emailValue = email;
        }
        if (telNumber.isBlank()) {
            telNumberValue = telNumber;
        }
        if (password.isBlank()) {
            passwordValue = password;
        }
        if (!(password.equals(passwordConfirm))) {
            passwordValue = password;
            passwordConfirmValue = passwordConfirm;
        }
        if (privacy == false) {
            privacyPolicy = privacy;
        }
        // sends the data to fields
        firstnameInbox.sendKeys(firstName);
        lastnameInbox.sendKeys(lastName);
        emailInbox.sendKeys(email);
        telInbox.sendKeys(telNumber);
        passwordInbox.sendKeys(password);
        passConfirmInbox.sendKeys(passwordConfirm);
        if (privacy == true) {
            privacyPolicy=true;
            privacyCheckBox.click();
        }
        continueBtn.click();
        //email field variations
        if (!(email.contains("@"))) {
            emailValue = email;
            errorMessage=emailInbox.getAttribute("validationMessage");
        } else if (email.startsWith("@")) {
            emailValue=email;
            errorMessage=emailInbox.getAttribute("validationMessage");
        }else if(email.endsWith("@")){
            emailValue=email;
            errorMessage=emailInbox.getAttribute("validationMessage");
        }
    }

    /**
     * This method checks the necessary fields value and returns what expected result is
     */
    public void verifyBlankEntryErrorMessages() {
        if (firstnameValue == null) {
        } else if (firstnameValue.isBlank()) {
            assertTrue(msg_firstnameError.isDisplayed());
        } else if (firstnameValue.length() > 32) {
            assertTrue(msg_firstnameError.isDisplayed());
        }
        if (lastnameValue == null) {
        } else if (lastnameValue.isBlank()) {
            assertTrue(msg_lastnameError.isDisplayed());
        } else if (lastnameValue.length() > 32) {
            assertTrue(msg_lastnameError.isDisplayed());
        }
        if (emailValue == null) {
        } else if (emailValue.isBlank()) {
            assertTrue(msg_emailError.isDisplayed());
        } else if (!emailValue.contains("@")) {
            assertEquals(errorMessage, "Please include an '@' in the email address. '" + emailValue + "' is missing an '@'.");
        } else if (emailValue.startsWith("@")) {
            assertEquals(errorMessage,"Please enter a part followed by '@'. '"+emailValue+"' is incomplete.");
        } else if (emailValue.endsWith("@")) {
            assertEquals(errorMessage,"Please enter a part following '@'. '"+emailValue+"' is incomplete.");
        }
        if (telNumberValue == null) {
        } else if (telNumberValue.isBlank()) {
            assertTrue(msg_telNumberError.isDisplayed());
        } else if (telNumberValue.length() > 32 || telNumberValue.length() < 3) {
            assertTrue(msg_telNumberError.isDisplayed());
        }
        if (passwordValue == null) {
        } else if (passwordValue.isBlank()) {
            assertTrue(msg_passwordError.isDisplayed());
        } else if (passwordValue.length() > 20 || passwordValue.length() < 4) {
            assertTrue(msg_passwordError.isDisplayed());
        }
        if (passwordConfirmValue == null) {
        } else if (passwordValue != passwordConfirmValue) {
            assertTrue(msg_passwordConfirmError.isDisplayed());
        }
        if (privacyPolicy == true){}
        else if (privacyPolicy == false) {
            assertTrue(msg_privacyError.isDisplayed());
        }
    }
}
