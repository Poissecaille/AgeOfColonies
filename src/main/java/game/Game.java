package game;

import game.classes.MapPanel;
import game.classes.Window;

public class Game {
    private MapPanel mapPanel;
    private Window window;

    public Game() {
        this.window = new Window();
        this.mapPanel = new MapPanel(window.getMap().getTilesMap());
        this.window.add(mapPanel);
        //this.window.remove(mapPanel);
        //this.mapPanel.requestFocusInWindow();
        this.mapPanel.requestFocus();
    }


}
