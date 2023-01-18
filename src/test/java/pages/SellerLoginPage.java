package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SellerLoginPage {


    public SellerLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//input[@id='email']")
    public WebElement mailBox;

    @FindBy (id = "password")
    public WebElement passwordBox;

    @FindBy (xpath = "//button[text()='Login']")
    public WebElement loginButton;







}
