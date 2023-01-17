package Team04.tests;

import Team04.pages.HomePage;
import Team04.utilities.Driver;
import Team04.utilities.ReusableMethods;
import Team04.utilities.TestBaseReports;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_001 extends TestBaseReports {
    Faker faker=new Faker();
    HomePage hp=new HomePage(Driver.getDriver());
    ReusableMethods rm=new ReusableMethods();
@Test

    public void TC_001(){
    rm.sendKeysInfo("bag",hp.searchBox);

}
@Test
    public void TC_002(){


}


}
