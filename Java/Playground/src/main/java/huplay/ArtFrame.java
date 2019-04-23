package huplay;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import javax.swing.*;

public class ArtFrame extends JFrame {
  
    private static final long serialVersionUID = 1L;

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
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Platform.setImplicitExit(false);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                initFX(fxPanel);
            }
        });
    }

    private static void initFX(JFXPanel fxPanel) {

        Paint p = new Paint();
        Stage s = new Stage();


        Scene scene = p.getPaintScene(s);

        // This method is invoked on the JavaFX thread
        fxPanel.setScene(scene);
        s.setOnCloseRequest(event -> {
            System.out.println("Stage is closing");
            // Save file
        });
    }


}