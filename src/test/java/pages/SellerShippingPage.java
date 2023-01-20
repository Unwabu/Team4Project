package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SellerShippingPage {

    public SellerShippingPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@href='/login']")
    public WebElement saticiLogin;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailBox;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//button")
    public WebElement login;

    @FindBy(xpath = "//a[@href='/shippings']")
    public WebElement shippings;

    @FindBy(xpath = "//span[text()='Shipping']")
    public WebElement addShippingButton1;

    @FindBy(xpath = "//input[@id='name']")
    public WebElement descriptionNameBox;

    @FindBy(xpath = "//label[@for='FREE']")
    public WebElement typeFree;

    @FindBy(xpath = "//label[@for='FIXED']")
    public WebElement typeFixed;

    @FindBy(xpath = "//label[@for='PERCENTAGE']")
    public WebElement typePercentage;

    @FindBy(xpath = "//input[@id='amount']")
    public WebElement amountBox;

    @FindBy(xpath = "//button[text()='Shipping']")
    public WebElement addShippingButton2;

    @FindBy(xpath = "(//td[contains(@class,'rc-table-cell')])[2]")
    public WebElement nameText;

}
