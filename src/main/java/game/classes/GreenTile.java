package game.classes;

import java.awt.*;

public class GreenTile extends Canvas {
    public void paint(Graphics graphics) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage("C:\\Users\\PC\\IdeaProjects\\AgeOfColonies\\src\\main\\java\\game\\assets\\green.png");
        graphics.drawImage(image,0,0,this);
    }
}
