package base.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean W_pressed, W_justPressed;
    public boolean A_pressed, A_justPressed;
    public boolean D_pressed, D_justPressed;

    @Override
    public void keyTyped(KeyEvent e) {
        // not used
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> {
                W_pressed = true;
                W_justPressed = true;
            }
            case KeyEvent.VK_A -> {
                A_pressed = true;
                A_justPressed = true;
            }
            case KeyEvent.VK_D -> {
                D_pressed = true;
                D_justPressed = true;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> W_pressed = false;
            case KeyEvent.VK_A -> A_pressed = false;
            case KeyEvent.VK_D -> D_pressed = false;
        }
    }



    // reset variables
    public void update() {
        W_justPressed = false;
        A_justPressed = false;
        D_justPressed = false;
    }

}
