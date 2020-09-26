package reward;

import actor.Health;
import actor.HealthBar;
import actor.Player;
import actor.Score;
import board.TestLevel;
import board.Tile;
import image.Images;
import playgame.Main;

import java.awt.Graphics2D;

/**
 * Represents a HealthReward
 */
public final class HealthReward extends Reward {


    /**
     * Initializes a HealthReward instance at position x, y
     *
     * @param x x index of Tile occupied by this HealthReward
     * @param y y index of Tile occupied by this HealthReward
     * @see Tile
     * @see TestLevel
     */
    public HealthReward(final int x, final int y) {
        super(x * Tile.TILESIZE, y * Tile.TILESIZE);
        setValue(50);
    }


    /**
     * Increase Player Score, HP, HealthBar and removes this HealthReward instance from the game
     *
     * @see Player
     * @see Score
     * @see Health
     * @see HealthBar
     */
    public void onHit() {
        Health.increaseHp((Health.getHeartsLeft() + 1) * Health.getHeartHpThreshold());
        Health.getBar().add(new HealthBar((Tile.TILESIZE * Health.getHeartsLeft()), 0));
        Player.setScore(getValue());
        Score.update();
        TestLevel.addGrass(getXIndex(), getYIndex());
        Main.getRewards().remove(this);
    }

    /**
     * Redraws this HealthRewards graphics
     *
     * @param g Graphics2D instance used to redraw graphics
     */
    public void update(final Graphics2D g) {
        g.drawImage(Images.getHeartsImage(), getX(), getY(), Tile.TILESIZE, Tile.TILESIZE, null);
    }

}
