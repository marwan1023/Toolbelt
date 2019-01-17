package tesselation;

import graphicslib3D.*;

import java.io.*;
import javax.swing.*;

import static com.jogamp.opengl.GL4.*;
import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.texture.*;

public class Code extends JFrame implements GLEventListener
{	private GLCanvas myCanvas;
	private GLSLUtils util = new GLSLUtils();
	private int rendering_program;
	private int vao[] = new int[1];
	
	private Point3D terLoc = new Point3D(0,0,0);
	private Point3D cameraLoc = new Point3D(0,0,4);
	
	private Matrix3D proj_matrix = new Matrix3D();
	private Matrix3D m_matrix = new Matrix3D();
	private Matrix3D v_matrix = new Matrix3D();
	private Matrix3D mvp_matrix = new Matrix3D();
	
	private float tessInner = 30.0f;
	private float tessOuter = 20.0f;

	private int textureID;
	private Texture tex;

	private String dir = "src/src/main/java/tesselation/";
	public Code()
	{	setTitle("Chapter 12 - program 2");
		setSize(600, 600);
		myCanvas = new GLCanvas();
		myCanvas.addGLEventListener(this);
		getContentPane().add(myCanvas);
		this.setVisible(true);
	}

	public void display(GLAutoDrawable drawable)
	{	GL4 gl = (GL4) GLContext.getCurrentGL();
		gl.glUseProgram(rendering_program);
		int mvp_location = gl.glGetUniformLocation(rendering_program, "mvp");
		
		float aspect = (float) myCanvas.getWidth() / (float) myCanvas.getHeight();
		proj_matrix = perspective(50.0f, aspect, 0.1f, 1000.0f);
	
		m_matrix.setToIdentity();
		m_matrix.translate(terLoc.getX(),terLoc.getY(),terLoc.getZ());
		m_matrix.rotateX(30.0f);
		m_matrix.rotateY(100.0f);
		
		v_matrix.setToIdentity();
		v_matrix.translate(-cameraLoc.getX(),-cameraLoc.getY(),-cameraLoc.getZ());
		
		mvp_matrix.setToIdentity();
		mvp_matrix.concatenate(proj_matrix);
		mvp_matrix.concatenate(v_matrix);
		mvp_matrix.concatenate(m_matrix);
		
		gl.glUniformMatrix4fv(mvp_location, 1, false, mvp_matrix.getFloatValues(), 0);
		
		gl.glActiveTexture(GL_TEXTURE0);
		gl.glBindTexture(GL_TEXTURE_2D, textureID);
	
		gl.glFrontFace(GL_CCW);

		gl.glPatchParameteri(GL_PATCH_VERTICES, 16);
		gl.glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
		gl.glDrawArrays(GL_PATCHES, 0, 16);
	}

	public void init(GLAutoDrawable drawable)
	{	GL4 gl = (GL4) GLContext.getCurrentGL();
		rendering_program = createShaderPrograms();
		
		tex = loadTexture(dir + "floor_color.jpg");
		textureID = tex.getTextureObject();
		
		gl.glGenVertexArrays(vao.length, vao, 0);
		gl.glBindVertexArray(vao[0]);
	}

//--------------------------------------------------------------------------------------------
	
	public static void main(String[] args) { new Code(); }
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {}
	public void dispose(GLAutoDrawable drawable) {}
	
//-----------------

	private int createShaderPrograms()
	{	GL4 gl = (GL4) GLContext.getCurrentGL();

		String vshaderSource[]  = util.readShaderSource(dir + "vert.shader");
		String tcshaderSource[] = util.readShaderSource(dir + "tessC.shader");
		String teshaderSource[] = util.readShaderSource(dir + "tessE.shader");
		String fshaderSource[]  = util.readShaderSource(dir + "frag.shader");

		int vShader  = gl.glCreateShader(GL_VERTEX_SHADER);
		int tcShader = gl.glCreateShader(GL_TESS_CONTROL_SHADER);
		int teShader = gl.glCreateShader(GL_TESS_EVALUATION_SHADER);
		int fShader  = gl.glCreateShader(GL_FRAGMENT_SHADER);

		gl.glShaderSource(vShader, vshaderSource.length, vshaderSource, null, 0);
		gl.glShaderSource(tcShader, tcshaderSource.length, tcshaderSource, null, 0);
		gl.glShaderSource(teShader, teshaderSource.length, teshaderSource, null, 0);
		gl.glShaderSource(fShader, fshaderSource.length, fshaderSource, null, 0);

		gl.glCompileShader(vShader);
		gl.glCompileShader(tcShader);
		gl.glCompileShader(teShader);
		gl.glCompileShader(fShader);

		int vtfprogram = gl.glCreateProgram();
		gl.glAttachShader(vtfprogram, vShader);
		gl.glAttachShader(vtfprogram, tcShader);
		gl.glAttachShader(vtfprogram, teShader);
		gl.glAttachShader(vtfprogram, fShader);
		gl.glLinkProgram(vtfprogram);
		return vtfprogram;
	}

	private Matrix3D perspective(float fovy, float aspect, float n, float f)
	{	float q = 1.0f / ((float) Math.tan(Math.toRadians(0.5f * fovy)));
		float A = q / aspect;
		float B = (n + f) / (n - f);
		float C = (2.0f * n * f) / (n - f);
		Matrix3D r = new Matrix3D();
		r.setElementAt(0,0,A);
		r.setElementAt(1,1,q);
		r.setElementAt(2,2,B);
		r.setElementAt(3,2,-1.0f);
		r.setElementAt(2,3,C);
		r.setElementAt(3,3,0.0f);
		return r;
	}
	
	public Texture loadTexture(String textureFileName)
	{	Texture tex = null;
		try { tex = TextureIO.newTexture(new File(textureFileName), false); }
		catch (Exception e) { e.printStackTrace(); }
		return tex;
	}
}