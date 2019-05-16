package huplay;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;

public class ArtFrame extends JFrame {

    public ArtFrame() {
        Runnable r = () -> initAndShowGUI();
        r.run();
    }

    public ArtFrame(String sTitle) {
        this();
        setTitle(sTitle);
    }

    private void initAndShowGUI() {
        // This method is invoked on the EDT thread
        final JFXPanel fxPanel = new JFXPanel();

        this.add(fxPanel);
        this.setSize(1080, 790);
        this.setVisible(true);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                initFX(fxPanel);
            }
        });
    }

    private static void initFX(JFXPanel fxPanel) {
        Paint p = new Paint();
        Scene scene = p.getPaintScene(new Stage());

        // This method is invoked on the JavaFX thread
        fxPanel.setScene(scene);
   
    }


}
