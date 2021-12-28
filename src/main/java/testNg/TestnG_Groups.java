package testNg;

import org.testng.annotations.Test;

public class TestnG_Groups {

    @Test(groups = {"FUNCTIONAL","SMOKE","SANITY","REGRESSION"})
    public void loginTest(){
        System.out.println("Running login test");
    }

    @Test(groups = {"SMOKE","REGRESSION"})
    public void createOrder(){
        System.out.println("Running Create order");
    }
}
