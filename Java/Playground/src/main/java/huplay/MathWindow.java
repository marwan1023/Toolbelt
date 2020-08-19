package huplay;

import javax.swing.*;
import java.awt.*;

public abstract class MathWindow extends JFrame {


    ClassLoader classLoader = getClass().getClassLoader();
    Score score = Score.getInstance();

    JTextField plusbox = new JTextField();
    JTextField xbox = new JTextField();
    JTextField ybox = new JTextField();
    JTextField zbox = new JTextField();
    JButton enterbutton = new JButton();
    JTextField diologebox = new JTextField();
    JTextField scorebox = new JTextField();
    JLabel JLabel1 = new JLabel();

    JLabel equalsign = new JLabel();
    JTextField f = new JTextField();
    JTextField answbox = new JTextField();
    JButton answer = new JButton();

    JLabel JLabel2 = new JLabel();
    JButton nameEntryButton = new JButton();
    JButton JButton2 = new JButton();
    JButton JButton3 = new JButton();

    ImagePanel imagePanel1 = new ImagePanel();
    ImagePanel imagePanel2 = new ImagePanel();

    JLabel JLabel3 = new JLabel();
    JLabel JLabel4 = new JLabel();

    ImagePanel imagePanel3 = new ImagePanel();
    ImagePanel imagePanel4 = new ImagePanel();

    // Image Viewers
    ImagePanel imageViewer1;
    ImagePanel imageViewer2;
    ImagePanel imageViewer3;
    ImagePanel imageViewer4;
    ImagePanel imageViewer5;
    ImagePanel imageViewer6;
    ImagePanel imageViewer7;
    ImagePanel imageViewer8;
    ImagePanel imageViewer9;
    ImagePanel imageViewer10;
    ImagePanel imageViewer11;


