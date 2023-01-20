package tests;


import org.openqa.selenium.Keys;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ClothingPage;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReports;


public class US_035 extends TestBaseReports {

    HomePage homePage;
    ClothingPage clothingPage;

    @Test
    public void login() {
        homePage = new HomePage();
        clothingPage = new ClothingPage();
        extentTest = extentReports.createTest("SearchBoxUrunAratmaTestiLogin");

        //1- Kullanici URL girer.
        Driver.getDriver().get(ConfigReader.getProperty("pickBazarUrl"));
        extentTest.info("Pick Bazar Url`e Gidildi");

        //2- Kullanici anasayfada urun kategorisine tiklar
        clothingPage.shopCategories.click();

        //3- Kullanici urun kategorisinden "Clothing" urun kategorisini secer
        ReusableMethods.waitForClickablility(clothingPage.clothingShop);
        clothingPage.clothingShop.click();
        ReusableMethods.waitForUrl("https://shop-pickbazar-rest.vercel.app/clothing");
        extentTest.info("Clothing Sayfasina Gidildi");

    }

    @Test
    public void TC_001_SearchBoxUrunAratmaPozitifTesti() {
        login();
        homePage = new HomePage();
        clothingPage = new ClothingPage();
        extentTest = extentReports.createTest("TC_001_SearchBoxUrunAratmaPozitifTesti", "Kullanici Kategoriye Uygun Keyword ile Urun Arattiginda Listelenen Urunlerde Aranan Keyword Bulunmali ");

        //4- Kullanci searchbox`a sectigi kategoriye uygun olarak "blazer" yazip aratir
        homePage.searchBox.sendKeys("Blazer" + Keys.ENTER);
        extentTest.info("Search Box`ta Blazer Aramasi Yapildi");

        //5- Kullanici arattigi "Blazer"in listelenen urunler oldugunu dogrular
        ReusableMethods.waitForUrl("https://shop-pickbazar-rest.vercel.app/clothing?text=Blazer");
        ReusableMethods.waitForClickablility(clothingPage.blazerIlkUrun);
        String urunText = clothingPage.blazerIlkUrun.getText().toLowerCase();
        Assert.assertTrue(urunText.contains("blazer"));
        extentTest.pass("Listelenen Urunlerin Blazer Oldugu Goruntulendi");

        Driver.closeDriver();
    }

    @Test
    public void TC_002_SearchBoxUrunAratmaNegativeTest() {
        login();
        homePage = new HomePage();
        clothingPage = new ClothingPage();
        extentTest = extentReports.createTest("TC_002_SearchBoxUrunAratmaNegativeTest", "Kullanici Kategoriye Uygun Olmayan Keyword ile Urun Arattiginda Bos Liste Cikmali");

        //4- Kullanci searchbox`a sectigi kategoriye uygun olmayan "Table" yazip aratir
        homePage.searchBox.sendKeys("Chair" + Keys.ENTER);
        extentTest.info("Search Box`ta Chair Aramasi Yapildi");

        //5- Kullanici "Sorry, No Product Found :(" yazisini goruntulemelidir.
        ReusableMethods.waitForUrl("https://shop-pickbazar-rest.vercel.app/clothing?text=Chair");
        ReusableMethods.waitForClickablility(clothingPage.sorryText);
        String actualResult = clothingPage.sorryText.getText();
        String expectedResult = "Sorry, No Product Found :(";
        Assert.assertEquals(actualResult, expectedResult);
        extentTest.pass("Kategori Disi Arama Yapilamadigi Dogrulandi");

        Driver.closeDriver();
    }


    @Test
    public void login1() {
        homePage = new HomePage();
        clothingPage = new ClothingPage();
        extentTest = extentReports.createTest("UrunFiltrelemeTestiLogin");

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
        login1();
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
        login1();
        homePage = new HomePage();
        clothingPage = new ClothingPage();
        extentTest = extentReports.createTest("TC_004_TopsFiltreTesti", "Kullanici Urun Filtrelemesi Yaptiginda Filtreye Uygun Urunler Listelenmeli");

        //3- Kullanici "Clothing" kategorisinde sol tarafta bulunan filtrelerden "Tops" filtresine tiklar
        ReusableMethods.javaScriptExcecuter(clothingPage.topsFilter);
        ReusableMethods.waitForUrl("https://shop-pickbazar-rest.vercel.app/clothing?category=tops");
        extentTest.info("Filtre olarak Shirts secildi");

        //4- Kullanici "top" urunlerinin listelendigini goruntulemelidir.
        ReusableMethods.waitForClickablility(clothingPage.ilkUrun);
        String urunText = clothingPage.ilkUrun.getText().toLowerCase();
        Assert.assertTrue(urunText.contains("top"));
        extentTest.pass("Listelenen Urunlerin tops Oldugu Goruntulendi");

        Driver.closeDriver();
    }

    @Test
    public void TC_005_ChinosFiltreTesti() {
        login1();
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
        extentTest.pass("Listelenen Urunlerin tops Oldugu Goruntulendi");

        Driver.closeDriver();
    }

    @Test
    public void TC_006_JacketFiltreTesti() throws InterruptedException {
        login1();
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
        extentTest.pass("Listelenen Urunlerin tops Oldugu Goruntulendi");

        Driver.closeDriver();
    }

    @Test
    public void TC_007_PrintedFiltreTesti() {
        login1();
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
        extentTest.pass("Listelenen Urunlerin tops Oldugu Goruntulendi");

        Driver.closeDriver();
    }

}
