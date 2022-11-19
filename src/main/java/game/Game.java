package game;

import game.classes.MapPanel;
import game.classes.Window;

public class Game {
    private MapPanel mapPanel;
    private Window window;

    public Game() {
        window = new Window();
        mapPanel = new MapPanel(window.getMap().getTilesMap());
        window.add(mapPanel);
        mapPanel.requestFocus();
        window.setVisible(true);
    }

}
