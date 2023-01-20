package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UserDailyNeedsPage {

    public UserDailyNeedsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


      @FindBy(css = "img[alt=\"Allium\"]")
    public WebElement alliumCat;

   @FindBy(xpath = "(//div[@style='opacity: 1;'])[2]")
    public WebElement productFound;
     @FindBy(css = "p[class='my-2.5 font-semibold text-accent']")
    public WebElement productPrice;
@FindBy(xpath = "(//span[text()='close'])[2]")
    public WebElement delProdcutButton;
@FindBy(xpath = "(//div[@class='flex flex-1 items-center justify-center px-3 text-sm font-semibold !px-0 text-heading']")
    public WebElement addCount;




}
