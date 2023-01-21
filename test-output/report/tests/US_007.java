package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HuseyinPage;
import pages.SarpPage;
import utilities.Driver;

public class US_007 {

 SarpPage sp = new SarpPage();

    @Test
    public void testCase01 () {
     // Profilde gerekli bilgiler girilerek updateler yapilinca "Profile Updated Successfully" mesaji gorulmelidir.

    Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
    sp.joinButton.click();
    sp.loginButton.click();

        String expectedMessage = "Profile Updated Successfully";
       // String actualMessage =

    }

    @Test
    public void testCase02 () throws InterruptedException {
     // Change Password bolumunde sifre degistirince  "Password changed succesfully" mesaji gorulmelidir

     taslak();
     sp.profilButton.click();
     sp.changePasswordButton.click();
     sp.ilkKutu.sendKeys("demodemo");
     sp.ikinciKutu.sendKeys("DEMODEMO");
     sp.ucuncuKutu.sendKeys("DEMODEMO");
     sp.submitButton.click();
     Thread.sleep(2000);
     Driver.getDriver().switchTo().alert().accept();
     Driver.getDriver().close();

    }

    @Test
    public void testCase03 () throws InterruptedException {
     // MyOrders bolumunde istenilen siparisdeki  Order Received butonu ile Order Details gorulmelidir

     taslak();
     sp.myOrderButton.click();
     sp.detailsButton.click();
     Thread.sleep(2000);
     Driver.getDriver().close();
    }

    @Test
    public void testCase04 () throws InterruptedException {
    // WishListden urun kaldirinca "Successfully Removed from Wishlist!" mesaji gorulmelidir

    taslak();
    sp.wishlistButton.click();
    Thread.sleep(1000);
    sp.removedButton.click();


  //  WebElement actualMessage = Driver.getDriver().findElement(By.xpath("(//div[.=\"Successfully Removed from Wishlist!\"])[5]"));
  //  String expectedMessage = "Successfully Removed from Wishlist!";
  //  if (expectedMessage.equals(actualMessage)) {
  //   System.out.println("WishListden urun kaldirinca \"Successfully Removed from Wishlist!\" mesaji GÖRÜLMEKTEDİR");
  //  } else System.out.println("WishListden urun kaldirinca \"Successfully Removed from Wishlist!\" mesaji görülmemektedir.");

    }

    @Test
    public void testCase05 () throws InterruptedException {
    // Logout dan cikis yapabilmelidir

    taslak();
    sp.logoutButton.click();
    Driver.getDriver().close();
    }

 public void taslak () throws InterruptedException {
  Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
  Driver.getDriver().findElement(By.xpath("(//button[@data-variant=\"normal\"])[1]")).click();
  Driver.getDriver().findElement(By.xpath("(//button[@data-variant=\"normal\"])[3]")).click();
  Driver.getDriver().findElement(By.xpath("//img[@alt=\"user name\"]")).click();
   }

}
