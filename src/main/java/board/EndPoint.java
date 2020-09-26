package board;

import actor.Player;
import music.Winning;
import playgame.Main;
import window.GameOverMenu;

/**
 * Represents the exit point on the game map
 */
public class EndPoint {

    private static final int REQUIRED_KEYS = 5;

    /**
     * If the Player has collected all KeyRewards, ends the game
     *
     * @see Player
     * @see reward.KeyReward
     * @see GameOverMenu
     */
    public void onHit() {
        if (Player.getKeyCount() >= REQUIRED_KEYS) {
            Main.getWindow().dispose();
            Main.setRunning(false);
            new Winning();
            new GameOverMenu();
        }
    }

    /**
     * Returns the required number of KeyRewards to win the game
     *
     * @return the required number of KeyRewards to win the game, as an int
     * @see reward.KeyReward
     */
    public static int getRequiredKeys() {
        return REQUIRED_KEYS;
    }

}
