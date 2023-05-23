//Programmer: John Chen
//ProjectL Jump King- Space Oddyssey

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
//This is the main class of the game. This class compiles and runs the game
//in a loop.
public class Game extends Canvas implements Runnable{
	//The variable below are standard through out the whole game.
	//T_V stands for terminal velocity.
	public static final int WIDTH = 960, HEIGHT = 720, T_V = 10;
	//This double is being constantly applied to the y value of the player.
	public static double Gravity = 0.185;
	//The thread of the game.
	private Thread thread;
	//a boolean indicating whether or not the game is running.
	private boolean running = false;
	
	public GameStateManage manager;
	Level level;
	Window window;
	stores stores;
	//This boolean is set to true when the player reaches the last level. 
	public static boolean isfinal = false;
	public Game() throws IOException {
		stores = new stores();
		level = new Level("level.png");
		level.load(stores);
		stores.merge();
		Window window = new Window(WIDTH, HEIGHT, this);
		manager = new GameStateManage(this,stores);
		AudioPlayer.menuAudio.play();
	}
	//This method starts the game.
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
		System.out.println("Game started");
	}
	//This method stops the game.
	public synchronized void stop() {
		try {
			thread.join(1000000);
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//This is the game loop that runs as long as the running variable
	//stays true.
	public void run() {
		long start = System.nanoTime();
		double delta = 0;
		final double ns =  1000000000.0 / 80.0;
		requestFocus();
		while(running) {
			long now = System.nanoTime();
			delta += (now - start)/ns;
			start = now;
			if(delta >= 1) {
				tick();
				delta--;
			}
			if(running) {render();}
		}
		stop();
	}
	//Ticks whatever the GameStateManage redirrects to.
	private void tick() {
		manager.update();
	}
	//Renders using buffered strategy. 
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		manager.render(g);

		g.dispose();
		bs.show();
	}
	//The method below is a method the sets a limit on a value.
	//The method returns maximum when value is bigger or equal to maximum. The same
	//goes for minimum.
	public static int limit(int maximum, int minimum, int value) {
		return Math.max(minimum, Math.min(value, maximum));
	}

	public static void main(String args[]) throws IOException {
		new Game();
	}
}
