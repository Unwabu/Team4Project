package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HuseyinPage {
    public HuseyinPage() {
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy (xpath = "(//*[.=\"Shops\"])[2]")
    public WebElement shopButton;


    @FindBy (xpath = "(//div[@class])[27]")
    public WebElement groceeryShop;


    @FindBy (xpath = "//*[.=\"Lime\"]")
    public WebElement leemon;


    @FindBy (xpath = "(//*[.=\"Add To Shopping Cart\"])[5]")
    public WebElement sepet;


    @FindBy (xpath = "(//button[@class=\"cursor-pointer p-2 transition-colors duration-200 hover:bg-accent-hover focus:outline-none px-5\"])[4]")
    public WebElement urunArtır;


    @FindBy (xpath = "(//button[@class=\"cursor-pointer p-2 transition-colors duration-200 hover:bg-accent-hover focus:outline-none px-5\"])[3]")
    public WebElement urunAzalat;





    @FindBy (xpath = "(//div[@class='flex flex-1 items-center justify-center px-3 text-sm font-semibold'])[3]")
    public WebElement siparisAdedi;









}
