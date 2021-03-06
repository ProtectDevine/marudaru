package marudaru.main.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Service
public class mainService {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		
		FileWriter writer=null;
        JsonObject jsonobject = new JsonObject();
        jsonobject.addProperty("company", "tistory");
        jsonobject.addProperty("address", "seoul");
        jsonobject.addProperty("number", "0212345678");
        
        JsonObject name1Info = new JsonObject();
        name1Info.addProperty("name", "kim");
        name1Info.addProperty("age", "29");
        name1Info.addProperty("isNew", true);
        
        JsonObject name2Info = new JsonObject();
        name2Info.addProperty("name", "park");
        name2Info.addProperty("age", "27");
        name2Info.addProperty("isNew", true);
        
        JsonObject name3Info = new JsonObject();
        name3Info.addProperty("name", "lee");
        name3Info.addProperty("age", "26");
        name3Info.addProperty("isNew", true);
        
        JsonArray infoArray = new JsonArray();
        infoArray.add(name1Info);
        infoArray.add(name2Info);
        infoArray.add(name3Info);
        
        jsonobject.add("newEmployees", infoArray);
        System.out.println(jsonobject);
        
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(jsonobject);


        writer = new FileWriter("C:\\marudaru\\gson.json");
        writer.write(json);
        writer.flush();
        writer.close();
		
	}
}

		
