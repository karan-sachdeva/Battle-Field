package music;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.Clip;
import java.io.IOException;
import java.io.InputStream;

/**
 * Utility class used to load Background Music
 */
public final class BGM {
    private Clip bgm;

    /**
     * Loads the audio clip to be played as the background music of the game
     *
     * @see javax.sound.sampled
     */
    public BGM() {
        try {
            this.bgm = AudioSystem.getClip();
            InputStream is = Losing.class.getClassLoader().getResourceAsStream("sound/bgm.wav");
            AudioInputStream ais = AudioSystem.getAudioInputStream(is);
            this.bgm.open(ais);
            this.bgm.loop(Clip.LOOP_CONTINUOUSLY);    // play music continuously
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Terminates the audio clip playing as the background music of the game
     *
     * @see javax.sound.sampled.Clip
     */
    public void stop() {
        this.bgm.close();
    }
}
