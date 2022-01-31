package advance_Selenium;


import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class jsonRe {

    public static void jsonread() throws IOException, JSONException {
        InputStream input = new FileInputStream("./config.json");
        String jsonString = IOUtils.toString(input);
        System.out.println(jsonString);

        JSONObject json = new JSONObject(jsonString);
        JSONObject data = json.getJSONObject("data");

        System.out.println(data.getString("Name"));
        System.out.println(data.get("id").toString());



    }
}
