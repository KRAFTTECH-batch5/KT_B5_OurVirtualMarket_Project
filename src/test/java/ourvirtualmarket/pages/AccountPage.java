package ourvirtualmarket.pages;

import org.openqa.selenium.By;
import ourvirtualmarket.utilities.Driver;

public class AccountPage extends BasePage{
    public void navigateToAccountPageSubMenu(String subMenuName){
        String locator = "//a[text()='"+subMenuName+"'][@class='list-group-item']";
        Driver.get().findElement(By.xpath(locator)).click();
    }
   /*
   This method email , firstname , lastname and telephone info from your account
   If you want use this method you must use this syntax (email , firstname , lastname , telephone).
    */
    public String getCustomerInformation(String infoName){
        String locator = "//input[@name='"+infoName+"'] [@id='input-"+infoName+"']";
        return Driver.get().findElement(By.xpath(locator)).getAttribute("value");
    }
}
