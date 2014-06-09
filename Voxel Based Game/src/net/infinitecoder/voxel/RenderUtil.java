package net.infinitecoder.voxel;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.util.glu.GLU;

public class RenderUtil {
	public static void initGL() {
		glShadeModel(GL_SMOOTH);
        glClearColor(0.0f, 51.0f / 255.0f, 102.0f / 255.0f, 0.0f); 
        glClearDepth(1.0); 
        glEnable(GL_DEPTH_TEST);
        //glDepthFunc(GL_LEQUAL);
        
        glFrontFace(GL_CCW);
		glCullFace(GL_BACK);
		glEnable(GL_CULL_FACE);
        
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		GLU.gluPerspective(70.0F, Window.getWidth() / Window.getHeight(), 0.05F, 1000.0F);
		glMatrixMode(GL_MODELVIEW);
		glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);
	}
	
	public static void clearScreen() {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		glLoadIdentity();
	}
}
