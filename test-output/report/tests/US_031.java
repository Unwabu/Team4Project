package tests;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BakeryPage;
import utilities.Driver;
import utilities.TestBaseReports;

import java.security.Key;
import java.util.List;

public class US_031 extends TestBaseReports {

    BakeryPage bakeryPage = new BakeryPage();
    WebDriver driver = Driver.getDriver();

    @Test
    public void TC_001() throws InterruptedException {//Maksimumum 30 adet ürün gelmelidir.
        extentTest = extentReports.createTest("TC_001", "Maksimumum 30 adet ürün gelmelidir.");

        //1-Kullanıcı URL ye gider
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        // extentTest.info("1-Kullanıcı URL ye gider");
        Thread.sleep(5000);
        /*
        Thread.sleep(5000);
        2-Kullanıcı Bakery bölümüne gider */
        bakeryPage.categoryDropDownButton.click();
        bakeryPage.bakeryDropDownButton.click();
        bakeryPage.categoryDropDownButton.click();

        //3-Kullanıcı tüm ürünlerden 30 adedini görür.
        List<WebElement> bakeryCharts = bakeryPage.bakeryProductBox;//Driver.getDriver().findElements(By.xpath("//span[text()='Product Image']"));
        Assert.assertTrue(bakeryCharts.size() == 30);
        extentTest.pass("Sayfada 30 adet ürün olduğu doğrulandı. ");


    }

    @Test
    public void TC_002() throws InterruptedException {//Load butonu ile birlikte daha fazla ürün yükleyip görebilmeldir.
        extentTest = extentReports.createTest("TC_002", "Load butonu ile birlikte daha fazla ürün yükleyip görebilmeldir.");
        //1-Kullanıcı URL ye gider
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        Thread.sleep(5000);
        /*
        2-Kullanıcı Bakery bölümüne gider */
        bakeryPage.categoryDropDownButton.click();
        bakeryPage.bakeryDropDownButton.click();
        bakeryPage.categoryDropDownButton.click();
        //3-Kullanıcı Load Butonunu görmek için aşağı kaydırır.
        int chartCount = 0;
        List<WebElement> bakeryChartsBefore = bakeryPage.bakeryProductBox;
        chartCount = bakeryChartsBefore.size();
        System.out.println("bakeryChartsBefore.size() = " + bakeryChartsBefore.size());
        //Assert.assertTrue(bakeryCharts.size()==30);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
        //4-Kullanıcı daha fazla ürün görmek için LOAD butonuna basar.
        bakeryPage.btnLoadMore.click();
        Thread.sleep(5000);
        actions.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();

        // 5-Kullanıcı Daha Fazla Ürün geldiğini görür
        System.out.println("bakeryChartsBefore.size() = " + bakeryChartsBefore.size());
        Assert.assertTrue(chartCount < bakeryChartsBefore.size());
        extentTest.pass("Kullanıcı load butonuna bastığında daha fazla Ürün geldiğini görür");

    }
    /*

    @Test
    public void TC_003() throws InterruptedException {
        extentTest = extentReports.createTest("TC_003", "Ürün kategorilerinde {Cookies, Juice,Coffee & Tea, Cookies, Round Cake, " +
                "Pita Bread, Sliced Cake, Muffin, Danish, Croissants, Feeter & Pies, Toast & Loaf, Soft Bread, Bakery}");

        /*Ürün kategorilerinde {Cookies, Juice,Coffee & Tea, Cookies, Round Cake,
     Pita Bread, Sliced Cake, Muffin, Danish, Croissants, Feeter & Pies, Toast & Loaf, Soft Bread, Bakery}

        //1-Kullanıcı URL ye gider
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        // extentTest.info("1-Kullanıcı URL ye gider");
        Thread.sleep(5000);
        /*
        Thread.sleep(5000);
        2-Kullanıcı Bakery bölümüne gider
        bakeryPage.categoryDropDownButton.click();
        bakeryPage.bakeryDropDownButton.click();
        bakeryPage.categoryDropDownButton.click();
        Thread.sleep(5000);
        Actions action=new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        bakeryPage.btnNext.click();
        bakeryPage.btnNext.click();
        bakeryPage.btnNext.click();

    }*/
}
