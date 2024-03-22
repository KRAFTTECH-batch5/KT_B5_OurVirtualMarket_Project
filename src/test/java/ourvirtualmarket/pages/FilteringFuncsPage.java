package ourvirtualmarket.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ourvirtualmarket.utilities.BrowserUtils;
import ourvirtualmarket.utilities.Driver;

import java.util.List;

public class FilteringFuncsPage {

    @FindBy (xpath = "//i[@class='fa fa-bars']")
    private WebElement l_mainProductOptions;


    public void clickOnMainProductOpts() {
        WebElement mainProductOptions = l_mainProductOptions;
        BrowserUtils.hover(mainProductOptions);
    }

    public void megaMenu(String mainProduct){
        WebElement clickOnMainProduct = Driver.get().findElement(By.xpath("//span//strong[contains(text(),'" + mainProduct + "')]"));
        clickOnMainProduct.click();
    }

}
