import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
//This class manages the state of the game based on conditions given by
//its current state.
public class GameStateManage{
	//Values for a switch statement
	private int state =0;
	private final int Menu = 0;
	private final int GamePlay = 1;
	private final int End = 2;
	//Menu class that creates a menu
	private Menu menu;
	//GamePlay class that loads levels and player.
	private GamePlay gameplay;
	private int timer = 0;
	private float alpha = 1f;
	
	//Constructor
	public GameStateManage( Game main , stores stores) throws IOException {

		menu = new Menu(main,this);
		gameplay = new GamePlay(main,stores,this);
	}
	//This is the tick method of this class. It redirects to other tick
	//method in the game.
	public void update(){
		switch(state) {
		case Menu:
		//Showing Menu...
		menu.tick();
		break;
		case GamePlay:
		//Bring out Game Play...
		gameplay.tick();
		break;
		case End:
		//Bring out End credit....
			
		break;
		}
	}
	//This renders method redirects to other render method of the game.
	public void render(Graphics g) {
		switch(state) {
		case Menu:
		//Showing Menu...
		menu.render(g);
		break;
		case GamePlay:
		//Bring out Game Play...
		gameplay.render(g);
		break;
		case End:
			//Bring out End credit....
			Graphics2D g2d = (Graphics2D) g;
			timer++;
			if(timer > 1000) {
				if(alpha >= 0.01f)
					alpha -= 0.01f;
				g.drawRect(0, 0, Game.WIDTH, Game.HEIGHT);
				if(timer == 1500)
					ChangeGameState();
			}
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC,alpha));
			g2d.drawImage(Textures.end.load(), 0, 0, null);
		break;
		}
	}
	//changes the state by increasing it.
	public void ChangeGameState() {
		//State increase value in cycle...
		if(state < 2) {
			state++;
		}else state = 0;
	}
	
}
