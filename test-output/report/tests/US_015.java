package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BagsPage;
import pages.HomePage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReports;

public class US_015 extends TestBaseReports {

    @Test

    public void TC_01 () {

        extentTest= extentReports.createTest("US_15 , TC_01" ,"Kullanıcı sayfada iken secilen urun miktari degistirilmelidir");

//1. Kullanıcı URL gider
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        HomePage hp = new HomePage();

//2-Kullanıcı sol üstteki GROCERY butonuna tıklar.
        hp.categoryDropDownButton.click();

//3-Kullanıcı GROCERY butonundan aşağı doğru uzanan sekmelerden Bags sekmesine tıklar
        hp.bagsButton.click();

//4-Kullanıcı açılan Bags sayfasında eklemek istediği ürünün sağ alt köşesindeki Cart ı tıklar
        //(Ürün adı:Givenchy Mini Purse)
        BagsPage bp=new BagsPage();
        bp.Cart.click();



//5-Kullanıcı aradığı ürünün 1 adet olarak eklendiğini görür

        if (bp.itemControl.isDisplayed()) {
            System.out.println("Bags sayfasında iken ürünün 1 adet olarak eklendiği görüntülendi");
        } else {
            System.out.println("Bags sayfasında iken ürünün 1 adet olarak eklendiği görüntülenmedi");
        }

        extentTest.info("Kullanıcı aradığı ürünün 1 adet olarak eklendiğini görüntüledi");

//6-Kullanıcı ürün miktarını artırmak istediği oranda + tuşuna basar

        bp.BagsPlusCart.click();

        extentTest.info("Kullanıcı + tuşuna bastığında ürün miktarını artırdığını görüntüledi");

//7-Kullanıcı ürün miktarını azaltmak istediği oranda - tuşuna basar

        bp.BagsMinusCart.click();

        extentTest.info("Kullanıcı - tuşuna bastığında ürün miktarını azalttığını görüntüledi");


        Driver.closeDriver();


    }

    @Test
    public void TC_02() {

        extentTest= extentReports.createTest("US_15 , TC_02" ,"Kullanıcı sepette iken secilen urun miktari degistirilmelidir");

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

        bp.ItemCart.click();


//6-Kullanıcı ürün miktarını artırmak istediği oranda + tuşuna basar

        bp.PlusCart.click();


        extentTest.info("Kullanıcı sepette iken + tuşuna bastığında ürün miktarını artırdığını görüntüledi");

//7-Kullanıcı ürün miktarını azaltmak istediği oranda - tuşuna basar

        bp.MinusCart.click();

        extentTest.info("Kullanıcı sepette iken - tuşuna bastığında ürün miktarını azaldığını görüntüledi");

        Driver.closeDriver();




    }


}
