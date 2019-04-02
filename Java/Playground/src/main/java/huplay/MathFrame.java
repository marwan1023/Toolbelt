package huplay;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MathFrame extends JFrame {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private ClassLoader classLoader = getClass().getClassLoader();

    // {{DECLARE_CONTROLS
    JTextField plusbox = new JTextField();
    JTextField xbox = new JTextField();
    JTextField ybox = new JTextField();
    JTextField zbox = new JTextField();
    JButton enterbutton = new JButton();
    JTextField diologebox = new JTextField();
    JTextField scorebox = new JTextField();
    JLabel JLabel1 = new JLabel();
    // JButton startbutton = new JButton();
    JLabel equalsign = new JLabel();
    JTextField f = new JTextField();
    JTextField answbox = new JTextField();
    JButton answer = new JButton();

    JLabel JLabel2 = new JLabel();
    JButton JButton1 = new JButton();
    JButton JButton2 = new JButton();
    JButton JButton3 = new JButton();

    ImagePanel imagePanel1 = new ImagePanel();
    ImagePanel imagePanel2 = new ImagePanel();

    JLabel JLabel3 = new JLabel();
    JLabel JLabel4 = new JLabel();

    ImagePanel imagePanel3 = new ImagePanel();
    ImagePanel imagePanel4 = new ImagePanel();

    // Image Viewers
    ImagePanel imageViewer1 = new ImagePanel();
    ImagePanel imageViewer2 = new ImagePanel();
    ImagePanel imageViewer3 = new ImagePanel();
    ImagePanel imageViewer4 = new ImagePanel();
    ImagePanel imageViewer5 = new ImagePanel();
    ImagePanel imageViewer6 = new ImagePanel();
    ImagePanel imageViewer7 = new ImagePanel();
    ImagePanel imageViewer8 = new ImagePanel();
    ImagePanel imageViewer9 = new ImagePanel();
    ImagePanel imageViewer10 = new ImagePanel();
    ImagePanel imageViewer11 = new ImagePanel();

    int hiscore = 330;
    int giveup = 0;
    int clone = 0;
    int randx = 0;
    int randy = 0;
    int randsign = 0;
    int ans;
    int score = 0;
    int level = 0;
    Thread waitThread;

    public MathFrame() {

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
        plusbox.setBounds(216, 108, 48, 40);
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
        getContentPane().add(zbox);
        zbox.setBounds(540, 180, 84, 40);
        enterbutton.setText("Answer!");
        enterbutton.setActionCommand("Answer!");
        getContentPane().add(enterbutton);
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
        scorebox.setText("0.0");
        scorebox.setSelectionColor(new java.awt.Color(204, 204, 255));
        scorebox.setSelectedTextColor(java.awt.Color.black);
        scorebox.setCaretColor(java.awt.Color.black);
        scorebox.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        getContentPane().add(scorebox);
        scorebox.setBounds(504, 396, 84, 40);
        JLabel1.setText("Score");
        getContentPane().add(JLabel1);
        JLabel1.setBounds(516, 360, 60, 40);

        // startbutton.setText("Start Question");
        // startbutton.setActionCommand("next question");
        // getContentPane().add(startbutton);
        // startbutton.setBounds(276,84,132,24);

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
        f.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        getContentPane().add(f);
        f.setBounds(384, 396, 84, 40);
        answbox.setSelectionColor(new java.awt.Color(204, 204, 255));
        answbox.setSelectedTextColor(java.awt.Color.black);
        answbox.setCaretColor(java.awt.Color.black);
        answbox.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        getContentPane().add(answbox);
        answbox.setBounds(180, 336, 84, 40);
        answer.setText("Give Up!");
        answer.setActionCommand("Give Up!");
        getContentPane().add(answer);
        answer.setBounds(24, 336, 96, 40);

        JLabel2.setText("Hi-Score");
        getContentPane().add(JLabel2);
        JLabel2.setBounds(396, 360, 60, 40);
        JButton1.setText("L2");
        JButton1.setActionCommand("Close mathgame");
        getContentPane().add(JButton1);
        JButton1.setBounds(60, 108, 48, 24);
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

        imageViewer1 = new ImagePanel(classLoader.getResource("0.jpg").getFile());

        getContentPane().add(imageViewer1);
        imageViewer1.setBounds(624, 60, 24, 60);
        imageViewer1.setVisible(false);

        imageViewer2 = new ImagePanel(classLoader.getResource("1.jpg").getFile());

        getContentPane().add(imageViewer2);
        imageViewer2.setBounds(624, 96, 24, 24);
        imageViewer2.setVisible(false);

        imageViewer3 = new ImagePanel(classLoader.getResource("2.jpg").getFile());

        getContentPane().add(imageViewer3);
        imageViewer3.setBounds(624, 84, 24, 36);
        imageViewer3.setVisible(false);
        imageViewer4 = new ImagePanel(classLoader.getResource("3.jpg").getFile());

        getContentPane().add(imageViewer4);
        imageViewer4.setBounds(612, 96, 36, 24);
        imageViewer4.setVisible(false);
        imageViewer5 = new ImagePanel(classLoader.getResource("4.jpg").getFile());

        getContentPane().add(imageViewer5);
        imageViewer5.setBounds(612, 84, 36, 48);
        imageViewer5.setVisible(false);
        imageViewer6 = new ImagePanel(classLoader.getResource("5.jpg").getFile());

        getContentPane().add(imageViewer6);
        imageViewer6.setBounds(612, 84, 48, 36);
        imageViewer6.setVisible(false);
        imageViewer7 = new ImagePanel(classLoader.getResource("6.jpg").getFile());

        getContentPane().add(imageViewer7);
        imageViewer7.setBounds(624, 84, 24, 48);
        imageViewer7.setVisible(false);
        imageViewer8 = new ImagePanel(classLoader.getResource("7.jpg").getFile());

        getContentPane().add(imageViewer8);
        imageViewer8.setBounds(612, 84, 48, 48);
        imageViewer8.setVisible(false);
        imageViewer9 = new ImagePanel(classLoader.getResource("8.jpg").getFile());

        getContentPane().add(imageViewer9);
        imageViewer9.setBounds(612, 96, 36, 24);
        imageViewer9.setVisible(false);
        imageViewer10 = new ImagePanel(classLoader.getResource("9.jpg").getFile());

        getContentPane().add(imageViewer10);
        imageViewer10.setBounds(612, 84, 48, 36);
        imageViewer10.setVisible(false);
        
        imageViewer11 = new ImagePanel(classLoader.getResource("math.gif").getFile());
        getContentPane().add(imageViewer11);
        imageViewer11.setBounds(96, 12, 481, 56);


        // {{REGISTER_LISTENERS

        SymAction lSymAction = new SymAction();

        enterbutton.addActionListener(lSymAction);
        answer.addActionListener(lSymAction);

        JButton3.addActionListener(lSymAction);
        JButton2.addActionListener(lSymAction);
        JButton1.addActionListener(lSymAction);

        
    }

    class SymAction implements java.awt.event.ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent event) {
            Object object = event.getSource();
            if (object == enterbutton)
                enterbutton_actionPerformed(event);
            else if (object == answer)
                answer_actionPerformed(event);
            else if (object == JButton3)
                try {
                    JButton3_actionPerformed(event);
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }
            else if (object == JButton2)
                try {
                    JButton2_actionPerformed(event);
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }
            else if (object == JButton1)
                try {
                    JButton1_actionPerformed(event);
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }

        }
    }

    void startbutton_actionPerformed(java.awt.event.ActionEvent event) {
        // to do: code goes here.

        startbutton_actionPerformed_Interaction1(event);

        startbutton_actionPerformed_Interaction2(event);

        startbutton_actionPerformed_Interaction3(event);
    }

    void startbutton_actionPerformed_Interaction1(
            java.awt.event.ActionEvent event) {
        if (level < 1)
            new PlaySound(classLoader.getResource("skill.au").getFile());
        else {
            try {

                
                int contin = 1;
                if (giveup == 0) {
                    if (level == 1)
                        randx = Double.valueOf(Math.random() * 10).intValue();
                    if (level == 2)
                        randx = Double.valueOf(Math.random() * 30).intValue();
                    if (level == 3)
                        randx = Double.valueOf(Math.random() * 50).intValue();
                }
                clone = randx;

                imageViewer1.setBounds(0, 156, 108, 108);
                imagePanel1.removeAll();
                imagePanel1 = imageViewer1;
                imagePanel1.paintComponent(imageViewer1.getGraphics());

                imageViewer2.setBounds(120, 156, 108, 108);
                imagePanel2.removeAll();
                imagePanel2 = imageViewer2;
                imagePanel2.paintComponent(imageViewer2.getGraphics());

                for (int loop = 1; loop > 0; --loop) {
                    if (randx == 0) {
                        xbox.setText("0");
                        new PlaySound(classLoader.getResource("zero.au").getFile());
                        Thread.sleep(500);

                        imageViewer1.setBounds(120, 156, 108, 108);
                        imagePanel2.removeAll();
                        imagePanel2 = imageViewer1;
                        imagePanel2.paintComponent(imageViewer1.getGraphics());

                    }
                    if (randx == 1) {
                        xbox.setText("1"); 
                        new PlaySound(classLoader.getResource("one.au").getFile());
                        Thread.sleep(500);

                        imageViewer2.setBounds(120, 156, 108, 108);
                        imagePanel2.removeAll();
                        imagePanel2 = imageViewer2;
                        imagePanel2.paintComponent(imageViewer2.getGraphics());

                    }
                    if (randx == 2) {
                        xbox.setText("2");
                        new PlaySound(classLoader.getResource("two.au").getFile());
                        Thread.sleep(500);

                        imageViewer3.setBounds(120, 156, 108, 108);
                        imagePanel2.removeAll();
                        imagePanel2 = imageViewer3;
                        imagePanel2.paintComponent(imageViewer3.getGraphics());

                    }
                    if (randx == 3) {
                        xbox.setText("3");
                        new PlaySound(classLoader.getResource("three.au").getFile());
                        Thread.sleep(500);
                        imageViewer4.setBounds(120, 156, 108, 108);
                        imagePanel2.removeAll();
                        imagePanel2 = imageViewer4;
                        imagePanel2.paintComponent(imageViewer4.getGraphics());

                    }
                    if (randx == 4) {
                        xbox.setText("4");
                        new PlaySound(classLoader.getResource("four.au").getFile());
                        Thread.sleep(500);

                        imageViewer5.setBounds(120, 156, 108, 108);
                        imagePanel2.removeAll();
                        imagePanel2 = imageViewer5;
                        imagePanel2.paintComponent(imageViewer5.getGraphics());

                    }
                    if (randx == 5) {
                        xbox.setText("5");
                        new PlaySound(classLoader.getResource("five.au").getFile());
                        Thread.sleep(500);
                        imageViewer6.setBounds(120, 156, 108, 108);
                        imagePanel2.removeAll();
                        imagePanel2 = imageViewer6;
                        imagePanel2.paintComponent(imageViewer6.getGraphics());

                    }
                    if (randx == 6) {
                        xbox.setText("6");
                        new PlaySound(classLoader.getResource("six.au").getFile());
                        Thread.sleep(500);
                        ;
                        imageViewer7.setBounds(120, 156, 108, 108);
                        imagePanel2.removeAll();
                        imagePanel2 = imageViewer7;
                        imagePanel2.paintComponent(imageViewer7.getGraphics());

                    }
                    if (randx == 7) {
                        xbox.setText("7");
                        new PlaySound(classLoader.getResource("seven.au").getFile());
                        Thread.sleep(500);

                        imageViewer8.setBounds(120, 156, 108, 108);
                        imagePanel2.removeAll();
                        imagePanel2 = imageViewer8;
                        imagePanel2.paintComponent(imageViewer8.getGraphics());

                    }
                    if (randx == 8) {
                        xbox.setText("8");
                        new PlaySound(classLoader.getResource("eight.au").getFile());
                        Thread.sleep(500);

                        imageViewer9.setBounds(120, 156, 108, 108);
                        imagePanel2.removeAll();
                        imagePanel2 = imageViewer9;
                        imagePanel2.paintComponent(imageViewer9.getGraphics());

                    }
                    if (randx == 9) {
                        xbox.setText("9");
                        new PlaySound(classLoader.getResource("nine.au").getFile());
                        Thread.sleep(500);

                        imageViewer10.setBounds(120, 156, 108, 108);
                        imagePanel2.removeAll();
                        imagePanel2 = imageViewer10;
                        imagePanel2.paintComponent(imageViewer10.getGraphics());

                    }

                    if (randx == 10) {
                        xbox.setText("10");
                        new PlaySound(classLoader.getResource("ten.au").getFile());
                        Thread.sleep(500);

                        imageViewer2.setBounds(0, 156, 108, 108);
                        imagePanel1.removeAll();
                        imagePanel1 = imageViewer2;
                        imagePanel1.paintComponent(imageViewer2.getGraphics());
                        

                        imageViewer1.setBounds(120, 156, 108, 108);
                        imagePanel2.removeAll();
                        imagePanel2 = imageViewer1;
                        imagePanel2.paintComponent(imageViewer1.getGraphics());

                    }
                    if (randx == 11) {
                        xbox.setText("11");
                        new PlaySound(classLoader.getResource("eleven.au").getFile());
                        Thread.sleep(500);

                        imageViewer2.setBounds(0, 156, 108, 108);
                        imagePanel1.removeAll();
                        imagePanel1 = imageViewer2;
                        imagePanel1.paintComponent(imageViewer2.getGraphics());

                        imageViewer2.setBounds(120, 156, 108, 108);
                        imagePanel2.removeAll();
                        imagePanel2 = imageViewer2;
                        imagePanel2.paintComponent(imageViewer2.getGraphics());

                    }
                    if (randx == 12) {
                        xbox.setText("12");
                        new PlaySound(classLoader.getResource("twell.au").getFile());
                        Thread.sleep(500);

                        imageViewer2.setBounds(0, 156, 108, 108);
                        imagePanel1.removeAll();
                        imagePanel1 = imageViewer2;
                        imagePanel1.paintComponent(imageViewer2.getGraphics());

                        imageViewer2.setBounds(120, 156, 108, 108);
                        imagePanel2.removeAll();
                        imagePanel2 = imageViewer3;
                        imagePanel2.paintComponent(imageViewer3.getGraphics());

                    }
                    if (randx == 13) {
                        xbox.setText("13");
                        new PlaySound(classLoader.getResource("thierdteen.au").getFile());
                        Thread.sleep(500);

                        imageViewer2.setBounds(0, 156, 108, 108);
                        imagePanel1.removeAll();
                        imagePanel1 = imageViewer2;
                        imagePanel1.paintComponent(imageViewer2.getGraphics());

                        imageViewer4.setBounds(120, 156, 108, 108);
                        imagePanel2.removeAll();
                        imagePanel2 = imageViewer4;
                        imagePanel2.paintComponent(imageViewer4.getGraphics());

                    }
                    if (randx == 14) {
                        xbox.setText("14");
                        new PlaySound(classLoader.getResource("14.au").getFile());
                        Thread.sleep(500);

                        imageViewer2.setBounds(0, 156, 108, 108);
                        imagePanel1.removeAll();
                        imagePanel1 = imageViewer2;
                        imagePanel1.paintComponent(imageViewer2.getGraphics());
                        imageViewer5.setBounds(120, 156, 108, 108);
                        imagePanel2.removeAll();
                        imagePanel2 = imageViewer5;
                        imagePanel2.paintComponent(imageViewer5.getGraphics());

                    }
                    if (randx == 15) {
                        xbox.setText("15");
                        new PlaySound(classLoader.getResource("15.au").getFile());
                        Thread.sleep(500);

                        imageViewer2.setBounds(0, 156, 108, 108);
                        imagePanel1.removeAll();
                        imagePanel1 = imageViewer2;
                        imagePanel1.paintComponent(imageViewer2.getGraphics());

                        imageViewer6.setBounds(120, 156, 108, 108);
                        imagePanel2.removeAll();
                        imagePanel2 = imageViewer6;
                        imagePanel2.paintComponent(imageViewer6.getGraphics());

                    }
                    if (randx == 16) {
                        xbox.setText("16");
                        new PlaySound(classLoader.getResource("16.au").getFile());
                        Thread.sleep(500);

                        imageViewer2.setBounds(0, 156, 108, 108);
                        imagePanel1.removeAll();
                        imagePanel1 = imageViewer2;
                        imagePanel1.paintComponent(imageViewer2.getGraphics());

                        imageViewer7.setBounds(0, 156, 108, 108);
                        imagePanel2.removeAll();
                        imagePanel2 = imageViewer7;
                        imagePanel2.paintComponent(imageViewer7.getGraphics());

                    }
                    if (randx == 17) {
                        xbox.setText("17");
                        new PlaySound(classLoader.getResource("17.au").getFile());
                        Thread.sleep(500);

                        imageViewer2.setBounds(0, 156, 108, 108);
                        imagePanel1.removeAll();
                        imagePanel1 = imageViewer2;
                        imagePanel1.paintComponent(imageViewer2.getGraphics());

                        imageViewer8.setBounds(120, 156, 108, 108);
                        imagePanel2.removeAll();
                        imagePanel2 = imageViewer8;
                        imagePanel2.paintComponent(imageViewer8.getGraphics());

                    }
                    if (randx == 18) {
                        xbox.setText("18");
                        new PlaySound(classLoader.getResource("18.au").getFile());
                        Thread.sleep(500);

                        imageViewer2.setBounds(0, 156, 108, 108);
                        imagePanel1.removeAll();
                        imagePanel1 = imageViewer2;
                        imagePanel1.paintComponent(imageViewer2.getGraphics());
                        imageViewer9.setBounds(120, 156, 108, 108);
                        imagePanel2.removeAll();
                        imagePanel2 = imageViewer9;
                        imagePanel2.paintComponent(imageViewer9.getGraphics());

                    }
                    if (randx == 19) {
                        xbox.setText("19");
                        new PlaySound(classLoader.getResource("19.au").getFile());
                        Thread.sleep(500);
                        imageViewer2.setBounds(0, 156, 108, 108);
                        imagePanel1.removeAll();
                        imagePanel1 = imageViewer2;
                        imagePanel1.paintComponent(imageViewer2.getGraphics());
                        imageViewer10.setBounds(120, 156, 108, 108);
                        imagePanel2.removeAll();
                        imagePanel2 = imageViewer10;
                        imagePanel2.paintComponent(imageViewer10.getGraphics());

                    }

                    if (randx > 19 && randx < 30) {
                        xbox.setText("20");
                        new PlaySound(classLoader.getResource("20.au").getFile());
                        Thread.sleep(500);

                        imageViewer3.setBounds(0, 156, 108, 108);
                        imagePanel1.removeAll();
                        imagePanel1 = imageViewer3;
                        imagePanel1.paintComponent(imageViewer3.getGraphics());
                 

                    }
                    if (randx > 29 && randx < 40) {
                        xbox.setText("30");
                        new PlaySound(classLoader.getResource("30.au").getFile());
                        Thread.sleep(500);
                        imageViewer4.setBounds(0, 156, 108, 108);
                        imagePanel1.removeAll();
                        imagePanel1 = imageViewer4;
                        imagePanel1.paintComponent(imageViewer4.getGraphics());
            

                    }

                    if (randx > 39 && randx < 50) {
                        xbox.setText("40");
                        new PlaySound(classLoader.getResource("40.au").getFile());
                        Thread.sleep(500);
                        imageViewer5.setBounds(0, 156, 108, 108);
                        imagePanel1.removeAll();
                        imagePanel1 = imageViewer5;
                        imagePanel1.paintComponent(imageViewer5.getGraphics());
                

                    }
                    if (randx == 50) {
                        xbox.setText("50");
                        new PlaySound(classLoader.getResource("50.au").getFile());
                        Thread.sleep(500);
                        imageViewer6.setBounds(0, 156, 108, 108);
                        imagePanel1.removeAll();
                        imagePanel1 = imageViewer6;
                        imagePanel1.paintComponent(imageViewer6.getGraphics());
               

                    }

                    if (randx == 21 || randx == 31 || randx == 41) {
                        loop = 2;
                        clone = randx;
                        randx = 1;
                    }
                    if (randx == 22 || randx == 32 || randx == 42) {
                        loop = 2;
                        clone = randx;
                        randx = 2;
                    }
                    if (randx == 23 || randx == 33 || randx == 43) {
                        loop = 2;
                        clone = randx;
                        randx = 3;
                    }
                    if (randx == 24 || randx == 34 || randx == 44) {
                        loop = 2;
                        clone = randx;
                        randx = 4;
                    }
                    if (randx == 25 || randx == 35 || randx == 45) {
                        loop = 2;
                        clone = randx;
                        randx = 5;
                    }
                    if (randx == 26 || randx == 36 || randx == 46) {
                        loop = 2;
                        clone = randx;
                        randx = 6;
                    }
                    if (randx == 27 || randx == 37 || randx == 47) {
                        loop = 2;
                        clone = randx;
                        randx = 7;
                    }
                    if (randx == 28 || randx == 38 || randx == 48) {
                        loop = 2;
                        clone = randx;
                        randx = 8;
                    }
                    if (randx == 29 || randx == 39 || randx == 49) {
                        loop = 2;
                        clone = randx;
                        randx = 9;
                    }

                    for (double count = 0; count < 9999999; count++)
                        if (count > 9999997)
                            contin = 2;
                }
                randx = clone;

                if (contin == 2) {
                    // number change for sign box
                    if (giveup == 0)
                        randsign = (int) (Math.random() * 2);
                    if (randsign == 0) {
                        plusbox.setText("+");
                        new PlaySound(classLoader.getResource("pluss.au").getFile());
                        Thread.sleep(500);
                        JLabel3.setText("+");
                    }
                    if (randsign == 1) {
                        plusbox.setText("-");
                        new PlaySound(classLoader.getResource("minus.au").getFile());
                        Thread.sleep(500);
                        JLabel3.setText("-");
                    }
                }
                for (double count = 0; count < 10999999; count++)
                    if (count > 10999997)
                        contin = 3;

                // number change for secount box
                if (giveup == 0) {
                    if (level == 1)
                        randy = (int) (Math.random() * randx);
                    if (level == 2)
                        randy = (int) (Math.random() * 20);
                    if (level == 3)
                        randy = (int) (Math.random() * 50);
                }
                clone = randy;
                imageViewer1.setBounds(264, 156, 108, 108);
                imagePanel3.removeAll();
                imagePanel3 = imageViewer1;
                imagePanel3.paintComponent(imageViewer1.getGraphics());

                imageViewer1.setBounds(384, 156, 108, 108);
                imagePanel4.removeAll();
                imagePanel4 = imageViewer1;
                imagePanel4.paintComponent(imageViewer1.getGraphics());

                for (int loop = 1; loop > 0; --loop) {
                    if (randy == 0) {
                        ybox.setText("0");
                        new PlaySound(classLoader.getResource("zero.au").getFile());

                        imageViewer1.setBounds(384, 156, 108, 108);
                        imagePanel4.removeAll();
                        imagePanel4 = imageViewer1;
                        imagePanel4.paintComponent(imageViewer1.getGraphics());

                    }
                    if (randy == 1) {
                        ybox.setText("1");
                        new PlaySound(classLoader.getResource("one.au").getFile());

                        imageViewer2.setBounds(384, 156, 108, 108);
                        imagePanel4.removeAll();
                        imagePanel4 = imageViewer2;
                        imagePanel4.paintComponent(imageViewer2.getGraphics());

                    }
                    if (randy == 2) {
                        ybox.setText("2");
                        new PlaySound(classLoader.getResource("two.au").getFile());
                        imageViewer3.setBounds(384, 156, 108, 108);
                        imagePanel4.removeAll();
                        imagePanel4 = imageViewer3;
                        imagePanel4.paintComponent(imageViewer3.getGraphics());

                    }
                    if (randy == 3) {
                        ybox.setText("3");
                        new PlaySound(classLoader.getResource("three.au").getFile());

                        imageViewer4.setBounds(384, 156, 108, 108);
                        imagePanel4.removeAll();
                        imagePanel4 = imageViewer4;
                        imagePanel4.paintComponent(imageViewer4.getGraphics());

                    }
                    if (randy == 4) {
                        ybox.setText("4");
                        new PlaySound(classLoader.getResource("four.au").getFile());

                        imageViewer5.setBounds(384, 156, 108, 108);
                        imagePanel4.removeAll();
                        imagePanel4 = imageViewer5;
                        imagePanel4.paintComponent(imageViewer5.getGraphics());

                    }
                    if (randy == 5) {
                        ybox.setText("5");
                        new PlaySound(classLoader.getResource("five.au").getFile());

                        imageViewer6.setBounds(384, 156, 108, 108);
                        imagePanel4.removeAll();
                        imagePanel4 = imageViewer6;
                        imagePanel4.paintComponent(imageViewer6.getGraphics());

                    }
                    if (randy == 6) {
                        ybox.setText("6");
                        new PlaySound(classLoader.getResource("six.au").getFile());

                        imageViewer7.setBounds(384, 156, 108, 108);
                        imagePanel4.removeAll();
                        imagePanel4 = imageViewer7;
                        imagePanel4.paintComponent(imageViewer7.getGraphics());

                    }
                    if (randy == 7) {
                        ybox.setText("7");
                        new PlaySound(classLoader.getResource("seven.au").getFile());

                        imageViewer8.setBounds(384, 156, 108, 108);
                        imagePanel4.removeAll();
                        imagePanel4 = imageViewer8;
                        imagePanel4.paintComponent(imageViewer8.getGraphics());

                    }
                    if (randy == 8) {
                        ybox.setText("8");
                        new PlaySound(classLoader.getResource("eight.au").getFile());

                        imageViewer9.setBounds(384, 156, 108, 108);
                        imagePanel4.removeAll();
                        imagePanel4 = imageViewer9;
                        imagePanel4.paintComponent(imageViewer9.getGraphics());

                    }
                    if (randy == 9) {
                        ybox.setText("9");
                        new PlaySound(classLoader.getResource("nine.au").getFile());

                        imageViewer10.setBounds(384, 156, 108, 108);
                        imagePanel4.removeAll();
                        imagePanel4 = imageViewer10;
                        imagePanel4.paintComponent(imageViewer10.getGraphics());

                    }

                    if (randy == 10) {
                        ybox.setText("10");
                        new PlaySound(classLoader.getResource("ten.au").getFile());

                        imageViewer2.setBounds(264, 156, 108, 108);
                        imagePanel3.removeAll();
                        imagePanel3 = imageViewer2;
                        imagePanel3.paintComponent(imageViewer2.getGraphics());

                        imageViewer1.setBounds(384, 156, 108, 108);
                        imagePanel4.removeAll();
                        imagePanel4 = imageViewer1;
                        imagePanel4.paintComponent(imageViewer1.getGraphics());

                    }
                    if (randy == 11) {
                        ybox.setText("11");
                        new PlaySound(classLoader.getResource("eleven.au").getFile());
                        imageViewer2.setBounds(264, 156, 108, 108);
                        imagePanel3.removeAll();
                        imagePanel3 = imageViewer2;
                        imagePanel3.paintComponent(imageViewer2.getGraphics());

                        imageViewer2.setBounds(384, 156, 108, 108);
                        imagePanel4.removeAll();
                        imagePanel4 = imageViewer2;
                        imagePanel4.paintComponent(imageViewer2.getGraphics());

                    }
                    if (randy == 12) {
                        ybox.setText("12");
                        new PlaySound(classLoader.getResource("twell.au").getFile());
                        imageViewer2.setBounds(264, 156, 108, 108);
                        imagePanel3.removeAll();
                        imagePanel3 = imageViewer2;
                        imagePanel3.paintComponent(imageViewer2.getGraphics());

                        imageViewer3.setBounds(384, 156, 108, 108);
                        imagePanel4.removeAll();
                        imagePanel4 = imageViewer3;
                        imagePanel4.paintComponent(imageViewer3.getGraphics());

                    }
                    if (randy == 13) {
                        ybox.setText("13");
                        new PlaySound(classLoader.getResource("theirdteen.au").getFile());
                        imageViewer2.setBounds(264, 156, 108, 108);
                        imagePanel3.removeAll();
                        imagePanel3 = imageViewer2;
                        imagePanel3.paintComponent(imageViewer2.getGraphics());

                        imageViewer4.setBounds(384, 156, 108, 108);
                        imagePanel4.removeAll();
                        imagePanel4 = imageViewer4;
                        imagePanel4.paintComponent(imageViewer4.getGraphics());

                    }
                    if (randy == 14) {
                        ybox.setText("14");
                        new PlaySound(classLoader.getResource("14.au").getFile());

                        imageViewer2.setBounds(264, 156, 108, 108);
                        imagePanel3.removeAll();
                        imagePanel3 = imageViewer2;
                        imagePanel3.paintComponent(imageViewer2.getGraphics());

                        imageViewer5.setBounds(384, 156, 108, 108);
                        imagePanel4.removeAll();
                        imagePanel4 = imageViewer5;
                        imagePanel4.paintComponent(imageViewer5.getGraphics());

                    }
                    if (randy == 15) {
                        ybox.setText("15");
                        new PlaySound(classLoader.getResource("15.au").getFile());
                        imageViewer2.setBounds(264, 156, 108, 108);
                        imagePanel3.removeAll();
                        imagePanel3 = imageViewer2;
                        imagePanel3.paintComponent(imageViewer2.getGraphics());

                        imageViewer6.setBounds(384, 156, 108, 108);
                        imagePanel4.removeAll();
                        imagePanel4 = imageViewer6;
                        imagePanel4.paintComponent(imageViewer6.getGraphics());

                    }
                    if (randy == 16) {
                        ybox.setText("16");
                        new PlaySound(classLoader.getResource("16.au").getFile());
                        imageViewer2.setBounds(264, 156, 108, 108);
                        imagePanel3.removeAll();
                        imagePanel3 = imageViewer2;
                        imagePanel3.paintComponent(imageViewer2.getGraphics());

                        imageViewer7.setBounds(384, 156, 108, 108);
                        imagePanel4.removeAll();
                        imagePanel4 = imageViewer7;
                        imagePanel4.paintComponent(imageViewer7.getGraphics());

                    }
                    if (randy == 17) {
                        ybox.setText("17");
                        new PlaySound(classLoader.getResource("17.au").getFile());
                        imageViewer2.setBounds(264, 156, 108, 108);
                        imagePanel3.removeAll();
                        imagePanel3 = imageViewer2;
                        imagePanel3.paintComponent(imageViewer2.getGraphics());

                        imageViewer8.setBounds(384, 156, 108, 108);
                        imagePanel4.removeAll();
                        imagePanel4 = imageViewer8;
                        imagePanel4.paintComponent(imageViewer8.getGraphics());

                    }
                    if (randy == 18) {
                        ybox.setText("18");
                        new PlaySound(classLoader.getResource("18.au").getFile());
                        imageViewer2.setBounds(264, 156, 108, 108);
                        imagePanel3.removeAll();
                        imagePanel3 = imageViewer2;
                        imagePanel3.paintComponent(imageViewer2.getGraphics());

                        imageViewer9.setBounds(384, 156, 108, 108);
                        imagePanel4.removeAll();
                        imagePanel4 = imageViewer9;
                        imagePanel4.paintComponent(imageViewer9.getGraphics());

                    }
                    if (randy == 19) {
                        ybox.setText("19");
                        new PlaySound(classLoader.getResource("19.au").getFile());
                        imageViewer2.setBounds(264, 156, 108, 108);
                        imagePanel3.removeAll();
                        imagePanel3 = imageViewer2;
                        imagePanel3.paintComponent(imageViewer2.getGraphics());

                        imageViewer10.setBounds(384, 156, 108, 108);
                        imagePanel4.removeAll();
                        imagePanel4 = imageViewer10;
                        imagePanel4.paintComponent(imageViewer10.getGraphics());

                    }

                    if (randy > 19 && randy < 30) {
                        ybox.setText("20");
                        new PlaySound(classLoader.getResource("20.au").getFile());

                        imageViewer3.setBounds(264, 156, 108, 108);
                        imagePanel3.removeAll();
                        imagePanel3 = imageViewer3;
                        imagePanel3.paintComponent(imageViewer3.getGraphics());

                    

                    }
                    if (randy > 29 && randy < 40) {
                        ybox.setText("30");
                        new PlaySound(classLoader.getResource("30.au").getFile());

                        imageViewer4.setBounds(264, 156, 108, 108);
                        imagePanel3.removeAll();
                        imagePanel3 = imageViewer4;
                        imagePanel3.paintComponent(imageViewer4.getGraphics());

                    }
                    if (randy > 39 && randy < 50) {
                        ybox.setText("40");
                        new PlaySound(classLoader.getResource("40.au").getFile());

                        imageViewer5.setBounds(264, 156, 108, 108);
                        imagePanel3.removeAll();
                        imagePanel3 = imageViewer5;
                        imagePanel3.paintComponent(imageViewer5.getGraphics());

                    }
                    if (randy > 49 && randy < 60) {
                        ybox.setText("50");
                        new PlaySound(classLoader.getResource("50.au").getFile());

                        imageViewer6.setBounds(264, 156, 108, 108);
                        imagePanel3.removeAll();
                        imagePanel3 = imageViewer6;
                        imagePanel3.paintComponent(imageViewer6.getGraphics());

                    }
                    if (randy > 59 && randy < 70) {
                        ybox.setText("60");
                        new PlaySound(classLoader.getResource("60.au").getFile());
                        imageViewer7.setBounds(264, 156, 108, 108);
                        imagePanel3.removeAll();
                        imagePanel3 = imageViewer7;
                        imagePanel3.paintComponent(imageViewer7.getGraphics());

                    }
                    if (randy > 69 && randy < 80) {
                        ybox.setText("70");
                        new PlaySound(classLoader.getResource("70.au").getFile());

                        imageViewer8.setBounds(264, 156, 108, 108);
                        imagePanel3.removeAll();
                        imagePanel3 = imageViewer8;
                        imagePanel3.paintComponent(imageViewer8.getGraphics());

                    }
                    if (randy > 79 && randy < 90) {
                        ybox.setText("80");
                        new PlaySound(classLoader.getResource("80.au").getFile());

                        imageViewer9.setBounds(264, 156, 108, 108);
                        imagePanel3.removeAll();
                        imagePanel3 = imageViewer9;
                        imagePanel3.paintComponent(imageViewer9.getGraphics());

                    }
                    if (randy > 89 && randy < 100) {
                        ybox.setText("90");
                        new PlaySound(classLoader.getResource("90.au").getFile());

                        imageViewer10.setBounds(264, 156, 108, 108);
                        imagePanel3.removeAll();
                        imagePanel3 = imageViewer10;
                        imagePanel3.paintComponent(imageViewer10.getGraphics());

                    }

                    if (randy == 21 || randy == 31 || randy == 41
                            || randy == 51 || randy == 61 || randy == 71
                            || randy == 81 || randy == 91) {
                        loop = 2;
                        clone = randy;
                        randy = 1;
                    }
                    if (randy == 22 || randy == 32 || randy == 42
                            || randy == 52 || randy == 62 || randy == 72
                            || randy == 82 || randy == 92) {
                        loop = 2;
                        clone = randy;
                        randy = 2;
                    }
                    if (randy == 23 || randy == 33 || randy == 43
                            || randy == 53 || randy == 63 || randy == 73
                            || randy == 83 || randy == 93) {
                        loop = 2;
                        clone = randy;
                        randy = 3;
                    }
                    if (randy == 24 || randy == 34 || randy == 44
                            || randy == 54 || randy == 64 || randy == 74
                            || randy == 84 || randy == 94) {
                        loop = 2;
                        clone = randy;
                        randy = 4;
                    }
                    if (randy == 25 || randy == 35 || randy == 45
                            || randy == 55 || randy == 65 || randy == 75
                            || randy == 85 || randy == 95) {
                        loop = 2;
                        clone = randy;
                        randy = 5;
                    }
                    if (randy == 26 || randy == 36 || randy == 46
                            || randy == 56 || randy == 66 || randy == 76
                            || randy == 86 || randy == 96) {
                        loop = 2;
                        clone = randy;
                        randy = 6;
                    }
                    if (randy == 27 || randy == 37 || randy == 47
                            || randy == 57 || randy == 67 || randy == 77
                            || randy == 87 || randy == 97) {
                        loop = 2;
                        clone = randy;
                        randy = 7;
                    }
                    if (randy == 28 || randy == 38 || randy == 48
                            || randy == 58 || randy == 68 || randy == 78
                            || randy == 88 || randy == 98) {
                        loop = 2;
                        clone = randy;
                        randy = 8;
                    }
                    if (randy == 29 || randy == 39 || randy == 49
                            || randy == 59 || randy == 69 || randy == 79
                            || randy == 89 || randy == 99) {
                        loop = 2;
                        clone = randy;
                        randy = 9;
                    }
                    for (double count = 0; count < 9999999; count++)
                        ;
                }
                randy = clone;

                if (randsign == 0) {
                    Thread.sleep(500);
                    new PlaySound(classLoader.getResource("equals.au").getFile());
                    ans = randx + randy;

                }
                if (randsign == 1) {
                    new PlaySound(classLoader.getResource("equals.au").getFile());
                    ans = randx - randy;

                }

            } catch (java.lang.Exception e) {
            }
        }
    }

    void enterbutton_actionPerformed(java.awt.event.ActionEvent event) {
        // to do: code goes here.

        enterbutton_actionPerformed_Interaction1(event);
    }

    void enterbutton_actionPerformed_Interaction1(
            java.awt.event.ActionEvent event) {
        double a;
        try {
            // diologebox Set the JTextField's text
            // a = (double.valueOf(zbox.getText()).DoubleValue();
            a = (Double.valueOf(zbox.getText())).doubleValue();
            f.setText(String.valueOf(hiscore));
            for (double count = 0; count < 39999999; count++)
                ;
            // ;
            if (score == hiscore) {
                new PlaySound(classLoader.getResource("unbeleave.au").getFile());
                hiscore = hiscore + 330;
                for (double count = 0; count < 5999999; count++)
                    ;
                new PlaySound(classLoader.getResource("hi-score.au").getFile());// put
                                                                      // good
                                                                      // stuff
                                                                      // here//
                for (double count = 0; count < 5999999; count++)
                    ;
            }

            // answbox.setText(String.valueOf(ans));

            if (ans == a) {
                int rand1;
                rand1 = Double.valueOf(Math.random() * 6).intValue();
                if (rand1 == 0)
                    new PlaySound(classLoader.getResource("goodjob.au").getFile());
                Thread.sleep(500);
                if (rand1 == 1)
                    new PlaySound(classLoader.getResource("super.au").getFile());
                Thread.sleep(500);
                if (rand1 == 2)
                    new PlaySound(classLoader.getResource("wowgratejob.au").getFile());
                Thread.sleep(500);
                if (rand1 == 3)
                    new PlaySound(classLoader.getResource("u.practice.au").getFile());
                Thread.sleep(500);
                if (rand1 == 4)
                    new PlaySound(classLoader.getResource("yagotit.au").getFile());
                Thread.sleep(500);
                if (rand1 == 5)
                    new PlaySound(classLoader.getResource("let.lay.au").getFile());
                Thread.sleep(500);

                diologebox.setText("Right");
                score = score + 33;
                scorebox.setText(String.valueOf(score));
                for (double count = 0; count < 19999999; count++)
                    ;
                startbutton_actionPerformed_Interaction1(event);
            } else if (ans != a) {
                int rand1;
                rand1 = Double.valueOf(Math.random() * 2).intValue();
                if (rand1 == 0)
                    // soundPlayer1.play();
                    new PlaySound(classLoader.getResource("betterluck.au").getFile());
                if (rand1 == 1)
                    new PlaySound(classLoader.getResource("tryagain.au").getFile());
                diologebox.setText("wrong");
            }

        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        zbox.setText("");
    }

    void answer_actionPerformed(java.awt.event.ActionEvent event) {
        // to do: code goes here.

        answer_actionPerformed_Interaction1(event);
    }

    void answer_actionPerformed_Interaction1(java.awt.event.ActionEvent event) {
        try {
            giveup = 1;
            // ybox Set the JTextField's text
            answbox.setText(String.valueOf(ans));
            startbutton_actionPerformed_Interaction1(event);
            for (double count = 0; count < 9999999; count++)
                ;
            giveup = 0;
            
            int subans = ans;
            
            for (int loop = 1; loop > 0; --loop) {
                if (subans == 0) {
                    new PlaySound(classLoader.getResource("zero.au").getFile());
                    Thread.sleep(500);
                }
                if (subans == 1) {
                    new PlaySound(classLoader.getResource("one.au").getFile());
                    Thread.sleep(500);
                }
                if (subans == 2) {
                    new PlaySound(classLoader.getResource("two.au").getFile());
                    Thread.sleep(500);
                }
                if (subans == 3) {
                    new PlaySound(classLoader.getResource("three.au").getFile());
                    Thread.sleep(500);
                }
                if (subans == 4) {
                    new PlaySound(classLoader.getResource("four.au").getFile());
                    Thread.sleep(500);
                }
                if (subans == 5) {
                    new PlaySound(classLoader.getResource("five.au").getFile());
                    Thread.sleep(500);
                }
                if (subans == 6) {
                    new PlaySound(classLoader.getResource("six.au").getFile());
                    Thread.sleep(500);
                }
                if (subans == 7) {
                    new PlaySound(classLoader.getResource("seven.au").getFile());
                    Thread.sleep(500);
                }
                if (subans == 8) {
                    new PlaySound(classLoader.getResource("eight.au").getFile());
                    Thread.sleep(500);
                }
                if (subans == 9) {
                    new PlaySound(classLoader.getResource("nine.au").getFile());
                    Thread.sleep(500);
                }

                if (subans == 10) {
                    new PlaySound(classLoader.getResource("ten.au").getFile());
                    Thread.sleep(500);
                }
                if (subans == 11) {
                    new PlaySound(classLoader.getResource("eleven.au").getFile());
                    Thread.sleep(500);
                }
                if (subans == 12) {
                    new PlaySound(classLoader.getResource("twell.au").getFile());
                    Thread.sleep(500);
                }
                if (subans == 13) {
                    new PlaySound(classLoader.getResource("theirdteen.au").getFile());
                    Thread.sleep(500);
                }
                if (subans == 14) {
                    new PlaySound(classLoader.getResource("14.au").getFile());
                    Thread.sleep(500);
                }
                if (subans == 15) {
                    new PlaySound(classLoader.getResource("15.au").getFile());
                    Thread.sleep(500);
                }
                if (subans == 16) {
                    new PlaySound(classLoader.getResource("16.au").getFile());
                    Thread.sleep(500);
                }
                if (subans == 17) {
                    new PlaySound(classLoader.getResource("17.au").getFile());
                    Thread.sleep(500);
                }
                if (subans == 18) {
                    new PlaySound(classLoader.getResource("18.au").getFile());
                    Thread.sleep(500);
                }
                if (subans == 19) {
                    new PlaySound(classLoader.getResource("19.au").getFile());
                    Thread.sleep(500);
                }

                if (subans > 19 && subans < 30) {
                    new PlaySound(classLoader.getResource("20.au").getFile());
                    Thread.sleep(500);
                }
                if (subans > 29 && subans < 40) {
                    new PlaySound(classLoader.getResource("30.au").getFile());
                    Thread.sleep(500);
                }
                if (subans > 39 && subans < 50) {
                    new PlaySound(classLoader.getResource("40.au").getFile());
                    Thread.sleep(500);
                }
                if (subans > 49 && subans < 60) {
                    new PlaySound(classLoader.getResource("50.au").getFile());
                    Thread.sleep(500);
                }
                if (subans > 59 && subans < 70) {
                    new PlaySound(classLoader.getResource("60.au").getFile());
                    Thread.sleep(500);
                }
                if (subans > 69 && subans < 80) {
                    new PlaySound(classLoader.getResource("70.au").getFile());
                    Thread.sleep(500);
                }
                if (subans > 79 && subans < 90) {
                    new PlaySound(classLoader.getResource("80.au").getFile());
                    Thread.sleep(500);
                }
                if (subans > 89 && subans < 100) {
                    new PlaySound(classLoader.getResource("90.au").getFile());
                    Thread.sleep(500);
                }

                if (subans == 21 || subans == 31 || subans == 41
                        || subans == 51 || subans == 61 || subans == 71
                        || subans == 81 || subans == 91) {
                    loop = 2;
                    clone = subans;
                    subans = 1;
                }
                if (subans == 22 || subans == 32 || subans == 42
                        || subans == 52 || subans == 62 || subans == 72
                        || subans == 82 || subans == 92) {
                    loop = 2;
                    clone = subans;
                    subans = 2;
                }
                if (subans == 23 || subans == 33 || subans == 43
                        || subans == 53 || subans == 63 || subans == 73
                        || subans == 83 || subans == 93) {
                    loop = 2;
                    clone = subans;
                    subans = 3;
                }
                if (subans == 24 || subans == 34 || subans == 44
                        || subans == 54 || subans == 64 || subans == 74
                        || subans == 84 || subans == 94) {
                    loop = 2;
                    clone = subans;
                    subans = 4;
                }
                if (subans == 25 || subans == 35 || subans == 45
                        || subans == 55 || subans == 65 || subans == 75
                        || subans == 85 || subans == 95) {
                    loop = 2;
                    clone = subans;
                    subans = 5;
                }
                if (subans == 26 || subans == 36 || subans == 46
                        || subans == 56 || subans == 66 || subans == 76
                        || subans == 86 || subans == 96) {
                    loop = 2;
                    clone = subans;
                    subans = 6;
                }
                if (subans == 27 || subans == 37 || subans == 47
                        || subans == 57 || subans == 67 || subans == 77
                        || subans == 87 || subans == 97) {
                    loop = 2;
                    clone = subans;
                    subans = 7;
                }
                if (subans == 28 || subans == 38 || subans == 48
                        || subans == 58 || subans == 68 || subans == 78
                        || subans == 88 || subans == 98) {
                    loop = 2;
                    clone = subans;
                    subans = 8;
                }
                if (subans == 29 || subans == 39 || subans == 49
                        || subans == 59 || subans == 69 || subans == 79
                        || subans == 89 || subans == 99) {
                    loop = 2;
                    clone = subans;
                    subans = 9;
                }
                for (double count = 0; count < 49999999; count++)
                    ;

                startbutton_actionPerformed_Interaction1(event);
            }

        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    void startbutton_actionPerformed_Interaction2(
            java.awt.event.ActionEvent event) {
        try {
            // answbox Set the JTextField's text
            answbox.setText("*****");
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    void startbutton_actionPerformed_Interaction3(
            java.awt.event.ActionEvent event) {
        try {
            // zbox Set the JTextField's text
            zbox.setText("");
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    void closebutton_actionPerformed(java.awt.event.ActionEvent event) {
        // to do: code goes here.
    }

    void JButton3_actionPerformed(java.awt.event.ActionEvent event)
            throws InterruptedException {
        level = 1;
        new PlaySound(classLoader.getResource("that.spir.au").getFile());
        Thread.sleep(1000);
        startbutton_actionPerformed_Interaction1(event);

    }

    void JButton1_actionPerformed(java.awt.event.ActionEvent event)
            throws InterruptedException {
        level = 2;
        new PlaySound(classLoader.getResource("ready.when.you.au").getFile());
        Thread.sleep(1000);
        startbutton_actionPerformed_Interaction1(event);

    }

    void JButton2_actionPerformed(java.awt.event.ActionEvent event)
            throws InterruptedException {
        level = 3;
        new PlaySound(classLoader.getResource("good.choice.au").getFile());
        Thread.sleep(1000);
        startbutton_actionPerformed_Interaction1(event);

    }

    public MathFrame(String sTitle) {
        this();
        setTitle(sTitle);
    }

    public static void main(String args[]) {
        (new MathFrame()).setVisible(true);
    }
}
