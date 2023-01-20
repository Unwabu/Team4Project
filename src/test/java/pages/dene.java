package pages;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.Driver;

public class dene {
    @BeforeMethod
    public void setup(){
     //   driver.get("https://shop-pickbazar-rest.vercel.app/");

    }

    @AfterMethod
    public void shutDown(){
        Driver.closeDriver();
    }
}
