package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class JoinPage {
    public JoinPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailBox;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordBox;

    @FindBy(xpath = "(//button[@data-variant='normal'])[3]")
    public WebElement loginButton;

    @FindBy(xpath = "//img[@alt='user name']")
    public WebElement loginAvatar;

    @FindBy(xpath = "//p[text()='The credentials was wrong!']")
    public WebElement hataMesaji;

    @FindBy(xpath = "//li[@role='menuitem']")
    public List<WebElement> kullaniciMenuList;

    @FindBy(xpath = "(//li[@role='menuitem'])[1]")
    public WebElement points;

    @FindBy(xpath = "(//li[@role='menuitem'])[2]")
    public WebElement profile;

    @FindBy(xpath = "(//li[@role='menuitem'])[3]")
    public WebElement myOrders;

    @FindBy(xpath = "(//li[@role='menuitem'])[4]")
    public WebElement myWishlists;

    @FindBy(xpath = "(//li[@role='menuitem'])[5]")
    public WebElement checkout;

    @FindBy(xpath = "(//li[@role='menuitem'])[6]")
    public WebElement logout;

    @FindBy(xpath = "//a[text()='Profile']")
    public WebElement waitIcinElement;

    @FindBy(xpath = "//p[text()='Contact Number']")
    public WebElement waitIcinElementCheckout;





}
