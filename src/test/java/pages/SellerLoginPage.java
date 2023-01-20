package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SellerLoginPage {


    public SellerLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (css = "input[id='email']")
    public WebElement mailBox;

    @FindBy (css = "input[id=\"password\"]")
    public WebElement passwordBox;

    @FindBy (css = "button[data-variant=\"normal\"]")
    public WebElement loginButton;







}
