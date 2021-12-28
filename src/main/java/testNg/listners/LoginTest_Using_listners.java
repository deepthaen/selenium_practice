package testNg.listners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestNg_Listerner.class)
public class LoginTest_Using_listners {

    @Test
    public void loginTest(){
        System.out.println("Running my test login ");
        //Assert.fail("failing");
    }
}
