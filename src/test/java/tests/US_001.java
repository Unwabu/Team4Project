package tests;


import com.beust.ah.A;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class US_001 {

    Faker faker = new Faker();
    HomePage hp = new HomePage();
    SellerRegisterPage sp = new SellerRegisterPage();
    WebDriver driver = Driver.getDriver();
    SellerLoginPage sl = new SellerLoginPage();
    SellerLoggedInPage sli = new SellerLoggedInPage();
    SellerCreateShopPage scs = new SellerCreateShopPage();
    SellerMyShopsPage sms = new SellerMyShopsPage();
    SellerFirstShopPage sfs = new SellerFirstShopPage();
    SellerProductsPage spp = new SellerProductsPage();
    SellerCreateProductPage scpp=new SellerCreateProductPage();


    @Test

    public void TC_001() {

//kontrol yorumu


        driver.get("https://shop-pickbazar-rest.vercel.app/");

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
        Assert.assertNotEquals(firstPageHandle, driver.getWindowHandle());

        String isim = faker.name().name();
        sp.nameBox.sendKeys(isim);
        sp.mailBox.sendKeys(faker.internet().emailAddress());
        sp.passwordBox.sendKeys(faker.internet().password());
        sp.registerButton.click();
        Assert.assertEquals(sp.saticiIsim.getText(), isim);
        driver.quit();
    }


    @Test
    public void TC_002() throws InterruptedException {
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

        Thread.sleep(5000);
        Assert.assertTrue(sli.avatarIcon.isDisplayed());

    }

    @Test(dependsOnMethods = "TC_002")

    public void TC_003() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        Thread.sleep(5000);
        sli.createShopButton.click();
        ReusableMethods.yukleneneKadarBekle(scs.createShopText);
        Assert.assertEquals(scs.createShopText.getText(), "Create Shop");
        Thread.sleep(4000);
       ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('style')", scs.logoUpload);
        String homePath=System.getProperty("user.home");
        String filePathCover = "\\IdeaProjects\\Team4Project\\src\\test\\java\\resources\\cover.PNG";
        String filePathLogo = "\\IdeaProjects\\Team4Project\\src\\test\\java\\resources\\logo.PNG";
        String filePathCoverFull=homePath+filePathCover;
        String filePathLogoFull = homePath+filePathLogo;
        // File image=new File(filePath);
        // Assert.assertTrue(image.exists());
        scs.logoButton.sendKeys(filePathLogoFull);
        Assert.assertTrue(scs.logoImgUploadedIcon.isDisplayed());
        Thread.sleep(4000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('style')", scs.coverImgUpload);
        scs.coverImgUpload.sendKeys(filePathCoverFull);
        Assert.assertTrue(scs.coverImgUploadedIcon.isDisplayed());

        scs.nameBox.sendKeys(faker.company().name());
        scs.descriptionTextArea.sendKeys(faker.cat().breed());
        scs.accountHolderNameBox.sendKeys(faker.name().fullName());
        scs.accountHolderEMailBox.sendKeys(faker.internet().emailAddress());
        scs.bankNAmeBox.sendKeys(faker.company().name());
        scs.accountNumberBox.sendKeys(faker.number().digits(10));
        scs.countryBox.sendKeys(faker.country().name());
        scs.cityBox.sendKeys(faker.address().cityName());
        scs.stateBox.sendKeys(faker.address().state());
        scs.zipBox.sendKeys(faker.address().zipCode());
        scs.streetAddressBox.sendKeys(faker.address().streetAddress());
        scs.setMapLocationBox.click();
        scs.setMapLocationBox.sendKeys("a");
        scs.setMapLocationBox.click();
        scs.setMapLocationBox.sendKeys(Keys.DOWN);
        scs.setMapLocationBox.sendKeys(Keys.TAB);
        scs.contactNumberBox.sendKeys(faker.phoneNumber().phoneNumber());
        scs.websiteBox.sendKeys(faker.internet().domainName());
        scs.addNewSocailProfileButton.click();
        scs.selectSocialPlatformSelect.click();
        scs.selectSocialPlatformSelect.sendKeys(Keys.TAB);
        scs.inputLabelUrl.sendKeys(faker.animal().name());
        // scs.saveButton.click();
        Assert.assertTrue(sms.myShopsText.isDisplayed());

    }

    @Test(dependsOnMethods = "TC_002")
    public void TC_004() throws InterruptedException {
        Thread.sleep(5000);
        sli.myShopButton.click();
        Thread.sleep(5000);
        sms.myFirstShop.click();
        Thread.sleep(5000);
        Actions actions=new Actions(driver);
        actions.moveToElement(sfs.productsButton).click(sfs.productsButton).perform();
        spp.addProduct.click();
        Assert.assertTrue(spp.createNewProductText.isDisplayed());
       // String homePath=System.getProperty("user.home");
       // String productImg = "\\IdeaProjects\\Team4Project\\src\\test\\java\\resources\\cover.jpg";
       // String productFeaturedImg = "\\IdeaProjects\\Team4Project\\src\\test\\java\\resources\\logo.jpg";
       // String  productImgFull=homePath+ productImg;
       // String productFeaturedImgFull = homePath+productFeaturedImg;
       // scpp.featuredImagebox.sendKeys(productFeaturedImgFull);
       // Thread.sleep(5000);
       // Assert.assertTrue(scpp.featuredImageIcon.isDisplayed());
       // Thread.sleep(4000);
       // scpp.productImagebox.sendKeys(productImgFull);
       // Assert.assertTrue(scpp.productImageIcon.isDisplayed());
      actions.moveToElement( scpp.groupDropdown)
              .click( scpp.groupDropdown)
                .moveToElement(scpp.groupDropdownSelectBakery)
                    .click(scpp.groupDropdownSelectBakery).perform();

    }
}

