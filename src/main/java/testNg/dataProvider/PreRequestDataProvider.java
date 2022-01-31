package testNg.dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PreRequestDataProvider {

    @DataProvider(name = "deeptData")
    public Object[][] getData(){
        return null;
    }


    @Test(dataProvider = "deepthaData")
    public void test(String browser, String user, String pass){
        System.out.println(browser+"_"+user+"_"+pass);
    }
}
