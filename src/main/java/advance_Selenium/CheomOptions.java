package advance_Selenium;

import org.openqa.selenium.chrome.ChromeOptions;

public class CheomOptions {


    public static void chromOptions(){

        ChromeOptions op = new ChromeOptions();
        op.addArguments("--headless");
    }
}
