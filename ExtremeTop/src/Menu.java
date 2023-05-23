
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Menu extends Rectangle implements KeyListener {

    private Font f = new Font("Arial", Font.BOLD, 40);
    private BufferedImage title;
    private ArrayList<String> options;
    int selected = 0;
    private int state = 0;
    private final int MenuState = 0;
    private final int GamePlayState = 1;
    private final int EndState = 2;
    private Game main;
    private int timer = 0;
    private float alpha = 1f;
    private GamePlay gp;

    public void select() {
        switch (selected) {
            case 0:
                ChangeGameState();
                break;
            case 1:
                main.stop();
                break;
        }
    }

    public void tick() {
    }

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(Textures.menuBackground.load(), 0, 0, null);
        for (int i = 0; i < options.size(); i++) {
            if (selected == i) {
                g.setColor(Color.yellow);
            } else {
                g.setColor(Color.white);
            }
            g.setFont(f);
            g.drawString(options.get(i), 200, 350 + i * 100);
        }
    }

    public void DS() {
        if (selected < options.size() - 1) {
            selected++;
        } else {
            selected = 0;
        }
    }

    public void US() {
        if (selected > 0) {
            selected--;
        } else {
            selected = options.size() - 1;
        }
    }

    public Menu(Game main, stores stores) {
        options = new ArrayList<String>();
        options.add("Start Game");
        options.add("Quit");
        this.main = main;
        main.addKeyListener(this);
        gp = new GamePlay(main, stores, this);
    }

    public void keyPressed(KeyEvent e) {
        int input = e.getKeyCode();
        if (input == KeyEvent.VK_UP) {
            US();
        } else if (input == KeyEvent.VK_DOWN) {
            DS();
        }
        if (input == KeyEvent.VK_ENTER) {
            select();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public void update() {
        switch (state) {
            case MenuState:
                tick();
                break;
            case GamePlayState:
                gp.tick();
                break;
        }
    }

    public void renderMenu(Graphics g) {
        switch (state) {
            case MenuState:
                render(g);
                break;
            case GamePlayState:
                gp.render(g);
                break;
            case EndState:
                Graphics2D g2d = (Graphics2D) g;
                timer++;
                if (timer > 1000) {
                    if (alpha >= 0.01f) {
                        alpha -= 0.01f;
                    }
                    g.drawRect(0, 0, Game.WIDTH, Game.HEIGHT);
                    if (timer == 1500) {
                        ChangeGameState();
                    }
                }
                g2d.drawImage(Textures.end.load(), 0, 0, null);
                break;
        }
    }

    public void ChangeGameState() {
        if (state < EndState) {
            state++;
        } else {
            state = MenuState;
        }
    }
}
