package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BagsPage;
import pages.HomePage;
import utilities.Driver;

public class US_014 {

    @Test
    public void UrunMevcut() {


//1-Kullanıcı URL ye gider.
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        HomePage hp = new HomePage();

//2-Kullanıcı sol üstteki GROCERY butonuna tıklar.
        hp.categoryDropDownButton.click();

//3-Kullanıcı GROCERY butonundan aşağı doğru uzanan sekmelerden BAGS sekmesine tıklar
        hp.bagsButton.click();

//4-Kullanıcı SEARCH(Arama) bölmesine sayfada bulunan ürünlerden birini yazar ve ENTER'a basar
        BagsPage bp = new BagsPage();
        bp.SearchABag.click();

//5-Kullanıcı aradığı ürünün sayfada bulunduğunu görür


    }

    @Test
    public void UrunYok() {


//1-Kullanıcı URL ye gider.
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        HomePage hp = new HomePage();

//2-Kullanıcı sol üstteki GROCERY butonuna tıklar.
        hp.categoryDropDownButton.click();

//3-Kullanıcı GROCERY butonundan aşağı doğru uzanan sekmelerden BAGS sekmesine tıklar
        hp.bagsButton.click();

//4-Kullanıcı SEARCH(Arama) bölmesine sayfada bulunan ürünlerden birini yazar ve ENTER'a basar
        BagsPage bp = new BagsPage();
        bp.SearchAnotherBag.click();

//5-Kullanıcı "Sorry, No Product Found :(" yazısını yani, aradığı ürünün sayfada bulunmadığını görür


    }



}
