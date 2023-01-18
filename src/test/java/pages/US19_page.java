
package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;
import utilities.ReusableMethods;
import java.time.Duration;
import java.util.List;
public class US19_page {
    public US19_page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//button[.='Join']")
    public WebElement joinButton;
    @FindBy(id = "search")
    public WebElement searchBox;
    @FindBy(xpath = "(//div/button)[1]")
    public  WebElement grosery;
    public void groserybutton() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(grosery)).click();
    }
    @FindBy(xpath = "(//span[@class='flex h-5 w-5 items-center justify-center'])[7]")
    public WebElement dailyNeedsButton;
    @FindBy(xpath = "//input[@id='search']")
    public WebElement SearchButton;
    @FindBy(xpath = "//span[@class='text-sm font-semibold text-heading ltr:ml-3 rtl:mr-3']")
    public List<WebElement> liste;
    @FindBy(xpath = "(//span[@class='text-sm font-semibold text-heading ltr:ml-3 rtl:mr-3'])[1]")
    public WebElement fishtikla;
    public void fish() {
        ReusableMethods.yukleneneKadarBekle(fishtikla);
        fishtikla.click();
    }









}
