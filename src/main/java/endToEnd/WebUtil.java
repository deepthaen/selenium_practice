package endToEnd;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import javax.annotation.Nullable;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class WebUtil {

    //Pre Request
    //Add selenium dependency in pom.xml

    /**
     * Question
     *  1. Launch chrome browser
     *  2. maximise
     *  3. wait for page laad
     *  4. handle browser popups
     *  5. click on login using JS
     *  6. enter username password
     *  7. click on continue
     *  8. hover on category and go to listing
     *  9. scroll bottom
     *  10. scroll up
     *  11. take screenshot
     *  12. refresh screen
     *  12. close browser
     */


    private static final String[] BROWSERS ={"CHROME","FIREFOX","SAFARI","OPERA","EDGE","IE","HEADLESS"};
    private static final String URL ="https:///www.nnnow.com";
    private static final String USERNAME = "";
    private static final String PASSWORD = "";
    private static final String SCREENSHOT_PATH = "";
    private static final String CHROME_PATH = "/Users/deeptha.naik/Downloads/chromedriver2";
    private static final String GECKO_PATH = "";
    private static final String SAFARI_PATH = "";

    public static WebDriver driver;
    public static JavascriptExecutor js = (JavascriptExecutor) driver;

    public static ChromeOptions setChromeCapabilities(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        return options;
    }

    public static WebDriver launchBrowser(String browser){
        System.out.println("Launching chrome Browser");
        switch (browser){
            case "CHROME":
                System.setProperty("webdriver.chrome.driver",CHROME_PATH);
                driver = new ChromeDriver(setChromeCapabilities());
                break;
        }
        return  driver;
    }

    public static void setUrl(){
        System.out.println("Set browser Url :: "+URL);
        driver.get(URL);
    }

    public static void maximize(){
        System.out.println("Maximize Window");
        driver.manage().window().maximize();
    }

    public static void hardSleep(long time )  {
        System.out.println("Hard Sleep using thread :: " + time);
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void implicitWait(long time){
        System.out.println("Implicit wait :: " + time);
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }
    public static void waitForElementClickable(long time, WebElement element){
        System.out.println("Explicitly wait for element to click  :: "+ time);
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void fluentWait(long time, long loop, WebElement element){
        System.out.println("Fluent wait for :: "+time);
        Wait wait = new FluentWait(driver)
                .withTimeout(time,TimeUnit.SECONDS)
                .pollingEvery(loop, TimeUnit.SECONDS)
                .ignoring(Exception.class);

        wait.until(new Function<WebDriver,WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return element;
            }
        });
    }
    public static void scrollBottom(long pixel){
        System.out.println("Scrolling to bottom :; "+pixel);
        js.executeScript("window.scrollBy(0,"+pixel+")");
    }

    public static void scrollTop(){
        System.out.println("Scrolling to TOP :: ");
        js.executeScript("window.scrollTp(document.body.scrollHeight, 0)");
    }


    public static WebElement findElement(String locator,String pathValue){//ID, username
        System.out.println("FInd WeBElement in webpage :: "+ locator);
        WebElement element;
        switch (locator){
            case "ID":
                element = driver.findElement(By.id(pathValue));
                break;
            case "XPATH":
                element = driver.findElement(By.xpath(""));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + locator);
        }
        return element;
    }
    public static List<WebElement> finElements(String locator, String pathValue){
        System.out.println("Find WebElements in webpage :: "+ locator);
        List<WebElement> elements;
        switch (locator){
            case "ID":
                elements = driver.findElements(By.id(pathValue));
                break;
            case "XPATH":
                elements = driver.findElements(By.xpath(""));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + locator);
        }
        return elements;
    }

    public static void click(String locator,String xpath,long time){
        System.out.println("Perform click action ");
        waitForElementClickable(time,findElement(locator,xpath));
        findElement(locator,xpath).click();   //findElement(ID,"username").click()
    }
    public static void type(String locator,String xpath,String input){
        //eait for element present
        System.out.println("Enter input in text box");
        findElement(locator,xpath).sendKeys(input);
    }
    public static void click_using_js(String locator,String xpath){
        System.out.println("perform click action using java script ");
        js.executeScript("arguments[0].click();",findElement(locator,xpath));
    }
    public static void wait_forpageload(){
        System.out.println("wait for page load");
        ExpectedCondition<Boolean> expectedCondition = new ExpectedCondition<Boolean>() {
            @Nullable
            @Override
            public Boolean apply(@Nullable WebDriver input) {
                return js.executeScript("return document.readyState").toString().equals("complete");
            }
        };

        try{
            hardSleep(1000);
            WebDriverWait wait = new WebDriverWait(driver,30);
            wait.until(expectedCondition);
        }catch (Throwable error){
            System.exit(500);
        }
    }
    public static void refresh(){
        System.out.println("Refresh page");
        driver.navigate().refresh();
    }

    public static void mouseHover(WebElement hoverElement,WebElement clickElement){
        System.out.println("Perform mouse hover action");
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverElement).click(clickElement).build().perform();
    }
    public static void select_dropdown_value(WebElement element,String input){
        System.out.println("select option from dropdown by value");
        Select select = new Select(element);
        select.selectByValue(input);
    }
    public static Set<String> getWindows(){
        System.out.println("get window control");
        Set<String> windows =  driver.getWindowHandles();
        return windows;
    }
    public static String getCurrentWindow(){
        System.out.println("get current control ");
        String window =  driver.getWindowHandle();
        return window;
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
    public static void switchBackMainWindow(String parentWindow){
        System.out.println("switcing back to parent window");
        driver.switchTo().window(parentWindow);
    }


    public static void switchFrame(){}
    public static void getUrl(String URL){
        System.out.println("Get url" + URL);
        driver.get(URL);
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
    public static void handlePopUp(){}

    public static void handleBrowserPopUp(){}

    public static void isElementClickbale(){}

    public static void isElementPresent(){}

    public static void isEelementEnable(){}

    public static void fileUpload(){}

    public static void fileDownload(){}

    public static void fileDownloadSpecificLocation(){}

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

    public static void getAttribute(String locator, String xpath, String){
        System.out.println("Get Attribute of WebElement :: "+ locator);
        findElement(locator, xpath).getAttribute(locator);
    }


    public static void main(String[] args) throws IOException {
        launchBrowser("CHROME");
        maximize();
        implicitWait(30);
        setUrl();
        wait_forpageload();
        click("ID","login",30);
        type("ID","username","9035777119");
        click("ID","continue",30);
        //pasword
        click_using_js("ID","continue");
        refresh();
        mouseHover(findElement("ID","MENS"),findElement("ID","product"));
        scrollBottom(1000);
        scrollTop();
        hardSleep(3000);
        click("ID","list1",30);
        String parentWindow = getCurrentWindow();
        switchWindow();
        getText("ID","login");
        takeScreenShot("newwindow.png");
        switchBackMainWindow(parentWindow);
        refresh();
        takeScreenShot("oldWindow.png");
        close();
        quite();
    }



}
