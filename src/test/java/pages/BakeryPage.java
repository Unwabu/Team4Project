package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class BakeryPage {
    public BakeryPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[@class='flex h-5 w-5 items-center justify-center ltr:mr-2 rtl:ml-2'][1]")
    public WebElement categoryDropDownButton;
    @FindBy(xpath = "(//span[@class='flex h-5 w-5 items-center justify-center'])[2]")
    public WebElement bakeryDropDownButton;

    @FindBy(xpath = "//span[text()='Product Image']")
    public List<WebElement> bakeryProductBox;


    @FindBy(xpath = "(//h3[@class='text-xs text-body md:text-sm'])[1]")
    public WebElement bakeryProductName;

    @FindBy(xpath = "//button[text()='Load More']")
    public WebElement btnLoadMore;

    @FindBy(xpath ="//span[text()='Next']")// "//img[@alt='Soft Bread']")
    public WebElement btnNext;





}
