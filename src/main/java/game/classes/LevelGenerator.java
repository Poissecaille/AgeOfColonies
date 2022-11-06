package game.classes;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class LevelGenerator {
    Integer [][][] layers;
    public LevelGenerator(String file){
        this.createJson(file);
    }

    public Integer[][][] getLayer() {
        return layers;
    }

    public void setLayer(Integer[][][] layers) {
        this.layers = layers;
    }

    public void createJson (String filePath)  {
        JSONParser parser = new JSONParser();
        List<Object> matrix = new ArrayList<>();
        try{
            FileReader file = new FileReader(filePath);
            Object obj = parser.parse(file);
            JSONObject jsonObject = (JSONObject)obj;
            JSONArray values = (JSONArray)jsonObject.get("layers");
            for (int i = 0; i<values.size();i++){
                JSONObject current = (JSONObject) values.get(i);
                matrix.add(current.get("data"));
            }
           System.out.print(matrix);
            file.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException | IOException e) {
            throw new RuntimeException(e);
        }
    }

//        try {
//            StringBuilder buffer = new StringBuilder();
//            File myObj = new File(filePath);
//            Scanner myReader = new Scanner(myObj);
//            while (myReader.hasNextLine()) {
//                String data = myReader.nextLine();
//                buffer.append(data);
//            }
//            Object json = parser.parse(String.valueOf(buffer));
//            myReader.close();
//            jsonObject = (JSONObject) json;
//            JSONArray jsonArray = (JSONArray) jsonObject.get("layers");
//            System.out.print(jsonArray);
//            return jsonObject;
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
//        return jsonObject;




}
