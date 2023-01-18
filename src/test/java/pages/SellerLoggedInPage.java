package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SellerLoggedInPage {

    public SellerLoggedInPage()  {
        PageFactory.initElements(Driver.getDriver(), this);
    }



    @FindBy (xpath = "//span[@class='text-xs']")
    public WebElement loggedInMailText;

    @FindBy(css = "img[alt=\"avatar\"]")
    public WebElement avatarIcon;


    @FindBy(linkText = "Create Shop")
    public WebElement createShopButton;

  @FindBy(xpath = "//a[@href='/my-shops']")
    public WebElement myShopButton;

}















