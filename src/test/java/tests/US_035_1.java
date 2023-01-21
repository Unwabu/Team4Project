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


public class US_035_1 extends TestBaseReports {

    HomePage homePage;
    ClothingPage clothingPage;

    @BeforeMethod
    public void loginMethod() {
        homePage = new HomePage();
        clothingPage = new ClothingPage();
        extentTest = extentReports.createTest("loginMethod");

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
}
