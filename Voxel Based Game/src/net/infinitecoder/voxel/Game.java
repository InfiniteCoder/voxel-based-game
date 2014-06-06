package net.infinitecoder.voxel;

import org.lwjgl.opengl.GL11;

public class Game {
	
	public void init() {
		
	}
	
	public void input() {
		
	}
	
	public void update() {
		
	}
	
	public void render() {
		GL11.glTranslatef(0f,0.0f,-7f);             
        GL11.glRotatef(45f,0.0f,1.0f,0.0f);               
        GL11.glColor3f(0.5f,0.5f,1.0f);  
             
        GL11.glBegin(GL11.GL_QUADS);    
           GL11.glColor3f(1.0f,1.0f,0.0f);           
           GL11.glVertex3f( 1.0f, 1.0f,-1.0f);        
           GL11.glVertex3f(-1.0f, 1.0f,-1.0f);        
           GL11.glVertex3f(-1.0f, 1.0f, 1.0f);
           GL11.glVertex3f( 1.0f, 1.0f, 1.0f);  
           GL11.glColor3f(1.0f,0.5f,0.0f);            
           GL11.glVertex3f( 1.0f,-1.0f, 1.0f);
           GL11.glVertex3f(-1.0f,-1.0f, 1.0f);
           GL11.glVertex3f(-1.0f,-1.0f,-1.0f);
           GL11.glVertex3f( 1.0f,-1.0f,-1.0f);
           GL11.glColor3f(1.0f,0.0f,0.0f);
           GL11.glVertex3f( 1.0f, 1.0f, 1.0f);
           GL11.glVertex3f(-1.0f, 1.0f, 1.0f);
           GL11.glVertex3f(-1.0f,-1.0f, 1.0f);
           GL11.glVertex3f( 1.0f,-1.0f, 1.0f);
           GL11.glColor3f(1.0f,1.0f,0.0f);
           GL11.glVertex3f( 1.0f,-1.0f,-1.0f);
           GL11.glVertex3f(-1.0f,-1.0f,-1.0f);
           GL11.glVertex3f(-1.0f, 1.0f,-1.0f);
           GL11.glVertex3f( 1.0f, 1.0f,-1.0f);
           GL11.glColor3f(0.0f,0.0f,1.0f);
           GL11.glVertex3f(-1.0f, 1.0f, 1.0f);
           GL11.glVertex3f(-1.0f, 1.0f,-1.0f);
           GL11.glVertex3f(-1.0f,-1.0f,-1.0f);
           GL11.glVertex3f(-1.0f,-1.0f, 1.0f);
           GL11.glColor3f(1.0f,0.0f,1.0f);
           GL11.glVertex3f( 1.0f, 1.0f,-1.0f);
           GL11.glVertex3f( 1.0f, 1.0f, 1.0f);
           GL11.glVertex3f( 1.0f,-1.0f, 1.0f);
           GL11.glVertex3f( 1.0f,-1.0f,-1.0f);
       GL11.glEnd();   
	}
	
	public void dispose() {
		
	}
	
}
