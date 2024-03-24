package ourvirtualmarket.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ourvirtualmarket.utilities.BrowserUtils;

import java.util.List;

public class CheckoutPage extends BasePage{

    @FindBy(className = "img-responsive")
    private List<WebElement> products;

    @FindBy(xpath = "//div[@class='button-group cartinfo--left']//i[@class='fa fa-shopping-basket']")
    private WebElement addToCart;

    public void addProductToCart(String productName){
        searchMethod(productName);
        BrowserUtils.hover(products.get(0));
        addToCart.click();
    }
}
