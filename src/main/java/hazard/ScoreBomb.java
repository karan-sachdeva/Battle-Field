package hazard;

import actor.Player;
import actor.Score;
import board.TestLevel;
import board.Tile;
import image.Images;
import music.Boom;
import playgame.Main;

import java.awt.Graphics2D;

/**
 * Represents a ScoreBomb hazard
 */
public class ScoreBomb extends Bomb {

    private final int scoreDamage = 200;

    public ScoreBomb(final int x, final int y) {
        super(x * Tile.TILESIZE, y * Tile.TILESIZE);
    }

    /**
     * Decreases Players score upon collision, then removes this Bomb
     */
    @Override
    public void onHit() {
        Boom boom = new Boom();
        Player.setScore(-scoreDamage);
        Score.update();
        TestLevel.addGrass(getIndexX(), getIndexY());
        Main.getBomb().remove(this);
    }

    /**
     * Redraws this ScoreBombs graphics
     *
     * @param g Graphics2D instance used for redrawing
     * @see Graphics2D
     */
    @Override
    public void update(final Graphics2D g) {
        g.drawImage(Images.getScoreBombImage(), getX(), getY(), Tile.TILESIZE, Tile.TILESIZE, null);
    }

}
