package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UserVegetablePage {
    public UserVegetablePage() {   PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = " img[alt='Vegetables']")
    public WebElement vegetablesCat;
}
