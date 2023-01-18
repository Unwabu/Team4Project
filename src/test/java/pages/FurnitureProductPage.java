package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;
public class FurnitureProductPage {
    public FurnitureProductPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//div[.='Out Of Stock']")
    public WebElement outOfStockText;
    @FindBy(xpath = "//h4[.='No products found']")
    public WebElement noProductsFoundText;
    @FindBy(className = "my-2.5 font-semibold text-accent")
    public WebElement productPriceText;
    @FindBy(className = "font-bold text-heading ltr:ml-auto rtl:mr-auto")
    public WebElement priceText;
    @FindBy(xpath = "(//span[.='close'])[2]")
    public WebElement xRemoveButton;
    @FindBy(className = "flex flex-1 items-center justify-center px-3 text-sm font-semibold !px-0 text-heading")
    public WebElement miktar;
    @FindBy(xpath = "//h3[@class='font-bold text-heading']")
    public WebElement productName;
    @FindBy(xpath = "(//span[.='Product Image'])[1]")
    public WebElement furnitureProduct;
    @FindBy(xpath = "//span[.='Product Image']")
    public List<WebElement> furnitureProducts;
    @FindBy(xpath = "(//span[contains(text(),'Item')])[2]")
    public WebElement cesitAdediInCart;

}