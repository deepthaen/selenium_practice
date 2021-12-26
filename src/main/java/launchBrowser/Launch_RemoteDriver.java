package launchBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Launch_RemoteDriver {
    public static void main(String[] args) throws MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("browserVersion", "96");
        chromeOptions.setCapability("platformName", "Mac");
        WebDriver driver = new RemoteWebDriver(new URL("http://www.example.com"), chromeOptions);
        driver.get("http://www.nnnow.com");
        driver.quit();
    }
}
