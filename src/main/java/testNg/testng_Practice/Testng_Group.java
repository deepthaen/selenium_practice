package testNg.testng_Practice;

import org.testng.annotations.Test;

public class Testng_Group {

    @Test(groups ={"Smoke", "Sanity", "Regression"})
    public void test3(){
        System.out.println("test3");
    }

    @Test(groups ={"Smoke", "Regression"})
    public void test4(){
        System.out.println("test4");
    }
}
