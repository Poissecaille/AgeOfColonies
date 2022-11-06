package game.classes;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Drawing extends Canvas {
    private final int[] tilesSize = {64, 64};
    private final int[] matrix = {58, 0, 58, 58, 0};

    public Drawing() {
    }

    public void readJsonFromFile(String file) {
        try {
            String json = FileUtils.readFileToString(new File(file), "UTF-8");
            JSONObject object = new JSONObject(json);
            JSONArray layers = object.getJSONArray("layers");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void paint(Graphics graphics) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage("C:\\Users\\PC\\IdeaProjects\\AgeOfColonies\\src\\main\\java\\game\\assets\\green.png");
        int numberOfTiles = 0;
        for (int i : this.matrix) {
            if (i == 58) {
                graphics.drawImage(image, numberOfTiles * tilesSize[0], 0, this);
            }
            numberOfTiles++;
        }
    }
}
