package tests;


import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReports;

import java.time.Duration;
import java.util.Set;

public class US_001TC10TC11 extends TestBaseReports {

    Faker faker = new Faker();
    HomePage hp = new HomePage();
    SellerRegisterPage sp = new SellerRegisterPage();
    WebDriver driver = Driver.getDriver();
    SellerLoginPage sl = new SellerLoginPage();
    SellerLoggedInPage sli = new SellerLoggedInPage();
    SellerManufacturersPublicationsPage mPup = new SellerManufacturersPublicationsPage();
    SellerAuthorsPage auth = new SellerAuthorsPage();

    @Test(groups = {"smoke", "regression"})
    public void TC_002() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        driver.get("https://shop-pickbazar-rest.vercel.app/");
        String simtenMail = ConfigReader.getProperty("simtenMail");
        String simtenPassword = ConfigReader.getProperty("simtenPassword");
        String firstPageHandle = driver.getWindowHandle();

        hp.becomeASellerButton.click();

        Set<String> allWindowHandles = driver.getWindowHandles();

        String secondWindowHandle = "";

        for (String each : allWindowHandles) {
            if (!each.equals(firstPageHandle)) {
                secondWindowHandle = each;
            }
        }
        driver.switchTo().window(secondWindowHandle);
        Assert.assertTrue(driver.getCurrentUrl().contains("register"));
        sp.loginButton.click();
        Thread.sleep(5000);

        sl.mailBox.clear();
        sl.mailBox.sendKeys(simtenMail);
        sl.passwordBox.clear();
        sl.passwordBox.sendKeys(simtenPassword);
        sl.loginButton.click();

        wait.withTimeout(Duration.ofSeconds(5));
        Assert.assertTrue(sli.avatarIcon.isDisplayed());

    }
    @Test(dependsOnMethods = "TC_002",
            groups ={"smoke", "regression"})
    public void TC_010() throws InterruptedException {
        extentTest = extentReports.createTest("US01_TC10", "satici Manufacturers/Publications bolumunde ekleme yapabilmeli ve onay islemini gerceklesirebilmelidir");

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        Thread.sleep(3000);
        extentTest.info("Kullanıcı satıcı olarak siteye giriş yaptı");

        mPup.manufacturersPublicationsButton.click();
        ReusableMethods.yukleneneKadarBekle(mPup.addManuPubButton);
        wait.until(ExpectedConditions.visibilityOf(mPup.nameBox));
        String metin = "Lanet Getsin Bole Siteye...!!!";
        System.out.println(metin);
        mPup.nameBox.sendKeys(metin);
        mPup.websiteBox.sendKeys(faker.internet().domainName());
        mPup.descriptionBox.sendKeys(faker.funnyName().name());
        Actions act = new Actions(driver);
        act.moveToElement(mPup.groupDropDownBox).click().sendKeys("Grocery"+Keys.ENTER).perform();
        ReusableMethods.yukleneneKadarBekle(mPup.addManuPubBox);
        wait.until(ExpectedConditions.visibilityOf(mPup.firstManuPubInfo));
        System.out.println("fistManuPubInfo = "+mPup.firstManuPubInfo.getText());
        ReusableMethods.assertAssertTrue(metin, mPup.firstManuPubInfo);
        extentTest.pass("satici Manufacturers/Publications bolumunde ekleme yapabildiğini doğruladı");

        if (mPup.enabledButton.isDisplayed()){
            Assert.assertTrue(mPup.enabledButton.isDisplayed());
        } else {
            mPup.disabledButton.click();
            Thread.sleep(3000);
            Assert.assertTrue(mPup.enabledButton.isDisplayed());
        }
        extentTest.pass("satici Manufacturers/Publications bolumunde onaylama yapabildiğini doğruladı");

    }
    @Test(dependsOnMethods = "TC_002",
            groups = "regression")
    public void TC_011() throws InterruptedException {
        extentTest = extentReports.createTest("US01_TC11", "satici Author bolumunde yazar ekleme, onay, düzenleme ve silme islemlerini gerceklesirebilmelidir");

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        Thread.sleep(3000);
        extentTest.info("Kullanıcı satıcı olarak siteye giriş yaptı");

        ReusableMethods.yukleneneKadarBekle(auth.authorsButton);
        ReusableMethods.yukleneneKadarBekle(auth.addAuthorsButton);
        wait.until(ExpectedConditions.visibilityOf(auth.nameBox));
        String metin = "Lanet Getsin Bole Siteye...!!!";
        System.out.println(metin);
        auth.nameBox.sendKeys(metin);
        auth.languageBox.sendKeys(faker.programmingLanguage().name());
        auth.bioBox.sendKeys(faker.funnyName().name());
        auth.quoteBox.sendKeys(faker.funnyName().name());
        Actions act = new Actions(driver);
        act.moveToElement(auth.bornBox).click().sendKeys(faker.date().birthday().toString()+Keys.ENTER).perform();
        act.moveToElement(auth.deathBox).click().sendKeys(faker.date().toString()+Keys.ENTER).perform();
        ReusableMethods.yukleneneKadarBekle(auth.addAuthorsBox);
        wait.until(ExpectedConditions.visibilityOf(auth.firstAuthorInfo));
        System.out.println("fistManuPubInfo = "+auth.firstAuthorInfo.getText());
        ReusableMethods.assertAssertTrue(metin, auth.firstAuthorInfo);
        extentTest.pass("satici Author bolumunde yazar ekleme yapabildiğini doğruladı");

        if (auth.enabledButton.isDisplayed()){
            Assert.assertTrue(auth.enabledButton.isDisplayed());
        } else {
            auth.disabledButton.click();
            Thread.sleep(3000);
            Assert.assertTrue(auth.enabledButton.isDisplayed());
        }
        extentTest.pass("satici Author bolumunde yazar onaylama yapabildiğini doğruladı");

        auth.editButton.click();
        wait.until(ExpectedConditions.visibilityOf(auth.nameBox));
        String metin2 = "Lanet Gele Nalet...!!!";
        System.out.println(metin2);
        auth.nameBox.sendKeys(metin2);
        auth.updateAuthorsBox.click();
        ReusableMethods.yukleneneKadarBekle(auth.backBox);
        wait.until(ExpectedConditions.visibilityOf(auth.firstAuthorInfo));
        System.out.println("fistManuPubInfo = "+auth.firstAuthorInfo.getText());
        ReusableMethods.assertAssertTrue(metin2, auth.firstAuthorInfo);
        extentTest.pass("satici Author bolumunde düzenleme yapabildiğini doğruladı");

        auth.deleteButton.click();
        ReusableMethods.yukleneneKadarBekle(auth.deleteBox);
        wait.until(ExpectedConditions.visibilityOf(auth.firstAuthorInfo));
        System.out.println("fistManuPubInfo = "+auth.firstAuthorInfo.getText());
        ReusableMethods.assertAssertFalse(metin2, auth.firstAuthorInfo);
        extentTest.pass("satici Author bolumunde yazar silme işlemini yapabildiğini doğruladı");

    }
}

