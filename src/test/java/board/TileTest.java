package board;

import java.awt.Rectangle;
import org.junit.Assert;
import org.junit.Test;

public class TileTest {

    @Test
    public void TileConstructor(){
        Rectangle rec = new Rectangle(10, 20, 30, 35);
        Tile<Boolean> test = new Tile<>(-1, rec, false, Boolean.FALSE);

        Assert.assertEquals(-1, test.getId());
        Assert.assertFalse(test.isBarrier());
        Assert.assertEquals(Boolean.FALSE, test.getContents());
        Assert.assertEquals(10, test.getTileX());
        Assert.assertEquals(20, test.getTileY());
        Assert.assertEquals(30, test.getTileWidth());
        Assert.assertEquals(35, test.getTileHeight());

    }


    @Test
    public void getBounds(){
        Rectangle rec = new Rectangle(10, 20, 30, 30);
        Tile<Boolean> test = new Tile<>(-1, rec, false, Boolean.FALSE);

        Assert.assertEquals(rec.getBounds(), test.getBounds());
    }

    @Test
    public void hasContents(){
        Tile<Void> testVoid = new Tile<>(-1, new Rectangle(), false, null);
        Tile<Boolean> testItem = new Tile<>(-1, new Rectangle(), false, Boolean.TRUE);

        Assert.assertFalse(testVoid.hasContents());
        Assert.assertTrue(testItem.hasContents());
    }

    @Test
    public void getContents(){
        Tile<Void> testVoid = new Tile<>(-1, new Rectangle(), false, null);
        Tile<Boolean> testItem = new Tile<>(-1, new Rectangle(), false, Boolean.TRUE);

        Assert.assertNull(testVoid.getContents());
        Assert.assertEquals(Boolean.TRUE, testItem.getContents());
    }


}
