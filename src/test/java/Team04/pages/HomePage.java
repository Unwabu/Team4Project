package Team04.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

     WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "search")
     WebElement searchBox;
    @FindBy(xpath = "//button[.='Join']")
     WebElement joinButton;
    @FindBy(linkText = "Become a Seller")
    WebElement becomeaSellerButton;
    @FindBy(className = "hidden ltr:ml-10 ltr:mr-auto rtl:mr-10 rtl:ml-auto xl:block")
     WebElement categoryDropDownButton;
    @FindBy(xpath = "//button[text()='Search']")
     WebElement SearchButton;
    @FindBy(className = "text-sm font-normal text-m")
     WebElement ilkFiyat;
    @FindBy(className = "text-2xl f")
     WebElement indirimliFiyat;
    @FindBy(className = "rounded-full bg-y")
    WebElement indirimOrani;
    @FindBy(className = "mb-3 w-full lg:mb-0 lg:max-w-[400px]")
     WebElement addCartButton; // ürün ekleme butonu
    @FindBy(className = "flex ltr:ml-2 rtl:mr-2")
     WebElement itemCartButton; // sepet
    @FindBy(xpath = "//span[.='plus']")
  WebElement plusButton; // + arttırma tuşu ...ürün ekleme yapılmalı
    @FindBy(tagName = "h4")
     WebElement noProductFoundTextInCart;  // ürün bulunamadı yazısı
    @FindBy(linkText = "Shops")
  WebElement shops;
    //sol üst köşedeki butonlar
    @FindBy(xpath = "(//span[@class='flex h-5 w-5 items-center justify-center'])[4]")
     WebElement bagsButton;
    @FindBy(xpath = "(//span[@class='flex h-5 w-5 items-center justify-center'])[1]")
     WebElement groceryButton;
    @FindBy(xpath = "(//span[@class='flex h-5 w-5 items-center justify-center'])[2]")
     WebElement bakeryButton;
    @FindBy(xpath = "(//span[@class='flex h-5 w-5 items-center justify-center'])[3]")
     WebElement makeupButton;
    @FindBy(xpath = "(//span[@class='flex h-5 w-5 items-center justify-center'])[5]")
     WebElement clothingButton;
    @FindBy(xpath = "(//span[@class='flex h-5 w-5 items-center justify-center'])[6]")
     WebElement furnitureButton;
    @FindBy(xpath = "(//span[@class='flex h-5 w-5 items-center justify-center'])[7]")
     WebElement dailyNeedsButton;
    @FindBy(xpath = "(//span[@class='flex h-5 w-5 items-center justify-center'])[8]")
     WebElement booksButton;
    @FindBy(linkText = "Offers")
     WebElement offers;
    @FindBy(linkText = "FAQ")
    WebElement FAQ;
    @FindBy(linkText = "Contact")
     WebElement contact;
    @FindBy(xpath = "/*[. ='Points']")
     WebElement points;
    @FindBy(xpath = "/*[. ='Profile']")
     WebElement profile;
    @FindBy(xpath = "/*[. ='My Orders']")
    WebElement myOrders;
    @FindBy(xpath = "/*[. ='My Wishlists']")
     WebElement myWishLists;
    @FindBy(xpath = "/*[. ='Checkout']")
     WebElement checkout;
    @FindBy(xpath = "/*[. ='Logout']")
     WebElement logout;



}
