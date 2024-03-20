package ourvirtualmarket.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ourvirtualmarket.utilities.Driver;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }
    Faker faker=new Faker();


    @FindBy(xpath = "//button[@class='popup-close']")
    private WebElement subsPopupClose;
    @FindBy(xpath = "//input[@name='hidden-popup']")
    private WebElement subsCheckBox;
    @FindBy(xpath = "//div[@class='signin-w font-title hidden-sm hidden-xs']//a[text()='Register']")
    private WebElement registerBtn;
    @FindBy (xpath = "(//i[@class='fa fa-search'])[3]")
    public WebElement alternativeSearchBtn;

    @FindBy (xpath = "(//span[text()='Search'])[1]")
    public WebElement searchText;
    @FindBy (xpath = "(//input[@type='text'])[3]")
    public WebElement searchArea;

    @FindBy (xpath = "(//input[@name='search'])[2]")
    public WebElement searchBoxBtn;

    @FindBy (xpath = "(//a[@class='popup-close'])[4]")
    public WebElement toCloseSearchBox;

    @FindBy (xpath = "(//div[@class='row']//b)[1]")
    public WebElement welcomeMessage;

    /**
     * This method closes the "popup" on the main page.
     */
    public void closePopUp() {
        subsCheckBox.click();
        subsPopupClose.click();
    }

    public void closePopUpWithoutCheckbox(){
        subsPopupClose.click();
    }

    public void navigateToRegisterPage(){
        registerBtn.click();
    }
}
