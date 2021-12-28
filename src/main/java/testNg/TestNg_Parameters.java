package testNg;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNg_Parameters {


    @Test
    @Parameters("browser")
    public void loginTest(String browser){
        if(browser.equalsIgnoreCase("chrome"))
            System.out.println("CHROME");
        else if(browser.equalsIgnoreCase("FF"))
            System.out.println("FIREFOX");
    }
}
