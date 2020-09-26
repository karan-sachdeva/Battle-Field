package actor;


import board.TestLevel;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;


public class EnemyTest {

    @Test
    public void testEnemyConstructor()
    {
        Enemy enemy = new Enemy(32,16, 1);
        Assert.assertEquals(32, enemy.getX());
        Assert.assertEquals(16, enemy.getY());
        Assert.assertEquals(0, enemy.getFrozenTimer());
        Assert.assertTrue(enemy.getCanLeft());
        Assert.assertTrue(enemy.getCanRight());
        Assert.assertTrue(enemy.getCanUp());
        Assert.assertTrue(enemy.getCanDown());
    }

    @Test
    public void testGetBounds()     // test getBounds return correct result.
    {
        Enemy enemy = new Enemy(1,2, 1);
        Rectangle rectangle = enemy.getBounds();
        Assert.assertEquals(1,rectangle.x);
        Assert.assertEquals(2,rectangle.y);
        Assert.assertEquals(32,rectangle.width);
        Assert.assertEquals(32,rectangle.height);
    }


    /*--------------------------------------Collision()------------------------------------------*/

    @Test
    public void testCollisionCanLeft()      // test canLeft in collision
    {
        TestLevel level = new TestLevel(2);

        Enemy enemy = new Enemy(32,32, 1);
        Assert.assertTrue(enemy.getCanLeft());   // check initially canLeft is true
        enemy.collision();
        Assert.assertFalse(enemy.getCanLeft());  // in level there is barrier in the left hand side of enemy, canLeft become false

        Enemy enemy2 = new Enemy(64,32, 1);
        Assert.assertTrue(enemy2.getCanLeft());  // check initially canLeft is true
        enemy2.collision();
        Assert.assertTrue(enemy2.getCanLeft());  // in level there is no barrier in the left hand side of enemy2, canLeft should be true
    }

    @Test
    public void testCollisionCanRight()
    {
        TestLevel level = new TestLevel(2);

        Enemy enemy = new Enemy(32,64, 1);
        Assert.assertTrue(enemy.getCanRight());
        enemy.collision();
        Assert.assertFalse(enemy.getCanRight());

        Enemy enemy2 = new Enemy(32,32, 1);
        Assert.assertTrue(enemy2.getCanRight());
        enemy2.collision();
        Assert.assertTrue(enemy2.getCanRight());
    }

    @Test
    public void testCollisionCanUp()
    {
        TestLevel level = new TestLevel(2);

        Enemy enemy = new Enemy(32,32, 1);
        Assert.assertTrue(enemy.getCanUp());
        enemy.collision();
        Assert.assertFalse(enemy.getCanUp());

        Enemy enemy2 = new Enemy(32,64, 1);
        Assert.assertTrue(enemy2.getCanUp());  // check initially canLeft is true
        enemy2.collision();
        Assert.assertTrue(enemy2.getCanUp());
    }

    @Test
    public void testCollisionCanDown()
    {
        TestLevel level = new TestLevel(2);

        Enemy enemy = new Enemy(64,32, 1);
        Assert.assertTrue(enemy.getCanDown());
        enemy.collision();
        Assert.assertFalse(enemy.getCanDown());

        Enemy enemy2 = new Enemy(32,32, 1);
        Assert.assertTrue(enemy2.getCanDown());  // check initially canLeft is true
        enemy2.collision();
        Assert.assertTrue(enemy2.getCanDown());
    }

    @Test
    public void testCheckFrozen()
    {
        Enemy enemy = new Enemy(64,32, 1);
        enemy.checkFrozen();
        Assert.assertFalse(Enemy.getIsFrozen());
        Assert.assertEquals(0, enemy.getFrozenTimer());

        enemy.setFrozenTimer(2);
        enemy.checkFrozen();
        Assert.assertTrue(Enemy.getIsFrozen());
        Assert.assertEquals(1, enemy.getFrozenTimer());
        enemy.checkFrozen();
        Assert.assertTrue(Enemy.getIsFrozen());
        Assert.assertEquals(0, enemy.getFrozenTimer());
        enemy.checkFrozen();
        Assert.assertFalse(Enemy.getIsFrozen());
        Assert.assertEquals(0, enemy.getFrozenTimer());
    }


    /*-----------------------------------chasingHero()----------------------------------------*/

    @Test
    public void testChasingHero()
    {
        Enemy enemy = new Enemy(64, 128, 1);
        Player hero = new Player(32,32);

        enemy.setFrozenTimer(0);
        enemy.chasingHero(null);          // enemy will chasing hero by left and up direction
        Assert.assertEquals(63, enemy.getX());
        Assert.assertEquals(127, enemy.getY());

        Player.setX(256);   // change hero position
        Player.setY(300);

        enemy.chasingHero(null);          // enemy will chasing hero by right and down direction
        Assert.assertEquals(64, enemy.getX());
        Assert.assertEquals(128, enemy.getY());
    }
}