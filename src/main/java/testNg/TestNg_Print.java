package testNg;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNg_Print {

    @Test
    public void report(){
        //System.out.println("printing logs");
        Reporter.log("printing logs",true);
    }
}
