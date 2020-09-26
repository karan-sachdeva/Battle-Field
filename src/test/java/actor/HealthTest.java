package actor;

import actor.Health;
import actor.HealthBar;
import org.junit.Assert;
import org.junit.Test;
import playgame.Main;

public class HealthTest {

    @Test
    public void testHealthConstructor()
    {
        //Health health = new Health();
        Health.initializeHealth();
        Assert.assertEquals(3, Health.getBar().size());
    }
}
