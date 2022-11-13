package game;

import game.classes.Drawing;
import game.classes.Window;

public class Game {

    public Game() {
        Window window = new Window();
        window.add(new Drawing(window.getMap().getTilesMap()));
    }


}
