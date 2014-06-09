package net.infinitecoder.voxel.block;

import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;

public class ColoredBlock extends Block {
	
	protected Vector3f color, size;
	protected float opacity;

	public ColoredBlock(int blockID, Vector3f color) {
		this(blockID, new Vector3f(1, 1, 1), color);
	}
	
	public ColoredBlock(int blockID, Vector3f size, Vector3f color) {
		this(blockID, size, new Vector4f(color.x, color.y, color.z, 1F));
	}
	
	public ColoredBlock(int blockID, Vector3f size, Vector4f color) {
		super(blockID);
		this.color = new Vector3f(color.x/255f, color.y/255f, color.z/255f);
		this.opacity = color.w;
		this.size = size;
	}

	@Override
	public Vector3f getColor() {
		return color;
	}

	@Override
	public Vector3f getSize() {
		return size;
	}

	@Override
	public float getOpacity() {
		return opacity;
	}

}
