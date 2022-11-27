package game.classes;

import javax.swing.*;
import java.awt.*;

public abstract class GameUiEntity extends JPanel {
    ImageIcon imageIcon;
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

    public Image getImage() {
        return imageIcon.getImage();
    }
}
