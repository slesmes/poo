import java.awt.Graphics;
import java.awt.Graphics2D;
public class GamePlay {
	public stores stores;
	public control c;
	public Level level;
	public Game game;
	public Camera cam;
	public GamePlay( Game main , stores stores, Menu gsm) {
		cam = new Camera(0,Game.HEIGHT*0,gsm,stores);
		this.stores = stores;
		game = main;
		stores.add(new Player(300,Game.HEIGHT*4+651,ID.Player,stores));
		c = new control(stores);
		main.addKeyListener(c);
	}
	public void tick() {
		stores.tick();
		c.velocityCheck();
		for(int i = 0; i < stores.object.size(); i++) {
			if(stores.object.get(i).getid() == ID.Player) {
				cam.update((Player)stores.object.get(i));
				break;
			}
		}
	}
	public void render(Graphics g) {
		cam.render(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.translate(cam.getX(), cam.getY());
		stores.render(g);
		g2d.translate(-cam.getX(), -cam.getY());

	}
}
