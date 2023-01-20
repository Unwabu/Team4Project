package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SellerCreateProductPage {


    public SellerCreateProductPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }


@FindBy (xpath = "(//section[@class='upload']//input)[1]")
    public WebElement featuredImagebox;

@FindBy (xpath = "(//section[@class='upload']//input)[2]")
    public WebElement productImagebox;
@FindBy (xpath = "(//input[@accept=\"image/*\"])[2]")
    public WebElement productImageHiddenbox;


@FindBy (xpath = "//img[@alt='cover']")
    public WebElement productImageIcon;

@FindBy (xpath = "//img[@alt='logo']")
    public WebElement featuredImageIcon;


@FindBy(css= "td[class=\"rc-table-cell cursor-pointer rc-table-cell-ellipsis\"]")
    public List<WebElement>productList = new ArrayList<WebElement>();
@FindBy(xpath = "//input[@id='react-select-4-input']")
public WebElement groupDropdownStart;

@FindBy(xpath = "//*[contains(text(), 'Bakery’) ]")
    public WebElement groupDropdownSelectBakery;


@FindBy(css = "input[id=\"name\"]")
    public WebElement nameBox;
@FindBy(css = "input[name=\"quantity\"]")
    public WebElement quantity;
//@FindBy(xpath = "//button[text()='Update Product']")
@FindBy(css = "[data-variant=\"normal\"]")
    public WebElement updateButton;

@FindBy(css = "input[id=\"unit\"]")
    public WebElement unitBox;

@FindBy(css = "input[id=\"length\"]")
    public WebElement lenght;

@FindBy(css = "input[id=\"height\"]")
    public WebElement height;
@FindBy(css = "input[id=\"external_product_url\"]")
    public WebElement productUrl;

//@FindBy(css = "id=\"external_product_button_text\"")
@FindBy(xpath = "//input[@name='external_product_button_text']")
public WebElement productButtonText;

@FindBy(css = "label[for=\"is_external\"]")
    public WebElement checkBox;
@FindBy(css = "button[data-variant=\"normal\"]")
    public WebElement addButton;





}
