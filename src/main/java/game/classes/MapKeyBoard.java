package game.classes;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class MapKeyBoard implements KeyListener {

    private final MapPanel mapPanel;

    public MapKeyBoard(MapPanel panel) {
        mapPanel = panel;
    }

    private final Set<Integer> pressedKeys = new HashSet<>();

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        pressedKeys.add(e.getKeyCode());
        if (pressedKeys.contains(KeyMapping.CONTROL) && pressedKeys.contains(KeyMapping.UP)) {
            mapPanel.moveCursorUp();
        } else if (pressedKeys.contains(KeyMapping.CONTROL) && pressedKeys.contains(KeyMapping.DOWN)) {
            mapPanel.moveCursorDown();
        } else if (pressedKeys.contains(KeyMapping.CONTROL) && pressedKeys.contains(KeyMapping.LEFT)) {
            mapPanel.moveCursorLeft();
        } else if (pressedKeys.contains(KeyMapping.CONTROL) && pressedKeys.contains(KeyMapping.RIGHT)) {
            mapPanel.moveCursorRight();
        } else if (!pressedKeys.contains(KeyMapping.CONTROL) && pressedKeys.contains(KeyMapping.UP)) {
            mapPanel.moveCameraUp();
        } else if (!pressedKeys.contains(KeyMapping.CONTROL) && pressedKeys.contains(KeyMapping.DOWN)) {
            mapPanel.moveCameraDown();
        } else if (!pressedKeys.contains(KeyMapping.CONTROL) && pressedKeys.contains(KeyMapping.LEFT)) {
            mapPanel.moveCameraLeft();
        } else if (!pressedKeys.contains(KeyMapping.CONTROL) && pressedKeys.contains(KeyMapping.RIGHT)) {
            mapPanel.moveCameraRight();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        pressedKeys.remove(e.getKeyCode());
    }
}
