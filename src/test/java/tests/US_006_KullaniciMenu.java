package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.JoinPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReports;

public class US_006_KullaniciMenu extends TestBaseReports {

    HomePage homePage;
    JoinPage joinPage;

    @BeforeMethod
    public void loginMethod() {
        homePage = new HomePage();
        joinPage = new JoinPage();
        extentTest = extentReports.createTest("LoginMethod");

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
