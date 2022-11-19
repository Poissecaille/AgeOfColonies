package game.classes;

import javax.swing.*;

public class Window extends JFrame {
    private final int[] tilesSize = {64, 64};
    private int maxNumberOfTiles = 10;
    private Map map;

    public Map getMap() {
        return map;
    }

    public Window() {
        this.map = new Map("C:\\Users\\PC\\IdeaProjects\\AgeOfColonies\\src\\main\\java\\game\\assets\\test3.tmj", maxNumberOfTiles);
        this.setTitle("AgeOfColonies");
        this.setSize(this.maxNumberOfTiles * tilesSize[0], this.maxNumberOfTiles * tilesSize[1]);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        setVisible(true);
    }
}
