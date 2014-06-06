package net.infinitecoder.voxel;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.util.glu.GLU;

public class RenderUtil {
	public static void initGL() {
		glShadeModel(GL_SMOOTH);
        glClearColor(0.0f, 0.0f, 0.0f, 0.0f); 
        glClearDepth(1.0); 
        glEnable(GL_DEPTH_TEST);
        glDepthFunc(GL_LEQUAL);
        
        glEnableClientState(GL_VERTEX_ARRAY);
		glEnableClientState(GL_COLOR_ARRAY);
		
		glCullFace(GL_CW);
		glEnable(GL_CULL_FACE);
        
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		GLU.gluPerspective(
		           45.0f,
		           (float)Window.getWidth()/(float)Window.getHeight(),
		           0.1f,
		           300.0f);
		glMatrixMode(GL_MODELVIEW);
		glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);
	}
	
	public static void clearScreen() {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		glLoadIdentity();
	}
}
