package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UserLoggedInHPage {
    public UserLoggedInHPage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy (css = "button[id='headlessui-menu-button-1']")
  // @FindBy (css = "svg[class='max-h-full max-w-full']")
    public WebElement menuButton;

    @FindBy (css = "svg[viewBox='0 0 512 512']")
    public WebElement bakeryButton;
    @FindBy (css = "a[href=\"/daily-needs\"]")
    public WebElement dailyNeedsButton;





}
