package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SellerProductsPage {
    public SellerProductsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

@FindBy(xpath = "//*[text()='Add Product']")
    public WebElement addProduct;
@FindBy(xpath = "//h1[@class='text-lg font-semibold text-heading']")
    public WebElement createNewProductText;
@FindBy(xpath = "//section[@class='upload']//input")
    public WebElement featuredImgUpload;
    @FindBy(xpath = "(//section[@class='upload']//input)[2]")
    public WebElement galleryImgUpload;
    @FindBy(css = "td[title=\"urunum my product\"]")
    public WebElement urunAdi;
 // @FindBy(css = "input[aria-label='Search']")
 //@FindBy(css = "input[id='search']")
 //@FindBy(xpath = "//input[@id='search']")
    @FindBy(css = "input[aria-label=\"Search\"]")
    public WebElement searchBox;
    @FindBy(css = "td[title=\"urunum my product\"]")
    public WebElement searchBoxResultText;

   //@FindBy(xpath = "//button[text()='Filter']")
// @FindBy(css = "svg[viewBox='0 0 11.996 12']")
   // svg[class='ms-2']
    @FindBy(xpath = "//button[text()='Filter']")
    public WebElement filterButton;

    @FindBy(css = "svg[class=\"h-5 w-5\"]")
    public WebElement searchSymbol;

  // @FindBy(xpath = "//button[text()='Filter']")
//@FindBy(xpath = "//div[@class=' css-ackcql']")
@FindBy(css = "input[aria-owns=\"react-select-2-listbox\"]")
    public WebElement filterByGroupButton;

@FindBy(css = "input[aria-owns=\"react-select-3-listbox\"]")
    public WebElement filterByCatButton;

@FindBy(css= "svg[viewBox='0 0 20.547 20.299']")
    public WebElement editButton;

}
