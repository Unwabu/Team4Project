package tests;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FurniturePage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReports;

import java.time.Duration;

public class US_042 extends TestBaseReports {
    @Test (groups = {"smoke", "regression"})
    public void TC01() throws InterruptedException {
        extentTest = extentReports.createTest("US42_TC01", "Kullanici urunu sepete ekleyebilmeli");

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
        extentTest.info("Kullanıcı listedeki ilk ürünü seçti");

        //5-Kullanıcı "Add To Shoping Cart" yazılı yeşil butona tıklar
        fp.addCartButton.click();
        //6-Kullanıcı sayfanın sağ orta tarafında bulunan "1 Item" yazan yeşil butona tıklar
        ReusableMethods.yukleneneKadarBekle(fp.itemCartButton);
        //7-Kullanıcı Seçtiği ürünün sepete eklenmiş olduğunu görür
        System.out.println("allTextInCart = " + fp.allTextInCart.getText());
        ReusableMethods.assertAssertTrue(metin,fp.allTextInCart);
        extentTest.pass("Kullanıcı ürünün sepete eklenebildiğini doğruladı");

        Driver.closeDriver();
    }
    @Test(groups = {"smoke", "regression"})
    public void TC02() throws InterruptedException {
        extentTest = extentReports.createTest("US42_TC02", "Kullanıcı stokta olmayan ürünü sepete ekleyememeli");

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
        extentTest.info("Kullanıcı listedeki stokta olmayan ilk ürünü seçti");

        //5-Kullanıcı "Add To Shoping Cart" yazılı yeşil butona tıklar
        fp.addCartButton.click();
        //6-Kullanıcı sayfanın sağ orta tarafında bulunan "1 Item" yazan yeşil butona tıklar
        ReusableMethods.yukleneneKadarBekle(fp.itemCartButton);
        //7-Kullanıcı Seçtiği ürünün sepete eklenemediğini sepetin boş olduğunu görür
        System.out.println("allTextInCart = " + fp.allTextInCart.getText());
        ReusableMethods.assertAssertFalse(metin,fp.allTextInCart);
        extentTest.pass("Kullanıcı stokta olmyana ürünün sepete eklenemediğini doğruladı");

        Driver.closeDriver();
    }
    @Test(groups = {"regression"})
    public void TC03() throws InterruptedException {
        extentTest = extentReports.createTest("US42_TC03", "Kullanici urun stogunu goruntuleyebilmeli");

        //1-Kullanıcı URL ye gider.
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        FurniturePage fp = new FurniturePage();
        //2-Kullanıcı sol üstteki GROCERY butonuna tıklar.
        fp.categoryDropDownButton.click();
        //3-Kullanıcı GROCERY butonundan aşağı doğru uzanan sekmelerden FURNİTURE sekmesine tıklar
        fp.furnitureButton.click();
        //4-Kullanıcı çıkan ilk ürünün üzerine tıklar
        fp.ilkUrunName.click();
        extentTest.info("Kullanıcı listedeki ilk ürünü seçti");

        //5-Kullanıcı "Add To Shoping Cart" yazılı yeşil butonun sağ tarafında bulunan stok adedini görür
        System.out.println("allStockText = " + fp.allStockText.getText());
        Assert.assertTrue(fp.allStockText.isDisplayed());
        extentTest.pass("Kullanıcı ürün stoğunu görebildiğini doğruladı");

        Driver.closeDriver();
    }
    @Test(groups = {"smoke", "regression"})
    public void TC04() throws InterruptedException {
        extentTest = extentReports.createTest("US42_TC04", "Kullanici urun stogundan fazla ekleme yapamamali");

        //1-Kullanıcı URL ye gider.
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        FurniturePage fp = new FurniturePage();
        //2-Kullanıcı sol üstteki GROCERY butonuna tıklar.
        fp.categoryDropDownButton.click();
        //3-Kullanıcı GROCERY butonundan aşağı doğru uzanan sekmelerden FURNİTURE sekmesine tıklar
        fp.furnitureButton.click();
        //4-Kullanıcı çıkan ilk stoklu ürünün üzerine tıklar
        extentTest.info("Kullanıcı listedeki ilk stoklu ürünü seçti");

        //5-Kullanıcı "Add To Shoping Cart" yazılı yeşil butona tıklar
        //6-Kullanıcı "+" butonunun sağ tarafında bulunan ürün stoğundan daha çok olacak şekilde "+" butonuna tıklar
        for (int i = 5; i <fp.UrunNameler.size(); i++) {
            fp.UrunNameler.get(i).click();
            if (fp.allStockText.getText().contains("available")) {
                fp.addCartButton.click();
                ReusableMethods.yukleneneKadarBekle(fp.plusButton);
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
        extentTest.pass("Kullanıcı stoktan fazla ekleme yapamadığını doğruladı");

        Driver.closeDriver();
    }
    @Test(groups = {"regression"})
    public void TC05() throws InterruptedException {
        extentTest = extentReports.createTest("US42_TC05", "Kullanici sepetinden urun artirabilmeli");

        //1-Kullanıcı URL ye gider.
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        FurniturePage fp = new FurniturePage();
        //2-Kullanıcı sol üstteki GROCERY butonuna tıklar.
        fp.categoryDropDownButton.click();
        //3-Kullanıcı GROCERY butonundan aşağı doğru uzanan sekmelerden FURNİTURE sekmesine tıklar
        fp.furnitureButton.click();
        //4-Kullanıcı çıkan ilk stoklu ürünün üzerine tıklar
        extentTest.info("Kullanıcı listedeki ilk stoklu ürünü seçti");

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
                ReusableMethods.yukleneneKadarBekle(fp.plusButtonCart);
                int sonAdet = Integer.parseInt(fp.miktarInCart.getText());
                System.out.println("sonAdet = " + sonAdet);
                Assert.assertTrue(sonAdet>ilkAdet);
                break;
            }
            fp.backButton.click();
        }
        extentTest.pass("Kullanıcı sepetteyken ürün miktarını arttırabildiğini doğruladı");

        Driver.closeDriver();
    }
    @Test(groups = {"regression"})
    public void TC06() throws InterruptedException {
        extentTest = extentReports.createTest("US42_TC06", "Kullanici sepetinden urun azaltabilmeli");

        //1-Kullanıcı URL ye gider.
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        FurniturePage fp = new FurniturePage();
        //2-Kullanıcı sol üstteki GROCERY butonuna tıklar.
        fp.categoryDropDownButton.click();
        //3-Kullanıcı GROCERY butonundan aşağı doğru uzanan sekmelerden FURNİTURE sekmesine tıklar
        fp.furnitureButton.click();
        //4-Kullanıcı çıkan ilk stoklu ürünün üzerine tıklar
        extentTest.info("Kullanıcı listedeki ilk stoklu ürünü seçti");

        //5-Kullanıcı "Add To Shoping Cart" yazılı yeşil butona tıklar
        //6-Kullanıcı sayfanın sağ orta tarafında bulunan "1 Item" yazan yeşil butona tıklar
        //7-Kullanıcı Seçtiği ürünün sepete eklenmiş olduğunu görür
        //8-Kullanıcı sol üstte bulunan "+" butonuna tıklar ve adet sayısını 1 tane daha arttırarak 2 yapar
        //9-Kullanıcı sol altta bulunan "-" butonuna tıklar
        //10-Kullanıcı adet sayısının 1 azaldığını görür
        for (int i = 1; i < fp.UrunNameler.size(); i++) {
            fp.UrunNameler.get(i).click();
            if (fp.allStockText.getText().contains("available")) {
                fp.addCartButton.click();
                fp.itemCartButton.click();
                ReusableMethods.yukleneneKadarBekle(fp.plusButton);
                int ilkAdet = Integer.parseInt(fp.miktarInPage.getText());
                System.out.println("ilkAdet = " + ilkAdet);
                fp.minusButtonCart.click();
                int sonAdet = Integer.parseInt(fp.miktarInCart.getText());
                System.out.println("sonAdet = " + sonAdet);
                Assert.assertTrue(sonAdet<ilkAdet);
                break;
            }
            fp.backButton.click();
        }
        extentTest.pass("Kullanıcı sepetteyken ürün miktarını azaltabildiğini doğruladı");

        Driver.closeDriver();
    }
    @Test(groups = {"regression"})
    public void TC07() throws InterruptedException {
        extentTest = extentReports.createTest("US42_TC07", "Kullanici sepetinden urun cikarabilmeli ");

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
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
        extentTest.info("Kullanıcı listedeki ilk stoklu ürünü seçti");

        //5-Kullanıcı "Add To Shoping Cart" yazılı yeşil butona tıklar
        fp.addCartButton.click();
        //6-Kullanıcı sayfanın sağ orta tarafında bulunan "1 Item" yazan yeşil butona tıklar
        fp.itemCartButton.click();
        //7-Kullanıcı Seçtiği ürünün sepete eklenmiş olduğunu görür ve sağ tarafta bulunan "X" butonuna tıklar
        wait.until(ExpectedConditions.visibilityOf(fp.allTextInCart));
        System.out.println("allTextInCart = " + fp.allTextInCart.getText());
        Actions act = new Actions(Driver.getDriver());
        act.moveToElement(fp.xRemoveButton).click().perform();
        //9-Kullanıcı ürünün sepetten çıkarıldığını görür, eğer sepette başka ürün de yoksa "No products found" yazısını ve sepetin boş olduğunu görür
        System.out.println("allTextInCart = " + fp.allTextInCart.getText());
        ReusableMethods.assertAssertFalse(metin,fp.allTextInCart);
        extentTest.pass("Kullanıcı sepetten ürün çıkarabildiğini doğruladı");

        Driver.closeDriver();
    }
    @Test(groups = {"regression"})
    public void TC08() throws InterruptedException {
        extentTest = extentReports.createTest("US42_TC08", "Kullanici sepette urunun birim fiyatini goruntuleyebilmeli");

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        //1-Kullanıcı URL ye gider.
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        FurniturePage fp = new FurniturePage();
        //2-Kullanıcı sol üstteki GROCERY butonuna tıklar.
        fp.categoryDropDownButton.click();
        //3-Kullanıcı GROCERY butonundan aşağı doğru uzanan sekmelerden FURNİTURE sekmesine tıklar
        fp.furnitureButton.click();
        //4-Kullanıcı çıkan ilk stoklu ürünün üzerine tıklar
        extentTest.info("Kullanıcı listedeki ilk stoklu ürünü seçti");

        //5-Kullanıcı "Add To Shoping Cart" yazılı yeşil butona tıklar
        //6-Kullanıcı sayfanın sağ orta tarafında bulunan "1 Item" yazan yeşil butona tıklar
        //7-Kullanıcı Seçtiği ürünün sepete eklenmiş olduğunu görür
        //8-Kullanıcı sol üstte bulunan "+" butonuna tıklar ve adet sayısını 1 arttırır
        //9-Kullanıcı solda ürünün birim fiyatının değişmediğini görür
        for (int i = 1; i < fp.UrunNameler.size(); i++) {
            fp.UrunNameler.get(i).click();
            if (fp.allStockText.getText().contains("available")) {
                fp.addCartButton.click();
                fp.itemCartButton.click();
                wait.until(ExpectedConditions.visibilityOf(fp.productPriceText));
                String metin = fp.productPriceText.getText();
                System.out.println("firstPrice = " + metin);
                fp.plusButtonCart.click();
                System.out.println("LastPrice = " + fp.productPriceText.getText());
                ReusableMethods.assertAssertTrue(metin,fp.productPriceText);
                break;
            }
            fp.backButton.click();
        }
        extentTest.pass("Kullanıcı sepette ürün birim fiyatının göründüğünü doğruladı");

        Driver.closeDriver();
    }
    @Test(groups = {"smoke", "regression"})
    public void TC09() throws InterruptedException {
        extentTest = extentReports.createTest("US42_TC09", "Kullanici sepette urunun toplam fiyatini goruntuleyebilmeli");

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        //1-Kullanıcı URL ye gider.
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        FurniturePage fp = new FurniturePage();
        //2-Kullanıcı sol üstteki GROCERY butonuna tıklar.
        fp.categoryDropDownButton.click();
        //3-Kullanıcı GROCERY butonundan aşağı doğru uzanan sekmelerden FURNİTURE sekmesine tıklar
        fp.furnitureButton.click();
        //4-Kullanıcı çıkan ilk stoklu ürünün üzerine tıklar
        extentTest.info("Kullanıcı listedeki ilk stoklu ürünü seçti");

        //5-Kullanıcı "Add To Shoping Cart" yazılı yeşil butona tıklar
        //6-Kullanıcı sayfanın sağ orta tarafında bulunan "1 Item" yazan yeşil butona tıklar
        //7-Kullanıcı Seçtiği ürünün sepete eklenmiş olduğunu görür
        //8-Kullanıcı sol üstte bulunan "+" butonuna tıklar ve adet sayısını 1 arttırır
        //9-Kullanıcı sağda ürünün toplam fiyatının değiştiğini görür
        for (int i = 1; i < fp.UrunNameler.size(); i++) {
            fp.UrunNameler.get(i).click();
            if (fp.allStockText.getText().contains("available")) {
                fp.addCartButton.click();
                fp.itemCartButton.click();
                wait.until(ExpectedConditions.visibilityOf(fp.totalPriceText));
                String metin = fp.totalPriceText.getText();
                System.out.println("firstPrice = " + metin);
                fp.plusButtonCart.click();
                System.out.println("LastPrice = " + fp.totalPriceText.getText());
                ReusableMethods.assertAssertFalse(metin,fp.totalPriceText);
                break;
            }
            fp.backButton.click();
        }
        extentTest.pass("Kullanıcı sepette ürün toplam fiyatının değiştiğini ve göründüğünü doğruladı");

        Driver.closeDriver();
    }
}
