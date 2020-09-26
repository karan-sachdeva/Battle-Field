package playgame;

import actor.Player;
import window.PauseMenu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * Implementation of Java {@link KeyListener} interface.
 */
public final class Key implements KeyListener {

    public Key() {}

    /**
     *Handles KeyEvents detected from user input.
     * @param e KeyEvent from keyboard input.
     */
    public void keyPressed(final KeyEvent e) {
        if (!Main.getPause()) {
            int k = e.getKeyCode();

            if (k == KeyEvent.VK_LEFT){ Player.setMovingLeft(true); }
            if (k == KeyEvent.VK_RIGHT){ Player.setMovingRight(true); }
            if (k == KeyEvent.VK_UP){ Player.setMovingUp(true); }
            if (k == KeyEvent.VK_DOWN){ Player.setMovingDown(true); }
            if (k == KeyEvent.VK_P){ new PauseMenu(); }
        }
    }

    /**
     *Specifies behaviour upon user releasing a key.
     * @param e KeyEvent from keyboard input.
     */
    public void keyReleased(final KeyEvent e) {
        if (!Main.getPause()) {
            int k = e.getKeyCode();

            if (k == KeyEvent.VK_LEFT) Player.setMovingLeft(false);
            if (k == KeyEvent.VK_RIGHT) Player.setMovingRight(false);
            if (k == KeyEvent.VK_UP) Player.setMovingUp(false);
            if (k == KeyEvent.VK_DOWN) Player.setMovingDown(false);
        }
    }


    public void keyTyped(KeyEvent e) {}
}

