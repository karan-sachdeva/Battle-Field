package music;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.Clip;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Utility class used to load KeyReward onHit sound effect
 */
public final class KeySound {
    private Clip keySound;

    /**
     * Laods the audio clip to be played when the Player collects a KeyReward
     *
     * @see javax.sound.sampled
     * @see actor.Player
     * @see reward.KeyReward
     */
    public KeySound() {
        try {
            this.keySound = AudioSystem.getClip();
            InputStream is = KeySound.class.getClassLoader().getResourceAsStream("sound/keySound.wav");
            AudioInputStream ais = AudioSystem.getAudioInputStream(is);
            this.keySound.open(ais);
            this.keySound.start();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Terminates the audio clip that plays when the Player collects a KeyReward
     *
     * @see javax.sound.sampled.Clip
     * @see actor.Player
     * @see reward.KeyReward
     */
    public void stop() {
        this.keySound.close();
    }
}
