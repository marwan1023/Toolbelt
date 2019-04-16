package huplay;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JTextField;

public class Trophy extends JFrame {

    private static final long serialVersionUID = 1L;
    private ClassLoader classLoader = getClass().getClassLoader();
    private Score score = Score.getInstance();


    ImagePanel imageViewer2 = new ImagePanel();
    JLabel spellingLabel = new JLabel();
    JLabel spellingScore = new JLabel();

    JLabel mathLabel = new JLabel();
    JLabel mathScore = new JLabel();


    ImagePanel imageViewer1 = new ImagePanel();
    ImagePanel sbronze = new ImagePanel();
    ImagePanel ssilver = new ImagePanel();
    ImagePanel sgold = new ImagePanel();
    ImagePanel swin = new ImagePanel();
    ImagePanel mwin = new ImagePanel();

    //JButton nameEntryButton = new JButton();
    //JTextField score2 = new JTextField();

    ImagePanel mbronze = new ImagePanel();
    ImagePanel msilver = new ImagePanel();
    ImagePanel mgold = new ImagePanel();

    // Used by addNotify
    boolean frameSizeAdjusted = false;

    public Trophy() {

        getContentPane().setLayout(null);
        getContentPane().setBackground(java.awt.Color.white);
        setSize(652, 485);
        setVisible(false);

        imageViewer2 = new ImagePanel(classLoader.getResource("congrat.gif").getFile());
        imageViewer2.setBackground(Color.WHITE);

        getContentPane().add(imageViewer2);
        imageViewer2.setBounds(144, 96, 396, 24);
        spellingLabel.setText("Spelling Score:");
        getContentPane().add(spellingLabel);
        spellingLabel.setForeground(java.awt.Color.blue);
        spellingLabel.setBounds(36, 168, 120, 24);
        spellingScore.setForeground(java.awt.Color.black);
        spellingScore.setBounds(160, 168, 120, 24);
        spellingScore.setText("" + score.getSpellingScore());
        getContentPane().add(spellingScore);
       // score.setFont(new Font("SansSerif", Font.BOLD, 12));
       // score.setBounds(132, 156, 72, 36);
        //send.setText("Ok!");
        //send.setActionCommand("Ok!");
        //getContentPane().add(send);
        //send.setBackground(new java.awt.Color(204, 204, 204));
        //send.setBounds(204, 156, 60, 36);

        imageViewer1 = new ImagePanel(classLoader.getResource("trophy.gif").getFile());
        imageViewer1.setBackground(Color.WHITE);
        getContentPane().add(imageViewer1);
        imageViewer1.setBounds(144, 12, 408, 84);

        sbronze = new ImagePanel(classLoader.getResource("sbronze.jpg").getFile());
        sbronze.setBackground(Color.WHITE);

        getContentPane().add(sbronze);
        sbronze.setBounds(36, 228, 264, 239);
        sbronze.setVisible(false);

        ssilver = new ImagePanel(classLoader.getResource("ssilver.jpg").getFile());
        ssilver.setBackground(Color.WHITE);

        getContentPane().add(ssilver);
        ssilver.setBounds(36, 228, 264, 239);
        ssilver.setVisible(false);

        sgold = new ImagePanel(classLoader.getResource("sgold.jpg").getFile());
        sgold.setBackground(Color.WHITE);

        getContentPane().add(sgold);
        sgold.setBounds(36, 228, 264, 239); // 672,336,120,48
        sgold.setVisible(false);

        swin.setAlignmentX(CENTER_ALIGNMENT);
        swin.setBackground(Color.WHITE);

        swin.setLayout(null);
        getContentPane().add(swin);
        swin.setBounds(36, 228, 264, 239);

        mwin.setAlignmentX(CENTER_ALIGNMENT);
        mwin.setBackground(Color.WHITE);
        mwin.setLayout(null);
        getContentPane().add(mwin);
        mwin.setBounds(360, 228, 264, 239);

        mathLabel.setText("Math Score:");
        mathLabel.setForeground(java.awt.Color.blue);
        mathLabel.setBounds(360, 168, 120, 24);
        getContentPane().add(mathLabel);

        mathScore.setForeground(java.awt.Color.black);
        mathScore.setBounds(456, 168, 120, 24);
        mathScore.setText("" + score.getMathScore());
        getContentPane().add(mathScore);

        mbronze = new ImagePanel(classLoader.getResource("mbronze.gif").getFile());
        mbronze.setBackground(Color.WHITE);

        getContentPane().add(mbronze);
        mbronze.setBounds(360, 228, 264, 239);
        mbronze.setVisible(false);
        msilver = new ImagePanel(classLoader.getResource("msilver.gif").getFile());
        msilver.setBackground(Color.WHITE);

        getContentPane().add(msilver);
        msilver.setBounds(360, 228, 264, 239);
        mgold = new ImagePanel(classLoader.getResource("mgold.gif").getFile());
        mgold.setBackground(Color.WHITE);

        getContentPane().add(mgold);
        mgold.setBounds(360, 228, 264, 239);

        // {{REGISTER_LISTENERS
        SymAction lSymAction = new SymAction();
       // send.addActionListener(lSymAction);
        //score.addActionListener(lSymAction);
        SymMouse aSymMouse = new SymMouse();
        //score.addMouseListener(aSymMouse);
        //nameEntryButton.addActionListener(lSymAction);
        // }}
    }

