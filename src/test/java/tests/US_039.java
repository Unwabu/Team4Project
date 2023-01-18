package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.FurniturePage;
import pages.HomePage;
import utilities.Driver;
import utilities.ReusableMethods;
public class US_039 {
    @Test
    public void TC01() {

        //1-Kullanıcı URL ye gider.
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        FurniturePage fp = new FurniturePage();
        //2-Kullanıcı sol üstteki GROCERY butonuna tıklar.
        fp.categoryDropDownButton.click();
        //3-Kullanıcı GROCERY butonundan aşağı doğru uzanan sekmelerden FURNİTURE sekmesine tıklar
        fp.furnitureButton.click();
        //4-Kullanıcı SEARCH(Arama) bölmesine sayfada bulunan ürünlerden birini yazar ve ENTER'a basar
        String metin1="bed";
        fp.furnitureSearchButton.sendKeys(metin1+Keys.ENTER);
        //5-Kullanıcı aradığı ürünün sayfada bulunduğunu görür
        System.out.println("ilkUrunName = " + fp.ilkUrunName.getText());
        ReusableMethods.assertAssertTrue(metin1, fp.ilkUrunName);
        Driver.closeDriver();
    }
    @Test
    public void TC02() {

        //1-Kullanıcı URL ye gider.
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        FurniturePage fp = new FurniturePage();
        //2-Kullanıcı sol üstteki GROCERY butonuna tıklar.
        fp.categoryDropDownButton.click();
        //3-Kullanıcı GROCERY butonundan aşağı doğru uzanan sekmelerden FURNİTURE sekmesine tıklar
        fp.furnitureButton.click();
        //4-Kullanıcı SEARCH(Arama) bölmesine sayfada bulunmayan ürünlerden birini yazar ve ENTER'a basar
        String metin2="phone";
        fp.furnitureSearchButton.sendKeys(metin2+Keys.ENTER);
        //5-Kullanıcı "Sorry, No Product Found :(" yazısını yani, aradığı ürünün sayfada bulunmadığını görür
        System.out.println("noProductsFoundText = " + fp.noProductsFoundMainText.getText());
        ReusableMethods.assertAssertTrue("Sorry, No Product Found :(", fp.noProductsFoundMainText);
        Driver.closeDriver();
    }
    @Test
    public void TC03() {

        //1-Kullanıcı URL ye gider.
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        FurniturePage fp = new FurniturePage();
        //2-Kullanıcı sol üstteki GROCERY butonuna tıklar.
        fp.categoryDropDownButton.click();
        //3-Kullanıcı GROCERY butonundan aşağı doğru uzanan sekmelerden FURNİTURE sekmesine tıklar
        fp.furnitureButton.click();
        //4-Kullanıcı solda bulunan alt kategorilere sırayla tıklar
        //5-Kullanıcı sadece aradığı alt kategorideki ürünlerin sayfada bulunduğunu görür
        for (WebElement w : fp.furnitureSubCategories) {
            w.click();
            ReusableMethods.assertAssertTrue(w.getText(),fp.ilkUrunName);
        }
        Driver.closeDriver();
    }
}
