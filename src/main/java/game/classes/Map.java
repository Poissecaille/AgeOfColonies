package game.classes;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Map {
    private final int maxMapSize = 10;
    private final int[] tilesSize = {64, 64};
    private final int[][] tilesMap;

    public int[][] getTilesMap() {
        return tilesMap;
    }

    public int getMaxMapSize() {
        return maxMapSize;
    }

    public int[] getTilesSize() {
        return tilesSize;
    }

    public Map(String file){
        this.tilesMap = new int[maxMapSize][maxMapSize];
        buildMatrix(readJsonFromFile(file));
    }
    public List<Integer> readJsonFromFile(String file) {
        try {
            String json = FileUtils.readFileToString(new File(file), "UTF-8");
            JSONObject object = new JSONObject(json);
            JSONObject layer = (JSONObject) object.getJSONArray("layers").get(0);
            List<Integer> arr = new ArrayList<>();
            for (Object i : layer.getJSONArray("data")){
                int value = (int) i;
                arr.add(value);
            }
            //System.out.print(Arrays.deepToString(tilesMap));
            return arr;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void buildMatrix(List<Integer> arr){
        for (int i = 0; i< maxMapSize; i++) {
            for (int j =0; j < maxMapSize; j++){
                tilesMap[i][j] = arr.get(i * maxMapSize + j);
            }
        }
    }

}
