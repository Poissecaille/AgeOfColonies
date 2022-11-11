package game.classes;

import javax.swing.*;

public class Window extends JFrame {
    private int tilesSize = 64;
    private int maxNumberOfTiles = 10;
    private Map map;
    public Window() {
        this.map = new Map("C:\\Users\\PC\\IdeaProjects\\AgeOfColonies\\src\\main\\resources\\test.json",maxNumberOfTiles);
        this.setSize(maxNumberOfTiles*tilesSize, maxNumberOfTiles*tilesSize);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
