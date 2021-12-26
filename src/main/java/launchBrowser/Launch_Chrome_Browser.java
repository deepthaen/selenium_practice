package launchBrowser;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static com.sun.jna.platform.FileUtils.*;

public class Launch_Chrome_Browser {

    public static void main(String[] args) throws InterruptedException, IOException {

        //Create a instance of ChromeOptions class
        ChromeOptions options = new ChromeOptions();

         //Add chrome switch to disable notification - "**--disable-notifications**"
        options.addArguments("--disable-notifications");

        //Setting system properties of ChromeDriver
        System.setProperty("webdriver.chrome.driver", "/Users/deeptha.naik/Downloads/chromedriver 2");
        WebDriver driver = new ChromeDriver(options);

        System.out.println("ChromenBrowser Intialized");
        //get method to get url
        driver.get("https://www.nnnow.com/");
        System.out.println("Open Website");
        //maxize window
        driver.manage().window().maximize();
        System.out.println("Browser Maximized");
        // thread sleep
        Thread.sleep(1000);
        System.out.println("hard wait using thread sleep");
        driver.findElement(By.xpath("//span[contains(text(),'Login')]")).click();
        System.out.println("click on Login");

        //enter text by using sendkeys
        driver.findElement(By.xpath("//div[contains(text(),'Enter your Phone / Email')]/../div[2]/input")).sendKeys("9986519557");

        //Implicit wait
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //click method
        driver.findElement(By.xpath("//button[text()='CONTINUE']")).click();
        System.out.println("click on login continue");

        //Enter password without Sendkeys using Java script
        JavascriptExecutor JS = (JavascriptExecutor)driver;

        WebElement password = driver.findElement(By.name("password"));
        JS.executeScript("arguments[0].click();",password);
        password.sendKeys("nnnow123");
        //JS.executeScript("arguments[0].value='nnnow123';",password);
        //JS.executeScript("document.getElementByName('password')[0].setAttribute('type','nnnow123'));");
        ////div[contains(text(),'Password*')]/../div[2]/input
         Thread.sleep(10000);
         driver.findElement(By.xpath("//button[text()='CONTINUE']")).click();
         Thread.sleep(10000);
        // naviagte metho
        //driver.navigate().refresh();
        System.out.println("using navigate refresh");

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //Scroll to down till 1000pixel   by vericaly
        JS.executeScript("window.scrollBy(0,1000)");


        // Scroll to Top
        JS.executeScript("window.scrollTo(document.body.scrollHeight, 0)");


        //Mouse Houver on element - mouse hover on Women
        Actions action = new Actions(driver);
        WebElement Mouse_Women = driver.findElement(By.xpath("//span[text()='WOMEN']"));
        action.moveToElement(Mouse_Women).perform();

        // Mouse on sub menu - houser on top and tshirt and click
        WebElement topsTshirt = driver.findElement(By.xpath("//a[text()='Tops & T-Shirts']"));
        action.moveToElement(topsTshirt).perform();

        ////build()- used to compile all the actions into a single step
        action.click().build().perform();
        System.out.println("Mouse hover on Women and going lisitng");
        // Take Screenshot
        TakesScreenshot srcShot = ((TakesScreenshot)driver);
        File srcFile = srcShot.getScreenshotAs(OutputType.FILE);
        File desFile = new File( "/Users/deeptha.naik/Downloads/homePageScreenshot.png");
        FileUtils.copyFile(srcFile, desFile);


        System.out.println("close browser");
        driver.close();


    }

}