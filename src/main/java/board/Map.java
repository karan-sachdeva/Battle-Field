package board;

/**
 * Integer mapping of the game board design
 */
public final class Map {
    private int[][] map;

    /**
     * Loads the integer mapping of the selected Map
     *
     * @param index index of which Map to load
     */
    Map(int index) {
        // 0: barrier, 1: grass, 2: key reward, 3: freeze reward
        // 4: health reward, 5: health bomb, 6: score bomb, 7: endpoint
        switch (index) {
            case 1:
                this.map = new int[][]{
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0},
                        {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0},
                        {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 6, 1, 0, 1, 1, 1, 1, 1, 0},
                        {0, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 0, 1, 4, 1, 1, 2, 0},
                        {0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0},
                        {0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0},
                        {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0},
                        {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                        {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                        {0, 1, 1, 1, 1, 1, 1, 1, 5, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                        {0, 1, 1, 2, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 6, 1, 0},
                        {0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0},
                        {0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                        {0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                        {0, 1, 1, 1, 1, 0, 1, 1, 1, 4, 1, 2, 1, 1, 1, 5, 1, 1, 1, 0},
                        {0, 1, 1, 3, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                        {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                        {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 7, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
                break;

            case 2:
                this.map = new int[][]{
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                        {0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 6, 1, 1, 1, 1, 1, 0, 1, 0},
                        {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 1, 0, 2, 0},
                        {0, 1, 0, 1, 1, 0, 0, 0, 0, 3, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0},
                        {0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0},
                        {0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0},
                        {0, 1, 0, 1, 1, 0, 1, 1, 1, 4, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0},
                        {0, 1, 0, 1, 1, 5, 1, 1, 1, 0, 0, 1, 1, 1, 6, 1, 1, 0, 1, 0},
                        {0, 1, 0, 1, 1, 1, 1, 1, 2, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0},
                        {0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0},
                        {0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0},
                        {0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 2, 0, 1, 1, 0, 1, 0},
                        {0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0},
                        {0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0},
                        {0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0},
                        {0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 5, 1, 1, 1, 1, 1, 1, 7, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
                break;

            default:
                System.err.println("INVALID MAP INDEX");
                System.exit(1);
                break;
        }
    }

    /**
     * Returns the int mapping of the game level design
     *
     * @return the int mapping of the game level design as an int[][]
     */
    public int[][] getMap() {
        return this.map;
    }
}
