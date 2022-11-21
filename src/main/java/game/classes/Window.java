package game.classes;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private final Map map;

    public Map getMap() {
        return map;
    }

    public Window() {
        this.map = new Map("C:\\Users\\PC\\IdeaProjects\\AgeOfColonies\\src\\main\\java\\game\\assets\\test3.tmj");
        this.setTitle("AgeOfColonies");
        this.getContentPane().setPreferredSize(new Dimension(map.getMaxMapSize() * map.getTilesSize()[0], map.getMaxMapSize() * map.getTilesSize()[1]));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        //this.setUndecorated(true);
        this.pack();
        setVisible(true);
    }
}
