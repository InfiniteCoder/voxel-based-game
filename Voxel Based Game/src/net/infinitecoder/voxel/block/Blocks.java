package net.infinitecoder.voxel.block;

import java.util.HashMap;

public class Blocks {
	private static HashMap<String, Block> blockTypes = new HashMap<String, Block>();
	
	public static void put(String name, Block b) {
		blockTypes.put(name, b);
	}
	
	public static Block get(int blockID) {
		for(Block b : blockTypes.values()) {
			if(b.getID() == blockID)
				return b;
		}
		return null;
	}
	
	public static HashMap<String, Block> getBlockTypes() {
		return blockTypes;
	}
}
