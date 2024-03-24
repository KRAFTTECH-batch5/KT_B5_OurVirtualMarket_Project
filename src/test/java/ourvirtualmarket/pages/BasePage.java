package ourvirtualmarket.pages;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ourvirtualmarket.utilities.BrowserUtils;
import ourvirtualmarket.utilities.Driver;


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

    @FindBy(xpath = "//*[text()='Remington NE3150 Smart']")
    private WebElement visibilityWishList1;
    @FindBy(xpath = "//img[@alt='Noerden Minimi Smart Body Scale']")
    private WebElement visibilityWishList2;
    @FindBy(xpath = "//img[@alt='Nicky Clarke NHD146 Hair Therapy Touch Control Hair Dryer']")
    private WebElement visibilityWishList3;
    @FindBy(xpath = "//button[contains(@onclick, wishlist.add('5719773'))]")
    private WebElement addToWishListButtonClick;
    @FindBy(xpath = "(//button[@class='wishlist btn-button'])[4]")
    private WebElement wishListremigthbtn;


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
    public void closePopUpWithoutCheckbox() {
        subsPopupClose.click();
    }

    public void navigateToRegisterPage() {
        registerBtn.click();
    }

    public void navigateToHomePage() {
        homeBtn.click();
    }

    public void verifySubsPopUpIsVisible() {
        subsPopUp.isDisplayed();
    }

    public void verifySubsPopUpIsNotVisible() {
        //burayı yapamadım kafayı yicem sabahın 5'inde
    }

    public void verifyBottomSubsIsVisible() {
        bottomSubs.isDisplayed();
    }

    /**
     * This method verifies that the search button is displayed.
     */
    public void isSearchBtnDisplay() {
        Assert.assertTrue(searchBtn.isDisplayed());
    }

    /**
     * This method verifies that the search bar is displayed.
     */
    public void isSearchBarDisplay() {
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

    public void verifySuccessfulSubs() throws InterruptedException {
        String expectedMessage = " × Subcription was successfull";
        String actualMessage = validPopUpMessage.getAttribute("textContent");
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    public WebElement[] getVisibilityWishLists() {
        return new WebElement[]{visibilityWishList1, visibilityWishList2, visibilityWishList3};
    }

    public void hoverAndClickWishList() {
        BrowserUtils.waitFor(2);
        BrowserUtils.hover(visibilityWishList1);
        BrowserUtils.waitFor(2);
        wishListremigthbtn.click();

    }


}