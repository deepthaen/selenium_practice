package testNg;

import org.testng.annotations.Test;

public class TestNg_Priority {

    @Test(priority = 1000)
    public void readFromDB(){
        System.out.println("Taking from DB");
    }

    @Test(priority = 1)
    public void readFromProperties(){
        System.out.println("Taking from Properties");
    }

    @Test(priority = 2)
    public void readFromCsv(){
        System.out.println("Taking from CSV");
    }
}
