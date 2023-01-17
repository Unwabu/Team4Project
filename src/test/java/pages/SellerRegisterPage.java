package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SellerRegisterPage {
    WebDriver driver;

    public SellerRegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "name") ////input[@id='name']
    public WebElement nameBox;

    @FindBy(id = "email")
    public WebElement mailBox;

    @FindBy(id = "password")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[.='Register']")
    public WebElement registerButton;
}
