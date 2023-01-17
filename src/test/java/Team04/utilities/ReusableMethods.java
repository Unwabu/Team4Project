package Team04.utilities;

import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;

import java.time.Duration;
import java.util.Date;


public class ReusableMethods {


    public  void assertAssertTrue(String text, WebElement locator) {
        Assert.assertTrue(locator.getText().contains(text));

    }

    public  void getTitle() {
        Driver.getDriver().getTitle();
    }

    public void sendKeysInfo(String key, WebElement locator) {

        locator.sendKeys(key + Keys.ENTER);
    }

    public  void pageControl(String expectedUrl, String actualUrl) {
        Assert.assertEquals(expectedUrl, actualUrl);

    }

    public  Select dropDown(WebElement locator) {
        Select select = new Select(locator);

        return select;
    }

    public  void URLset(String url) {
        Driver.getDriver().get(url);
    }

    public  void moveToElementHover(WebElement login) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(login).perform();

    }

    public  void yukleneneKadarBekle(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(webElement)).click();
    }

    public  void javaScriptExcecuter(WebElement element) {

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click()", element);
    }

    public static String getScreenshot(WebDriver driver, String name) throws IOException {

        // Screenshot dosya ismi icin suanki tarihi String olarak aliyoruz.
        String date = formatCurrentDate(" yyyy.MM.dd_HH.mm.ss"); // asagida olusturdugumuz methodu kullandik.

        // Screenshot alip file objesine atiyoruz.
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Kaydedilecek dosyanin yolunu belirtiyoruz.
        String target = System.getProperty("user.dir") + "\\test-output\\screenshot\\" + name + date + ".png";

        File targetFile = new File(target);
        FileUtils.copyFile(source, targetFile);

        return target;
    }

    public static String formatCurrentDate(String pattern) {

        return new SimpleDateFormat(pattern).format(new Date());
    }

}

