package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReports;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
public class SellerPageFinal extends TestBaseReports {
    Actions actions = new Actions(Driver.getDriver());

    public SellerPageFinal() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void goURL() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        ReusableMethods.linkKontrolEt("pickbazar");
    }

    public void Login() throws InterruptedException {
        Become_Seller.click();
        Driver.getDriver().switchTo().window((String) Driver.getDriver().getWindowHandles().toArray()[1]);
        Login_Seller.click();
        Thread.sleep(1000);
        WaitUntil(seller_email);
        seller_email.click();
        seller_email.clear();
        seller_email.sendKeys("admin@demo.com");
        WaitUntil(seller_password);
        seller_password.click();
        seller_password.clear();
        Thread.sleep(1000);
        ReusableMethods.dataSend(seller_password, "demodemo" + Keys.ENTER);
    }

    public void Login2() throws InterruptedException {
        join.click();
        //Driver.getDriver().switchTo().window((String) Driver.getDriver().getWindowHandles().toArray()[1]);
        WaitUntil(loginButton2);
        loginButton2.click();
    }

    @FindBy(xpath = "//button[.='Join']")
    public WebElement join;

    @FindBy(xpath = "//button[.='Login']")
    public WebElement loginButton2;

    @FindBy(xpath = "//a[.='Offers']")
    public WebElement offer_buton;

    @FindBy(xpath = "//div[@class='coupon-card'][1]")
    public WebElement coupon_card_1;

    @FindBy(xpath = "(//div[@class='coupon-card'][1])//div[2]//button")
    public WebElement coupon_card_1_copy;

    @FindBy(xpath = "(//div[@class='coupon-card'][1])//div[2]//span")
    public WebElement coupon_card_use;

    @FindBy(xpath = "(//div[@class='coupon-card'][1])//div[2]//div")
    public WebElement coupon_card_1_copied;

    @FindBy(xpath = "(//span[.='Add'])[5]//ancestor::button")
    public WebElement urun_add;

    @FindBy(xpath = "//span[contains(text(),'Check')]")
    public WebElement checkout;

    @FindBy(xpath = "//button[contains(text(),'Check')]")
    public WebElement checkout_avaible;

    @FindBy(xpath = "//p[@role='button']")
    public WebElement do_you_have_coupon;

    @FindBy(xpath = "//span[contains(text(),'Item')]")
    public WebElement sepet;

    @FindBy(xpath = "//span[contains(text(),'Cas')]")
    public WebElement cod;

    @FindBy(id = "code")
    public WebElement code;

    @FindBy(xpath = "//button[contains(text(),'Apply')]")
    public WebElement apply;

    @FindBy(xpath = "(//p[contains(text(),'Dis')]//following::span)[2]")
    public WebElement esc;

    @FindBy(xpath = "(//p[contains(text(),'Dis')]//following::span)[3]")
    public WebElement is_visible;


    public List coupon_kayit() {
        List<String> card = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
           card = new ArrayList<String>();
           card.add(((Driver.getDriver().findElement(By.xpath("(//div[@class='coupon-card'][1])//div[2]//span"))).getText().toString()));
           card.add(((Driver.getDriver().findElement(By.xpath("(//div[@class='coupon-card'][2])//div[2]//span"))).getText().toString()));
           card.add(((Driver.getDriver().findElement(By.xpath("(//div[@class='coupon-card'][3])//div[2]//span"))).getText().toString()));
           card.add(((Driver.getDriver().findElement(By.xpath("(//div[@class='coupon-card'][4])//div[2]//span"))).getText().toString()));
           card.add(((Driver.getDriver().findElement(By.xpath("(//div[@class='coupon-card'][5])//div[2]//span"))).getText().toString()));
           card.add(((Driver.getDriver().findElement(By.xpath("(//div[@class='coupon-card'][6])//div[2]//span"))).getText().toString()));
           card.add(((Driver.getDriver().findElement(By.xpath("(//div[@class='coupon-card'][7])//div[2]//span"))).getText().toString()));
           card.add(((Driver.getDriver().findElement(By.xpath("(//div[@class='coupon-card'][8])//div[2]//span"))).getText().toString()));
           card.add(((Driver.getDriver().findElement(By.xpath("(//div[@class='coupon-card'][9])//div[2]//span"))).getText().toString()));
           card.add(((Driver.getDriver().findElement(By.xpath("(//div[@class='coupon-card'][10])//div[2]//span"))).getText().toString()));

        }
        return card;
    }
    @Test
    public void coupon_try(ArrayList a)  {


            actions.moveToElement(checkout_avaible).click().perform();
            do_you_have_coupon.click();
            actions.moveToElement(code).click().sendKeys(a.get(0).toString()).perform();
            actions.moveToElement(apply).click().perform();
            Assert.assertTrue(is_visible.isDisplayed());
            actions.moveToElement(esc).click().perform();


        }




    public void coupuncard() {
        for (int i = 1; i < 10; i++) {
            WebElement a = Driver.getDriver().findElement(By.xpath("(//div[@class='coupon-card'][" + i + "])//div[2]//button"));
            actions
                    .moveToElement(a)
                    .click()
                    .perform();
            Assert.assertTrue(Driver.getDriver().findElement(By.xpath("(//div[@class='coupon-card'][" + i + "])//div[2]//div")).isDisplayed());
        }

    }


    public void WaitUntil(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void WaitClicable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    public void SelectIndex(WebElement element) {
        Select select = new Select(element);
        select.selectByIndex(0);
    }

    @FindBy(xpath = "//a[.='Become a Seller']")
    public WebElement Become_Seller;

    @FindBy(id = "name")
    public WebElement seller_name;

    @FindBy(id = "email")
    public WebElement seller_email;

    @FindBy(id = "password")
    public WebElement seller_password;

    @FindBy(xpath = "//button[.='Register']")
    public WebElement seller_register;

    @FindBy(xpath = "//a[.='Register as Shop Owner']")
    public WebElement register_so;

    @FindBy(xpath = "//a[.='Login']")
    public WebElement Login_Seller;

    @FindBy(xpath = "//label[.='']")
    public WebElement password_show;

    @FindBy(tagName = "h3")
    public WebElement check_name;

    @FindBy(xpath = "//div[.='Enabled']")
    public WebElement check_enable;

    @FindBy(xpath = "//a[.='Profile']")
    public WebElement profile;

    @FindBy(id = "headlessui-menu-button-1")
    public WebElement avatar_seller;

    @FindBy(id = "headlessui-menu-item-20")
    public WebElement avatar_profil;

    @FindBy(id = "headlessui-menu-item-21")
    public WebElement avatar_logout;

    @FindBy(xpath = "//a[.='Create Shop']")
    public WebElement create_shop;


    @FindAll({
            @FindBy(xpath = "(//input[@accept='image/*'])[1]"),
            @FindBy(xpath = "(//input[@accept='image/*'])[2]"),
    })
    public List<WebElement> set_img;

    @FindAll({

            @FindBy(id = "name"),
            @FindBy(id = "description"),
            @FindBy(xpath = "//input[@name='balance.payment_info.name']"),
            @FindBy(xpath = "//input[@name='balance.payment_info.bank']"),
            @FindBy(xpath = "//input[@name='balance.payment_info.account']"),
            @FindBy(xpath = "//input[@name='address.country']"),
            @FindBy(xpath = "//input[@name='address.city']"),
            @FindBy(xpath = "//input[@name='address.zip']"),
            @FindBy(xpath = "//textarea[@name='address.street_address']"),
            @FindBy(xpath = "//input[@placeholder='Search location form here']"),
            @FindBy(xpath = "//input[@name='settings.contact']"),
            @FindBy(xpath = "//input[@name='settings.website']")
    })
    public List<WebElement> set_information;

    @FindBy(xpath = "//button[.='Add New Social Profile']")
    public WebElement Add_Social_Profil;

    @FindBy(id = "balance.payment_info.email")
    public WebElement add_holder_email;

    @FindBy(xpath = "//button[.='Save']")
    public WebElement Save_Profil;

    @FindBy(xpath = "(//a)[4]")
    public WebElement show_shops;

    @FindBy(xpath = "//span[.='Dashboard']")
    public WebElement dashboard;

    @FindBy(xpath = "//span[.='Attributes']")
    public WebElement attributes;

    @FindBy(xpath = "//span[.='Products']")
    public WebElement products;

    @FindBy(xpath = "//span[.='Shippings']")
    public WebElement shipping;

    @FindBy(xpath = "//span[.='Manufacturers/Publications']")
    public WebElement man_au;

    @FindBy(xpath = "//span[.='Users']")
    public WebElement user;

    @FindBy(xpath = "//span[.='Taxes']")
    public WebElement taxes;

    @FindBy(xpath = "//span[.='Orders']")
    public WebElement orders;

    @FindBy(xpath = "//span[.='Coupons']")
    public WebElement coupons;

    @FindBy(xpath = "//span[.='Refunds']")
    public WebElement refunds;

    @FindBy(xpath = "//span[.='Staff']")
    public WebElement staff;

    @FindBy(xpath = "//span[.='Withdrawals']")
    public WebElement withdrawals;

    @FindBy(xpath = "//span[.='Reviews']")
    public WebElement reviews;

    @FindBy(xpath = "//span[.='Questions']")
    public WebElement questions;

    @FindBy(xpath = "//a[.='Visit Shop']")
    public WebElement visit_shop;

    @FindBy(xpath = "//a[.='Groups']")
    public WebElement groups;

    @FindBy(xpath = "//a[.='Categories']")
    public WebElement categories;

    @FindBy(xpath = "//a[.='Tags']")
    public WebElement tag;

    @FindBy(xpath = "//a[.='Authors']")
    public WebElement authors;

    @FindBy(xpath = "//a[.='Create Order']")
    public WebElement create_order;

    @FindBy(xpath = "//span[.='+ Add Attribute']")
    public WebElement add_attribute;

    @FindBy(xpath = "//*[name()='svg']//*[name()='path'][@d='m128 256c0 35.347656-28.652344 64-64 64s-64-28.652344-64-64 28.652344-64 64-64 64 28.652344 64 64zm0 0']")
    public WebElement ex_im;

    @FindBy(xpath = "//div[@role='button']")
    public WebElement import_file;

    @FindBy(xpath = "//a[@target='_blank']")
    public WebElement export_file;

    @FindBy(id = "name")
    public WebElement attribute_name;

    @FindBy(xpath = "//button[.='Add Value']")
    public WebElement add_value;

    @FindBy(xpath = "//button[.='Add Attribute']")
    public WebElement add_attribute2;

    @FindBy(xpath = "//input[@name='values.0.value']")
    public WebElement add_attribute_value;

    @FindBy(xpath = "//input[@name='values.0.meta']")
    public WebElement add_meta;

    @FindBy(xpath = "//button[.='Remove']")
    public WebElement attribute_remove;

    @FindBy(id = "search")
    public WebElement products_search;

    @FindBy(xpath = "//span[.='+ Add Product']")
    public WebElement add_product;

    @FindBy(xpath = "((//main//div)[3]//button)[2]")
    public WebElement product_filter;

    @FindBy(xpath = "(//table//tr)[3]//td[2]")
    public WebElement product_name;

    @FindBy(xpath = "//table//tr[2]//td[2]")
    public WebElement product_name2;

    @FindBy(xpath = "(//table//tr[2]//td[3]")
    public WebElement product_groups_name;

    @FindBy(xpath = "(//div[@class=' css-15aq8md'])[1]")
    public WebElement product_groups_check;


    @FindBy(xpath = "(//*[@class= ' css-15aq8md'])[1]")
    public WebElement product_filter_group;

    @FindBy(xpath = "//div[@class=' css-b62m3t-container']")
    public WebElement product_filter_text;

    @FindBy(xpath = "(//tr)[3]//td[3]")
    public WebElement product_filter_text_check;

    @FindBy(xpath = "(//*[@class= ' css-15aq8md'])[2]")
    public WebElement product_filter_category;

    @FindBy(xpath = "(//tr)[3]//td[9]//button")
    public WebElement product_cop;

    @FindBy(xpath = "(//tr)[3]//td[9]//a")
    public WebElement product_edit;

    public void scfrom() {
        actions
                .sendKeys(Keys.ENTER)
                .perform();
    }

    @FindAll({
            @FindBy(xpath = "(//input[@type='file'])[3]"),
            @FindBy(xpath = "(//input[@type='file'])[2]"),
            @FindBy(xpath = "(//input[@type='file'])[1]"),

    })
    public List<WebElement> product_information_img;

    @FindAll({
            @FindBy(xpath = "(//div[@class=' css-b62m3t-container'])[1]"),
            @FindBy(xpath = "(//div[@class=' css-b62m3t-container'])[2]"),
            @FindBy(xpath = "(//div[@class=' css-b62m3t-container'])[3]"),
            @FindBy(xpath = "(//div[@class=' css-b62m3t-container'])[4]"),
            @FindBy(xpath = "(//div[@class=' css-b62m3t-container'])[5]"),
            @FindBy(xpath = "(//div[@class=' css-b62m3t-container'])[6]")

    })
    public List<WebElement> product_information_select;
    @FindAll({
            @FindBy(id = "name"),
            @FindBy(id = "unit"),
            @FindBy(id = "description"),
            @FindBy(id = "price"),

            @FindBy(id = "quantity"),
            @FindBy(id = "sku"),
            @FindBy(id = "width"),
            @FindBy(id = "height"),
            @FindBy(id = "length")
    })
    public List<WebElement> product_information;

    @FindBy(id = "sale_price")
    public WebElement sale_price;

    @FindAll({

            @FindBy(xpath = "//label[@for='published']"),
            @FindBy(xpath = "//label[@for='draft']"),
            @FindBy(id = "is_digital"),
            @FindBy(id = "is_external"),

    })
    public List<WebElement> product_information_check;


    @FindBy(xpath = "//button[.='Add Product']")
    public WebElement Add_product;

    @FindBy(xpath = "//button[.='Update Product']")
    public WebElement edit_product;
    @FindBy(xpath = "(//div[.='Successfully updated!'])[2]")
    public WebElement product_success;

    @FindBy(xpath = "(//div[.='Successfully deleted!'])[4]")
    public WebElement product_delete;

    @FindBy(xpath = "(//button[.='Delete'])")
    public WebElement product_delete_red;


    @FindBy(xpath = "//tbody[@class='rc-table-tbody']")
    public WebElement author_table;

    @FindBy(id = "search")
    public WebElement author_search;

    @FindBy(xpath = "//span[.='+ Add Author']")
    public WebElement Author_add;

    @FindAll({
            @FindBy(xpath = "(//input[@accept='image/*'])[1]"),
            @FindBy(xpath = "(//input[@accept='image/*'])[2]"),

    })
    public List<WebElement> author_img;

    @FindAll({
            @FindBy(id = "name"),
            @FindBy(id = "languages"),
            @FindBy(id = "bio"),
            @FindBy(id = "quote"),
            @FindBy(xpath = "//input[@name='socials.0.url']"),

    })
    public List<WebElement> author_information;

    @FindAll({
            @FindBy(xpath = "(//div[@class='react-datepicker-wrapper'])[1]"),
            @FindBy(xpath = "(//div[@class='react-datepicker-wrapper'])[2]"),

    })
    public List<WebElement> author_calender;

    @FindBy(xpath = "//button[.='Add New Social Profile']")
    public WebElement author_add_social;

    @FindBy(xpath = " //div[@class=' css-ackcql']")
    public WebElement author_select_platform;


    @FindBy(xpath = "(//button[@type='button'])[2]")
    public WebElement author_remove;

    @FindBy(xpath = "//button[.='Add Author']")
    public WebElement author_add_last;

    @FindBy(xpath = "//button[.='Update Author']")
    public WebElement author_update_last;

    @FindBy(xpath = "(//div[.='Successfully created!'])[2]")
    public WebElement author_success;

    @FindBy(xpath = "(//tr)[3]//td[6]//a")
    public WebElement author_edit;

    @FindBy(xpath = "(//tr)[3]//td[6]//button")
    public WebElement author_cop;
    @FindBy(xpath = "(//div[.='Successfully updated!'])[2]")
    public WebElement author_updated;

    @FindBy(xpath = "(//button[.='Delete'])")
    public WebElement author_delete;

    @FindBy(xpath = "(//tr)[3]//td[5]//button")
    public WebElement author_aproval_btn;

    @FindBy(xpath = "(//div[.='Successfully updated!'])[2]")
    public WebElement author_aproval_chck;

    @FindBy(id = "search")
    public WebElement m_search;

    @FindBy(xpath = "//span[.='+ Add Manufacturer/Publication']")
    public WebElement m_add_mp;
    @FindBy(xpath = "//button[.='Add Manufacturer/Publication']")
    public WebElement m_add_mp_last;

    @FindBy(xpath = "//button[.='Update Manufacturer/Publication']")
    public WebElement m_add_mp_update;


    @FindBy(xpath = "//input[@accept='image/*']")
    public WebElement groups_img;

    @FindAll({
            @FindBy(xpath = "(//input[@accept='image/*'])[1]"),
            @FindBy(xpath = "(//input[@accept='image/*'])[2]"),

    })
    public List<WebElement> m_img;

    @FindAll({
            @FindBy(xpath = "//div[@class=' css-15aq8md']"),
            @FindBy(xpath = "(//div[@class=' css-1n58n78'])[2]"),

    })
    public List<WebElement> m_select_group;

    @FindAll({
            @FindBy(id = "name"),
            @FindBy(id = "website"),
            @FindBy(id = "website"),
            @FindBy(xpath = "(//div[@class=' css-1n58n78'])[2]"),
    })
    public List<WebElement> m_information;


    @FindBy(xpath = "//button[.='Add New Social Profile']")
    public WebElement m_social_add;


    @FindBy(xpath = "//input[@name='socials.0.url']")
    public WebElement m_socialUrl;

    @FindBy(xpath = "(//div[.='Successfully created!'])[2]")
    public WebElement m_success;

    @FindBy(xpath = "(//div[.='Successfully updated!'])[2]")
    public WebElement m_updated;

    @FindBy(xpath = "(//button[.='Delete'])")
    public WebElement m_delete;


    @FindBy(xpath = "(//tr)[3]//td[6]//button")
    public WebElement m_cop;

    @FindBy(xpath = "(//tr)[3]//td[6]//a")
    public WebElement m_edit;

    @FindBy(xpath = "(//tr)[3]//td[5]//button")
    public WebElement m_aproval_btn;

    @FindBy(xpath = "(//div[.='Successfully updated!'])[2]")
    public WebElement m_aproval_chck;

    @FindBy(tagName = "//main//a")
    public WebElement myShops;

    @FindBy(id = "search")
    public WebElement groups_search;

    @FindBy(xpath = "//span[.='+ Add Group']")
    public WebElement groups_add_group;

    @FindBy(xpath = "//div[@class='rc-table-container']")
    public WebElement groups_table;

    @FindBy(xpath = "(//tr)[3]//td[4]//button")
    public WebElement groups_cop;

    @FindBy(xpath = "(//tr)[3]//td[4]//a")
    public WebElement groups_edit;

    @FindBy(xpath = "(//button[.='Delete'])")
    public WebElement groups_delete;


    @FindAll({
            @FindBy(xpath = "//label[@for='classic']"),
            @FindBy(xpath = "//label[@for='compact']"),
            @FindBy(xpath = "//label[@for='minimal']"),
            @FindBy(xpath = "//label[@for='modern']"),
            @FindBy(xpath = "//label[@for='standard']"),
    })
    public List<WebElement> groups_SelectLoyout;
    @FindAll({
            @FindBy(xpath = "//label[@for='product-card-0']"),
            @FindBy(xpath = "//label[@for='product-card-1']"),
            @FindBy(xpath = "//label[@for='product-card-2']"),
            @FindBy(xpath = "//label[@for='product-card-3']"),
            @FindBy(xpath = "//label[@for='product-card-4']"),
            @FindBy(xpath = "//label[@for='product-card-5']"),
            @FindBy(xpath = "//label[@for='product-card-6']"),
    })
    public List<WebElement> groups_SelectCard;

    @FindBy(id = "name")
    public WebElement groups_name;

    @FindBy(xpath = "//label[@for='banners.0.title']")
    public WebElement groups_title;

    @FindBy(xpath = "//textarea[@id='banners.0.description']")
    public WebElement groups_description;

    @FindAll({
            @FindBy(id = "name"),
            @FindBy(xpath = "//label[@for='banners.0.title']"),
            @FindBy(xpath = "//textarea[@id='banners.0.description']"),
    })
    public List<WebElement> groups_information;


    @FindBy(xpath = "(//div[@class=' css-1n58n78'])[1]")
    public WebElement groups_selectIcon;

    @FindBy(xpath = "//button[.='Add Banner']")
    public WebElement groups_addBanner;

    @FindBy(xpath = "//button[.='Remove']")
    public WebElement groups_remove;

    @FindBy(xpath = "//button[.='Add Group']")
    public WebElement groups_addGroup_last;

    @FindBy(xpath = "//button[.='Update Group']")
    public WebElement groups_update;

    @FindBy(xpath = "(//div[.='Successfully updated!'])[2]")
    public WebElement groups_updated;

    @FindBy(xpath = "(//div[.='Successfully created!'])[2]")
    public WebElement groups_success;

    @FindBy(id = "search")
    public WebElement ctg_search;

    @FindBy(xpath = "//span[.='+ Add Categories']")
    public WebElement ctg_addCategories;

    @FindBy(xpath = "//div[.='Filter by Group']")
    public WebElement ctg_filter;

    @FindBy(xpath = "//input[@accept='image/*']")
    public WebElement ctg_img;

    @FindAll({
            @FindBy(id = "name"),
            @FindBy(id = "details"),
    })
    public List<WebElement> ctg_information;

    @FindAll({
            @FindBy(xpath = "(//div[@class=' css-15aq8md'])[1]"),
            @FindBy(xpath = "(//div[@class=' css-15aq8md'])[2]"),
            @FindBy(xpath = "(//div[@class=' css-15aq8md'])[3]"),
    })
    public List<WebElement> ctg_selectyout;

    @FindBy(xpath = "//button[.='Add Category']")
    public WebElement Ctg_addCategories_last;

    @FindBy(xpath = "//button[.='Update Category']")
    public WebElement ctg_update;

    @FindBy(xpath = "(//div[.='Successfully created!'])[2]")
    public WebElement ctg_success;

    @FindBy(xpath = "(//tr)[3]//td[9]//button")
    public WebElement ctg_cop;

    @FindBy(xpath = "(//tr)[3]//td[9]//a")
    public WebElement ctg_edit;

    @FindBy(xpath = "(//div[.='Successfully updated!'])[4]")
    public WebElement ctg_updated;

    @FindBy(xpath = "(//div[.='Successfully deleted!'])[2]")
    public WebElement ctg_deleted;

    @FindBy(id = "search")
    public WebElement tag_search;

    @FindBy(xpath = "//span[.='+ Add Tag']")
    public WebElement tag_addCategories;

    @FindBy(xpath = "//button[.='Delete']")
    public WebElement tag_delete;

    @FindBy(xpath = "(//tr)[3]//td[6]//button")
    public WebElement tag_cop;

    @FindBy(xpath = "(//div[.='Successfully deleted!'])[2]")
    public WebElement tag_deleted;

    @FindBy(xpath = "(//button[@title='Delete'])[1]/following-sibling::a")
    public WebElement tag_edit;

    @FindAll({
            @FindBy(id = "name"),
            @FindBy(id = "details"),
    })
    public List<WebElement> tag_information;

    @FindAll({
            @FindBy(xpath = "(//div[@class=' css-ackcql'])[1]"),
            @FindBy(xpath = "(//div[@class=' css-ackcql'])[2]"),

    })
    public List<WebElement> tag_select;

    @FindBy(xpath = "(//div[.='Successfully created!'])[2]")
    public WebElement tag_success;

    @FindBy(xpath = "(//div[.='Successfully updated!'])[4]")
    public WebElement tag_updated;

    @FindBy(xpath = "//input[@accept='image/*']")
    public WebElement tag_img;

    @FindBy(xpath = "(//div[.='Add Tag'])[2]//button")
    public WebElement tag_addTag;

    @FindBy(xpath = "(//button[.='Update Tag'])")
    public WebElement tag_updateTag;

    @FindBy(id = "search")
    public WebElement order_search;

    @FindBy(id = "headlessui-menu-button-2")
    public WebElement order_options;

    @FindBy(id = "//tbody//tr[2]//td[1]//span")
    public WebElement order_show;

    @FindBy(xpath = "//tbody//tr[2]//td[8]//a")
    public WebElement order_eye;

    @FindBy(xpath = "//tbody//tr[2]//td[2]")
    public WebElement order_tracking_number;

    @FindBy(xpath = "(//h3)[1]")
    public WebElement order_id;

    @FindBy(xpath = "//div[@class=' css-ackcql']")
    public WebElement order_status_select;

    @FindBy(xpath = "//span[.='Change Status']")
    public WebElement order_Change_status;

    @FindBy(xpath = "//button[.='Download Invoice']")
    public WebElement order_download;

    @FindBy(xpath = "(//main//div)[7]//span[2]")
    public WebElement ordes_status;

    @FindBy(xpath = "(//div[.='Successfully updated!'])[2]")
    public WebElement order_success;

    @FindBy(id = "search")
    public WebElement c_order_search;

    @FindBy(xpath = "(//h3)[1]")
    public WebElement c_head;

    @FindBy(xpath = "(//*[@class= ' css-15aq8md'])[1]")
    public WebElement c_filter_groups;

    @FindBy(xpath = "//button[contains(text(),'Filter')]")
    public WebElement c_filter;

    @FindBy(xpath = "(//span[.='text-product-image'])[1]")
    public WebElement c_order_selectOrder;

    @FindBy(xpath = "(//span[.='Add'])[1]")
    public WebElement c_order_add;

    @FindBy(xpath = "(//div[.='Select...'])[5]")
    public WebElement c_select;

    @FindBy(xpath = "(//div[.='Phone'])//input")
    public WebElement c_input;

    @FindBy(xpath = "//button[.='Save']")
    public WebElement c_save;

    @FindBy(xpath = "(//button[.='Add'])[1]")
    public WebElement c_add1;
    @FindBy(xpath = "(//button[.='Add'])[2]")
    public WebElement c_add2;
    @FindBy(xpath = "(//button[.='Add'])[3]")
    public WebElement c_add3;
    @FindBy(xpath = "(//button[.='Add'])[4]")
    public WebElement c_add4;

    @FindBy(xpath = "//span[contains(text(),'Item')]")
    public WebElement c_order_sepet;

    @FindBy(xpath = "//span[.='Checkout']//ancestor::button")
    public WebElement c_order_checkout;

    @FindBy(xpath = "//button[.='Update']")
    public WebElement c_order_update;

    @FindBy(xpath = "(//button[.='Add'])")
    public WebElement c_order_adds;

    @FindBy(xpath = "(//div[@class=' css-ackcql'])")
    public WebElement c_order_costumer;


    @FindBy(xpath = ("//*[.='Check Availability']"))
    public WebElement c_oreder_check;

    @FindBy(id = "(headlessui-radiogroup-option-11)")
    public WebElement c_order_delivery;

    @FindBy(id = "(headlessui-radiogroup-option-34)")
    public WebElement c_order_cash;

    @FindBy(id = "(headlessui-radiogroup-option-35)")
    public WebElement c_order_cod;

    @FindBy(id = "search")
    public WebElement costumer_search;

    @FindBy(xpath = "(//span[.='+ Add Customer'])")
    public WebElement costumer_add_costumer;

    @FindBy(xpath = "((//tr)[3]//td[4])//div")
    public WebElement costumer_permission;

    @FindBy(xpath = "((//tr)[3]//td[5])")
    public WebElement costumer_wallet;

    @FindBy(xpath = "((//tr)[3]//td[6])")
    public WebElement costumer_status;

    @FindBy(xpath = "((//tr)[3]//td[7]//button[1])")
    public WebElement costumer_act_per;

    @FindBy(xpath = "(//tr)[3]//td[2]")
    public WebElement shp_check;

    @FindBy(xpath = "((//tr)[3]//td[7]//button[2])")
    public WebElement costumer_act_wallet;

    @FindBy(xpath = "((//tr)[3]//td[7]//button[3])")
    public WebElement costumer_act_status;

    @FindBy(xpath = "(//button[.='Cancel'])")
    public WebElement costumer_cancel;

    @FindBy(id = "points")
    public WebElement costumer_wallet_edit;

    @FindBy(xpath = "((//div[@class='w-1/2'])[2])")
    public WebElement costumer_red_btn;

    @FindBy(xpath = "(//div[.='Successfully updated!'])[2]")
    public WebElement costumer_updated;

    @FindBy(xpath = "(//div[contains(text(),'Successfully')])")
    public WebElement costumer_remove;

    @FindBy(xpath = "//button[.='Create Customer']")
    public WebElement costumer_last;

    @FindBy(xpath = "(//tr[2])//td[2]")
    public WebElement costumer_name;

    @FindBy(id = "email")
    public WebElement costumer_email;

    @FindAll({
            @FindBy(id = "name"),
            @FindBy(id = "password"),
    })
    public List<WebElement> costumer_information;

    @FindBy(id = "search")
    public WebElement coupons_search;

    @FindBy(xpath = "(//table//tr[2])//td[3]")
    public WebElement coupons_name;

    @FindBy(xpath = "(//table//tr[2])//td[2]")
    public WebElement TAX_name;

    @FindBy(xpath = "(//span[.='+ Add Coupon'])")
    public WebElement coupons_add_coupon;

    @FindBy(xpath = "(//span[.='+ Add Tax'])")
    public WebElement coupons_add_tax;

    @FindBy(xpath = "(//span[.='+ Add Shipping'])")
    public WebElement shp_add;

    @FindBy(xpath = "//button[.='Add Shipping']")
    public WebElement shp_add2;

    @FindBy(xpath = "//button[@data-variant='normal']")
    public WebElement coupons_add_coupon_last;

    @FindBy(xpath = "(//button[.='Add Tax'])")
    public WebElement tax_add_coupon_last;

    @FindBy(xpath = "((//tr)[3]//td[8]//button)")
    public WebElement coupons_cop;

    @FindBy(xpath = "((//tr)[3]//td[8]//a)")
    public WebElement coupons_edit;

    @FindBy(xpath = "(//button[.='Cancel'])")
    public WebElement coupons_cancel;

    @FindBy(xpath = "(//button[.='Delete'])")
    public WebElement coupons_delete;

    @FindBy(xpath = "(//div[.='Successfully deleted!'])[4]")
    public WebElement coupons_d_m;
    @FindBy(xpath = "(//div[.='Successfully deleted!'])[3]")
    public WebElement deleted_1;
    @FindBy(xpath = "(//div[.='Successfully deleted!'])[2]")
    public WebElement deleted_2;


    @FindBy(xpath = "//input[@accept='image/*']")
    public WebElement coupons_img;

    @FindAll({
            @FindBy(id = "code"),
            @FindBy(id = "description"),
            @FindBy(id = "minimum_cart_amount"),
            @FindBy(xpath = "(//input[@type='text'])[2]"),
            @FindBy(xpath = "(//input[@type='text'])[3]"),
    })
    public List<WebElement> coupons_information;
    @FindAll({
            @FindBy(id = "name"),
            @FindBy(id = "rate"),
            @FindBy(id = "country"),
            @FindBy(id = "city"),
            @FindBy(id = "state"),
            @FindBy(id = "zip"),

    })
    public List<WebElement> tax_information;
    @FindAll({
            @FindBy(id = "name"),
            @FindBy(id = "amount"),


    })
    public List<WebElement> shp_information;

    @FindAll({
            @FindBy(xpath = "//input[@id='fixed']"),
            @FindBy(xpath = "//input[@id='percentage']"),
            @FindBy(xpath = "//input[@id='free_shipping']"),
    })
    public List<WebElement> coupons_type;

    @FindAll({
            @FindBy(xpath = "//label[@for='FIXED']"),
            @FindBy(xpath = "//label[@for='PERCENTAGE']"),
            @FindBy(xpath = "//label[@for='FREE']"),
    })
    public List<WebElement> shp_type;

    @FindBy(xpath = "(//div[.='Successfully created!'])[2]")
    public WebElement coupons_success;

    @FindBy(xpath = "(//div[.='Successfully updated!'])[2]")
    public WebElement tax_update;

    @FindBy(xpath = "(//button[.='Back'])")
    public WebElement coupons_back;

    @FindBy(xpath = "(//button[.='Update Coupon'])")
    public WebElement coupons_update_c;

    @FindBy(xpath = "//button[.='Update Tax']")
    public WebElement tax_update_c;

    @FindBy(xpath = "//table//tr[2]")
    public WebElement question_show;

    @FindBy(xpath = "(//tr)[3]//td[2]//p")
    public WebElement question_check;

    @FindBy(xpath = "//table//tr[2]//td[7]//button[1]")
    public WebElement question_cop;

    @FindBy(xpath = "//table//tr[2]//td[7]//button[2]")
    public WebElement question_edit;

    @FindBy(id = "answer")
    public WebElement box;

    @FindBy(xpath = "(//button[.='Cancel'])")
    public WebElement question_cancel;

    @FindBy(xpath = "//button[.='Delete']")
    public WebElement question_delete;

    @FindBy(id = "answer")
    public WebElement costumer_delete;

    @FindBy(xpath = "//button[.='Reply']")
    public WebElement costumer_reply;



    @FindBy(xpath = "//table//tr[2]")
    public WebElement reviews_show;

    @FindBy(xpath = "(//table//tr[2]//td[7]//button[1])")
    public WebElement reviews_cop;

    @FindBy(xpath = "//table//tr[2]//td[4]//a")
    public WebElement reviews_Products;

    @FindBy(xpath = "//h1")
    public WebElement reviews_check_name;

    @FindBy(xpath = "(//div//p)[3]")
    public WebElement m_y;

    @FindBy(xpath = "//table//tr[2]//td[2]//p")
    public WebElement m_y2;

    @FindBy(xpath = "//table//tr[2]//td[2]")
    public WebElement reviews_costumer;

}