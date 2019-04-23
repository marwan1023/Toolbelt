package seniorproject;

/*
	A basic extension of the java.awt.Frame class
 */

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Insets;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.Timer;

public class Registration extends Frame
{
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    private SetFiles sf = new SetFiles();

    public Registration()
	{
		// This code is automatically generated by Visual Cafe when you add
		// components to the visual environment. It instantiates and initializes
		// the components. To modify the code, only use code syntax that matches
		// what Visual Cafe can generate, or Visual Cafe may be unable to back
		// parse your Java file into its visual environment.
		//{{INIT_CONTROLS
		setLayout(null);
		setBackground(new java.awt.Color(253,236,219));
		setSize(394,143);
		setVisible(false);
		//$$ timer1.move(36,12);
		MainScreenLabel.setText("Welcome to Stable Storage");
		add(MainScreenLabel);
		MainScreenLabel.setForeground(new java.awt.Color(0,0,128));
		MainScreenLabel.setFont(new Font("Serif", Font.BOLD|Font.ITALIC, 30));
		MainScreenLabel.setBounds(12,36,358,64);
		setTitle("JST- Stable Storage");
		//}}

		//{{INIT_MENUS
		//}}

		//{{REGISTER_LISTENERS
		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		SymAction lSymAction = new SymAction();
		
		timer1 = new Timer(3000,lSymAction);
		//}}
	}

	public Registration(String title)
	{
		this();
		setTitle(title);
	}

    /**
     * Shows or hides the component depending on the boolean flag b.
     * @param b  if true, show the component; otherwise, hide the component.
     * @see java.awt.Component#isVisible
     */
    public void setVisible(boolean b)
	{
		if(b)
		{
			setLocation(50, 50);
		}
		super.setVisible(b);
	}

	static public void main(String args[])
	{
		(new Registration()).setVisible(true);
	}
	
	public void addNotify()
	{
	    // Record the size of the window prior to calling parents addNotify.
	    Dimension d = getSize();
	    
		super.addNotify();

		if (fComponentsAdjusted)
			return;

		// Adjust components according to the insets
		Insets insets = getInsets();
		setSize(insets.left + insets.right + d.width, insets.top + insets.bottom + d.height);
		Component components[] = getComponents();
		for (int i = 0; i < components.length; i++)
		{
			Point p = components[i].getLocation();
			p.translate(insets.left, insets.top);
			components[i].setLocation(p);
		}
		fComponentsAdjusted = true;
	}

    // Used for addNotify check.
	boolean fComponentsAdjusted = false;

	//{{DECLARE_CONTROLS
	Timer timer1;
	JLabel MainScreenLabel = new JLabel();
	//}}

	//{{DECLARE_MENUS
	//}}

	class SymWindow extends java.awt.event.WindowAdapter
	{
		public void windowOpened(java.awt.event.WindowEvent event)
		{
			Object object = event.getSource();
			if (object == Registration.this)
				OpeningScreen_WindowOpened(event);
		}

		public void windowClosing(java.awt.event.WindowEvent event)
		{
			Object object = event.getSource();
			if (object == Registration.this)
				OpeningScreen_WindowClosing(event);
		}
	}
	
	void OpeningScreen_WindowClosing(java.awt.event.WindowEvent event)
	{
		setVisible(false);		 // hide the Frame
	}

	void OpeningScreen_WindowOpened(java.awt.event.WindowEvent event)
	{
		// to do: code goes here.
			 
		OpeningScreen_WindowOpened_Interaction1(event);
	}

	void OpeningScreen_WindowOpened_Interaction1(java.awt.event.WindowEvent event)
	{
		try {
			// timer1 Start Timer
			timer1.start();
		} catch (java.lang.Exception e) {
		}
	}

	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == timer1)
				timer1_ActionPerformed(event);
		}
	}

	void timer1_ActionPerformed(java.awt.event.ActionEvent event)
	{
		// to do: code goes here.
			 
		timer1_ActionPerformed_Interaction1(event);
			 
		timer1_ActionPerformed_Interaction2(event);
	}

	void timer1_ActionPerformed_Interaction1(java.awt.event.ActionEvent event)
	{
		try {
			// SetFiles Create and show the SetFiles
		    if (!sf.isVisible())
		    {
		        sf.setVisible(true);
		    }
			} catch (java.lang.Exception e) {
		}
	}

	void timer1_ActionPerformed_Interaction2(java.awt.event.ActionEvent event)
	{
		try {
			// OpeningScreen Hide the OpeningScreen
			this.setVisible(false);
		} catch (java.lang.Exception e) {
		}
	}
}
