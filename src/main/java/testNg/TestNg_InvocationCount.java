package testNg;

import org.testng.annotations.Test;

public class TestNg_InvocationCount {

    @Test(invocationCount  =100)
    public void loginTest(){
        System.out.println("LoginTest");
    }
}
