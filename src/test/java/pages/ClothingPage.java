package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ClothingPage {

    public ClothingPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "(//h3)[1]")
    public WebElement blazerIlkUrun;

    @FindBy(xpath = "//a[@href='/clothing']")
    public WebElement clothingShop;

    @FindBy(xpath = "//*[contains(text(),'No Product Found')]")
    public WebElement sorryText;

    @FindBy(xpath = "//span[text()='Shirts']")
    public WebElement shirtsFilter;

    @FindBy(xpath = "//span[text()='Tops']")
    public WebElement topsFilter;

    @FindBy(xpath = "(//button[contains(@class,'flex w-full items-center')])[1]")
    public WebElement womenDresFilterButton;

    @FindBy(xpath = "(//button[contains(@class,'flex w-full items-center')])[2]")
    public WebElement outerWearFilterButton;

    @FindBy(xpath = "(//button[contains(@class,'flex w-full items-center')])[3]")
    public WebElement pantsFilterButton;

    @FindBy(xpath = "//span[text()='Printed']")
    public WebElement printedFilter;

    @FindBy(xpath = "//span[text()='Jacket']")
    public WebElement jackedFilter;

    @FindBy(xpath = "//span[text()='Jeans']")
    public WebElement jeansFilter;

    @FindBy(xpath = "(//h3)[1]")
    public WebElement ilkUrun;

    @FindBy(xpath = "(//button[contains(@id,'headlessui-menu-button')])[1]")
    public WebElement shopCategories;





}
