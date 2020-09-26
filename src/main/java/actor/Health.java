package actor;

import board.Tile;

import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * Keeps track of a players current Health
 */
public class Health {
    private static float hp = 89;
    private static ArrayList<HealthBar> bar;
    private static int index;
    private static int heartsLeft;
    private static int heartHpThreshold = 30;

    private Health() {
        bar = new ArrayList<>();
        bar.add(new HealthBar(0, 0));
        bar.add(new HealthBar(Tile.TILESIZE, 0));
        bar.add(new HealthBar(Tile.TILESIZE * 2, 0));
    }

    /*---------------------------------getter setter---------------------------------*/

    /**
     * Initializes players HealthBar
     */
    public static void initializeHealth() {
        new Health();
    }

    /**
     * Returns Players remaining health as a float
     *
     * @return Players remaining health as a float
     */
    public static float getHp() {
        return hp;
    }

    /**
     * Returns amount of HP an individual HealthBar instance represents
     *
     * @return int value of HP an individual HealthBar instance represents
     */
    public static int getHeartHpThreshold() {
        return heartHpThreshold;
    }

    /**
     * Returns an ArrayList of this games HealthBar instances
     *
     * @return an ArrayList of this games HealthBar instances
     * @see HealthBar
     */
    public static ArrayList<HealthBar> getBar() {
        return bar;
    }

    /**
     * Returns position in ArrayList of most recent heart
     *
     * @return position in ArrayList of most recent heart
     */
    public static int getIndex() {
        return index;
    }

    /**
     * Returns Players remaining heart count
     *
     * @return PLayers remaining heart count
     */
    public static int getHeartsLeft() {
        return heartsLeft;
    }

    /**
     * Increases Players health count by amount
     *
     * @param amount amount by which to increase Players health count
     */
    public static void increaseHp(float amount) {
        hp += amount;
    }

    /**
     * Decrements Players remaining Hearts
     */
    public static void decreaseHeartLeft() {
        heartsLeft--;
    }

    /*-------------------------------------------------------------------------------*/

    /**
     * Redraws Health graphics and updates Player heart count
     *
     * @param g Graphics2D instance used to redraw graphics
     * @see Graphics2D
     */
    public static void update(Graphics2D g) {
        heartsLeft = bar.size();
        index = heartsLeft - 1; // last index
        if (g != null)
            bar.forEach((h) -> h.update(g));
    }
}



