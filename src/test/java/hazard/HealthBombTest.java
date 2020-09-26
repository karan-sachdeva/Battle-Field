package hazard;

import actor.Health;
import actor.Player;
import board.TestLevel;
import org.junit.Assert;
import org.junit.Test;
import playgame.Main;


public class HealthBombTest {
    @Test
    public void testHealthBombConstructor(){ //checks that placement of healthbomb works properly
        HealthBomb hb = new HealthBomb(32,32);
        Assert.assertEquals(1024, (int)hb.getX());
        Assert.assertEquals(1024, (int)hb.getY());
        Assert.assertEquals(32, (int)hb.getIndexX());
        Assert.assertEquals(32, (int)hb.getIndexY());
    }

    @Test
    public void onHit() {
        HealthBomb hb = new HealthBomb(8,10);
        //Health h = new Health();
        Health.initializeHealth();
        Health.update(null);
        TestLevel tl = new TestLevel(1);
        tl.addBomb(8, 10, hb);
        Player miss = new Player(10*32, 3*32);
        int[]currentTile = miss.currentTile();
        int dx = currentTile[0];
        int dy = currentTile[1];
        miss.collideContent(dx, dy);
        Assert.assertTrue(Main.getBomb().contains(hb));
        Assert.assertEquals(3, Health.getHeartsLeft());

        Player hit = new Player(8*32, 10*32);
        currentTile = hit.currentTile();
        dx = currentTile[0];
        dy = currentTile[1];
        hit.collideContent(dx, dy);
        Assert.assertFalse(Main.getBomb().contains(hb));
        Assert.assertEquals(2, Health.getHeartsLeft());


    }

    @Test
    public void update() {
    }
}
