package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class FAQ {


    private WebDriver driver;

    public FAQ(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "svg[width='20']")
    List<WebElement> plusButtons = new ArrayList<>();

    @FindBy(css = "path[d='M20 12H4']")
    List<WebElement> minusButtons = new ArrayList<>();

    @FindBy(xpath = "//h2[@class='text-sm md:text-base font-semibold leading-relaxed text-heading']")
    List<WebElement> questions = new ArrayList<>();

    @FindBy(xpath = "//div[@class='md:pt-1 pb-4 px-5 leading-7 text-sm md:text-base md:leading-loose text-body-dark']")
    List<WebElement> anwsers = new ArrayList<>();

}
