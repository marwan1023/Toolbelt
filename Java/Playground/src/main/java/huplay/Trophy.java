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

    private JLabel spellingLabel = new JLabel();
    private JLabel spellingScore = new JLabel();

    private JLabel mathLabel = new JLabel();
    private JLabel mathScore = new JLabel();

    private ImagePanel imageViewer1;
    private ImagePanel imageViewer2;

    private ImagePanel sbronze;
    private ImagePanel ssilver;
    private ImagePanel sgold;

    private ImagePanel mbronze;
    private ImagePanel msilver;
    private ImagePanel mgold;


    public Trophy() {

        getContentPane().setLayout(null);
        getContentPane().setBackground(java.awt.Color.white);
        setSize(652, 485);

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
        msilver.setVisible(false);

        mgold = new ImagePanel(classLoader.getResource("mgold.gif").getFile());
        mgold.setBackground(Color.WHITE);
        getContentPane().add(mgold);

        mgold.setBounds(360, 228, 264, 239);
        mgold.setVisible(false);


        showTrophies();
    }

    public Trophy(String sTitle) {
        this();
        setTitle(sTitle);
    }

    private void showTrophies() {

        int spellingScore = score.getSpellingScore();
        int mathScore = score.getMathScore();

        if (spellingScore >= 5 && spellingScore <= 20) {

            sbronze.setVisible(true);


        } else if (spellingScore > 20 && spellingScore <= 30) {
            ssilver.setVisible(true);

        } else if (spellingScore > 30 && spellingScore <= 40) {
            sgold.setVisible(true);
        }

        if (mathScore >=5 && mathScore <= 70) {
            mbronze.setVisible(true);


        } else if (mathScore > 70 && mathScore <= 100) {
            msilver.setVisible(true);


        } else if (mathScore > 100 && mathScore <= 125) {
            mgold.setVisible(true);


        }
    }


}