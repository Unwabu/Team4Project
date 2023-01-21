package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class FAQ {


    private WebDriver driver;

    public FAQ(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "svg[width='20']")
  public  List<WebElement> plusButtons = new ArrayList<>();

    @FindBy(css = "path[d='M20 12H4']")
  public  List<WebElement> minusButtons = new ArrayList<>();

    @FindBy(xpath = "//h2[@class='text-sm md:text-base font-semibold leading-relaxed text-heading']")
   public List<WebElement> questions = new ArrayList<>();

    @FindBy(xpath = "//div[@class='md:pt-1 pb-4 px-5 leading-7 text-sm md:text-base md:leading-loose text-body-dark']")
   public List<WebElement> anwsers = new ArrayList<>();

    @FindBy(xpath = "//*[text()='Our Customer Experience Team is available 7 days a week and we offer 2 ways to get in contact.Email and Chat . We try to reply quickly, so you need not to wait too long for a response!.']")
    public WebElement firstAnwser;

    @FindBy(xpath = "//*[text()='Please read the documentation carefully . We also have some online video tutorials regarding this issue . If the problem remains, Please Open a ticket in the support forum']")
    public WebElement secondAnwser;

    @FindBy(xpath = "//*[text()='At first, Please check your internet connection . We also have some online video tutorials regarding this issue . If the problem remains, Please Open a ticket in the support forum.']")
    public WebElement thirdAnwser;

    @FindBy(xpath = "//*[text()='If you want to open an account for personal use you can do it over the phone or online. Opening an account online should only take a few minutes.']")
    public WebElement fourthAnwser;

}
