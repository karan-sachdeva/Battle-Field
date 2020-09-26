package hazard;

import actor.Health;
import board.TestLevel;
import board.Tile;
import image.Images;
import music.Boom;
import playgame.Main;

import java.awt.Graphics2D;

/**
 * Represents a HealthBomb hazard
 */
public class HealthBomb extends Bomb {

    public HealthBomb(final int x, final int y) {
        super(x * Tile.TILESIZE, y * Tile.TILESIZE);
    }


    /**
     * Decreases Players health count and removes this Bomb
     */
    @Override
    public void onHit() {
        Boom boom = new Boom();
        Health.getBar().remove(Health.getIndex());//health minus
        Health.decreaseHeartLeft();
        TestLevel.addGrass(getIndexX(), getIndexY());
        Main.getBomb().remove(this);
    }

    /**
     * Redraws this HealthBombs Graphics
     *
     * @param g Graphics2D instance used for redrawing
     * @see Graphics2D
     */
    @Override
    public void update(final Graphics2D g) {
        g.drawImage(Images.getHealthBombImage(), getX(), getY(), 32, 32, null);
    }

}