    public Trophy(String sTitle) {
        this();
        setTitle(sTitle);
    }

    public void setVisible(boolean b) {
        if (b)
            setLocation(50, 50);
        super.setVisible(b);
    }

    public void addNotify() {
        // Record the size of the window prior to calling parents addNotify.
        Dimension size = getSize();

        super.addNotify();

        if (frameSizeAdjusted)
            return;
        frameSizeAdjusted = true;

        // Adjust size of frame according to the insets and menu bar
        Insets insets = getInsets();
        JMenuBar menuBar = getRootPane().getJMenuBar();
        int menuBarHeight = 0;
        if (menuBar != null)
            menuBarHeight = menuBar.getPreferredSize().height;
        setSize(insets.left + insets.right + size.width, insets.top
                + insets.bottom + size.height + menuBarHeight);
    }

    class SymAction implements java.awt.event.ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent event) {
            Object object = event.getSource();
//            if (object == send)
//                send_actionPerformed(event);
//            else if (object == score)
//                score_actionPerformed(event);
//            else if (object == nameEntryButton)
//                nameEntryButton_actionPerformed(event);
        }
    }

    void send_actionPerformed(java.awt.event.ActionEvent event) {
        // to do: code goes here.

        send_actionPerformed_Interaction2(event);
    }

    void score_actionPerformed(java.awt.event.ActionEvent event) {
        // to do: code goes here.
    }

    void send_actionPerformed_Interaction2(java.awt.event.ActionEvent event) {
        try {
            // send.addActionListener(d);
            double sscore;
           // sscore = (Double.valueOf(score.getText())).doubleValue();
//            if (sscore <= 5) {
//                swin.removeAll();
//                swin = sbronze;
//                swin.paintComponent(sbronze.getGraphics());
//
//            } else if (sscore > 5 && sscore <= 8) {
//                swin.removeAll();
//                swin = ssilver;
//                swin.paintComponent(ssilver.getGraphics());
//                // swin.setImageURL(ssilver.getImageURL());
//            } else if (sscore > 8 && sscore <= 11) {
//                swin.removeAll();
//                swin = sgold;
//                swin.paintComponent(sgold.getGraphics());
//                // swin.setImageURL(sgold.getImageURL());
//            }

        } catch (Exception e) {
        }
    }

    class SymMouse extends java.awt.event.MouseAdapter {
        public void mouseClicked(java.awt.event.MouseEvent event) {
            Object object = event.getSource();
            if (object == score)
                score_mouseClicked(event);
        }
    }

    void score_mouseClicked(java.awt.event.MouseEvent event) {
        // to do: code goes here.

        score_mouseClicked_Interaction1(event);
    }

    void score_mouseClicked_Interaction1(java.awt.event.MouseEvent event) {
        try {
            // score Set the JTextField's text; convert double->class
            // java.lang.String
            // score.setText(java.lang.String.valueOf(this.fin));
        } catch (java.lang.Exception e) {
        }
    }

    void nameEntryButton_actionPerformed(java.awt.event.ActionEvent event) {
        // to do: code goes here.

        nameEntryButton_actionPerformed_Interaction1(event);
    }

    void nameEntryButton_actionPerformed_Interaction1(java.awt.event.ActionEvent event) {
        try {
//            double sscore;
//            sscore = (Double.valueOf(score2.getText())).doubleValue();
//            if (sscore <= 330) {
//                mwin.removeAll();
//                mwin = mbronze;
//                mwin.paintComponent(mbronze.getGraphics());
//
//            } else if (sscore > 330 && sscore <= 600) {
//                mwin.removeAll();
//                mwin = msilver;
//                mwin.paintComponent(msilver.getGraphics());
//
//            } else if (sscore > 600 && sscore <= 1000) {
//                mwin.removeAll();
//                mwin = mgold;
//                mwin.paintComponent(mgold.getGraphics());
//
//            }

        } catch (Exception e) {
        }

    }

    public static void main(String[] args) {
        (new Trophy("Trophies!!!")).setVisible(true);
    }

}