package ourvirtualmarket.pages;

import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import ourvirtualmarket.utilities.BrowserUtils;
import ourvirtualmarket.utilities.Driver;

import java.util.List;

public class CheckoutPage extends BasePage {

    SearchPage searchPage = new SearchPage();

    @FindBy(className = "img-responsive")
    private List<WebElement> products;

    @FindBy(xpath = "//div[@class='button-group cartinfo--left']//i[@class='fa fa-shopping-basket']")
    private WebElement addToCart;

    @FindBy(css = ".fa-shopping-bag")
    private WebElement cart;

    @FindBy(xpath = "//div[@class='cart-popup-action']/a[contains(.,'View Cart')]")
    private WebElement viewCart;

    @FindBy(xpath = "//div[@class='pull-right']/a[.='Checkout']")
    private WebElement checkoutButton;

    @FindBy(id = "input-payment-firstname")
    private WebElement firstName;

    @FindBy(id = "input-payment-lastname")
    private WebElement lastName;

    @FindBy(id = "input-payment-company")
    private WebElement company;

    @FindBy(id = "input-payment-address-1")
    private WebElement address1;

    @FindBy(id = "input-payment-address-2")
    private WebElement address2;

    @FindBy(id = "input-payment-city")
    private WebElement city;

    @FindBy(id = "input-payment-postcode")
    private WebElement postcode;

    @FindBy(id = "input-payment-country")
    private WebElement country;

    @FindBy(id = "input-payment-zone")
    private WebElement zone;

    @FindBy(id = "button-payment-address")
    private WebElement continueButtonInBillingDetails;

    @FindBy(id = "button-shipping-address")
    private WebElement continueButtonInDeliveryDetails;

    @FindBy(name = "shipping_address")
    private List<WebElement> shippingAddress;

    @FindBy(xpath = "//div[@id='collapse-shipping-address']//label[contains(.,'I want to use a new address')]")
    private WebElement updateAddressButton;

    @FindBy(name = "comment")
    private WebElement comment;

    @FindBy(id = "button-shipping-method")
    private WebElement continueButtonInDeliveryMethod;











    /**
     * This method adds a product to the cart
     *
     * @param productName
     */
    public void addProductToCart(String productName) {
        searchMethod(productName);
        BrowserUtils.hover(products.get(0));
        BrowserUtils.waitFor(2);
        addToCart.click();
    }

    /**
     * This method searches for a product
     */
    public void navigateToCart() {
        viewCart.click();
    }

    /**
     * This method verifies the product in the cart
     *
     * @param productName
     */
    public void verifyProductInCart(String productName) {
        WebElement actualProduct = Driver.get().findElement(By.xpath("//td[.='" + productName + "']"));
        Assert.assertTrue(actualProduct.isDisplayed());
    }

    /**
     * This method verifies the checkout button
     */
    public void verifyCheckoutButton() {
        Assert.assertTrue(checkoutButton.isDisplayed());
    }

    /**
     * This method clicks on the checkout button
     */
    public void clickCheckoutButton() {
        checkoutButton.click();
    }

    /**
     * This method verifies the menu
     *
     * @param menu
     */
    public void verifyMenu(String menu) {
        WebElement menuWebElement = Driver.get().findElement(By.xpath("//a[contains(.,'" + menu + "')]"));
        Assert.assertTrue(menuWebElement.isEnabled());
    }

    /**
     * This method fills in all the menus and clicks on the Continue button
     */
    public void fillInAllMenus() {
        if (firstName.isDisplayed()) {
            firstName.sendKeys(faker.name().firstName());
            lastName.sendKeys(faker.name().lastName());
            company.sendKeys(faker.company().name());
            address1.sendKeys(faker.address().streetAddress());
            address2.sendKeys(faker.address().secondaryAddress());
            city.sendKeys(faker.address().city());
            postcode.sendKeys(faker.address().zipCode());
            Select selectCountry = new Select(country);
            selectCountry.selectByVisibleText("Turkey");
            Select selectZone = new Select(zone);
            selectZone.selectByVisibleText("İzmir");
            BrowserUtils.waitFor(2);
            continueButtonInBillingDetails.click();
        } else
            continueButtonInBillingDetails.click();
    }

    /**
     * This method verifies the current address
     */
    public void verifyCurrentAddress() {
        Assert.assertTrue(shippingAddress.get(0).isSelected());
    }

    /**
     * This method verifies the update address button
     */
    public void verifyUpdateAddressButton() {
        Assert.assertTrue(updateAddressButton.isEnabled());
    }

    /**
     * This method selects the delivery address and clicks on the Continue button
     */
    public void selectDeliveryAddress() {
        continueButtonInDeliveryDetails.click();
    }

    /**
     * This method verifies the delivery method
     *
     * @param flatShippingRate
     */
    public void verifyDeliveryMethod(String flatShippingRate) {
        WebElement flatShippingRateWebElement = Driver.get().findElement(By.xpath("//label[contains(.,'" + flatShippingRate + "')]"));
        Assert.assertTrue(flatShippingRateWebElement.isEnabled());
    }

    /**
     * This method verifies the comment space
     */
    public void verifyCommentSpace() {
        Assert.assertTrue(comment.isEnabled());
    }

}
