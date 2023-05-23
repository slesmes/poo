import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
//This class compiles all the instructions necessary to construct
//gameplay.
public class GamePlay extends Canvas{
	//Only one stores object is created to stores all the object.
	public stores stores;
	//Control class is created to bring in controls.
	public control c;
	//Level is created to load the level.
	public Level level;
	public Game game;
	public Camera cam;
	//Constructor links the main stores and main game class together.
	public GamePlay( Game main , stores stores, GameStateManage gsm) {
		cam = new Camera(0,Game.HEIGHT*0,gsm,stores);
		this.stores = stores;
		game = main;
		//the player below will spawn at the top--Enable to cheat(you have to comment
		//out the other player.
		//stores.add(new Player(140,100,ID.Player,stores));
		stores.add(new Player(300,Game.HEIGHT*4+651,ID.Player,stores));
		c = new control(stores);
		main.addKeyListener(c);
	}
//This is the tick method of this program.
	public void tick() {
		//The method below ticks through all the objects stored in stores.
		stores.tick();
		//checks the velocity of the player.
		c.velocityCheck();
		//Update the camera based on the player's position. 
		for(int i = 0; i < stores.object.size(); i++) {
			if(stores.object.get(i).getid() == ID.Player) {
				cam.update((Player)stores.object.get(i));
				break;
			}
		}
	}
	//This method renders objects in the game.
	public void render(Graphics g) {
		cam.render(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.translate(cam.getX(), cam.getY());
		//What ever is sandwich between cam is rendered. and projected onto the screen.
		//In this case, stores objects are being rendered.
		stores.render(g);
		g2d.translate(-cam.getX(), -cam.getY());

	}
}
