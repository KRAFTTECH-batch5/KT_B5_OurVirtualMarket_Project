package ourvirtualmarket.pages;

import com.github.javafaker.Faker;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
    @FindBy(xpath = "//span[@class='items_cart']")
    private WebElement addToCard;
    @FindBy(xpath = "//*[text()='Remington NE3150 Smart']")
    private WebElement visibilityControl;
    @FindBy(xpath = "//*[text()='Remington NE3150 Smart']")
    private WebElement addToCardBTNdisplayed;
    @FindBy(xpath = "//*[@id=\"cart\"]/a/div/div/span/span[3]")
    private WebElement totalPayments;

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

}
