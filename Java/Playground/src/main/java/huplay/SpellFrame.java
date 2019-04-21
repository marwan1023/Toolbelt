package huplay;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.*;

public class SpellFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private ClassLoader classLoader = getClass().getClassLoader();
    private Score score = Score.getInstance();


    // {{DECLARE_CONTROLS
    JTextField scoreField = new JTextField();
    JLabel JLabel1 = new JLabel();
    JLabel JLabel2 = new JLabel();
    JButton First = new JButton();
    JButton Second = new JButton();
    JButton Third = new JButton();
    JButton Fourth = new JButton();
    JButton Fifth = new JButton();
    JButton Seventh = new JButton();
    JButton sixth = new JButton();
    JTextField Word1 = new JTextField();
    JTextField Word2 = new JTextField();
    JTextField Word3 = new JTextField();
    JTextField Word4 = new JTextField();
    JTextField Word5 = new JTextField();
    JTextField Word6 = new JTextField();
    JTextField Word7 = new JTextField();
    JButton Ans1 = new JButton();
    JButton Ans2 = new JButton();
    JButton Ans3 = new JButton();
    JButton Ans4 = new JButton();
    JButton Ans5 = new JButton();
    JButton Ans6 = new JButton();
    JButton Ans7 = new JButton();
    ButtonGroup Panel = new ButtonGroup();
    JButton easy = new JButton();
    JButton medium = new JButton();
    JButton hard = new JButton();
    JLabel JLabel3 = new JLabel();
    JTextField level = new JTextField();
    JLabel JLabel4 = new JLabel();
    JLabel JLabel5 = new JLabel();
    JLabel starlabel1;
    JLabel starlabel2;
    ImagePanel imageViewer1;

    ImagePanel image = new ImagePanel();
    ImagePanel dogs;
    ImagePanel bd;
    ImagePanel batd;
    ImagePanel catd;
    ImagePanel treed;
    ImagePanel balld;
    ImagePanel birdd;
    ImagePanel lamp;

    ImagePanel coats;
    ImagePanel soaps;
    ImagePanel leaps;
    ImagePanel tig;
    ImagePanel bea;
    ImagePanel slp;
    ImagePanel boa;
    ImagePanel mouse;
    ImagePanel shark;
    ImagePanel fish;
    ImagePanel chr;
    ImagePanel apple;
    ImagePanel deer;
    ImagePanel lite;
    ImagePanel carrot;
    ImagePanel pokemon;
    ImagePanel book;
    ImagePanel clock;
    ImagePanel worm;
    ImagePanel star2;
    ImagePanel star1;

    String e = "Level 1";
    String m = "Level 2";
    String h = "Level 3";

    public SpellFrame() {

        score.resetSpellingScore();

        // {{INIT_CONTROLS
        getContentPane().setLayout(null);
        getContentPane().setBackground(java.awt.Color.white);
        setSize(620, 464);
        scoreField.setSelectionColor(new java.awt.Color(204, 204, 255));
        scoreField.setSelectedTextColor(java.awt.Color.black);
        scoreField.setCaretColor(java.awt.Color.black);
        scoreField.setDisabledTextColor(java.awt.Color.white);
        scoreField.setEditable(false);
        getContentPane().add(scoreField);
        scoreField.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
        scoreField.setBounds(60, 120, 46, 32);
        JLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel1.setText("Score:");
        getContentPane().add(JLabel1);
        JLabel1.setBackground(java.awt.Color.black);
        JLabel1.setForeground(java.awt.Color.black);
        JLabel1.setBounds(0, 132, 73, 12);
        JLabel2.setText("Click the number and spell the word in the box!");
        JLabel2.setAlignmentX(CENTER_ALIGNMENT);
        getContentPane().add(JLabel2);
        JLabel2.setForeground(java.awt.Color.black);
        JLabel2.setBounds(160, 120, 396, 24);
        First.setText("1");
        First.setActionCommand("1");
        getContentPane().add(First);
        First.setBounds(204, 192, 48, 24);
        Second.setText("2");
        Second.setActionCommand("1");
        getContentPane().add(Second);
        Second.setBounds(204, 216, 48, 24);
        Third.setText("3");
        Third.setActionCommand("1");
        getContentPane().add(Third);
        Third.setBounds(204, 240, 48, 24);
        Fourth.setText("4");
        Fourth.setActionCommand("1");
        getContentPane().add(Fourth);
        Fourth.setBounds(204, 264, 48, 24);
        Fifth.setText("5");
        Fifth.setActionCommand("1");
        getContentPane().add(Fifth);
        Fifth.setBounds(204, 288, 48, 24);
        Seventh.setText("7");
        Seventh.setActionCommand("1");
        getContentPane().add(Seventh);
        Seventh.setBounds(204, 336, 48, 24);
        sixth.setText("6");
        sixth.setActionCommand("1");
        getContentPane().add(sixth);
        sixth.setBounds(204, 312, 48, 24);
        Word1.setSelectionColor(new java.awt.Color(204, 204, 255));
        Word1.setSelectedTextColor(java.awt.Color.black);
        Word1.setCaretColor(java.awt.Color.black);
        Word1.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        getContentPane().add(Word1);
        Word1.setBounds(252, 192, 94, 24);
        Word2.setSelectionColor(new java.awt.Color(204, 204, 255));
        Word2.setSelectedTextColor(java.awt.Color.black);
        Word2.setCaretColor(java.awt.Color.black);
        Word2.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        getContentPane().add(Word2);
        Word2.setBounds(252, 216, 94, 24);
        Word3.setSelectionColor(new java.awt.Color(204, 204, 255));
        Word3.setSelectedTextColor(java.awt.Color.black);
        Word3.setCaretColor(java.awt.Color.black);
        Word3.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        getContentPane().add(Word3);
        Word3.setBounds(252, 240, 94, 24);
        Word4.setSelectionColor(new java.awt.Color(204, 204, 255));
        Word4.setSelectedTextColor(java.awt.Color.black);
        Word4.setCaretColor(java.awt.Color.black);
        Word4.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        getContentPane().add(Word4);
        Word4.setBounds(252, 264, 94, 24);
        Word5.setSelectionColor(new java.awt.Color(204, 204, 255));
        Word5.setSelectedTextColor(java.awt.Color.black);
        Word5.setCaretColor(java.awt.Color.black);
        Word5.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        getContentPane().add(Word5);
        Word5.setBounds(252, 288, 94, 24);
        Word6.setSelectionColor(new java.awt.Color(204, 204, 255));
        Word6.setSelectedTextColor(java.awt.Color.black);
        Word6.setCaretColor(java.awt.Color.black);
        Word6.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        getContentPane().add(Word6);
        Word6.setBounds(252, 312, 94, 24);
        Word7.setSelectionColor(new java.awt.Color(204, 204, 255));
        Word7.setSelectedTextColor(java.awt.Color.black);
        Word7.setCaretColor(java.awt.Color.black);
        Word7.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        getContentPane().add(Word7);
        Word7.setBounds(252, 336, 94, 24);
        Ans1.setText("Ok");
        Ans1.setActionCommand("1");
        getContentPane().add(Ans1);
        Ans1.setBounds(348, 192, 60, 24);
        Ans2.setText("Ok");
        Ans2.setActionCommand("1");
        getContentPane().add(Ans2);
        Ans2.setBounds(348, 216, 60, 24);
        Ans3.setText("Ok");
        Ans3.setActionCommand("1");
        getContentPane().add(Ans3);
        Ans3.setBounds(348, 240, 60, 24);
        Ans4.setText("Ok");
        Ans4.setActionCommand("1");
        getContentPane().add(Ans4);
        Ans4.setBounds(348, 264, 60, 24);
        Ans5.setText("Ok");
        Ans5.setActionCommand("1");
        getContentPane().add(Ans5);
        Ans5.setBounds(348, 288, 60, 24);
        Ans6.setText("Ok");
        Ans6.setActionCommand("1");
        getContentPane().add(Ans6);
        Ans6.setBounds(348, 312, 60, 24);
        Ans7.setText("Ok");
        Ans7.setActionCommand("1");
        getContentPane().add(Ans7);
        Ans7.setBounds(348, 336, 60, 24);

        JLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel3.setText("Choose your difficulty!");
        getContentPane().add(JLabel3);
        JLabel3.setForeground(java.awt.Color.black);
        JLabel3.setBounds(36, 252, 159, 18);
        easy.setText("Level 1");
        easy.setActionCommand("Easy");
        Panel.add(easy);
        easy.setBounds(36, 276, 159, 18);
        getContentPane().add(easy);

        medium.setText("Level 2");
        medium.setActionCommand("Medium");
        Panel.add(medium);
        medium.setBounds(36, 296, 159, 18);
        getContentPane().add(medium);

        hard.setText("Level 3");
        hard.setActionCommand("Hard");
        Panel.add(hard);
        hard.setBounds(36, 316, 159, 18);
        getContentPane().add(hard);

        level.setSelectionColor(java.awt.Color.white);
        level.setSelectedTextColor(java.awt.Color.black);
        level.setCaretColor(java.awt.Color.white);
        level.setHorizontalAlignment(SwingConstants.CENTER);
        level.setDisabledTextColor(java.awt.Color.white);
        level.setEditable(false);
        getContentPane().add(level);
        level.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
        level.setBounds(48, 204, 128, 27);
        JLabel4.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel4.setText("Level of Lesson");
        getContentPane().add(JLabel4);
        JLabel4.setForeground(java.awt.Color.black);
        JLabel4.setBounds(60, 180, 109, 24);
        JLabel5.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel5.setText("Note: Choose difficulty level before playing.");
        getContentPane().add(JLabel5);
        JLabel5.setForeground(java.awt.Color.black);
        JLabel5.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
        JLabel5.setBounds(120, 96, 380, 19);
        imageViewer1 = new ImagePanel(classLoader.getResource("spell.gif").getFile());
        imageViewer1.setBackground(Color.WHITE);

        getContentPane().add(imageViewer1);
        imageViewer1.setBounds(156, 12, 317, 73);

        Eighth.setText("8");
        Eighth.setActionCommand("1");
        getContentPane().add(Eighth);
        Eighth.setBounds(204, 360, 48, 24);
        Word8.setSelectionColor(new java.awt.Color(204, 204, 255));
        Word8.setSelectedTextColor(java.awt.Color.black);
        Word8.setCaretColor(java.awt.Color.black);
        Word8.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        getContentPane().add(Word8);
        Word8.setBounds(252, 360, 94, 24);
        Ans8.setText("Ok");
        Ans8.setActionCommand("1");
        getContentPane().add(Ans8);
        Ans8.setBounds(348, 360, 60, 24);
        bonus.setText("Bonus");
        bonus.setActionCommand("Bonus");
        getContentPane().add(bonus);
        bonus.setBounds(180, 396, 72, 24);
        Word9.setSelectionColor(new java.awt.Color(204, 204, 255));
        Word9.setSelectedTextColor(java.awt.Color.black);
        Word9.setCaretColor(java.awt.Color.black);
        Word9.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        getContentPane().add(Word9);
        Word9.setBounds(252, 396, 96, 24);
        Ans9.setText("Ok");
        Ans9.setActionCommand("1");
        getContentPane().add(Ans9);
        Ans9.setBounds(348, 396, 60, 24);

        spell.setHorizontalAlignment(SwingConstants.CENTER);
        spell.setText("Spell:");
        getContentPane().add(spell);
        spell.setForeground(java.awt.Color.black);
        spell.setFont(new Font("Dialog", Font.BOLD, 14));
        spell.setBounds(456, 156, 129, 24);
        image.setAlignmentX(CENTER_ALIGNMENT);
        image.setLayout(null);
        getContentPane().add(image);
        image.setBounds(420, 192, 193, 264);

        dogs = new ImagePanel(classLoader.getResource("dog.jpg").getFile());
        dogs.setBackground(Color.WHITE);
        getContentPane().add(dogs);
        dogs.setBounds(420, 192, 193, 264); // 636,36,108,72
        dogs.setVisible(false);

        bd = new ImagePanel(classLoader.getResource("bed.jpg").getFile());
        bd.setBackground(Color.WHITE);
        getContentPane().add(bd);
        bd.setBounds(420, 192, 193, 264);
        bd.setVisible(false);

        batd = new ImagePanel(classLoader.getResource("bat.gif").getFile());
        batd.setBackground(Color.WHITE);
        getContentPane().add(batd);
        batd.setBounds(420, 192, 193, 264);
        batd.setVisible(false);

        catd = new ImagePanel(classLoader.getResource("cat.gif").getFile());
        catd.setBackground(Color.WHITE);
        getContentPane().add(catd);
        catd.setBounds(420, 192, 193, 264);
        catd.setVisible(false);

        treed = new ImagePanel(classLoader.getResource("tree.gif").getFile());
        treed.setBackground(Color.WHITE);
        getContentPane().add(treed);
        treed.setBounds(420, 192, 193, 264);
        treed.setVisible(false);

        balld = new ImagePanel(classLoader.getResource("ball.jpg").getFile());
        balld.setBackground(Color.WHITE);
        getContentPane().add(balld);
        balld.setBounds(420, 192, 193, 264);
        balld.setVisible(false);

        birdd = new ImagePanel(classLoader.getResource("bird.jpg").getFile());
        birdd.setBackground(Color.WHITE);
        getContentPane().add(birdd);
        birdd.setBounds(420, 192, 193, 264);
        birdd.setVisible(false);

        lamp = new ImagePanel(classLoader.getResource("lamps.gif").getFile());
        lamp.setBackground(Color.WHITE);
        getContentPane().add(lamp);
        lamp.setBounds(420, 192, 193, 264);
        lamp.setVisible(false);

        coats = new ImagePanel(classLoader.getResource("coat.jpg").getFile());

        getContentPane().add(coats);
        coats.setBounds(420, 192, 193, 264);
        coats.setVisible(false);
        soaps = new ImagePanel(classLoader.getResource("soaps.jpg").getFile());

        getContentPane().add(soaps);
        soaps.setBounds(420, 192, 193, 264);
        soaps.setVisible(false);
        leaps = new ImagePanel(classLoader.getResource("leaps.gif").getFile());

        getContentPane().add(leaps);
        leaps.setBounds(420, 192, 193, 264);
        leaps.setVisible(false);
        tig = new ImagePanel(classLoader.getResource("tiger.gif").getFile());

        getContentPane().add(tig);
        tig.setBounds(420, 192, 193, 264);
        tig.setVisible(false);
        bea = new ImagePanel(classLoader.getResource("pooh.gif").getFile());

        getContentPane().add(bea);
        bea.setBounds(420, 192, 193, 264);
        bea.setVisible(false);
        slp = new ImagePanel(classLoader.getResource("sleeps.gif").getFile());

        getContentPane().add(slp);
        slp.setBounds(420, 192, 193, 264);
        slp.setVisible(false);
        boa = new ImagePanel(classLoader.getResource("boats.jpg").getFile());

        getContentPane().add(boa);
        boa.setBounds(420, 192, 193, 264);
        boa.setVisible(false);
        mouse = new ImagePanel(classLoader.getResource("mouse.gif").getFile());

        getContentPane().add(mouse);
        mouse.setBounds(420, 192, 193, 264);
        mouse.setVisible(false);
        shark = new ImagePanel(classLoader.getResource("shark.gif").getFile());

        getContentPane().add(shark);
        shark.setBounds(420, 192, 193, 264);
        shark.setVisible(false);
        fish = new ImagePanel(classLoader.getResource("fish.gif").getFile());

        getContentPane().add(fish);
        fish.setBounds(420, 192, 193, 264);
        fish.setVisible(false);
        chr = new ImagePanel(classLoader.getResource("chairs.gif").getFile());

        getContentPane().add(chr);
        chr.setBounds(420, 192, 193, 264);
        chr.setVisible(false);
        apple = new ImagePanel(classLoader.getResource("apple.gif").getFile());

        getContentPane().add(apple);
        apple.setBounds(420, 192, 193, 264);
        apple.setVisible(false);
        deer = new ImagePanel(classLoader.getResource("deer.gif").getFile());

        getContentPane().add(deer);
        deer.setBounds(420, 192, 193, 264);
        deer.setVisible(false);
        lite = new ImagePanel(classLoader.getResource("bulb.gif").getFile());

        getContentPane().add(lite);
        lite.setBounds(420, 192, 193, 264);
        lite.setVisible(false);
        carrot = new ImagePanel(classLoader.getResource("carrot.gif").getFile());

        getContentPane().add(carrot);
        carrot.setBounds(420, 192, 193, 264);
        carrot.setVisible(false);
        pokemon = new ImagePanel(classLoader.getResource("pika.gif").getFile());

        getContentPane().add(pokemon);
        pokemon.setBounds(420, 192, 193, 264);
        pokemon.setVisible(false);
        book = new ImagePanel(classLoader.getResource("book.png").getFile());

        getContentPane().add(book);
        book.setBounds(420, 192, 193, 264);
        book.setVisible(false);
        clock = new ImagePanel(classLoader.getResource("clock.gif").getFile());

        getContentPane().add(clock);
        clock.setBounds(420, 192, 193, 264);
        clock.setVisible(false);
        worm = new ImagePanel(classLoader.getResource("worm.gif").getFile());

        getContentPane().add(worm);
        worm.setBounds(420, 192, 193, 264);
        worm.setVisible(false);
        star2 = new ImagePanel(classLoader.getResource("star.gif").getFile());

        star2.setLayout(null);
        //getContentPane().add(star2);

        Icon imgIcon = new ImageIcon(classLoader.getResource("star.gif"));
        starlabel1 = new JLabel(imgIcon);
        starlabel1.setBounds(504, 12, 72, 74);
        getContentPane().add(starlabel1);
       starlabel1.setVisible(false);

        star2.setBounds(504, 12, 72, 74);
        star2.setVisible(false);


        star1 = new ImagePanel(classLoader.getResource("star.gif").getFile());

        star1.setLayout(null);

        imgIcon = new ImageIcon(classLoader.getResource("star.gif"));
        starlabel2 = new JLabel(imgIcon);
        starlabel2.setBounds(36, 12, 72, 74);
        getContentPane().add(starlabel2);
        starlabel2.setVisible(false);

        star1.setBounds(36, 12, 72, 74);
        star1.setVisible(false);

        // {{REGISTER_LISTENERS
        SymAction lSymAction = new SymAction();
        Ans1.addActionListener(lSymAction);
        easy.addActionListener(lSymAction);
        medium.addActionListener(lSymAction);
        hard.addActionListener(lSymAction);
        First.addActionListener(lSymAction);
        Second.addActionListener(lSymAction);
        Ans2.addActionListener(lSymAction);
        Third.addActionListener(lSymAction);
        Ans3.addActionListener(lSymAction);
        Fourth.addActionListener(lSymAction);
        Ans4.addActionListener(lSymAction);
        Fifth.addActionListener(lSymAction);
        Ans5.addActionListener(lSymAction);
        sixth.addActionListener(lSymAction);
        Ans6.addActionListener(lSymAction);
        Seventh.addActionListener(lSymAction);
        Ans7.addActionListener(lSymAction);
        Eighth.addActionListener(lSymAction);
        Ans8.addActionListener(lSymAction);
        bonus.addActionListener(lSymAction);
        Ans9.addActionListener(lSymAction);
        SymMouse aSymMouse = new SymMouse();
        First.addMouseListener(aSymMouse);
        // }}
    }

    public void scoreKeep() {
        scoreField.setText(String.valueOf(score.getSpellingScore()));
        if (score.getSpellingScore() >= 40) {
            starlabel1.setVisible(true);
            starlabel2.setVisible(true);
            new PlaySound(classLoader.getResource("applause2.au").getFile());

        }
    }

    public SpellFrame(String sTitle) {
        this();
        setTitle(sTitle);
    }


    static public void main(String args[]) {
        (new SpellFrame()).setVisible(true);
    }

    JButton Eighth = new JButton();
    JTextField Word8 = new JTextField();
    JButton Ans8 = new JButton();
    JButton bonus = new JButton();
    JTextField Word9 = new JTextField();
    JButton Ans9 = new JButton();
    
    JLabel spell = new JLabel();

  

    class SymAction implements java.awt.event.ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent event) {
            Object object = event.getSource();
            if (object == Ans1)
                Ans1_actionPerformed(event);
            else if (object == easy)
                easy_actionPerformed(event);
            else if (object == medium)
                medium_actionPerformed(event);
            else if (object == hard)
                hard_actionPerformed(event);
            else if (object == First)
                First_actionPerformed(event);
            else if (object == Second)
                Second_actionPerformed(event);
            else if (object == Ans2)
                Ans2_actionPerformed(event);
            else if (object == Third)
                Third_actionPerformed(event);
            else if (object == Ans3)
                Ans3_actionPerformed(event);
            else if (object == Fourth)
                Fourth_actionPerformed(event);
            else if (object == Ans4)
                Ans4_actionPerformed(event);
            else if (object == Fifth)
                Fifth_actionPerformed(event);
            else if (object == Ans5)
                Ans5_actionPerformed(event);
            else if (object == sixth)
                sixth_actionPerformed(event);
            else if (object == Ans6)
                Ans6_actionPerformed(event);
            else if (object == Seventh)
                Seventh_actionPerformed(event);
            else if (object == Ans7)
                Ans7_actionPerformed(event);
            else if (object == Eighth)
                Eighth_actionPerformed(event);
            else if (object == Ans8)
                Ans8_actionPerformed(event);
            else if (object == bonus)
                bonus_actionPerformed(event);
            else if (object == Ans9)
                Ans9_actionPerformed(event);

        }
    }

    void Ans1_actionPerformed(java.awt.event.ActionEvent event) {
        // to do: code goes here.

        Ans1_actionPerformed_Interaction1(event);
    }

    void Ans1_actionPerformed_Interaction1(java.awt.event.ActionEvent event) {
        String setting = (String.valueOf(level.getText()));
        if (setting.equals(e)) {
            try {

                {
                    String word = "dog";
                    String input = (String.valueOf(Word1.getText())).toLowerCase();

                    if (input.equals(word)) {
                        score.incrementSpellingScore(5);
                        // right.play();
                        new PlaySound(classLoader.getResource("Tada.au").getFile());
                        Word1.setEditable(false);
                        Ans1.setEnabled(false);
                        scoreKeep();
                    } else { // Wrong.play();
                        new PlaySound(classLoader.getResource("wrong.au").getFile());
                       score.decrementSpellingScore(5);
                        Word1.setText("dog");
                        Word1.setEditable(false);
                        Ans1.setEnabled(false);
                        scoreKeep();
                    }
                }
            } catch (Exception e) {
            }
        } else if (setting.equals(m)) {
            try {

                {
                    String word = "coat";
                    String input = (String.valueOf(Word1.getText())).toLowerCase();

                    if (input.equals(word)) {

                        new PlaySound(classLoader.getResource("Tada.au").getFile());
                        score.incrementSpellingScore(5);
                        Word1.setEditable(false);
                        Ans1.setEnabled(false);
                        scoreKeep();
                    } else {
                         score.decrementSpellingScore(5);
                        new PlaySound(classLoader.getResource("wrong.au").getFile());

                        Word1.setText("coat");
                        Word1.setEditable(false);
                        Ans1.setEnabled(false);
                        scoreKeep();
                    }
                }
            } catch (Exception e) {
            }
        } else if (setting.equals(h)) {
            try {

                {
                    String word = "mouse";
                    String input = (String.valueOf(Word1.getText())).toLowerCase();

                    if (input.equals(word)) {
                        // right.play();
                        new PlaySound(classLoader.getResource("Tada.au").getFile());
                         score.incrementSpellingScore(5);
                        Word1.setEditable(false);
                        Ans1.setEnabled(false);
                        scoreKeep();
                    } else {
                         score.decrementSpellingScore(5);
                        new PlaySound(classLoader.getResource("wrong.au").getFile());
                        // Wrong.play();
                        Word1.setText("mouse");
                        Word1.setEditable(false);
                        Ans1.setEnabled(false);
                        scoreKeep();
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    void easy_actionPerformed(java.awt.event.ActionEvent event) {
        // to do: code goes here.

        easy_actionPerformed_Interaction1(event);
    }

    void easy_actionPerformed_Interaction1(java.awt.event.ActionEvent event) {
        try {
            // level Set the JTextField's text
            level.setText("Level 1");
            new PlaySound(classLoader.getResource("level1.au").getFile());

            hard.setEnabled(false);
            medium.setEnabled(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void medium_actionPerformed(java.awt.event.ActionEvent event) {
        // to do: code goes here.

        medium_actionPerformed_Interaction1(event);
    }

    void medium_actionPerformed_Interaction1(java.awt.event.ActionEvent event) {
        try {
            // level Set the JTextField's text
            level.setText("Level 2");
            new PlaySound(classLoader.getResource("level2.au").getFile());

            easy.setEnabled(false);
            hard.setEnabled(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void hard_actionPerformed(java.awt.event.ActionEvent event) {
        // to do: code goes here.

        hard_actionPerformed_Interaction1(event);
    }

    void hard_actionPerformed_Interaction1(java.awt.event.ActionEvent event) {
        try {
            // level Set the JTextField's text
            level.setText("Level 3");
            new PlaySound(classLoader.getResource("level3.au").getFile());

            easy.setEnabled(false);
            medium.setEnabled(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void First_actionPerformed(java.awt.event.ActionEvent event) {
        // to do: code goes here.

        First_actionPerformed_Interaction1(event);
    }

    void First_actionPerformed_Interaction1(java.awt.event.ActionEvent event) {
        String setting = (String.valueOf(level.getText()));
        try {
            if (setting.equals(e)) {
                new PlaySound(classLoader.getResource("dog.au").getFile());
                spell.setVisible(true);
                image.removeAll();
                image = dogs;
                image.paintComponent(dogs.getGraphics());

            } else if (setting.equals(m)) {
                new PlaySound(classLoader.getResource("coat.au").getFile());

                image.removeAll();
                image = coats;
                image.paintComponent(coats.getGraphics());
                spell.setVisible(true);
            } else if (setting.equals(h)) {
                new PlaySound(classLoader.getResource("leave.au").getFile());

                image.removeAll();
                image = mouse;
                image.paintComponent(mouse.getGraphics());
                spell.setVisible(true);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void Second_actionPerformed(java.awt.event.ActionEvent event) {
        // to do: code goes here.

        Second_actionPerformed_Interaction1(event);
    }

    void Second_actionPerformed_Interaction1(java.awt.event.ActionEvent event) {

        String setting = (String.valueOf(level.getText()));
        try {
            if (setting.equals(e)) { // bed.play();
                new PlaySound(classLoader.getResource("bed.au").getFile());

                image.removeAll();
                image = bd;
                image.paintComponent(bd.getGraphics());
            } else if (setting.equals(m)) { // soap.play();
                new PlaySound(classLoader.getResource("soap.au").getFile());

                image.removeAll();
                image = soaps;
                image.paintComponent(soaps.getGraphics());
            } else if (setting.equals(h)) { // crawl.play();
                new PlaySound(classLoader.getResource("crawl.au").getFile());

                image.removeAll();
                image = shark;
                image.paintComponent(shark.getGraphics());
            }
            // First.addActionListener(g);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void Ans2_actionPerformed(java.awt.event.ActionEvent event) {
        // to do: code goes here.

        Ans2_actionPerformed_Interaction1(event);
    }

    void Ans2_actionPerformed_Interaction1(java.awt.event.ActionEvent event) {
        String setting = (String.valueOf(level.getText()));
        if (setting.equals(e)) {
            try {

                {
                    String word = "bed";
                    String input = (String.valueOf(Word2.getText())).toLowerCase();

                    if (input.equals(word)) {
                         score.incrementSpellingScore(5);
                        // right.play();
                        new PlaySound(classLoader.getResource("Tada.au").getFile());
                        Word2.setEditable(false);
                        Ans2.setEnabled(false);
                        scoreKeep();
                    } else { // Wrong.play();
                        new PlaySound(classLoader.getResource("wrong.au").getFile());
                         score.decrementSpellingScore(5);
                        Word2.setText("bed");
                        Word2.setEditable(false);
                        Ans2.setEnabled(false);
                        scoreKeep();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (setting.equals(m)) {
            try {

                {
                    String word = "soap";
                    String input = (String.valueOf(Word2.getText())).toLowerCase();

                    if (input.equals(word)) {
                        // right.play();
                        new PlaySound(classLoader.getResource("Tada.au").getFile());
                         score.incrementSpellingScore(5);
                        Word2.setEditable(false);
                        Ans2.setEnabled(false);
                        scoreKeep();
                    } else {
                         score.decrementSpellingScore(5);
                        // Wrong.play();
                        new PlaySound(classLoader.getResource("wrong.au").getFile());
                        Word2.setText("soap");
                        Word2.setEditable(false);
                        Ans2.setEnabled(false);
                        scoreKeep();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (setting.equals(h)) {
            try {

                {
                    String word = "shark";
                    String input = (String.valueOf(Word2.getText())).toLowerCase();

                    if (input.equals(word)) {
                        // right.play();
                        new PlaySound(classLoader.getResource("Tada.au").getFile());
                         score.incrementSpellingScore(5);
                        Word2.setEditable(false);
                        Ans2.setEnabled(false);
                        scoreKeep();
                    } else {
                         score.decrementSpellingScore(5);
                        // Wrong.play();
                        new PlaySound(classLoader.getResource("wrong.au").getFile());
                        Word2.setText("shark");
                        Word2.setEditable(false);
                        Ans2.setEnabled(false);
                        scoreKeep();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    void Third_actionPerformed(java.awt.event.ActionEvent event) {
        // to do: code goes here.

        Third_actionPerformed_Interaction1(event);
    }

    void Third_actionPerformed_Interaction1(java.awt.event.ActionEvent event) {

        String setting = (String.valueOf(level.getText()));
        try {
            if (setting.equals(e)) { // bat.play();
                new PlaySound(classLoader.getResource("bat.au").getFile());

                image.removeAll();
                image = batd;
                image.paintComponent(batd.getGraphics());
            } else if (setting.equals(m)) { // leap.play();
                new PlaySound(classLoader.getResource("leap.au").getFile());

                image.removeAll();
                image = leaps;
                image.paintComponent(leaps.getGraphics());
            } else if (setting.equals(h)) { // jump.play();
                new PlaySound(classLoader.getResource("jump.au").getFile());

                image.removeAll();
                image = fish;
                image.paintComponent(fish.getGraphics());
            }
            // First.addActionListener(g);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void Ans3_actionPerformed(java.awt.event.ActionEvent event) {
        // to do: code goes here.

        Ans3_actionPerformed_Interaction1(event);
    }

    void Ans3_actionPerformed_Interaction1(java.awt.event.ActionEvent event) {
        String setting = (String.valueOf(level.getText()));
        if (setting.equals(e)) {
            try {

                {
                    String word = "bat";
                    String input = (String.valueOf(Word3.getText()));

                    if (input.equals(word)) {
                         score.incrementSpellingScore(5);
                        // right.play();
                        new PlaySound(classLoader.getResource("Tada.au").getFile());
                        Word3.setEditable(false);
                        Ans3.setEnabled(false);
                        scoreKeep();
                    } else { // Wrong.play();
                        new PlaySound(classLoader.getResource("wrong.au").getFile());
                         score.decrementSpellingScore(5);
                        Word3.setText("bat");
                        Word3.setEditable(false);
                        Ans3.setEnabled(false);
                        scoreKeep();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (setting.equals(m)) {
            try {

                {
                    String word = "frog";
                    String input = (String.valueOf(Word3.getText()));

                    if (input.equals(word)) {
                        // right.play();
                        new PlaySound(classLoader.getResource("Tada.au").getFile());
                         score.incrementSpellingScore(5);
                        Word3.setEditable(false);
                        Ans3.setEnabled(false);
                        scoreKeep();
                    } else {
                         score.decrementSpellingScore(5);
                        // Wrong.play();
                        new PlaySound(classLoader.getResource("wrong.au").getFile());
                        Word3.setText("frog");
                        Word3.setEditable(false);
                        Ans3.setEnabled(false);
                        scoreKeep();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (setting.equals(h)) {
            try {

                {
                    String word = "fish";
                    String input = (String.valueOf(Word3.getText())).toLowerCase();

                    if (input.equals(word)) {
                        // right.play();
                        new PlaySound(classLoader.getResource("Tada.au").getFile());
                         score.incrementSpellingScore(5);
                        Word3.setEditable(false);
                        Ans3.setEnabled(false);
                        scoreKeep();
                    } else {
                         score.decrementSpellingScore(5);
                        // Wrong.play();
                        new PlaySound(classLoader.getResource("wrong.au").getFile());
                        Word3.setText("fish");
                        Word3.setEditable(false);
                        Ans3.setEnabled(false);
                        scoreKeep();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    void Fourth_actionPerformed(java.awt.event.ActionEvent event) {
        // to do: code goes here.

        Fourth_actionPerformed_Interaction1(event);
    }

    void Fourth_actionPerformed_Interaction1(java.awt.event.ActionEvent event) {
        String setting = (String.valueOf(level.getText()));
        try {
            if (setting.equals(e)) {// sit.play();
                new PlaySound(classLoader.getResource("sit.au").getFile());

                image.removeAll();
                image = book;
                image.paintComponent(book.getGraphics());
            } else if (setting.equals(m)) { // tigers.play();
                new PlaySound(classLoader.getResource("tiger.au").getFile());

                image.removeAll();
                image = tig;
                image.paintComponent(tig.getGraphics());
            } else if (setting.equals(h)) { // chair.play();
                new PlaySound(classLoader.getResource("chair.au").getFile());

                image.removeAll();
                image = chr;
                image.paintComponent(chr.getGraphics());
            }
            // First.addActionListener(g);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void Ans4_actionPerformed(java.awt.event.ActionEvent event) {
        // to do: code goes here.

        Ans4_actionPerformed_Interaction1(event);
    }

    void Ans4_actionPerformed_Interaction1(java.awt.event.ActionEvent event) {
        String setting = (String.valueOf(level.getText()));
        if (setting.equals(e)) {
            try {

                {
                    String word = "book";
                    String input = (String.valueOf(Word4.getText())).toLowerCase();

                    if (input.equals(word)) {
                         score.incrementSpellingScore(5);
                        // right.play();
                        new PlaySound(classLoader.getResource("Tada.au").getFile());
                        Word4.setEditable(false);
                        Ans4.setEnabled(false);
                        scoreKeep();
                    } else { // Wrong.play();
                        new PlaySound(classLoader.getResource("wrong.au").getFile());
                         score.decrementSpellingScore(5);
                        Word4.setText("book");
                        Word4.setEditable(false);
                        Ans4.setEnabled(false);
                        scoreKeep();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (setting.equals(m)) {
            try {

                {
                    String word = "tiger";
                    String input = (String.valueOf(Word4.getText())).toLowerCase();

                    if (input.equals(word)) {
                        // right.play();
                        new PlaySound(classLoader.getResource("Tada.au").getFile());
                         score.incrementSpellingScore(5);
                        Word4.setEditable(false);
                        Ans4.setEnabled(false);
                        scoreKeep();
                    } else {
                         score.decrementSpellingScore(5);
                        // Wrong.play();
                        new PlaySound(classLoader.getResource("wrong.au").getFile());
                        Word4.setText("tiger");
                        Word4.setEditable(false);
                        Ans4.setEnabled(false);
                        scoreKeep();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (setting.equals(h)) {
            try {

                {
                    String word = "chair";
                    String input = (String.valueOf(Word4.getText())).toLowerCase();

                    if (input.equals(word)) {
                        // right.play();
                        new PlaySound(classLoader.getResource("Tada.au").getFile());
                         score.incrementSpellingScore(5);
                        Word4.setEditable(false);
                        Ans4.setEnabled(false);
                        scoreKeep();
                    } else {
                         score.decrementSpellingScore(5);
                        // Wrong.play();
                        new PlaySound(classLoader.getResource("wrong.au").getFile());
                        Word4.setText("chair");
                        Word4.setEditable(false);
                        Ans4.setEnabled(false);
                        scoreKeep();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    void Fifth_actionPerformed(java.awt.event.ActionEvent event) {
        // to do: code goes here.

        Fifth_actionPerformed_Interaction1(event);
    }

    void Fifth_actionPerformed_Interaction1(java.awt.event.ActionEvent event) {
        String setting = (String.valueOf(level.getText()));
        try {
            if (setting.equals(e)) {// cat.play();
                new PlaySound(classLoader.getResource("cat.au").getFile());

                image.removeAll();
                image = catd;
                image.paintComponent(catd.getGraphics());
            } else if (setting.equals(m)) { // bear.play();
                new PlaySound(classLoader.getResource("bear.au").getFile());

                image.removeAll();
                image = bea;
                image.paintComponent(bea.getGraphics());
            } else if (setting.equals(h)) { // speak.play();
                new PlaySound(classLoader.getResource("speak.au").getFile());

                image.removeAll();
                image = apple;
                image.paintComponent(apple.getGraphics());
            }
            // First.addActionListener(g);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void Ans5_actionPerformed(java.awt.event.ActionEvent event) {
        // to do: code goes here.

        Ans5_actionPerformed_Interaction1(event);
    }

    void Ans5_actionPerformed_Interaction1(java.awt.event.ActionEvent event) {
        String setting = (String.valueOf(level.getText()));
        if (setting.equals(e)) {
            try {

                {
                    String word = "cat";
                    String input = (String.valueOf(Word5.getText())).toLowerCase();

                    if (input.equals(word)) {
                         score.incrementSpellingScore(5);
                        // right.play();
                        new PlaySound(classLoader.getResource("Tada.au").getFile());
                        Word5.setEditable(false);
                        Ans5.setEnabled(false);
                        scoreKeep();
                    } else { // Wrong.play();
                        new PlaySound(classLoader.getResource("wrong.au").getFile());
                         score.decrementSpellingScore(5);
                        Word5.setText("cat");
                        Word5.setEditable(false);
                        Ans5.setEnabled(false);
                        scoreKeep();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (setting.equals(m)) {
            try {

                {
                    String word = "bear";
                    String input = (String.valueOf(Word5.getText())).toLowerCase();

                    if (input.equals(word)) {
                        // right.play();
                        new PlaySound(classLoader.getResource("Tada.au").getFile());
                         score.incrementSpellingScore(5);
                        Word5.setEditable(false);
                        Ans5.setEnabled(false);
                        scoreKeep();
                    } else {
                         score.decrementSpellingScore(5);
                        // Wrong.play();
                        new PlaySound(classLoader.getResource("wrong.au").getFile());
                        Word5.setText("bear");
                        Word5.setEditable(false);
                        Ans5.setEnabled(false);
                        scoreKeep();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (setting.equals(h)) {
            try {

                {
                    String word = "apple";
                    String input = (String.valueOf(Word5.getText())).toLowerCase();

                    if (input.equals(word)) {
                        // right.play();
                        new PlaySound(classLoader.getResource("Tada.au").getFile());
                         score.incrementSpellingScore(5);
                        Word5.setEditable(false);
                        Ans5.setEnabled(false);
                        scoreKeep();
                    } else {
                         score.decrementSpellingScore(5);
                        // Wrong.play();
                        new PlaySound(classLoader.getResource("wrong.au").getFile());
                        Word5.setText("apple");
                        Word5.setEditable(false);
                        Ans5.setEnabled(false);
                        scoreKeep();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    void sixth_actionPerformed(java.awt.event.ActionEvent event) {
        // to do: code goes here.

        sixth_actionPerformed_Interaction1(event);
    }

    void sixth_actionPerformed_Interaction1(java.awt.event.ActionEvent event) {
        String setting = (String.valueOf(level.getText()));
        try {
            if (setting.equals(e)) {// tree.play();
                new PlaySound(classLoader.getResource("tree.au").getFile());

                image.removeAll();
                image = treed;
                image.paintComponent(treed.getGraphics());
            } else if (setting.equals(m)) { // drop.play();
                new PlaySound(classLoader.getResource("drop.au").getFile());

                image.removeAll();
                image = clock;
                image.paintComponent(clock.getGraphics());
            } else if (setting.equals(h)) { // table.play();
                new PlaySound(classLoader.getResource("table.au").getFile());

                image.removeAll();
                image = deer;
                image.paintComponent(deer.getGraphics());
            }
            // First.addActionListener(g);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void Ans6_actionPerformed(java.awt.event.ActionEvent event) {
        // to do: code goes here.

        Ans6_actionPerformed_Interaction1(event);
    }

    void Ans6_actionPerformed_Interaction1(java.awt.event.ActionEvent event) {
        String setting = (String.valueOf(level.getText()));
        if (setting.equals(e)) {
            try {

                {
                    String word = "tree";
                    String input = (String.valueOf(Word6.getText())).toLowerCase();

                    if (input.equals(word)) {
                         score.incrementSpellingScore(5);
                        // right.play();
                        new PlaySound(classLoader.getResource("Tada.au").getFile());
                        Word6.setEditable(false);
                        Ans6.setEnabled(false);
                        scoreKeep();
                    } else { // Wrong.play();
                        new PlaySound(classLoader.getResource("wrong.au").getFile());
                         score.decrementSpellingScore(5);
                        Word6.setText("tree");
                        Word6.setEditable(false);
                        Ans6.setEnabled(false);
                        scoreKeep();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (setting.equals(m)) {
            try {

                {
                    String word = "clock";
                    String input = (String.valueOf(Word6.getText())).toLowerCase();

                    if (input.equals(word)) {
                        // right.play();
                        new PlaySound(classLoader.getResource("Tada.au").getFile());
                         score.incrementSpellingScore(5);
                        Word6.setEditable(false);
                        Ans6.setEnabled(false);
                        scoreKeep();
                    } else {
                         score.decrementSpellingScore(5);
                        // Wrong.play();
                        new PlaySound(classLoader.getResource("wrong.au").getFile());
                        Word6.setText("clock");
                        Word6.setEditable(false);
                        Ans6.setEnabled(false);
                        scoreKeep();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (setting.equals(h)) {
            try {

                {
                    String word = "deer";
                    String input = (String.valueOf(Word6.getText())).toLowerCase();

                    if (input.equals(word)) {
                        // right.play();
                        new PlaySound(classLoader.getResource("Tada.au").getFile());
                         score.incrementSpellingScore(5);
                        Word6.setEditable(false);
                        Ans6.setEnabled(false);
                        scoreKeep();
                    } else {
                         score.decrementSpellingScore(5);
                        // Wrong.play();
                        new PlaySound(classLoader.getResource("Tada.au").getFile());
                        Word6.setText("deer");
                        Word6.setEditable(false);
                        Ans6.setEnabled(false);
                        scoreKeep();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    void Seventh_actionPerformed(java.awt.event.ActionEvent event) {
        // to do: code goes here.

        Seventh_actionPerformed_Interaction1(event);
    }

    void Seventh_actionPerformed_Interaction1(java.awt.event.ActionEvent event) {
        String setting = (String.valueOf(level.getText()));
        try {
            if (setting.equals(e)) {// ball.play();
                new PlaySound(classLoader.getResource("ball.au").getFile());

                image.removeAll();
                image = balld;
                image.paintComponent(balld.getGraphics());
            } else if (setting.equals(m)) { // clas.play();
                new PlaySound(classLoader.getResource("class.au").getFile());

                image.removeAll();
                image = worm;
                image.paintComponent(worm.getGraphics());
            } else if (setting.equals(h)) { // light.play();
                new PlaySound(classLoader.getResource("light.au").getFile());

                image.removeAll();
                image = lite;
                image.paintComponent(lite.getGraphics());
            }
            // First.addActionListener(g);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void Ans7_actionPerformed(java.awt.event.ActionEvent event) {
        // to do: code goes here.

        Ans7_actionPerformed_Interaction1(event);
    }

    void Ans7_actionPerformed_Interaction1(java.awt.event.ActionEvent event) {
        String setting = (String.valueOf(level.getText()));
        if (setting.equals(e)) {
            try {

                {
                    String word = "ball";
                    String input = (String.valueOf(Word7.getText())).toLowerCase();

                    if (input.equals(word)) {
                         score.incrementSpellingScore(5);
                        // right.play();
                        new PlaySound(classLoader.getResource("Tada.au").getFile());
                        Word7.setEditable(false);
                        Ans7.setEnabled(false);
                        scoreKeep();
                    } else { // Wrong.play();
                        new PlaySound(classLoader.getResource("wrong.au").getFile());
                         score.decrementSpellingScore(5);
                        Word7.setText("ball");
                        Word7.setEditable(false);
                        Ans7.setEnabled(false);
                        scoreKeep();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (setting.equals(m)) {
            try {

                {
                    String word = "worm";
                    String input = (String.valueOf(Word7.getText())).toLowerCase();

                    if (input.equals(word)) {
                        // right.play();
                        new PlaySound(classLoader.getResource("Tada.au").getFile());
                         score.incrementSpellingScore(5);
                        Word7.setEditable(false);
                        Ans7.setEnabled(false);
                        scoreKeep();
                    } else {
                         score.decrementSpellingScore(5);
                        // Wrong.play();
                        new PlaySound(classLoader.getResource("wrong.au").getFile());
                        Word7.setText("worm");
                        Word7.setEditable(false);
                        Ans7.setEnabled(false);
                        scoreKeep();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (setting.equals(h)) {
            try {

                {
                    String word = "light";
                    String input = (String.valueOf(Word7.getText())).toLowerCase();

                    if (input.equals(word)) {
                        // right.play();
                        new PlaySound(classLoader.getResource("Tada.au").getFile());
                         score.incrementSpellingScore(5);
                        Word7.setEditable(false);
                        Ans7.setEnabled(false);
                        scoreKeep();
                    } else {
                         score.decrementSpellingScore(5);
                        // Wrong.play();
                        new PlaySound(classLoader.getResource("wrong.au").getFile());
                        Word7.setText("light");
                        Word7.setEditable(false);
                        Ans7.setEnabled(false);
                        scoreKeep();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    void Eighth_actionPerformed(java.awt.event.ActionEvent event) {
        // to do: code goes here.

        Eighth_actionPerformed_Interaction1(event);
    }

    void Eighth_actionPerformed_Interaction1(java.awt.event.ActionEvent event) {
        String setting = (String.valueOf(level.getText()));
        try {
            if (setting.equals(e)) {
                new PlaySound(classLoader.getResource("bird.au").getFile());

                image.removeAll();
                image = birdd;
                image.paintComponent(birdd.getGraphics());
            } else if (setting.equals(m)) { // sleep.play();
                new PlaySound(classLoader.getResource("sleep.au").getFile());

                image.removeAll();
                image = slp;
                image.paintComponent(slp.getGraphics());
            } else if (setting.equals(h)) { // radio.play();
                new PlaySound(classLoader.getResource("radio.au").getFile());

                image.removeAll();
                image = carrot;
                image.paintComponent(carrot.getGraphics());

            }
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void Ans8_actionPerformed(java.awt.event.ActionEvent event) {
        // to do: code goes here.

        Ans8_actionPerformed_Interaction1(event);
    }

    void Ans8_actionPerformed_Interaction1(java.awt.event.ActionEvent event) {
        String setting = (String.valueOf(level.getText()));
        if (setting.equals(e)) {
            try {

                {
                    String word = "bird";
                    String input = (String.valueOf(Word8.getText())).toLowerCase();

                    if (input.equals(word)) {
                         score.incrementSpellingScore(5);
                      
                        new PlaySound(classLoader.getResource("Tada.au").getFile());
                        Word8.setEditable(false);
                        Ans8.setEnabled(false);
                        scoreKeep();
                    } else { 
                        new PlaySound(classLoader.getResource("wrong.au").getFile());
                         score.decrementSpellingScore(5);
                        Word8.setText("bird");
                        Word8.setEditable(false);
                        Ans8.setEnabled(false);
                        scoreKeep();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (setting.equals(m)) {
            try {

                {
                    String word = "sleep";
                    String input = (String.valueOf(Word8.getText())).toLowerCase();

                    if (input.equals(word)) {
                       
                        new PlaySound(classLoader.getResource("Tada.au").getFile());
                         score.incrementSpellingScore(5);
                        Word8.setEditable(false);
                        Ans8.setEnabled(false);
                        scoreKeep();
                    } else {
                         score.decrementSpellingScore(5);
                        
                        new PlaySound(classLoader.getResource("wrong.au").getFile());
                        Word8.setText("sleep");
                        Word8.setEditable(false);
                        Ans8.setEnabled(false);
                        scoreKeep();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (setting.equals(h)) {
            try {

                {
                    String word = "carrot";
                    String input = (String.valueOf(Word8.getText())).toLowerCase();

                    if (input.equals(word)) {
                        // right.play();
                        new PlaySound(classLoader.getResource("Tada.au").getFile());
                         score.incrementSpellingScore(5);
                        Word8.setEditable(false);
                        Ans8.setEnabled(false);
                        scoreKeep();
                    } else {
                         score.decrementSpellingScore(5);
                        // Wrong.play();
                        new PlaySound(classLoader.getResource("wrong.au").getFile());
                        Word8.setText("carrot");
                        Word8.setEditable(false);
                        Ans8.setEnabled(false);
                        scoreKeep();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    void bonus_actionPerformed(java.awt.event.ActionEvent event) {
        // to do: code goes here.

        bonus_actionPerformed_Interaction1(event);
    }

    void bonus_actionPerformed_Interaction1(java.awt.event.ActionEvent event) {
        String setting = (String.valueOf(level.getText()));
        try {
            if (setting.equals(e)) {
                new PlaySound(classLoader.getResource("bonus1.au").getFile());

                image.removeAll();
                image = lamp;
                image.paintComponent(lamp.getGraphics());
            } else if (setting.equals(m)) { 
                new PlaySound(classLoader.getResource("float.au").getFile());

                image.removeAll();
                image = boa;
                image.paintComponent(boa.getGraphics());

            } else if (setting.equals(h)) { 
                new PlaySound(classLoader.getResource("cabinet.au").getFile());

                image.removeAll();
                image = pokemon;
                image.paintComponent(pokemon.getGraphics());
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void Ans9_actionPerformed(java.awt.event.ActionEvent event) {
        // to do: code goes here.

        Ans9_actionPerformed_Interaction1(event);
    }

    void Ans9_actionPerformed_Interaction1(java.awt.event.ActionEvent event) {
        String setting = (String.valueOf(level.getText()));
        if (setting.equals(e)) {
            try {

                {
                    String word = "lamp";
                    String input = (String.valueOf(Word9.getText())).toLowerCase();

                    if (input.equals(word)) {
                        score.incrementSpellingScore(10);
                     
                        new PlaySound(classLoader.getResource("Tada.au").getFile());
                        Word9.setEditable(false);
                        Ans9.setEnabled(false);
                        scoreKeep();
                    } else {
                        new PlaySound(classLoader.getResource("wrong.au").getFile());
                        Word9.setText("lamp");
                        Word9.setEditable(false);
                        Ans9.setEnabled(false);
                        scoreKeep();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (setting.equals(m)) {
            try {

                {
                    String word = "boat";
                    String input = (String.valueOf(Word9.getText())).toLowerCase();

                    if (input.equals(word)) {
                      
                        new PlaySound(classLoader.getResource("Tada.au").getFile());
                        score.incrementSpellingScore(10);
                        Word9.setEditable(false);
                        Ans9.setEnabled(false);
                        scoreKeep();
                    } else {

                      
                        new PlaySound(classLoader.getResource("wrong.au").getFile());
                        Word9.setText("boat");
                        Word9.setEditable(false);
                        Ans9.setEnabled(false);
                        scoreKeep();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (setting.equals(h)) {
            try {

                {
                    String word = "pokemon";
                    String input = (String.valueOf(Word9.getText())).toLowerCase();

                    if (input.equals(word)) {
                       
                        new PlaySound(classLoader.getResource("Tada.au").getFile());
                        score.incrementSpellingScore(10);
                        Word9.setEditable(false);
                        Ans9.setEnabled(false);
                        scoreKeep();
                    } else {

                       
                        new PlaySound(classLoader.getResource("wrong.au").getFile());
                        Word9.setText("pokemon");
                        Word9.setEditable(false);
                        Ans9.setEnabled(false);
                        scoreKeep();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class SymMouse extends java.awt.event.MouseAdapter {
        public void mouseClicked(java.awt.event.MouseEvent event) {
            Object object = event.getSource();
            if (object == First)
                First_mouseClicked(event);
        }
    }

    void First_mouseClicked(java.awt.event.MouseEvent event) {
        // to do: code goes here.
    }
}