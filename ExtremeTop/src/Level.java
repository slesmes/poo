
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Level {

    private String path;

    public Level(String path) {
        this.path = path;
    }

    public void load(stores stores) {
        try {
            BufferedImage image = ImageIO.read(new File(path));
            image = image.getSubimage(0, 3, image.getWidth(), image.getHeight() - 3);
            int w = image.getWidth();
            int h = image.getHeight();
            for (int x = 0; x < w; x++) {
                for (int y = 0; y < h; y++) {
                    int pixel = image.getRGB(x, y);
                    int red = (pixel >> 16) & 0xff;
                    int blue = (pixel) & 0xff;
                    int green = (pixel >> 8) & 0xff;
                    if (red == 255 && blue == 255 && green == 255) {
                        stores.addBlock(new Block(x * 32, y * 32 + 32, ID.Block));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("No se encontro la imagen");
        }

    }

}
