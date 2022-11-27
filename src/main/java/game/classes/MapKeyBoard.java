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

    private boolean selection = false;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        pressedKeys.add(e.getKeyCode());
        //System.out.println(e.getKeyCode());
        if (!selection) {
            if (pressedKeys.contains(KeyMapping.ENTER) && mapPanel.checkSelectionIsPossible()
            ) {
                selection = true;
                mapPanel.getGameCursor().setVisible(false);
            }
            else if (pressedKeys.contains(KeyMapping.CONTROL) && pressedKeys.contains(KeyMapping.UP)) {
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
        } else {
            if (pressedKeys.contains(KeyMapping.ENTER)){
                selection = false;
                mapPanel.getGameCursor().setVisible(true);
            }
            else if (pressedKeys.contains(KeyMapping.UP)) {
                mapPanel.moveEarthyEntityUp();
            } else if (pressedKeys.contains(KeyMapping.DOWN)) {
                mapPanel.moveEarthyEntityDown();
            } else if (pressedKeys.contains(KeyMapping.LEFT)) {
                mapPanel.moveEarthyEntityLeft();
            } else if (pressedKeys.contains(KeyMapping.RIGHT)) {
                mapPanel.moveEarthyEntityRight();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        pressedKeys.remove(e.getKeyCode());
    }
}
