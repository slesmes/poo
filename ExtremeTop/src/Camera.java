
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * Aqui se realiazan los cambios de pantallas en los limites.
 *
 * @author Santiago Lesmes Marín
 * @author María José Muñoz Posada
 * @version 1.0.0
 */
public class Camera {

    private int x;
    private int y;
    private Player player;
    private final int first = 4;
    private final int second = 3;
    private final int third = 2;
    private final int fourth = 1;
    private final int fifth = 0;
    private int level = 4;
    public Menu gsm;
    public stores stores;

    public Camera(int x, int y, Menu gsm, stores stores) {
        this.stores = stores;
        this.gsm = gsm;
        this.x = x;
        this.y = y;
    }

    
    public void update(Player player) {
        this.level = player.getY() / Game.HEIGHT;
        y = -((player.getY() / Game.HEIGHT) * Game.HEIGHT);
        this.player = player;
    }

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        switch (level) {
            case first:
                g2d.drawImage(Textures.background5.load(), x, -y - (4 * Game.HEIGHT), null);
                break;
            case second:
                g2d.drawImage(Textures.background5.load(), x, -y - (3 * Game.HEIGHT), null);
                break;
            case third:
                g2d.drawImage(Textures.background5.load(), x, -y - (2 * Game.HEIGHT), null);
                break;
            case fourth:
                g2d.drawImage(Textures.background5.load(), x, -y - (1 * Game.HEIGHT), null);
                break;
            case fifth:
                g2d.drawImage(Textures.background5.load(), x, -y - (0 * Game.HEIGHT), null);
                g2d.drawImage(Textures.princess.load(), x + 500, -y + 180, null);
                if (player.getX() > 500 && player.getY() > 170 && player.getY() < 190) {
                    stores.remove(player);
                    g.dispose();
                    gsm.ChangeGameState();
                }
                break;
        }
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
