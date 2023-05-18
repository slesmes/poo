/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package elements;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;

/**
 *
 * @author Daniel Lesmes
 */
public class Patio extends Sprite implements Dimensionable, Drawable {

    private player player;
    /**
     * Es la interfaz que permite redibujar los cambios
     */
    private Drawable drawable;

    public Patio(int width, int height) {
        super(0, 0, width, height);
        player = new player(width / 2, height / 2);
        player.setdrawable(this);
    }

    @Override
    public void draw(Graphics g, ImageObserver Window) {
        getPlayer().draw(g, Window);
    }
   

    public void handleKey(int key) {
        if (key == KeyEvent.VK_LEFT
                | key == KeyEvent.VK_RIGHT
                | key == KeyEvent.VK_SPACE) {
            getPlayer().handleKey(key);
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


}
