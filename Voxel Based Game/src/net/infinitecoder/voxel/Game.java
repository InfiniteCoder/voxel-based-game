package net.infinitecoder.voxel;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class Game {
	
	private float PX, PY, PZ;

	public void init() {
		
	}

	public void input() {
		if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
			PY--;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
			PY++;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
			PX++;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
			PX--;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_E)) {
			PZ--;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_Q)) {
			PZ++;
		}
	}

	public void update() {
	}

	public void render() {
		GL11.glTranslatef(-30f + PX, -40f + PY, -160f+PZ);
		GL11.glRotatef(45f, 0.4f, 1.0f, 0.1f);
		GL11.glRotatef(45f, 0f, 1.0f, 0f);
	}

	public void dispose() {

	}
	
}
