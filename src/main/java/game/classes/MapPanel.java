package game.classes;

import javax.swing.*;
import java.awt.*;

public class MapPanel extends JPanel {
    private final GameCursor gameCursor;
    private final int[] tilesSize = {64, 64};
    private final int[][] matrix;

    private final int GRASS = 58;
    private int x;
    private int y;

    public MapPanel(int[][] tilesMap) {
        matrix = tilesMap;
        gameCursor = new GameCursor();
        this.add(gameCursor);
        addKeyListener(new MapKeyBoard(this));
    }


    public void moveCursorUp() {
        if (gameCursor.getY() > 0) {
            gameCursor.setY(gameCursor.getY() - tilesSize[1]);
            repaint();
        }
    }

    public void moveCursorDown() {
        if (gameCursor.getY() < tilesSize[1] * matrix[0].length - tilesSize[1]) {
            gameCursor.setY(gameCursor.getY() + tilesSize[1]);
            repaint();
        }
    }

    public void moveCursorRight() {
        if (gameCursor.getX() < tilesSize[0] * matrix[0].length - tilesSize[0]) {
            gameCursor.setX(gameCursor.getX() + tilesSize[0]);
            repaint();
        }
    }

    public void moveCursorLeft() {
        if (gameCursor.getX() > 0) {
            gameCursor.setX(gameCursor.getX() - tilesSize[0]);
            repaint();
        }
    }

    public void moveCameraUp() {
        y += tilesSize[1];
        repaint();
    }

    public void moveCameraDown() {
        y -= tilesSize[1];
        repaint();
    }

    public void moveCameraRight() {
        x -= tilesSize[0];
        repaint();
    }

    public void moveCameraLeft() {
        x += tilesSize[0];
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
                graphics.drawImage(image, col * tilesSize[0] + x, row * tilesSize[1] + y, this);
            }
        }
        gameCursor.draw(graphics, this);
    }
}

