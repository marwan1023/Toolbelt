package huplay;

public class MathFrame extends MathWindow {

    private int giveup = 0;
    private int clone = 0;
    private int randx = 0;
    private int randy = 0;
    private int randsign = 0;
    private int ans;

    private final int numberOfQuestions = 25;
    private int questionNumber = 0;

    int level = 0;


    public MathFrame() {

        score.resetMathScore();
        this.configureMathFrame();

        // {{REGISTER_LISTENERS

        SymAction lSymAction = new SymAction();

        enterbutton.addActionListener(lSymAction);
        answer.addActionListener(lSymAction);

        JButton3.addActionListener(lSymAction);
        JButton2.addActionListener(lSymAction);
        nameEntryButton.addActionListener(lSymAction);

        
    }

    class SymAction implements java.awt.event.ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent event) {
            Object object = event.getSource();


            if (object == enterbutton)
                enterbutton_actionPerformed(event);
            else if (object == answer)
                answer_actionPerformed(event);
            else if (object == JButton3)

                    JButton3_actionPerformed(event);

            else if (object == JButton2)
                     JButton2_actionPerformed(event);

            else if (object == nameEntryButton)
                    nameEntryButton_actionPerformed(event);


        }
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
                        onTick(1000L);
                       
                        imageViewer1.setBounds(120, 156, 108, 108);
                        imagePanel2.removeAll();
                        imagePanel2 = imageViewer1;
                        imagePanel2.paintComponent(imageViewer1.getGraphics());

                    }
                    if (randx == 1) {
                        xbox.setText("1"); 
                        new PlaySound(classLoader.getResource("one.au").getFile());
                       onTick(1000L);

                        imageViewer2.setBounds(120, 156, 108, 108);
                        imagePanel2.removeAll();
                        imagePanel2 = imageViewer2;
                        imagePanel2.paintComponent(imageViewer2.getGraphics());

                    }
                    if (randx == 2) {
                        xbox.setText("2");
                        new PlaySound(classLoader.getResource("two.au").getFile());
                        onTick(1000L);

                        imageViewer3.setBounds(120, 156, 108, 108);
                        imagePanel2.removeAll();
                        imagePanel2 = imageViewer3;
                        imagePanel2.paintComponent(imageViewer3.getGraphics());

                    }
                    if (randx == 3) {
                        xbox.setText("3");
                        new PlaySound(classLoader.getResource("three.au").getFile());
                       onTick(1000L);
                        imageViewer4.setBounds(120, 156, 108, 108);
                        imagePanel2.removeAll();
                        imagePanel2 = imageViewer4;
                        imagePanel2.paintComponent(imageViewer4.getGraphics());

                    }
                    if (randx == 4) {
                        xbox.setText("4");
                        new PlaySound(classLoader.getResource("four.au").getFile());
                        onTick(1000L);

                        imageViewer5.setBounds(120, 156, 108, 108);
                        imagePanel2.removeAll();
                        imagePanel2 = imageViewer5;
                        imagePanel2.paintComponent(imageViewer5.getGraphics());

                    }
                    if (randx == 5) {
                        xbox.setText("5");
                        new PlaySound(classLoader.getResource("five.au").getFile());
                        onTick(1000L);
                        imageViewer6.setBounds(120, 156, 108, 108);
                        imagePanel2.removeAll();
                        imagePanel2 = imageViewer6;
                        imagePanel2.paintComponent(imageViewer6.getGraphics());

                    }
                    if (randx == 6) {
                        xbox.setText("6");
                        new PlaySound(classLoader.getResource("six.au").getFile());
                        onTick(1000L);
                        imageViewer7.setBounds(120, 156, 108, 108);
                        imagePanel2.removeAll();
                        imagePanel2 = imageViewer7;
                        imagePanel2.paintComponent(imageViewer7.getGraphics());

                    }
                    if (randx == 7) {
                        xbox.setText("7");
                        new PlaySound(classLoader.getResource("seven.au").getFile());
                        onTick(1000L);

                        imageViewer8.setBounds(120, 156, 108, 108);
                        imagePanel2.removeAll();
                        imagePanel2 = imageViewer8;
                        imagePanel2.paintComponent(imageViewer8.getGraphics());

                    }
                    if (randx == 8) {
                        xbox.setText("8");
                        new PlaySound(classLoader.getResource("eight.au").getFile());
                        onTick(1000L);

                        imageViewer9.setBounds(120, 156, 108, 108);
                        imagePanel2.removeAll();
                        imagePanel2 = imageViewer9;
                        imagePanel2.paintComponent(imageViewer9.getGraphics());

                    }
                    if (randx == 9) {
                        xbox.setText("9");
                        new PlaySound(classLoader.getResource("nine.au").getFile());
                        onTick(1000L);

                        imageViewer10.setBounds(120, 156, 108, 108);
                        imagePanel2.removeAll();
                        imagePanel2 = imageViewer10;
                        imagePanel2.paintComponent(imageViewer10.getGraphics());

                    }

                    if (randx == 10) {
                        xbox.setText("10");
                        new PlaySound(classLoader.getResource("ten.au").getFile());
                        onTick(1000L);

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
                        onTick(1000L);

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
                        onTick(1000L);

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
                        onTick(1000L);

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
                        onTick(1000L);

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
                       onTick(1000L);

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
                        onTick(1000L);

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
                        onTick(1000L);

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
                        onTick(1000L);

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
                        onTick(1000L);
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
                        onTick(1000L);

                        imageViewer3.setBounds(0, 156, 108, 108);
                        imagePanel1.removeAll();
                        imagePanel1 = imageViewer3;
                        imagePanel1.paintComponent(imageViewer3.getGraphics());
                 

                    }
                    if (randx > 29 && randx < 40) {
                        xbox.setText("30");
                        new PlaySound(classLoader.getResource("30.au").getFile());
                        onTick(1000L);
                        imageViewer4.setBounds(0, 156, 108, 108);
                        imagePanel1.removeAll();
                        imagePanel1 = imageViewer4;
                        imagePanel1.paintComponent(imageViewer4.getGraphics());
            

                    }

                    if (randx > 39 && randx < 50) {
                        xbox.setText("40");
                        new PlaySound(classLoader.getResource("40.au").getFile());
                        onTick(1000L);
                        imageViewer5.setBounds(0, 156, 108, 108);
                        imagePanel1.removeAll();
                        imagePanel1 = imageViewer5;
                        imagePanel1.paintComponent(imageViewer5.getGraphics());
                

                    }
                    if (randx == 50) {
                        xbox.setText("50");
                        new PlaySound(classLoader.getResource("50.au").getFile());
                        onTick(1000L);
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

                }
                randx = clone;


                    if (giveup == 0)
                        randsign = (int) (Math.random() * 2);
                    if (randsign == 0) {
                        plusbox.setText("+");
                        new PlaySound(classLoader.getResource("pluss.au").getFile());
                        onTick(500L);
                        JLabel3.setText("+");
                    }
                    if (randsign == 1) {
                        plusbox.setText("-");
                        new PlaySound(classLoader.getResource("minus.au").getFile());
                        onTick(500L);
                        JLabel3.setText("-");
                    }


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

                }
                randy = clone;
              //END BIG ASS FOR LOOP
                if (randsign == 0) {
                    onTick(500L);
                    new PlaySound(classLoader.getResource("equals.au").getFile());
                    ans = randx + randy;

                }
                if (randsign == 1) {
                    onTick(500L);
                    new PlaySound(classLoader.getResource("equals.au").getFile());
                    ans = randx - randy;

                }

                questionNumber++;

                if (questionNumber > numberOfQuestions)
                {
                    diologebox
                            .setText("Game Over! Great Job!");




                    if(score.getMathScore() > score.getMathHighScore())
                    {
                        score.setMathHighScore(score.getMathScore());
                        f.setText(""+score.getMathHighScore());
                    }

                    nameEntryButton.setEnabled(false);
                    JButton2.setEnabled(false);
                    JButton3.setEnabled(false);
                    zbox.setEnabled(false);
                    enterbutton.setEnabled(false);
                    answer.setEnabled(false);
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
        int a;
        try {

            a = Integer.valueOf(zbox.getText());

            if (ans == a) {
                int rand1;
                rand1 = Double.valueOf(Math.random() * 6).intValue();
                if (rand1 == 0)
                    new PlaySound(classLoader.getResource("goodjob.au").getFile());
               onTick(500L);
                if (rand1 == 1)
                    new PlaySound(classLoader.getResource("super.au").getFile());
               onTick(500L);
                if (rand1 == 2)
                    new PlaySound(classLoader.getResource("wowgratejob.au").getFile());
                onTick(500L);
                if (rand1 == 3)
                    new PlaySound(classLoader.getResource("u.practice.au").getFile());
                onTick(500L);
                if (rand1 == 4)
                    new PlaySound(classLoader.getResource("yagotit.au").getFile());
                onTick(500L);
                if (rand1 == 5)
                    new PlaySound(classLoader.getResource("let.lay.au").getFile());
                onTick(500L);

                diologebox.setText("Right");
                score.incrementMathScore(5);
                startbutton_actionPerformed_Interaction1(event);
            } else if (ans != a) {
                int rand1;
                rand1 = Double.valueOf(Math.random() * 2).intValue();
                if (rand1 == 0)
                    new PlaySound(classLoader.getResource("betterluck.au").getFile());
                if (rand1 == 1)
                    new PlaySound(classLoader.getResource("tryagain.au").getFile());
                diologebox.setText("Wrong");
                score.decrementMathScore(5);

            }
            scorebox.setText(String.valueOf(score.getMathScore()));


        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        zbox.setText("");
    }

    void answer_actionPerformed(java.awt.event.ActionEvent event) {
           answer_actionPerformed_Interaction1(event);
    }

    void answer_actionPerformed_Interaction1(java.awt.event.ActionEvent event) {
        try {
            giveup = 1;
            // ybox Set the JTextField's text
            answbox.setText(String.valueOf(ans));
            startbutton_actionPerformed_Interaction1(event);
            giveup = 0;
            
            int subans = ans;
            
            for (int loop = 1; loop > 0; --loop) {
                if (subans == 0) {
                    new PlaySound(classLoader.getResource("zero.au").getFile());
                    onTick(500L);
                }
                if (subans == 1) {
                    new PlaySound(classLoader.getResource("one.au").getFile());
                    onTick(500L);
                }
                if (subans == 2) {
                    new PlaySound(classLoader.getResource("two.au").getFile());
                    onTick(500L);
                }
                if (subans == 3) {
                    new PlaySound(classLoader.getResource("three.au").getFile());
                    onTick(500L);
                }
                if (subans == 4) {
                    new PlaySound(classLoader.getResource("four.au").getFile());
                    onTick(500L);
                }
                if (subans == 5) {
                    new PlaySound(classLoader.getResource("five.au").getFile());
                    onTick(500L);
                }
                if (subans == 6) {
                    new PlaySound(classLoader.getResource("six.au").getFile());
                    onTick(500L);
                }
                if (subans == 7) {
                    new PlaySound(classLoader.getResource("seven.au").getFile());
                    onTick(500L);
                }
                if (subans == 8) {
                    new PlaySound(classLoader.getResource("eight.au").getFile());
                    onTick(500L);
                }
                if (subans == 9) {
                    new PlaySound(classLoader.getResource("nine.au").getFile());
                    onTick(500L);
                }

                if (subans == 10) {
                    new PlaySound(classLoader.getResource("ten.au").getFile());
                    onTick(500L);
                }
                if (subans == 11) {
                    new PlaySound(classLoader.getResource("eleven.au").getFile());
                    onTick(500L);
                }
                if (subans == 12) {
                    new PlaySound(classLoader.getResource("twell.au").getFile());
                    onTick(500L);
                }
                if (subans == 13) {
                    new PlaySound(classLoader.getResource("theirdteen.au").getFile());
                    onTick(500L);
                }
                if (subans == 14) {
                    new PlaySound(classLoader.getResource("14.au").getFile());
                    onTick(500L);
                }
                if (subans == 15) {
                    new PlaySound(classLoader.getResource("15.au").getFile());
                    onTick(500L);
                }
                if (subans == 16) {
                    new PlaySound(classLoader.getResource("16.au").getFile());
                    onTick(500L);
                }
                if (subans == 17) {
                    new PlaySound(classLoader.getResource("17.au").getFile());
                    onTick(500L);
                }
                if (subans == 18) {
                    new PlaySound(classLoader.getResource("18.au").getFile());
                    onTick(500L);
                }
                if (subans == 19) {
                    new PlaySound(classLoader.getResource("19.au").getFile());
                    onTick(500L);
                }

                if (subans > 19 && subans < 30) {
                    new PlaySound(classLoader.getResource("20.au").getFile());
                    onTick(500L);
                }
                if (subans > 29 && subans < 40) {
                    new PlaySound(classLoader.getResource("30.au").getFile());
                    onTick(500L);
                }
                if (subans > 39 && subans < 50) {
                    new PlaySound(classLoader.getResource("40.au").getFile());
                    onTick(500L);
                }
                if (subans > 49 && subans < 60) {
                    new PlaySound(classLoader.getResource("50.au").getFile());
                    onTick(500L);
                }
                if (subans > 59 && subans < 70) {
                    new PlaySound(classLoader.getResource("60.au").getFile());
                    onTick(500L);
                }
                if (subans > 69 && subans < 80) {
                    new PlaySound(classLoader.getResource("70.au").getFile());
                    onTick(500L);
                }
                if (subans > 79 && subans < 90) {
                    new PlaySound(classLoader.getResource("80.au").getFile());
                    onTick(500L);
                }
                if (subans > 89 && subans < 100) {
                    new PlaySound(classLoader.getResource("90.au").getFile());
                    onTick(500L);
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

                startbutton_actionPerformed_Interaction1(event);
            }

        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    void JButton3_actionPerformed(java.awt.event.ActionEvent event)
             {
        level = 1;
        new PlaySound(classLoader.getResource("that.spir.au").getFile());
        onTick(1000L);
        startbutton_actionPerformed_Interaction1(event);
        nameEntryButton.setEnabled(false);
        JButton2.setEnabled(false);
        zbox.setEnabled(true);
        enterbutton.setEnabled(true);
        answer.setEnabled(true);

    }

    void nameEntryButton_actionPerformed(java.awt.event.ActionEvent event)
            {
        level = 2;
        new PlaySound(classLoader.getResource("ready.when.you.au").getFile());
        onTick(1000L);
        startbutton_actionPerformed_Interaction1(event);
        JButton3.setEnabled(false);
        JButton2.setEnabled(false);
        zbox.setEnabled(true);
        enterbutton.setEnabled(true);
        answer.setEnabled(true);

    }

    void JButton2_actionPerformed(java.awt.event.ActionEvent event)
            {
        level = 3;
        new PlaySound(classLoader.getResource("good.choice.au").getFile());
        onTick(1000L);
        startbutton_actionPerformed_Interaction1(event);
        JButton3.setEnabled(false);
        nameEntryButton.setEnabled(false);
        zbox.setEnabled(true);
        enterbutton.setEnabled(true);
        answer.setEnabled(true);

    }

    public void onTick(long PERIOD) {//Called every "Tick"
        long thisTime = System.currentTimeMillis();
         while (true) {
            long now = System.currentTimeMillis();
            if((now - thisTime) >= PERIOD) break;
            // Do nothing
        }

    }

    public MathFrame(String sTitle) {
        this();
        setTitle(sTitle);
    }

    public static void main(String args[]) {
        (new MathFrame()).setVisible(true);
    }
}
