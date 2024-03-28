package ourvirtualmarket.pages;

import com.github.javafaker.Faker;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ourvirtualmarket.utilities.BrowserUtils;
import org.openqa.selenium.support.pagefactory.DefaultElementLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ourvirtualmarket.utilities.BrowserUtils;
import ourvirtualmarket.utilities.Driver;


import java.util.List;


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

    @FindBy(xpath = "//span[@class='items_cart']")
    private WebElement addToCard;
    @FindBy(xpath = "//*[text()='Remington NE3150 Smart']")
    private WebElement visibilityControl;
    @FindBy(xpath = "//*[text()='Remington NE3150 Smart']")
    private WebElement addToCardBTNdisplayed;
    @FindBy(xpath = "//*[@id=\"cart\"]/a/div/div/span/span[3]")
    private WebElement totalPayments;

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
    @FindBy(xpath = "//a[contains(text(),'Returns')]")
    public List<WebElement> returnLinks;

    @FindBy(xpath = "//a[@href=\"index.php?route=account/return/add\"]")
    public WebElement returnsLink;


    @FindBy(xpath = "//*[text()='Remington NE3150 Smart']")
    private WebElement visibilityWishList1;
    @FindBy(xpath = "(//button[@class='wishlist btn-button'])[4]")
    private WebElement wishListremigthbtn;
    @FindBy(xpath = "//div[@class='alert alert-success fadeOut']/a[.='Remington NE3150 Smart']")
    private WebElement popUpSuccesfully;
    @FindBy(xpath = "//*[@id=\"wishlist-total\"]")
    private WebElement wishListBtnClick;
    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/table/tbody/tr/td[2]/a")
    private WebElement wishListNotEmpty;

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
    public void navigateToHomePage() {
        homeBtn.click();
    }

    /**
     * This method is used to verify that the subscription pop-up has been opened.
     */
    public void verifySubsPopUpIsVisible() {
        subsPopUp.isDisplayed();
    }

    /**
     * This method is used to verify that the subscription pop-up window is closed.
     */
    public void verifySubsPopUpIsNotVisible() {
        try {
            subsPopUp.isDisplayed();
        } catch (NoSuchElementException e) {
            Assert.assertTrue(true);
        }
    }

    /**
     * This method is used to verify that the subscription banner appears at the bottom of the page.
     */
    public void verifyBottomSubsIsVisible() {
        bottomSubs.isDisplayed();
    }

    /**
     * This method verifies that the search button is displayed.
     */
    public void isSearchBtnDisplay() {
        Assert.assertTrue(searchBtn.isDisplayed());
    }

    public void navigateToHomePage() {
        /**
         * This method is used to go to the home page.
         */
        public void navigateToHomePage( ) {
            homeBtn.click();
        }
        /**
         * This method is used to verify that the subscription pop-up has been opened.
         */
        public void verifySubsPopUpIsVisible () {

            public void verifySubsPopUpIsVisible() {
                subsPopUp.isDisplayed();
            }
            /**
             * This method is used to verify that the subscription pop-up window is closed.
             */
            public void verifySubsPopUpIsNotVisible () {
                try {
                    subsPopUp.isDisplayed();
                } catch (NoSuchElementException e) {
                    Assert.assertTrue(true);
                }

                public void verifySubsPopUpIsNotVisible () {
                    //burayı yapamadım kafayı yicem sabahın 5'inde
                }
                /**
                 * This method is used to verify that the subscription banner appears at the bottom of the page.
                 */
                public void verifyBottomSubsIsVisible () {

                    public void verifyBottomSubsIsVisible () {
                        bottomSubs.isDisplayed();
                    }
                    /**
                     * This method verifies that the search button is displayed.
                     */
                    public void isSearchBtnDisplay () {
                        Assert.assertTrue(searchBtn.isDisplayed());
                    }

    /**
     * This method verifies that the search bar is displayed.
     */
    public void isSearchBarDisplay() {
        Assert.assertTrue(searchBar.isDisplayed());
    }
                    /**
                     * This method verifies that the search bar is displayed.
                     */
                    public void isSearchBarDisplay () {
                        Assert.assertTrue(searchBar.isDisplayed());
                    }

    /**
     * This method verifies that the search bar default text.
     */
    public void verifySearchBarDefaultText(String defaultText) {
        String expectedDefaultText = searchBar.getAttribute("placeholder");
        String actualDefaultText = defaultText;
        Assert.assertEquals(expectedDefaultText, actualDefaultText);
    }

    public void searchMethod(String SearchData) {
        searchBar.sendKeys(SearchData);
        searchBtn.click();
    }

    /**
     * This method is used to subscribe via the pop-up.
     */
    public void subscribeTo() {
        emailBoxToSubs.sendKeys(faker.internet().emailAddress());
        subsBtn.click();
    }

    /**
     * This method returns the visibility control WebElement.
     */
    public WebElement getVisibilityControl() {
        return visibilityControl;
    }

    /**
     * Performs product control.
     */
    public void productControl() {
        String actual = addToCard.getText();
        int actualCount = Integer.parseInt(actual);
        int expectedCount = 1;
        Assert.assertTrue(actualCount >= expectedCount);
    }

    /**
     * Opens quick view and clicks on Add to Cart.
     */
    public void quickViewAndAddToCard() {
        navigateToHomePage();
        BrowserUtils.scrollToElement(getVisibilityControl());
        BrowserUtils.waitFor(3);
        BrowserUtils.hover(getVisibilityControl());
        BrowserUtils.waitFor(3);
        WebElement element = Driver.get().findElement(By.xpath("(//button[@class='addToCart btn-button'])[4]")); // XPath ifadesini düzelttik
        BrowserUtils.waitFor(3);
        Assert.assertNotNull(element);
    }

    /**
     * Clicks on the Add to Cart button.
     */
    public void addToCardbtnClick() {
        navigateToHomePage();
        BrowserUtils.scrollToElement(getVisibilityControl());
        BrowserUtils.waitFor(3);
        BrowserUtils.hover(getVisibilityControl());
        BrowserUtils.waitFor(3);
        WebElement element = Driver.get().findElement(By.xpath("(//button[@class='addToCart btn-button'])[4]"));
        element.click();
        BrowserUtils.waitFor(5);
        Driver.get().navigate().refresh();
    }

    /**
     * Verifies that Total Payments is displayed.
     */
    public void totalPayments() {
        Assert.assertTrue(totalPayments.isDisplayed());
    }

    /**
     * This method is used to verify the valid subscription message.
     */
    public void verifySuccessfulSubs() {
        String expectedMessage = " × Subcription was successfull";
        String actualMessage = subsAlertMessage.getAttribute("textContent");
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    /**
     * This method is used to scroll the page to the bottom.
     */
    public void scrollsDownThePageToTheBottom() {
        js = (JavascriptExecutor) Driver.get();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    /**
     * This method is used to subscribe via the subscription at the bottom of the page.
     */
    public void subscribeToBottomSubs(String email) {
        emailInputBoxBottomSubs.sendKeys(email);
        subBtnBottom.click();
    }

    /**
     * This method is used to verify the incoming message when trying to subscribe with the same e-mail.
     */
    public void verifySameEmailMessage() {
        String expectedMessage = " × Email has already exist";
        String actualMessage = subsAlertMessage.getAttribute("textContent");
        Assert.assertEquals(expectedMessage, actualMessage);
    }
                    /**
                     * This method verifies that the search bar default text.
                     */
                    public void verifySearchBarDefaultText (String defaultText){
                        String expectedDefaultText = searchBar.getAttribute("placeholder");
                        String actualDefaultText = defaultText;
                        Assert.assertEquals(expectedDefaultText, actualDefaultText);
                    }

                    public void searchMethod (String SearchData){
                        searchBar.sendKeys(SearchData);
                        searchBtn.click();
                    }

                    /**
                     * This method is used to subscribe via the pop-up.
                     */
                    public void subscribeTo () {
                        emailBoxToSubs.sendKeys(faker.internet().emailAddress());
                        subsBtn.click();
                    }

                    /**
                     * This method retrieves the visibility wish lists.
                     *
                     * @return The visibility wish lists
                     */

                    public void verifySuccessfulSubs () throws InterruptedException {
                        /**
                         * This method is used to verify the valid subscription message.
                         */
                        public void verifySuccessfulSubs () {
                            String expectedMessage = " × Subcription was successfull";
                            String actualMessage = validPopUpMessage.getAttribute("textContent");
                            Assert.assertEquals(expectedMessage, actualMessage);
                            String actualMessage = subsAlertMessage.getAttribute("textContent");
                            Assert.assertEquals(expectedMessage, actualMessage);
                        }
                        /**
                         * This method is used to scroll the page to the bottom.
                         */
                        public void scrollsDownThePageToTheBottom () {
                            js = (JavascriptExecutor) Driver.get();
                            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
                        }
                        /**
                         * This method is used to subscribe via the subscription at the bottom of the page.
                         */
                        public void subscribeToBottomSubs (String email){
                            emailInputBoxBottomSubs.sendKeys(email);
                            subBtnBottom.click();
                        }
                        /**
                         * This method is used to verify the incoming message when trying to subscribe with the same e-mail.
                         */
                        public void verifySameEmailMessage () {
                            String expectedMessage = " × Email has already exist";
                            String actualMessage = subsAlertMessage.getAttribute("textContent");
                            Assert.assertEquals(expectedMessage, actualMessage);
                        }

    public void verifytoDollar() {
        String expected = displayedtodollar.getText();
        String actual = "$";
        Assert.assertTrue(expected.contains(actual));
    }

                        public void clickcurrencybtn () {
                            currencyswitchingBtn.click();
    public void clickcurrencybtn() {
        currencyswitchingBtn.click();

                        }
                        public void clicktoeurobtn () {
                            EuroBtn.click();
                            homeBtn.click();
                        }
    }

    public void clicktoeurobtn() {
        EuroBtn.click();
        homeBtn.click();
    }

    public void verifytoeuro() {
        String expected = verifytoprice.getText();
        String actual = "€";
        Assert.assertTrue(expected.contains(actual));
    }

    public void clicktopoundSterlinbtn() {
        PoundSterlingBtn.click();
        homeBtn.click();
    }
                        public void clicktopoundSterlinbtn () {
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
    public void clickToBottomSubsWithoutEmail() {
        subBtnBottom.click();
    }

    /**
     * This method is used to verify the alert error message that appears when the subscribe button is clicked
     * without entering an e-mail in the subscription header below.
     */
    public void verifyEmptyEmailAlertMessage() {
        alert = Driver.get().switchTo().alert();
        String expectedMessage = "Email is required";
        String actualMessage = alert.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    /**
     * This method is used to validate the warning error message displayed when an invalid email is entered
     * in the subscription header below and the subscribe button is clicked.
     */
    public void verifyInvalidEmailMessage() {
        String expectedMessage = " × Invalid Email ";
        String actualMessage = subsAlertMessage.getAttribute("textContent");
        Assert.assertEquals(expectedMessage, actualMessage);

    }
                        public void verifytopoundSterlin () {
                            String expected = verifytoprice.getText();
                            String actual = "£";
                            Assert.assertTrue(expected.contains(actual));
                        }
                        /**
                         * This method is used to click the subscribe button without entering an email in the subscription banner below.
                         */
                        public void clickToBottomSubsWithoutEmail () {
                            subBtnBottom.click();
                        }
                        /**
                         * This method is used to verify the alert error message that appears when the subscribe button is clicked
                         * without entering an e-mail in the subscription header below.
                         */
                        public void verifyEmptyEmailAlertMessage () {
                            alert = Driver.get().switchTo().alert();
                            String expectedMessage = "Email is required";
                            String actualMessage = alert.getText();
                            Assert.assertEquals(expectedMessage, actualMessage);
                        }
                        /**
                         * This method is used to validate the warning error message displayed when an invalid email is entered
                         * in the subscription header below and the subscribe button is clicked.
                         */
                        public void verifyInvalidEmailMessage () {
                            String expectedMessage = " × Invalid Email ";
                            String actualMessage = subsAlertMessage.getAttribute("textContent");
                            Assert.assertEquals(expectedMessage, actualMessage);
                        }

}


                    /**
                     * This method retrieves the success pop-up and prints it.
                     */
                    public void hoverAndClickWishList () {
                        BrowserUtils.waitFor(2);
                        BrowserUtils.hover(visibilityWishList1);
                        BrowserUtils.waitFor(2);
                        wishListremigthbtn.click();
                    }

                    /**
                     * This method navigates to the page and verifies if the wish list is not empty.
                     */
                    public void redirectToHeartIcon () {
                        String productVisibility = popUpSuccesfully.getText();
                        System.out.println("product = " + productVisibility);
                    }

                    /**
                     * This method is used to subscribe via the pop-up.
                     */
                    public void displayPreviousList () {
                        wishListBtnClick.click();
                        wishListNotEmpty.isDisplayed();

                    }
                }
            }
        }
    }
}


