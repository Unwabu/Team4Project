package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SellerProductsPage {
    public SellerProductsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

@FindBy(xpath = "//span[text()='Add Product']")
    public WebElement addProduct;
@FindBy(xpath = "//h1[@class='text-lg font-semibold text-heading']")
    public WebElement createNewProductText;
@FindBy(xpath = "//section[@class='upload']//input")
    public WebElement featuredImgUpload;
    @FindBy(xpath = "(//section[@class='upload']//input)[2]")
    public WebElement galleryImgUpload;
}
