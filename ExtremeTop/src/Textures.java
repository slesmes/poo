
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

//lee, carga y almacena todas las imagenes juntas.
public class Textures {

    private Image image;

    public Textures(String path, int width, int height) {
        try {
            BufferedImage img = ImageIO.read(new File(path));
            this.image = img.getScaledInstance(width, height, BufferedImage.TYPE_INT_ARGB);
        } catch (IOException e) {
            System.out.println("imagen no encontrada");
        }
    }

    public Image load() {
        return this.image;
    }
    //segundo constructor que se usa para leer un sprite que requiere cambios.

    public Textures(int x, int y, int width, int height, boolean flip) {
        try {
            if (flip) {
                BufferedImage bi = ImageIO.read(new File("baseFlipped.png"));
                this.image = bi.getSubimage(bi.getWidth() - x - width, y, width, height);
                this.image = image.getScaledInstance(45, 45, BufferedImage.TYPE_INT_ARGB);
            } else {
                BufferedImage bi = ImageIO.read(new File("base.png"));
                this.image = bi.getSubimage(x, y, width, height);
                this.image = image.getScaledInstance(45, 45, BufferedImage.TYPE_INT_ARGB);
            }
        } catch (IOException e) {
            System.out.println("imagen no encontrada");
        }
    }
    public static Textures menuBackground = new Textures("menu.png", Game.WIDTH, Game.HEIGHT);
    public static Textures rightStanding = new Textures(0, 0, 25, 25, false);
    public static Textures rightWalking1 = new Textures(1 * 48, 0, 30, 25, false);
    public static Textures rightWalking2 = new Textures(2 * 48, 0, 25, 25, false);
    public static Textures rightWalking3 = new Textures(3 * 48, 0, 30, 25, false);
    public static Textures rightJump = new Textures(1 * 48 + 2, 1 * 48 - 5, 25, 32, false);
    public static Textures rightfalling = new Textures(2 * 48 + 2, 1 * 48 - 5, 25, 32, false);
    public static Textures rightbouncing = new Textures(0 * 48 + 2, 2 * 48, 30, 25, false);

    public static Textures charging = new Textures(0 * 48 + 1, 1 * 48, 30, 25, false);
    public static Textures resting = new Textures(3 * 48, 1 * 48, 30, 25, false);

    //imagenes de movimiento del jugador
    public static Textures leftStanding = new Textures(0, 0, 25, 25, true);
    public static Textures leftWalking1 = new Textures(1 * 48, 0, 30, 25, true);
    public static Textures leftWalking2 = new Textures(2 * 48, 0, 25, 25, true);
    public static Textures leftWalking3 = new Textures(3 * 48, 0, 30, 25, true);
    public static Textures leftJump = new Textures(1 * 48 + 2, 1 * 48 - 5, 25, 32, true);
    public static Textures leftfalling = new Textures(2 * 48 + 2, 1 * 48 - 5, 25, 32, true);
    public static Textures leftbouncing = new Textures(0 * 48 + 2, 2 * 48, 30, 25, true);

    //imagenes del mundo
    public static Textures background5 = new Textures("final.png", Game.WIDTH, Game.HEIGHT);
    public static Textures princess = new Textures("princess.png", 40, 40);
    public static Textures holding = new Textures("holding.png", 25, 25);
    public static Textures end = new Textures("jump_king.jpg", Game.WIDTH, Game.HEIGHT);

}
