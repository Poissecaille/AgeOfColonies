package game.classes;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoard implements KeyListener {

    private KeyMapping mapping;
    private MapPanel mapPanel;

    public KeyBoard(MapPanel mapPanel){
        this.mapPanel=mapPanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println(e.getKeyCode());
        switch (e.getKeyCode()) {
            case KeyMapping.UP:
            case KeyMapping.UP2:
                System.out.println("UP");
                mapPanel.moveCameraUp();
                break;
            case KeyMapping.DOWN:
            case KeyMapping.DOWN2:
                System.out.println("DOWN");
                mapPanel.moveCameraDown();
                break;
            case KeyMapping.LEFT:
            case KeyMapping.LEFT2:
                System.out.println("LEFT");
                mapPanel.moveCameraLeft();
                break;
            case KeyMapping.RIGHT:
            case KeyMapping.RIGHT2:
                System.out.println("RIGHT");
                mapPanel.moveCameraRight();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
