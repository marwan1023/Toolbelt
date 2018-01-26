package random;

import graphicslib3D.*;
import graphicslib3D.GLSLUtils.*;

import javax.swing.*;
import java.nio.*;
import java.util.*;
import java.awt.Color;

import static com.jogamp.opengl.GL4.*;
import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.*;
import com.jogamp.common.nio.Buffers;

/*  Simulates drifting and changing clouds.
    To view the skydome from the outside, move the camera to 0,2,10
	   and change the winding order to CCW.
*/

public class Code extends JFrame implements GLEventListener
{
	private GLCanvas myCanvas;
	private GLSLUtils util = new GLSLUtils();

	private int rendering_program;
	private int[] vao = new int[1];
	private int[] vbo = new int[2];
	private int mv_location, proj_location, dOffset_location;
	
	private int textureID;

	private HalfSphere halfSphere = new HalfSphere(48);
	private int numSphereVertices;
	
	private Point3D objLoc = new Point3D(0,0,0);
	private Point3D cameraLoc = new Point3D(0,2,0);

	private Matrix3D m_matrix = new Matrix3D();
	private Matrix3D v_matrix = new Matrix3D();
	private Matrix3D mv_matrix = new Matrix3D();
	private Matrix3D proj_matrix = new Matrix3D();

	private int noiseHeight= 200;
	private int noiseWidth = 200;
	private int noiseDepth = 200;
	private double[][][] noise = new double[noiseHeight][noiseWidth][noiseDepth];
	private Random random = new Random();
	
	private double rotAmt = 0.0;
	private float d = 0.01f; // depth for 3rd dimension of 3D noise texture

	private String dir = "src/src/main/java/random/";
	public Code()
	{	setTitle("Chapter 14 - program8");
		setSize(1000, 800);
		myCanvas = new GLCanvas();
		myCanvas.addGLEventListener(this);
		this.getContentPane().add(myCanvas);
		this.setVisible(true);
		FPSAnimator animator = new FPSAnimator(myCanvas,60);
		animator.start();
	}

	public void display(GLAutoDrawable drawable)
	{	GL4 gl = (GL4) GLContext.getCurrentGL();

		gl.glClear(GL_DEPTH_BUFFER_BIT);
		float bkg[] = { 1.0f, 1.0f, 1.0f, 1.0f };
		FloatBuffer bkgBuffer = Buffers.newDirectFloatBuffer(bkg);
		gl.glClearBufferfv(GL_COLOR, 0, bkgBuffer);

		float aspect = (float) myCanvas.getWidth() / (float) myCanvas.getHeight();
		proj_matrix = perspective(50.0f, aspect, 0.1f, 1000.0f);
		
		gl.glUseProgram(rendering_program);

		mv_location = gl.glGetUniformLocation(rendering_program, "mv_matrix");
		proj_location = gl.glGetUniformLocation(rendering_program, "proj_matrix");
		dOffset_location = gl.glGetUniformLocation(rendering_program, "d");

		m_matrix.setToIdentity();
		m_matrix.translate(objLoc.getX(),objLoc.getY(),objLoc.getZ());
		rotAmt += 0.02;
		m_matrix.rotateY(rotAmt);
		m_matrix.scale(4,4,4);

		v_matrix.setToIdentity();
		v_matrix.translate(-cameraLoc.getX(),-cameraLoc.getY(),-cameraLoc.getZ());
		
		mv_matrix.setToIdentity();
		mv_matrix.concatenate(v_matrix);
		mv_matrix.concatenate(m_matrix);
		
		d += 0.00005f; if (d >= 0.99f) d = 0.01f;
		
		gl.glUniformMatrix4fv(mv_location, 1, false, mv_matrix.getFloatValues(), 0);
		gl.glUniformMatrix4fv(proj_location, 1, false, proj_matrix.getFloatValues(), 0);
		gl.glUniform1f(dOffset_location, d);
		
		gl.glBindBuffer(GL_ARRAY_BUFFER, vbo[0]);
		gl.glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);
		gl.glEnableVertexAttribArray(0);
		
		gl.glBindBuffer(GL_ARRAY_BUFFER, vbo[1]);
		gl.glVertexAttribPointer(1, 2, GL_FLOAT, false, 0, 0);
		gl.glEnableVertexAttribArray(1);
		
