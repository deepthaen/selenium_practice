package testNg.testng_Practice;

import org.testng.annotations.Test;

public class TestNg_Basics {

    @Test(invocationCount = 5)
    public void test(){
        System.out.println("testng class");
    }

    @Test(priority = 1)
    public void test_1(){
        System.out.println("testng 1");
    }

    @Test(priority = 2)
    public void test_2(){
        System.out.println("testng 2");
    }
}
