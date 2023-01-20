package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.FAQ;
import pages.HomePage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReports;

public class US_003 extends TestBaseReports {

    HomePage hp = new HomePage();
    FAQ faqPage = new FAQ(Driver.getDriver());


    @BeforeMethod
    public void setup() {
        //1. Kullanıcı siteye gider
        ReusableMethods.URLset("https://shop-pickbazar-rest.vercel.app/");

        //2. Kullanıcı FAQ kısmına tıklar
        hp.faq.click();
    }

    @Test
    public void testCase_01() {
        extentTest = extentReports.createTest("US03_TC01", "kullanici sitede FAQ de istedigi cevaplara erisim saglamalidir");

        //3. Kullanıcı 4 soru olduğunu doğrular
        Assert.assertEquals(faqPage.questions.size(), 4);
        extentTest.info("4 soru olduğu doğrulandı");


        //4. Kullanıcı sorulara tıklayarak her sorunun cevabı olduğunu doğrular
        faqPage.questions.get(0).click();

        int questionNo = 0;
        int anwserNo = 0;
        while (questionNo < 4) {

            switch (anwserNo) {

                case 0:
                    faqPage.questions.get(questionNo).click();
                    Assert.assertTrue(faqPage.firstAnwser.isDisplayed());
                    extentTest.info("İlk cevabın görüntülendiğini doğrulandı");
                    questionNo++;
                    anwserNo++;
                case 1:
                    faqPage.questions.get(questionNo).click();
                    Assert.assertTrue(faqPage.secondAnwser.isDisplayed());
                    extentTest.info("İkinci cevabın görüntülendiğini doğrulandı");
                    questionNo++;
                    anwserNo++;
                case 2:
                    faqPage.questions.get(questionNo).click();
                    Assert.assertTrue(faqPage.thirdAnwser.isDisplayed());
                    extentTest.info("Üçüncü cevabın görüntülendiğini doğrulandı");
                    questionNo++;
                    anwserNo++;
                case 3:
                    faqPage.questions.get(questionNo).click();
                    Assert.assertTrue(faqPage.fourthAnwser.isDisplayed());
                    extentTest.info("Dördüncü cevabın görüntülendiğini doğrulandı");
                    questionNo++;
                    anwserNo++;
            }
        }
        extentTest.pass("Kullanıcı istediği cevaplara erişim sağlayabildi");

    }

    @Test
    public void testCase_02()  {
        extentTest = extentReports.createTest("US03_TC02", "kullanici sitede FAQ de istedigi cevaplara erisim saglamalidir");

        //3. Kullanıcı sorulardaki + işaretine tıkladıktan sonra işaretin -'ye döndüğünü doğrulamalı ve her sorunun cevabı olduğunu görüntülemelidir

        faqPage.questions.get(0).click();

        int plusButtonNo = 0;
        int anwserNo = 0;
        while (plusButtonNo < 4) {

            switch (anwserNo) {

                case 0:
                    Assert.assertEquals(faqPage.plusButtons.size(), 4);
                    extentTest.info("+ işaretlerinin 4 tane olduğu doğrulandı");
                    faqPage.plusButtons.get(plusButtonNo).click();
                    Assert.assertTrue(faqPage.firstAnwser.isDisplayed());
                    extentTest.info("İlk cevabın görüntülendiği doğrulandı");
                    Assert.assertEquals(faqPage.plusButtons.size(), 3);
                    extentTest.info("+ işaretlerinin 3 tane olduğu doğrulandı");
                    Assert.assertFalse(faqPage.minusButtons.isEmpty());
                    extentTest.info("Sayfada - işareti olduğu doğrulandı");
                    plusButtonNo++;
                    anwserNo++;

                case 1:
                    faqPage.plusButtons.get(plusButtonNo-1).click();
                    Assert.assertTrue(faqPage.secondAnwser.isDisplayed());
                    extentTest.info("İkinci cevabın görüntülendiği doğrulandı");
                    Assert.assertEquals(faqPage.plusButtons.size(), 3);
                    extentTest.info("+ işaretlerinin 3 tane olduğu doğrulandı");
                    Assert.assertFalse(faqPage.minusButtons.isEmpty());
                    extentTest.info("Sayfada - işareti olduğu doğrulandı");
                    plusButtonNo++;
                    anwserNo++;

                case 2:
                    faqPage.plusButtons.get(plusButtonNo-1).click();
                    Assert.assertTrue(faqPage.thirdAnwser.isDisplayed());
                    extentTest.info("Üçüncü cevabın görüntülendiği doğrulandı");
                    Assert.assertEquals(faqPage.plusButtons.size(), 3);
                    extentTest.info("+ işaretlerinin 3 tane olduğu doğrulandı");
                    Assert.assertFalse(faqPage.minusButtons.isEmpty());
                    extentTest.info("Sayfada - işareti olduğu doğrulandı");
                    plusButtonNo++;
                    anwserNo++;

                case 3:
                    faqPage.plusButtons.get(plusButtonNo-1).click();
                    Assert.assertTrue(faqPage.fourthAnwser.isDisplayed());
                    extentTest.info("Dördüncü cevabın görüntülendiği doğrulandı");
                    Assert.assertEquals(faqPage.plusButtons.size(), 3);
                    extentTest.info("+ işaretlerinin 3 tane olduğu doğrulandı");
                    Assert.assertFalse(faqPage.minusButtons.isEmpty());
                    extentTest.info("Sayfada - işareti olduğu doğrulandı");
                    plusButtonNo++;
                    anwserNo++;
            }
        }
        extentTest.pass("Kullanıcı istediği cevaplara erişim sağlayabildi");
    }

    @AfterTest
    public void shutDown() {
        //Kullanıcı sayfayı kapatır
        Driver.closeDriver();
    }
}
