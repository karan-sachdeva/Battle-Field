package actor;

import board.Tile;
import image.Images;

import java.awt.Graphics2D;

/**
 * Represents a single heart unit of a players Health
 */
public final class HealthBar {

    private int x;
    private int y;

    /**
     * Initializes a HealthBar instance at position x, y
     *
     * @param x x position real pixel value
     * @param y y position real pixel value
     */
    public HealthBar(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns x position real pixel value
     *
     * @return x position real pixel value
     */
    public int getX() {
        return x;
    }

    /**
     * Returns y position real pixel value
     *
     * @return y position real pixel value
     */
    public int getY() {
        return y;
    }

    /**
     * Redraws this HealthBars graphics
     *
     * @param g Graphics2D used to redraw HealthBar graphics
     * @see Graphics2D
     */
    public void update(final Graphics2D g) {
        g.drawImage(Images.getHeartsImage(), getX(), getY(), Tile.TILESIZE, Tile.TILESIZE, null);
    }
}



