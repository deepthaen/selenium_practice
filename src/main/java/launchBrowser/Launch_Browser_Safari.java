package launchBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Launch_Browser_Safari {

    public static void main(String[] args) {
        WebDriver driver = new SafariDriver();

        System.out.println("safari Browser Intialized");
        driver.get("https://www.nnnow.com/");
        System.out.println("Open Website");
        driver.close();
    }
}
