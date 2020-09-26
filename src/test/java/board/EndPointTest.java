package board;

import actor.Player;
import org.junit.Assert;
import org.junit.Test;
import playgame.Main;

public class EndPointTest {

    @Test
    public void insufficientKeyCount(){
        new Main(1);
        EndPoint test = new EndPoint();
        test.onHit();
        Assert.assertTrue(Main.getRunning());
    }

    @Test
    public void sufficientKeyCount(){
        new Main(1);
        EndPoint test = new EndPoint();
        for(int i = 0; i < EndPoint.getRequiredKeys(); i++) {
            Player.IncreaseKeyCount();
        }
        test.onHit();
        Assert.assertFalse(Main.getRunning());
    }

}

