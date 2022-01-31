package advance_Selenium;


import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Json_Pratice {


    public static void jsonReaders() throws IOException, JSONException {
        InputStream input = new FileInputStream("./config.json");
        String jsonString = IOUtils.toString(input);
        System.out.println(jsonString);

        JSONObject json = new JSONObject(jsonString);
        JSONObject data = json.getJSONObject("data");

        System.out.println(data.getString("name"));
        System.out.println(data.get("id").toString());


    }

    public static void main(String[] args) throws JSONException, IOException {
        jsonReaders();
    }
}
