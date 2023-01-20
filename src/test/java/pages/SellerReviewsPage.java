package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SellerReviewsPage {

    public SellerReviewsPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//span[text()='Reviews']")
    public WebElement reviews;

    @FindBy(xpath = "(//p[contains(@class,'text-sm')])[1]")
    public WebElement cutomerReview;

    @FindBy(xpath = "(//a[contains(@class,'transition-color')])[1]")
    public WebElement products;

    @FindBy(xpath = "(//span[(@class='font-bold')])[1]")
    public WebElement reports;

    @FindBy(xpath = "(//span[(@class='whitespace-nowrap')])[1]")
    public WebElement date;

    @FindBy(xpath = "(//img[(@class='overflow-hidden rounded')])[1]")
    public WebElement image;

}
