package music;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.Clip;
import java.io.IOException;
import java.io.InputStream;

/**
 * Utility class used to load GameOverMenu music upon loss
 */
public final class Losing {
    private Clip losingSound;

    /**
     * Loads the audio clip to be played when the Player losses the game
     *
     * @see javax.sound.sampled
     */
    public Losing() {
        try {
            this.losingSound = AudioSystem.getClip();
            InputStream is = Losing.class.getClassLoader().getResourceAsStream("sound/losegame.wav");
            AudioInputStream ais = AudioSystem.getAudioInputStream(is);
            this.losingSound.open(ais);
            this.losingSound.start();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Terminates the audio clip played when the Player losses the game
     *
     * @see javax.sound.sampled.Clip
     */
    public void stop() {
        this.losingSound.close();
    }
}
