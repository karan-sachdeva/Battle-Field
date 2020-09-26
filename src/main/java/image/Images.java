package image;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Utility class used to load game textures
 */
public class Images {
    private static BufferedImage Enemy;
    private static BufferedImage Enemy2;
    private static BufferedImage Enemy3;
    private static BufferedImage Player;
    private static BufferedImage HealthBomb;
    private static BufferedImage ScoreBomb;
    private static BufferedImage Freeze;
    private static BufferedImage Grass;
    private static BufferedImage Wall;
    private static BufferedImage EndPoint;
    private static BufferedImage Hearts;
    private static BufferedImage Keys;
    private static BufferedImage EnemyFrozen;


    private Images() {
        try {
            Wall = ImageIO.read(getClass().getResource("/image/wall1.png"));
            Grass = ImageIO.read(getClass().getResource("/image/grass.png"));
            Player = ImageIO.read(getClass().getResource("/image/player.png"));
            Enemy = ImageIO.read(getClass().getResource("/image/enemy 1.png"));
            Enemy2 = ImageIO.read(getClass().getResource("/image/enemy 2.png"));
            Enemy3 = ImageIO.read(getClass().getResource("/image/enemy 3.png"));
            HealthBomb = ImageIO.read(getClass().getResource("/image/heartbomb.png"));
            ScoreBomb = ImageIO.read(getClass().getResource("/image/scorebomb.png"));
            Freeze = ImageIO.read(getClass().getResource("/image/freeze power.png"));
            EndPoint = ImageIO.read(getClass().getResource("/image/exit cell.png"));
            Hearts = ImageIO.read(getClass().getResource("/image/heart.png"));
            Keys = ImageIO.read(getClass().getResource("/image/key.png"));
            EnemyFrozen = ImageIO.read(getClass().getResource("/image/freeze_enemy.png"));
            Wall = ImageIO.read(getClass().getResource("/image/wall1.png"));
            Grass = ImageIO.read(getClass().getResource("/image/grass.png"));
            Player = ImageIO.read(getClass().getResource("/image/player.png"));
            Enemy = ImageIO.read(getClass().getResource("/image/enemy 1.png"));
            Enemy2 = ImageIO.read(getClass().getResource("/image/enemy 2.png"));
            Enemy3 = ImageIO.read(getClass().getResource("/image/enemy 3.png"));
            HealthBomb = ImageIO.read(getClass().getResource("/image/Health Hazard.png"));
            ScoreBomb = ImageIO.read(getClass().getResource("/image/blackbomb.png"));
            Freeze = ImageIO.read(getClass().getResource("/image/freeze power.png"));
            EndPoint = ImageIO.read(getClass().getResource("/image/exit cell.png"));
            Hearts = ImageIO.read(getClass().getResource("/image/heart.png"));
            Keys = ImageIO.read(getClass().getResource("/image/key.png"));
            EnemyFrozen = ImageIO.read(getClass().getResource("/image/freeze_enemy.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads all image resources
     */
    public static void loadImages() {
        new Images();
    }

    /**
     * Returns Enemy image resource file as a BufferedImage
     *
     * @return Enemy image resource as a BufferedImage
     * @see BufferedImage
     */
    public static BufferedImage getEnemyImage() {
        return Enemy;
    }

    /**
     * Returns first alternate Enemy image resource file as a BufferedImage
     *
     * @return first alternate Enemy image resource as a BufferedImage
     * @see BufferedImage
     */
    public static BufferedImage getEnemy2Image() {
        return Enemy2;
    }

    /**
     * Returns second alternate Enemy image resource file as a BufferedImage
     *
     * @return second alternate Enemy image resource as a BufferedImage
     * @see BufferedImage
     */
    public static BufferedImage getEnemy3Image() {
        return Enemy3;
    }

    /**
     * Returns Player image resource file as a BufferedImage
     *
     * @return Player image resource as a BufferedImage
     * @see BufferedImage
     */
    public static BufferedImage getPlayerImage() {
        return Player;
    }

    /**
     * Returns HealthBomb image resource file as a BufferedImage
     *
     * @return HealthBomb image resource as a BufferedImage
     * @see BufferedImage
     */
    public static BufferedImage getHealthBombImage() {
        return HealthBomb;
    }

    /**
     * Returns ScoreBomb image resource file as a BufferedImage
     *
     * @return ScoreBomb image resource as a BufferedImage
     * @see BufferedImage
     */
    public static BufferedImage getScoreBombImage() {
        return ScoreBomb;
    }

    /**
     * Returns Freeze image resource file as a BufferedImage
     *
     * @return Freeze image resource as a BufferedImage
     * @see BufferedImage
     */
    public static BufferedImage getFreezeImage() {
        return Freeze;
    }

    /**
     * Returns grass image resource file as a BufferedImage
     *
     * @return grass image resource as a BufferedImage
     * @see BufferedImage
     */
    public static BufferedImage getGrassImage() {
        return Grass;
    }

    /**
     * Returns wall image resource file as a BufferedImage
     *
     * @return wall image resource as a BufferedImage
     * @see BufferedImage
     */
    public static BufferedImage getWallImage() {
        return Wall;
    }

    /**
     * Returns EndPoint image resource file as a BufferedImage
     *
     * @return EndPoint image resource as a BufferedImage
     * @see BufferedImage
     */
    public static BufferedImage getEndPointImage() {
        return EndPoint;
    }

    /**
     * Returns HealthReward image resource file as a BufferedImage
     *
     * @return HealthReward image resource as a BufferedImage
     * @see BufferedImage
     */
    public static BufferedImage getHeartsImage() {
        return Hearts;
    }

    /**
     * Returns KeyReward image resource file as a BufferedImage
     *
     * @return KeyReward image resource as a BufferedImage
     * @see BufferedImage
     */
    public static BufferedImage getKeysImage() {
        return Keys;
    }

    /**
     * Returns FrozenEnemy image resource file as a BufferedImage
     *
     * @return FrozenEnemy image resource as a BufferedImage
     * @see BufferedImage
     */
    public static BufferedImage getEnemyFrozenImage() {
        return EnemyFrozen;
    }

}
