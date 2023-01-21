package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class ShopsPage {

    public ShopsPage() {
    PageFactory.initElements(Driver.getDriver(),this);

}


    @FindBy(xpath="//span[.='plus']")
    private WebElement plusBtn;

    @FindBy(xpath="(//span[.='Add'])[1]")
    private WebElement addBtn;

    @FindBy(xpath="(//button[@class='cursor-pointer p-2 transition-colors duration-200 hover:bg-accent-hover focus:outline-none'])[1]")
    public WebElement minusBtn;

    @FindBy(xpath="//span[@class='bg-light rounded w-full py-2 px-2 text-accent mt-3']")
    public WebElement sepetBtn;

    @FindBy(xpath="(//button[@class='cursor-pointer p-2 transition-colors duration-200 hover:bg-accent-hover focus:outline-none hover:!bg-gray-100'])[2]")
    public WebElement sepetPls;

    @FindBy(xpath ="(//button[@class='cursor-pointer p-2 transition-colors duration-200 hover:bg-accent-hover focus:outline-none hover:!bg-gray-100'])[1]")
    public WebElement sepetMinus;

    @FindBy(xpath="//del[@class='text-xs text-muted ltr:ml-2 rtl:mr-2 md:text-sm']")
    private List<WebElement> ilkFiyat;

    @FindBy(xpath="//span[@class='text-sm font-semibold text-heading md:text-base']")
    private List<WebElement> indirimFiat;

    @FindBy(xpath="//div[@class='absolute top-3 rounded bg-accent px-1.5 text-xs font-semibold leading-6 text-light ltr:right-3 rtl:left-3 sm:px-2 md:top-4 md:px-2.5 ltr:md:right-4 rtl:md:left-4']")
    private List<WebElement> indirimOrani;

    @FindBy(xpath="//div[@class='flex flex-1 items-center justify-center px-3 text-sm font-semibold']")
    private WebElement urunarti2;

    @FindBy(xpath="//div[@class='flex flex-1 items-center justify-center px-3 text-sm font-semibold !px-0 text-heading']")
    private WebElement sptartibir;




    public List<WebElement> ilkFiyat(){
     List<WebElement> ilkFiyatlar= ilkFiyat;

     return ilkFiyat;
    }
    public List<WebElement> IndirimliFiyat(){
        List<WebElement> indirimliFiyatlar= indirimFiat;

      return indirimFiat;
    }
    public List<WebElement> IndirimOrani() {
        List<WebElement> indirimOranlari=indirimOrani;

        return indirimOrani;

    }

    public WebElement addBtnClick(){
        addBtn.click();
        addBtn.click();

        return addBtn;
    }

    public boolean urunartiGostergesi(){
        Assert.assertTrue(urunarti2.isDisplayed(), "Urun arttırıldığında miktar artıyor");
   return true;
}
   public boolean UrunazaltmaGostergesi() {
       Assert.assertTrue(urunarti2.isDisplayed(), "Urun azaltıldığında miktar azalıyor");

       return true;
   }

}





