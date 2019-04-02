package huplay;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.SwingConstants;

public class ArtFrame extends JFrame {
  
    private static final long serialVersionUID = 1L;
    private ClassLoader classLoader = getClass().getClassLoader();
    // Used by addNotify
    boolean frameSizeAdjusted = false;

    // {{DECLARE_CONTROLS
    JLabel JLabel1 = new JLabel();
    ImagePanel image1 = new ImagePanel();
    JLabel JLabel2 = new JLabel();
    ImagePanel image2 = new ImagePanel();
    JLabel JLabel3 = new JLabel();
    JButton OneA = new JButton();
    JButton TwoA = new JButton();
    JButton ThrA = new JButton();
    JButton OneB = new JButton();
    JButton TwoB = new JButton();
    JButton ThrB = new JButton();
    ImagePanel image3 = new ImagePanel();
    ImagePanel image4 = new ImagePanel();
    JButton OneC = new JButton();
    JButton TwoC = new JButton();
    JButton TwoD = new JButton();
    JButton OneD = new JButton();
    JButton ThrC = new JButton();
    JButton ThrD = new JButton();
    JLabel JLabel4 = new JLabel();
    JLabel JLabel5 = new JLabel();
    JLabel JLabel6 = new JLabel();

    ImagePanel artPanel;
    ImagePanel elephant;
    ImagePanel kangaroo;
    ImagePanel penguin;
    ImagePanel building;
    ImagePanel white;
    ImagePanel monument;
    ImagePanel gremlin;
    ImagePanel tap;
    ImagePanel russian;
    ImagePanel chili;
    ImagePanel mouse;
    ImagePanel taz;

    String setting1;
    String setting2;
    String setting3;
    String setting4;
    String a = "1";
    String b = "2";
    String c = "3";

