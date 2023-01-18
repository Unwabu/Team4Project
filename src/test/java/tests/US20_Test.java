
    package tests;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.network.model.DataReceived;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SellerRegisterPage;
import pages.US20_page;
import utilities.Driver;
    public class US20_Test {
        @Test
        public void test() {
            Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
            HomePage hm=new HomePage();
            US20_page pg=new US20_page();
            //Kullanıcı GROCERY tıklar
            hm.categoryDropDownButton.click();
            //Kullanıcı GROCERY butonundan Daily Needs sekmesını tıklar
            hm.dailyNeedsButton.click();
        }
    }





