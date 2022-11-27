package game.classes;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Infantry extends GameEntity{
    public Infantry(){
        this.type=GameEntityType.EARHTY;
        this.fuelLevel = 99;
        this.vision = 3;
        this.movement = 3;
        this.experience = 0;
        try {
            imageIcon = new ImageIcon(ImageIO.read(new File("C:\\Users\\PC\\IdeaProjects\\AgeOfColonies\\src\\main\\java\\game\\assets\\character.png")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    };
}
