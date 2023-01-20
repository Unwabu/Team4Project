package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class UsersPage {

    public UsersPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@href=\"/users/create\"]")
   public WebElement userCreate;


    @FindBy(xpath = "//td[@style='text-align: left;']")
    public List<WebElement> users = new ArrayList<>();
}
