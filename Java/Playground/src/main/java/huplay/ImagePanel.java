package huplay;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ImagePanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private BufferedImage image;

    public ImagePanel() {
        this.setBackground(Color.WHITE);
    }

    public ImagePanel(URL url) {
        try {
            this.setBackground(Color.WHITE);

            int index = url.getPath().lastIndexOf('/');
            String name = url.getPath().substring(index+1, url.getPath().length());
            String filename = "./resources/" + name;
            
            
            image = ImageIO.read(new File(filename));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int componentWidth = this.getWidth();
        int componentHeight = this.getHeight();
        int imageWidth = 0;
        int imageHeight = 0;

        if (image != null) {
            imageWidth = image.getWidth();
            imageHeight = image.getHeight();
        }

        int x = (componentWidth - imageWidth) / 2;
        int y = (componentHeight - imageHeight) / 2;
        g.drawImage(image, x, y, null);
    }

}
