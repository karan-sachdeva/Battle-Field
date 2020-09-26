package board;

import image.Images;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * Represents an individual board tile
 *
 * @param <T> The game component contained within this particular tile
 */
public final class Tile<T> extends Rectangle {

    private int id;
    private boolean barrier;
    private T item;
    private int x;
    private int y;
    private int height;
    private int width;


    /**
     * The number of total Tiles per row and col
     */
    public static final int GRIDSIZE = 20; //contains 20 tiles

    /**
     * The pixel value of an individual Tiles size
     */
    public static final int TILESIZE = 32;

    /**
     * Initializes a new Tile instance with it's id and contents
     *
     * @param id         Image resource file id
     * @param boundaries Rectangle that bounds this Tile
     * @param barrier    boolean value of whether or not this Tile is a barrier
     * @param contents   item of type T occupying this Tile
     * @see Rectangle
     * @see Images
     */
    public Tile(final int id, final Rectangle boundaries, final boolean barrier, final T contents) {
        this.setBounds(boundaries);
        x = boundaries.x;
        y = boundaries.y;
        height = boundaries.height;
        width = boundaries.width;
        this.id = id;
        this.barrier = barrier;
        item = contents;
    }

    /**
     * Returns this Tile's x index
     *
     * @return this Tile's x index
     */
    public int getTileX() {
        return x;
    }

    /**
     * Returns this Tile's y index
     *
     * @return this Tile's y index
     */
    public int getTileY() {
        return y;
    }

    /**
     * Returns this Tile's height in pixels
     *
     * @return this Tile's height in pixels
     */
    public int getTileHeight() {
        return height;
    }

    /**
     * Returns this Tile's width in pixels
     *
     * @return this Tile's width in pixels
     */
    public int getTileWidth() {
        return width;
    }

    /**
     * Returns this Tile's Image resource file Id as an int
     *
     * @return this Tile's Image resource file Id as an int
     * @see Images
     */
    public int getId() {
        return id;
    }

    /**
     * Returns whether of not this Tile is a barrier
     *
     * @return boolean value of whether or not this Tile is a barrier
     */
    public boolean isBarrier() {
        return barrier;
    }

    /**
     * Returns the Rectangle that bounds this Tile
     *
     * @return the Rectangle that bounds this Tile as a Rectangle
     * @see Rectangle
     */
    public Rectangle getBounds() {
        return super.getBounds();
    }

    /**
     * Returns whether or not this Tile is occupied
     *
     * @return boolean value of whether or not this Tile is occupied
     */
    public boolean hasContents() {
        return item != null;
    }

    /**
     * Returns the contents occupying this Tile
     *
     * @return object instance of type T that is occupying this Tile
     */
    public T getContents() {
        return item;
    }


    /**
     * Redraws this Tile's graphics
     *
     * @param g Graphics2D instance used to redraw the graphics
     * @see Graphics2D
     */
    public void update(final Graphics2D g) {
        final int RED = 243;
        final int GREEN = 184;
        final int BLUE = 122;
        switch (id) {
            case 0: // endpoint
                g.drawImage(Images.getEndPointImage(), x, y, width, height, null);
                break;
            case 1: //
                g.drawImage(Images.getGrassImage(), x, y, width, height, null);
                break;
            case 2:
                g.drawImage(Images.getWallImage(), x, y, width, height, null);
                break;
            default: //without any textures
                g.setColor(new Color(RED, GREEN, BLUE));
                g.fillRect(x, y, width, height);
                break;
        }

    }
}
