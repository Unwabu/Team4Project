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
public class US19_Test {
    @Test
    public void test() throws InterruptedException {
        //Kullanıcı URL ye gıder
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        HomePage hp=new HomePage();
        US19_page pg=new US19_page();
        //Kullanıcı GROCERY butonuna tıklar
        hp.categoryDropDownButton.click();
        //Kullanıcı GROCERY butonundan Daily Needs sekmesını tıklar
        hp.dailyNeedsButton.click();
        //  Thread.sleep(10);
//Kullanıcı Search arama motorunda bulunan ürünlerden arananı yazar ve ENTER'a tıklar
        String urun="fish";
        ReusableMethods.yukleneneKadarBekle(pg.searchBox);
        pg.searchBox.sendKeys(urun+Keys.ENTER);
//Kullanıcı aradığı ürünün sayfada oldugunu görüntüler
        for(WebElement each:pg.liste) {
            Assert.assertTrue(each.getText().toLowerCase().contains(urun));
            pg.fish();
        }
    }}
