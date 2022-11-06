package game;

import game.classes.Drawing;
import game.classes.Window;

public class Game {
    private final int[] screenSize = {800, 800};

    public Game() {
        Window window = new Window(screenSize[0], screenSize[1]);
        window.add(new Drawing());
    }


}
