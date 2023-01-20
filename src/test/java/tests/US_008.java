package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReports;

import java.time.Duration;

public class US_008 extends TestBaseReports {

    HomePage hp = new HomePage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

    @BeforeMethod
    public void setup() {
        //1. Kullanıcı siteye gider
        ReusableMethods.URLset("https://shop-pickbazar-rest.vercel.app/");

        //2. Kullanıcı ürün kategorilerinin seçildiği alana tıklamalıdır
        hp.categoryDropDownButton.click();
    }

    @Test
    public void testCase_01() {
        extentTest = extentReports.createTest("US08_TC01", "kullanıcı olarak urun kategorileri belirlenebilmelidir");

        //3. Kullanıcı Grocery kategorisini seçebilmelidir.
        hp.groceryButton.click();

        wait.until(ExpectedConditions.urlToBe("https://shop-pickbazar-rest.vercel.app/grocery"));

        //4. Kullanıcı urlde Grocery geçip geçmediğini doğrular.
        ReusableMethods.checkUrl("grocery");
        extentTest.info("Urlde Grocery geçip geçmediği doğrulandı.");

        extentTest.pass("Kullanıcı ürün kategorilerini belirleyebildi");
    }

    @Test
    public void testCase_02() {
        extentTest = extentReports.createTest("US08_TC02", "kullanıcı olarak urun kategorileri belirlenebilmelidir");

        //3. Kullanıcı Bakery kategorisini seçebilmelidir.
        hp.bakeryButton.click();

        wait.until(ExpectedConditions.urlToBe("https://shop-pickbazar-rest.vercel.app/bakery"));

        //4. Kullanıcı urlde Bakery geçip geçmediğini doğrular.
        ReusableMethods.checkUrl("bakery");
        extentTest.info("Urlde Bakery geçip geçmediği doğrulandı.");
        extentTest.pass("Kullanıcı ürün kategorilerini belirleyebildi");


    }

    @Test
    public void testCase_03() {
        extentTest = extentReports.createTest("US08_TC03", "kullanıcı olarak urun kategorileri belirlenebilmelidir");

        //3. Kullanıcı Make Up kategorisini seçebilmelidir.
        hp.makeupButton.click();

        wait.until(ExpectedConditions.urlToBe("https://shop-pickbazar-rest.vercel.app/makeup"));

        //4. Kullanıcı urlde Make Up geçip geçmediğini doğrular.
        ReusableMethods.checkUrl("makeup");
        extentTest.info("Urlde Make Up geçip geçmediği doğrulandı.");
        extentTest.pass("Kullanıcı ürün kategorilerini belirleyebildi");

    }

    @Test
    public void testCase_04() {
        extentTest = extentReports.createTest("US08_TC04", "kullanıcı olarak urun kategorileri belirlenebilmelidir");

        //3. Kullanıcı Bags kategorisini seçebilmelidir.
        hp.bagsButton.click();

        wait.until(ExpectedConditions.urlToBe("https://shop-pickbazar-rest.vercel.app/bags"));

        //4. Kullanıcı urlde Bags geçip geçmediğini doğrular.
        ReusableMethods.checkUrl("bags");
        extentTest.info("Urlde Bags geçip geçmediği doğrulandı.");
        extentTest.pass("Kullanıcı ürün kategorilerini belirleyebildi");


    }

    @Test
    public void testCase_05() {
        extentTest = extentReports.createTest("US08_TC05", "kullanıcı olarak urun kategorileri belirlenebilmelidir");

        //3. Kullanıcı Clothing kategorisini seçebilmelidir.
        hp.clothingButton.click();

        wait.until(ExpectedConditions.urlToBe("https://shop-pickbazar-rest.vercel.app/clothing"));

        //4. Kullanıcı urlde Clothing geçip geçmediğini doğrular.
        ReusableMethods.checkUrl("clothing");
        extentTest.info("Urlde Clothing geçip geçmediği doğrulandı.");
        extentTest.pass("Kullanıcı ürün kategorilerini belirleyebildi");


    }

    @Test
    public void testCase_06() {
        extentTest = extentReports.createTest("US08_TC06", "kullanıcı olarak urun kategorileri belirlenebilmelidir");

        //3. Kullanıcı Furniture kategorisini seçebilmelidir.
        hp.furnitureButton.click();

        wait.until(ExpectedConditions.urlToBe("https://shop-pickbazar-rest.vercel.app/furniture"));

        //4. Kullanıcı urlde Furnitue geçip geçmediğini doğrular.
        ReusableMethods.checkUrl("furniture");
        extentTest.info("Urlde Furniture geçip geçmediği doğrulandı.");
        extentTest.pass("Kullanıcı ürün kategorilerini belirleyebildi");


    }

    @Test
    public void testCase_07() {
        extentTest = extentReports.createTest("US08_TC07", "kullanıcı olarak urun kategorileri belirlenebilmelidir");

        //3. Kullanıcı Daily Needs kategorisini seçebilmelidir.
        hp.dailyNeedsButton.click();

        wait.until(ExpectedConditions.urlToBe("https://shop-pickbazar-rest.vercel.app/daily-needs"));

        //4. Kullanıcı urlde Daily Needs geçip geçmediğini doğrular.
        ReusableMethods.checkUrl("daily-needs");
        extentTest.info("Urlde Daily Needs geçip geçmediği doğrulandı.");
        extentTest.pass("Kullanıcı ürün kategorilerini belirleyebildi");


    }

    @AfterTest
    public void shutDown() {
        //5. Kullanıcı sayfayı kapatır
         Driver.closeDriver();
    }


}