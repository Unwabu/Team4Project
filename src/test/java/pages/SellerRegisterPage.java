package pages;

import com.github.dockerjava.api.model.Links;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class SellerRegisterPage {


    public SellerRegisterPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

  //  @FindBy(xpath = "//input[@id='name']")
    @FindBy(css = "input[name='name']")
    public WebElement nameBox;

    @FindBy(id = "email")
    public WebElement mailBox;

    @FindBy(id = "password")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[.='Register']")
    public WebElement registerButton;

    @FindBy(xpath = "//h3[@class='mt-4 text-lg font-semibold text-heading']")
    public WebElement saticiIsim;

    @FindBy(linkText = "Login")
    public WebElement loginButton;

}
