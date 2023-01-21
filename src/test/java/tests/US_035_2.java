package tests;


import org.openqa.selenium.Keys;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ClothingPage;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReports;


public class US_035_2 extends TestBaseReports {

    HomePage homePage;
    ClothingPage clothingPage;

    @BeforeMethod
    public void loginMedhod() {
        homePage = new HomePage();
        clothingPage = new ClothingPage();
        extentTest = extentReports.createTest("loginMedhod");

        //1- Kullanici URL girer.
        Driver.getDriver().get(ConfigReader.getProperty("pickBazarUrl"));
        extentTest.info("Pick Bazar Url`e Gidildi");

        //2- Kullanici anasayfadan "Clothing" kategorisini secer.
        clothingPage.shopCategories.click();

        ReusableMethods.waitForClickablility(clothingPage.clothingShop);
        clothingPage.clothingShop.click();
        ReusableMethods.waitForUrl("https://shop-pickbazar-rest.vercel.app/clothing");
        extentTest.info("Clothing Sayfasina Gidildi");
    }

    @Test
    public void TC_003_ShirtsFiltreTesti() {
        homePage = new HomePage();
        clothingPage = new ClothingPage();
        extentTest = extentReports.createTest("TC_003_ShirtsFiltreTesti", "Kullanici Urun Filtrelemesi Yaptiginda Filtreye Uygun Urunler Listelenmeli");

        //3- Kullanici "Clothing" kategorisinde sol tarafta bulunan filtrelerden "Shirts" filtresine tiklar
        ReusableMethods.javaScriptExcecuter(clothingPage.shirtsFilter);
        ReusableMethods.waitForUrl("https://shop-pickbazar-rest.vercel.app/clothing?category=shirts");
        extentTest.info("Filtre olarak Shirts secildi");

        //4- Kullanici "shirts" urunlerinin listelendigini goruntulemelidir.
        ReusableMethods.waitForVisibility(clothingPage.ilkUrun);
        String urunText = clothingPage.ilkUrun.getText().toLowerCase();
        Assert.assertTrue(urunText.contains("shirt"));
        extentTest.pass("Listelenen Urunlerin Shirts Oldugu Goruntulendi");

        Driver.closeDriver();
    }

    @Test
    public void TC_004_TopsFiltreTesti() {
        homePage = new HomePage();
        clothingPage = new ClothingPage();
        extentTest = extentReports.createTest("TC_004_TopsFiltreTesti", "Kullanici Urun Filtrelemesi Yaptiginda Filtreye Uygun Urunler Listelenmeli");

        //3- Kullanici "Clothing" kategorisinde sol tarafta bulunan filtrelerden "Tops" filtresine tiklar
        ReusableMethods.javaScriptExcecuter(clothingPage.topsFilter);
        ReusableMethods.waitForUrl("https://shop-pickbazar-rest.vercel.app/clothing?category=tops");
        extentTest.info("Filtre olarak Tops secildi");

        //4- Kullanici "top" urunlerinin listelendigini goruntulemelidir.
        ReusableMethods.waitForClickablility(clothingPage.ilkUrun);
        String urunText = clothingPage.ilkUrun.getText().toLowerCase();
        Assert.assertTrue(urunText.contains("top"));
        extentTest.pass("Listelenen Urunlerin tops Oldugu Goruntulendi");

        Driver.closeDriver();
    }

    @Test
    public void TC_005_ChinosFiltreTesti() {
        homePage = new HomePage();
        clothingPage = new ClothingPage();
        extentTest = extentReports.createTest("TC_005_ChinosFiltreTesti", "Kullanici Urun Filtrelemesi Yaptiginda Filtreye Uygun Urunler Listelenmeli");

        //3- Kullanici "Clothing" kategorisinde sol tarafta bulunan filtrelerden
        //   "Pants" filtresi altinda yeralan "Jeans" filtresine tiklar.
        ReusableMethods.javaScriptExcecuter(clothingPage.pantsFilterButton);
        ReusableMethods.waitForUrl("https://shop-pickbazar-rest.vercel.app/clothing?category=pants");
        ReusableMethods.waitForClickablility(clothingPage.ilkUrun);
        clothingPage.jeansFilter.click();
        ReusableMethods.waitForUrl("https://shop-pickbazar-rest.vercel.app/clothing?category=jeans");
        extentTest.info("Filtre olarak Jeans secildi");

        //4- Kullanici "Chinos" urunlerinin listelendigini goruntulemelidir.
        ReusableMethods.waitForClickablility(clothingPage.ilkUrun);
        String urunText = clothingPage.ilkUrun.getText().toLowerCase();
        Assert.assertTrue(urunText.contains("jean"));
        extentTest.pass("Listelenen Urunlerin Jeans Oldugu Goruntulendi");

        Driver.closeDriver();
    }

    @Test
    public void TC_006_JacketFiltreTesti(){
        homePage = new HomePage();
        clothingPage = new ClothingPage();
        extentTest = extentReports.createTest("TC_006_JacketFiltreTesti", "Kullanici Urun Filtrelemesi Yaptiginda Filtreye Uygun Urunler Listelenmeli");

        //3- Kullanici "Clothing" kategorisinde sol tarafta bulunan filtrelerden "Outer Wear"
        //   filtresi altinda yeralan "Jacket" filtresine tiklar
        ReusableMethods.javaScriptExcecuter(clothingPage.outerWearFilterButton);
        ReusableMethods.waitForUrl("https://shop-pickbazar-rest.vercel.app/clothing?category=outer-wear");
        ReusableMethods.waitForClickablility(clothingPage.ilkUrun);
        clothingPage.jackedFilter.click();
        ReusableMethods.waitForUrl("https://shop-pickbazar-rest.vercel.app/clothing?category=jacket");
        extentTest.info("Filtre olarak Jacket secildi");

        //4- Kullanici "jacket" urunlerinin listelendigini goruntulemelidir.
        ReusableMethods.waitForClickablility(clothingPage.ilkUrun);
        String urunText = clothingPage.ilkUrun.getText().toLowerCase();
        Assert.assertTrue(urunText.contains("jacket"));
        extentTest.pass("Listelenen Urunlerin Jacket Oldugu Goruntulendi");

        Driver.closeDriver();
    }

    @Test
    public void TC_007_PrintedFiltreTesti() {
        homePage = new HomePage();
        clothingPage = new ClothingPage();
        extentTest = extentReports.createTest("TC_007_PrintedFiltreTesti", "Kullanici Urun Filtrelemesi Yaptiginda Filtreye Uygun Urunler Listelenmeli");

        //3- Kullanici "Clothing" kategorisinde sol tarafta bulunan filtrelerden
        // "Women Dress" filtresi altinda yeralan "Printed" filtresine
        ReusableMethods.javaScriptExcecuter(clothingPage.womenDresFilterButton);
        ReusableMethods.waitForUrl("https://shop-pickbazar-rest.vercel.app/clothing?category=women-dress");
        ReusableMethods.waitForClickablility(clothingPage.ilkUrun);
        clothingPage.printedFilter.click();
        ReusableMethods.waitForUrl("https://shop-pickbazar-rest.vercel.app/clothing?category=printed");
        extentTest.info("Filtre olarak Printed secildi");

        //4- Kullanici "Printed" urunlerinin listelendigini goruntulemelidir.
        ReusableMethods.waitForClickablility(clothingPage.ilkUrun);
        String urunText = clothingPage.ilkUrun.getText().toLowerCase();
        Assert.assertTrue(urunText.contains("printed"));
        extentTest.pass("Listelenen Urunlerin Printed Oldugu Goruntulendi");

        Driver.closeDriver();
    }

}
