import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
//This menu class the class that creates a menu out of graphics.
public class Menu{
	private Font f = new Font("Arial", Font.BOLD, 40);
	private BufferedImage title;
	private ArrayList<Selection> options;
	int selected = 0;
	GameStateManage gsm;
	menuControl mc;
	Game main;
	//A select method that do task when the user pressed enter.
	public void select() {
		switch(selected) {
		case 0:
			gsm.ChangeGameState();
			break;
		case 2:
			main.stop();
			break;
		}
	}
	//this is the tick method.
	public void tick() {
	}
	//This is the render method that renders the Strings and its colors.
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(Textures.menuBackground.load(), 0, 0, null);
		for(int i = 0; i < options.size(); i++) {
			if(selected == i) {
				options.get(i).setSelected(true);
			}else
				options.get(i).setSelected(false);
			options.get(i).render(g);
		}
		
	}
	//a loop if the user exceeds the lower and upper limit.
	public void DS() {
		if( selected < options.size()-1) {
			selected++;
		}else
			selected = 0;
	}
	public void US() {
		if(selected > 0) {
			selected--;
		}else
			selected = 1;
	}
	//Constructor that links the game , GameStateManager, and this class together.
	public Menu(Game main, GameStateManage gsm) {

		options = new ArrayList<Selection>();
		options.add(new Selection(Color.white,Color.yellow,"Start Game", f, 200, 350));
		options.add(new Selection(Color.white,Color.yellow,"Quit", f, 200, 450));
		mc = new menuControl(this);
		main.addKeyListener(mc);
		this.gsm = gsm;
		this.main = main;
	}
	
}
//A control class for menu
class menuControl extends KeyAdapter{
	Menu menu;
	
	public menuControl(Menu menu) {
		this.menu = menu;
	}
	
	public void keyPressed(KeyEvent e) {
		int input = e.getKeyCode();
		if(input == KeyEvent.VK_UP) {
			menu.US();
		}else if(input == KeyEvent.VK_DOWN) {
			menu.DS();
		}
		if(input == KeyEvent.VK_ENTER) {
			menu.select();
		}
			
	}
}




