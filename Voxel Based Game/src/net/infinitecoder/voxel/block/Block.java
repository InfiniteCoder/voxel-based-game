package net.infinitecoder.voxel.block;

import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;

public class Block {
	
	
	private int blockID;
	
	public Block() {
		Blocks.put("stone", new ColoredBlock(1, new Vector3f(128, 128, 128)));
		Blocks.put("water", new ColoredBlock(2, new Vector3f(1, .7f, 1), new Vector4f(128, 128, 128, .5f)));
	}
	
	public Block(int blockID) {
		this.blockID = blockID;
	}
	
	public int getID() {
		return blockID;
	}
	
	public Vector3f getColor() {return new Vector3f(128, 128, 128);}
	public Vector3f getSize() {return new Vector3f(1, 1, 1);}
	public float getOpacity() {return 1F;}
}