		gl.glActiveTexture(GL_TEXTURE0);
		gl.glBindTexture(GL_TEXTURE_3D, textureID);
		
		gl.glEnable(GL_CULL_FACE);
		gl.glFrontFace(GL_CW);	// we are viewing the inside of the skydome
		gl.glEnable(GL_DEPTH_TEST);
		gl.glDepthFunc(GL_LEQUAL);

		gl.glDrawArrays(GL_TRIANGLES, 0, numSphereVertices);
	}

	public void init(GLAutoDrawable drawable)
	{	GL4 gl = (GL4) GLContext.getCurrentGL();
		rendering_program = createShaderPrograms();
		setupVertices();
		generateNoise();	
		textureID = loadNoiseTexture();
	}
	
	private void setupVertices()
	{	GL4 gl = (GL4) GLContext.getCurrentGL();
	
		Vertex3D[] sphere_vertices = halfSphere.getVertices();
		int[] sphere_indices = halfSphere.getIndices();	
		float[] sphere_fvalues = new float[sphere_indices.length*3];
		float[] sphere_tvalues = new float[sphere_indices.length*2];
		
		for (int i=0; i<sphere_indices.length; i++)
		{	sphere_fvalues[i*3]   = (float) (sphere_vertices[sphere_indices[i]]).getX();			
			sphere_fvalues[i*3+1] = (float) (sphere_vertices[sphere_indices[i]]).getY();
			sphere_fvalues[i*3+2] = (float) (sphere_vertices[sphere_indices[i]]).getZ();
		
			sphere_tvalues[i*2]   = (float) (sphere_vertices[sphere_indices[i]]).getS();
			sphere_tvalues[i*2+1] = (float) (sphere_vertices[sphere_indices[i]]).getT();
		}
		numSphereVertices = sphere_indices.length;

		gl.glGenVertexArrays(vao.length, vao, 0);
		gl.glBindVertexArray(vao[0]);
		gl.glGenBuffers(2, vbo, 0);
		
		//  put the Sphere vertices into the first buffer,
		gl.glBindBuffer(GL_ARRAY_BUFFER, vbo[0]);
		FloatBuffer vertBuf = Buffers.newDirectFloatBuffer(sphere_fvalues);
		gl.glBufferData(GL_ARRAY_BUFFER, vertBuf.limit()*4, vertBuf, GL_STATIC_DRAW);
		
		//  put the Sphere texture coordinates into the second buffer,
		gl.glBindBuffer(GL_ARRAY_BUFFER, vbo[1]);
		FloatBuffer normalBuf = Buffers.newDirectFloatBuffer(sphere_tvalues);
		gl.glBufferData(GL_ARRAY_BUFFER, normalBuf.limit()*4, normalBuf, GL_STATIC_DRAW);
	}

	public static void main(String[] args) { new Code(); }
	public void dispose(GLAutoDrawable drawable) {}
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {}

