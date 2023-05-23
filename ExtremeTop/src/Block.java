
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * Son los obstáculos del jugador.
 *
 * @author Santiago Lesmes Marín
 * @author María José Muñoz Posada
 * @version 1.0.0
 */

public class Block extends object {

    /**
     * Ancho del bloque.
     */
    private int width;
    /**
     * Alto del bloque.
     */
    private int height;

    public Block(int x, int y, ID id) {
        super(x, y, id);
        this.width = 32;
        this.height = 32;
    }
    
    @Override
    public void tick() {
    }
    
    @Override
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.DARK_GRAY);
        g2d.fillRect(x, y, width, height);

    }
    public void setWidth(int a) {
        this.width = a;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public Rectangle getSkeleton() {
        return new Rectangle(x, y, width, height);
    }
    
    public Rectangle getTop() {
        return new Rectangle(x, y - 1, width, 1);
    }

}
