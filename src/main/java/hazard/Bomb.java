package hazard;

import board.Tile;

import java.awt.Graphics2D;

/**
 * Abstract class representing a Bomb Hazard
 */
public abstract class Bomb {

    private int x;
    private int y;

    Bomb(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns this Bombs first index in the TestLevel.Tiles[][] array
     *
     * @return this Bombs first index in the TestLevel.Tiles[][] array
     */
    public int getIndexX() {
        return x / Tile.TILESIZE;
    }

    /**
     * Returns this Bombs second index in the TestLevel.Tiles[][] array
     *
     * @return this Bombs second index in the TestLevel.Tiles[][] array
     */
    public int getIndexY() {
        return y / Tile.TILESIZE;
    }

    /**
     * Returns this Bombs x position pixel value
     *
     * @return this Bombs x position pixel value
     */
    public final int getX() {
        return x;
    }

    /**
     * Returns this Bombs y position pixel value
     *
     * @return this Bombs y position pixel value
     */
    public final int getY() {
        return y;
    }

    /**
     * Defines action to take upon collision with Player
     */
    public abstract void onHit();

    /**
     * Redraws this Bombs Graphics
     *
     * @param g Graphics2D instance used for redrawing
     * @see Graphics2D
     */
    public abstract void update(final Graphics2D g);

}
