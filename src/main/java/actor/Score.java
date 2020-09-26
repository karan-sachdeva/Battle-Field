package actor;

import javax.swing.JPanel;
import javax.swing.JLabel;

/**
 * Keeps track of a players Score
 */
public class Score {
    private static JLabel textView = new JLabel("000", JLabel.CENTER);
    private static JPanel displayPanel = new JPanel();

    /**
     * Returns the JPanel containing the Score display
     *
     * @return JPanel containing the Score display
     */
    public static JPanel getPanel() {
        return displayPanel;
    }

    /**
     * Returns JLabel containing the Score amount
     *
     * @return Returns JLabel containing the Score amount
     */
    public static JLabel getComponent() {
        return textView;
    }

    /**
     * Updates the Score display amount
     */
    public static void update() {
        textView.setText("" + Player.getScore());
    }
}


