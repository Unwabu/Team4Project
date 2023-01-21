package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US19_page;
import pages.HomePage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReports;

    public class US19_Test extends TestBaseReports {

        @Test
        public void test() throws InterruptedException {
            extentTest = extentReports.createTest("DailyneedsUS19");
            //Kullanıcı URL ye gıder
            Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
            HomePage hp = new HomePage();
            US19_page pg = new US19_page();
            //Kullanıcı GROCERY butonuna tıklar
            hp.categoryDropDownButton.click();
            //Kullanıcı GROCERY butonundan Daily Needs sekmesını tıklar
            hp.dailyNeedsButton.click();

            //Kullanıcı Search arama motorunda bulunan ürünlerden arananı yazar ve ENTER'a tıklar
            String urun = "fish";
            ReusableMethods.yukleneneKadarBekle(pg.searchBox);
            pg.searchBox.sendKeys(urun + Keys.ENTER);


            Assert.assertTrue(pg.fishtikla.getText().toLowerCase().contains(urun));


            extentTest.info("Kullanıcı aradığı ürünün sayfada oldugunu görüntüledi");


        }
    }




