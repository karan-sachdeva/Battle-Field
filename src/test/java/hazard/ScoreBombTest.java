package hazard;

import actor.Player;
import board.TestLevel;
import org.junit.Assert;
import org.junit.Test;
import playgame.Main;


public class ScoreBombTest {
    @Test
    public void testScoreBombConstructor(){ //checks that ScoreBomb placement works as intended
        ScoreBomb sb = new ScoreBomb(32,32);
        Assert.assertEquals(1024, (int)sb.getX());
        Assert.assertEquals(1024, (int)sb.getY());
        Assert.assertEquals(32, (int)sb.getIndexX());
        Assert.assertEquals(32, (int)sb.getIndexY());

    }


    @Test
    public void onHit() {
        ScoreBomb sb = new ScoreBomb(11,3);
        TestLevel tl = new TestLevel(1);
        tl.addBomb(11, 3, sb);
        Player miss = new Player(10*32, 3*32);
        int[]currentTile = miss.currentTile();
        int dx = currentTile[0];
        int dy = currentTile[1];
        miss.collideContent(dx, dy);
        Assert.assertTrue(Main.getBomb().contains(sb));
        Assert.assertEquals(0, Player.getScore());

        Player hit = new Player(11*32, 3*32);
        currentTile = hit.currentTile();
        dx = currentTile[0];
        dy = currentTile[1];
        hit.collideContent(dx, dy);
        Assert.assertFalse(Main.getBomb().contains(sb));
        Assert.assertEquals(-200, Player.getScore());
    }

    @Test
    public void update() {
    }
}


