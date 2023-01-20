package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.JoinPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReports;

public class US_006 extends TestBaseReports {

    HomePage homePage;
    JoinPage joinPage;

    @Test(groups = "smoke")
    public void TC_001_validEmailPasswordLoginPozitifTest() {
        homePage = new HomePage();
        joinPage = new JoinPage();
        extentTest = extentReports.createTest("TC_001_validEmailPasswordLogin", "Kullanici Valid Email ve Password ile Join Olabilmelidir.");

        //1- Kullanici URL girer.
        Driver.getDriver().get(ConfigReader.getProperty("pickBazarUrl"));
        extentTest.info("Pick Bazar Url`e Gidildi");

        //2- Kullanici Join butonuna tiklar
        homePage.joinButton.click();
        extentTest.info("Join Button Tiklandi");

        //3- Kullanici valid email girer.
        ReusableMethods.waitForClickablility(joinPage.emailBox);
        joinPage.emailBox.clear();
        joinPage.emailBox.sendKeys(ConfigReader.getProperty("kullaniciValidMail"));
        extentTest.info("Valid/Invalid Email girildi");

        //4- Kullanici valid password girer.
        joinPage.passwordBox.clear();
        joinPage.passwordBox.sendKeys(ConfigReader.getProperty("kullaniciValidPassword"));
        extentTest.info("Valid Password Girildi");

        //5- Kullanici login butonuna tiklar
        joinPage.loginButton.click();
        extentTest.info("Login Button Tiklandi");

        //6- Kullanici olrak giris yaptigini dogrular
        ReusableMethods.waitForClickablility(joinPage.loginAvatar);
        Assert.assertTrue(joinPage.loginAvatar.isDisplayed());
        extentTest.pass("Kullanicinin Valid Mail ve Password ile Login Oldugu Dogrulandi");

        Driver.closeDriver();
    }

    @Test(dataProvider = "getData"
    )
    public void TC_002_003_004_NegatifLoginTestleri(String mail, String password) {
        homePage = new HomePage();
        joinPage = new JoinPage();
        extentTest = extentReports.createTest("TC_002_003_004_NegatifLoginTestleri");

        //1- Kullanici URL girer.
        Driver.getDriver().get(ConfigReader.getProperty("pickBazarUrl"));
        extentTest.info("Pick Bazar Url`e Gidildi");

        //2- Kullanici Join butonuna tiklar
        homePage.joinButton.click();
        extentTest.info("Join Button Tiklandi");

        //3- Kullanici invalid email girer
        ReusableMethods.waitForClickablility(joinPage.emailBox);
        joinPage.emailBox.clear();
        joinPage.emailBox.sendKeys(mail);
        extentTest.info("Valid/Invalid Email girildi");

        //4- Kullanici valid password girer.
        joinPage.passwordBox.clear();
        joinPage.passwordBox.sendKeys(password);
        extentTest.info("Valid/Invalid Password Girildi");

        //5- Kullanici login butonuna tiklar
        joinPage.loginButton.click();
        extentTest.info("Login Button Tiklandi");

        //6- Kullanici olarak giris yapamadigini dogrular
        ReusableMethods.waitForClickablility(joinPage.hataMesaji);
        Assert.assertTrue(joinPage.hataMesaji.isDisplayed());
        extentTest.pass("Kullanicinin Invalid Girdiler ile Login Olamadigi Dogrulandi");

        Driver.closeDriver();
    }

    @DataProvider
    public static Object[][] getData() {

        return new Object[][]{
                {ConfigReader.getProperty("kullaniciInvalidMail"), ConfigReader.getProperty("kullaniciValidPassword")}, // TC_002
                {ConfigReader.getProperty("kullaniciValidMail"), ConfigReader.getProperty("kullaniciInvaildPassword")}, // TC_003
                {ConfigReader.getProperty("kullaniciInvalidMail"), ConfigReader.getProperty("kullaniciInvaildPassword")}, // TC_004
        };
    }

    @Test
    public void login() {
        homePage = new HomePage();
        joinPage = new JoinPage();
        extentTest = extentReports.createTest("KullaniciMenusunuTestiLogin");

        //1- Kullanici URL girer.
        Driver.getDriver().get(ConfigReader.getProperty("pickBazarUrl"));
        extentTest.info("Pick Bazar Url`e Gidildi");

        //2- Kullanici olarak giris yapar
        homePage.joinButton.click();

        ReusableMethods.waitForClickablility(joinPage.emailBox);
        joinPage.emailBox.clear();
        joinPage.emailBox.sendKeys(ConfigReader.getProperty("kullaniciValidMail"));

        joinPage.passwordBox.clear();
        joinPage.passwordBox.sendKeys(ConfigReader.getProperty("kullaniciValidPassword"));

        joinPage.loginButton.click();
        extentTest.info("Kullanici olarak giris yapildi");

        //3- Kullanici menusune gider.
        joinPage.loginAvatar.click();
        extentTest.info("Kullanici menusu acildi");

    }

