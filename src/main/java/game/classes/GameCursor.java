package game.classes;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class GameCursor extends JPanel {
    private ImageIcon imageIcon;
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public GameCursor() {
        try {
            imageIcon = new ImageIcon(ImageIO.read(new File("C:\\Users\\PC\\IdeaProjects\\AgeOfColonies\\src\\main\\java\\game\\assets\\testCursor.png")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    protected void draw(Graphics graphics, ImageObserver imageObserver) {
        graphics.drawImage(imageIcon.getImage(), x, y, imageObserver);
    }

}
