package ourvirtualmarket.pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ourvirtualmarket.utilities.BrowserUtils;
import ourvirtualmarket.utilities.Driver;

import javax.naming.Name;
import java.util.List;

public class ProductReturnsPage extends BasePage {
    AccountPage accountPage = new AccountPage();
    @FindBy(xpath = "//div[@id='content']/h1")
    private WebElement returnPageTitle;
    @FindBy(xpath = "//*[@id=\"content\"]/ul[1]/li[1]/a")
    private WebElement editYourAccountInfoLink;
    @FindBy(xpath = "//div[@class='radio']/label")
    public List<WebElement> formRadioButtonstext;
    @FindBy(xpath = "//div[@class='radio']/label/input")
    public List<WebElement> formRadioButtons;
    @FindBy(xpath = "//input[@type=\"submit\"]")
    private WebElement submitButton;
    @FindBy(xpath = "//div[@id=\"content\"]/p")
    private List<WebElement> formSuccessMessages;


    /*
      This method email , firstname , lastname and telephone info from your account
      If you want use this method you must use this syntax (email , firstname , lastname , telephone).
       */
    public String getCustomerInformationFromProductReturnsForm(String infoName) {
        String locator = "//input[@name='" + infoName + "'] [@id='input-" + infoName + "']";
        return Driver.get().findElement(By.xpath(locator)).getAttribute("value");
    }

    public void verifyReturnsButtonsIsVisible() {
        List<WebElement> returnsLink = returnLinks;
        for (WebElement element : returnsLink) {
            Assert.assertTrue(element.isDisplayed());
        }
    }

    public void navigateToProductReturnPage() {
        returnsLink.click();
    }

    public void verifyNavigateToProductReturnPage() {
        Assert.assertEquals(returnPageTitle.getText(), "Product Returns");
    }

    public void getCustomerInformationAndVerifyWithFormInfo(String infoName) {

        accountPage.navigateToAccountPageSubMenu("My Account");
        editYourAccountInfoLink.click();
        String actualInfo = accountPage.getCustomerInformation(infoName);
        Driver.get().navigate().back();
        Driver.get().navigate().back();
        String expectedInfo = getCustomerInformationFromProductReturnsForm(infoName);
        Assert.assertEquals(actualInfo, expectedInfo);
    }

    public void fillInAllNecessaryInformationFromReturnsForm() {
        accountPage.navigateToAccountPageSubMenu("Order History");
        Driver.get().findElement(By.xpath("//a[@data-original-title=\"View\"]")).click();
        String[] split = Driver.get().findElement(By.xpath("//*[@id=\"content\"]/table[1]/tbody/tr/td[1]")).getText().split(":");
        String orderID = split[1];
        String ProductCode = Driver.get().findElement(By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr/td[1]")).getText();
        String ProductName = Driver.get().findElement(By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr/td[2]")).getText();
        Driver.get().navigate().back();
        Driver.get().navigate().back();
        Driver.get().findElement(By.xpath("//input[@placeholder='Order ID']")).sendKeys(orderID);
        Driver.get().findElement(By.xpath("//input[@placeholder='Product Code']")).sendKeys(ProductCode);
        Driver.get().findElement(By.xpath("//input[@placeholder='Product Name']")).sendKeys(ProductName);
    }
    public void clickRadioButton(String buttonName){
        for (WebElement formRadioButton : formRadioButtonstext) {
           if (formRadioButton.getText().contains(buttonName) ){
               formRadioButtons.get(0).click();
           } if (formRadioButton.getText().contains(buttonName) ){
               formRadioButtons.get(1).click();
           } if (formRadioButton.getText().contains(buttonName) ){
               formRadioButtons.get(2).click();
           } if (formRadioButton.getText().contains(buttonName) ){
               formRadioButtons.get(3).click();
           } if (formRadioButton.getText().contains(buttonName) ){
               formRadioButtons.get(4).click();
           }
        }
    }
    public void clickSubmitButtonFromReturns(){
        submitButton.click();
    }
    public void verifySuccessFormMessage(String message){
        String actualMessage  = formSuccessMessages.get(0).getText()+" "+formSuccessMessages.get(1).getText();
        Assert.assertEquals(actualMessage,message);


    }
}
