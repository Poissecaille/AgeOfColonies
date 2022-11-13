package game.classes;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class MapPanel extends JPanel {
    private final int[] tilesSize = {64, 64};
    private int[][] matrix;
    private final int GRASS = 58;


    public MapPanel(int[][] tilesMap) {
        this.matrix = tilesMap;
        addKeyListener(new KeyBoard());
    }


    public void paint(Graphics graphics) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        //this.setLayout(new FlowLayout());
        Image image = toolkit.getImage("C:\\Users\\PC\\IdeaProjects\\AgeOfColonies\\src\\main\\java\\game\\assets\\green.png");
        for (int row = 0; row< this.matrix.length; row++) {
            //System.out.print(Arrays.toString(this.matrix[row]) +"\n");
            for (int col = 0; col < this.matrix[row].length; col++) {
               // System.out.print(this.matrix[row][col] +"\n");
                if (this.matrix[row][col] == this.GRASS){
                    graphics.drawImage(image, col*tilesSize[0], row*tilesSize[1], this);
                }
            }
        }

    }
}
