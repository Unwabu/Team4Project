package tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BakeryPage;
import pages.HomePage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReports;

public class US_032 extends TestBaseReports {

    BakeryPage bp = new BakeryPage();
    HomePage hp = new HomePage();


    @BeforeMethod
    public void setup() {
        ReusableMethods.URLset("https://shop-pickbazar-rest.vercel.app/");
        hp.categoryDropDownButton.click();
        hp.bakeryButton.click();
        ReusableMethods.waitForUrl("https://shop-pickbazar-rest.vercel.app/bakery");
        bp.products.get(1).click();

    }

    @Test
    public void testCase_01(){
        extentTest = extentReports.createTest("US32_TC01", "Kullanıcı Ürünün fiyatı ile ilgili bilgilerni ürün cardında görebilmelidir");
        ReusableMethods.waitForUrl("https://shop-pickbazar-rest.vercel.app/bakery");
        Assert.assertTrue(bp.indirimliFiyat.isDisplayed());
        extentTest.info("Ürün kartında indirimli fiyatın göründüğü doğrulandı.");
        extentTest.pass("Kullanıcı indirimli fiyatı görebildi");


    }

    @Test
    public void testCase_02(){
        extentTest = extentReports.createTest("US32_TC01", "Kullanıcı Ürünün fiyatı ile ilgili bilgilerni ürün cardında görebilmelidir");
        ReusableMethods.waitForUrl("https://shop-pickbazar-rest.vercel.app/bakery");
        Assert.assertTrue(bp.indirimsizFiyat.isDisplayed());
        extentTest.info("Ürün kartında indirimsiz fiyatın göründüğü doğrulandı.");
        extentTest.pass("Kullanıcı indirimsiz fiyatı görebildi");


    }

    @AfterTest
    public void shutDown(){

        Driver.closeDriver();
    }
}