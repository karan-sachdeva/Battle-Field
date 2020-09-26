package reward;

import actor.Player;
import board.TestLevel;
import org.junit.Assert;
import org.junit.Test;


public class FreezeTest {
    @Test
    public void testFreezeConstructor(){ //checks that ScoreBomb placement works as intended
        Freeze fr = new Freeze(32,32);
        Assert.assertEquals(1024,(int)fr.getX());
        Assert.assertEquals(1024, (int)fr.getY());
    }

    @Test
    public void onHit() { //checks whether collision with a freezeReward works properly
        Freeze fr = new Freeze(3,16);
        TestLevel tl = new TestLevel(1);
        tl.addReward(3, 16, fr);

        Player player = new Player(3*32,16*32);
        int[] currentTile = player.currentTile();
        int dx = currentTile[0];
        int dy = currentTile[1];

        Assert.assertEquals(0,Player.getScore());
        player.collideContent(dx,dy);
        Assert.assertEquals(150,Player.getScore());

    }

}



