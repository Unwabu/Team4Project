package tests;

import org.testng.annotations.*;
import pages.HomePage;
import pages.PickPazarLoginPage;
import pages.ShopsPage;
import utilities.Driver;
import utilities.TestBaseReports;


public class US_11 extends TestBaseReports {

    HomePage hp = new HomePage();
    PickPazarLoginPage loginPage = new PickPazarLoginPage();
    ShopsPage sp = new ShopsPage();


    @BeforeClass
    public void siteGit() {
        extentTest = extentReports.createTest("US_11", "Kullanıcı hem sayfada hem sepetinde ürünün miktarını değiştirebilmeli");

        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");

    }

    @Test
    public void loginTest() {

        hp.joinButton.click();
        loginPage.yukleneneKadarBekle(loginPage.btnLogin);

    }

    @Test
    public void anasayfadaUrunmiktariTest() {
        sp.addBtnClick();
        sp.urunartiGostergesi();

        loginPage.yukleneneKadarBekle(sp.minusBtn);
        sp.UrunazaltmaGostergesi();

        extentTest.pass("Kullanıcı ana sayfada iken ürün miktarınının değiştiği doğrulandı");


    }

    @Test
    public void spturunmiktariTest() {

        sp.addBtnClick();
        loginPage.yukleneneKadarBekle(sp.sepetBtn);
        sp.sepetMinus.click();
        sp.sepetPls.click();
        sp.sepetMinus.click();

        extentTest.pass("Kullanıcının sepetindeki ürünün miktarını değiştirebildiği doğrulandı");


    }

    @AfterClass
    public void tearDown() {
        Driver.closeDriver();
    }
}



