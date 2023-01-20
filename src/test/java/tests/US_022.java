package tests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReports;

public class US_022 extends TestBaseReports {

    WebDriver driver = Driver.getDriver();
    HomePage hp = new HomePage();
    UserJoinPage usp = new UserJoinPage();
    UserLoggedInHPage ulh = new UserLoggedInHPage();
    Actions action = new Actions(driver);
    UserDailyNeedsPage udn = new UserDailyNeedsPage();
    UserAlliumPage uap = new UserAlliumPage();
    UserVegetablePage uvp = new UserVegetablePage();

    @Test
    public void TC_001() {

        extentTest = extentReports.createTest("TC_001",
                "Kullanıcı pakete ürün ekleyebilmeli çıkartabilmeli veya azaltabilmeli");

        driver.get(ConfigReader.getProperty("pickBazarUrl"));
        hp.joinButton.click();
        usp.emailBox.clear();
        usp.emailBox.sendKeys(ConfigReader.getProperty("simtenMail"));
        usp.passwordBox.clear();
        usp.passwordBox.sendKeys(ConfigReader.getProperty("simtenPassword"));
        usp.loginButton.click();
        Assert.assertTrue(usp.loginAvatar.isDisplayed());
        extentTest.info("kullanıcı giriş yapabildiğini görüntüler");
        ReusableMethods.yukleneneKadarBekle(ulh.menuButton);
        action.moveToElement(ulh.menuButton)
                .click().perform();
        ReusableMethods.yukleneneKadarBekle(ulh.dailyNeedsButton);
        action.moveToElement(ulh.dailyNeedsButton).click().perform();

        action.moveToElement(uvp.vegetablesCat).click().perform();
        action.moveToElement(udn.alliumCat).click().perform();
        action.moveToElement(uap.plusButton).click().perform();
       action.moveToElement( uap.cartButton).click().perform();
        Assert.assertTrue(udn.productFound.isDisplayed());
        extentTest.info("ürünün sepete eklendiğini doğrular");
        Assert.assertTrue(udn.productPrice.isDisplayed());
        extentTest.info("ürün fiyatının görüntülendiğini doğrular");
      action.click(udn.delProdcutButton).perform();
      ReusableMethods.yukleneneKadarBekle(udn.productFound);
      Assert.assertTrue(udn.productFound.isDisplayed());
        extentTest.info("ürün fiyatının görüntülendiğini doğrular");
        extentTest.pass("Daily Needs kategorisinde kullanıcının pakete ürün ekleme/çıkartma yapabildiği doğrulandı");
    }


}
