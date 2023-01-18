package tests;


import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.jar.asm.Handle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FAQ;
import pages.HomePage;
import utilities.Driver;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Handler;

public class US_001 {
    Faker faker=new Faker();
    HomePage hp=new HomePage();


@Test

public void TC_001() {


    Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");

//kontrol yorumu


}


}
