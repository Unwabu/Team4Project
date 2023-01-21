package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.FurniturePage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReports;

public class US_039 extends TestBaseReports {
    @Test(groups = {"smoke", "regression"})
    public void TC01() throws InterruptedException {
        extentTest = extentReports.createTest("US39_TC01", "Kullanıcı, ürünlerde geçen Keyword ile arama yaptığında Keyword listede geçmelidir");

        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        FurniturePage fp = new FurniturePage();
        fp.categoryDropDownButton.click();
        fp.furnitureButton.click();
        String metin1="bed";
        fp.furnitureSearchButton.sendKeys(metin1+Keys.ENTER);
        extentTest.info("Kullanıcı Keywordle arama yaptı");

        System.out.println("ilkUrunName = " + fp.ilkUrunName.getText());
        ReusableMethods.assertAssertTrue(metin1, fp.ilkUrunName);
        extentTest.pass("Arama yapılan Keyword'ün Listede olduğu doğrulandı.");

        Driver.closeDriver();
    }
    @Test(groups = {"regression"})
    public void TC02() throws InterruptedException {
        extentTest = extentReports.createTest("US39_TC02", "Kullanıcı, ürünlerde geçmeyen Keyword ile arama yaptığında boş liste görünmelidir");

        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        FurniturePage fp = new FurniturePage();
        fp.categoryDropDownButton.click();
        fp.furnitureButton.click();

        String metin2="phone";
        fp.furnitureSearchButton.sendKeys(metin2+Keys.ENTER);
        extentTest.info("Kullanıcı Keywordle arama yaptı");

        System.out.println("noProductsFoundText = " + fp.noProductsFoundMainText.getText());
        ReusableMethods.assertAssertTrue("Sorry, No Product Found :(", fp.noProductsFoundMainText);
        extentTest.pass("Keyword bulunmadığı için listenin boş olduğu doğrulandı");

        Driver.closeDriver();
    }
    @Test(groups = {"smoke", "regression"})
    public void TC03() throws InterruptedException {
        extentTest = extentReports.createTest("US39_TC03", "Kullanıcı, filtreyle arama yaptığında istediği ürünleri görebilmelidir");

        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        FurniturePage fp = new FurniturePage();
        fp.categoryDropDownButton.click();
        fp.furnitureButton.click();
        extentTest.info("Kullanıcı filtreleme bölümünü açtı");

        for (WebElement w : fp.furnitureSubCategories) {
            w.click();
            ReusableMethods.assertAssertTrue(w.getText(),fp.ilkUrunName);
        }
        extentTest.pass("Kullanıcı filtreleyerek sadece istediği ürün çeşitlerini görebildiğini doğruladı");

        Driver.closeDriver();
    }
}
