package actor;

import actor.HealthBar;
import org.junit.Assert;
import org.junit.Test;

public class HealthBarTest {
    @Test
    public void testHealthBarConstructor()
    {
        HealthBar healthbar = new HealthBar(32,16);
        Assert.assertEquals(32,healthbar.getX());
        Assert.assertEquals(16,healthbar.getY());
    }
}