    public ArtFrame() {

        getContentPane().setLayout(null);
        getContentPane().setBackground(java.awt.Color.WHITE);
        setSize(514, 437);
        setVisible(false);
        JLabel1.setText("The");
        getContentPane().add(JLabel1);
        JLabel1.setForeground(java.awt.Color.black);
        JLabel1.setBounds(24, 108, 24, 40);
        try {
            image1.setAlignmentX(CENTER_ALIGNMENT);
            image1.setAlignmentY(CENTER_ALIGNMENT);
            image1.setBackground(Color.WHITE);
        } catch (Exception error) {
            error.printStackTrace();
        }
        image1.setLayout(null);
        getContentPane().add(image1);
        image1.setBounds(60, 72, 144, 108);
        JLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel2.setText("went to the");
        getContentPane().add(JLabel2);
        JLabel2.setForeground(java.awt.Color.black);
        JLabel2.setBounds(204, 108, 96, 40);
        try {
            image2.setAlignmentX(CENTER_ALIGNMENT);
            image2.setBackground(Color.WHITE);
        } catch (Exception error) {
            error.printStackTrace();
        }
        image2.setLayout(null);
        getContentPane().add(image2);
        image2.setBounds(300, 72, 144, 108);
        JLabel3.setText(".");
        getContentPane().add(JLabel3);
        JLabel3.setForeground(java.awt.Color.black);
        JLabel3.setBounds(432, 108, 72, 40);
        OneA.setText("1");
        OneA.setActionCommand("1");
        getContentPane().add(OneA);
        OneA.setFont(new Font("Dialog", Font.BOLD, 14));
        OneA.setBounds(60, 180, 48, 24);
        TwoA.setText("2");
        TwoA.setActionCommand("2");
        getContentPane().add(TwoA);
        TwoA.setFont(new Font("Dialog", Font.BOLD, 14));
        TwoA.setBounds(108, 180, 48, 24);
        ThrA.setText("3");
        ThrA.setActionCommand("3");
        getContentPane().add(ThrA);
        ThrA.setFont(new Font("Dialog", Font.BOLD, 14));
        ThrA.setBounds(156, 180, 48, 24);
        OneB.setText("1");
        OneB.setActionCommand("1");
        getContentPane().add(OneB);
        OneB.setFont(new Font("Dialog", Font.BOLD, 14));
        OneB.setBounds(300, 180, 48, 24);
        TwoB.setText("2");
        TwoB.setActionCommand("2");
        getContentPane().add(TwoB);
        TwoB.setFont(new Font("Dialog", Font.BOLD, 14));
        TwoB.setBounds(348, 180, 48, 24);
        ThrB.setText("3");
        ThrB.setActionCommand("3");
        getContentPane().add(ThrB);
        ThrB.setFont(new Font("Dialog", Font.BOLD, 14));
        ThrB.setBounds(396, 180, 48, 24);
        try {
            image3.setAlignmentX(CENTER_ALIGNMENT);
            image3.setBackground(Color.WHITE);
        } catch (Exception error) {
            error.printStackTrace();
        }
        image3.setLayout(null);
        getContentPane().add(image3);
        image3.setBounds(60, 252, 144, 108);
        try {
            image4.setAlignmentX(CENTER_ALIGNMENT);
            image4.setBackground(Color.WHITE);
        } catch (Exception error) {
            error.printStackTrace();
        }
        image4.setLayout(null);
        getContentPane().add(image4);
        image4.setBounds(312, 252, 144, 108);
        OneC.setText("1");
        OneC.setActionCommand("1");
        getContentPane().add(OneC);
        OneC.setFont(new Font("Dialog", Font.BOLD, 14));
        OneC.setBounds(60, 360, 48, 24);
        TwoC.setText("2");
        TwoC.setActionCommand("2");
        getContentPane().add(TwoC);
        TwoC.setFont(new Font("Dialog", Font.BOLD, 14));
        TwoC.setBounds(108, 360, 48, 24);
        TwoD.setText("2");
        TwoD.setActionCommand("2");
        getContentPane().add(TwoD);
        TwoD.setFont(new Font("Dialog", Font.BOLD, 14));
        TwoD.setBounds(360, 360, 48, 24);
        OneD.setText("1");
        OneD.setActionCommand("1");
        getContentPane().add(OneD);
        OneD.setFont(new Font("Dialog", Font.BOLD, 14));
        OneD.setBounds(312, 360, 48, 24);
        ThrC.setText("3");
        ThrC.setActionCommand("3");
        getContentPane().add(ThrC);
        ThrC.setFont(new Font("Dialog", Font.BOLD, 14));
        ThrC.setBounds(156, 360, 48, 24);
        ThrD.setText("3");
        ThrD.setActionCommand("3");
        getContentPane().add(ThrD);
        ThrD.setFont(new Font("Dialog", Font.BOLD, 14));
        ThrD.setBounds(408, 360, 48, 24);
        JLabel4.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel4.setText("My");
        getContentPane().add(JLabel4);
        JLabel4.setForeground(java.awt.Color.black);
        JLabel4.setBounds(24, 300, 24, 40);
        JLabel5.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel5.setText("parties with");
        getContentPane().add(JLabel5);
        JLabel5.setForeground(java.awt.Color.black);
        JLabel5.setBounds(204, 300, 84, 40);
        JLabel6.setText(".");
        getContentPane().add(JLabel6);
        JLabel6.setForeground(java.awt.Color.black);
        JLabel6.setBounds(432, 300, 72, 40);

        // Images
        try {
            artPanel = new ImagePanel(classLoader.getResource("art.gif").getFile());
        } catch (Exception error) {
            error.printStackTrace();
        }

        getContentPane().add(artPanel);
        artPanel.setBounds(108, 12, 250, 58);
        artPanel.setBackground(Color.WHITE);
        artPanel.setAlignmentX(CENTER_ALIGNMENT);
        artPanel.setAlignmentY(CENTER_ALIGNMENT);
        try {
            elephant = new ImagePanel(classLoader.getResource("elephant.gif").getFile());
        } catch (Exception error) {
            error.printStackTrace();
        }

        // Image 1
        getContentPane().add(elephant);
        elephant.setBounds(60, 72, 144, 108);
        elephant.setBackground(Color.WHITE);
        elephant.setVisible(false);
        try {
            kangaroo = new ImagePanel(classLoader.getResource("kangaroo.gif").getFile());
        } catch (Exception error) {
            error.printStackTrace();
        }

        getContentPane().add(kangaroo);
        kangaroo.setBounds(60, 72, 144, 108);
        kangaroo.setBackground(Color.WHITE);
        kangaroo.setVisible(false);
        try {
            penguin = new ImagePanel(classLoader.getResource("penguin.gif").getFile());
        } catch (Exception error) {
            error.printStackTrace();
        }

        getContentPane().add(penguin);
        penguin.setBounds(60, 72, 144, 108);
        penguin.setBackground(Color.WHITE);
        penguin.setVisible(false);

        // Image 2
        try {
            building = new ImagePanel(classLoader.getResource("building.gif").getFile());
        } catch (Exception error) {
            error.printStackTrace();
        }

        getContentPane().add(building);
        building.setBounds(300, 72, 144, 108);
        building.setBackground(Color.WHITE);
        building.setVisible(false);

        try {
            white = new ImagePanel(classLoader.getResource("whitehouse.jpg").getFile());
        } catch (Exception error) {
            error.printStackTrace();
        }

        getContentPane().add(white);
        white.setBounds(300, 72, 144, 108);
        white.setBackground(Color.WHITE);
        white.setVisible(false);

        try {
            monument = new ImagePanel(classLoader.getResource("mounument.jpg").getFile());
        } catch (Exception error) {
            error.printStackTrace();
        }
        getContentPane().add(monument);
        monument.setBounds(300, 72, 144, 108);
        monument.setBackground(Color.WHITE);
        monument.setVisible(false);

        // Image 3
        try {
            gremlin = new ImagePanel(classLoader.getResource("toon.gif").getFile());
        } catch (Exception error) {
            error.printStackTrace();
        }

        getContentPane().add(gremlin);
        gremlin.setBounds(60, 252, 144, 108);
        gremlin.setBackground(Color.WHITE);
        gremlin.setVisible(false);
        try {
            tap = new ImagePanel(classLoader.getResource("tapdance.gif").getFile());
        } catch (Exception error) {
            error.printStackTrace();
        }

        getContentPane().add(tap);
        tap.setBounds(60, 252, 144, 108);
        tap.setBackground(Color.WHITE);
        tap.setVisible(false);
        try {
            russian = new ImagePanel(classLoader.getResource("russian.gif").getFile());
        } catch (Exception error) {
            error.printStackTrace();
        }

        getContentPane().add(russian);
        russian.setBounds(60, 252, 144, 108);
        russian.setBackground(Color.WHITE);
        russian.setVisible(false);

        // Image 4
        try {
            chili = new ImagePanel(classLoader.getResource("chili.gif").getFile());
        } catch (Exception error) {
            error.printStackTrace();
        }

        getContentPane().add(chili);
        chili.setBounds(312, 252, 144, 108);
        chili.setBackground(Color.WHITE);
        chili.setVisible(false);
        try {
            mouse = new ImagePanel(classLoader.getResource("mouse2.gif").getFile());
        } catch (Exception error) {
            error.printStackTrace();
        }

        getContentPane().add(mouse);
        mouse.setBounds(312, 252, 144, 108);
        mouse.setBackground(Color.WHITE);
        mouse.setVisible(false);
        try {
            taz = new ImagePanel(classLoader.getResource("taz.gif").getFile());
        } catch (Exception error) {
            error.printStackTrace();
        }

        getContentPane().add(taz);
        taz.setBounds(312, 252, 144, 108);
        taz.setBackground(Color.WHITE);
        taz.setVisible(false);

        // {{INIT_MENUS
        // }}

        // {{REGISTER_LISTENERS
        SymAction lSymAction = new SymAction();
        OneA.addActionListener(lSymAction);
        TwoA.addActionListener(lSymAction);
        ThrA.addActionListener(lSymAction);
        OneB.addActionListener(lSymAction);
        TwoB.addActionListener(lSymAction);
        ThrB.addActionListener(lSymAction);
        OneC.addActionListener(lSymAction);
        TwoC.addActionListener(lSymAction);
        ThrC.addActionListener(lSymAction);
        OneD.addActionListener(lSymAction);
        TwoD.addActionListener(lSymAction);
        ThrD.addActionListener(lSymAction);
        // }}
    }

