package testNg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testNgBasic {


    @Parameters({"flag","username","password"})
    @Test(groups = {"FUNCTIONAL"})
    public void test(){
        boolean flag=false;
        if(flag==true){

        }
        System.out.println("dfdf");
    }




}
