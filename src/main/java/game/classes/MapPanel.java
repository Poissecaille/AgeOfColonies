package game.classes;

import javax.swing.*;
import java.awt.*;

public class MapPanel extends JPanel {
    private final int[] tilesSize = {64, 64};
    private int[][] matrix;
    private final int GRASS = 58;
    private int tileDeltaX = 0;
    private int tileDeltaY = 0;
    public MapPanel(int[][] tilesMap) {
        this.matrix = tilesMap;
        addKeyListener(new KeyBoard(this));
    }

    public void moveCameraUp(){
        this.tileDeltaY += 1;
        repaint();
    }

    public void moveCameraDown(){
        this.tileDeltaY -= 1;
        repaint();
    }

    public void moveCameraRight(){
        this.tileDeltaX -= 1;
        repaint();
    }

    public void moveCameraLeft(){
        this.tileDeltaX += 1;
        repaint();
    }

    public void paint(Graphics graphics) {
        super.paintComponent(graphics);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        //this.setLayout(new FlowLayout());
        Image image = toolkit.getImage("C:\\Users\\PC\\IdeaProjects\\AgeOfColonies\\src\\main\\java\\game\\assets\\green.png");
        for (int row = 0; row< this.matrix.length; row++) {
            //System.out.print(Arrays.toString(this.matrix[row]) +"\n");
            for (int col = 0; col < this.matrix[row].length; col++) {
               // System.out.print(this.matrix[row][col] +"\n");
                if (this.matrix[row][col] == this.GRASS){
                    graphics.drawImage(image, col*tilesSize[0] + tilesSize[0] * this.tileDeltaX, row*tilesSize[1] + tilesSize[1] * this.tileDeltaY, this);
                }
            }
        }
    }
}
