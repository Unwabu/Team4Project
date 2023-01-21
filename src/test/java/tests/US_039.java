package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.FurniturePage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReports;

public class US_039 extends TestBaseReports {
    @Test
    public void TC01() {
        extentTest = extentReports.createTest("US39_TC01", "Kullanıcı, ürünlerde geçen Keyword ile arama yaptığında Keyword listede geçmelidir");

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
        extentTest.info("Kullanıcı Keywordle arama yaptı");

        //5-Kullanıcı aradığı ürünün sayfada bulunduğunu görür
        System.out.println("ilkUrunName = " + fp.ilkUrunName.getText());
        ReusableMethods.assertAssertTrue(metin1, fp.ilkUrunName);
        extentTest.pass("Arama yapılan Keyword'ün Listede olduğu doğrulandı.");

        Driver.closeDriver();
    }
    @Test
    public void TC02() {
        extentTest = extentReports.createTest("US39_TC02", "Kullanıcı, ürünlerde geçmeyen Keyword ile arama yaptığında boş liste görünmelidir");

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
        extentTest.info("Kullanıcı Keywordle arama yaptı");

        //5-Kullanıcı "Sorry, No Product Found :(" yazısını yani, aradığı ürünün sayfada bulunmadığını görür
        System.out.println("noProductsFoundText = " + fp.noProductsFoundMainText.getText());
        ReusableMethods.assertAssertTrue("Sorry, No Product Found :(", fp.noProductsFoundMainText);
        extentTest.pass("Keyword bulunmadığı için listenin boş olduğu doğrulandı");

        Driver.closeDriver();
    }
    @Test
    public void TC03() {
        extentTest = extentReports.createTest("US39_TC03", "Kullanıcı, filtreyle arama yaptığında istediği ürünleri görebilmelidir");

        //1-Kullanıcı URL ye gider.
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        FurniturePage fp = new FurniturePage();
        //2-Kullanıcı sol üstteki GROCERY butonuna tıklar.
        fp.categoryDropDownButton.click();
        //3-Kullanıcı GROCERY butonundan aşağı doğru uzanan sekmelerden FURNİTURE sekmesine tıklar
        fp.furnitureButton.click();
        //4-Kullanıcı solda bulunan alt kategorilere sırayla tıklar
        extentTest.info("Kullanıcı filtreleme bölümünü açtı");

        //5-Kullanıcı sadece aradığı alt kategorideki ürünlerin sayfada bulunduğunu görür
        for (WebElement w : fp.furnitureSubCategories) {
            w.click();
            ReusableMethods.assertAssertTrue(w.getText(),fp.ilkUrunName);
        }
        extentTest.pass("Kullanıcı filtreleyerek sadece istediği ürün çeşitlerini görebildiğini doğruladı");

        Driver.closeDriver();
    }
}
