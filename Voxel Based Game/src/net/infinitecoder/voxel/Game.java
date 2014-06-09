package net.infinitecoder.voxel;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class Game {
	
	private float PX = 0, PY = 0, PZ = 0;
	Chunk chunk;

	public void init() {
		new Game();
		chunk = new Chunk();
		VBOTest.init();
	}

	public void input() {
		if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
			PY-=.1f;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
			PY+=.1f;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
			PX+=.1f;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
			PX-=.1f;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
			PZ-=.1f;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
			PZ+=.1f;
		}
	}

	public void update() {
	}

	public void render() {
		GL11.glTranslatef(-30f + PX, -40f + PY, -160f+PZ);
		//GL11.glRotatef(45f, 0.4f, 1.0f, 0.1f);
		//GL11.glRotatef(45f, 0f, 1.0f, 0f);
		//chunk.render();
		VBOTest.render();
	}

	public void dispose() {
		VBOTest.dispose();
	}
	
}
