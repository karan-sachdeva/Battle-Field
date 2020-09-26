package reward;

import board.Tile;

import java.awt.Graphics2D;

/**
 * Abstract class representing a Reward component
 */
public abstract class Reward {
    private int x;
    private int y;
    private int value;

    /**
     * Initializes Reward instance at position x, y
     *
     * @param dx x position real pixel value
     * @param dy y position real pixel value
     */
    public Reward(final int dx, final int dy) {
        x = dx;
        y = dy;
    }

    /**
     * Abstract method that defines collision with Player behaviour for this Reward
     *
     * @see actor.Player
     */
    public abstract void onHit();

    /**
     * Abstract method that defines how to draw this Reward instance
     *
     * @param g Graphics2D instance used to draw graphics
     */
    public abstract void update(final Graphics2D g);

    /**
     * Returns the x index of the Tile currently occupied by this Reward instance
     *
     * @return x index of the Tile currently occupied by this Reward instance as an int
     * @see Tile
     * @see board.TestLevel
     */
    public final int getXIndex() {
        return (int) (x / Tile.TILESIZE);
    }

    ;

    /**
     * Returns the y index of the Tile currently occupied by this Reward instance
     *
     * @return y index of the Tile currently occupied by this Reward instance as an int
     * @see Tile
     * @see board.TestLevel
     */
    public final int getYIndex() {
        return (int) (y / Tile.TILESIZE);
    }

    ;

    /**
     * Returns the x position real pixel value
     *
     * @return x position real pixel value as an int
     */
    public final int getX() {
        return x;
    }

    ;

    /**
     * Returns the y position real pixel value
     *
     * @return y position real pixel value as an int
     */
    public final int getY() {
        return y;
    }

    ;

    /**
     * Returns the score value of this Reward
     *
     * @return the score value of this Reward as an int
     * @see actor.Score
     */
    public final int getValue() {
        return value;
    }

    /**
     * Sets the score value of this Reward
     *
     * @param amount new score int value of this Reward
     * @see actor.Score
     */
    public final void setValue(int amount) {
        value = amount;
    }
}
