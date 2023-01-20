package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.awt.*;

public class UserJoinPage {


    public UserJoinPage() {


        PageFactory.initElements(Driver.getDriver(), this);
    }



    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailBox;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordBox;

    @FindBy(xpath = "(//button[@data-variant='normal'])[3]")
    public WebElement loginButton;

    @FindBy(xpath = "//img[@alt='user name']")
    public WebElement loginAvatar;


}
