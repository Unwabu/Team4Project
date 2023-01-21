package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;

public class PickPazarLoginPage {

    public PickPazarLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath="//input[@id='email']")
    public WebElement txtUsername;

    @FindBy(xpath="//input[@id='password']")
    public WebElement txtPassword;

    @FindBy(xpath="//button[.='Login']")
    public WebElement btnLogin;

    @FindBy(id="headlessui-menu-button-1")
    public WebElement select;

    @FindBy(id="headlessui-menu-item-46")
    public WebElement Grocery;


    public void yukleneneKadarBekle(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(webElement)).click();
    }

    }

