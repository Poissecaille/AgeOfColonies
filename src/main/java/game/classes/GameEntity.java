package game.classes;

public abstract class GameEntity {
    protected int health = 10;
    protected GameEntityType type;
    protected int movement;
    protected int fuelLevel;
    protected int vision;
    protected String imagePath;
    protected int experience;
}
