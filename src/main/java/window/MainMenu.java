package window;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Container;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * GUI component that displays on game launch
 */
public class MainMenu extends JFrame {
    private final int MENU_SIZE = 500;
    private final int MENU_X_POS = 500;
    private final int MENU_Y_POS = 200;
    private final int BATTLEFIELD_LABEL_X_POS = 140;
    private final int BATTLEFIELD_LABEL_Y_POS = 50;
    private final int BATTLEFIELD_LABEL_WIDTH = 250;
    private final int BATTLEFIELD_LABEL_HEIGHT = 50;
    private final int BUTTON_WIDTH = 200;
    private final int BUTTON_HEIGHT = 50;
    private final int PLAY_BUTTON_X_POS = 150;
    private final int PLAY_BUTTON_Y_POS = 130;
    private final int EXIT_BUTTON_X_POS = 150;
    private final int EXIT_BUTTON_Y_POS = 260;
    private final int TITLE_FONT_SIZE = 32;
    private final int BUTTON_FONT_SIZE = 18;

    /**
     * Initializes and displays a new MainMenu for the game
     */
    public MainMenu() {
        setTitle("Main Menu");
        setBounds(MENU_X_POS, MENU_Y_POS, MENU_SIZE, MENU_SIZE);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.WHITE);
        Container c = getContentPane();
        Font titleFont = new Font("宋体", Font.BOLD, TITLE_FONT_SIZE);
        Font buttonFont = new Font("宋体", Font.BOLD, BUTTON_FONT_SIZE);

        // play a new game button
        JButton playNewGame = new JButton("Play a new game");
        playNewGame.setFont(buttonFont);
        playNewGame.setBounds(PLAY_BUTTON_X_POS, PLAY_BUTTON_Y_POS, BUTTON_WIDTH, BUTTON_HEIGHT);
        c.add(playNewGame);
        playNewGame.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                dispose();
                new MapChoice();
            }
        });

        // exit
        JButton exit = new JButton("Exit");
        exit.setFont(buttonFont);
        exit.setBounds(EXIT_BUTTON_X_POS, EXIT_BUTTON_Y_POS, BUTTON_WIDTH, BUTTON_HEIGHT);
        c.add(exit);
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                System.exit(0);
            }
        });

        // Battle Field
        JLabel l = new JLabel("BATTLE FIELD");
        l.setFont(titleFont);
        l.setBounds(BATTLEFIELD_LABEL_X_POS, BATTLEFIELD_LABEL_Y_POS, BATTLEFIELD_LABEL_WIDTH, BATTLEFIELD_LABEL_HEIGHT);
        c.add(l);
    }
}
