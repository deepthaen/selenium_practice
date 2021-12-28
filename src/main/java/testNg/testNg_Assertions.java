package testNg;

import org.testng.Assert;
import org.testng.annotations.Test;

public class testNg_Assertions {

    @Test
    public void loginAssertion(){
        //login successful - success
        // login failure = failure

        String apiResponse = "failure";
        Assert.assertEquals(apiResponse,"success");

    }
}
