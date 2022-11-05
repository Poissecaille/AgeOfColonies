package game.classes;

public class Config {
    private final int windowPixelWidth = 800;
    private final int windowPixelHeight = 600;
    private final String jsonMapFile = "C:\\Users\\PC\\IdeaProjects\\AgeOfColonies\\src\\main\\java\\game\\assets\\grass.json";

    public Config(){}

    public int getWindowPixelWidth() {
        return windowPixelWidth;
    }

    public int getWindowPixelHeight() {
        return windowPixelHeight;
    }

    public String getJsonMapFile() {
        return jsonMapFile;
    }
}