package com.base.engine;

public class Matrix4f {
	private float[][] m;
	
	public Matrix4f() {
		m = new float[4][4];
	}
	
	public Matrix4f initIdentity() {
		set(0, 0, 1);	set(0, 1, 0);	set(0, 2, 0);	set(0, 3, 0);
		set(1, 0, 0);	set(1, 1, 1);	set(1, 2, 0);	set(1, 3, 0);
		set(2, 0, 0);	set(2, 1, 0);	set(2, 2, 1);	set(2, 3, 0);
		set(3, 0, 0);	set(3, 1, 0);	set(3, 2, 0);	set(3, 3, 1);
		
		return this;
	}
	
	public Matrix4f mul(Matrix4f r) {
		Matrix4f res = new Matrix4f();
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				res.set(i, j, m[i][0] * r.get(0, j) +
							  m[i][1] * r.get(1, j) +
							  m[i][2] * r.get(2, j) +
							  m[i][3] * r.get(3, j));
			}
		}
		
		return res;
	}
	
	public float get(int x, int y) {
		return m[x][y];
	}

	public float[][] getM() {
		return m;
	}

	public void setM(float[][] m) {
		this.m = m;
	}
	
	public void set(int x, int y, float value) {
		m[x][y] = value;
	}
	
}
