package game.classes;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class GameCursor extends GameUiEntity {
    private static GameCursor INSTANCE;
    private GameCursor() {
        try {
            imageIcon = new ImageIcon(ImageIO.read(new File("C:\\Users\\PC\\IdeaProjects\\AgeOfColonies\\src\\main\\java\\game\\assets\\testCursor.png")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static GameCursor uniqueInstance(){
        if(INSTANCE == null){
            INSTANCE = new GameCursor();
        }
        return INSTANCE;
    }

}
