package game;

import game.classes.MapPanel;
import game.classes.Window;

public class Game {

    public Game() {
        Window window = new Window();
        MapPanel mapPanel = new MapPanel(window.getMap().getTilesMap(),window.getMap().getTilesSize());
        window.add(mapPanel);
        mapPanel.requestFocus();
        window.setVisible(true);
    }

}
