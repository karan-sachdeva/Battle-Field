package music;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.Clip;
import java.io.IOException;
import java.io.InputStream;

/**
 * Utility class used to load Freeze reward onHit sound effect
 */
public final class FreezeSound {
    private Clip freezeSound;

    /**
     * Loads the audio clip to be played when the Player collects a FreezeReward
     *
     * @see javax.sound.sampled
     * @see reward.Freeze
     * @see actor.Player
     */
    public FreezeSound() {
        try {
            this.freezeSound = AudioSystem.getClip();
            InputStream is = FreezeSound.class.getClassLoader().getResourceAsStream("sound/freezeSound.wav");
            AudioInputStream ais = AudioSystem.getAudioInputStream(is);
            this.freezeSound.open(ais);
            this.freezeSound.start();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Terminates the audio clip played when the Player collects a FreezeReward
     *
     * @see javax.sound.sampled.Clip
     * @see reward.Freeze
     * @see actor.Player
     */
    public void stop() {
        this.freezeSound.close();
    }
}
