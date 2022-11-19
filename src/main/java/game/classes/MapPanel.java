package game.classes;

import javax.swing.*;
import java.awt.*;

public class MapPanel extends JPanel {
    private final GameCursor gameCursor;
    private final int[] tilesSize = {64, 64};
    private final int[][] matrix;

    private final int GRASS = 58;
    private int tileDeltaCameraX = 0;
    private int tileDeltaCameraY = 0;
    private int tileDeltaCursorX = 0;
    private int tileDeltaCursorY = 0;

    public MapPanel(int[][] tilesMap) {
        matrix = tilesMap;
        gameCursor = new GameCursor();
        this.add(gameCursor);
        addKeyListener(new MapKeyBoard(this));
    }


    public void moveCursorUp() {
        tileDeltaCursorY -= 1;
        repaint();
    }

    public void moveCursorDown() {
        tileDeltaCursorY += 1;
        repaint();
    }

    public void moveCursorRight() {
        tileDeltaCursorX += 1;
        repaint();
    }

    public void moveCursorLeft() {
        tileDeltaCursorX -= 1;
        repaint();
    }

    public void moveCameraUp() {
        tileDeltaCameraY += 1;
        repaint();
    }

    public void moveCameraDown() {
        tileDeltaCameraY -= 1;
        repaint();
    }

    public void moveCameraRight() {
        tileDeltaCameraX -= 1;
        repaint();
    }

    public void moveCameraLeft() {
        tileDeltaCameraX += 1;
        repaint();
    }

    public void paint(Graphics graphics) {
        super.paintComponent(graphics);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        String path = "";
        Image image = toolkit.getImage("");
        for (int row = 0; row < matrix.length; row++) {
            //System.out.print(Arrays.toString(this.matrix[row]) +"\n");
            for (int col = 0; col < matrix[row].length; col++) {
                // System.out.print(this.matrix[row][col] +"\n");
                switch (matrix[row][col]) {
                    case TilesMapping.VOID:
                        continue;
                    case TilesMapping.GRASS:
                        path = "C:\\Users\\PC\\IdeaProjects\\AgeOfColonies\\src\\main\\java\\game\\assets\\green.png";
                        image = toolkit.getImage(path);
                        break;
                    case TilesMapping.RIVER:
                        path = "C:\\Users\\PC\\IdeaProjects\\AgeOfColonies\\src\\main\\java\\game\\assets\\blue.png";
                        image = toolkit.getImage(path);
                        break;
                }
                graphics.drawImage(image, col * tilesSize[0] + tilesSize[0] * tileDeltaCameraX, row * tilesSize[1] + tilesSize[1] * tileDeltaCameraY, this);
            }
        }
        gameCursor.draw(graphics, tilesSize[0]*tileDeltaCursorX, tilesSize[1]*tileDeltaCursorY, this);
    }
}

