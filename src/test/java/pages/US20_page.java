

package pages;
import org.bouncycastle.jcajce.provider.asymmetric.X509;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;
import utilities.ReusableMethods;
import java.time.Duration;
import java.util.List;
    public class US20_page {
        public US20_page() {
            PageFactory.initElements(Driver.getDriver(),this);
        }


        @FindBy(xpath = "//button[.='Join']")
        public WebElement joinButton;

        @FindBy(id="email")
        public WebElement emailgiris;

        @FindBy(id = "password")
        public WebElement passwordgiris;


        @FindBy(id = "search")
        public WebElement searchBox;
        @FindBy(xpath = "(//div/button)[1]")
        public  WebElement grosery;


        @FindBy(xpath = "(//div[@class='flex flex-col flex-1 h-full relative z-10'])[1]")
        public WebElement vegetables;


        @FindBy(xpath = "(//*[text()='View More'])[1]")
        public WebElement viewmore;

        @FindBy(xpath = "(//span[@class='flex-1'])[1]")
        public WebElement addbuton;



        @FindBy(xpath = "//button[@class='hidden product-cart lg:flex relative']")
        public WebElement sepet;

        @FindBy(xpath = "//span[@class='flex h-full flex-1 items-center px-5 text-light']")
        public WebElement checkout;



        @FindBy(xpath = "//button[@data-variant='normal']")
        public WebElement checkAvailability;


        @FindBy(xpath = "//button[@data-variant='normal']")
        public WebElement PlaceOrder;


        @FindBy(xpath = "//button[text()='Pay']")
        public WebElement Pay;

        @FindBy(xpath = "//span[@class='px-3 py-1 rounded-full text-sm text-light bg-accent min-h-[2rem] items-center justify-center text-[9px] !leading-none xs:text-sm inline-flex']")
        public WebElement paymentSuccess;



        public void groserybutton() {
            ReusableMethods.yukleneneKadarBekle(grosery);
            grosery.click();


        }
        public void setEmailgiris(String mail) {
            emailgiris.sendKeys(mail+ Keys.ENTER);


        }
        public void setPasswordgiris(String password) {
            passwordgiris.sendKeys(password+Keys.ENTER);
        }



        public void add() {
            ReusableMethods.yukleneneKadarBekle(addbuton);
            addbuton.click();
        }


    }









