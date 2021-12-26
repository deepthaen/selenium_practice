package launchBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Launch_Firefox_Browser {

    public static void main(String[] args) {
        //Setting system properties of ChromeDriver
       System.setProperty("webdriver.gecko.driver", "/Users/deeptha.naik/Downloads/geckodriver2");
        WebDriver driver = new FirefoxDriver();
        System.out.println("FireFox Browser Intialized");
        driver.get("https://www.nnnow.com/");
        System.out.println("Open Website");
        driver.close();
    }
}
