package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UserBakeryPage {
    public UserBakeryPage() { PageFactory.initElements(Driver.getDriver(), this);
    }

@FindBy (xpath = "//h1[text()='Get Your Bakery Items Delivered']")
    public WebElement bakeryText;

    @FindBy (css = "svg[viewBox='0 0 24 24']")
    public WebElement bakeryFirstItem;
   @FindBy (xpath = "//span[@class='bg-light rounded w-full py-2 px-2 text-accent mt-3']")
    public WebElement cartPrice;

}
