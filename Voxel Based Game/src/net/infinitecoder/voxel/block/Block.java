package net.infinitecoder.voxel.block;

import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;

public class Block {
	
	public static Block stone = new ColoredBlock(1, new Vector3f(128, 128, 128));
	public static Block water = new ColoredBlock(2, new Vector3f(1, .7f, 1), new Vector4f(0, 0, 255, .3f));
	
	private int blockID;
	
	public Block(int blockID) {
		this.blockID = blockID;
	}
	
	public int getID() {
		return blockID;
	}
	
	public Vector3f getColor() {return new Vector3f(0, 0, 128);}
	public Vector3f getSize() {return new Vector3f(1, 1, 1);}
	public float getOpacity() {return 1F;}
}
