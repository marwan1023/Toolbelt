package huplay;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.URI;

public class PlaySound {

    public PlaySound(String filename) {
        try {
            File f = new File(filename);
            URI ui = f.toURI();
            AudioClip sound = Applet.newAudioClip(ui.toURL());
            sound.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
