package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UserAlliumPage {

    public UserAlliumPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "svg[viewBox='0 0 24 24']")
    public WebElement plusButton;

    @FindBy(css = "path[stroke-width='1.6']")
    public WebElement cartButton;
}
