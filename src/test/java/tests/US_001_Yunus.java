package tests;

import com.github.javafaker.Faker;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SellerQuestionsPage;
import pages.SellerReviewsPage;
import pages.SellerShippingPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReports;

import java.util.Set;


public class US_001_Yunus extends TestBaseReports {

    HomePage hp;
    SellerShippingPage sp;

    @Test
    public void TC_019() {
        hp = new HomePage();
        sp = new SellerShippingPage();
        extentTest = extentReports.createTest("TC_019", "Satici Shipping Bolumune Free Kayit Yapabilmeli");

        //1-Kullanıcı URL'ye gider
        Driver.getDriver().get(ConfigReader.getProperty("pickBazarUrl"));
        extentTest.info("Pick Bazar Url`e Gidildi");

        // 2-Satıcı olarak login olur
        hp.becomeASellerButton.click();

        String ilkSayfaWH = Driver.getDriver().getWindowHandle();
        Set<String> windowHandleSeti = Driver.getDriver().getWindowHandles();
        ReusableMethods.switchToNewWindow(windowHandleSeti, ilkSayfaWH);
        sp.saticiLogin.click();

        ReusableMethods.waitForUrl("https://admin-pickbazar-rest.vercel.app/login");
        sp.emailBox.clear();
        sp.emailBox.sendKeys(ConfigReader.getProperty("simtenMail"));
        sp.passwordBox.clear();
        sp.passwordBox.sendKeys(ConfigReader.getProperty("simtenPassword"));
        sp.login.click();
        extentTest.info("Satici Olarak Giris Yapildi");

        // 3-shippings ekranına geçer ve doğrular
        sp.shippings.click();
        ReusableMethods.waitForUrl("https://admin-pickbazar-rest.vercel.app/shippings");
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("shippings"));
        extentTest.info("Shippings Ekranina Gecildi ve Dogrulandi");

        // 4-Add shipping butonuna basar
        sp.addShippingButton1.click();

        // 5-Description kısmında name girer.
        String name = new Faker().name().firstName();
        ReusableMethods.waitForClickablility(sp.descriptionNameBox);
        sp.descriptionNameBox.sendKeys(name);

        // 6-typeı free seçer
        sp.typeFree.click();

        // 7-add shipping butonuna tıklar
        sp.addShippingButton2.click();
        extentTest.info("Add Shipping Kismindan Yeni Kayit Olusturuldu");

        // 8-eklemeyi görüntüler
        ReusableMethods.waitForText(sp.nameText, name);
        String actualName = sp.nameText.getText();
        Assert.assertEquals(actualName, name);
        extentTest.pass("Kayit Yapildigi Dogrulandi");

