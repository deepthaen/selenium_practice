package endToEnd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserCapability {
    /**
     * Set Capabilities
     * Set Chromer driver path
     * Instaninate chromer driver
     * launch browser and get url - Login - hover on menu
     * navigate to lsiitng and take screenshot
     */
    public static void chromeCapabolity(){
    ChromeOptions options = new ChromeOptions();

    //Add chrome switch to disable notification - "**--disable-notifications**"
        options.addArguments("--disable-notifications");

        // u bevakufff

    //Setting system properties of ChromeDriver
        System.setProperty("webdriver.chrome.driver", "/Users/deeptha.naik/Downloads/chromedriver 2");
       WebDriver driver = new ChromeDriver(options);

        System.out.println("ChromenBrowser Intialized");
                }
}
