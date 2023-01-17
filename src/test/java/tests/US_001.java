package tests;


import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FAQ;
import pages.HomePage;
import utilities.Driver;

import java.time.Duration;

public class US_001 {
    Faker faker=new Faker();
    HomePage hp=new HomePage();


@Test

public void TC_001(){



Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");

//kontrol yorumu

}



}
