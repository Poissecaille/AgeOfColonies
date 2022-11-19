package game.classes;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class GameCursor extends JPanel {
    private ImageIcon imageIcon;

    public GameCursor() {
        try {
            imageIcon = new ImageIcon(ImageIO.read(new File("C:\\Users\\PC\\IdeaProjects\\AgeOfColonies\\src\\main\\java\\game\\assets\\testCursor.png")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    protected void draw(Graphics graphics, int x, int y, ImageObserver imageObserver) {
        graphics.drawImage(imageIcon.getImage(), x, y, imageObserver);
    }

}
