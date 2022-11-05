package game.classes;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LevelGenerator {
    public LevelGenerator(String file){
        this.createJson(file);
    }

    public JSONObject createJson(String filePath) {
        JSONObject jsonObject = new JSONObject();
        try {
            JSONParser parser = new JSONParser();
            StringBuilder buffer = new StringBuilder();
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                buffer.append(data);
            }
            Object json = parser.parse(String.valueOf(buffer));
            myReader.close();
            jsonObject = (JSONObject) json;
            System.out.print(json);
            return jsonObject;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return jsonObject;
    }



}
