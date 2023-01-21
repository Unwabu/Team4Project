package US_001;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReports;

import java.time.Duration;
import java.util.Set;

public class US_001_TC14 extends TestBaseReports {

    String simtenMail = ConfigReader.getProperty("simtenMail");
    String simtenPassword = ConfigReader.getProperty("simtenPassword");
    HomePage hp = new HomePage();
    SellerLoggedInPageS slip = new SellerLoggedInPageS();
    SellerLoginPage firstSlip = new SellerLoginPage();
    SellerRegisterPage srp = new SellerRegisterPage();
    UserCreatePage ucp = new UserCreatePage();
    UsersPage up = new UsersPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

    Faker faker = new Faker();

    String name = faker.name().name();
    String email = faker.internet().emailAddress();
    String password = faker.internet().password();
    String firstPageHandle = Driver.getDriver().getWindowHandle();


    @Test
    public void testCase_14() {
        extentTest = extentReports.createTest("US01_TC14", "kullanici satici olabilmeli ve satici aksiyonlarini gerceklestirebilmelidir");

        //1-Kullanıcı URL'ye gider
        ReusableMethods.URLset("https://shop-pickbazar-rest.vercel.app/");

        //2-Satıcı olarak login olur
        hp.becomeASellerButton.click();

        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();

        String secondWindowHandle = "";

        for (String each : allWindowHandles) {
            if (!each.equals(firstPageHandle)) {
                secondWindowHandle = each;
            }
        }
        Driver.getDriver().switchTo().window(secondWindowHandle);
        srp.loginButton.click();
        wait.until(ExpectedConditions.urlToBe("https://admin-pickbazar-rest.vercel.app/login"));
        firstSlip.mailBox.clear();
        firstSlip.mailBox.sendKeys(simtenMail);
        firstSlip.passwordBox.clear();
        firstSlip.passwordBox.sendKeys(simtenPassword);
        firstSlip.loginButton.click();

        //3-Users ekranına geçer ve doğrular
        slip.users.click();
        wait.until(ExpectedConditions.urlToBe("https://admin-pickbazar-rest.vercel.app/users"));
        ReusableMethods.linkKontrolEt("users");
        extentTest.info("Urlde users geçip geçmediği doğrulandı.");

        //4-add customer butonuna tıklar
        up.userCreate.click();

        //5-Create new customer sayfasının açıldığını doğrular
        Assert.assertTrue(ucp.cncText.isDisplayed());
        extentTest.info("Create new customer sayfasının açıldığı doğrulandı.");

        //6-information datalarını girer
        ucp.name.sendKeys(name);
        ucp.email.sendKeys(email);
        ucp.password.sendKeys(password);

        //7-Create customer butonuna tıklar
        ucp.createCustomer.click();

        //8-users sayfasına döner
        ReusableMethods.URLset("https://admin-pickbazar-rest.vercel.app/users");

        //9-Yaratılan customerın varlığını doğrular
        wait.until(ExpectedConditions.urlToBe("https://admin-pickbazar-rest.vercel.app/users"));

        Assert.assertEquals(up.users.get(0).getText() , name);
        extentTest.info("Kullanıcının oluşturulduğu doğrulandı.");

        extentTest.pass("Satıcı müşteri ekleyebildi");

    }

    @AfterMethod
    public void shutDown(){

        Driver.closeDriver();
    }
}
