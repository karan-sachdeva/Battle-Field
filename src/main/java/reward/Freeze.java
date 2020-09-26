package reward;

import actor.Player;
import actor.Score;
import board.TestLevel;
import board.Tile;
import image.Images;
import music.FreezeSound;
import playgame.Main;

import java.awt.Graphics2D;

/**
 * Represents a Freeze reward
 */
public final class Freeze extends Reward {
    private int freezeTime = 180;
    private int timeLeft = 750;

    /**
     * Initializes this Freeze instance at position x, y
     *
     * @param x x index of Tile occupied by this Freeze reward
     * @param y y index of Tile occupied by this Freeze reward
     * @see Tile
     * @see TestLevel
     */
    public Freeze(final int x, final int y) {
        super(x * Tile.TILESIZE, y * Tile.TILESIZE);
        setValue(150);
    }

    /**
     * Freezes all instances of Enemy on the map and removes this Freeze reward
     *
     * @see actor.Enemy
     */
    public void onHit() {
        FreezeSound freezeSound = new FreezeSound();
        Main.getEnemy().forEach((e) -> e.setFrozenTimer(freezeTime));
        Player.setScore(getValue());
        Score.update();
        TestLevel.addGrass(getXIndex(), getYIndex());
        Main.getRewards().remove(this);
    }

    /**
     * Redraws this Freeze rewards graphics while it is available on the map
     *
     * @param g Graphics2D instance used to redraw graphics
     */
    public void update(final Graphics2D g) {
        if (timeLeft > 0) {
            g.drawImage(Images.getFreezeImage(), getX(), getY(), Tile.TILESIZE, Tile.TILESIZE, null);
            timeLeft -= 1;
        } else {
            TestLevel.addGrass(getXIndex(), getYIndex());
        }
    }
}
