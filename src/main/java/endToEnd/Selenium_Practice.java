package endToEnd;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedMap;
import java.util.concurrent.TimeUnit;

public class Selenium_Practice {

    /**
     *
     */

    public static String[] BROWSERS = {"CHROME", "FIREFOX", "IE", "SAFARI"};
    public static String URL = "http://www.nnnow.com";
    public static String CHROME_PATH = "";
    public static String GECKO_PATH = "";

    public static WebDriver driver;
    public static JavascriptExecutor js = (JavascriptExecutor) driver;

    public static ChromeOptions setCapabilities() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable notifications");
        return options;
    }

    public static WebDriver launchBrowser(String browser) {
        switch (browser) {
            case "CHROME":
                System.setProperty("webdriver.chrome.driver", CHROME_PATH);
                driver = new ChromeDriver(setCapabilities());
                break;

            default:
                System.out.println("No Browser");
                break;

        }
        return driver;
    }

    public static void getUrl(String URL) {
        System.out.println("Get Url :: " + URL);
        driver.get(URL);

    }

    public static void hardSleep(long time) throws InterruptedException {
        System.out.println("Hard Sleep using Thread sleep :: " + time);
        Thread.sleep(time);
    }

    public static void implicitwait(long time) {
        System.out.println("Implicit wait  :: " + time);
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    public static void execplictWait(long time, WebElement element) {
        System.out.println("Exeplict wait  :: " + time);
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    public static void maximize() {
        System.out.println("Browser maximize");
        driver.manage().window().maximize();
    }

    public static WebElement findElement(String locator, String pathValue) {//ID, username
        System.out.println("FInd WeBElement in webpage :: " + locator);
        WebElement element;
        switch (locator) {
            case "ID":
                element = driver.findElement(By.id(pathValue));
                break;
            case "XPATH":
                element = driver.findElement(By.xpath(pathValue));
                break;
            case "CSS":
                element=driver.findElement(By.cssSelector(pathValue));
            default:
                throw new IllegalStateException("Unexpected value: " + locator);
        }
        return element;
    }

    public static void click(String Xpath, String locators) {
        System.out.println("perform click ");
        findElement(locators, Xpath).click();
    }

    public static void type(String locator, String xpath, String input) {

        System.out.println("Enter input in text box");
        findElement(locator, xpath).sendKeys(input);
    }

    public static void refresh() {
        System.out.println("Refresh page");
        driver.navigate().refresh();
    }

    public static void mouseHover(WebElement hoverElement, WebElement clickElement) {
        System.out.println("Perform mouse hover action");
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverElement).perform();
        actions.click(clickElement).build().perform();

    }

    public static void select_dropdown_value(WebElement element,String input, int index){
        System.out.println("select option from dropdown by value");
        Select select = new Select(element);
        // visible text
        select.selectByValue(input);
        // select by index
        select.selectByIndex(index);

    }

    public static String getCurrentWindow(){
        System.out.println("get current control ");
        String window =  driver.getWindowHandle();
        return window;
    }
    public static void switchBackMainWindow(String parentWindow){
        System.out.println("switcing back to parent window");
        driver.switchTo().window(parentWindow);
    }

    public static Set<String> getWindows(){
        System.out.println("get window control");
        Set<String> windows =  driver.getWindowHandles();
        return windows;
    }

    public static void switchWindow(){
        System.out.println("switching from parent window to child wnindow");
        String currentWindow= getCurrentWindow();
        Set<String> windows = getWindows();
        Iterator<String> it = windows.iterator();
        while (it.hasNext()){
            String newWindow = it.next();
            driver.switchTo().window(newWindow);
        }
    }
    public static void getPageSource(){
        System.out.println("Get Page Source ");
        driver.getPageSource();
    }
    public static void takeScreenShot(String name) throws IOException {
        TakesScreenshot srcShot = (TakesScreenshot)driver;
        File srcFile = srcShot.getScreenshotAs(OutputType.FILE);
        File desFile = new File( "/Users/deeptha.naik/Downloads/"+name+".png");
        FileUtils.copyFile(srcFile, desFile);

    }
    public static void close(){
        System.out.println("close current browser ");
        driver.close();
    }
    public static void quite(){
        System.out.println("close all open browser window");
        driver.quit();
    }
    public static void getText(String locator, String xpath){
        System.out.println("Get Text of webElement :: "+locator);
        findElement(locator,xpath).getText();
    }

    public static void getAttribute(String locator, String xpath){
        System.out.println("Get Attribute of WebElement :: "+ locator);
        findElement(locator, xpath).getAttribute(locator);
    }



}