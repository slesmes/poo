import java.awt.Graphics;
import java.awt.Graphics2D;
//This class is a camera class that renders objects in a given area.
public class Camera {
	//Common variable.
	private int x;
	private int y;
	//This player object is linked to the player object created in the class GamePlay
	private Player player;
	//All the scenes that will be rendered
	private final int first = 4;
	private final int second = 3;
	private final int third = 2;
	private final int fourth = 1;
	private final int fifth = 0;
	private int level = 4;
	//This is linked to the GameStateManage created in Game class.
	public GameStateManage gsm ;
	//This stores is linked to the stores created in GamePlay Class.
	public stores stores;
	//Initializing the variables and linking/share variable between classes.
	public Camera(int x, int y, GameStateManage gsm, stores stores) {
		this.stores = stores;
		this.gsm = gsm;
		this.x = x;
		this.y = y;
	}
	//this is the tick method of this class.
	//This method takes in a player class and set
	//the y-value of the camera based on the coordinates of the player.
	public void update(Player player) {
		this.level = player.getY()/Game.HEIGHT;
		y = -((player.getY()/Game.HEIGHT) * Game.HEIGHT);
		this.player = player;
	}
	//This render method renders one scenes at a time which is the based
	//on the level the player is in.
	//Graphics g is linked to the same graphics g in Game.render.
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		switch(level) {
		case first:
			g2d.drawImage(Textures.background5.load(), x, -y-(4*Game.HEIGHT) , null);
			break;
		case second:
			g2d.drawImage(Textures.background5.load(), x, -y-(3*Game.HEIGHT), null);
			break;
		case third:
			g2d.drawImage(Textures.background5.load(), x, -y-(2*Game.HEIGHT), null);
			break;
		case fourth:
			g2d.drawImage(Textures.background5.load(), x, -y-(1*Game.HEIGHT), null);
			break;
		case fifth:
			g2d.drawImage(Textures.background5.load(), x, -y-(0*Game.HEIGHT), null);
			g2d.drawImage(Textures.princess.load(),x+500,-y+180,null);
			if(player.getX() > 500 && player.getY() > 170 && player.getY() < 190) {
				stores.remove(player);
				g.dispose();
				gsm.ChangeGameState();
			}
			break;
		}
	}
	//getter and setter
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
}
