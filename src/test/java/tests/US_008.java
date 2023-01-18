package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_008 {

    HomePage hp = new HomePage();

    @BeforeTest
    public void setup() {
        //1. Kullanıcı siteye gider
        ReusableMethods.URLset("https://shop-pickbazar-rest.vercel.app/");

        //2. Kullanıcı ürün kategorilerinin seçildiği alana tıklamalıdır
        hp.categoryDropDownButton.click();
    }

    @Test
    public void testCase_01(){

    }
    @Test
    public void testCase_02(){

    }
    @Test
    public void testCase_03(){

    }
    @Test
    public void testCase_04(){

    }
    @Test
    public void testCase_05(){

    }
    @Test
    public void testCase_06(){

    }
    @Test
    public void testCase_07(){

    }


    @AfterTest
   public void shutDown(){
        Driver.closeDriver();
    }


}