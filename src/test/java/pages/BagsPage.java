package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BagsPage {

    public BagsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "svg[viewBox='0 0 14.4 12']")
    public WebElement Cart;

    @FindBy(xpath = "//div[@class='flex flex-1 items-center justify-center px-3 text-sm font-semibold']")
    public WebElement itemControl;

    @FindBy(id = "search")
    public WebElement BagsSearchButton;

    @FindBy(xpath = "//h3[@class='mb-2 truncate text-sm font-semibold text-heading']")
    public WebElement SayfadaIlkUrun;

    @FindBy(xpath = "//h3[@class='w-full text-center text-xl font-semibold text-body my-7']")
    public WebElement NoProductsFoundText;

    @FindBy(xpath = "(//button[@class='cursor-pointer p-2 transition-colors duration-200 hover:bg-accent-hover focus:outline-none px-3 py-3 sm:px-2'])[2]")
    public WebElement BagsPlusCart;

    @FindBy(xpath = "//button[@class='cursor-pointer p-2 transition-colors duration-200 hover:bg-accent-hover focus:outline-none px-3 py-3 sm:px-2'][1]")
    public WebElement BagsMinusCart;

    @FindBy(xpath = "//span[@class='flex pb-0.5']")
    public WebElement ItemCart;

    @FindBy(xpath = "(//button[@class='cursor-pointer p-2 transition-colors duration-200 hover:bg-accent-hover focus:outline-none hover:!bg-gray-100'])[2]")
    public WebElement PlusCart;

    @FindBy(xpath = "(//button[@class='cursor-pointer p-2 transition-colors duration-200 hover:bg-accent-hover focus:outline-none hover:!bg-gray-100'])[1]")
    public WebElement MinusCart;







}
