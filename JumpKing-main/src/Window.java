import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
//This is the setting for my window.
public class Window extends Canvas{
	private static final long serialVersionUID = -8255319694373975038L;
	public Window(int width, int height, Game game) {
		JFrame framework = new JFrame();
		Dimension dimension = new Dimension(width,height);
		//focus on the window.
		framework.addNotify();
		framework.setFocusable(true);
		//set it to resizable so that the measurements of my game is 
		//unchangable.
		framework.setPreferredSize(dimension);
		framework.setMaximumSize(dimension);
		framework.setMinimumSize(dimension);
		framework.setResizable(false);
		//Title....
		framework.setTitle("Jump King: Space Oddyssey");
		
		framework.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framework.setLocationRelativeTo(null);
		framework.add(game);
		
		framework.setVisible(true);
		//Starts the game...
		game.start();
	}
}
