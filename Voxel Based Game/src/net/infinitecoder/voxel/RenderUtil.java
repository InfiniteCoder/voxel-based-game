package net.infinitecoder.voxel;

import static org.lwjgl.opengl.GL11.*;

public class RenderUtil {
	public static void initGL() {
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, Window.getWidth(), 0, Window.getHeight(), .1f, 1f);
		glMatrixMode(GL_MODELVIEW);
	}
	
	public static void clearScreen() {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	}
}
