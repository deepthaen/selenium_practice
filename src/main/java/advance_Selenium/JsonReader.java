package advance_Selenium;


import com.oracle.javafx.jmx.json.JSONException;
import org.apache.commons.io.IOUtils;

import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class JsonReader {

    public static void jsonReader() throws IOException, JSONException {

        InputStream input = new FileInputStream("./config.json"); // Reading from file
        String jsonString = IOUtils.toString(input); // converting file data to string

        System.out.println(jsonString); // reading complete json String

//        JSONObject json = new JSONObject(jsonString); // string to JSON OBJECT
//        JSONObject data = json.getJSONObject("data"); // reading data object
//
//        System.out.println(data.getString("BROWSER"));
//        System.out.println(data.get("URL").toString());

    }


    public static void main(String[] args) throws IOException, JSONException {
        jsonReader();
    }
}