        Driver.closeDriver();
    }

    @Test
    public void TC_020() {
        hp = new HomePage();
        sp = new SellerShippingPage();
        extentTest = extentReports.createTest("TC_020", "Satici Shipping Bolumune Fixed Kayit Yapabilmeli");

        //1-Kullanıcı URL'ye gider
        Driver.getDriver().get(ConfigReader.getProperty("pickBazarUrl"));
        extentTest.info("Pick Bazar Url`e Gidildi");

        // 2-Satıcı olarak login olur
        hp.becomeASellerButton.click();

        String ilkSayfaWH = Driver.getDriver().getWindowHandle();
        Set<String> windowHandleSeti = Driver.getDriver().getWindowHandles();
        ReusableMethods.switchToNewWindow(windowHandleSeti, ilkSayfaWH);
        sp.saticiLogin.click();

        ReusableMethods.waitForUrl("https://admin-pickbazar-rest.vercel.app/login");
        sp.emailBox.clear();
        sp.emailBox.sendKeys(ConfigReader.getProperty("simtenMail"));
        sp.passwordBox.clear();
        sp.passwordBox.sendKeys(ConfigReader.getProperty("simtenPassword"));
        sp.login.click();
        extentTest.info("Satici Olarak Giris Yapildi");

        // 3-shippings ekranına geçer ve doğrular
        sp.shippings.click();
        ReusableMethods.waitForUrl("https://admin-pickbazar-rest.vercel.app/shippings");
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("shippings"));
        extentTest.info("Shippings Ekranina Gecildi ve Dogrulandi");

        // 4-Add shipping butonuna basar
        sp.addShippingButton1.click();

        // 5-Description kısmında name girer
        String name = new Faker().name().firstName();
        ReusableMethods.waitForClickablility(sp.descriptionNameBox);
        sp.descriptionNameBox.sendKeys(name);

        // 6-typeı fixed seçer
        sp.typeFixed.click();

        // 7-amount ekler.
        sp.amountBox.sendKeys("5");

        // 8-add shipping butonuna tıklar
        sp.addShippingButton2.click();
        extentTest.info("Add Shipping Kismindan Yeni Kayit Olusturuldu");

        // 9-eklemeyi görüntüler
        ReusableMethods.waitForText(sp.nameText, name);
        String actualName = sp.nameText.getText();
        Assert.assertEquals(actualName, name);
        extentTest.pass("Kayit Yapildigi Dogrulandi");

        Driver.closeDriver();
    }

    @Test
    public void TC_021() {
        hp = new HomePage();
        sp = new SellerShippingPage();
        extentTest = extentReports.createTest("TC_021", "Satici Shipping Bolumune Percentage Kayit Yapabilmeli");

        //1-Kullanıcı URL'ye gider
        Driver.getDriver().get(ConfigReader.getProperty("pickBazarUrl"));
        extentTest.info("Pick Bazar Url`e Gidildi");

        // 2-Satıcı olarak login olur
        hp.becomeASellerButton.click();

        String ilkSayfaWH = Driver.getDriver().getWindowHandle();
        Set<String> windowHandleSeti = Driver.getDriver().getWindowHandles();
        ReusableMethods.switchToNewWindow(windowHandleSeti, ilkSayfaWH);
        sp.saticiLogin.click();

        ReusableMethods.waitForUrl("https://admin-pickbazar-rest.vercel.app/login");
        ;
        sp.emailBox.clear();
        sp.emailBox.sendKeys(ConfigReader.getProperty("simtenMail"));
        sp.passwordBox.clear();
        sp.passwordBox.sendKeys(ConfigReader.getProperty("simtenPassword"));
        sp.login.click();
        extentTest.info("Satici Olarak Giris Yapildi");

        // 3-shippings ekranına geçer ve doğrular
        sp.shippings.click();
        ReusableMethods.waitForUrl("https://admin-pickbazar-rest.vercel.app/shippings");
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("shippings"));
        extentTest.info("Shippings Ekranina Gecildi ve Dogrulandi");

        // 4-Add shipping butonuna basar
        sp.addShippingButton1.click();

        // 5-Description kısmında name girer
        String name = new Faker().name().firstName();
        ReusableMethods.waitForClickablility(sp.descriptionNameBox);
        sp.descriptionNameBox.sendKeys(name);

        // 6-typeı percentage seçer
        sp.typePercentage.click();

        // 7-amount ekler
        sp.amountBox.sendKeys("7");

        // 8-add shipping butonuna tıklar
        sp.addShippingButton2.click();
        extentTest.info("Add Shipping Kismindan Yeni Kayit Olusturuldu");

        // 9-eklemeyi görüntüler
        ReusableMethods.waitForText(sp.nameText, name);
        String actualName = sp.nameText.getText();
        Assert.assertEquals(actualName, name);
        extentTest.pass("Kayit Yapildigi Dogrulandi");

        Driver.closeDriver();
    }


    @Test
    public void TC_022() {
        hp = new HomePage();
        sp = new SellerShippingPage();
        SellerQuestionsPage qp = new SellerQuestionsPage();

        extentTest = extentReports.createTest("TC_022",
                "Satici Questions Bolumunde Soru Soran Musterilerin Bilgilerini Goruntuleyebilmeli ve Soruları Silebilmelidir");

        //1-Kullanıcı URL'ye gider
        Driver.getDriver().get(ConfigReader.getProperty("pickBazarUrl"));
        extentTest.info("Pick Bazar Url`e Gidildi");

        // 2-Satıcı olarak login olur
        hp.becomeASellerButton.click();

        String ilkSayfaWH = Driver.getDriver().getWindowHandle();
        Set<String> windowHandleSeti = Driver.getDriver().getWindowHandles();
        ReusableMethods.switchToNewWindow(windowHandleSeti, ilkSayfaWH);
        ReusableMethods.waitForVisibility(sp.saticiLogin);
        sp.saticiLogin.click();

        ReusableMethods.waitForUrl("https://admin-pickbazar-rest.vercel.app/login");
        sp.emailBox.clear();
        sp.emailBox.sendKeys(ConfigReader.getProperty("simtenMail"));
        sp.passwordBox.clear();
        sp.passwordBox.sendKeys(ConfigReader.getProperty("simtenPassword"));
        sp.login.click();
        extentTest.info("Satici Olarak Giris Yapildi");

        //3-Questions ekranına geçer ve doğrular
        qp.questions.click();
        ReusableMethods.waitForUrl("https://admin-pickbazar-rest.vercel.app/questions");
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("questions"));
        extentTest.info("Questions Ekranina Gecildi ve Dogrulandi");

        //4-sorunun düzenleme butonuna basar
        qp.editButton.click();

        //5-düzenleme ekranını görüntüler
        Assert.assertTrue(qp.replyButton.isDisplayed());

        //6-Answer bölümünü doldurur
        String answer = "Ebik Gabik";
        qp.answerBox.clear();
        qp.answerBox.sendKeys(answer);
        extentTest.info("Musteri Sorularina Cevap Verildi");

        //7-reply tuşuna basar
        new Actions(Driver.getDriver()).click(qp.replyButton).perform();

        //8-verdiği cevapla soru sayfasında görünen cevap match olmalıdır
        ReusableMethods.waitForText(qp.newAnswer, answer);
        String actualAnswer = qp.newAnswer.getText();
        Assert.assertEquals(actualAnswer, "A:" + answer);
        extentTest.info("Musteri Sorularina Cevap Verildigi Dogrulandi");

        //9-soruyu silme butonuna tıklar
        qp.deleteButton.click();

        //10-onaylar
        qp.deleteButton2.click();
        extentTest.info("Musterinin Sorusu Silindi");

        //11-soru sayfasında sorunun silindiği görüntülenmelidir
        String answer2 = qp.newAnswer2.getText(); // 2. siradaki cevap
        ReusableMethods.waitForText(qp.newAnswer, answer2);
        String deleteAnswer = qp.newAnswer.getText();
        Assert.assertFalse(deleteAnswer.contains(answer));
        extentTest.info("Musteri Sorusunun Silindigi Dogrulandi");

        Driver.closeDriver();
        extentTest.pass("Satici Questions Bolumunde Soru Soran Musterilerin Bilgilerini Goruntudi ve Sildi");
    }


    @Test
    public void TC_023() {

        hp = new HomePage();
        sp = new SellerShippingPage();
        SellerReviewsPage rp = new SellerReviewsPage();

        extentTest = extentReports.createTest("TC_023",
                "Satici Reviews Bolumunde Musteri Tarafindan Yapilan Yorumu ve Yorum Hakkindaki Bilgileri Goruntuleyebilmelidir");

        //1-Kullanıcı URL'ye gider
        Driver.getDriver().get(ConfigReader.getProperty("pickBazarUrl"));
        extentTest.info("Pick Bazar Url`e Gidildi");

        //2-Satıcı olarak login olur
        hp.becomeASellerButton.click();

        String ilkSayfaWH = Driver.getDriver().getWindowHandle();
        Set<String> windowHandleSeti = Driver.getDriver().getWindowHandles();
        ReusableMethods.switchToNewWindow(windowHandleSeti, ilkSayfaWH);
        sp.saticiLogin.click();

        ReusableMethods.waitForUrl("https://admin-pickbazar-rest.vercel.app/login");
        sp.emailBox.clear();
        sp.emailBox.sendKeys(ConfigReader.getProperty("simtenMail"));
        sp.passwordBox.clear();
        sp.passwordBox.sendKeys(ConfigReader.getProperty("simtenPassword"));
        sp.login.click();
        extentTest.info("Satici Olarak Giris Yapildi");

        //3-reviews ekranına geçer ve doğrular.
        rp.reviews.click();
        ReusableMethods.waitForUrl("https://admin-pickbazar-rest.vercel.app/reviews");
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("reviews"));
        extentTest.info("Reviews Ekranina Gecildi ve Dogrulandi");

        //4-Customer review görüntüler
        Assert.assertTrue(rp.cutomerReview.isDisplayed());
        extentTest.info("Musteri Yorumunun Goruntulendigi Dogrulandi");

        //5-products bilgisinin görünür olduğunu doğrular
        Assert.assertTrue(rp.products.isDisplayed());
        extentTest.info("Products Bilgisinin Goruntulendigi Dogrulandi");

        //6-reports bilgisinin görünür olduğunu doğrular
        Assert.assertTrue(rp.reports.isDisplayed());
        extentTest.info("Reports Bilgisinin Goruntulendigi Dogrulandi");

        //7-date bilgisinin görünür olduğunu doğrular
        Assert.assertTrue(rp.date.isDisplayed());
        extentTest.info("Date Bilgisinin Goruntulendigi Dogrulandi");

        //8-imageın görünür olduğunu doğrular
        Assert.assertTrue(rp.image.isDisplayed());
        extentTest.info("Image`in Goruntulendigi Dogrulandi");

        Driver.closeDriver();
        extentTest.pass("Saticinin Reviews Bolumunde Musteri Tarafindan Yapilan Yorumu ve Yorum Hakkindaki Bilgileri Goruntuledigi Dorulandi");
    }


}