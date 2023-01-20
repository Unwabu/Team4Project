
package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.network.model.DataReceived;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SellerRegisterPage;
import pages.US20_page;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReports;

public class US20_Test extends TestBaseReports {
    @Test
    public void test() throws InterruptedException {
        extentTest = extentReports.createTest("DAİLYNEEDS");

        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");

        HomePage hm = new HomePage();
        US20_page pg = new US20_page();
        pg.joinButton.click();
        pg.emailgiris.clear();
        pg.setEmailgiris("customer@demo.com");
        pg.passwordgiris.clear();
        pg.setPasswordgiris("demodemo");


        hm.categoryDropDownButton.click();

        hm.dailyNeedsButton.click();
       Assert.assertTrue(pg.vegetables.isDisplayed());
        Actions actions = new Actions(Driver.getDriver());

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.moveToElement(pg.vegetables).perform();
     ReusableMethods.yukleneneKadarBekle(pg.viewmore);
      Assert.assertTrue(pg.viewmore.isDisplayed());
       actions.moveToElement(pg.vegetables).click().perform();




        actions.moveToElement(pg.vegetables).click().perform();


       pg.addbuton.click();


       pg.sepet.click();


        pg.checkout.click();


        pg.checkAvailability.click();


       pg.PlaceOrder.click();

pg.Pay.click();


        Assert.assertTrue(pg.paymentSuccess.isDisplayed());


        extentTest.info("kullanıcı ılgılı kategorıde işlem yapabıldı");


    }


}





