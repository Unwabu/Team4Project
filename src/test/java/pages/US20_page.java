package pages;
import org.bouncycastle.jcajce.provider.asymmetric.X509;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;
import utilities.ReusableMethods;
import java.time.Duration;
import java.util.List;
public class US20_page {
    public US20_page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    /*  @FindBy(xpath = "//button[.='Join']")
      public WebElement joinButton;
      @FindBy(xpath = "//input[@id='email']")
      public WebElement email;
      @FindBy(xpath = "//input[@id='password'")
  public WebElement password;
      @FindBy(xpath = "//button[text()='Login']")
      public WebElement login;*/
    @FindBy(id = "search")
    public WebElement searchBox;
    @FindBy(xpath = "(//div/button)[1]")
    public  WebElement grosery;
    public void groserybutton() {
        ReusableMethods.yukleneneKadarBekle(grosery);
        grosery.click();
    }
}
