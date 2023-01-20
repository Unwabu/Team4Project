package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SarpPage {
    public SarpPage () {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//*[.=\"Shops\"])[2]")
    public WebElement shopButton;

    @FindBy(xpath = "(//button[@data-variant=\"normal\"])[1]")
    public WebElement joinButton;

    @FindBy(xpath = "(//button[@data-variant=\"normal\"])[3]")
    public WebElement loginButton;

    @FindBy(xpath = "(//button[@class])[3]")
    public WebElement profilButton;

    @FindBy(xpath = "(//a[@class])[8]")
    public WebElement changePasswordButton;

    @FindBy (xpath = "(//button[@class])[4]")
    public WebElement submitButton;

    @FindBy (xpath = "(//input[@id])[1]")
    public WebElement ilkKutu;

    @FindBy (xpath = "(//input[@id])[2]")
    public WebElement ikinciKutu;

    @FindBy (xpath = "(//input[@id])[3]")
    public WebElement ucuncuKutu;

    @FindBy (xpath = "(//button[@class])[4]")
    public WebElement myOrderButton;


    @FindBy (xpath = "(//a[@class])[17]")
    public WebElement detailsButton;

    @FindBy (xpath = "(//button[@class])[5]")
    public WebElement wishlistButton;

    @FindBy (xpath = "(//button[@class])[10]")
    public WebElement removedButton;

//    @FindBy (xpath = "(//button[@class])[10]")
//    public WebElement removedButton2;

    @FindBy (xpath = "(//button[@class])[7]")
    public WebElement logoutButton;













}
