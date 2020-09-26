package actor;

import board.TestLevel;
import org.junit.Assert;
import org.junit.Test;
import playgame.Main;

import java.awt.*;

public class PlayerTest {
    @Test
    public void testPlayerConstructor()
    {
        Player player = new Player(32,16);
        Assert.assertEquals(32,  (int) Player.getX());
        Assert.assertEquals(16,  (int) Player.getY());
        Assert.assertTrue(Player.getCanLeft());
        Assert.assertTrue(Player.getCanRight());
        Assert.assertTrue(Player.getCanUp());
        Assert.assertTrue(Player.getCanDown());
    }

    @Test
    public void testGetBounds()     // test getBounds return correct result.
    {
        Player player = new Player(1,2);
        Rectangle rectangle = player.getBounds();
        Assert.assertEquals(1,rectangle.x);
        Assert.assertEquals(2,rectangle.y);
        Assert.assertEquals(32,rectangle.width);
        Assert.assertEquals(32,rectangle.height);
    }

    /*--------------------------------------Collision()------------------------------------------*/

    @Test
    public void testCurrentTile()
    {
        Player player = new Player(32,64);
        int[] currentTile = player.currentTile();
        Assert.assertEquals(1, currentTile[0]);
        Assert.assertEquals(2, currentTile[1]);

        Player.setX(47);
        Player.setY(79);
        currentTile = player.currentTile();
        Assert.assertEquals(1, currentTile[0]);
        Assert.assertEquals(2, currentTile[1]);

        Player.setX(48);
        Player.setY(80);
        currentTile = player.currentTile();
        Assert.assertEquals(2, currentTile[0]);
        Assert.assertEquals(3, currentTile[1]);

        Player.setX(49);
        Player.setY(81);
        currentTile = player.currentTile();
        Assert.assertEquals(2, currentTile[0]);
        Assert.assertEquals(3, currentTile[1]);
    }

    @Test
    public void testCollideEnemy() {
        new Main(1);
        Main.getEnemy().add(new Enemy(32, 32, 1));
        Player player = new Player(32, 32);
        Health.initializeHealth();

        Health.update(null);
        player.collideEnemy();
        Assert.assertEquals(88, (int) Health.getHp());
        Assert.assertEquals(3, Health.getHeartsLeft());
        Assert.assertEquals(2, Health.getIndex());

        Health.update(null);
        while(Health.getHp() > 30){
            player.collideEnemy();
        }
        Assert.assertEquals(30, (int) Health.getHp());
        Assert.assertEquals(2, Health.getHeartsLeft());
        Assert.assertEquals(2, Health.getIndex());

        Health.update(null);
        while(Health.getHp() > 15){
            player.collideEnemy();
        }
        Assert.assertEquals(15, (int) Health.getHp());
        Assert.assertEquals(1, Health.getHeartsLeft());
        Assert.assertEquals(1, Health.getIndex());

        Health.update(null);
        while(Health.getHp() > -1){
            player.collideEnemy();
        }
        Assert.assertEquals(-1, (int) Health.getHp());
        Assert.assertEquals(0, Health.getHeartsLeft());
        Assert.assertEquals(0, Health.getIndex());

    }


    @Test
    public void testCheckMoveCanLeft()
    {
        TestLevel level = new TestLevel(2);

        Player player = new Player(32,32);
        Assert.assertTrue(Player.getCanLeft());   // check initially canLeft is true
        player.checkMove();
        Assert.assertFalse(Player.getCanLeft());  // in level there is barrier in the left hand side of enemy, canLeft become false

        Player player2 = new Player(64,32);
        Assert.assertTrue(Player.getCanLeft());  // check initially canLeft is true
        player2.collision();
        Assert.assertTrue(Player.getCanLeft());  // in level there is no barrier in the left hand side of enemy2, canLeft should be true
    }

    @Test
    public void testCheckMoveCanRight()
    {
        TestLevel level = new TestLevel(2);

        Player player = new Player(32,64);
        Assert.assertTrue(Player.getCanRight());
        player.collision();
        Assert.assertFalse(Player.getCanRight());

        Player player2 = new Player(32,32);
        Assert.assertTrue(Player.getCanRight());
        player2.collision();
        Assert.assertTrue(Player.getCanRight());
    }

    @Test
    public void testCheckMoveCanUp()
    {
        TestLevel level = new TestLevel(2);

        Player player = new Player(32,32);
        Assert.assertTrue(Player.getCanUp());
        player.collision();
        Assert.assertFalse(Player.getCanUp());

        Player player2 = new Player(32,64);
        Assert.assertTrue(Player.getCanUp());  // check initially canLeft is true
        player2.collision();
        Assert.assertTrue(Player.getCanUp());
    }

    @Test
    public void testCollisionCanDown()
    {
        TestLevel level = new TestLevel(2);

        Player player = new Player(64,32);
        Assert.assertTrue(Player.getCanDown());
        player.collision();
        Assert.assertFalse(Player.getCanDown());

        Player player2 = new Player(32,32);
        Assert.assertTrue(Player.getCanDown());  // check initially canLeft is true
        player2.collision();
        Assert.assertTrue(Player.getCanDown());
    }
}

