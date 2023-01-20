package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UserBakeryPage;
import pages.UserJoinPage;

import pages.UserLoggedInHPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReports;


public class US_034 extends TestBaseReports {
    WebDriver driver = Driver.getDriver();
    HomePage hp = new HomePage();
    UserJoinPage usp=new UserJoinPage();
    UserLoggedInHPage ulh=new UserLoggedInHPage();
    Actions action=new Actions(driver);
  
UserBakeryPage ubp= new UserBakeryPage();
    @Test
    public void TC_001() {
            extentTest = extentReports.createTest("TC_001",
            "Bakery kategorisinde ürün sepete eklenmeli");

        driver.get(ConfigReader.getProperty("pickBazarUrl"));
        hp.joinButton.click();
        usp.emailBox.clear();
        usp.emailBox.sendKeys(ConfigReader.getProperty("simtenMail"));
        usp.passwordBox.clear();
        usp.passwordBox.sendKeys(ConfigReader.getProperty("simtenPassword"));
        usp.loginButton.click();

        ReusableMethods.yukleneneKadarBekle(ulh.menuButton);
        action.moveToElement(ulh.menuButton)
                .click().perform();
        ReusableMethods.yukleneneKadarBekle(ulh.bakeryButton);
        action.moveToElement(ulh.bakeryButton).click().perform();
        ReusableMethods.yukleneneKadarBekle(ubp.bakeryText);
        Assert.assertTrue(driver.getCurrentUrl().contains("bakery"));
        extentTest.info("kullanıcı bakery sayfasında olduğunu görüntüler");
        String beforeAdd=ubp.cartPrice.getText();
        ubp.bakeryFirstItem.click();
        ReusableMethods.yukleneneKadarBekle(ubp.cartPrice);
        String afterAdd=ubp.cartPrice.getText();
        Assert.assertNotEquals(beforeAdd,afterAdd);
        extentTest.info("kullanıcı sepetteki fiyat değişikliğini doğrular");
        extentTest.pass("Bakery kategorisinde ürünün sepete eklendiği ve fiyat değişikliğinin görüntülendiği doğrulandı");

    }





}
