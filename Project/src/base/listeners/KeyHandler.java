package base.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean W_justPressed;
    public boolean A_justPressed;
    public boolean D_justPressed;

    @Override
    public void keyTyped(KeyEvent e) {
        // not used
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> W_justPressed = true;
            case KeyEvent.VK_A -> A_justPressed = true;
            case KeyEvent.VK_D -> D_justPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // not used
    }



    // reset variables
    public void update() {
        W_justPressed = false;
        A_justPressed = false;
        D_justPressed = false;
    }

}
