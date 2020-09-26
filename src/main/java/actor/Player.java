package actor;

import board.EndPoint;
import board.TestLevel;
import board.Tile;
import hazard.Bomb;
import image.Images;
import playgame.Main;
import reward.Freeze;
import reward.HealthReward;
import reward.KeyReward;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import static board.Tile.TILESIZE;

/**
 * Represents a Player
 */
public final class Player {
    private static float x; //position
    private static float y;

    private static final int SIZE = 32;
    private static int score;
    private static int keyCount;
    private int speed = 2;

    private static boolean movingLeft;
    private static boolean movingRight;
    private static boolean movingUp;
    private static boolean movingDown;
    private static boolean canUp;
    private static boolean canDown;
    private static boolean canRight;
    private static boolean canLeft;

    /**
     * Initializes Player instance at positions dx, dy and sets score and keyCount to 0
     *
     * @param dx x position real pixel value
     * @param dy y position real pixel value
     */
    public Player(final float dx, final float dy) {
        x = dx;
        y = dy;
        canUp = true;
        canDown = true;
        canLeft = true;
        canRight = true;
        score = 0;
        keyCount = 0;
    }

    /*---------------------------------getter setter---------------------------------*/

    /**
     * Returns x position real pixel value as a float
     *
     * @return x position real pixel value as a float
     */
    public static float getX() {
        return x;
    }

    /**
     * Returns y position real pixel value as a float
     *
     * @return y position real pixel value as a float
     */
    public static float getY() {
        return y;
    }

    /**
     * Sets x position real pixel value to dx
     *
     * @param dx real pixel value of new x position
     */
    public static void setX(final float dx) {
        x = dx;
    }

    /**
     * Sets y position real pixel value to dx
     *
     * @param dy real pixel value of new y position
     */
    public static void setY(final float dy) {
        y = dy;
    }

