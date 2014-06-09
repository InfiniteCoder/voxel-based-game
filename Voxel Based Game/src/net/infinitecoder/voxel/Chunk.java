package net.infinitecoder.voxel;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;

import net.infinitecoder.voxel.block.Block;
import net.infinitecoder.voxel.block.RenderedBlock;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.util.vector.Vector3f;


public class Chunk {
	public static final int CHUNK_SIZE = 2;
	private int amount;
	
	private float[] fromTo(ArrayList<float[]> list) {
		float[] total = new float[0];
		return total;
	}
	
	private float[] getFromBlock(RenderedBlock block) {
		float[] block_vertex_array = new float[]{
			//   x      y      z      nx     ny     nz     r      g      b      a
		    // back quad
		         1.0f,  1.0f,  1.0f,  0.0f,  0.0f, block.getLocation().getZ() + block.getBlock().getSize().getZ(),  block.getBlock().getColor().getX(),  block.getBlock().getColor().getY(),  block.getBlock().getColor().getZ(),  block.getBlock().getOpacity(),
		        -1.0f,  1.0f,  1.0f,  0.0f,  0.0f, block.getLocation().getZ() + block.getBlock().getSize().getZ(),  block.getBlock().getColor().getX(),  block.getBlock().getColor().getY(),  block.getBlock().getColor().getZ(),  block.getBlock().getOpacity(),
		        -1.0f, -1.0f,  1.0f,  0.0f,  0.0f, block.getLocation().getZ() + block.getBlock().getSize().getZ(),  block.getBlock().getColor().getX(),  block.getBlock().getColor().getY(),  block.getBlock().getColor().getZ(),  block.getBlock().getOpacity(),
		         1.0f, -1.0f,  1.0f,  0.0f,  0.0f, block.getLocation().getZ() + block.getBlock().getSize().getZ(),  block.getBlock().getColor().getX(),  block.getBlock().getColor().getY(),  block.getBlock().getColor().getZ(),  block.getBlock().getOpacity(),

		    // front quad
		         1.0f,  1.0f, -1.0f,  0.0f,  0.0f, -1.0f,  block.getBlock().getColor().getX(),  block.getBlock().getColor().getY(),  block.getBlock().getColor().getZ(),  block.getBlock().getOpacity(),
		        -1.0f,  1.0f, -1.0f,  0.0f,  0.0f, -1.0f,  block.getBlock().getColor().getX(),  block.getBlock().getColor().getY(),  block.getBlock().getColor().getZ(),  block.getBlock().getOpacity(),
		        -1.0f, -1.0f, -1.0f,  0.0f,  0.0f, -1.0f,  block.getBlock().getColor().getX(),  block.getBlock().getColor().getY(),  block.getBlock().getColor().getZ(),  block.getBlock().getOpacity(),
		         1.0f, -1.0f, -1.0f,  0.0f,  0.0f, -1.0f,  block.getBlock().getColor().getX(),  block.getBlock().getColor().getY(),  block.getBlock().getColor().getZ(),  block.getBlock().getOpacity(),

		    // left quad
		        -1.0f,  1.0f, -1.0f, -1.0f,  0.0f,  0.0f,  block.getBlock().getColor().getX(),  block.getBlock().getColor().getY(),  block.getBlock().getColor().getZ(),  block.getBlock().getOpacity(),
		        -1.0f,  1.0f,  1.0f, -1.0f,  0.0f,  0.0f,  block.getBlock().getColor().getX(),  block.getBlock().getColor().getY(),  block.getBlock().getColor().getZ(),  block.getBlock().getOpacity(),
		        -1.0f, -1.0f,  1.0f, -1.0f,  0.0f,  0.0f,  block.getBlock().getColor().getX(),  block.getBlock().getColor().getY(),  block.getBlock().getColor().getZ(),  block.getBlock().getOpacity(),
		        -1.0f, -1.0f, -1.0f, -1.0f,  0.0f,  0.0f,  block.getBlock().getColor().getX(),  block.getBlock().getColor().getY(),  block.getBlock().getColor().getZ(),  block.getBlock().getOpacity(),

		    // right quad
		         1.0f,  1.0f, -1.0f,  1.0f,  0.0f,  0.0f,  block.getBlock().getColor().getX(),  block.getBlock().getColor().getY(),  block.getBlock().getColor().getZ(),  block.getBlock().getOpacity(),
		         1.0f,  1.0f,  1.0f,  1.0f,  0.0f,  0.0f,  block.getBlock().getColor().getX(),  block.getBlock().getColor().getY(),  block.getBlock().getColor().getZ(),  block.getBlock().getOpacity(),
		         1.0f, -1.0f,  1.0f,  1.0f,  0.0f,  0.0f,  block.getBlock().getColor().getX(),  block.getBlock().getColor().getY(),  block.getBlock().getColor().getZ(),  block.getBlock().getOpacity(),
		         1.0f, -1.0f, -1.0f,  1.0f,  0.0f,  0.0f,  block.getBlock().getColor().getX(),  block.getBlock().getColor().getY(),  block.getBlock().getColor().getZ(),  block.getBlock().getOpacity(),

		    // top quad
		        -1.0f,  1.0f, -1.0f,  0.0f,  1.0f,  0.0f,  block.getBlock().getColor().getX(),  block.getBlock().getColor().getY(),  block.getBlock().getColor().getZ(),  block.getBlock().getOpacity(),
		        -1.0f,  1.0f,  1.0f,  0.0f,  1.0f,  0.0f,  block.getBlock().getColor().getX(),  block.getBlock().getColor().getY(),  block.getBlock().getColor().getZ(),  block.getBlock().getOpacity(),
		         1.0f,  1.0f,  1.0f,  0.0f,  1.0f,  0.0f,  block.getBlock().getColor().getX(),  block.getBlock().getColor().getY(),  block.getBlock().getColor().getZ(),  block.getBlock().getOpacity(),
		         1.0f,  1.0f, -1.0f,  0.0f,  1.0f,  0.0f,  block.getBlock().getColor().getX(),  block.getBlock().getColor().getY(),  block.getBlock().getColor().getZ(),  block.getBlock().getOpacity(),

		    // bottom quad
		        -1.0f, -1.0f, -1.0f,  0.0f, -1.0f,  0.0f,  block.getBlock().getColor().getX(),  block.getBlock().getColor().getY(),  block.getBlock().getColor().getZ(),  block.getBlock().getOpacity(),
		        -1.0f, -1.0f,  1.0f,  0.0f, -1.0f,  0.0f,  block.getBlock().getColor().getX(),  block.getBlock().getColor().getY(),  block.getBlock().getColor().getZ(),  block.getBlock().getOpacity(),
		         1.0f, -1.0f,  1.0f,  0.0f, -1.0f,  0.0f,  block.getBlock().getColor().getX(),  block.getBlock().getColor().getY(),  block.getBlock().getColor().getZ(),  block.getBlock().getOpacity(),
		         1.0f, -1.0f, -1.0f,  0.0f, -1.0f,  0.0f,  block.getBlock().getColor().getX(),  block.getBlock().getColor().getY(),  block.getBlock().getColor().getZ(),  block.getBlock().getOpacity(),
		};
		return block_vertex_array;
	}
	
