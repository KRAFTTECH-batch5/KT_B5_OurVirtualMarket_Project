package ourvirtualmarket.pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ourvirtualmarket.utilities.BrowserUtils;
import ourvirtualmarket.utilities.Driver;

import java.time.Duration;
import java.util.List;


public class FilteringFuncsPage {

    WebDriver driver;

    Actions actions = new Actions(Driver.get());

    @FindBy (xpath = "//input[@id='text_search']")
    private WebElement l_SearchBar;

    @FindBy (xpath = "//div[@class='so-filter-option opt-select  opt_enable']/div[@class='so-option-container']")
    private WebElement l_ManufacturerTab;

    @FindBy (xpath = ".//div[@class='content_min_max']")
    private WebElement l_RangeTab;

    @FindBy (xpath = "//button[@class='btn btn-default']") //  //button[@class='btn btn-default'] // //button[@id='submit_text_search']
    private WebElement l_clickSearchBtn;

    @FindBy(xpath = "//h4/a")
    public List<WebElement> productNames;

    public void clickOnMainProductOpts() {
        WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='navbar-header'])[2]")));
        WebElement hoverElement = Driver.get().findElement(By.xpath("(//div[@class='navbar-header'])[2]"));
        BrowserUtils.hover(hoverElement);
    }

    public void megaMenu(String mainProduct) {
        WebElement clickOnMainProduct = Driver.get().findElement(By.xpath("//span//strong[contains(text(),'" + mainProduct + "')]"));
        clickOnMainProduct.click();
    }

    public void getArrowBtn1() {
        WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(2));
        wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//div[@class='module so_filter_wrap block-shopby']//li[1]//i[@class='fa fa-chevron-down']"))).click();
    }

    public void isSearchBarVisible() {
        Assert.assertNull(l_SearchBar);
    }

    public void getArrowBtn2() {
        WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(2));
        wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//div[@class='module so_filter_wrap block-shopby']//li[2]//i[@class='fa fa-chevron-down']"))).click();
    }

    public void isManufacturerTabVisible() {
        Assert.assertNull(l_ManufacturerTab);
    }

    public void getArrowBtn3() {
        WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(2));
        wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//div[@class='module so_filter_wrap block-shopby']//li[3]//i[@class='fa fa-chevron-down']"))).click();
    }

    public void isRangeTabVisible() {
        Assert.assertNull(l_ManufacturerTab);
    }

    public void searchProduct(String productName) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(2));
        wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//input[@id='text_search']"))).sendKeys(productName);
        actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
    }

    public void verifyThatTheSearchPageContainsValidProducts(String searchData) {
        List<String> productNameList = BrowserUtils.getElementsText(productNames);
        for (String productName : productNameList) {
            if (productName.contains(searchData)) {
                Assert.assertTrue(searchData, true);
                return; // Doğrulama başarılı olduğu için fonksiyondan çık
            }   Assert.fail(searchData);
        }
    }


}
