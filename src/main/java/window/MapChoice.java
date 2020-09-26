package window;

import playgame.Main;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * GUI component that displays for game map selection
 */
public class MapChoice extends JFrame {

    private int MENU_SIZE = 500;
    private int MENU_X_POS = 500;
    private int MENU_Y_POS = 200;
    private int FONT_SIZE = 18;
    private int MAP_BUTTON_ROW = 0;
    private int MAP_BUTTON_COL = 0;
    private int EXIT_BUTTON_ROW = 1;
    private int EXIT_BUTTON_COL = 0;
    private int EXIT_BUTTON_WIDTH = 2;
    private int BUTTON_INT_PADDING = 50;


    /**
     * Initializes and displays a new MapChoice menu for the game
     *
     * @see board.Map
     */
    public MapChoice() {
        setTitle("Map Choice");
        setBounds(MENU_X_POS, MENU_Y_POS, MENU_SIZE, MENU_SIZE);
        setResizable(false);
        setVisible(true);
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.WHITE);
        Container c = getContentPane();
        Font font = new Font("宋体", Font.BOLD, FONT_SIZE);

        // map 1
        JButton map1 = new JButton("Map 1");
        map1.setFont(font);
        constraints.gridx = MAP_BUTTON_COL;
        constraints.gridy = MAP_BUTTON_ROW;
        constraints.ipadx = BUTTON_INT_PADDING;
        constraints.ipady = BUTTON_INT_PADDING;
        c.add(map1, constraints);
        map1.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                dispose();
                try {
                    new Main(1);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        // map 2
        JButton map2 = new JButton("Map 2");
        map2.setFont(font);
        constraints.gridx = MAP_BUTTON_COL + 1;
        constraints.gridy = MAP_BUTTON_ROW;
        constraints.ipadx = BUTTON_INT_PADDING;
        constraints.ipady = BUTTON_INT_PADDING;
        c.add(map2, constraints);
        map2.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                dispose();
                try {
                    new Main(2);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
