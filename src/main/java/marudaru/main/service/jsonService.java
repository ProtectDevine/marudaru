package marudaru.main.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class jsonService {
	public static void main(String[] args) throws JsonIOException, JsonSyntaxException, FileNotFoundException {
		
        FileWriter writer=null;
 
            JsonObject jsonobject = new JsonObject();
            JsonParser jsonParser = new JsonParser();
            
            JsonElement element = jsonParser.parse(new FileReader("C:\\marudaru\\umainfo.json"));
            
            jsonobject = element.getAsJsonObject();
            
            
            System.out.println(jsonobject.get("name"));
			
            
            /*
			 * JsonArray memberArray = (JsonArray) jsonobject.get("newEmployees");
			 * 
			 * JsonObject object = (JsonObject) memberArray.get(1);
			 * System.out.println(Integer.parseInt(object.get("age").toString().replace(
			 * "\"", "")));
			 * 
			 * 
			 * 
			 * 
			 * 
			 * String aaa = object.get("age").toString(); System.out.println(aaa);
			 * object.addProperty("park", "bang"); System.out.println(object.get("name"));
			 * System.out.println(memberArray);
			 */
        /*    Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(element);
            
            writer = new FileWriter("C:\\Users\\USER\\Desktop\\java-workspaces\\JSONTest\\jsontestfile\\new_gson.json");
            writer.write(json);

            writer.flush();
            writer.close();*/

        }
        
}		
		
		
