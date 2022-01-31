package testNg.testng_Practice;

import org.testng.annotations.Test;

public class Testng_dependnce {

    @Test
    public void test1(){
        System.out.println("test 1");
    }

    @Test(dependsOnMethods = "test1")
    public void test2(){
        System.out.println("test 2");
    }

    @Test
    public void test3(){
        System.out.println("test 3");
    }
}
