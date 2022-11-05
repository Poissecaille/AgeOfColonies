package game;

import game.classes.Config;
import game.classes.LevelGenerator;

public class Game {
     private Config config;
     public Game(){
          this.config = new Config();
          LevelGenerator levelGenerator = new LevelGenerator(config.getJsonMapFile());
//          GreenTile greenTile = new GreenTile();
//          window = new Window(WINDOW_WIDTH,WINDOW_HEIGHT);
//          window.add(greenTile);
     }



}
