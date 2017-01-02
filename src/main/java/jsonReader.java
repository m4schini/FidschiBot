import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class jsonReader {

    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        try {
            System.out.println("Read Command Data");
            Object obj = parser.parse(new FileReader("data.json"));
            JSONObject jsonObject = (JSONObject) obj;

            JSONArray commandscont = (JSONArray) jsonObject.get("commands");
            Iterator i = commandscont.iterator();

            while (i.hasNext()) {
                JSONObject commnd = (JSONObject) i.next();

                String alias = (String)commnd.get("alias");
                String command = (String)commnd.get("command");
                Long value = (Long) commnd.get("value");

                main.aliasL.add(alias);
                main.commandL.add(command);
                main.valueL.add(value);
            }
            System.out.println("aliase: " + main.aliasL);
            System.out.println("commands: " + main.commandL);
            System.out.println("values: " + main.valueL);
            System.out.println(main.line);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}