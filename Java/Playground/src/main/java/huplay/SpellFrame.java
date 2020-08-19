package huplay;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.*;

public class SpellFrame extends SpellWindow {


    String e = "Level 1";
    String m = "Level 2";
    String h = "Level 3";

    public SpellFrame() {

        score.resetSpellingScore();
        this.configureSpellFrame();


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

    }

    public void scoreKeep() {
        scoreField.setText(String.valueOf(score.getSpellingScore()));
        if (score.getSpellingScore() >= 40) {
            starlabel1.setVisible(true);
            starlabel2.setVisible(true);
            new PlaySound(classLoader.getResource("applause2.au"));
        }
    }

    public SpellFrame(String sTitle) {
        this();
        setTitle(sTitle);
    }


    static public void main(String args[]) {
        (new SpellFrame()).setVisible(true);
    }


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
        Ans1_actionPerformed_Interaction1(event);
    }

    private void handleSpellingQuestion(String word, JTextField textfield, JButton button) {


        String input = (String.valueOf(textfield.getText())).toLowerCase();

        if (input.equals(word)) {
            score.incrementSpellingScore(5);
            new PlaySound(classLoader.getResource("Tada.au"));
            textfield.setEditable(false);
            button.setEnabled(false);

        } else { // Wrong.play();
            new PlaySound(classLoader.getResource("wrong.au"));
            score.decrementSpellingScore(5);
            textfield.setText(word);
            textfield.setEditable(false);
            button.setEnabled(false);
        }
        scoreKeep();

    }

    void Ans1_actionPerformed_Interaction1(java.awt.event.ActionEvent event) {
        String setting = (String.valueOf(level.getText()));
        if (setting.equals(e)) {

            String word = "dog";
            handleSpellingQuestion(word, Word1, Ans1);

        } else if (setting.equals(m)) {

            String word = "coat";
            handleSpellingQuestion(word, Word1, Ans1);

        } else if (setting.equals(h)) {

            String word = "mouse";
            handleSpellingQuestion(word, Word1, Ans1);
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
            new PlaySound(classLoader.getResource("level1.au"));

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
            new PlaySound(classLoader.getResource("level2.au"));

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
            new PlaySound(classLoader.getResource("level3.au"));

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
                new PlaySound(classLoader.getResource("dog.au"));
                spell.setVisible(true);
                image.removeAll();
                image = dogs;
                image.paintComponent(dogs.getGraphics());

            } else if (setting.equals(m)) {
                new PlaySound(classLoader.getResource("coat.au"));

                image.removeAll();
                image = coats;
                image.paintComponent(coats.getGraphics());
                spell.setVisible(true);
            } else if (setting.equals(h)) {
                new PlaySound(classLoader.getResource("leave.au"));

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
                new PlaySound(classLoader.getResource("bed.au"));

                image.removeAll();
                image = bd;
                image.paintComponent(bd.getGraphics());
            } else if (setting.equals(m)) { // soap.play();
                new PlaySound(classLoader.getResource("soap.au"));

                image.removeAll();
                image = soaps;
                image.paintComponent(soaps.getGraphics());
            } else if (setting.equals(h)) { // crawl.play();
                new PlaySound(classLoader.getResource("crawl.au"));

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
            String word = "bed";
            handleSpellingQuestion(word, Word2, Ans2);

        } else if (setting.equals(m)) {
            String word = "soap";
            handleSpellingQuestion(word, Word2, Ans2);
        } else if (setting.equals(h)) {

            String word = "shark";
            handleSpellingQuestion(word, Word2, Ans2);
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
                new PlaySound(classLoader.getResource("bat.au"));

                image.removeAll();
                image = batd;
                image.paintComponent(batd.getGraphics());
            } else if (setting.equals(m)) { // leap.play();
                new PlaySound(classLoader.getResource("leap.au"));

                image.removeAll();
                image = leaps;
                image.paintComponent(leaps.getGraphics());
            } else if (setting.equals(h)) { // jump.play();
                new PlaySound(classLoader.getResource("jump.au"));

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

            String word = "bat";
            handleSpellingQuestion(word, Word3, Ans3);
        } else if (setting.equals(m)) {

            String word = "frog";
            handleSpellingQuestion(word, Word3, Ans3);
        } else if (setting.equals(h)) {

            String word = "fish";
            handleSpellingQuestion(word, Word3, Ans3);
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
                new PlaySound(classLoader.getResource("sit.au"));

                image.removeAll();
                image = book;
                image.paintComponent(book.getGraphics());
            } else if (setting.equals(m)) { // tigers.play();
                new PlaySound(classLoader.getResource("tiger.au"));

                image.removeAll();
                image = tig;
                image.paintComponent(tig.getGraphics());
            } else if (setting.equals(h)) { // chair.play();
                new PlaySound(classLoader.getResource("chair.au"));

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
            String word = "book";
            String input = (String.valueOf(Word4.getText())).toLowerCase();

            handleSpellingQuestion(word, Word4, Ans4);
        } else if (setting.equals(m)) {

            String word = "tiger";
            handleSpellingQuestion(word, Word4, Ans4);
        } else if (setting.equals(h)) {

            String word = "chair";
            handleSpellingQuestion(word, Word4, Ans4);
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
                new PlaySound(classLoader.getResource("cat.au"));

                image.removeAll();
                image = catd;
                image.paintComponent(catd.getGraphics());
            } else if (setting.equals(m)) { // bear.play();
                new PlaySound(classLoader.getResource("bear.au"));

                image.removeAll();
                image = bea;
                image.paintComponent(bea.getGraphics());
            } else if (setting.equals(h)) { // speak.play();
                new PlaySound(classLoader.getResource("speak.au"));

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

            String word = "cat";
            handleSpellingQuestion(word, Word5, Ans5);
        } else if (setting.equals(m)) {

            String word = "bear";
            handleSpellingQuestion(word, Word5, Ans5);
        } else if (setting.equals(h)) {

            String word = "apple";
            handleSpellingQuestion(word, Word5, Ans5);
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
                new PlaySound(classLoader.getResource("tree.au"));

                image.removeAll();
                image = treed;
                image.paintComponent(treed.getGraphics());
            } else if (setting.equals(m)) { // drop.play();
                new PlaySound(classLoader.getResource("drop.au"));

                image.removeAll();
                image = clock;
                image.paintComponent(clock.getGraphics());
            } else if (setting.equals(h)) { // table.play();
                new PlaySound(classLoader.getResource("table.au"));

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

            String word = "tree";
            handleSpellingQuestion(word, Word6, Ans6);
        } else if (setting.equals(m)) {

            String word = "clock";
            handleSpellingQuestion(word, Word6, Ans6);
        } else if (setting.equals(h)) {

            String word = "deer";
            handleSpellingQuestion(word, Word6, Ans6);
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
                new PlaySound(classLoader.getResource("ball.au"));

                image.removeAll();
                image = balld;
                image.paintComponent(balld.getGraphics());
            } else if (setting.equals(m)) { // clas.play();
                new PlaySound(classLoader.getResource("class.au"));

                image.removeAll();
                image = worm;
                image.paintComponent(worm.getGraphics());
            } else if (setting.equals(h)) { // light.play();
                new PlaySound(classLoader.getResource("light.au"));

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

            String word = "ball";
            handleSpellingQuestion(word, Word7, Ans7);
        } else if (setting.equals(m)) {

            String word = "worm";
            handleSpellingQuestion(word, Word7, Ans7);
        } else if (setting.equals(h)) {

            String word = "light";
            handleSpellingQuestion(word, Word7, Ans7);
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
                new PlaySound(classLoader.getResource("bird.au"));

                image.removeAll();
                image = birdd;
                image.paintComponent(birdd.getGraphics());
            } else if (setting.equals(m)) { // sleep.play();
                new PlaySound(classLoader.getResource("sleep.au"));

                image.removeAll();
                image = slp;
                image.paintComponent(slp.getGraphics());
            } else if (setting.equals(h)) { // radio.play();
                new PlaySound(classLoader.getResource("radio.au"));

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

            String word = "bird";
            handleSpellingQuestion(word, Word8, Ans8);
        } else if (setting.equals(m)) {

            String word = "sleep";
            handleSpellingQuestion(word, Word8, Ans8);
        } else if (setting.equals(h)) {

            String word = "carrot";
            handleSpellingQuestion(word, Word8, Ans8);
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
                new PlaySound(classLoader.getResource("bonus1.au"));

                image.removeAll();
                image = lamp;
                image.paintComponent(lamp.getGraphics());
            } else if (setting.equals(m)) {
                new PlaySound(classLoader.getResource("float.au"));

                image.removeAll();
                image = boa;
                image.paintComponent(boa.getGraphics());

            } else if (setting.equals(h)) {
                new PlaySound(classLoader.getResource("cabinet.au"));

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

            String word = "lamp";
            handleSpellingQuestion(word, Word9, Ans9);
        } else if (setting.equals(m)) {

            String word = "boat";
            handleSpellingQuestion(word, Word9, Ans9);
        } else if (setting.equals(h)) {
            String word = "pokemon";
            handleSpellingQuestion(word, Word9, Ans9);
        }
    }

}