    public ArtFrame(String sTitle) {
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
            if (object == OneA)
                OneA_actionPerformed(event);
            else if (object == TwoA)
                TwoA_actionPerformed(event);
            else if (object == ThrA)
                ThrA_actionPerformed(event);
            else if (object == OneB)
                OneB_actionPerformed(event);
            else if (object == TwoB)
                TwoB_actionPerformed(event);
            else if (object == ThrB)
                ThrB_actionPerformed(event);
            else if (object == OneC)
                OneC_actionPerformed(event);
            else if (object == TwoC)
                TwoC_actionPerformed(event);
            else if (object == ThrC)
                ThrC_actionPerformed(event);
            else if (object == OneD)
                OneD_actionPerformed(event);
            else if (object == TwoD)
                TwoD_actionPerformed(event);
            else if (object == ThrD)
                ThrD_actionPerformed(event);

        }
    }

    void OneA_actionPerformed(java.awt.event.ActionEvent event) {
        // to do: code goes here.

        OneA_actionPerformed_Interaction1(event);
    }

    void OneA_actionPerformed_Interaction1(java.awt.event.ActionEvent event) {
        try {
            // image1 Set the image to be displayed on the panel; elephant Get
            // the URL of the image being viewed

            image1.removeAll();
            image1 = elephant;
            image1.paintComponent(elephant.getGraphics());
            new PlaySound(classLoader.getResource("eleph.au").getFile());
            setting1 = "1";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void TwoA_actionPerformed(java.awt.event.ActionEvent event) {
        // to do: code goes here.

        TwoA_actionPerformed_Interaction1(event);
    }

    void TwoA_actionPerformed_Interaction1(java.awt.event.ActionEvent event) {
        try {
            // image1 Set the image to be displayed on the panel; kangaroo Get
            // the URL of the image being viewed
            image1.removeAll();
            image1 = kangaroo;
            image1.paintComponent(kangaroo.getGraphics());
            new PlaySound(classLoader.getResource("kang.au").getFile());
            setting1 = "2";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void ThrA_actionPerformed(java.awt.event.ActionEvent event) {
        // to do: code goes here.

        ThrA_actionPerformed_Interaction1(event);
    }

    void ThrA_actionPerformed_Interaction1(java.awt.event.ActionEvent event) {
        try {
            // image1 Set the image to be displayed on the panel; penguin Get
            // the URL of the image being viewed
            image1.removeAll();
            image1 = penguin;
            image1.paintComponent(penguin.getGraphics());
            new PlaySound(classLoader.getResource("peng.au").getFile());
            setting1 = "3";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void OneB_actionPerformed(java.awt.event.ActionEvent event) {
        // to do: code goes here.

        OneB_actionPerformed_Interaction1(event);
    }

    void OneB_actionPerformed_Interaction1(java.awt.event.ActionEvent event) {
        try {
            // image2 Set the image to be displayed on the panel; building Get
            // the URL of the image being viewed
            image2.removeAll();
            image2 = building;
            image2.paintComponent(building.getGraphics());

            new PlaySound(classLoader.getResource("went.au").getFile());

            Thread.sleep(1000);

            new PlaySound(classLoader.getResource("build.au").getFile());

            setting2 = "1";

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void TwoB_actionPerformed(java.awt.event.ActionEvent event) {
        // to do: code goes here.

        TwoB_actionPerformed_Interaction1(event);
    }

    void TwoB_actionPerformed_Interaction1(java.awt.event.ActionEvent event) {
        try {
            // image2 Set the image to be displayed on the panel; white Get the
            // URL of the image being viewed
            image2.removeAll();
            image2 = white;
            image2.paintComponent(white.getGraphics());

            new PlaySound(classLoader.getResource("went.au").getFile());

            Thread.sleep(1000);

            new PlaySound(classLoader.getResource("white.au").getFile());
            setting2 = "2";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void ThrB_actionPerformed(java.awt.event.ActionEvent event) {
        // to do: code goes here.

        ThrB_actionPerformed_Interaction1(event);
    }

    void ThrB_actionPerformed_Interaction1(java.awt.event.ActionEvent event) {
        try {
            // image2 Set the image to be displayed on the panel; monument Get
            // the URL of the image being viewed

            image2.removeAll();
            image2 = monument;
            image2.paintComponent(monument.getGraphics());

            new PlaySound(classLoader.getResource("went.au").getFile());

            Thread.sleep(1000);

            new PlaySound(classLoader.getResource("monu.au").getFile());

            setting2 = "2";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void OneC_actionPerformed(java.awt.event.ActionEvent event) {
        // to do: code goes here.

        OneC_actionPerformed_Interaction1(event);
    }

    void OneC_actionPerformed_Interaction1(java.awt.event.ActionEvent event) {
        try {
            // image3 Set the image to be displayed on the panel; russian Get
            // the URL of the image being viewed
            image3.removeAll();
            image3 = russian;
            image3.paintComponent(russian.getGraphics());

            setting3 = "1";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void TwoC_actionPerformed(java.awt.event.ActionEvent event) {
        // to do: code goes here.

        TwoC_actionPerformed_Interaction1(event);
    }

    void TwoC_actionPerformed_Interaction1(java.awt.event.ActionEvent event) {
        try {
            // image3 Set the image to be displayed on the panel; gremlin Get
            // the URL of the image being viewed
            image3.removeAll();
            image3 = gremlin;
            image3.paintComponent(gremlin.getGraphics());
            setting3 = "2";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void ThrC_actionPerformed(java.awt.event.ActionEvent event) {
        // to do: code goes here.

        ThrC_actionPerformed_Interaction1(event);
    }

    void ThrC_actionPerformed_Interaction1(java.awt.event.ActionEvent event) {
        try {
            // image3 Set the image to be displayed on the panel; tap Get the
            // URL of the image being viewed
            image3.removeAll();
            image3 = tap;
            image3.paintComponent(tap.getGraphics());
            setting3 = "3";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void OneD_actionPerformed(java.awt.event.ActionEvent event) {
        // to do: code goes here.

        OneD_actionPerformed_Interaction1(event);
    }

    void OneD_actionPerformed_Interaction1(java.awt.event.ActionEvent event) {
        try {
            // image4 Set the image to be displayed on the panel; chili Get the
            // URL of the image being viewed
            image4.removeAll();
            image4 = chili;
            image4.paintComponent(chili.getGraphics());

            new PlaySound(classLoader.getResource("lives.au").getFile());

            setting4 = "1";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void TwoD_actionPerformed(java.awt.event.ActionEvent event) {
        // to do: code goes here.

        TwoD_actionPerformed_Interaction1(event);
    }

    void TwoD_actionPerformed_Interaction1(java.awt.event.ActionEvent event) {
        try {
            // image4 Set the image to be displayed on the panel; mouse Get the
            // URL of the image being viewed
            image4.removeAll();
            image4 = mouse;
            image4.paintComponent(mouse.getGraphics());

            new PlaySound(classLoader.getResource("lives.au").getFile());
            setting4 = "2";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void ThrD_actionPerformed(java.awt.event.ActionEvent event) {
        // to do: code goes here.

        ThrD_actionPerformed_Interaction1(event);
    }

    void ThrD_actionPerformed_Interaction1(java.awt.event.ActionEvent event) {
        try {
            // image4 Set the image to be displayed on the panel; taz Get the
            // URL of the image being viewed
            image4.removeAll();
            image4 = taz;
            image4.paintComponent(taz.getGraphics());

            new PlaySound(classLoader.getResource("lives.au").getFile());
            setting4 = "3";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        (new ArtFrame("Test Art")).setVisible(true);
    }
}