package game.classes;

import javax.swing.*;

public abstract class GameEntity extends JPanel {
    protected int health = 10;
    protected GameEntityType type;
    protected int movement;
    protected int fuelLevel;
    protected int vision;
    protected String imagePath;
    protected int experience;
}
