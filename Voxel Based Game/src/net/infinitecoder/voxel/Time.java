package net.infinitecoder.voxel;

import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;

public class Time {
	public static long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}

	private static long lastFrame;
	private static long lastFPS;
	private static int fps;
	private static int latestFPS;

	public static int getDelta() {
		long time = getTime();
		int delta = (int) (time - lastFrame);
		lastFrame = time;

		return delta;
	}

	public static void init() {
		getDelta();
		lastFPS = getTime();
	}

	/**
	 * @return put this at bottom of main update loop
	 */
	public static void update() {
		if (getTime() - lastFPS > 1000) {
			latestFPS = fps;
			//System.out.println(latestFPS + " FPS");
			Display.setTitle(Main.TITLE + " | " + latestFPS + " FPS");
			fps = 0;
			lastFPS += 1000;
		}
		fps++;
	}

	public static int getFPS() {
		return latestFPS;
	}
}
