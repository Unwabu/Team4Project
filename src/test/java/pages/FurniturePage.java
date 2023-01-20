package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class FurniturePage {
    public FurniturePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//span[@class='flex h-5 w-5 items-center justify-center ltr:mr-2 rtl:ml-2'][1]")
    public WebElement categoryDropDownButton;
    @FindBy(xpath = "(//span[@class='flex h-5 w-5 items-center justify-center'])[6]")
    public WebElement furnitureButton;
    @FindBy(xpath = "//input[@id='grocery search at header']")
    public WebElement furnitureSearchButton;
    @FindBy(xpath = "(//h3[@class='mb-2 truncate text-sm font-semibold text-heading'])[1]")
    public WebElement ilkUrunName;
    @FindBy(xpath = "//h3[@class='mb-2 truncate text-sm font-semibold text-heading']")
    public List<WebElement> UrunNameler;
    @FindBy(xpath = "//div[@class='w-full h-20 flex items-center justify-center']")
    public List<WebElement> furnitureSubCategories;
    @FindBy(xpath = "//section[@class='relative flex h-full flex-col']")
    public WebElement allTextInCart;
    @FindBy(xpath = "//span[@class='whitespace-nowrap text-base text-body ltr:lg:ml-7 rtl:lg:mr-7']")
    public WebElement stockText;
    @FindBy(xpath = "//div[@class='mt-6 flex flex-col items-center md:mt-6 lg:flex-row']")
    public WebElement allStockText;
    @FindBy(xpath = "//h3[.='Sorry, No Product Found :(']")
    public WebElement noProductsFoundMainText;
    @FindBy(xpath = "//span[@class='flex ltr:ml-2 rtl:mr-2']")
    public WebElement itemCartButton;
    @FindBy(xpath = "//span[.='Add To Shopping Cart']")
    public WebElement addCartButton;
    @FindBy(xpath = "//div[@class='flex flex-1 items-center justify-center px-3 text-sm font-semibold']")
    public WebElement miktarInPage;
    @FindBy(xpath = "//div[@class='flex flex-1 items-center justify-center px-3 text-sm font-semibold !px-0 text-heading']")
    public WebElement miktarInCart;
    @FindBy(xpath = "//button[.='Back']")
    public WebElement backButton;
    @FindBy(xpath = "(//button[@class='cursor-pointer p-2 transition-colors duration-200 hover:bg-accent-hover focus:outline-none px-5'])[2]")
    public WebElement plusButton;
    @FindBy(xpath = "(//button[@class='cursor-pointer p-2 transition-colors duration-200 hover:bg-accent-hover focus:outline-none hover:!bg-gray-100'])[2]")
    public WebElement plusButtonCart;
    @FindBy(xpath = "(//button[@class='cursor-pointer p-2 transition-colors duration-200 hover:bg-accent-hover focus:outline-none px-5'])[1]")
    public WebElement minusButton;
    @FindBy(xpath = "(//button[@class='cursor-pointer p-2 transition-colors duration-200 hover:bg-accent-hover focus:outline-none hover:!bg-gray-100'])[1]")
    public WebElement minusButtonCart;
    @FindBy(xpath = "(//span[text()='close'])[2]")
    public WebElement xRemoveButton;
    @FindBy(xpath = "//p[@class='my-2.5 font-semibold text-accent']")
    public WebElement productPriceText;
    @FindBy(xpath = "//span[@class='font-bold text-heading ltr:ml-auto rtl:mr-auto']")
    public WebElement totalPriceText;

}