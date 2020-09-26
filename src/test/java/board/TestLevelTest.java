package board;

import hazard.HealthBomb;
import hazard.ScoreBomb;
import org.junit.Assert;
import playgame.Main;
import reward.Freeze;
import reward.HealthReward;
import reward.KeyReward;
import org.junit.Test;

public class TestLevelTest {

    @Test
    public void addGrass(){
        TestLevel test = new TestLevel(1);
        TestLevel.addGrass(1,1);

        Assert.assertFalse(TestLevel.getTiles()[1][1].hasContents());
        Assert.assertNull(TestLevel.getTiles()[1][1].getContents());
        Assert.assertFalse(TestLevel.getTiles()[1][1].isBarrier());
        Assert.assertEquals( 1, TestLevel.getTiles()[1][1].getId());

    }

    @Test
    public void addBombs(){
        TestLevel test = new TestLevel(2);
        HealthBomb hb = new HealthBomb(1, 1);
        ScoreBomb sb = new ScoreBomb(16, 4);
        test.addBomb(1,1, hb);
        test.addBomb(16,4, sb);

        Assert.assertTrue(TestLevel.getTiles()[1][1].hasContents());
        Assert.assertEquals(hb,TestLevel.getTiles()[1][1].getContents());
        Assert.assertFalse(TestLevel.getTiles()[1][1].isBarrier());
        Assert.assertEquals( 1, TestLevel.getTiles()[1][1].getId());

        Assert.assertTrue(TestLevel.getTiles()[16][4].hasContents());
        Assert.assertEquals(sb, TestLevel.getTiles()[16][4].getContents());
        Assert.assertFalse(TestLevel.getTiles()[16][4].isBarrier());
        Assert.assertEquals( 1, TestLevel.getTiles()[16][4].getId());

        Assert.assertTrue(Main.getBomb().contains(hb));
        Assert.assertTrue(Main.getBomb().contains(sb));
    }

    @Test
    public void addRewards(){
        TestLevel test = new TestLevel(1);
        KeyReward key = new KeyReward(1, 1);
        Freeze fz = new Freeze(1,1);
        HealthReward hp = new HealthReward(1,1);
        test.addReward(1,1, key);
        test.addReward(3,4, fz);
        test.addReward(5,10, hp);

        Assert.assertTrue(TestLevel.getTiles()[1][1].hasContents());
        Assert.assertEquals(key,TestLevel.getTiles()[1][1].getContents());
        Assert.assertFalse(TestLevel.getTiles()[1][1].isBarrier());
        Assert.assertEquals( 1, TestLevel.getTiles()[1][1].getId());

        Assert.assertTrue(TestLevel.getTiles()[3][4].hasContents());
        Assert.assertEquals(fz, TestLevel.getTiles()[3][4].getContents());
        Assert.assertFalse(TestLevel.getTiles()[3][4].isBarrier());
        Assert.assertEquals( 1, TestLevel.getTiles()[3][4].getId());

        Assert.assertTrue(TestLevel.getTiles()[5][10].hasContents());
        Assert.assertEquals(hp, TestLevel.getTiles()[5][10].getContents());
        Assert.assertFalse(TestLevel.getTiles()[5][10].isBarrier());
        Assert.assertEquals( 1, TestLevel.getTiles()[5][10].getId());


        Assert.assertTrue(Main.getRewards().contains(key));
        Assert.assertTrue(Main.getRewards().contains(fz));
        Assert.assertTrue(Main.getRewards().contains(hp));
    }

    @Test
    public void setEndPoint(){
        TestLevel test = new TestLevel(2);
        EndPoint end = new EndPoint();
        test.setEndPoint(1,1, end);

        Assert.assertTrue(TestLevel.getTiles()[1][1].hasContents());
        Assert.assertEquals(end,TestLevel.getTiles()[1][1].getContents());
        Assert.assertFalse(TestLevel.getTiles()[1][1].isBarrier());
        Assert.assertEquals( 0, TestLevel.getTiles()[1][1].getId());
    }


}
