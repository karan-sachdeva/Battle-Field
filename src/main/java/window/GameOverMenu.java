package window;

import actor.Player;
import playgame.Main;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Container;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * GUI component that displays upon game over
 */
public class GameOverMenu extends JFrame {
    private final int MENU_SIZE = 500;
    private final int MENU_X_POS = 500;
    private final int MENU_Y_POS = 200;
    private final int MENU_TITLE_X_POS = 150;
    private final int MENU_TITLE_Y_POS = 50;
    private final int MENU_TITLE_WIDTH = 200;
    private final int MENU_TITLE_HEIGHT = 50;
    private final int SCORE_LABEL_WIDTH = 200;
    private final int SCORE_LABEL_HEIGHT = 50;
    private final int SCORE_LABEL_X_POS = 180;
    private final int SCORE_LABEL_Y_POS = 150;
    private final int EXIT_BUTTON_X_POS = 140;
    private final int EXIT_BUTTON_Y_POS = 200;
    private final int EXIT_BUTTON_WIDTH = 200;
    private final int EXIT_BUTTON_HEIGHT = 50;

    private final int TITLE_FONT_SIZE = 32;
    private final int BUTTON_FONT_SIZE = 18;

    /**
     * Initializes and displays a new GameOverMenu if the player losses the game
     */
    public GameOverMenu() {
        Main.getBgm().stop();

        setTitle("Game Over Menu");
        setBounds(MENU_X_POS, MENU_Y_POS, MENU_SIZE, MENU_SIZE);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBackground(Color.WHITE);
        Container c = getContentPane();
        setLayout(null);
        Font titleFont = new Font("宋体", Font.BOLD, TITLE_FONT_SIZE);
        Font buttonFont = new Font("宋体", Font.BOLD, BUTTON_FONT_SIZE);

        // title
        JLabel gameOver = new JLabel("Game Over");
        gameOver.setFont(titleFont);
        gameOver.setBounds(MENU_TITLE_X_POS, MENU_TITLE_Y_POS, MENU_TITLE_WIDTH, MENU_TITLE_HEIGHT);
        c.add(gameOver);

        JLabel score = new JLabel();
        String finalScore = Integer.toString(Player.getScore());
        score.setText("Final Score : " + finalScore);
        score.setFont(buttonFont);
        score.setBounds(SCORE_LABEL_X_POS, SCORE_LABEL_Y_POS, SCORE_LABEL_WIDTH, SCORE_LABEL_HEIGHT);
        c.add(score);

        // exit
        JButton exit = new JButton("Exit");
        exit.setFont(buttonFont);
        exit.setBounds(EXIT_BUTTON_X_POS, EXIT_BUTTON_Y_POS, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
        c.add(exit);
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
