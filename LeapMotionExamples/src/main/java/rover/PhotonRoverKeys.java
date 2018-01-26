package rover;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PhotonRoverKeys implements KeyListener {

    private static final String accessToken = "da0d58dfbd0ced8098266f32038dccfcd4162d4f";
    private static final String deviceID = "270036000d47343233323032";
    private static String controlURL;

    public static void main(String[] args) {

        PhotonRoverKeys prk = new PhotonRoverKeys();
        JFrame frame = new JFrame();

        frame.setTitle("Photon Rover");

        Container cp = frame.getContentPane();
        cp.setLayout(new FlowLayout());
     
        JButton forwardButton = new JButton("Forward");
        JButton leftButton = new JButton("Left");
        JButton rightButton = new JButton("Right");
        JButton reverseButton = new JButton("Reverse");
        JButton stopButton = new JButton("Stop");
        
        forwardButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                determineMovement(KeyEvent.VK_W);
            } 
          } );
        
        stopButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                executeCommand("S");
            } 
          } );
        
        leftButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                determineMovement(KeyEvent.VK_D);
            } 
          } );
        
        rightButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                determineMovement(KeyEvent.VK_A);
            } 
          } );
        
        reverseButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                determineMovement(KeyEvent.VK_S);
            } 
          } );
        

        cp.add(forwardButton);
        cp.add(leftButton);
        cp.add(rightButton);
        cp.add(reverseButton);
        cp.add(stopButton);
   

        frame.setSize(300, 100);

        frame.setVisible(true);
        frame.addKeyListener(prk);

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {

        //determineMovement(e.getKeyCode());

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    private static void determineMovement(int keyCode) {
        StringBuilder url = new StringBuilder();
        url.append("https://api.spark.io/v1/devices/");
        url.append(deviceID);
        url.append("/control");

        controlURL = url.toString();

        switch (keyCode) {
        case KeyEvent.VK_W:
            System.out.println("Forward");
            executeCommand("F-100");
            break;
        case KeyEvent.VK_D:
            System.out.println("Right");
            executeCommand("R-50");
            break;
        case KeyEvent.VK_A:
            System.out.println("Left");
            executeCommand("L-50");
            break;
        case KeyEvent.VK_S:
            System.out.println("Reverse");
            executeCommand("B-75");
            break;
        default:
            System.out.println("Stop");
            executeCommand("S");
            break;

        }

    }

    private static void executeCommand(String command) {
        URL url;
        try {
            url = new URL(controlURL);

            HttpURLConnection hConnection = (HttpURLConnection) url
                    .openConnection();
            HttpURLConnection.setFollowRedirects(true);

            hConnection.setDoOutput(true);
            hConnection.setRequestMethod("POST");

            PrintStream ps = new PrintStream(hConnection.getOutputStream());
            ps.print("params=" + command + "&access_token=" + accessToken);
            ps.close();

            hConnection.connect();

            hConnection.getResponseCode();

        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