    @Test
    public void TC_005_KullaniciMenusunuGoruntulemeTesti() {
        login();
        joinPage = new JoinPage();
        extentTest = extentReports.createTest("TC_005_KullaniciMenusunuGoruntulemeTesti", "Kullanici Menusundeki Secenekler Goruntulenebilmeli");

        //4- Kullanici menusundeki seceneklerin gorunur oldugunu dogrular
        ReusableMethods.waitForClickablility(joinPage.logout);
        for (WebElement w : joinPage.kullaniciMenuList) {
            System.out.println(w.getText());
            Assert.assertTrue(w.isDisplayed());
        }
        extentTest.pass("Kullanici Menusundeki Secenekler Goruntulendi");

        Driver.closeDriver();
    }


    @Test
    public void TC_006_PointsGoruntulemeTesti() {
        login();
        joinPage = new JoinPage();
        extentTest = extentReports.createTest("TC_006_PointsGoruntulemeTesti", "Kullanici Menusunde Kullanici Points Goruntulenebilmeli");

        //4- Kullanici, Kullanici Points`i Goruntuleyebilmeli
        ReusableMethods.waitForClickablility(joinPage.points);
        Assert.assertTrue(joinPage.points.isDisplayed());
        extentTest.pass("Kullanici Menusundeki Points Seceneginde Puanlar Goruntulendi");

        Driver.closeDriver();

    }

    @Test
    public void TC_007_ProfileTesti() {
        login();
        joinPage = new JoinPage();
        extentTest = extentReports.createTest("TC_007_ProfileTesti", "Kullanici Menusundeki Profile Tiklandiginda Profile Sayfasi Goruntulenebilmeli");

        //4- Kullanici Profile secenegine tiklar
        joinPage.profile.click();
        extentTest.info("Profil sayfasi acildi");

        //5- Kullanici Profile sayfasina erisildigini dogrular
        ReusableMethods.waitForClickablility(joinPage.waitIcinElement);
        String urlText = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(urlText.contains("profile"));
        extentTest.pass("Kullanici Menusundeki Profile Secenegine Tiklanarak Profile Sayfasi Goruntulendi");

        Driver.closeDriver();

    }

    @Test
    public void TC_008_MyOrdersTest() {
        login();
        joinPage = new JoinPage();
        extentTest = extentReports.createTest("TC_008_MyOrdersTest", "Kullanici Menusundeki My Orders Tiklandiginda My Orders Sayfasi Goruntulenebilmeli");

        //4- Kullanici My Orders secenegine tiklar
        joinPage.myOrders.click();
        extentTest.info("My Orders sayfasi acildi");

        //5- Kullanici My Orders sayfasina erisildigini dogrular
        ReusableMethods.waitForClickablility(joinPage.waitIcinElement);
        String urlText = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(urlText.contains("orders"));
        extentTest.pass("Kullanici Menusundeki My Orders Secenegine Tiklanarak My Orders Sayfasi Goruntulendi");

        Driver.closeDriver();
    }

    @Test
    public void TC_009_MyWishlistsTesti() {
        login();
        joinPage = new JoinPage();
        extentTest = extentReports.createTest("TC_009_MyWishlistsTesti", "Kullanici Menusundeki My Wishlists Tiklandiginda My Wishlists Sayfasi Goruntulenebilmeli");

        //4- Kullanici My Wishlists secenegine tiklar
        joinPage.myWishlists.click();
        extentTest.info("My Wishlists sayfasi acildi");

        //5- Kullanici My Wishlists sayfasina erisildigini dogrular
        ReusableMethods.waitForClickablility(joinPage.waitIcinElement);
        String urlText = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(urlText.contains("wishlists"));
        extentTest.pass("Kullanici Menusundeki My Wishlists Secenegine Tiklanarak My Wishlists Sayfasi Goruntulendi");

        Driver.closeDriver();
    }

    @Test
    public void TC_010_CheckoutTesti() {
        login();
        joinPage = new JoinPage();
        extentTest = extentReports.createTest("TC_010_CheckoutTesti", "Kullanici Menusundeki Checkout Tiklandiginda Checkout Sayfasi Goruntulenebilmeli");

        //4- Kullanici Checkout secenegine tiklar
        joinPage.checkout.click();
        extentTest.info("Checkout sayfasi acildi");

        //5- Kullanici Checkout sayfasina erisildigini dogrular
        ReusableMethods.waitForClickablility(joinPage.waitIcinElementCheckout);
        String urlText = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(urlText.contains("checkout"));
        extentTest.pass("Kullanici Menusundeki Checkout Secenegine Tiklanarak Checkout Sayfasi Goruntulendi");

        Driver.closeDriver();
    }

    @Test
    public void TC_011_LogoutTesti() {
        login();
        joinPage = new JoinPage();
        extentTest = extentReports.createTest("TC_011_LogoutTesti", "Kullanici Menusundeki Logout Tiklandiginda Kullanici Cikis Yapabilmeli");

        //4- Kullanici Logout secenegine tiklar
        joinPage.logout.click();
        extentTest.info("Cikis islemi gerceklestirildi");

        // 5- Kullanici cikis yaptigini dogrular
        ReusableMethods.waitForClickablility(homePage.joinButton);
        Assert.assertTrue(homePage.joinButton.isDisplayed());
        extentTest.pass("Kullanici Menusundeki Logout Secenegine Tiklanarak Cikis Yapildigi Dogrulandi");

        Driver.closeDriver();
    }
}
