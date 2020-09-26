package window;

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
 * GUI component that displays upon pause
 */
public class PauseMenu extends JFrame {
    private final int MENU_SIZE = 500;
    private final int MENU_X_POS = 500;
    private final int MENU_Y_POS = 200;
    private final int MENU_TITLE_X_POS = 140;
    private final int MENU_TITLE_Y_POS = 50;
    private final int MENU_TITLE_WIDTH = 250;
    private final int MENU_TITLE_HEIGHT = 50;
    private final int RESUME_BUTTON_WIDTH = 200;
    private final int RESUME_BUTTON_HEIGHT = 50;
    private final int RESUME_BUTTON_X_POS = 150;
    private final int RESUME_BUTTON_Y_POS = 150;
    private final int EXIT_BUTTON_X_POS = 200;
    private final int EXIT_BUTTON_Y_POS = 300;
    private final int EXIT_BUTTON_WIDTH = 100;
    private final int EXIT_BUTTON_HEIGHT = 50;

    private final int TITLE_FONT_SIZE = 32;
    private final int BUTTON_FONT_SIZE = 18;

    /**
     * Initializes and displays a new PauseMenu for the game, placing the main game in a pause state
     */
    public PauseMenu() {
        Main.setPause(true);

        setTitle("Pause Menu");
        setBounds(MENU_X_POS, MENU_Y_POS, MENU_SIZE, MENU_SIZE);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.WHITE);
        setLayout(null);
        Container c = getContentPane();
        Font titleFont = new Font("宋体", Font.BOLD, TITLE_FONT_SIZE);
        Font buttonFont = new Font("宋体", Font.BOLD, BUTTON_FONT_SIZE);

        // title
        JLabel pause = new JLabel("Pause Menu");
        pause.setFont(titleFont);
        pause.setBounds(MENU_TITLE_X_POS, MENU_TITLE_Y_POS, MENU_TITLE_WIDTH, MENU_TITLE_HEIGHT);
        c.add(pause);

        // resume
        JButton resume = new JButton("Resume");
        resume.setFont(buttonFont);
        resume.setBounds(RESUME_BUTTON_X_POS, RESUME_BUTTON_Y_POS, RESUME_BUTTON_WIDTH, RESUME_BUTTON_HEIGHT);
        c.add(resume);
        resume.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                dispose();
                Main.setPause(false);
            }
        });

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
