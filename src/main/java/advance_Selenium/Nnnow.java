package advance_Selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Nnnow {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/harikrishnarecharla/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.nnnow.com");
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("document.getElementByXpath('//span[text()='Login']').click();");

    }
}
