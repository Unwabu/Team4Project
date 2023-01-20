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


    //  @FindBy(linkText = "Create Shop")
 @FindBy(xpath = "//a[@href=\"/shops/create\"]")

    public WebElement createShopButton;

  @FindBy(xpath = "//a[@href='/my-shops']")

    public WebElement myShopButton;

   @FindBy(css = "svg[viewbox='0 0 26 28.026']")

    public WebElement productsButton;

  @FindBy(css = "div[class='flex w-full flex-col']")
    public WebElement forWait;


}















