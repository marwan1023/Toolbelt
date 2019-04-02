package huplay;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;

public class PlaySound {

    @SuppressWarnings("deprecation")
    public PlaySound(String filename) {
        try {
            File f = new File(filename);
            AudioClip sound = Applet.newAudioClip(f.toURL());
            sound.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
