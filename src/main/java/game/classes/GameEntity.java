package game.classes;

import javax.swing.*;
import java.awt.*;

public abstract class GameEntity extends JPanel {
    protected int health = 10;
    protected GameEntityType type;
    protected int movement;
    protected int fuelLevel;
    protected int vision;
    ImageIcon imageIcon;
    protected int experience;
    private int x;
    private int y;

    public GameEntityType getType() {
        return type;
    }

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
