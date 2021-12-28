package testNg;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestNg_Skip {

    boolean flag=false;

    @Test(groups = {"FUNCTIONAL"})
    public void testSkip(){
        if(flag==false){
            throw new SkipException("Skipping Tes");
        }
    }
}
