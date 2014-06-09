package net.infinitecoder.voxel;

public class Main {
	
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static final String TITLE = "Voxel Engine";
	private Game game;

	public Main() {
		start();
	}
	
	public void start() {
		System.out.println("Started.");
		Window.create(TITLE, WIDTH, HEIGHT);
		game = new Game();
		run();
	}
	
	public void stop() {
		System.out.println("Stopped.");
		dispose();
	}
	
	private void run() {
		RenderUtil.initGL();
		Time.init();
		game.init();
		
		while(!Window.isCloseRequested()) {
			int delta = Time.getDelta();
			update(delta);
			render();
		}
		
		stop();
	}
	
	private void update(int delta) {
		game.input();
		game.update();
		Time.update();
	}
	
	private void render() {
		RenderUtil.clearScreen();
		game.render();
		Window.render();
	}
	
	private void dispose() {
		game.dispose();
		Window.dispose();
	}
	
}
