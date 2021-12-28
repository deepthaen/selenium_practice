package testNg;

import org.testng.Assert;
import org.testng.annotations.Test;

public class testNg_AssetFail {

    @Test
    public void assertFail(){
        //login
        //checkout
        //payment
        // if only COD -- gohead -- else fail
        String mod ="PREPAID";
        if(!mod.equalsIgnoreCase("COD")){
            Assert.fail("Payment method is not equals to COD, so failing test case");
        }
        //place order

    }
}
