package reward;

import actor.KeyBar;
import actor.Player;
import actor.Score;
import board.TestLevel;
import board.Tile;
import image.Images;
import music.KeySound;
import playgame.Main;

import java.awt.Graphics2D;

/**
 * Represents a KeyReward
 */
public final class KeyReward extends Reward {

    /**
     * Initializes this KeyReward instance at position x, y
     *
     * @param x x position real pixel value as an int
     * @param y y position real pixel value as an int
     */
    public KeyReward(final int x, final int y) {
        super(x * Tile.TILESIZE, y * Tile.TILESIZE);
        setValue(100);
    }

    /**
     * Increases the Player keyCount, increases Score and removes this instance from the game
     *
     * @see Player
     * @see Score
     */
    public void onHit() {
        KeySound keysound = new KeySound();
        Player.IncreaseKeyCount();
        Player.setScore(getValue());
        Score.update();
        TestLevel.addGrass(getXIndex(), getYIndex());
        Main.getRewards().remove(this);
        KeyBar.getKbar().add(new KeyReward(KeyBar.getInitialTile() + KeyBar.increaseCollected(), 0));
    }

    /**
     * Redraws this KeyRewards graphics
     *
     * @param g Graphics2D instance used to draw graphics
     */
    public void update(final Graphics2D g) {
        g.drawImage(Images.getKeysImage(), getX(), getY(), Tile.TILESIZE, Tile.TILESIZE, null);
    }
}

