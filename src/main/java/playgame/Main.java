package playgame;

import actor.Player;
import actor.Enemy;
import actor.Health;
import actor.KeyBar;
import board.TestLevel;
import board.Tile;
import hazard.Bomb;
import image.Images;
import music.BGM;
import music.Losing;
import reward.Reward;
import window.GameOverMenu;
import window.MainMenu;
import window.Window;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;


/**
 * Driver class. Runs main thread of game.
 */
public final class Main extends Canvas implements Runnable {
    // size
    private static final int WIDTH = Tile.TILESIZE;
    private static final int HEIGHT = Tile.TILESIZE;
    private static final int HOR_SCALE = Tile.GRIDSIZE;
    private static final int VERT_SCALE = Tile.GRIDSIZE;
    private static int width = WIDTH * HOR_SCALE;
    private static int height = HEIGHT * VERT_SCALE;
    private Dimension size = new Dimension(width, height);

    // functional
    //private static Thread mainThread; //thread object
    private static Window window;
    private static boolean running = false; //used for thread
    private static boolean pause = false;
    private static Graphics2D g;

    // music
    private static BGM bgm;

    // game component
    private static Player player;
    private static TestLevel level;
    private static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    private static ArrayList<Bomb> bombs = new ArrayList<Bomb>();
    private static ArrayList<Reward> rewards = new ArrayList<Reward>();

    // Constructor

    /**
     * Creates an instance of the Main game, populating the map depending on
     * the selected level
     * @param mapindex The specified level
     */
    public Main(final int mapindex){
        if (mapindex == 1) {    // first map
            player = new Player(Tile.TILESIZE, Tile.TILESIZE); //starting position(x,y)
            level = new TestLevel(mapindex); //instantiate
            Images.loadImages();

            //health = new Health();
            Health.initializeHealth();

            enemies.add(new Enemy(2 * Tile.TILESIZE, 14 * Tile.TILESIZE, 1));
            enemies.add(new Enemy(7 * Tile.TILESIZE, 15 * Tile.TILESIZE, 2));
            enemies.add(new Enemy(16 * Tile.TILESIZE, 3 * Tile.TILESIZE, 3));  // 3 enemies on the board

            window = new Window(size, this);
            bgm = new BGM();       // start bgm;
            addKeyListener(new Key()); //keylistener to get user input
        }
        else if(mapindex == 2)  // second map
        {
            player = new Player(Tile.TILESIZE, Tile.TILESIZE);
            level = new TestLevel(mapindex); //instantiate
            Images.loadImages();

            //health = new Health();
            Health.initializeHealth();

            enemies.add(new Enemy(18 * Tile.TILESIZE, 7 * Tile.TILESIZE, 1));
            enemies.add(new Enemy(9 * Tile.TILESIZE, 11 * Tile.TILESIZE, 2));
            enemies.add(new Enemy(16 * Tile.TILESIZE, 3 * Tile.TILESIZE, 3));

            window = new Window(size, this);
            bgm = new BGM();       // start bgm;
            addKeyListener(new Key()); //keylistener to get user input
        }
    }

    /*---------------------------------getter setter---------------------------------*/

    /**
     * Returns the Window instance of this game
     * @return the Window instance of this game
     * @see Window
     */
    public static  Window getWindow() { return window; }

    /**
     * Returns the Player instance of this game
     * @return the Player instance of this game
     * @see Player
     */
    public static Player getPlayer() { return player; }

    /**
     * Returns an Arraylist of enemy instances in this game
     * @return an Arraylist of enemy instances in this game
     * @see Enemy
     */
    public static ArrayList<Enemy> getEnemy() { return enemies; }

    /**
     * Returns the current running state of this game
     * @return the running state of this game
     */
    public static boolean getRunning() { return running; }

    /**
     * Returns an Arraylist of reward instances in this game
     * @return an Arraylist of reward instances in this game
     * @see Reward
     * @see reward.Freeze
     * @see reward.HealthReward
     */
    public static ArrayList<Reward> getRewards() { return rewards; }

    /**
     * Returns the background music instance of this game
     * @return the background music instance of this game
     * @see BGM
     */
    public static BGM getBgm() { return bgm; }

    /**
     * Returns the current pause state of this game
     * @return the pause state of this game
     */
    public static boolean getPause() { return pause; }

    /**
     * Returns an ArrayList of hazard instances in this game
     * @return an ArrayList of hazard instances in this game
     * @see Bomb
     * @see hazard.HealthBomb
     * @see hazard.ScoreBomb
     */
    public static ArrayList<Bomb> getBomb() { return bombs; }

    /**
     * Sets the pause state of this game to the specified boolean value
     * @param b the new pause state for this game
     */
    public static void setPause(boolean b) { pause = b; }

    /**
     * Sets the running state of this game to the specified boolean value
     * @param b the new running state for this game
     */
    public static void setRunning(boolean b) { running = b; }

    /*-------------------------------------------------------------------------------*/

    /**
     * Starts the main game thread, sets running state to true
     * @see Thread
     */
    public synchronized void start() { //start thread
        Thread mainThread = new Thread(this);
        mainThread.start();
        running = true;
    }

    /**
     * Implements Runnable.run() method. Runs Main.update() method.
     * Puts main game thread to sleep if pause state is true.
     * @see Runnable
     */
    public void run() { //when thread is running
        long timer = System.currentTimeMillis();
        while(running) {
            while(pause) {
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try {
                Thread.sleep(7); //caues thread to suspend execution for a specificed period. an efficient means of making processor time for other threads
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            update();

            if(System.currentTimeMillis() - timer >= 1000) {
                timer += 1000;
            }
        }
    }

    /**
     * Checks if Player has any health remaining. Launches new instance of GameOverMenu if Player has no health left.
     * @see GameOverMenu
     */
    public void isHeroStillAlive(){
        if(Health.getBar().isEmpty()){
            Main.getWindow().dispose();
            running = false;
            new Losing();
            new GameOverMenu();
        }
    }

    /**
     * Updates this games graphics using a BufferStrategy. Passes graphics instance to all other components for
     * redrawing
     * @see BufferStrategy
     */
    public void update() {
        isHeroStillAlive();
        BufferStrategy bs = this.getBufferStrategy(); //items are drawn to screen using buffer strategy
        if(bs == null) {
            createBufferStrategy(3); //prevents image tearing
            return;
        }
        Graphics graphics = bs.getDrawGraphics();
        g = (Graphics2D) graphics;
        g.setColor(new Color(0,0,0)); //r,g,b only goes upto 255
        g.fillRect(0, 0, width, height);

        level.update(g);
        Health.update(g);
        enemies.forEach((e) -> e.update(g));
        bombs.forEach((b) -> b.update(g));
        rewards.forEach((r) -> r.update(g));
        KeyBar.update(g);
        player.update(g);
        g.dispose();
        bs.show();
    }

    /**
     * Main driver method. Launches new instance of MainMenu
     * @param args command line arguments
     * @see MainMenu
     */
    public static void main(final String[] args) {
        new MainMenu();
    }

}//end class
