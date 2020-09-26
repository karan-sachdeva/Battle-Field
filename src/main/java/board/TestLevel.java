package board;

import hazard.Bomb;
import hazard.HealthBomb;
import hazard.ScoreBomb;
import playgame.Main;
import reward.Freeze;
import reward.HealthReward;
import reward.KeyReward;
import reward.Reward;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 * Represents an entire game level
 */
public final class TestLevel {
    private enum MappedAs {BARRIER, GRASS, KEY_REWARD, FREEZE, HEALTH_REWARD, HEALTH_BOMB, SCORE_BOMB, END_POINT}

    private static int[][] map;
    private static Tile[][] tiles = new Tile[Tile.GRIDSIZE][Tile.GRIDSIZE]; //grid
    private static final int TILESIZE = Tile.TILESIZE;
    private static ArrayList<Tile> barrierList = new ArrayList<>();

    /**
     * Populates the game board with all necessary components as mapped by the selected level mapIndex
     *
     * @param mapIndex selected level design from class Map
     * @see Map
     */
    public TestLevel(final int mapIndex) {
        this.map = new Map(mapIndex).getMap();

        for (int i = 0; i < map.length; i++)
            for (int j = 0; j < map[0].length; j++) {
                if (map[j][i] == MappedAs.valueOf("BARRIER").ordinal()) // 0: barrier
                {
                    tiles[i][j] = new Tile<Void>(2, new Rectangle(i * TILESIZE, j * TILESIZE, TILESIZE, TILESIZE), true, null);
                    barrierList.add(tiles[i][j]);
                }

                if (map[j][i] == MappedAs.valueOf("GRASS").ordinal()) // 1: grass
                    tiles[i][j] = new Tile<Void>(1, new Rectangle(i * TILESIZE, j * TILESIZE, TILESIZE, TILESIZE), false, null);

                if (map[j][i] == MappedAs.valueOf("KEY_REWARD").ordinal()) // 2: key reward
                    addReward(i, j, new KeyReward(i, j));

                if (map[j][i] == MappedAs.valueOf("FREEZE").ordinal()) // 3: freeze reward
                    addReward(i, j, new Freeze(i, j));

                if (map[j][i] == MappedAs.valueOf("HEALTH_REWARD").ordinal()) // 4: health reward
                    addReward(i, j, new HealthReward(i, j));

                if (map[j][i] == MappedAs.valueOf("HEALTH_BOMB").ordinal()) // 5: health bomb
                    addBomb(i, j, new HealthBomb(i, j));

                if (map[j][i] == MappedAs.valueOf("SCORE_BOMB").ordinal()) // 6: score bomb
                    addBomb(i, j, new ScoreBomb(i, j));

                if (map[j][i] == MappedAs.valueOf("END_POINT").ordinal()) // 7: end point
                    setEndPoint(i, j, new EndPoint());
            }
    }

    /**
     * Creates a new grass Tile at position x, y
     *
     * @param x x index of new grass Tile in Tiles[][]
     * @param y y index of new grass Tile in Tiles[][]
     */
    public static void addGrass(final int x, final int y) {
        TestLevel.tiles[x][y] = new Tile<Void>(1, new Rectangle(x * Tile.TILESIZE, y * Tile.TILESIZE, Tile.TILESIZE, Tile.TILESIZE), false, null);
    }

    /**
     * Creates a new Tile at position x, y that contains a Bomb
     *
     * @param x    x index of new bomb Tile in Tiles[][]
     * @param y    y index of new bomb Tile in Tiles[][]
     * @param bomb instance of bomb that occupies this Tile
     * @see Bomb
     * @see hazard.HealthBomb
     * @see ScoreBomb
     */
    public void addBomb(final int x, final int y, final Bomb bomb) {
        tiles[x][y] = new Tile<Bomb>(1, new Rectangle(x * TILESIZE, y * TILESIZE, TILESIZE, TILESIZE), false, bomb);
        Main.getBomb().add(bomb);
    }

    /**
     * Creates a new Tile at position x, y that contains a Reward
     *
     * @param x      x index of new reward Tile in Tiles[][]
     * @param y      y index of new reward Tile in Tiles[][]
     * @param reward instance of Reward that occupies this Tile
     * @see Reward
     * @see HealthReward
     * @see KeyReward
     * @see Freeze
     */
    public void addReward(final int x, final int y, final Reward reward) {
        tiles[x][y] = new Tile<Reward>(1, new Rectangle(x * TILESIZE, y * TILESIZE, TILESIZE, TILESIZE), false, reward);
        Main.getRewards().add(reward);
    }

    /**
     * Creates a new Tile at position x, y and sets the EndPoint within it
     *
     * @param x x index of new EndPoint Tile in Tiles[][]
     * @param y y index of new EndPoint Tile in Tiles[][]
     * @param e instance of EndPoint
     * @see EndPoint
     */
    public void setEndPoint(final int x, final int y, final EndPoint e) {
        tiles[x][y] = new Tile<EndPoint>(0, new Rectangle(x * TILESIZE, y * TILESIZE, TILESIZE, TILESIZE), false, e);
    }

    /**
     * Returns a reference to the Tile 2D array
     *
     * @return a reference to this levels Tile[][]
     */
    public static Tile[][] getTiles() {
        return tiles;
    }

    /**
     * Returns this levels list of barriers
     *
     * @return an ArrayList<Tile> containing all the barriers of this level
     */
    public static ArrayList<Tile> getBarriers() {
        return barrierList;
    }

    /**
     * Redraws the graphics of all Tiles on the board
     *
     * @param g Graphics2D instance used to redraw graphics
     * @see Graphics2D
     */
    public void update(final Graphics2D g) {
        for (int x = 0; x < tiles.length; x++)
            for (int y = 0; y < tiles[0].length; y++)
                tiles[x][y].update(g);
    }
}
