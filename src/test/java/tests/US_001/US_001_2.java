package tests.US_001;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.Driver;
import utilities.TestBaseReports;

import java.time.Duration;
import java.util.Set;

public class US_001_2  extends TestBaseReports {
    Faker faker = new Faker();
    HomePage hp = new HomePage();
    SellerRegisterPage sp = new SellerRegisterPage();
    WebDriver driver = Driver.getDriver();

    String  firstPageHandle,  secondWindowHandle = "";

    @Test
    public void TC_001() {



        extentTest = extentReports.createTest("TC_001",
                "Kullanici satici olmak icin kayit islemi gerceklestirebilmelidir");
        //WebDriver driver = Driver.getDriver();
        driver.get("https://shop-pickbazar-rest.vercel.app/");
        //kontrol yorumu

        firstPageHandle = driver.getWindowHandle();

        hp.becomeASellerButton.click();

        Set<String> allWindowHandles = driver.getWindowHandles();



        for (String each : allWindowHandles) {
            if (!each.equals(firstPageHandle)) {
                secondWindowHandle = each;
            }
        }
        driver.switchTo().window(secondWindowHandle);
        Assert.assertNotEquals(firstPageHandle, driver.getWindowHandle());
        extentTest.info("Kullanıcı kayıt sayfasının görüntülendiğini doğrular");
        String isim = faker.name().name();
        sp.nameBox.sendKeys(isim);
        sp.mailBox.sendKeys(faker.internet().emailAddress());
        sp.passwordBox.sendKeys(faker.internet().password());
        sp.registerButton.click();
        Assert.assertEquals(sp.saticiIsim.getText(), isim);
        extentTest.info("yeni sayfada isminin görüntülendiğini doğrular");

        extentTest.pass("Kullanicinin satici olmak icin kayit islemi gerceklestirebildiği doğrulandı");

        driver.close();



    }

}
