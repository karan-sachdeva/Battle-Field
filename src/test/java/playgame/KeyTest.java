package playgame;

import actor.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class KeyTest{

    public KeyTest(){
    }

    private Key test;
    private KeyEvent mockKeyEvent = mock(KeyEvent.class);

    @Before
    public void setup() {
        test = new Key();
        Player.setMovingDown(false);
        Player.setMovingUp(false);
        Player.setMovingLeft(false);
        Player.setMovingRight(false);
        Main.setPause(false);
    }

    @Test
    public void testKeyPressedDown(){
        when(mockKeyEvent.getKeyCode()).thenReturn(KeyEvent.VK_DOWN);
        Assert.assertFalse(Player.getMovingDown());
        test.keyPressed(mockKeyEvent);
        Assert.assertTrue(Player.getMovingDown());

    }

    @Test
    public void testKeyPressedUp(){
        when(mockKeyEvent.getKeyCode()).thenReturn(KeyEvent.VK_UP);
        Assert.assertFalse(Player.getMovingUp());
        test.keyPressed(mockKeyEvent);
        Assert.assertTrue(Player.getMovingUp());
    }

    @Test
    public void testKeyPressedLeft(){
        when(mockKeyEvent.getKeyCode()).thenReturn(KeyEvent.VK_LEFT);
        Assert.assertFalse(Player.getMovingLeft());
        test.keyPressed(mockKeyEvent);
        Assert.assertTrue(Player.getMovingLeft());
    }

    @Test
    public void testKeyPressedRight(){
        when(mockKeyEvent.getKeyCode()).thenReturn(KeyEvent.VK_RIGHT);
        Assert.assertFalse(Player.getMovingRight());
        test.keyPressed(mockKeyEvent);
        Assert.assertEquals(true,Player.getMovingRight());
    }

    @Test
    public void testKeyPressedPause(){
        when(mockKeyEvent.getKeyCode()).thenReturn(KeyEvent.VK_P);
        Assert.assertFalse(Main.getPause());
        test.keyPressed(mockKeyEvent);
        Assert.assertTrue(Main.getPause());
    }

    @Test
    public void testKeyReleasedDown(){
        when(mockKeyEvent.getKeyCode()).thenReturn(KeyEvent.VK_DOWN);
        Assert.assertFalse(Player.getMovingDown());
        test.keyPressed(mockKeyEvent);
        Assert.assertTrue(Player.getMovingDown());

        test.keyReleased(mockKeyEvent);
        Assert.assertFalse(Player.getMovingDown());
    }

    @Test
    public void testKeyReleasedUp(){
        when(mockKeyEvent.getKeyCode()).thenReturn(KeyEvent.VK_UP);
        Assert.assertFalse(Player.getMovingUp());
        test.keyPressed(mockKeyEvent);
        Assert.assertTrue(Player.getMovingUp());

        test.keyReleased(mockKeyEvent);
        Assert.assertFalse(Player.getMovingUp());
    }

    @Test
    public void testKeyReleasedLeft(){
        when(mockKeyEvent.getKeyCode()).thenReturn(KeyEvent.VK_LEFT);
        Assert.assertFalse(Player.getMovingLeft());
        test.keyPressed(mockKeyEvent);
        Assert.assertTrue(Player.getMovingLeft());

        test.keyReleased(mockKeyEvent);
        Assert.assertFalse(Player.getMovingLeft());
    }

    @Test
    public void testKeyReleasedRight(){
        when(mockKeyEvent.getKeyCode()).thenReturn(KeyEvent.VK_RIGHT);
        Assert.assertFalse(Player.getMovingRight());
        test.keyPressed(mockKeyEvent);
        Assert.assertTrue(Player.getMovingRight());

        test.keyReleased(mockKeyEvent);
        Assert.assertFalse(Player.getMovingRight());
    }

}
