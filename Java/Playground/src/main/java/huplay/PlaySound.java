package huplay;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.URI;
import java.net.URL;

public class PlaySound {

	public PlaySound(URL url) {
		try {

			int index = url.getPath().lastIndexOf('/');
			String name = url.getPath().substring(index + 1, url.getPath().length());
			String filename = "./resources/" + name;

			File f = new File(filename);
			URI ui = f.toURI();
			AudioClip sound = Applet.newAudioClip(ui.toURL());
			sound.play();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
