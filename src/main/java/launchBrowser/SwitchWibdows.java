package launchBrowser;

import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class SwitchWibdows {

    public WebDriver driver;
    public void switchWindows(){
        String currentWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();

        Iterator<String> it = windows.iterator();
        while(it.hasNext()){


        }


    }
}
