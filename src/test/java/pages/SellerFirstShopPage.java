package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utilities.Driver;

public class SellerFirstShopPage {


    public SellerFirstShopPage() { PageFactory.initElements(Driver.getDriver(), this);
    }


//@FindBy(css = "path[stroke-width='.8']")
//@FindBy(css = "svg[viewbox='0 0 26 28.026']")
@FindBy(xpath = "//*[text()='Products']")
    public WebElement productsButton;










}
