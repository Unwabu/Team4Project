package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FurniturePage;
import pages.HomePage;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_042 {
    @Test
    public void TC01() throws InterruptedException {

        //1-Kullanıcı URL ye gider.
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        FurniturePage fp = new FurniturePage();
        //2-Kullanıcı sol üstteki GROCERY butonuna tıklar.
        fp.categoryDropDownButton.click();
        //3-Kullanıcı GROCERY butonundan aşağı doğru uzanan sekmelerden FURNİTURE sekmesine tıklar
        fp.furnitureButton.click();
        //4-Kullanıcı çıkan ilk ürünün üzerine tıklar
        String metin = fp.ilkUrunName.getText();
        System.out.println(metin);
        fp.ilkUrunName.click();
        //5-Kullanıcı "Add To Shoping Cart" yazılı yeşil butona tıklar
        fp.addCartButton.click();
        //6-Kullanıcı sayfanın sağ orta tarafında bulunan "1 Item" yazan yeşil butona tıklar
        fp.itemCartButton.click();
        Thread.sleep(5000);
        //7-Kullanıcı Seçtiği ürünün sepete eklenmiş olduğunu görür
        System.out.println("hp.allTextInCart.getText() = " + fp.allTextInCart.getText());
        ReusableMethods.assertAssertTrue(metin,fp.allTextInCart);
        Driver.closeDriver();
    }
    @Test
    public void TC02() throws InterruptedException {

        //1-Kullanıcı URL ye gider.
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        FurniturePage fp = new FurniturePage();
        //2-Kullanıcı sol üstteki GROCERY butonuna tıklar.
        fp.categoryDropDownButton.click();
        //3-Kullanıcı GROCERY butonundan aşağı doğru uzanan sekmelerden FURNİTURE sekmesine tıklar
        fp.furnitureButton.click();
        //4-Kullanıcı "out of stock" olan ilk ürünün üzerine tıklar
        String metin = fp.ilkUrunName.getText();
        fp.ilkUrunName.click();
        //5-Kullanıcı "Add To Shoping Cart" yazılı yeşil butona tıklar
        fp.addCartButton.click();
        //6-Kullanıcı sayfanın sağ orta tarafında bulunan "1 Item" yazan yeşil butona tıklar
        fp.itemCartButton.click();
        Thread.sleep(5000);
        //7-Kullanıcı Seçtiği ürünün sepete eklenemediğini sepetin boş olduğunu görür
        System.out.println("hp.allTextInCart.getText() = " + fp.allTextInCart.getText());
        ReusableMethods.assertAssertFalse(metin,fp.allTextInCart);
        Driver.closeDriver();
    }
    @Test
    public void TC03() throws InterruptedException {

        //1-Kullanıcı URL ye gider.
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        FurniturePage fp = new FurniturePage();
        //2-Kullanıcı sol üstteki GROCERY butonuna tıklar.
        fp.categoryDropDownButton.click();
        //3-Kullanıcı GROCERY butonundan aşağı doğru uzanan sekmelerden FURNİTURE sekmesine tıklar
        fp.furnitureButton.click();
        //4-Kullanıcı çıkan ilk ürünün üzerine tıklar
        fp.ilkUrunName.click();
        //5-Kullanıcı "Add To Shoping Cart" yazılı yeşil butonun sağ tarafında bulunan stok adedini görür
        System.out.println("allStockText = " + fp.allStockText.getText());
        Assert.assertTrue(fp.allStockText.isDisplayed());
        Driver.closeDriver();
    }
    @Test
    public void TC04() throws InterruptedException {

        //1-Kullanıcı URL ye gider.
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        FurniturePage fp = new FurniturePage();
        //2-Kullanıcı sol üstteki GROCERY butonuna tıklar.
        fp.categoryDropDownButton.click();
        //3-Kullanıcı GROCERY butonundan aşağı doğru uzanan sekmelerden FURNİTURE sekmesine tıklar
        fp.furnitureButton.click();
        Thread.sleep(3000);
        //4-Kullanıcı çıkan ilk stoklu ürünün üzerine tıklar
        //5-Kullanıcı "Add To Shoping Cart" yazılı yeşil butona tıklar
        //6-Kullanıcı "+" butonunun sağ tarafında bulunan ürün stoğundan daha çok olacak şekilde "+" butonuna tıklar
        for (int i = 1; i <fp.UrunNameler.size(); i++) {
            fp.UrunNameler.get(i).click();
            if (fp.allStockText.getText().contains("available")) {
                fp.addCartButton.click();
                Thread.sleep(2000);
                for (int j=1  ;  j<=50 ;  j++  ){
                    fp.plusButton.click();
                }
                break;
            }
            fp.backButton.click();
        }
        //7-Kullanıcı eklenen ürün adedinin, stok adedini geçmediğini görür
        System.out.println("miktarInPage = " + fp.miktarInPage.getText());
        System.out.println("stockText = " + fp.stockText.getText());
        ReusableMethods.assertAssertTrue(fp.miktarInPage.getText(), fp.stockText);
        Driver.closeDriver();
    }
    @Test
    public void TC05() throws InterruptedException {

        //1-Kullanıcı URL ye gider.
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        FurniturePage fp = new FurniturePage();
        //2-Kullanıcı sol üstteki GROCERY butonuna tıklar.
        fp.categoryDropDownButton.click();
        //3-Kullanıcı GROCERY butonundan aşağı doğru uzanan sekmelerden FURNİTURE sekmesine tıklar
        fp.furnitureButton.click();
        //4-Kullanıcı çıkan ilk stoklu ürünün üzerine tıklar
        //5-Kullanıcı "Add To Shoping Cart" yazılı yeşil butona tıklar
        //6-Kullanıcı sayfanın sağ orta tarafında bulunan "1 Item" yazan yeşil butona tıklar
        //7-Kullanıcı Seçtiği ürünün sepete eklenmiş olduğunu görür
        //8-Kullanıcı sol üstte bulunan "+" butonuna tıklar
        //9-Kullanıcı adet sayısının 1 arttığını görür
        for (int i = 1; i < fp.UrunNameler.size(); i++) {
            fp.UrunNameler.get(i).click();
            if (fp.allStockText.getText().contains("available")) {
                fp.addCartButton.click();
                int ilkAdet = Integer.parseInt(fp.miktarInPage.getText());
                System.out.println("ilkAdet = " + ilkAdet);
                fp.itemCartButton.click();
                Thread.sleep(3000);
                fp.plusButtonCart.click();
                int sonAdet = Integer.parseInt(fp.miktarInCart.getText());
                System.out.println("sonAdet = " + sonAdet);
                Assert.assertTrue(sonAdet>ilkAdet);
                break;
            }
            fp.backButton.click();
        }
        Driver.closeDriver();
    }
}
