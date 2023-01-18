package pages;

import org.openqa.selenium.By;
import utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {


    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[.='Join']")
    public WebElement joinButton;

    @FindBy(id = "search")
    public WebElement searchBox;


    @FindBy(linkText = "Become a Seller")
    public WebElement becomeASellerButton;

    @FindBy(xpath = "//span[@class='flex h-5 w-5 items-center justify-center ltr:mr-2 rtl:ml-2'][1]")
    public WebElement categoryDropDownButton;

    @FindBy(xpath = "//button[text()='Search']")
    public WebElement SearchButton;

    @FindBy(xpath = "//del[@class='text-xs text-muted ltr:ml-2 rtl:mr-2 md:text-sm'][1]")
    public WebElement ilkFiyat;

    @FindBy(xpath = "//span[@class='text-sm font-semibold text-heading md:text-base'][1]")
    public WebElement indirimliFiyat;
    @FindBy(xpath = "//div[@class='rounded-full bg-yellow-500 px-3 text-xs font-semibold leading-6 text-light ltr:ml-auto rtl:mr-auto']")
    public WebElement indirimOrani;
    @FindBy(xpath = "//img[@alt='Apples']")
    public WebElement urunResmi;
//    hp.urunResmi.click();
//    System.out.println(hp.indirimOrani.getText());

    @FindBy(xpath = "//span[.='Add To Shopping Cart']")
    public WebElement addCartButton;

    @FindBy(xpath = "//span[@class='flex ltr:ml-2 rtl:mr-2']")
    public WebElement itemCartButton;

    @FindBy(xpath = "//span[.='plus']")
    public WebElement plusButton;

    @FindBy(tagName = "h4")
    public WebElement noProductFoundTextInCart;

    @FindBy(linkText = "Shops")
    public WebElement shops;

    @FindBy(xpath = "(//span[@class='flex h-5 w-5 items-center justify-center'])[4]")
    public WebElement bagsButton;

    @FindBy(xpath = "(//span[@class='flex h-5 w-5 items-center justify-center'])[1]")
    public WebElement groceryButton;

    @FindBy(xpath = "(//span[@class='flex h-5 w-5 items-center justify-center'])[2]")
    public WebElement bakeryButton;

    @FindBy(xpath = "(//span[@class='flex h-5 w-5 items-center justify-center'])[3]")
    public WebElement makeupButton;

    @FindBy(xpath = "(//span[@class='flex h-5 w-5 items-center justify-center'])[5]")
    public WebElement clothingButton;

    @FindBy(xpath = "(//span[@class='flex h-5 w-5 items-center justify-center'])[6]")
    public WebElement furnitureButton;

    @FindBy(xpath = "(//span[@class='flex h-5 w-5 items-center justify-center'])[7]")
    public WebElement dailyNeedsButton;

    @FindBy(xpath = "(//span[@class='flex h-5 w-5 items-center justify-center'])[8]")
    public WebElement booksButton;

    @FindBy(linkText = "Offers")
    public WebElement offers;

    @FindBy(linkText = "FAQ")
    public WebElement faq;

    @FindBy(linkText = "Contact")
    public WebElement contact;

    @FindBy(xpath = "/*[. ='Points']")
    public WebElement points;

    @FindBy(xpath = "/*[. ='Profile']")
    public WebElement profile;

    @FindBy(xpath = "/*[. ='My Orders']")
    public WebElement myOrders;

    @FindBy(xpath = "/*[. ='My Wishlists']")
    public WebElement myWishLists;

    @FindBy(xpath = "/*[. ='Checkout']")
    public WebElement checkout;

    @FindBy(xpath = "/*[. ='Logout']")
    public WebElement logout;


    @FindBy(xpath = "//span[@class='whitespace-nowrap'][1]")
    public WebElement shopCategories;

// @FindBy(xpath="//div[@class='relative inline-block ltr:text-left rtl:text-right']")
//public WebElement shopCategories;


    //kontrol yorumu

}

