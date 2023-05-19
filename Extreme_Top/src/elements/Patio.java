/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package elements;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author Daniel Lesmes
 */
public class Patio extends Sprite implements Dimensionable, Drawable {

    private Random random;
    private player player;
    private LinkedList<Platform> plataformas;
    private int screenOffsetY = 0;
    private boolean cambioPantalla=false;
    /**
     * Es la interfaz que permite redibujar los cambios
     */
    private Drawable drawable;
    private Platform plataforma1;
    private Platform plataforma2;

    public Patio(int width, int height) {
        super(0, 0, width, height);
        random = new Random();
        player = new player(200, 615);
        plataformas = new LinkedList<>();
        plataforma1 = new Platform(100, height - 50, 600, 20);
        plataformas.add(plataforma1);
        generarPlataformas(10);
        player.setdrawable(this);
    }

    @Override
    public void draw(Graphics g, ImageObserver Window) {
        ImageIcon imagen = new ImageIcon(getClass().getResource("fondo.png"));
        g.drawImage(imagen.getImage(), getX(), getY(), getWidth(), getHeight(), Window);
        getPlayer().draw(g, Window);

        for (Platform actual : getPlataformas()) {
            g.fillRect(actual.getX(), actual.getY(), actual.getWidth(), actual.getHeight());
        }
        chocoObstaculo(g, Window);
    }

    public void handleKey(int key) {
        if (key == KeyEvent.VK_LEFT
                | key == KeyEvent.VK_RIGHT) {
            getPlayer().handleKey(key);
        }
    }

    public void handleKeyUp(int key) {
        if (key == KeyEvent.VK_SPACE) {
            getPlayer().handleKeyUp(key);
        }
    }

    @Override
    public void redraw() {
        drawable.redraw();
    }

    public void setdrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    /**
     * @return the player
     */
    public player getPlayer() {
        return player;
    }

    /**
     * @return the plataformas
     */
    public LinkedList<Platform> getPlataformas() {
        return plataformas;
    }

    private void generarPlataformas(int numPlatforms) {
        int screenWidth = 1000;
        int screenHeight = 1000;

        for (int i = 0; i < numPlatforms; i++) {
            int x = random.nextInt(screenWidth);
            int y = random.nextInt(screenHeight);
            int width = random.nextInt(100) + 50;
            int height = 20;

            Platform platform = new Platform(x, y, width, height);
            plataformas.add(platform);
        }
    }

    public void chocoObstaculo(Graphics g, ImageObserver Window) {

        int playerY = player.getY(); // Posición y del jugador
        int upperLimit = -5; // Límite superior antes de desplazar la pantalla

        if (playerY < upperLimit) {
            screenOffsetY = upperLimit - playerY;
             setCambioPantalla(true);
             render(g, Window);
        }
       
        System.out.println(cambioPantalla);

    }

    public void render(Graphics g,ImageObserver Window) {
        ImageIcon imagen = new ImageIcon(getClass().getResource("meteoro.png"));
        g.drawImage(imagen.getImage(), getX(), -screenOffsetY, getWidth(), getHeight(), Window);

        
        for (Platform platform : getPlataformas()) {
            int platformX = platform.getX();
            int platformY = platform.getY() - screenOffsetY;
            int platformWidth = platform.getWidth();
            int platformHeight = platform.getHeight();
            g.fillRect(platformX, platformY, platformWidth, platformHeight);
        }
        
        
        // Dibuja el jugador con el desplazamiento
        int playerX = player.getX();
        int playerY = player.getY() - screenOffsetY;
        ImageIcon imagenP = new ImageIcon(getClass().getResource("meteoro.png"));
        g.drawImage(imagenP.getImage(), playerX, playerY, getWidth(), getHeight(), Window);

        // Dibuja el jugador con el desplazamiento
    }

    /**
     * @param cambioPantalla the cambioPantalla to set
     */
    public void setCambioPantalla(boolean cambioPantalla) {
        this.cambioPantalla = cambioPantalla;
    }

}
