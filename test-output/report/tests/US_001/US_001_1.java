package tests.US_001;


import com.aventstack.extentreports.reporter.configuration.Theme;
import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReports;

import java.time.Duration;
import java.util.Set;

public class US_001_1 extends TestBaseReports {

    Faker faker = new Faker();
    HomePage hp = new HomePage();
    SellerRegisterPage sp = new SellerRegisterPage();
    //  WebDriver driver = Driver.getDriver();
    SellerLoginPage sl = new SellerLoginPage();
    SellerLoggedInPage sli = new SellerLoggedInPage();
    SellerCreateShopPage scs = new SellerCreateShopPage();
    SellerMyShopsPage sms = new SellerMyShopsPage();
    SellerFirstShopPage sfs = new SellerFirstShopPage();
    SellerProductsPage spp = new SellerProductsPage();
    SellerCreateProductPage scpp = new SellerCreateProductPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    Actions actions = new Actions(Driver.getDriver());
    String firstPageHandle, secondWindowHandle = "";
    String simtenMail = ConfigReader.getProperty("simtenMail");
    String simtenPassword = ConfigReader.getProperty("simtenPassword");


    // @Test(dependsOnMethods = "TC_002")
    @Test
    public void TC_003() {
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        hp.becomeASellerButton.click();
        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();
        String secondWindowHandle = "";
        for (String each : allWindowHandles) {
            if (!each.equals(firstPageHandle)) {
                secondWindowHandle = each;
            }
        }
        Driver.getDriver().switchTo().window(secondWindowHandle);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("register"));
        extentTest.info("register sayfasının görüntülendiği doğrulandı   ");
        sp.loginButton.click();
        ReusableMethods.yukleneneKadarBekle(sl.mailBox);
        wait.until(ExpectedConditions.urlToBe("https://admin-pickbazar-rest.vercel.app/login"));
        sl.mailBox.clear();
        sl.mailBox.sendKeys(simtenMail);
        sl.passwordBox.clear();
        sl.passwordBox.sendKeys(simtenPassword);

        sl.loginButton.click();

        ReusableMethods.yukleneneKadarBekle(sli.avatarIcon);
        Assert.assertTrue(sli.avatarIcon.isDisplayed());
        extentTest.info("satıcı kendi shop ekranını görüntüledi");


        extentTest = extentReports.createTest("TC_003",
                "satici magaza create edebilmeli ve magazalarını goruntuleyebilmeli");
        // WebDriver driver = Driver.getDriver();



