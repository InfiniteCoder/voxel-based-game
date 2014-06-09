package net.infinitecoder.voxel;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;

public class VBOTest {
	
	private static final int vertex_size = 3;
	private static final int color_size = 4;
	
	private static int vbo_vertex_handle;
	private static int vbo_color_handle;
	
	private static int vertices;
	
	public static void init() {
		float[] verticesArr = {
			// Left bottom triangle
			-0.5f, 0.5f, 0f,
			-0.5f, -0.5f, 0f,
			0.5f, -0.5f, 0f,
			// Right top triangle
			0.5f, -0.5f, 0f,
			0.5f, 0.5f, 0f,
			-0.5f, 0.5f, 0f
		};
		
		vertices = verticesArr.length / 3;
		
		FloatBuffer vertex_data = BufferUtils.createFloatBuffer(vertices * vertex_size);
		vertex_data.put(verticesArr);
		vertex_data.flip();

		FloatBuffer color_data = BufferUtils.createFloatBuffer(vertices * color_size);
		color_data.put(new float[] { 1f, 0f, 0f, 1f});
		color_data.put(new float[] { 0f, 1f, 0f, 1f});
		color_data.put(new float[] { 0f, 0f, 1f, 1f});
		color_data.put(new float[] { 1f, 1f, 1f, 1f});
		color_data.put(new float[] { 1f, 1f, 1f, 1f});
		color_data.put(new float[] { 1f, 1f, 1f, 1f});
		color_data.flip();

		vbo_vertex_handle = glGenBuffers();
		glBindBuffer(GL_ARRAY_BUFFER, vbo_vertex_handle);
		glBufferData(GL_ARRAY_BUFFER, vertex_data, GL_STATIC_DRAW);
		glBindBuffer(GL_ARRAY_BUFFER, 0);

		vbo_color_handle = glGenBuffers();
		glBindBuffer(GL_ARRAY_BUFFER, vbo_color_handle);
		glBufferData(GL_ARRAY_BUFFER, color_data, GL_STATIC_DRAW);
		glBindBuffer(GL_ARRAY_BUFFER, 0);
	}
	
	public static void render() {
		glBindBuffer(GL_ARRAY_BUFFER, vbo_vertex_handle);
		glVertexPointer(vertex_size, GL_FLOAT, 0, 0l);

		glBindBuffer(GL_ARRAY_BUFFER, vbo_color_handle);
		glColorPointer(color_size, GL_FLOAT, 0, 0l);

		glEnableClientState(GL_VERTEX_ARRAY);
		glEnableClientState(GL_COLOR_ARRAY);

		glDrawArrays(GL_TRIANGLES, 0, vertices);

		glDisableClientState(GL_COLOR_ARRAY);
		glDisableClientState(GL_VERTEX_ARRAY);
	}
	
	public static void dispose() {
		glDeleteBuffers(vbo_vertex_handle);
		glDeleteBuffers(vbo_color_handle);
	}
	
}