	public Chunk() {
		IntBuffer buffer = BufferUtils.createIntBuffer(1);
	    GL15.glGenBuffers(buffer);

	    int vertex_buffer_id = buffer.get(0);

	    float[] vertex_data_array = getFromBlock(new RenderedBlock(Block.water, new Vector3f(0, 0, 0)));

	    amount += vertex_data_array.length;
	    
	    FloatBuffer vertex_buffer_data = BufferUtils.createFloatBuffer(amount);
	    vertex_buffer_data.put(vertex_data_array);
	    
	    vertex_buffer_data.rewind();

	    GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vertex_buffer_id);
	    GL15.glBufferData(GL15.GL_ARRAY_BUFFER, vertex_buffer_data, GL15.GL_STATIC_DRAW);
	}
	
	public void render() {
		 GL11.glVertexPointer(3, GL11.GL_FLOAT, 40, 0);
	      GL11.glNormalPointer(GL11.GL_FLOAT, 40, 12);
	      GL11.glColorPointer(4, GL11.GL_FLOAT, 40, 24);

	      GL11.glDrawArrays(GL11.GL_QUADS, 0, amount / 10);
	}
	
	public FloatBuffer floatBuffer(float a, float b, float c, float d) {
	    float[] data = new float[]{a,b,c,d};
	    FloatBuffer fb = BufferUtils.createFloatBuffer(data.length);
	    fb.put(data);
	    fb.flip();
	    return fb;
	  }
	
}
