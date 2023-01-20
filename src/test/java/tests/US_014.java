package tests;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BagsPage;
import pages.HomePage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReports;

public class US_014 extends TestBaseReports {

    @Test
    public void TC_01() {

        extentTest=extentReports.createTest("US_14 TC_01", "Kullanıcı, bags urun kategorisini sectiğinde urun arayabilmelidir");


//1-Kullanıcı URL ye gider.
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        HomePage hp = new HomePage();



//2-Kullanıcı sol üstteki GROCERY butonuna tıklar.
        hp.categoryDropDownButton.click();



//3-Kullanıcı GROCERY butonundan aşağı doğru uzanan sekmelerden BAGS sekmesine tıklar
        hp.bagsButton.click();

//4-Kullanıcı SEARCH(Arama) bölmesine Keyword yazar ve ENTER'a basar

        BagsPage bp=new BagsPage();

        String metin1="Bag";
        bp.BagsSearchButton.sendKeys(metin1+ Keys.ENTER);



//5-Kullanıcı aradığı ürünün sayfada bulunduğunu görür



        System.out.println("Sayfadaki ilk ürünün ismi = " +bp.SayfadaIlkUrun.getText());

        ReusableMethods.assertAssertTrue(metin1, bp.SayfadaIlkUrun);

        extentTest.info("Kullanıcı search areadan urunleri keyword ile aradiginda listelenen urunlerde aranan keyword ü görüntüledi");



        Driver.closeDriver();

    }

    @Test
    public void TC_02() {

        extentTest=extentReports.createTest("US_14 TC_02","Kullanıcı, bags urun kategorisini sectiğinde urun arayabilmelidir");


//1-Kullanıcı URL ye gider.
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        HomePage hp = new HomePage();


//2-Kullanıcı sol üstteki GROCERY butonuna tıklar.
        hp.categoryDropDownButton.click();

//3-Kullanıcı GROCERY butonundan aşağı doğru uzanan sekmelerden BAGS sekmesine tıklar
        hp.bagsButton.click();


//4-Kullanıcı SEARCH(Arama) bölmesine sayfada bulunmayacak bir Keyword yazar ve ENTER'a basar
        BagsPage bp=new BagsPage();

        String metin2="Ball";
        bp.BagsSearchButton.sendKeys(metin2+ Keys.ENTER);


//5-Kullanıcı "Sorry, No Product Found :(" yazısını yani, aradığı ürünün sayfada bulunmadığını görür


        System.out.println("NoProductsFoundText = " +bp.NoProductsFoundText.getText() );

        ReusableMethods.assertAssertTrue("Sorry, No Product Found :(", bp.NoProductsFoundText);

        extentTest.info("Kullanici urunlerde bulunmayan bir keyword ile arama yaptığında -Sorry, No Product Found :(- yazısını görüntüledi ");

        Driver.closeDriver();
    }
}
