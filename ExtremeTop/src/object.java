
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class object {

    protected int x;
    protected int y;
    protected ID id;
    protected double dx = 0, dy = 0;

    public object(int x, int y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public abstract Rectangle getSkeleton();

    public void setDX(int n) {
        this.dx = n;
    }

    public void setDY(int n) {
        this.dy = n;
    }

    public ID getid() {
        return this.id;

    }

    public double getDY() {
        return this.dy;
    }

    public double getDX() {
        return this.dx;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
