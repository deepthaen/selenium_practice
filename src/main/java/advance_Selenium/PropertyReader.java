package advance_Selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {




    public static String readProperty(String key) throws IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream("./config.properties"));
        String response = prop.getProperty(key);
        return response;
    }


    public static void main(String[] args) throws IOException {

        String browser = readProperty("URL");
        System.out.println(browser);

    }
}
