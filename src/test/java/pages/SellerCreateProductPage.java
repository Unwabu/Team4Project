package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SellerCreateProductPage {


    public SellerCreateProductPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }


@FindBy (xpath = "(//section[@class='upload']//input)[1]")
    public WebElement featuredImagebox;

@FindBy (xpath = "(//section[@class='upload']//input)[2]")
    public WebElement productImagebox;


@FindBy (xpath = "//img[@alt='cover']")
    public WebElement productImageIcon;

@FindBy (xpath = "//img[@alt='logo']")
    public WebElement featuredImageIcon;

//@FindBy(xpath = "//input[@id='react-select-2-input']")
@FindBy(css = "div[class=' css-ackcql']")
    public WebElement groupDropdown;
@FindBy(css = "//*[text( )= 'Bakery']")
    public WebElement groupDropdownSelectBakery;



}
