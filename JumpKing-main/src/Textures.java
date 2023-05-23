import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
//This class read, loads, and stores all pictures together.
import javax.imageio.ImageIO;

public class Textures{
	//Remembering the image.
	private Image image;
	//This first constructor is used to read in pictures that does not require extraction.
	public Textures(String path, int width, int height) {
		try {
			BufferedImage img = ImageIO.read(new File(path));
			this.image = img.getScaledInstance(width, height, BufferedImage.TYPE_INT_ARGB);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//returns the image.
	public Image load() {
		return this.image;
	}
	//The second constructor is used to read in a sprite sheet that requires extraction.
	public Textures(int x, int y, int width, int height,boolean flip) {
		try {
			if(flip) {
				BufferedImage bi = ImageIO.read(new File("baseFlipped.png"));
				this.image =  bi.getSubimage(bi.getWidth() - x - width, y, width, height);
				this.image = image.getScaledInstance(45, 45, BufferedImage.TYPE_INT_ARGB);
			}else {
				BufferedImage bi = ImageIO.read(new File("base.png"));
				this.image =  bi.getSubimage(x, y, width, height);
				this.image = image.getScaledInstance(45, 45, BufferedImage.TYPE_INT_ARGB);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//All the static variables below are read-in pictures.
	public static Textures menuBackground = new Textures("menu.png",Game.WIDTH,Game.HEIGHT);
	public static Textures rightStanding = new Textures(0, 0, 25, 25,false);
	public static Textures rightWalking1 = new Textures(1*48,0,30,25,false);
	public static Textures rightWalking2 = new Textures(2*48,0,25,25,false);
	public static Textures rightWalking3 = new Textures(3*48,0,30,25,false);
	public static Textures rightJump = new Textures(1*48+2,1*48-5,25,32,false);
	public static Textures rightfalling = new Textures(2*48+2,1*48-5,25,32,false);
	public static Textures rightbouncing = new Textures(0*48+2,2*48,30,25,false);
	
	
	public static Textures charging = new Textures(0*48+1,1*48,30,25,false);
	public static Textures resting = new Textures(3*48,1*48,30,25,false);
	
	
	public static Textures leftStanding = new Textures(0, 0, 25, 25,true);
	public static Textures leftWalking1 = new Textures(1*48,0,30,25,true);
	public static Textures leftWalking2 = new Textures(2*48,0,25,25,true);
	public static Textures leftWalking3 = new Textures(3*48,0,30,25,true);
	public static Textures leftJump = new Textures(1*48+2,1*48-5,25,32,true);
	public static Textures leftfalling = new Textures(2*48+2,1*48-5,25,32,true);
	public static Textures leftbouncing = new Textures(0*48+2,2*48,30,25,true);
	
	
	public static Textures background1 = new Textures("1.png",Game.WIDTH, Game.HEIGHT);
	public static Textures background2 = new Textures("2.png",Game.WIDTH, Game.HEIGHT);
	public static Textures background3 = new Textures("3.png",Game.WIDTH, Game.HEIGHT);
	public static Textures background4 = new Textures("4.png",Game.WIDTH, Game.HEIGHT+100);
	public static Textures background5 = new Textures("final.png",Game.WIDTH, Game.HEIGHT);
	public static Textures princess = new Textures("princess.png",40,40);
	public static Textures holding = new Textures("holding.png",25,25);
	public static Textures end = new Textures("jump_king.jpg",Game.WIDTH,Game.HEIGHT);


}