        ReusableMethods.yukleneneKadarBekle(sli.createShopButton);
        sli.createShopButton.click();
        ReusableMethods.yukleneneKadarBekle(scs.createShopText);
        Assert.assertEquals(scs.createShopText.getText(), "Create Shop");
        extentTest.info("satıcı shop ekranını görüntüledi");
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].removeAttribute('style')", scs.logoUpload);
        String homePath = System.getProperty("user.home");
        String filePathCover = "/IdeaProjects/Team4Project/src/test/java/resources/cover.jpg";
        String filePathLogo = "/IdeaProjects/Team4Project/src/test/java/resources/logo.jpg";
        String filePathCoverFull = homePath + filePathCover;
        String filePathLogoFull = homePath + filePathLogo;
        // File image=new File(filePath);
        //Assert.assertTrue(image.exists());
        scs.logoButton.sendKeys(filePathLogoFull);
        Assert.assertTrue(scs.logoImgUploadedIcon.isDisplayed());
        extentTest.info("logo yüklendi");
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].removeAttribute('style')", scs.coverImgUpload);
        ReusableMethods.yukleneneKadarBekle(scs.coverImgUpload);
        scs.coverImgUpload.sendKeys(filePathCoverFull);
        Assert.assertTrue(scs.coverImgUploadedIcon.isDisplayed());
        extentTest.info("cover yüklendi");
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
        scs.saveButton.click();
        Assert.assertTrue(sms.myShopsText.isDisplayed());
        extentTest.info("Kayıt sonrası oluşturulan shop görüntülendi");
        extentTest.pass("satici magaza create edebildi ve magazalarını goruntuledi");

    }

    //  @Test(dependsOnMethods = "TC_002")
    @Test
    public void TC_004() {

        extentTest = extentReports.createTest("TC_004",
                "Satıcı mağazasına ürün ekleyebilmeli ve eklediği ürünü görebilmelidir");

        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");


        hp.becomeASellerButton.click();

        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();

        String secondWindowHandle = "";

        for (String each : allWindowHandles) {
            if (!each.equals(firstPageHandle)) {
                secondWindowHandle = each;
            }
        }
        Driver.getDriver().switchTo().window(secondWindowHandle);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("register"));
        extentTest.info("-register sayfasının görüntülendiği doğrulandı   ");
        sp.loginButton.click();
        wait.until(ExpectedConditions.urlToBe("https://admin-pickbazar-rest.vercel.app/register"));


        wait.until(ExpectedConditions.urlToBe("https://admin-pickbazar-rest.vercel.app/login"));

        sl.mailBox.clear();
        sl.mailBox.sendKeys(simtenMail);
        sl.passwordBox.clear();
        sl.passwordBox.sendKeys(simtenPassword);

        sl.loginButton.click();

        ReusableMethods.yukleneneKadarBekle(sli.myShopButton);
        sli.myShopButton.click();
        wait.until(ExpectedConditions.urlToBe("https://admin-pickbazar-rest.vercel.app/my-shops"));
        ReusableMethods.yukleneneKadarBekle(sms.myFirstShop);
        // actions.click(sms.myFirstShop).perform();
        sms.myFirstShop.click();
        wait.until(ExpectedConditions.urlToBe("https://admin-pickbazar-rest.vercel.app/simsim"));

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(sfs.productsButton).click(sfs.productsButton).perform();
        spp.addProduct.click();
        Assert.assertTrue(spp.createNewProductText.isDisplayed());
        extentTest.info("product ekleme sayfasını görüntüledi");
        String homePath = System.getProperty("user.home");
        String productImg = "/IdeaProjects/Team4Project/src/test/java/resources/cover.jpg";
        String productFeaturedImg = "/IdeaProjects/Team4Project/src/test/java/resources/logo.jpg";
        String productImgFull = homePath + productImg;
        String productFeaturedImgFull = homePath + productFeaturedImg;
        scpp.featuredImagebox.sendKeys(productFeaturedImgFull);
        ReusableMethods.yukleneneKadarBekle(scpp.featuredImageIcon);
        Assert.assertTrue(scpp.featuredImageIcon.isDisplayed());
        extentTest.info("featured img upload edildi");
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].removeAttribute('style')", scpp.productImagebox);
        //ReusableMethods.yukleneneKadarBekle(scpp.productImageHiddenbox);
        scpp.productImageHiddenbox.sendKeys(productImgFull);
        Assert.assertTrue(scpp.productImageIcon.isDisplayed());
        extentTest.info("product img upload edildi");
        actions.click(scpp.groupDropdownStart)
                .sendKeys(Keys.DOWN)
                .sendKeys(Keys.DOWN)
                .sendKeys(Keys.DOWN)
                .sendKeys(Keys.DOWN)
                .sendKeys(Keys.DOWN)
                .sendKeys(Keys.DOWN)
                .sendKeys(Keys.ENTER)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.DOWN)
                .sendKeys(Keys.DOWN)
                .sendKeys(Keys.ENTER)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.DOWN)
                .sendKeys(Keys.DOWN)
                .sendKeys(Keys.ENTER)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.DOWN)
                .sendKeys(Keys.DOWN)
                .sendKeys(Keys.ENTER)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).perform();
        scpp.nameBox.sendKeys("urunum");
        actions.click(scpp.unitBox)
                .sendKeys(" my product ")
                .sendKeys(Keys.TAB)
                .sendKeys(faker.expression("My Description "))
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.DOWN)
                .sendKeys(Keys.ENTER)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.number().digits(3))
                .sendKeys(Keys.TAB)
                .sendKeys(faker.number().digits(2))
                .sendKeys(Keys.TAB)
                .sendKeys(faker.number().digits(2))
                .sendKeys(Keys.TAB)
                .sendKeys(faker.number().digits(2))
                .sendKeys(Keys.TAB)
                .sendKeys(faker.number().digits(2))
                .sendKeys(Keys.TAB)
                .sendKeys(faker.number().digits(2))
                .perform();
        scpp.height.sendKeys(faker.number().digit());
        scpp.lenght.sendKeys(faker.number().digit());
        ReusableMethods.yukleneneKadarBekle(scpp.checkBox);
        actions.click(scpp.checkBox);
        scpp.productUrl.sendKeys(faker.internet().domainName());
        ReusableMethods.yukleneneKadarBekle(scpp.productButtonText);
        scpp.productButtonText.sendKeys(faker.animal().name());
        scpp.addButton.click();
        wait.until(ExpectedConditions.urlToBe("https://admin-pickbazar-rest.vercel.app/simsim/products"));
        Assert.assertTrue(spp.urunAdi.getText().contains("urunum"));
        extentTest.info("ürünün eklendiği görüntülendi");
        extentTest.pass("Satıcı mağazasına ürün ekleyebildi ");

    }

    //   @Test(dependsOnMethods = "TC_002")
    @Test
    public void TC_005() {


        extentTest = extentReports.createTest("TC_005",
                "satici product(urun) arayabilmeli, arama yaparkende filtre kullanabilmelidir");

        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");


        hp.becomeASellerButton.click();

        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();

        String secondWindowHandle = "";

        for (String each : allWindowHandles) {
            if (!each.equals(firstPageHandle)) {
                secondWindowHandle = each;
            }
        }
        Driver.getDriver().switchTo().window(secondWindowHandle);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("register"));
        // extentTest.info("-register sayfasının görüntülendiği doğrulandı   ");
        sp.loginButton.click();
        wait.until(ExpectedConditions.urlToBe("https://admin-pickbazar-rest.vercel.app/register"));


        wait.until(ExpectedConditions.urlToBe("https://admin-pickbazar-rest.vercel.app/login"));

        sl.mailBox.clear();
        sl.mailBox.sendKeys(simtenMail);
        sl.passwordBox.clear();
        sl.passwordBox.sendKeys(simtenPassword);

        sl.loginButton.click();
        wait.until(ExpectedConditions.urlToBe("https://admin-pickbazar-rest.vercel.app/"));
        wait.until(ExpectedConditions.visibilityOfAllElements(sli.forWait, sli.productsButton));
        actions.moveToElement(sli.productsButton).click(sli.productsButton).perform();
        ReusableMethods.yukleneneKadarBekle(spp.searchBox);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("products"));
        extentTest.info("product sayfası görüntülendi");

        spp.searchBox.sendKeys("urunum my product");
        spp.searchSymbol.click();
        Assert.assertTrue(spp.searchBoxResultText.isDisplayed());
        extentTest.info("arama sonuçlarında ürün olduğu doğrulandı");
        spp.filterButton.click();
        ReusableMethods.yukleneneKadarBekle(spp.filterByGroupButton);

      //  spp.filterByGroupButton.click();

        actions.moveToElement(spp.filterByGroupButton).click().sendKeys(Keys.DOWN)
                .sendKeys(Keys.DOWN)
                .sendKeys(Keys.DOWN)
                .sendKeys(Keys.DOWN)
                .sendKeys(Keys.DOWN)
                .sendKeys(Keys.DOWN)
                .sendKeys(Keys.ENTER).perform();


        //spp.filterByCatButton.click();
        actions.moveToElement(spp.filterByCatButton).click(spp.filterByCatButton).sendKeys(Keys.DOWN)
                .sendKeys(Keys.DOWN)
                .sendKeys(Keys.ENTER).perform();

        Assert.assertTrue(spp.searchBoxResultText.isDisplayed());
        extentTest.info("filtre sonucunda aranan ürün görüntülendi");
        extentTest.pass("satici product(urun) arama işlemini gerçekleştirdi.filtre özelliğini kullanabildi");

    }


    ////  @Test(dependsOnMethods = "TC_002")
    //  @Test
    //  public void TC_006(){
    //    //  extentTest = extentReports.createTest("TC_006",
    //         //     "satici product(urun)bilgisini duzenleyebilmeli ve silebilmelidir");
    //      wait.until(ExpectedConditions.visibilityOfAllElements(sli.forWait,sli.productsButton) );
    //      actions.moveToElement(sli.productsButton).click(sli.productsButton).perform();
    //      spp.searchBox.sendKeys("urunum my product");
    //      spp.searchSymbol.click();
    //   //   extentTest.info("filtre sonucunda aranan ürün görüntülendi");
    //      spp.editButton.click();
    //      actions.click(scpp.quantity).sendKeys(Keys.UP).perform();
    //      scpp.updateButton.click();
    //      actions.moveToElement(sli.productsButton).click(sli.productsButton).perform();


    //     // extentTest.pass("satici product(urun)bilgisini duzenleyebildi ve silebildi");

    //  }


}

