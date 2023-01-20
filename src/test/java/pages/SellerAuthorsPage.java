package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SellerAuthorsPage {
    public SellerAuthorsPage(){
        PageFactory.initElements(Driver.getDriver(), this);}
    @FindBy(linkText = "Authors")
    public WebElement authorsButton;
    @FindBy(partialLinkText = "Add Author")
    public WebElement addAuthorsButton;
    @FindBy(xpath = "//input[@id='name']")
    public WebElement nameBox;
    @FindBy(xpath = "//input[@id='languages']")
    public WebElement languageBox;
    @FindBy(xpath = "//textarea[@id='bio']")
    public WebElement bioBox;
    @FindBy(xpath = "//textarea[@id='quote']")
    public WebElement quoteBox;
    @FindBy(xpath = "(//div[@class='react-datepicker-wrapper'])[1]")
    public WebElement bornBox;
    @FindBy(xpath = "(//div[@class='react-datepicker-wrapper'])[2]")
    public WebElement deathBox;
    @FindBy(xpath = "//button[text()='Add Author']")
    public WebElement addAuthorsBox;
    @FindBy(xpath = "//button[text()='Update Author']")
    public WebElement updateAuthorsBox;
    @FindBy(xpath = "//button[text()='Back']")
    public WebElement backBox;
    @FindBy(xpath = "(//tr[@class='rc-table-row rc-table-row-level-0'])[1]")
    public WebElement firstAuthorInfo;
    @FindBy(xpath = "(//span[@class='translate-x-6 inline-block h-4 w-4 transform rounded-full bg-light transition-transform'])[1]")
    public WebElement enabledButton;
    @FindBy(xpath = "(//span[@class='translate-x-1 inline-block h-4 w-4 transform rounded-full bg-light transition-transform'])[1]")
    public WebElement disabledButton;
    @FindBy(xpath = "(//a[@class='text-base transition duration-200 hover:text-heading'])[1]")
    public WebElement editButton;
    @FindBy(xpath = "(//button[@class='text-red-500 transition duration-200 hover:text-red-600 focus:outline-none'])[1]")
    public WebElement deleteButton;
    @FindBy(xpath = "//button[text()='Delete']")
    public WebElement deleteBox;
}
