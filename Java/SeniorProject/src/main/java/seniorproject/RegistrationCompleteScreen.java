package seniorproject;

/*
	A basic extension of the java.awt.Dialog class
 */

import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class RegistrationCompleteScreen extends Dialog
{
	/**
     * 
     */
    private static final long serialVersionUID = 1L;


    public RegistrationCompleteScreen(Frame parent)
	{
		super(parent);

		// This code is automatically generated by Visual Cafe when you add
		// components to the visual environment. It instantiates and initializes
		// the components. To modify the code, only use code syntax that matches
		// what Visual Cafe can generate, or Visual Cafe may be unable to back
		// parse your Java file into its visual environment.
		//{{INIT_CONTROLS
		setLayout(null);
		setBackground(new java.awt.Color(253,236,219));
		setSize(297,165);
		setVisible(false);
		RegistrationCompleteLabel.setText("Registration done.");
		add(RegistrationCompleteLabel);
		RegistrationCompleteLabel.setForeground(new java.awt.Color(0,0,128));
		RegistrationCompleteLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
		RegistrationCompleteLabel.setBounds(48,84,216,64);
		JLabel1.setText("Thank You");
		add(JLabel1);
		JLabel1.setForeground(new java.awt.Color(0,0,128));
		JLabel1.setFont(new Font("SansSerif", Font.BOLD, 20));
		JLabel1.setBounds(84,12,156,60);
		//}}

		//{{REGISTER_LISTENERS
		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		//}}
	}
	
	public RegistrationCompleteScreen(Frame parent, boolean modal)
	{
		this(parent);
        setModal(modal);
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


	public RegistrationCompleteScreen(Frame parent, String title, boolean modal)
	{
		this(parent, modal);
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
			Rectangle bounds = getParent().getBounds();
			Rectangle abounds = getBounds();
	
			setLocation(bounds.x + (bounds.width - abounds.width)/ 2,
				 bounds.y + (bounds.height - abounds.height)/2);
		}
		super.setVisible(b);
	}

	//{{DECLARE_CONTROLS
	JLabel RegistrationCompleteLabel = new JLabel();
	JLabel JLabel1 = new JLabel();
	//}}

	class SymWindow extends java.awt.event.WindowAdapter
	{
		public void windowClosing(java.awt.event.WindowEvent event)
		{
			Object object = event.getSource();
			if (object == RegistrationCompleteScreen.this)
				RegistrationCompleteScreen_WindowClosing(event);
		}
	}
	
	void RegistrationCompleteScreen_WindowClosing(java.awt.event.WindowEvent event)
	{
		setVisible(false);
	}
	
	public static void main(String[] args)
	{
	    JFrame frame = new JFrame();
	    RegistrationCompleteScreen rcs = new RegistrationCompleteScreen(frame);
	    rcs.setVisible(true);
	}
}
