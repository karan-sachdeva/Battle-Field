package reward;

import actor.Health;
import actor.Player;
import board.TestLevel;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class KeyRewardTest {
    @Test
    public void testKeyRewardConstructor(){ //checks that ScoreBomb placement works as intended
        KeyReward kr = new KeyReward(32,32);
        Assert.assertEquals(1024,(int)kr.getX());
        Assert.assertEquals(1024, (int)kr.getY());
    }

    @Test
    public void onHit() { //ensures that colliding with a key increases score and keycount
        Player player = new Player(3*32,4*32);
        TestLevel testLevel = new TestLevel(1);
        int[] currentTile = player.currentTile();
        int dx = currentTile[0];
        int dy = currentTile[1];


        Assert.assertEquals(0, Player.getScore());
        Assert.assertEquals(0, Player.getKeyCount());
        player.collideContent(dx, dy);
        Assert.assertEquals(100, Player.getScore());
        Assert.assertEquals(1, Player.getKeyCount());


    }

    @Test
    public void update() {
    }
}


