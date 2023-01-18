package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BagsPage;
import pages.HomePage;
import utilities.Driver;

public class US_015 {

    @Test

    public void SayfadaUrunArtirmaAzaltma () {

//1. Kullanıcı URL gider
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        HomePage hp = new HomePage();

//2-Kullanıcı sol üstteki GROCERY butonuna tıklar.
        hp.categoryDropDownButton.click();

//3-Kullanıcı GROCERY butonundan aşağı doğru uzanan sekmelerden Bags sekmesine tıklar
        hp.bagsButton.click();

//4-Kullanıcı açılan Bags sayfasında eklemek istediği ürünün sağ alt köşesindeki Cart ı tıklar
        BagsPage bp=new BagsPage();
        bp.Cart.click();

//5-Kullanıcı aradığı ürünün 1 adet olarak eklendiğini görür

        if (bp.itemControl.isDisplayed()) {
            System.out.println("Bags sayfasında iken ürünün 1 adet olarak eklendiği görüntülendi");
        } else {
            System.out.println("Bags sayfasında iken ürünün 1 adet olarak eklendiği görüntülenmedi");
        }

//6-Kullanıcı ürün miktarını artırmak istediği oranda + tuşuna basar


//7-Kullanıcı ürün miktarını azaltmak istediği oranda - tuşuna basar

    }

    @Test
    public void SepetteUrunArtirmaAzaltma() {
//1. Kullanıcı URL gider
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        HomePage hp = new HomePage();

//2-Kullanıcı sol üstteki GROCERY butonuna tıklar.
        hp.categoryDropDownButton.click();

//3-Kullanıcı GROCERY butonundan aşağı doğru uzanan sekmelerden Bags sekmesine tıklar
        hp.bagsButton.click();

//4-Kullanıcı açılan Bags sayfasında eklemek istediği ürünün sağ alt köşesindeki Cart ı tıklar
        BagsPage bp=new BagsPage();
        bp.Cart.click();

//5-Kullanıcı sepete gider
//6-Kullanıcı sepette eklediği ürünü görür
//7-Kullanıcı ürün miktarını artırmak istediği oranda + tuşuna basar
//8-Kullanıcı ürün miktarını azaltmak istediği oranda - tuşuna basar

    }


}
