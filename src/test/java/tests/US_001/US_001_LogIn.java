package tests.US_001;


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

public class US_001_LogIn extends TestBaseReports {

    Faker faker = new Faker();
    HomePage hp = new HomePage();
    SellerRegisterPage srp = new SellerRegisterPage();
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

    SellerPageFinal sp = new SellerPageFinal();

    // @Test(dependsOnMethods = "TC_002")
    @Test
    public void TC_003() {
        extentTest = extentReports.createTest("TC_003",
                "satici magaza create edebilmeli ve magazalarını goruntuleyebilmeli");

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
        srp.loginButton.click();
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

        scs.coverImgUpload.sendKeys(filePathCoverFull);
       // ReusableMethods.yukleneneKadarBekle(scs.coverImgUploadedIcon);
       // Assert.assertTrue(scs.coverImgUploadedIcon.isDisplayed());
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
        srp.loginButton.click();
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
        srp.loginButton.click();
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

    @Test
    public void task6() throws InterruptedException {
        extentTest = extentReports.createTest("TC_006");
        sp.goURL();
        sp.Login();
        sp.show_shops.click();
        sp.WaitUntil(sp.dashboard);
        sp.dashboard.click();
        sp.WaitUntil(sp.products);
        sp.groups.click();
        sp.groups_add_group.click();

        String homePath = System.getProperty("user.home");
        String productImg = "/IdeaProjects/Team4Project/src/test/java/resources/cover.jpg";
        String productFeaturedImg = "/IdeaProjects/Team4Project/src/test/java/resources/logo.jpg";
        String productImgFull = homePath + productImg;
        String productFeaturedImgFull = homePath + productFeaturedImg;
        actions.moveToElement(sp.groups_addBanner).click().perform();
        sp.groups_SelectLoyout.forEach(s -> actions.moveToElement(s).click().perform());
        sp.groups_SelectCard.forEach(s -> actions.moveToElement(s).click().perform());
        sp.groups_img.sendKeys(productFeaturedImgFull);
        sp.groups_information.forEach(s -> actions
                .moveToElement(s)
                .click()
                .keyDown(Keys.CLEAR)
                .keyUp(Keys.CLEAR)
                .sendKeys("12")
                .perform());
        sp.groups_addGroup_last.click();


        Assert.assertTrue(sp.groups_success.isDisplayed());


        sp.groups_edit.click();

        sp.groups_SelectLoyout.forEach(s -> actions.moveToElement(s).click().perform());
        sp.groups_SelectCard.forEach(s -> actions.moveToElement(s).click().perform());
        sp.groups_img.sendKeys(productImgFull);
        sp.groups_information.forEach(s -> actions
                .moveToElement(s)
                .click()
                .keyDown(Keys.CLEAR)
                .keyUp(Keys.CLEAR)
                .sendKeys("12")
                .perform());

        actions.moveToElement(sp.groups_update).click().perform();


        Assert.assertTrue(sp.groups_updated.isDisplayed());

        Driver.getDriver().navigate().back();
        sp.groups_cop.click();
        sp.WaitUntil(sp.groups_delete);
        sp.groups_delete.click();

        Assert.assertFalse(sp.groups_delete.isDisplayed());

        Driver.closeDriver();
        extentTest.pass("TC_006 passed");
    }

    @Test
    public void task7() throws InterruptedException {
        extentTest = extentReports.createTest("TC_007");
        sp.goURL();
        sp.Login();
        sp.categories.click();
        sp.ctg_addCategories.click();


        String homePath = System.getProperty("user.home");
        String productImg = "/IdeaProjects/Team4Project/src/test/java/resources/cover.jpg";
        String productFeaturedImg = "/IdeaProjects/Team4Project/src/test/java/resources/logo.jpg";
        String productImgFull = homePath + productImg;
        String productFeaturedImgFull = homePath + productFeaturedImg;
        sp.ctg_img.sendKeys(productImgFull);
        sp.ctg_information.forEach(s -> actions
                .moveToElement(s)
                .click()
                .keyDown(Keys.CLEAR)
                .keyUp(Keys.CLEAR)
                .sendKeys("12")
                .perform());
        sp.ctg_selectyout.forEach(s -> actions
                .moveToElement(s)
                .click()
                .keyDown(Keys.ARROW_DOWN)
                .keyUp(Keys.ARROW_DOWN)
                .keyDown(Keys.ENTER)
                .keyUp(Keys.ENTER)
                .perform());


        Assert.assertTrue(sp.ctg_success.isDisplayed());


        actions.moveToElement(sp.ctg_edit).click().perform();

        sp.ctg_img.sendKeys(productFeaturedImgFull);
        sp.ctg_information.forEach(s -> actions
                .moveToElement(s)
                .click()
                .keyDown(Keys.CLEAR)
                .keyUp(Keys.CLEAR)
                .sendKeys("12")
                .perform());
        sp.ctg_selectyout.forEach(s -> actions
                .moveToElement(s)
                .click()
                .keyDown(Keys.ARROW_DOWN)
                .keyUp(Keys.ARROW_DOWN)
                .keyDown(Keys.ENTER)
                .keyUp(Keys.ENTER)
                .perform());
        actions.moveToElement(sp.ctg_update).click().perform();


        Assert.assertTrue(sp.ctg_updated.isDisplayed());

        Driver.getDriver().navigate().back();
        Thread.sleep(3000);
        sp.ctg_cop.click();
        sp.groups_delete.click();
        Assert.assertTrue(sp.ctg_deleted.isDisplayed());
        Driver.closeDriver();
        extentTest.pass("TC_007 passed");
    }

    @Test
    public void task8() throws InterruptedException {
        extentTest = extentReports.createTest("TC_008");
        sp.goURL();
        sp.Login();
        sp.tag.click();

        actions.moveToElement(sp.tag_addCategories).click().perform();


        String homePath = System.getProperty("user.home");
        String productImg = "/IdeaProjects/Team4Project/src/test/java/resources/cover.jpg";
        String productFeaturedImg = "/IdeaProjects/Team4Project/src/test/java/resources/logo.jpg";
        String productImgFull = homePath + productImg;
        String productFeaturedImgFull = homePath + productFeaturedImg;
        sp.tag_img.sendKeys(productImgFull);
        sp.tag_information.forEach(s -> actions
                .moveToElement(s)
                .click()
                .keyDown(Keys.CLEAR)
                .keyUp(Keys.CLEAR)
                .sendKeys("12")
                .perform());
        sp.tag_select.forEach(s -> actions
                .moveToElement(s)
                .click()
                .keyDown(Keys.ARROW_DOWN)
                .keyUp(Keys.ARROW_DOWN)
                .keyDown(Keys.ENTER)
                .keyUp(Keys.ENTER)
                .pause(Duration.ofSeconds(2))
                .perform());
        actions.moveToElement(sp.tag_addTag).click().perform();

        Assert.assertTrue(sp.tag_success.isDisplayed());

        actions.moveToElement(sp.tag_edit).click().perform();

        sp.tag_img.sendKeys(productFeaturedImgFull);
        sp.tag_information.forEach(s -> actions
                .moveToElement(s)
                .click()
                .keyDown(Keys.CLEAR)
                .keyUp(Keys.CLEAR)
                .sendKeys("12")
                .perform());
        sp.tag_select.forEach(s -> actions
                .moveToElement(s)
                .click()
                .keyDown(Keys.ARROW_DOWN)
                .keyUp(Keys.ARROW_DOWN)
                .keyDown(Keys.ENTER)
                .keyUp(Keys.ENTER)
                .perform());
        actions.moveToElement(sp.tag_updateTag).click().perform();

        Assert.assertTrue(sp.tag_updated.isDisplayed());

        Driver.getDriver().navigate().back();
        actions.moveToElement(sp.tag_cop).click().perform();
        actions.moveToElement(sp.tag_delete).click().perform();

        Assert.assertFalse(sp.tag_deleted.isDisplayed());
        extentTest.pass("TC_008 passed");

    }


    @Test
    public void task9() throws InterruptedException {
        extentTest = extentReports.createTest("TC_009");
        sp.goURL();
        sp.Login();
        actions.moveToElement(sp.man_au).click().perform();
        actions.moveToElement(sp.m_add_mp).click().perform();
        actions.moveToElement(sp.m_social_add).click().perform();
        String homePath = System.getProperty("user.home");
        String productImg = "/IdeaProjects/Team4Project/src/test/java/resources/cover.jpg";
        String productFeaturedImg = "/IdeaProjects/Team4Project/src/test/java/resources/logo.jpg";
        String productImgFull = homePath + productImg;
        String productFeaturedImgFull = homePath + productFeaturedImg;
        sp.m_img.forEach(s -> s.sendKeys(productFeaturedImgFull));
        sp.m_information.forEach(s -> actions
                .moveToElement(s)
                .click()
                .keyDown(Keys.CLEAR)
                .keyUp(Keys.CLEAR)
                .sendKeys("12")
                .perform());

        sp.m_select_group.forEach(s -> actions
                .moveToElement(s)
                .click()
                .click()
                .pause(Duration.ofSeconds(2))
                .keyDown(Keys.ARROW_DOWN)
                .keyUp(Keys.ARROW_DOWN)
                .keyDown(Keys.ENTER)
                .keyUp(Keys.ENTER)
                .perform());
        actions.moveToElement(sp.m_add_mp_last).click().perform();
        Assert.assertTrue(sp.m_success.isDisplayed());
        actions.moveToElement(sp.m_edit).click().perform();
        sp.m_img.forEach(s -> s.sendKeys(productImgFull));
        sp.m_information.forEach(s -> actions
                .moveToElement(s)
                .click()
                .keyDown(Keys.CLEAR)
                .keyUp(Keys.CLEAR)
                .sendKeys("12")
                .perform());

        sp.m_select_group.forEach(s -> actions
                .moveToElement(s)
                .click()
                .pause(Duration.ofSeconds(2))
                .keyDown(Keys.ARROW_DOWN)
                .keyUp(Keys.ARROW_DOWN)
                .keyDown(Keys.ENTER)
                .keyUp(Keys.ENTER)
                .perform());
        actions.moveToElement(sp.m_add_mp_update).pause(Duration.ofSeconds(3)).click().perform();

        Assert.assertTrue(sp.m_updated.isDisplayed());

        Driver.getDriver().navigate().back();
        actions.moveToElement(sp.m_cop).click().perform();
        actions.moveToElement(sp.m_delete).click().perform();


        Assert.assertTrue(sp.m_updated.isDisplayed());

        actions.moveToElement(sp.m_aproval_btn).click().perform();

        Assert.assertTrue(sp.m_aproval_chck.isDisplayed());
        extentTest.pass("TC_009 passed");
    }

    @Test

    public void task12() throws InterruptedException {
        extentTest = extentReports.createTest("TC_012");
        sp.goURL();
        sp.Login();


        actions.moveToElement(sp.create_order).click().perform();

        sp.WaitUntil(sp.c_filter);
        String a = sp.c_head.getText();
        actions.moveToElement(sp.c_order_search)
                .click()
                .sendKeys(a)
                .perform();
        Assert.assertTrue(sp.c_head.getText().contains(a));


        sp.c_filter.click();
        Thread.sleep(5000);
        sp.scfrom();

        Thread.sleep(5000);

        actions.moveToElement(sp.c_order_add).click().perform();

        actions.moveToElement(sp.c_order_sepet).click().pause(Duration.ofSeconds(1)).perform();
        actions.moveToElement(sp.c_order_checkout).pause(Duration.ofSeconds(1)).click().perform();
        sp.WaitUntil(sp.c_add3);
        sp.c_add3.click();
        actions.moveToElement(sp.c_add3).click().perform();
        actions.moveToElement(sp.c_select).click().keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        actions.moveToElement(sp.c_input).click().sendKeys("12345678").perform();
        actions.moveToElement(sp.c_save).click().perform();

        extentTest.pass("TC_012 passed");
    }



    @Test
    public void task13() throws InterruptedException {
        extentTest = extentReports.createTest("TC_013");
        sp.goURL();

        sp.Login();

        actions.moveToElement(sp.user).click().perform();

        actions.moveToElement(sp.costumer_add_costumer).click().perform();

        sp.costumer_information.forEach(s -> actions
                .moveToElement(s)
                .click()
                .keyDown(Keys.CLEAR)
                .keyUp(Keys.CLEAR)
                .sendKeys("123")
                .perform());
        sp.WaitUntil(sp.costumer_email);
        actions.moveToElement(sp.costumer_email).click()
                .keyDown(Keys.CLEAR)
                .keyUp(Keys.CLEAR)
                .sendKeys(faker.name().firstName() + "@gmail.com").pause(Duration.ofSeconds(2)).perform();
        sp.costumer_last.click();
        Driver.getDriver().navigate().back();
        Thread.sleep(3000);
        Assert.assertTrue(sp.costumer_name.getText().contains("123"));
        extentTest.pass("TC_013 passed");
    }

    @Test
    public void task15() throws InterruptedException {
        extentTest = extentReports.createTest("TC_015");
        sp.goURL();
        sp.Login();
        sp.coupons.click();

        sp.coupons_add_coupon.click();

        String homePath = System.getProperty("user.home");
        String productImg = "/IdeaProjects/Team4Project/src/test/java/resources/cover.jpg";
        String productFeaturedImg = "/IdeaProjects/Team4Project/src/test/java/resources/logo.jpg";
        String productImgFull = homePath + productImg;
        String productFeaturedImgFull = homePath + productFeaturedImg;
        sp.coupons_img.sendKeys(productImgFull);
        sp.coupons_information.forEach(s -> actions.moveToElement(s).click().sendKeys("123").perform());
        actions.moveToElement(sp.coupons_add_coupon_last).click().perform();

        Assert.assertTrue(sp.coupons_success.isDisplayed());

        actions.moveToElement(sp.coupons_search).click().sendKeys("123").perform();
        Assert.assertTrue(sp.coupons_name.getText().contains("123"));

        Driver.getDriver().navigate().back();
        sp.coupons_edit.click();

        sp.coupons_img.sendKeys(productFeaturedImgFull);
        sp.coupons_information.forEach(s -> actions.moveToElement(s).click().sendKeys("123").perform());
        actions.moveToElement(sp.coupons_update_c).perform();

        Assert.assertTrue(sp.tax_update.isDisplayed());

        Driver.getDriver().navigate().back();
        sp.coupons_cop.click();

        sp.coupons_cancel.click();
        Assert.assertFalse(sp.coupons_d_m.isDisplayed());
        sp.coupons_delete.click();
        Assert.assertTrue(sp.coupons_d_m.isDisplayed());
        extentTest.pass("TC_015 passed");

    }



    @Test
    public void task16() throws InterruptedException {
        extentTest = extentReports.createTest("TC_016");
        sp.goURL();
        sp.Login();
        sp.taxes.click();
        sp.coupons_add_tax.click();

        sp.tax_information.forEach(s -> actions.moveToElement(s).click().sendKeys("123").perform());
        actions.moveToElement(sp.tax_add_coupon_last).click().perform();

        Assert.assertTrue(sp.coupons_success.isDisplayed());

        actions.moveToElement(sp.coupons_search).click().sendKeys("123").perform();
        Assert.assertTrue(sp.coupons_name.getText().contains("123"));

        sp.coupons_edit.click();

        sp.tax_information.forEach(s -> actions.moveToElement(s).click().sendKeys("123").perform());
        sp.WaitUntil(sp.tax_update_c);
        sp.tax_update_c.click();

        Thread.sleep(3000);
        Assert.assertTrue(sp.tax_update.isDisplayed());

        Driver.getDriver().navigate().back();
        sp.coupons_cop.click();

        sp.coupons_cancel.click();
        Thread.sleep(3000);
        sp.coupons_cop.click();

        sp.coupons_delete.click();
        Thread.sleep(3000);
        Assert.assertTrue(sp.coupons_d_m.isDisplayed());
        extentTest.pass("TC_016 passed");

    }
    @Test
    public void task17() throws InterruptedException {
        extentTest = extentReports.createTest("TC_017");
        sp.goURL();
        sp.Login();
        sp.shipping.click();
        sp.shp_add.click();
        sp.shp_information.forEach(s -> actions.moveToElement(s).click().sendKeys("123").perform());
        sp.shp_type.forEach(s -> actions
                .moveToElement(s)
                .click()
                .perform());
        sp.shp_add2.click();
        Assert.assertTrue(sp.coupons_success.isDisplayed());
        sp.products_search.sendKeys("123" + Keys.ENTER);
        Assert.assertTrue(sp.shp_check.getText().contains("123"));
        extentTest.pass("TC_017 passed");



    }

    @Test

    public void task18() throws InterruptedException {
        extentTest = extentReports.createTest("TC_018");
        sp.goURL();
        sp.Login();
        sp.questions.click();
        sp.WaitUntil(sp.question_show);
        Assert.assertTrue(sp.question_show.isDisplayed());
        sp.question_edit.click();
        sp.box.sendKeys("123");
        sp.costumer_reply.click();
        Assert.assertTrue(sp.product_success.isDisplayed());

        sp.question_cop.click();
        sp.question_cancel.click();

        //10-Kullanıcı işlemi onaylar ve yorumun silindiğini onaylar.
        Thread.sleep(5000);
        sp.question_cop.click();
        sp.question_delete.click();
        sp.WaitUntil(sp.deleted_1);
        Assert.assertTrue(sp.deleted_1.isDisplayed());
        extentTest.pass("TC_018 passed");


    }















}

