package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.PickPazarLoginPage;
import pages.ShopsPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReports;

import java.util.List;

public class US_28 extends TestBaseReports {

    HomePage hp = new HomePage();
    PickPazarLoginPage loginPage = new PickPazarLoginPage();
    ShopsPage sp = new ShopsPage();


    @BeforeClass
    public void siteGit() {
        extentTest = extentReports.createTest("US_28", "Kullanıcı ürün fiyatlarını ürün cardında görebilmeli");

        //   1.Kullanıcı URL ye gider
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");

    }

    @Test
    public void loginTest() throws InterruptedException {
        // 2.Kullanıcı olarak giriş yapar, login olur

        hp.joinButton.click();
        loginPage.btnLogin.click();

    }

    @Test
    public void IlkFiat() {

        for (WebElement each : sp.ilkFiyat()) {
            System.out.println(each.getText());

            Assert.assertTrue(sp.ilkFiyat().contains(each));

        }
        extentTest.pass("İlk fiyatın kartta gözüktüğü doğrulandı ");

    }

    @Test
    public void indirimliFiat() {
        for (WebElement each : sp.IndirimliFiyat()) {
            System.out.println(each.getText());

            Assert.assertTrue(sp.IndirimliFiyat().contains(each));
        }
        extentTest.pass("İndirim fiyatının kartta gözüktüğü doğrulandı ");

    }

    @Test
    public void indirimOrani() {

        for (WebElement each : sp.IndirimOrani()) {
            System.out.println(each.getText());

            Assert.assertTrue(sp.IndirimOrani().contains(each));

        }
        extentTest.pass("İndirim oranının kartta gözüktüğü doğrulandı ");

    }

    @AfterClass
    public void tearDown() {
        Driver.closeDriver();
    }
}