package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.FAQ;
import pages.HomePage;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_003 {

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
        //3. Kullanıcı 4 soru olduğunu doğrular
        Assert.assertEquals(faqPage.questions.size(), 4);

        //4. Kullanıcı sorulara tıklayarak her sorunun cevabı olduğunu doğrular
        faqPage.questions.get(0).click();

        int questionNo = 0;
        int anwserNo = 0;
        while (questionNo < 4) {

            switch (anwserNo) {

                case 0:
                    faqPage.questions.get(questionNo).click();
                    Assert.assertTrue(faqPage.firstAnwser.isDisplayed());
                    questionNo++;
                    anwserNo++;
                case 1:
                    faqPage.questions.get(questionNo).click();
                    Assert.assertTrue(faqPage.secondAnwser.isDisplayed());
                    questionNo++;
                    anwserNo++;
                case 2:
                    faqPage.questions.get(questionNo).click();
                    Assert.assertTrue(faqPage.thirdAnwser.isDisplayed());
                    questionNo++;
                    anwserNo++;
                case 3:
                    faqPage.questions.get(questionNo).click();
                    Assert.assertTrue(faqPage.fourthAnwser.isDisplayed());
                    questionNo++;
                    anwserNo++;
            }
        }
    }

    @Test
    public void testCase_02()  {

        //3. Kullanıcı sorulardaki + işaretine tıkladıktan sonra işaretin -'ye döndüğünü doğrulamalı ve her sorunun cevabı olduğunu görüntülemelidir

        faqPage.questions.get(0).click();

        int plusButtonNo = 0;
        int anwserNo = 0;
        while (plusButtonNo < 4) {

            switch (anwserNo) {

                case 0:
                    Assert.assertEquals(faqPage.plusButtons.size(), 4);
                    faqPage.plusButtons.get(plusButtonNo).click();
                    Assert.assertTrue(faqPage.firstAnwser.isDisplayed());
                    Assert.assertEquals(faqPage.plusButtons.size(), 3);
                    Assert.assertFalse(faqPage.minusButtons.isEmpty());
                    plusButtonNo++;
                    anwserNo++;

                case 1:
                    faqPage.plusButtons.get(plusButtonNo-1).click();
                    Assert.assertTrue(faqPage.secondAnwser.isDisplayed());
                    Assert.assertEquals(faqPage.plusButtons.size(), 3);
                    Assert.assertFalse(faqPage.minusButtons.isEmpty());
                    plusButtonNo++;
                    anwserNo++;

                case 2:
                    faqPage.plusButtons.get(plusButtonNo-1).click();
                    Assert.assertTrue(faqPage.thirdAnwser.isDisplayed());
                    Assert.assertEquals(faqPage.plusButtons.size(), 3);
                    Assert.assertFalse(faqPage.minusButtons.isEmpty());
                    plusButtonNo++;
                    anwserNo++;

                case 3:
                    faqPage.plusButtons.get(plusButtonNo-1).click();
                    Assert.assertTrue(faqPage.fourthAnwser.isDisplayed());
                    Assert.assertEquals(faqPage.plusButtons.size(), 3);
                    Assert.assertFalse(faqPage.minusButtons.isEmpty());
                    plusButtonNo++;
                    anwserNo++;
            }
        }
    }

    @AfterSuite
    public void shutDown() {
        Driver.closeDriver();
    }
}
