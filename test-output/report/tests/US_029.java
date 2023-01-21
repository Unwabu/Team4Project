package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HuseyinPage;
import utilities.Driver;

public class US_029 {

    // US = Kullanıcı pakete ürün ekleyebilmeli ve azaltabilmeli
    @Test
    public void testCase01 () throws InterruptedException {

        HuseyinPage hp = new HuseyinPage();

        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        hp.shopButton.click();
        hp.groceeryShop.click();
        hp.leemon.click();
        hp.sepet.click();
        hp.urunArtır.click();
        Thread.sleep(500);
        hp.urunArtır.click();
        hp.urunArtır.click();

        String actualResult = hp.siparisAdedi.getText();
        Assert.assertEquals(actualResult, "4");

        hp.urunAzalat.click();
        hp.urunAzalat.click();
        Thread.sleep(500);
        hp.urunAzalat.click();

        actualResult = hp.siparisAdedi.getText();
        Assert.assertEquals(actualResult, "1");

       Driver.getDriver().close();

    }
}