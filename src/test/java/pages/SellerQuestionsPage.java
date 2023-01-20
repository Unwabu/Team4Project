package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SellerQuestionsPage {

    public SellerQuestionsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[text()='Questions']")
    public WebElement questions;

    @FindBy(xpath = "(//button[@title='Edit'])[1]")
    public WebElement editButton;

    @FindBy(xpath = "//button[text()='Reply']")
    public WebElement replyButton;

    @FindBy(xpath = "//textarea[@name='answer']")
    public WebElement answerBox;

    @FindBy(xpath = "(//p)[1]")
    public WebElement newAnswer;

    @FindBy(xpath = "(//p)[2]")
    public WebElement newAnswer2;


    @FindBy(xpath = "(//button[@title='Delete'])[1]")
    public WebElement deleteButton;

    @FindBy(xpath = "//button[text()='Delete']")
    public WebElement deleteButton2;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement succeesfulAlert;


}
