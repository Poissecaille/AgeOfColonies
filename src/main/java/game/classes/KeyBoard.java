package game.classes;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoard implements KeyListener {

    private KeyMapping mapping;

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
                break;
            case KeyMapping.DOWN:
            case KeyMapping.DOWN2:
                System.out.println("DOWN");
                break;
            case KeyMapping.LEFT:
            case KeyMapping.LEFT2:
                System.out.println("LEFT");
                break;
            case KeyMapping.RIGHT:
            case KeyMapping.RIGHT2:
                System.out.println("RIGHT");
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
