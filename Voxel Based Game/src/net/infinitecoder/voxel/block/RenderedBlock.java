package net.infinitecoder.voxel.block;

import org.lwjgl.util.vector.Vector3f;

public class RenderedBlock {
	private Block block;
	private Vector3f location;
	
	public RenderedBlock(Block block, Vector3f location) {
		this.block = block;
		this.location = location;
	}

	public Block getBlock() {
		return block;
	}

	public void setBlock(Block block) {
		this.block = block;
	}

	public Vector3f getLocation() {
		return location;
	}

	public void setLocation(Vector3f location) {
		this.location = location;
	}
	
}
