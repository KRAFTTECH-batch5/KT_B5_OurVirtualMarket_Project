package ourvirtualmarket.pages;

import org.openqa.selenium.support.PageFactory;
import ourvirtualmarket.utilities.Driver;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }
}
