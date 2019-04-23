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
import javax.swing.JTextArea;


public class AboutDialog extends Dialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public AboutDialog(Frame parent, boolean modal)
	{
		super(parent, modal);
    
		//{{INIT_CONTROLS
		setLayout(null);
		setBackground(new java.awt.Color(253,236,219));
		setFont(new Font("Dialog", Font.ITALIC, 12));
		setSize(314,180);
		setVisible(false);
		okButton.setLabel("OK");
		add(okButton);
		okButton.setBackground(new java.awt.Color(0,0,128));
		//okButton.setForeground(new java.awt.Color(253,236,219));
		okButton.setBounds(108,144,66,27);
		JTextArea ta = new JTextArea();
		ta.setText("Stable Storage is an application created by 4 Howard University Seniors.  Israel Cook, Zarinah El-Amin, Marcus Johnson, and Jalatee Worjloh.  This project was created to fulfill the graduation requirements of a B.S. in Systems and Computer Science.");
		ta.setColumns(5);
		ta.setLineWrap(true);
		ta.setEditable(false);
		add(ta);
		ta.setBackground(new java.awt.Color(253,236,219));
		ta.setForeground(new java.awt.Color(0,0,128));
		ta.setFont(new Font("Serif", Font.ITALIC, 14));
		ta.setBounds(12,12,276,120);
		setTitle("About JST- Stable Storage");
        
		//{{REGISTER_LISTENERS
		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		SymAction lSymAction = new SymAction();
		okButton.addActionListener(lSymAction);
		//}}

	}
    
	public AboutDialog(Frame parent, String title, boolean modal)
	{
		this(parent, modal);
		setTitle(title);
	}

	public void addNotify()
	{
		// Record the size of the window prior to calling parents addNotify.
                Dimension d = getSize();

		super.addNotify();

		// Only do this once.
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

		// Used for addNotify check.
		fComponentsAdjusted = true;
	}

	public void setVisible(boolean b)
	{
	    if (b)
	    {
    		Rectangle bounds = getParent().getBounds();
    		Rectangle abounds = getBounds();

    		setLocation(bounds.x + (bounds.width - abounds.width)/ 2,
    			 bounds.y + (bounds.height - abounds.height)/2);
	    }

		super.setVisible(b);
	}

	//{{DECLARE_CONTROLS
	java.awt.Button okButton = new java.awt.Button();
	//}}
    
    // Used for addNotify check.
	boolean fComponentsAdjusted = false;

	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == okButton)
				okButton_ActionPerformed(event);
		}
	}

	void okButton_ActionPerformed(java.awt.event.ActionEvent event)
	{
		// to do: code goes here.
			 
		okButton_ActionPerformed_Interaction1(event);
	}


	void okButton_ActionPerformed_Interaction1(java.awt.event.ActionEvent event)
	{
		try {
			this.dispose();
		} catch (Exception e) {
		}
	}


	class SymWindow extends java.awt.event.WindowAdapter
	{
		public void windowClosing(java.awt.event.WindowEvent event)
		{
			Object object = event.getSource();
			if (object == AboutDialog.this)
				AboutDialog_WindowClosing(event);
		}
	}

	void AboutDialog_WindowClosing(java.awt.event.WindowEvent event)
	{
		// to do: code goes here.
			 
		AboutDialog_WindowClosing_Interaction1(event);
	}


	void AboutDialog_WindowClosing_Interaction1(java.awt.event.WindowEvent event)
	{
		try {
			this.dispose();
		} catch (Exception e) {
		}
	}
	
	public static void main(String[] args)
	{
	    JFrame frame = new JFrame();
	    AboutDialog ad = new AboutDialog(frame, true);
	    ad.setVisible(true);
	    
	}

}
