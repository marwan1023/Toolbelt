package chapter2;

import java.nio.*;
import javax.swing.*;
import static com.jogamp.opengl.GL4.*;
import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.common.nio.Buffers;

public class Background extends JFrame implements GLEventListener
{	private GLCanvas myCanvas;

	public Background()
	{	setTitle("Chapter2 - program1");
		setSize(600,400);
		setLocation(200,200);
		myCanvas = new GLCanvas();
		myCanvas.addGLEventListener(this);
		getContentPane().add(myCanvas);
		setVisible(true);
	}

	public void display(GLAutoDrawable drawable)
	{	GL4 gl = (GL4) GLContext.getCurrentGL();

		float bkg[] = { 1.0f, 0.0f, 0.0f, 1.0f };
		FloatBuffer bkgBuffer = Buffers.newDirectFloatBuffer(bkg);
		
		gl.glClearBufferfv(GL_COLOR, 0, bkgBuffer);
	}

	public static void main(String[] args)
	{ new Background();
	}

	public void init(GLAutoDrawable drawable) {}
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {}
	public void dispose(GLAutoDrawable drawable) {}
}