package actor;

import reward.KeyReward;

import java.util.ArrayList;
import java.awt.Graphics2D;

/**
 * Holds the keys that the Player has collected
 */
public class KeyBar {
    private static ArrayList<KeyReward> kBar = new ArrayList<>();
    private static int collected = 0;
    private static int intialTile = 14;

    /**
     * Returns list of collected KeyReward instances
     *
     * @return an ArrayList of collected KeyReward instances
     * @see KeyReward
     */
    public static ArrayList<KeyReward> getKbar() {
        return kBar;
    }

    /**
     * Increment the number of KeyRewards collected
     *
     * @return an int value of KeyRewards collected
     */
    public static int increaseCollected() {
        collected++;
        return collected;
    }

    /**
     * Returns the x index of the initial Tile the KeyBar occupies
     *
     * @return x index of the initial Tile the KeyBar occupies
     * @see board.Tile
     * @see board.TestLevel
     */
    public static int getInitialTile() {
        return intialTile;
    }

    /**
     * Redraws the KeyBar graphics
     *
     * @param g Graphics2D instance used to redraw graphics
     * @see Graphics2D
     */
    public static void update(final Graphics2D g) {
        kBar.forEach((k) -> k.update(g));
    }
}


