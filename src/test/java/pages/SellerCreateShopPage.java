package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SellerCreateShopPage {


    public SellerCreateShopPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
@FindBy(xpath = "//input[@id='name']")
public WebElement nameBox;

    @FindBy(xpath = "//textarea[@id='description']")
public WebElement descriptionTextArea;

      @FindBy(xpath = "//input[@id='balance.payment_info.name']")
public WebElement accountHolderNameBox;

      @FindBy(xpath = "//input[@id='balance.payment_info.email']")
public WebElement accountHolderEMailBox;
      @FindBy(xpath = "//input[@id='balance.payment_info.bank']")
public WebElement bankNAmeBox;

      @FindBy(xpath = "//input[@id='balance.payment_info.account']")
public WebElement accountNumberBox;

      @FindBy(xpath = "//input[@id='address.country']")
public WebElement countryBox;

      @FindBy(xpath = "//input[@id='address.city']")
public WebElement cityBox;

      @FindBy(xpath = "//input[@id='address.state']")
public WebElement stateBox;

      @FindBy(xpath = "//input[@id='address.zip']")
public WebElement zipBox;

      @FindBy(xpath = "//textarea[@id='address.street_address']")
public WebElement streetAddressBox;

      @FindBy(xpath = "//input[@type='text'][@placeholder='Search location form here']")
public WebElement setMapLocationBox;

      @FindBy(xpath = "//input[@id='settings.contact']")
public WebElement contactNumberBox;

      @FindBy(xpath = "//input[@id='settings.website']")
public WebElement websiteBox;

      @FindBy(xpath = "//button[text()='Add New Social Profile']")
public WebElement addNewSocailProfileButton;

    //  @FindBy(xpath = "//div[@class=' css-ackcql']")
    @FindBy(xpath = "//input[@id='react-select-2-input']")
public WebElement selectSocialPlatformSelect;

      @FindBy(xpath = "//input[@name='settings.socials.0.url']")
public WebElement inputLabelUrl;

      @FindBy(xpath = "//button[text()='Save']")
public WebElement saveButton;






 @FindBy (linkText = "Create Shop")

public WebElement createShopText;

@FindBy(xpath = "//input[@accept='image/*'][1]")

    public WebElement logoUpload;


    @FindBy(xpath = "(//section[@class='upload']//input)[2]")
    public WebElement coverImgUpload;


@FindBy(xpath = "//input[@accept='image/*'][@type='file']")
    public WebElement logoButton;

@FindBy(xpath = "//img[@alt='upload placeholder']")
    public WebElement logoImgUploadedIcon;

@FindBy(xpath = "(//img[@alt='upload placeholder'])[2]")
    public WebElement coverImgUploadedIcon;

    @FindBy(css = "img[alt=\"avatar\"]")
    public WebElement avatarIcon;



}
