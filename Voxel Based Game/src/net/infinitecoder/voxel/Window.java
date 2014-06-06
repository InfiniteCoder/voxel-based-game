package net.infinitecoder.voxel;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Window {
	public static void create(String title, int width, int height) {
		try {
			Display.setTitle(title);
			Display.setDisplayMode(new DisplayMode(width, height));
			Display.create();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void render() {
		Display.update();
		//Display.sync(60);
	}
	
	public static void dispose() {
		Display.destroy();
	}
	
	public static boolean isCloseRequested() {
		return Display.isCloseRequested();
	}
	
	public static int getWidth() {
		return Display.getDisplayMode().getWidth();
	}
	
	public static int getHeight() {
		return Display.getDisplayMode().getHeight();
	}
	
	public static String getTitle() {
		return Display.getTitle();
	}
}
