package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SellerMyShopsPage {
    public SellerMyShopsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h1[@class='text-lg font-semibold text-heading']")
    public WebElement myShopsText;


    @FindBy(xpath = "//*[text()='simsim']")
    public WebElement myFirstShop;

}
