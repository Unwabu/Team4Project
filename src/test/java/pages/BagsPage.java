package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BagsPage {

    public BagsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//h3[@role='button'])[11]")
    public WebElement SearchABag;

    @FindBy(xpath = "(//h3[@role='button'])[3]")
    public WebElement SearchAnotherBag;

    @FindBy(css = "svg[viewBox='0 0 14.4 12']")
    public WebElement Cart;

    @FindBy(xpath = "//div[@class='flex flex-1 items-center justify-center px-3 text-sm font-semibold']")
    public WebElement itemControl;








}