    public void configureMathFrame() {

        // {{INIT_CONTROLS
        getContentPane().setLayout(null);
        getContentPane().setBackground(java.awt.Color.white);
        setSize(647, 477);
        setVisible(false);
        plusbox.setText("+");
        plusbox.setSelectionColor(new java.awt.Color(204, 204, 255));
        plusbox.setSelectedTextColor(java.awt.Color.black);
        plusbox.setCaretColor(java.awt.Color.black);
        plusbox.setDisabledTextColor(new java.awt.Color(153, 153, 153));

        getContentPane().add(plusbox);
        plusbox.setBounds(216, 108, 12, 40);
        plusbox.setVisible(false);
        xbox.setText("0");
        xbox.setSelectionColor(new java.awt.Color(204, 204, 255));
        xbox.setSelectedTextColor(java.awt.Color.black);
        xbox.setCaretColor(java.awt.Color.black);
        xbox.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        getContentPane().add(xbox);
        xbox.setBounds(168, 108, 48, 40);
        xbox.setVisible(false);
        ybox.setText("0");
        ybox.setSelectionColor(new java.awt.Color(204, 204, 255));
        ybox.setSelectedTextColor(java.awt.Color.black);
        ybox.setCaretColor(java.awt.Color.black);
        ybox.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        getContentPane().add(ybox);
        ybox.setBounds(264, 108, 48, 40);
        ybox.setVisible(false);
        zbox.setSelectionColor(new java.awt.Color(204, 204, 255));
        zbox.setSelectedTextColor(java.awt.Color.black);
        zbox.setCaretColor(java.awt.Color.black);
        zbox.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        zbox.setEnabled(false);
        getContentPane().add(zbox);
        zbox.setBounds(540, 180, 84, 40);
        enterbutton.setText("Answer!");
        enterbutton.setActionCommand("Answer!");
        getContentPane().add(enterbutton);
        enterbutton.setEnabled(false);
        enterbutton.setBounds(528, 228, 108, 40);
        diologebox
                .setText("Hello and Welcome to the Math page. Enjoy!");
        diologebox.setSelectionColor(new java.awt.Color(204, 204, 255));
        diologebox.setSelectedTextColor(java.awt.Color.black);
        diologebox.setCaretColor(java.awt.Color.black);
        diologebox.setHorizontalAlignment(SwingConstants.CENTER);
        diologebox.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        getContentPane().add(diologebox);
        diologebox.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 14));
        diologebox.setBounds(120, 288, 396, 40);
        scorebox.setText("" + score.getMathScore());
        scorebox.setSelectionColor(new java.awt.Color(204, 204, 255));
        scorebox.setSelectedTextColor(java.awt.Color.black);
        scorebox.setCaretColor(java.awt.Color.black);
        scorebox.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        scorebox.setEnabled(false);

        getContentPane().add(scorebox);
        scorebox.setBounds(504, 396, 84, 40);
        JLabel1.setText("Score");
        getContentPane().add(JLabel1);
        JLabel1.setBounds(516, 360, 60, 40);

        equalsign.setIconTextGap(9);
        equalsign.setText("=");
        getContentPane().add(equalsign);
        equalsign.setForeground(java.awt.Color.darkGray);
        equalsign.setFont(new Font("Dialog", Font.BOLD, 40));
        equalsign.setBounds(324, 108, 60, 40);
        equalsign.setVisible(false);
        f.setSelectionColor(new java.awt.Color(204, 204, 255));
        f.setSelectedTextColor(java.awt.Color.black);
        f.setCaretColor(java.awt.Color.black);
        f.setEnabled(false);
        f.setText(""+score.getMathHighScore());
        f.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        getContentPane().add(f);
        f.setBounds(384, 396, 84, 40);
        answbox.setSelectionColor(new java.awt.Color(204, 204, 255));
        answbox.setSelectedTextColor(java.awt.Color.black);
        answbox.setCaretColor(java.awt.Color.black);
        answbox.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        answbox.setEnabled(false);
        getContentPane().add(answbox);
        answbox.setBounds(180, 336, 84, 40);
        answer.setText("Give Up!");
        answer.setActionCommand("Give Up!");
        answer.setEnabled(false);
        getContentPane().add(answer);
        answer.setBounds(24, 336, 96, 40);

        JLabel2.setText("Hi-Score");
        getContentPane().add(JLabel2);
        JLabel2.setBounds(396, 360, 60, 40);
        nameEntryButton.setText("L2");
        nameEntryButton.setActionCommand("Close mathgame");
        getContentPane().add(nameEntryButton);
        nameEntryButton.setBounds(60, 108, 48, 24);
        JButton2.setText("L3");
        JButton2.setActionCommand("Close mathgame");
        getContentPane().add(JButton2);
        JButton2.setBounds(108, 108, 48, 24);
        JButton3.setText("L1");
        JButton3.setActionCommand("level1");
        getContentPane().add(JButton3);
        JButton3.setBounds(12, 108, 48, 24);
        imagePanel1.setLayout(null);
        getContentPane().add(imagePanel1);
        imagePanel1.setBounds(0, 156, 108, 108);
        imagePanel2.setLayout(null);
        getContentPane().add(imagePanel2);
        imagePanel2.setBounds(120, 156, 108, 108);
        JLabel3.setIconTextGap(9);
        JLabel3.setText("+");
        getContentPane().add(JLabel3);
        JLabel3.setForeground(java.awt.Color.darkGray);
        JLabel3.setFont(new Font("Dialog", Font.BOLD, 40));
        JLabel3.setBounds(240, 192, 60, 40);
        JLabel4.setIconTextGap(9);
        JLabel4.setText("=");
        getContentPane().add(JLabel4);
        JLabel4.setForeground(java.awt.Color.darkGray);
        JLabel4.setFont(new Font("Dialog", Font.BOLD, 40));
        JLabel4.setBounds(516, 180, 60, 40);
        imagePanel3.setLayout(null);
        getContentPane().add(imagePanel3);
        imagePanel3.setBounds(264, 156, 108, 108);
        imagePanel4.setLayout(null);
        getContentPane().add(imagePanel4);
        imagePanel4.setBounds(384, 156, 108, 108);

        imageViewer1 = new ImagePanel(classLoader.getResource("0.jpg"));

        getContentPane().add(imageViewer1);
        imageViewer1.setBounds(624, 60, 24, 60);
        imageViewer1.setVisible(false);

        imageViewer2 = new ImagePanel(classLoader.getResource("1.jpg"));

        getContentPane().add(imageViewer2);
        imageViewer2.setBounds(624, 96, 24, 24);
        imageViewer2.setVisible(false);

        imageViewer3 = new ImagePanel(classLoader.getResource("2.jpg"));

        getContentPane().add(imageViewer3);
        imageViewer3.setBounds(624, 84, 24, 36);
        imageViewer3.setVisible(false);
        imageViewer4 = new ImagePanel(classLoader.getResource("3.jpg"));

        getContentPane().add(imageViewer4);
        imageViewer4.setBounds(612, 96, 36, 24);
        imageViewer4.setVisible(false);
        imageViewer5 = new ImagePanel(classLoader.getResource("4.jpg"));

        getContentPane().add(imageViewer5);
        imageViewer5.setBounds(612, 84, 36, 48);
        imageViewer5.setVisible(false);
        imageViewer6 = new ImagePanel(classLoader.getResource("5.jpg"));

        getContentPane().add(imageViewer6);
        imageViewer6.setBounds(612, 84, 48, 36);
        imageViewer6.setVisible(false);
        imageViewer7 = new ImagePanel(classLoader.getResource("6.jpg"));

        getContentPane().add(imageViewer7);
        imageViewer7.setBounds(624, 84, 24, 48);
        imageViewer7.setVisible(false);
        imageViewer8 = new ImagePanel(classLoader.getResource("7.jpg"));

        getContentPane().add(imageViewer8);
        imageViewer8.setBounds(612, 84, 48, 48);
        imageViewer8.setVisible(false);
        imageViewer9 = new ImagePanel(classLoader.getResource("8.jpg"));

        getContentPane().add(imageViewer9);
        imageViewer9.setBounds(612, 96, 36, 24);
        imageViewer9.setVisible(false);
        imageViewer10 = new ImagePanel(classLoader.getResource("9.jpg"));

        getContentPane().add(imageViewer10);
        imageViewer10.setBounds(612, 84, 48, 36);
        imageViewer10.setVisible(false);

        imageViewer11 = new ImagePanel(classLoader.getResource("math.gif"));
        getContentPane().add(imageViewer11);
        imageViewer11.setBounds(96, 12, 481, 56);

    }


}