    /**
     * Returns this Player's bounding Rectangle
     *
     * @return a Rectangle that bounds this Player instance
     * @see Rectangle
     */
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, SIZE, SIZE);
    }

    /**
     * Returns the amount of KeyRewards collected by this Player
     *
     * @return int value of KeyRewards collected
     * @see KeyReward
     */
    public static int getKeyCount() {
        return keyCount;
    }

    /**
     * Returns this Player's Score
     *
     * @return int value of this Player's Score
     * @see Score
     */
    public static int getScore() {
        return score;
    }

    /**
     * Returns whether or not this Player can move to the left
     *
     * @return boolean value canLeft
     */
    public static boolean getCanLeft() {
        return canLeft;
    }

    /**
     * Returns whether or not this Player can move to the right
     *
     * @return boolean value canRight
     */
    public static boolean getCanRight() {
        return canRight;
    }

    /**
     * Returns whether or not this Player can move up
     *
     * @return boolean value canUp
     */
    public static boolean getCanUp() {
        return canUp;
    }

    /**
     * Returns whether or not this Player can move down
     *
     * @return boolean value canDown
     */
    public static boolean getCanDown() {
        return canDown;
    }

    /**
     * Increments this Player's Score by passed in amount
     *
     * @param amount int value to increment Player's Score by
     */
    public static void setScore(int amount) {
        score += amount;
    }

    /**
     * Increments this Player's keyCount
     */
    public static void IncreaseKeyCount() {
        keyCount++;
    }

    /**
     * Sets whether or not this Player is moving to the left
     *
     * @param b new boolean value of movingLeft
     */
    public static void setMovingLeft(boolean b) {
        movingLeft = b;
    }

    /**
     * Sets whether or not this Player is moving to the right
     *
     * @param b new boolean vale of movingRight
     */
    public static void setMovingRight(boolean b) {
        movingRight = b;
    }

    /**
     * Sets whether or not this Player is moving upwards
     *
     * @param b new boolean value of movingUp
     */
    public static void setMovingUp(boolean b) {
        movingUp = b;
    }

    /**
     * Sets whether of not this Player is moving downwards
     *
     * @param b new boolean value of movingDown
     */
    public static void setMovingDown(boolean b) {
        movingDown = b;
    }

    /**
     * Returns whether or not this Player is moving left
     *
     * @return boolean value of movingLeft
     */
    public static boolean getMovingLeft() {
        return movingLeft;
    }

    /**
     * Returns whether or not this Player is moving right
     *
     * @return boolean value of movingRight
     */
    public static boolean getMovingRight() {
        return movingRight;
    }

    /**
     * Returns whether or not this Player is moving upwards
     *
     * @return boolean value of movingUp
     */
    public static boolean getMovingUp() {
        return movingUp;
    }

    /**
     * Returns whether or not this Player is moving downwards
     *
     * @return boolean value of movingDown
     */
    public static boolean getMovingDown() {
        return movingDown;
    }

    /*-------------------------------------------------------------------------------*/


    /**
     * Return the x and y indices of the Tile this Player is currently in
     *
     * @return x and y positions of the Tile this Player instance is occupying as an int array
     * @see Tile
     * @see TestLevel
     */
    public int[] currentTile()  //hero current tile
    {
        int[] currentTile = new int[2];
        int dx;
        if (x - (int) (x / TILESIZE) * TILESIZE >= (Tile.TILESIZE / 2))
            dx = (int) (x / TILESIZE) + 1;
        else {
            dx = (int) (x / TILESIZE);
        }
        int dy;
        if (y - (int) (y / TILESIZE) * TILESIZE >= (Tile.TILESIZE / 2))
            dy = (int) (y / TILESIZE) + 1;
        else {
            dy = (int) (y / TILESIZE);
        }

        currentTile[0] = dx;
        currentTile[1] = dy;
        return currentTile;
    }

    /**
     * Checks if this Player instance has collided with an enemy and sets Health accordingly
     *
     * @see Enemy
     * @see Health
     */
    public void collideEnemy()  // collide with enemy
    {
        for (int i = 0; i < Main.getEnemy().size(); i++)
            if (Main.getEnemy().get(i).getBounds().intersects(this.getBounds())) {
                if (Health.getHp() % Health.getHeartHpThreshold() == 0) {
                    Health.getBar().remove(Health.getIndex());
                    Health.increaseHp(-Enemy.getDamage());
                    Health.decreaseHeartLeft();    // heart bar index -1
                } else {
                    Health.increaseHp(-Enemy.getDamage());
                }
            }
    }

    /**
     * Checks if this Player instance has collided with another interactable game component
     *
     * @param dx x position of the TIle this Player instance is currently occupying
     * @param dy y position of the TIle this Player instance is currently occupying
     */
    public void collideContent(final int dx, final int dy)      // hit a content
    {
        if (TestLevel.getTiles()[dx][dy].hasContents()) {
            if (TestLevel.getTiles()[dx][dy].getContents() instanceof Bomb) {
                Bomb b = (Bomb) TestLevel.getTiles()[dx][dy].getContents();
                b.onHit();
            } else if (TestLevel.getTiles()[dx][dy].getContents() instanceof Freeze) {
                Freeze f = (Freeze) TestLevel.getTiles()[dx][dy].getContents();
                f.onHit();
            } else if (TestLevel.getTiles()[dx][dy].getContents() instanceof HealthReward) {
                HealthReward hr = (HealthReward) TestLevel.getTiles()[dx][dy].getContents();
                hr.onHit();
            } else if (TestLevel.getTiles()[dx][dy].getContents() instanceof KeyReward) {
                KeyReward kr = (KeyReward) TestLevel.getTiles()[dx][dy].getContents();
                kr.onHit();
            } else if (TestLevel.getTiles()[dx][dy].getContents() instanceof EndPoint) {
                EndPoint e = (EndPoint) TestLevel.getTiles()[dx][dy].getContents();
                e.onHit();
            }
        }
    }

    /**
     * Checks whether or not there is a barrier around this Player
     */
    public void checkMove() {
        Rectangle herorect = this.getBounds();
        Rectangle barrierrect = null;
        // check can left
        canLeft = true;
        for (int i = 0; i < TestLevel.getBarriers().size(); i++) {
            Tile barrier = TestLevel.getBarriers().get(i);
            barrierrect = new Rectangle(barrier.getTileX() + 2, barrier.getTileY(), barrier.getTileWidth(), barrier.getTileHeight());
            if (herorect.intersects(barrierrect)) {
                canLeft = false;
                break;
            }
        }

        // check can right
        canRight = true;
        for (int i = 0; i < TestLevel.getBarriers().size(); i++) {
            Tile barrier = TestLevel.getBarriers().get(i);
            barrierrect = new Rectangle(barrier.getTileX() - 2, barrier.getTileY(), barrier.getTileWidth(), barrier.getTileHeight());
            if (herorect.intersects(barrierrect)) {
                canRight = false;
                break;
            }
        }

        // check can up
        canUp = true;
        for (int i = 0; i < TestLevel.getBarriers().size(); i++) {
            Tile barrier = TestLevel.getBarriers().get(i);
            barrierrect = new Rectangle(barrier.getTileX(), barrier.getTileY() + 2, barrier.getTileWidth(), barrier.getTileHeight());
            if (herorect.intersects(barrierrect)) {
                canUp = false;
                break;
            }
        }

        // check can down
        canDown = true;
        for (int i = 0; i < TestLevel.getBarriers().size(); i++) {
            Tile barrier = TestLevel.getBarriers().get(i);
            barrierrect = new Rectangle(barrier.getTileX(), barrier.getTileY() - 2, barrier.getTileWidth(), barrier.getTileHeight());
            if (herorect.intersects(barrierrect)) {
                canDown = false;
                break;
            }
        }
    }

    /**
     * Checks for all possible collisions
     */
    public void collision() {

        int[] currentTile = currentTile();
        int dx = currentTile[0]; // hero current tile x index
        int dy = currentTile[1]; // hero current tile y index

        collideEnemy();

        collideContent(dx, dy);

        checkMove();
    }

    /**
     * Redraws this Players graphics and updates it's position on the game window
     *
     * @param g Graphics2D instance used to redraw graphics
     * @see Graphics2D
     */
    public void update(final Graphics2D g) {
        collision();
        if (g != null)
            g.drawImage(Images.getPlayerImage(), (int) x, (int) y, SIZE, SIZE, null);
        //update player movement based on user input
        if (movingLeft && canLeft)
            x -= speed;
        if (movingRight && canRight)
            x += speed;
        if (movingUp && canUp)
            y -= speed;
        if (movingDown && canDown)
            y += speed;
    }
}



