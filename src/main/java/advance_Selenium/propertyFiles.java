package advance_Selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class propertyFiles {

    public static String getProperty(String key) throws IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream("./config.properties"));
        String res = prop.getProperty(key);
        return res;

    }

    public static void main(String[] args) throws IOException {
        String val =getProperty("BASEURL");
        System.out.println(val);
    }
}
