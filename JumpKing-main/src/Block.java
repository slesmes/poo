import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Comparator;
//This is a block class that is a child of the object class.
public class Block extends object implements Comparable<Block>{
	//the width and height of the block.
	private int width;
	private int height;
	private Color c;
	private int r = 0;
	private int b = 0;
	private int gr = 0;
	private int counter = 0;
	////initialize the x and y value of the block.
	public Block(int x, int y, ID id) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
		this.width = 32;
		this.height = 32;
	}
	//Block doesn't move, therefore doesn't tick. Since tick
	//is an abstract method, it needs to be overrided.
	@Override
	public void tick() {
	}
	//This renders method draws the last stage.
	@Override
	public void render(Graphics g) {
			Graphics2D g2d = (Graphics2D) g;
			counter++;
			if(counter % 20 == 0) {
				gr = gr + randomNum();
				b = b + randomNum();
				r = r + randomNum();
				if(b > 255)
					b = 0;
				if(gr > 255)
					gr = 0;
				if(r > 255)
					r = 0;
			}
			c = new Color(r,b,gr);
			g2d.setColor(c);
			g2d.drawRect(x, y, width, height);

	}
	public int randomNum() {
		return (int)(Math.random() * 80 + 1);

	}
	//Getters and setters
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
		return new Rectangle(x,y,width,height);
	}
	public Rectangle getTop() {
		return new Rectangle(x,y-1,width,1);
	}
	//Overriding compareTo method to sort a list of block by it
	//y value. From big to small.
	@Override
	public int compareTo(Block o) {
		return o.getY() - this.y;
	}

}
//comparator method to sort block by x value
class SortX implements Comparator<Block>{
	public int compare(Block o1, Block o2) {
		return o1.getX()-o2.getX();
	}

}

