package actor;

import board.TestLevel;
import board.Tile;
import image.Images;

import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * Represents an Enemy
 */
public final class Enemy {

    private int x;
    private int y;
    private int speed = 1;
    private int enemyImageId;
    private boolean canUp;
    private boolean canDown;
    private boolean canRight;
    private boolean canLeft;
    private static boolean isFrozen = false;
    private int frozenTimer;
    private static final int SIZE = 32;

    private static final float DAMAGE = 0.5f;

    /**
     * Initializes Enemy instance at positions x, y, with sprite corresponding to imageId
     *
     * @param x       x position real pixel value
     * @param y       y position real pixel value
     * @param imageId ID of which sprite to load from Images
     * @see Images
     */
    public Enemy(final int x, final int y, final int imageId) {
        this.x = x;
        this.y = y;
        enemyImageId = imageId;
        canUp = true;
        canDown = true;
        canLeft = true;
        canRight = true;
        frozenTimer = 0;
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
     * Returns whether this Enemy can move up on the board
     *
     * @return boolean value determining this Enemy's ability to move up
     */
    public boolean getCanUp() {
        return canUp;
    }

    /**
     * Returns whether this Enemy can move down on the board
     *
     * @return boolean value determining this Enemy's ability to move down
     */
    public boolean getCanDown() {
        return canDown;
    }

    /**
     * Returns whether this Enemy can move left on the board
     *
     * @return boolean value determining this Enemy's ability to move left
     */
    public boolean getCanLeft() {
        return canLeft;
    }

    /**
     * Returns whether this Enemy can move right on the board
     *
     * @return boolean value determining this Enemy's ability to move right
     */
    public boolean getCanRight() {
        return canRight;
    }

    /**
     * Returns amount of damage enemies deals as a float
     *
     * @return amount of damage enemies deals as a float
     */
    public static float getDamage() {
        return DAMAGE;
    }

    /**
     * Returns amount of time this Enemy will be frozen for as an int
     *
     * @return amount of time this Enemy will be frozen for as an int
     */
    public int getFrozenTimer() {
        return frozenTimer;
    }

    /**
     * Sets the amount of time this Enemy will be frozen for
     *
     * @param time integer value for amount of time this Enemy will be frozen for
     */
    public void setFrozenTimer(int time) {
        frozenTimer = time;
    }

    /**
     * Returns whether or not Enemies are frozen
     *
     * @return boolean value isFrozen
     */
    public static boolean getIsFrozen() {
        return isFrozen;
    }

    /**
     * Sets whether or not enemies are frozen
     *
     * @param b new boolean value for whether enemies are frozen or not
     */
    public static void setIsFrozen(boolean b) {
        isFrozen = b;
    }

    /**
     * Returns this Enemy's bounding Rectangle
     *
     * @return this Enemy's bounding Rectangle
     * @see Rectangle
     */
    public Rectangle getBounds() {
        return new Rectangle(x, y, SIZE, SIZE);
    }

    /**
     * Checks whtether or not enemies are frozen and sets them accordingly
     */
    public void checkFrozen() {
        if (frozenTimer != 0) {
            setIsFrozen(true);
            frozenTimer -= 1;
        } else {
            setIsFrozen(false);
        }
    }

    /**
     * Moves this Enemy towards the Player and redraws it's graphics accordingly
     *
     * @param g Graphics2D instance used to redraw graphics
     */
    public void chasingHero(Graphics2D g) {
        if (!isFrozen) {  // chasing hero
            if (g != null)
                switch (enemyImageId) {
                    case 1:
                        g.drawImage(Images.getEnemyImage(), x, y, SIZE, SIZE, null);
                        break;
                    case 2:
                        g.drawImage(Images.getEnemy2Image(), x, y, SIZE, SIZE, null);
                        break;
                    case 3:
                        g.drawImage(Images.getEnemy3Image(), x, y, SIZE, SIZE, null);
                        break;
                }
            if (Player.getX() > this.x && canRight) {
                x += speed;
            }
            if (Player.getY() > this.y && canDown) {
                y += speed;
            }
            if (Player.getX() < this.x && canLeft) {
                x -= speed;
            }
            if (Player.getY() < this.y && canUp) {
                y -= speed;
            }
        } else {
            if (g != null)
                g.drawImage(Images.getEnemyFrozenImage(), (int) x, (int) y, SIZE, SIZE, null);
        }
    }

    /**
     * Checks if this Enemy has collided with a barrier and stops it's movement accordingly
     */
    public void collision() {

        Rectangle enemyrect = this.getBounds();
        Rectangle barrierrect = null;

        // check can left
        canLeft = true;
        for (int i = 0; i < TestLevel.getBarriers().size(); i++) {
            Tile barrier = TestLevel.getBarriers().get(i);
            barrierrect = new Rectangle(barrier.getTileX() + 1, barrier.getTileY(), barrier.getTileWidth(), barrier.getTileHeight());
            if (enemyrect.intersects(barrierrect)) {
                canLeft = false;
                break;
            }
        }

        // check can right
        canRight = true;
        for (int i = 0; i < TestLevel.getBarriers().size(); i++) {
            Tile barrier = TestLevel.getBarriers().get(i);
            barrierrect = new Rectangle(barrier.getTileX() - 1, barrier.getTileY(), barrier.getTileWidth(), barrier.getTileHeight());
            if (enemyrect.intersects(barrierrect)) {
                canRight = false;
                break;
            }
        }

        // check can up
        canUp = true;
        for (int i = 0; i < TestLevel.getBarriers().size(); i++) {
            Tile barrier = TestLevel.getBarriers().get(i);
            barrierrect = new Rectangle(barrier.getTileX(), barrier.getTileY() + 1, barrier.getTileWidth(), barrier.getTileHeight());
            if (enemyrect.intersects(barrierrect)) {
                canUp = false;
                break;
            }
        }

        // check can down
        canDown = true;
        for (int i = 0; i < TestLevel.getBarriers().size(); i++) {
            Tile barrier = TestLevel.getBarriers().get(i);
            barrierrect = new Rectangle(barrier.getTileX(), barrier.getTileY() - 1, barrier.getTileWidth(), barrier.getTileHeight());
            if (enemyrect.intersects(barrierrect)) {
                canDown = false;
                break;
            }
        }
    }

    /**
     * Composite function which checks for collision(), checkFrozen() and calls chasingHero(Graohics2D)
     *
     * @param g Graphics2D instance used to redraw graphics
     */
    public void update(final Graphics2D g) {
        collision();
        checkFrozen();
        chasingHero(g);
    }
}


