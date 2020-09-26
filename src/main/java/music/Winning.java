package music;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.Clip;
import java.io.IOException;
import java.io.InputStream;

/**
 * Utility class used to load GameOverMenu music upon win
 */
public final class Winning {
    private Clip winningSound;

    /**
     * Loads the audio clip to be played when the Player wins the game
     *
     * @see javax.sound.sampled
     */
    public Winning() {
        try {
            this.winningSound = AudioSystem.getClip();
            InputStream is = Winning.class.getClassLoader().getResourceAsStream("sound/wingame.wav");
            AudioInputStream ais = AudioSystem.getAudioInputStream(is);
            this.winningSound.open(ais);
            this.winningSound.start();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Terminates the audio clip played when the Player wins the game
     *
     * @see javax.sound.sampled.Clip
     */
    public void stop() {
        this.winningSound.close();
    }
}
