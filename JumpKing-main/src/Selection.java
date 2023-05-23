import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;

//This class represents a button
public class Selection extends Rectangle{
	private Font font;
	private String text;
	private Color color,selectColor;
	private boolean selected;
	private int x,y;
	
	public Selection(Color color, Color selectColor, String text , Font font,int x, int y) {
		this.color  = color; 
		this.selectColor  = selectColor; 
		this.text = text; 
		this.font = font; 
		this.x = x;
		this.y = y;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	//Draws the string based on the color text. 
	public void render(Graphics g) {
		if(selected) {
			g.setColor(selectColor);
		}else {	
			g.setColor(color);
		}
		g.setFont(font);
		g.drawString(text, x, y);
	}
}