//-----------------

	private void fillDataArray(byte data[])
	{ for (int i=0; i<noiseHeight; i++)
	  { for (int j=0; j<noiseWidth; j++)
	    { for (int k=0; k<noiseDepth; k++)
	      {	float brightness = 1.0f - (float) turbulence(i,j,k,32) / 256.0f;
			Color c = new Color(brightness, brightness, 1.0f, 1.0f);
	        data[i*(noiseWidth*noiseHeight*4)+j*(noiseHeight*4)+k*4+0] = (byte) c.getRed();
	        data[i*(noiseWidth*noiseHeight*4)+j*(noiseHeight*4)+k*4+1] = (byte) c.getGreen();
	        data[i*(noiseWidth*noiseHeight*4)+j*(noiseHeight*4)+k*4+2] = (byte) c.getBlue();
	        data[i*(noiseWidth*noiseHeight*4)+j*(noiseHeight*4)+k*4+3] = (byte) 0;
	} } } } 

	private int loadNoiseTexture()
	{	GL4 gl = (GL4) GLContext.getCurrentGL();

		byte[] data = new byte[noiseHeight*noiseWidth*noiseDepth*4];
		
		fillDataArray(data);

		ByteBuffer bb = Buffers.newDirectByteBuffer(data);

		int[] textureIDs = new int[1];
		gl.glGenTextures(1, textureIDs, 0);
		int textureID = textureIDs[0];

		gl.glBindTexture(GL_TEXTURE_3D, textureID);

		gl.glTexStorage3D(GL_TEXTURE_3D, 1, GL_RGBA8, noiseWidth, noiseHeight, noiseDepth);
		gl.glTexSubImage3D(GL_TEXTURE_3D, 0, 0, 0, 0,
				noiseWidth, noiseHeight, noiseDepth, GL_RGBA, GL_UNSIGNED_INT_8_8_8_8_REV, bb);
		
		gl.glTexParameteri(GL_TEXTURE_3D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);

		return textureID;
	}

	void generateNoise()
	{	for (int x=0; x<noiseHeight; x++)
		{	for (int y=0; y<noiseWidth; y++)
			{	for (int z=0; z<noiseDepth; z++)
				{	noise[x][y][z] = random.nextDouble();
	}	}	}	}
	
	double smoothNoise(double x1, double y1, double z1)
	{	//get fractional part of x, y, and z
		double fractX = x1 - (int) x1;
		double fractY = y1 - (int) y1;
		double fractZ = z1 - (int) z1;

		//neighbor values
		int x2 = ((int)x1 + noiseWidth - 1) % noiseWidth;
		int y2 = ((int)y1 + noiseHeight- 1) % noiseHeight;
		int z2 = ((int)z1 + noiseDepth - 1) % noiseDepth;

		//smooth the noise by interpolating
		double value = 0.0;
		value += fractX     * fractY     * fractZ     * noise[(int)x1][(int)y1][(int)z1];
		value += fractX     * (1-fractY) * fractZ     * noise[(int)x1][(int)y2][(int)z1];
		value += (1-fractX) * fractY     * fractZ     * noise[(int)x2][(int)y1][(int)z1];
		value += (1-fractX) * (1-fractY) * fractZ     * noise[(int)x2][(int)y2][(int)z1];

		value += fractX     * fractY     * (1-fractZ) * noise[(int)x1][(int)y1][(int)z2];
		value += fractX     * (1-fractY) * (1-fractZ) * noise[(int)x1][(int)y2][(int)z2];
		value += (1-fractX) * fractY     * (1-fractZ) * noise[(int)x2][(int)y1][(int)z2];
		value += (1-fractX) * (1-fractY) * (1-fractZ) * noise[(int)x2][(int)y2][(int)z2];

		return value;
	}

	private double turbulence(double x, double y, double z, double size)
	{	double value = 0.0, initialSize = size, cloud_quant;
		while(size >= 0.9)
		{	value = value + smoothNoise(x/size, y/size, z/size) * size;
			size = size / 2.0;
		}
		cloud_quant = 110.0; // tunable quantity of clouds
		value = value/initialSize;
		value = 256.0 * logistic(value * 128.0 - cloud_quant);
		//value = 128.0 * value / initialSize;
		return value;
	}

	private double logistic(double x)
	{	double k = 0.2; // tunable haziness of clouds
		return (1.0/(1.0+Math.pow(2.718,-k*x)));
	}

	private int createShaderPrograms()
	{	GL4 gl = (GL4) GLContext.getCurrentGL();

		String[] vShaderSource = util.readShaderSource(dir + "shaderVert");
		String[] fShaderSource = util.readShaderSource(dir + "shaderFrag");
		
		int VShader = gl.glCreateShader(GL_VERTEX_SHADER);
		int FShader = gl.glCreateShader(GL_FRAGMENT_SHADER);

		gl.glShaderSource(VShader, vShaderSource.length, vShaderSource, null, 0);
		gl.glShaderSource(FShader, fShaderSource.length, fShaderSource, null, 0);
		
		gl.glCompileShader(VShader);
		gl.glCompileShader(FShader);
		
		int vfprogram = gl.glCreateProgram();

		gl.glAttachShader(vfprogram, VShader);
		gl.glAttachShader(vfprogram, FShader);
		gl.glLinkProgram(vfprogram);
		
		return vfprogram;
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
}