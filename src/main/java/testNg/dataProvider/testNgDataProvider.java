package testNg.dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testNgDataProvider {


    @DataProvider(name = "somData")
    public Object[][] getdata(){
        Object[][] obj= new Object[3][2];
        obj[0][0]="Deeptha";
        obj[0][1]="password123";
        obj[1][0]="Hari";
        obj[1][1]="password123";
        obj[2][0]="raj";
        obj[2][1]="password123";
        return  obj;
    }


    @Test(dataProvider = "somData")
    public void loginTest(String username, String password){
        //login(username,passowrd)
        System.out.println(username+" "+password);
    }
}
