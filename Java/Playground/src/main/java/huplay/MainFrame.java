package huplay;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.BevelBorder;

/**
 * This project is an edutainment center focused towards children from
 * pre-schoolers to 2nd graders. It has a spelling, art, and math section and
 * each use animations to keep the children interested.
 * 
 * @author Marcus Johnson
 * @author Israel Cook
 * @author Margaret Reid
 * @version 1.0
 * @since December 4, 1999
 */

public class MainFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    private ClassLoader classLoader = getClass().getClassLoader();
    ImagePanel imageViewer1 = new ImagePanel();
    JButton spell = new JButton();
    JButton art = new JButton();
    JButton math = new JButton();
    JButton trophy = new JButton();
    JTextField personal = new JTextField();
    JLabel JLabel1 = new JLabel();
    JButton JButton1 = new JButton();
    BevelBorder bevelBorder1 = new BevelBorder(0);
    ImagePanel imageViewer2 = new ImagePanel();
    ImagePanel imageViewer3 = new ImagePanel();
    ImagePanel imageViewer4 = new ImagePanel();

    String name1, name2, total2;
    String total = "";
    String test = "";

    public MainFrame(String sTitle) {
        this();
        setTitle(sTitle);
    }

    public MainFrame() {

        
        
        
        // This line prevents the "Swing: checked access to system event queue"
        // message seen in some browsers.
        getRootPane().putClientProperty("defeatSystemEventQueueCheck",
                Boolean.TRUE);

        getContentPane().setLayout(null);
        getContentPane().setBackground(java.awt.Color.white);
        getContentPane().setForeground(java.awt.Color.green);
        setSize(570, 425);
        try {

          
            imageViewer1 = new ImagePanel(classLoader.getResource("play.gif").getFile());
            imageViewer1.setBackground(Color.WHITE);
        } catch (Exception error) {
        }

        getContentPane().add(imageViewer1);
        imageViewer1.setBounds(36, 12, 489, 72);
        spell.setText("Spelling");
        spell.setActionCommand("Spelling");
        spell.setBorder(bevelBorder1);
        getContentPane().add(spell);
        spell.setBackground(java.awt.Color.lightGray);
        spell.setBounds(72, 180, 132, 48);
        art.setText("Art");
        art.setActionCommand("Spelling");
        art.setBorder(bevelBorder1);
        getContentPane().add(art);
        art.setBackground(java.awt.Color.lightGray);
        art.setBounds(336, 180, 132, 48);
        math.setText("Math");
        math.setActionCommand("Spelling");
        math.setBorder(bevelBorder1);
        getContentPane().add(math);
        math.setBackground(java.awt.Color.lightGray);
        math.setBounds(204, 180, 132, 48);
        trophy.setText("Trophy Room");
        trophy.setActionCommand("Trophy Room");
        trophy.setBorder(bevelBorder1);
        getContentPane().add(trophy);
        trophy.setBackground(java.awt.Color.lightGray);
        trophy.setBounds(204, 228, 132, 48);
        personal.setSelectionColor(new java.awt.Color(204, 204, 255));
        personal.setSelectedTextColor(java.awt.Color.black);
        personal.setCaretColor(java.awt.Color.black);
        personal.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        getContentPane().add(personal);
        personal.setFont(new Font("SansSerif", Font.BOLD, 12));
        personal.setBounds(264, 132, 190, 36);
        JLabel1.setText("Enter your name:");
        getContentPane().add(JLabel1);
        JLabel1.setForeground(java.awt.Color.black);
        JLabel1.setBounds(84, 144, 180, 24);
        JButton1.setText("Ok!");
        JButton1.setActionCommand("Ok!");
        JButton1.setBorder(bevelBorder1);
        getContentPane().add(JButton1);
        JButton1.setBackground(java.awt.Color.lightGray);
        JButton1.setBounds(456, 120, 60, 48);

        new PlaySound(classLoader.getResource("welcome.au").getFile());
        imageViewer2 = new ImagePanel(classLoader.getResource("squirtle.gif").getFile());

        Icon imgIcon = new ImageIcon(classLoader.getResource("squirtle.gif"));
        JLabel label = new JLabel(imgIcon);
        label.setBounds(12, 252, 144, 144);

        imageViewer2.setBackground(Color.WHITE);
         getContentPane().add(label);
        imageViewer2.setBounds(12, 252, 144, 144);






        imageViewer3 = new ImagePanel(classLoader.getResource("garfield.gif").getFile());
        imageViewer3.setBackground(Color.WHITE);

        imgIcon = new ImageIcon(classLoader.getResource("garfield.gif"));
        label = new JLabel(imgIcon);
        label.setBounds(408, 240, 155, 166);

        getContentPane().add(label);
        imageViewer3.setBounds(408, 240, 155, 166);

        imageViewer4 = new ImagePanel(classLoader.getResource("clown2.gif").getFile());
        imageViewer4.setBackground(Color.WHITE);

        imgIcon = new ImageIcon(classLoader.getResource("clown2.gif"));
        label = new JLabel(imgIcon);
        label.setBounds(204, 264, 144, 132);

        getContentPane().add(label);
        imageViewer4.setBounds(204, 264, 144, 132);

        // {{REGISTER_LISTENERS
        SymMouse aSymMouse = new SymMouse();
        JButton1.addMouseListener(aSymMouse);
        spell.addMouseListener(aSymMouse);
        math.addMouseListener(aSymMouse);
        art.addMouseListener(aSymMouse);
        trophy.addMouseListener(aSymMouse);
        SymAction lSymAction = new SymAction();
        spell.addActionListener(lSymAction);
        JButton1.addActionListener(lSymAction);
        trophy.addActionListener(lSymAction);
        art.addActionListener(lSymAction);
        math.addActionListener(lSymAction);
        // }}
    }

    class SymMouse extends java.awt.event.MouseAdapter {
        public void mouseExited(java.awt.event.MouseEvent event) {
            Object object = event.getSource();
            if (object == JButton1)
                JButton1_mouseExited(event);
            else if (object == spell)
                spell_mouseExited(event);
            else if (object == math)
                math_mouseExited(event);
            else if (object == art)
                art_mouseExited(event);
            else if (object == trophy)
                trophy_mouseExited(event);

        }

        public void mouseEntered(java.awt.event.MouseEvent event) {
            Object object = event.getSource();
            if (object == JButton1)
                JButton1_mouseEntered(event);
            else if (object == spell)
                spell_mouseEntered(event);
            else if (object == math)
                math_mouseEntered(event);
            else if (object == art)
                art_mouseEntered(event);
            else if (object == trophy)
                trophy_mouseEntered(event);

        }
    }

    void JButton1_mouseEntered(java.awt.event.MouseEvent event) {
        // to do: code goes here.

        JButton1_mouseEntered_Interaction1(event);
    }

    void JButton1_mouseEntered_Interaction1(java.awt.event.MouseEvent event) {
        try {
            // JButton1 Set the Background Color; art The color green
            JButton1.setBackground(Color.green);
            JButton1.repaint();
        } catch (Exception e) {
        }
    }

    void spell_mouseEntered(java.awt.event.MouseEvent event) {
        // to do: code goes here.

        spell_mouseEntered_Interaction1(event);
    }

    void spell_mouseEntered_Interaction1(java.awt.event.MouseEvent event) {
        try {
            // spell Set the Background Color; trophy The color green
            spell.setBackground(Color.green);
            spell.repaint();
        } catch (Exception e) {
        }
    }

    void JButton1_mouseExited(java.awt.event.MouseEvent event) {
        // to do: code goes here.

        JButton1_mouseExited_Interaction1(event);
    }

    void JButton1_mouseExited_Interaction1(java.awt.event.MouseEvent event) {
        try {
            // JButton1 Set the Background Color; JLabel1 The color light gray
            JButton1.setBackground(Color.lightGray);
            JButton1.repaint();
        } catch (Exception e) {
        }
    }

    void spell_mouseExited(java.awt.event.MouseEvent event) {
        // to do: code goes here.

        spell_mouseExited_Interaction1(event);
    }

    void spell_mouseExited_Interaction1(java.awt.event.MouseEvent event) {
        try {
            // spell Set the Background Color; spell The color light gray
            spell.setBackground(Color.lightGray);
            spell.repaint();
        } catch (Exception e) {
        }
    }

    void math_mouseEntered(java.awt.event.MouseEvent event) {
        // to do: code goes here.

        math_mouseEntered_Interaction1(event);
    }

    void math_mouseEntered_Interaction1(java.awt.event.MouseEvent event) {
        try {
            // math Set the Background Color; art The color green
            math.setBackground(Color.green);
            math.repaint();
        } catch (Exception e) {
        }
    }

    void math_mouseExited(java.awt.event.MouseEvent event) {
        // to do: code goes here.

        math_mouseExited_Interaction1(event);
    }

    void math_mouseExited_Interaction1(java.awt.event.MouseEvent event) {
        try {
            // math Set the Background Color; spell The color light gray
            math.setBackground(Color.lightGray);
            math.repaint();
        } catch (Exception e) {
        }
    }

    void art_mouseEntered(java.awt.event.MouseEvent event) {
        // to do: code goes here.

        art_mouseEntered_Interaction1(event);
    }

    void art_mouseEntered_Interaction1(java.awt.event.MouseEvent event) {
        try {
            // art Set the Background Color; trophy The color green
            art.setBackground(Color.green);
            art.repaint();
        } catch (Exception e) {
        }
    }

    void art_mouseExited(java.awt.event.MouseEvent event) {
        // to do: code goes here.

        art_mouseExited_Interaction1(event);
    }

    void art_mouseExited_Interaction1(java.awt.event.MouseEvent event) {
        try {
            // art Set the Background Color; JTextField1 The color light gray
            art.setBackground(Color.lightGray);
            art.repaint();
        } catch (Exception e) {
        }
    }

    void trophy_mouseEntered(java.awt.event.MouseEvent event) {
        // to do: code goes here.

        trophy_mouseEntered_Interaction1(event);
    }

    void trophy_mouseEntered_Interaction1(java.awt.event.MouseEvent event) {
        try {
            // trophy Set the Background Color; math The color green
            trophy.setBackground(Color.green);
            trophy.repaint();
        } catch (Exception e) {
        }
    }

    void trophy_mouseExited(java.awt.event.MouseEvent event) {
        // to do: code goes here.

        trophy_mouseExited_Interaction1(event);
    }

    void trophy_mouseExited_Interaction1(java.awt.event.MouseEvent event) {
        try {
            // trophy Set the Background Color; art The color light gray
            trophy.setBackground(Color.lightGray);
            trophy.repaint();
        } catch (Exception e) {
        }
    }

    class SymAction implements java.awt.event.ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent event) {
            Object object = event.getSource();
            if (object == spell)
                spell_actionPerformed(event);
            else if (object == JButton1)
                JButton1_actionPerformed(event);
            else if (object == trophy)
                trophy_actionPerformed(event);
            else if (object == art)
                art_actionPerformed(event);
            else if (object == math)
                math_actionPerformed(event);
        }
    }

    void spell_actionPerformed(java.awt.event.ActionEvent event) {
        // to do: code goes here.

        spell_actionPerformed_Interaction1(event);
    }

    void JButton1_actionPerformed(java.awt.event.ActionEvent event) {
        // to do: code goes here.

        JButton1_actionPerformed_Interaction1(event);
    }

    void JButton1_actionPerformed_Interaction1(java.awt.event.ActionEvent event) {
        try {
            // affirm.play();
            new PlaySound(classLoader.getResource("Ding.au").getFile());
            name1 = (String.valueOf(personal.getText()));
            name2 = "'s";
            total = name1 + name2;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void spell_actionPerformed_Interaction1(java.awt.event.ActionEvent event) {
        try {
            // SpellFrame Create and show the SpellFrame with a title

            new PlaySound(classLoader.getResource("Ding.au").getFile());
            if (total.equals(test)) {
                new PlaySound(classLoader.getResource("laugh.au").getFile());
                personal.setText("Enter name please!");
            } else  {
                new PlaySound(classLoader.getResource("Ding.au").getFile());
                // click.play();
                String app1 = " ";
                app1 += "Spelling Activity";
                total2 = total + app1;
                (new SpellFrame(total2)).setVisible(true);
            }
        } catch (Exception e) {
        }
    }

    void trophy_actionPerformed(java.awt.event.ActionEvent event) {
        // to do: code goes here.

        trophy_actionPerformed_Interaction1(event);
    }

    void trophy_actionPerformed_Interaction1(java.awt.event.ActionEvent event) {
        try {
            // SpellFrame Create and show the SpellFrame with a title

            new PlaySound(classLoader.getResource("Ding.au").getFile());
            if (total.equals(test)) {
                new PlaySound(classLoader.getResource("laugh.au").getFile());
                personal.setText("Enter name please!");
            } else {
                new PlaySound(classLoader.getResource("Ding.au").getFile());
                String app1 = " ";
                app1 += "Trophy Room";
                total2 = total + app1;
                (new Trophy(total2)).setVisible(true);
            }
        } catch (Exception e) {
        }
    }

    void art_actionPerformed(java.awt.event.ActionEvent event) {
        // to do: code goes here.

        art_actionPerformed_Interaction1(event);
    }

    void art_actionPerformed_Interaction1(java.awt.event.ActionEvent event) {
        try {
            if (total.equals(test)) {
                new PlaySound(classLoader.getResource("laugh.au").getFile());
                personal.setText("Enter name please!");
            } else  {
                new PlaySound(classLoader.getResource("Ding.au").getFile());
                String app1 = " ";
                app1 += "Art Activity";
                total2 = total + app1;
                (new ArtFrame(total2)).setVisible(true);
            }
        } catch (java.lang.Exception e) {
        }
    }

    void math_actionPerformed(java.awt.event.ActionEvent event) {

        math_actionPerformed_Interaction2(event);
    }

    void math_actionPerformed_Interaction2(java.awt.event.ActionEvent event) {
        try {
            // MFrame Create and show the MFrame with a title
            if (total.equals(test)) {
                new PlaySound(classLoader.getResource("laugh.au").getFile());
                personal.setText("Enter name please!");
            } else  {
                total2 = total + " Math Activity";
                new PlaySound(classLoader.getResource("Ding.au").getFile());
                (new MathFrame(total2)).setVisible(true);
            }
        } catch (java.lang.Exception e) {
        }
    }
}
