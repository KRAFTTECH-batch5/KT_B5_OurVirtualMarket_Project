package ourvirtualmarket.pages;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ourvirtualmarket.utilities.BrowserUtils;
import ourvirtualmarket.utilities.Driver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class ProductComparisonPage extends BasePage {

    WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(5));


    @FindBy(xpath = "//*[@id='menuHeading']/div/div/div")
    private WebElement l_allCategoryBar;
    private String categoryBar="//*[@id='menuHeading']/div/div/div";

    @FindBy(id = "product-image-6816626")
    private WebElement l_product1;

    @FindBy(id = "product-image-7850424")
    private WebElement l_product2;

    @FindBy(xpath = "//li[@class='compare']")
    private WebElement l_addToCompareButton;

    @FindBy(xpath = "//div[@class='alert alert-info']")
    private WebElement l_addToCompareSuccessMessage;

    @FindBy(id = "product-image-6816624")
    private WebElement l_product3;

    @FindBy(id = "product-image-5854510")
    private WebElement l_product4;

    @FindBy(id = "product-image-5535113")
    private WebElement l_product5;



    @FindBy(id = "compare-total")
    private WebElement l_compareButton;

    @FindBy(xpath = "//h1")
    private WebElement l_comparisonPageVerifyText;


    public void navigatesToGivenCategory(String categoryName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(categoryBar)));
        WebElement hoverElement = Driver.get().findElement(By.xpath(categoryBar));
        BrowserUtils.hover(hoverElement);

        WebElement clickToCategory = Driver.get().findElement(By.xpath("//span//strong[contains(text(),'" + categoryName + "')]"));
        BrowserUtils.waitFor(1);
        clickToCategory.click();
    }

    public void addTwoProductsOnComparisonList(){

        wait.until(ExpectedConditions.visibilityOf(l_product1));
        BrowserUtils.hover(l_product1);
        l_product1.click();
        BrowserUtils.waitFor(1);
        l_addToCompareButton.click();
        String actualText;
        String expectedText="Success: You have added ";
        try {
            WebElement addToCompareMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                    "/html/body/div[1]/a[1]/..")));
            actualText = addToCompareMessage.getText();
            System.out.println("1. product added = " + actualText);
            Assert.assertTrue(actualText.contains(expectedText));
        } catch (Exception e) {
            System.err.println("yazı bulunamadı");
        }
        BrowserUtils.waitFor(1);
        Driver.get().navigate().back();

        wait.until(ExpectedConditions.visibilityOf(l_product2));
        BrowserUtils.hover(l_product2);
        l_product2.click();
        BrowserUtils.waitFor(1);
        l_addToCompareButton.click();
        try {
            WebElement addToCompareMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                    "/html/body/div[1]/a[1]/..")));
            actualText = addToCompareMessage.getText();
            System.out.println("2. product added = " + actualText);
            Assert.assertTrue(actualText.contains(expectedText));
        } catch (Exception e) {
            System.err.println("yazı bulunamadı");
        }
        BrowserUtils.waitFor(1);
        Driver.get().navigate().back();

    }

    public void addProductToCompareList(){
        wait.until(ExpectedConditions.visibilityOf(l_product3));
        BrowserUtils.hover(l_product3);
        l_product3.click();
        wait.until(ExpectedConditions.visibilityOf(l_addToCompareButton));
        l_addToCompareButton.click();
    }

    public void verifyAddingProductToCompareListMessage(String message){
        String actualText;
        String expectedText=message;
        try {
            WebElement addToCompareMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                    "/html/body/div[1]/a[1]/..")));
            actualText = addToCompareMessage.getText();
            System.out.println("3. product added = " + actualText);
            Assert.assertTrue(actualText.contains(expectedText));
        } catch (Exception e) {
            System.err.println("yazı bulunamadı");
        }
        BrowserUtils.waitFor(1);
        Driver.get().navigate().back();
    }

    public void clickToCompareButton(){
        wait.until(ExpectedConditions.visibilityOf(l_compareButton));
        l_compareButton.click();
    }

    public void comparisonPageVerify(){
        String expectedResult="Product Comparison";
        String actualResult=l_comparisonPageVerifyText.getText();
        Assert.assertEquals(expectedResult,actualResult);
    }

    public void verifyComparisonTerms(List<String> list){
        List<String> compareTermNames=new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            compareTermNames.add(Driver.get().findElement(By.xpath(
                    "//*[@id='content']/table/tbody[1]/tr["+(i+1)+"]/td[1]")).getText());
            System.out.println("compareTermNames.get(i) = " + compareTermNames.get(i));
            System.out.println("list.get(i) = " + list.get(i));
            Assert.assertEquals(list.get(i),compareTermNames.get(i));
        }
    }
    public void addThirdProductToComparisonList(){
        wait.until(ExpectedConditions.visibilityOf(l_product3));
        BrowserUtils.hover(l_product3);
        l_product3.click();
        wait.until(ExpectedConditions.visibilityOf(l_addToCompareButton));
        l_addToCompareButton.click();
        WebElement addToCompareMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "/html/body/div[1]/a[1]/..")));
        String actualText = addToCompareMessage.getText();
        System.out.println("3. product added = " + actualText);
        BrowserUtils.waitFor(1);
        Driver.get().navigate().back();
    }

    public void addFourthProductToComparisonList(){
        wait.until(ExpectedConditions.visibilityOf(l_product4));
        BrowserUtils.hover(l_product4);
        l_product4.click();
        wait.until(ExpectedConditions.visibilityOf(l_addToCompareButton));
        l_addToCompareButton.click();
        WebElement addToCompareMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "/html/body/div[1]/a[1]/..")));
        String actualText = addToCompareMessage.getText();
        System.out.println("4. product added = " + actualText);
        BrowserUtils.waitFor(1);
        Driver.get().navigate().back();
    }

    public void addFifthProductToComparisonList(){
        wait.until(ExpectedConditions.visibilityOf(l_product5));
        BrowserUtils.hover(l_product5);
        l_product5.click();
        wait.until(ExpectedConditions.visibilityOf(l_addToCompareButton));
        l_addToCompareButton.click();

    }

    public void verifyWarningMessageThatProductFifthCannotBeAddedToComparisonList(String message){
        String actualText;
        try {
            WebElement addToCompareWarningMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                    "/html/body/div[1]/div/button/..")));
            actualText = addToCompareWarningMessage.getText();
            System.out.println("5. product error message = " + actualText);
            Assert.assertEquals(message,actualText);
        } catch (Exception e) {
            System.err.println("yazı bulunamadı");
        }

    }






}
