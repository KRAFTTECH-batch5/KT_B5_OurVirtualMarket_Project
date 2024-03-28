package ourvirtualmarket.pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import ourvirtualmarket.utilities.BrowserUtils;
import ourvirtualmarket.utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class CheckoutPage extends BasePage {

    public String flatShippingRate;
    public List<String> productQuantities ;
    public List<String> productUnitPrices ;
    public List<String> productTotalPrices ;
    public List<String> productModels ;
    public List<String> productNames ;
    public String totalPrice;

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

    @FindBy(name = "agree")
    private WebElement agree;

    @FindBy(id = "button-payment-method")
    private WebElement continueButtonInPaymentMethod;

    @FindBy(id = "button-confirm")
    private WebElement confirmButton;

    @FindBy(xpath = "//a[.='track your order']")
    private WebElement followProductButton;

    @FindBy(xpath = "//div[@id='so-groups']/a[3]/i[@class='fa fa-user']")
    private WebElement myAccountButton;

    @FindBy(css = ".fa-history")
    private WebElement orderHistoryButton;

    @FindBy(xpath = "//div[@id='collapse-shipping-method']//div[@class='radio']")
    private WebElement flatShippingRatePrice;

    @FindBy(xpath = "//table[@class='table table-bordered']/tbody//td[@class='text-center']")
    private List<WebElement> shoppingCartItems;

    @FindBy(css = ".table-bordered > tbody > tr")
    private List<WebElement> shoppingCartItems2;

    @FindBy(css =".col-sm-offset-8 tr:nth-of-type(2) > td:nth-of-type(2)")
    private WebElement totalPriceInShoppingCart;

    @FindBy(css = "tr:nth-of-type(5) > td:nth-of-type(2)")
    private WebElement totalPriceWithFlatShippingRate;

    @FindBy(xpath = "//a[text() ='Continue']")
    public WebElement continueButtonInSuccessShop;


    /**
     * This method adds a product to the cart
     *
     * @param productName
     */
    public void addProductToCart(String productName) {
        searchMethod(productName);
        BrowserUtils.waitFor(1);
        BrowserUtils.hover(products.get(0));
        BrowserUtils.waitFor(1);
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
        getShoppingCartItemsInfo();
        unitPriceMultipleQuantities();
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
        BrowserUtils.waitFor(1);
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
        getFlatShippingRatePrice();
    }

    /**
     * This method verifies the comment space
     */
    public void verifyCommentSpace() {
        Assert.assertTrue(comment.isEnabled());
    }

    /**
     * This method clicks on the Continue button
     */
    public void clickContinueButton() {
        continueButtonInDeliveryMethod.click();
    }

    /**
     * This method verifies the payment method
     *
     * @param Cash_on_Delivery
     */
    public void verifyPaymentMethod(String Cash_on_Delivery) {
        WebElement paymentMethodWebElement = Driver.get().findElement(By.xpath("//label[contains(.,'" + Cash_on_Delivery + "')]"));
        Assert.assertTrue(paymentMethodWebElement.isEnabled());
    }

    /**
     * This method verifies the Terms and Conditions button
     */
    public void verifyTermsAndConditionsButton() {
        Assert.assertTrue(agree.isEnabled());
    }

    /**
     * This method accepts Terms & Conditions and clicks on the Continue button
     */
    public void acceptTermsAndConditions() {
        agree.click();
        continueButtonInPaymentMethod.click();
    }

    /**
     * This method verifies the order details
     */
    public void verifyOrderDetails() {
        for (int i = 1; i <= shoppingCartItems2.size(); i++) {
            for (int j = 1; j < 6; j++) {
                if (j == 1) {
                    Assert.assertEquals(productNames.get(i - 1), Driver.get().findElement(By.cssSelector(".table-bordered > tbody > tr:nth-of-type(" + i + ") > td:nth-of-type(" + j + ")")).getText());
                } else if (j == 2) {
                    Assert.assertEquals(productModels.get(i - 1), Driver.get().findElement(By.cssSelector(".table-bordered > tbody > tr:nth-of-type(" + i + ") > td:nth-of-type(" + j + ")")).getText());
                } else if (j == 3) {
                    Assert.assertEquals(productQuantities.get(i - 1), Driver.get().findElement(By.cssSelector(".table-bordered > tbody > tr:nth-of-type(" + i + ") > td:nth-of-type(" + j + ")")).getText());
                } else if (j == 4) {
                    Assert.assertEquals(productUnitPrices.get(i - 1), Driver.get().findElement(By.cssSelector(".table-bordered > tbody > tr:nth-of-type(" + i + ") > td:nth-of-type(" + j + ")")).getText());
                } else if (j == 5) {
                    Assert.assertEquals(productTotalPrices.get(i - 1), Driver.get().findElement(By.cssSelector(".table-bordered > tbody > tr:nth-of-type(" + i + ") > td:nth-of-type(" + j + ")")).getText());
                }
            }
        }
        calculateTotalPriceWithFlatShippingRate();
    }

    /**
     * This method clicks on the Confirm Order button
     */
    public void clickConfirmOrderButton() {
        confirmButton.click();
        BrowserUtils.waitFor(2);
    }

    /**
     * This method verifies the order messages
     * @param messages
     */
    public void verifyOrderMessages(List<String> messages) {
        String actualOrderMessage = Driver.get().findElement(By.cssSelector("h1")).getText();
        String expectedOrderMessage = messages.get(0);
        Assert.assertEquals(expectedOrderMessage, actualOrderMessage);
        for (int i = 1; i < messages.size(); i++) {
            WebElement messageWebElement = Driver.get().findElement(By.xpath("//p[contains(.,'" + messages.get(i) + "')]"));
            Assert.assertEquals(messages.get(i), messageWebElement.getText());
        }
    }

    /**
     * This method verifies the Track Your Order button
     */
    public void verifyFollowProductButton() {
        Assert.assertTrue(followProductButton.isEnabled());
    }

    /**
     * This method navigates to the Order History page
     */
    public void navigateToOrderHistory() {
        myAccountButton.click();
        orderHistoryButton.click();
    }

    /**
     * This method verifies the order history
     */
    public void verifyOrderHistory() {
        for (int i = 1; i < 7; i++) {
            WebElement element = Driver.get().findElement(By.xpath("(//tbody//td)[" + i + "]"));
            Assert.assertTrue(element.isDisplayed());
        }
    }

    /**
     * This method gets the flat shipping rate price
     */
    public void getFlatShippingRatePrice() {
        String str = flatShippingRatePrice.getText();
        flatShippingRate = str.substring(22, str.length() - 3);
    }

    /**
     * This method gets the shopping cart items info
     */
    public void getShoppingCartItemsInfo() {
        for (int i = 1; i <= shoppingCartItems.size(); i++) {
            for (int j = 2; j < 7; j++) {
                if (j == 2) {
                    productNames.add(Driver.get().findElement(By.cssSelector(".table-responsive tbody > tr:nth-of-type(" + i + ") > td:nth-of-type(" + j + ")")).getText());
                } else if (j == 3) {
                    productModels.add(Driver.get().findElement(By.cssSelector(".table-responsive tbody > tr:nth-of-type(" + i + ") > td:nth-of-type(" + j + ")")).getText());
                } else if (j == 4) {
                    productQuantities.add(Driver.get().findElement(By.cssSelector(".table-responsive tr:nth-of-type(" + i + ") .form-control")).getAttribute("value"));
                } else if (j == 5) {
                    productUnitPrices.add(Driver.get().findElement(By.cssSelector(".table-responsive tbody > tr:nth-of-type(" + i + ") > td:nth-of-type(" + j + ")")).getText());
                } else if (j == 6) {
                    productTotalPrices.add(Driver.get().findElement(By.cssSelector(".table-responsive tbody > tr:nth-of-type(" + i + ") > td:nth-of-type(" + j + ")")).getText());
                }
            }
        }
        totalPrice = totalPriceInShoppingCart.getText();
        calculateTotalInShoppingCart();
    }

    /**
     * This method calculates the total in the shopping cart
     * @return
     */
    public Double calculateTotalInShoppingCart() {
        double total = 0;
        for (int i = 0; i < productTotalPrices.size(); i++) {
            total += Double.parseDouble(productTotalPrices.get(i).substring(1));
        }
        Assert.assertEquals(total, Double.parseDouble(totalPrice.substring(1)), 0.01);
        return total;
    }

    /**
     * This method calculates the total price with flat shipping rate
     */
    public void calculateTotalPriceWithFlatShippingRate() {
        double total = calculateTotalInShoppingCart();
        double flatShippingRate = Double.parseDouble(this.flatShippingRate);
        double totalPrice = Double.parseDouble(totalPriceWithFlatShippingRate.getText().substring(1));
        Assert.assertEquals(totalPrice, total + flatShippingRate, 0.01);
    }

    /**
     * This method verifies the unit price multiple quantities
     */
    public void unitPriceMultipleQuantities() {
        for (int i = 0; i < productUnitPrices.size(); i++) {
            double unitPrice = Double.parseDouble(productUnitPrices.get(i).substring(1));
            double quantity = Double.parseDouble(productQuantities.get(i));
            double total = Double.parseDouble(productTotalPrices.get(i).substring(1));
            Assert.assertEquals(total, unitPrice * quantity, 0.01);
        }
    }
}
