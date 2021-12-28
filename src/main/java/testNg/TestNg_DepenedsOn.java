package testNg;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestNg_DepenedsOn {

    @Test
    public void testLogin(){
        System.out.println("test Login");
    }

    @Test(dependsOnMethods = "testLogin")
    public void checkout(){
        System.out.println("checkout");
    }

    @Test(dependsOnMethods = "checkout")
    public void placeOrder(){
        System.out.println("place Order");
    }
}
