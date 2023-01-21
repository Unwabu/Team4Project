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

public class US_006_KullaniciLogin extends TestBaseReports {

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

    @Test(dataProvider = "getData",
            groups = "smoke"
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
}
