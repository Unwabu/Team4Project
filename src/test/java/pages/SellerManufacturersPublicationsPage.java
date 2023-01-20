package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SellerManufacturersPublicationsPage {
    public SellerManufacturersPublicationsPage(){
        PageFactory.initElements(Driver.getDriver(), this);}
    @FindBy(linkText = "Manufacturers/Publications")
    public WebElement manufacturersPublicationsButton;

    @FindBy(partialLinkText = "Add Manufacturer/Publication")
    public WebElement addManuPubButton;

    @FindBy(xpath = "//input[@id='name']")
    public WebElement nameBox;

    @FindBy(xpath = "//textarea[@id='description']")
    public WebElement descriptionBox;

    @FindBy(xpath = "//input[@id='website']")
    public WebElement websiteBox;
    @FindBy(xpath = "//div[@id='react-select-2-placeholder']")
    public WebElement groupDropDownBox;

    @FindBy(xpath = "//button[text()='Add Manufacturer/Publication']")
    public WebElement addManuPubBox;

    @FindBy(xpath = "(//tr[@class='rc-table-row rc-table-row-level-0'])[1]")
    public WebElement firstManuPubInfo;

    @FindBy(xpath = "(//span[@class='translate-x-6 inline-block h-4 w-4 transform rounded-full bg-light'])[1]")
    public WebElement enabledButton;
    @FindBy(xpath = "(//span[@class='translate-x-1 inline-block h-4 w-4 transform rounded-full bg-light'])[1]")
    public WebElement disabledButton;

}
