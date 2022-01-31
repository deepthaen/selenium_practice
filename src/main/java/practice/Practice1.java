package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Practice1 {

    public static WebDriver driver;

    public static String parentWindow(){
        String parentWindow = driver.getWindowHandle();
        return parentWindow;
    }
    public static void windows() {
        Set<String> windowss = driver.getWindowHandles();

        Iterator<String> it = windowss.iterator();
        while (it.hasNext()) {
            String childwindow = it.next();
            driver.switchTo().window(childwindow);
        }

    }

    public static void switchToParent(String ParentWindow){
        driver.switchTo().window(ParentWindow);
    }

    public static void dropDown(){
        WebElement path = driver.findElement(By.xpath(""));
        Select sel = new Select(path);
        sel.selectByVisibleText("");
        sel.selectByIndex(4);
        sel.selectByValue("");
    }

    public static  void actionClass(){
        WebElement path = driver.findElement(By.xpath(""));
        Actions actions = new Actions(driver);
        actions.moveToElement(path).build().perform();
        actions.click(path).build().perform();
    }

    public static void downLoadFile(){
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> pref = new HashMap<>();
        pref.put("download.prompt_for_download", 0);
        options.setExperimentalOption("prefs",pref);
        driver = new ChromeDriver(options);
    }

    public static void dowbload_1(){
        ChromeOptions options = new ChromeOptions();
        Map<String , Object> pref = new HashMap<>();
        pref.put("download.prompt_for_download",0);
        options.setExperimentalOption("prefs", pref);
        driver = new ChromeDriver(options);
    }
}
