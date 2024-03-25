package ourvirtualmarket.pages;

import io.cucumber.messages.types.ParseError;
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


public class FilteringFuncsPage extends BasePage{

    WebDriver driver;

    Actions actions = new Actions(Driver.get());

    @FindBy (xpath = "//input[@id='text_search']")
    private WebElement l_SearchBar;

    @FindBy (xpath = "//div[@class='so-filter-option opt-select  opt_enable']/div[@class='so-option-container']")
    private WebElement l_ManufacturerTab;

    @FindBy (xpath = ".//div[@class='content_min_max']")
    private WebElement l_RangeTab;

    @FindBy (xpath = "//button[@class='btn btn-default']")
    private WebElement l_clickSearchBtn;

    @FindBy(className = "img-responsive")
    public List<WebElement> productNames;

    @FindBy(xpath = "//span[.='54']")
    public WebElement l_palmNumber;

    @FindBy(className = "price-new")
    public List<WebElement> productPrices;

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
        Assert.assertNotNull(l_SearchBar);
    }

    public void getArrowBtn2() {
        WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(2));
        wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//div[@class='module so_filter_wrap block-shopby']//li[2]//i[@class='fa fa-chevron-down']"))).click();
    }

    public void isManufacturerTabVisible() {
        Assert.assertNotNull(l_ManufacturerTab);
    }

    public void getArrowBtn3() {
        WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(2));
        wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//div[@class='module so_filter_wrap block-shopby']//li[3]//i[@class='fa fa-chevron-down']"))).click();
    }

    public void isRangeTabVisible() {
        Assert.assertNotNull(l_ManufacturerTab);
    }

    public void searchProduct(String productName) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(2));
        wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//input[@id='text_search']"))).sendKeys(productName);
        actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
    }

    public void verifyValidProducts(String searchData) throws InterruptedException {
        Thread.sleep(2000);
        List<String> productNameList = BrowserUtils.getElementsText(productNames);
        for (String productName : productNameList) {
            if (productName.contains(searchData)) {
                Assert.assertTrue(searchData, true);
            }
        }
    }

    public void verifyPalmNumber(){
        int expectedPalmNumber = 54;
        int actualPalmNumber = Integer.parseInt(l_palmNumber.getText());
        Assert.assertEquals(expectedPalmNumber,actualPalmNumber);
    }

    public void setPriceRange(String minPrice, String maxPrice) {
        WebElement minPriceInput = Driver.get().findElement(By.cssSelector(".input_min")); // minPrice input elementine ulaşma
        WebElement maxPriceInput = Driver.get().findElement(By.cssSelector(".input_max")); // maxPrice input elementine ulaşma

        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        minPriceInput.sendKeys(del + minPrice);
        BrowserUtils.waitFor(2);
        maxPriceInput.sendKeys(del + maxPrice + Keys.ENTER);
        BrowserUtils.waitFor(2);
    }

    public void getProductPrices() {
        BrowserUtils.waitFor(3);
        List<String> productPriceList = BrowserUtils.getElementsText(productPrices);
        System.out.println(productPriceList);
        for (String prices : productPriceList) {
            String sub = prices.substring(1,4);
            if (Integer.valueOf(sub)>150&&Integer.valueOf(sub)<250) {
                Assert.assertTrue(sub,true);
            } else {
                Assert.fail();
            }
        }
    }


}
