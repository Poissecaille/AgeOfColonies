package game.classes;

import javax.swing.*;
import java.awt.*;

public class MapPanel extends JPanel {
    private final GameCursor gameCursor;
    private GameEntity gameEntity;
    private final int[] tilesSize;
    private final int[][] matrix;
    private int x;
    private int y;

    public boolean checkSelectionIsPossible() {
        return gameCursor.getX() == gameEntity.getX() && gameCursor.getY() == gameEntity.getY();
    }

    public GameCursor getGameCursor() {
        return gameCursor;
    }

    public MapPanel(int[][] tilesMap, int[] tilesDimensions) {
        matrix = tilesMap;
        tilesSize = tilesDimensions;
        // INSTANCES TO MIGRATE IN ARRAYS LATER
        gameCursor = GameCursor.uniqueInstance();
        this.add(gameCursor);
        gameEntity = new Infantry();
        this.add(gameEntity);
        addKeyListener(new MapKeyBoard(this));
    }

    public void moveEarthyEntityUp() {
        if (gameEntity.getY() > 0 && matrix[gameEntity.getY() / tilesSize[0] - 1][gameEntity.getX() / tilesSize[1]] == TilesMapping.GRASS) {
            gameEntity.setY(gameEntity.getY() - tilesSize[1]);
            repaint();
        }
        //System.out.println(matrix[gameEntity.getY()/tilesSize[0]][gameEntity.getX()/tilesSize[1]]);
    }

    public void moveEarthyEntityDown() {
        if (gameEntity.getY() < tilesSize[1] * matrix[0].length - tilesSize[1] && matrix[gameEntity.getY() / tilesSize[0] + 1][gameEntity.getX() / tilesSize[1]] == TilesMapping.GRASS) {
            gameEntity.setY(gameEntity.getY() + tilesSize[1]);
            repaint();
        }
        //System.out.println(matrix[gameEntity.getY()/tilesSize[0]][gameEntity.getX()/tilesSize[1]]);
    }

    public void moveEarthyEntityRight() {
        if (gameEntity.getX() < tilesSize[0] * matrix[0].length - tilesSize[0] && matrix[gameEntity.getY() / tilesSize[0]][gameEntity.getX() / tilesSize[1] + 1] == TilesMapping.GRASS) {
            gameEntity.setX(gameEntity.getX() + tilesSize[0]);
            repaint();
        }
        //System.out.println(matrix[gameEntity.getY()/tilesSize[0]][gameEntity.getX()/tilesSize[1]]);
    }

    public void moveEarthyEntityLeft() {
        if (gameEntity.getX() > 0 && matrix[gameEntity.getY() / tilesSize[0]][gameEntity.getX() / tilesSize[1] - 1] == TilesMapping.GRASS) {
            gameEntity.setX(gameEntity.getX() - tilesSize[0]);
            repaint();
        }
        //System.out.println(matrix[gameEntity.getY()/tilesSize[0]][gameEntity.getX()/tilesSize[1]]);
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

    public void drawUiEntity(Graphics graphics, GameUiEntity gameUiEntity) {
        if (gameUiEntity.isVisible()) {
            graphics.drawImage(gameUiEntity.getImage(), gameUiEntity.getX(), gameUiEntity.getY(), this);
        }
    }

    public void drawEntity(Graphics graphics, GameEntity gameEntity) {
        if (gameEntity.isVisible()) {
            graphics.drawImage(gameEntity.getImage(), gameEntity.getX(), gameEntity.getY(), this);
        }
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
        drawUiEntity(graphics, gameCursor);
        drawEntity(graphics, gameEntity);
    }
}

