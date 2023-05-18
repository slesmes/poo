/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package elements;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;

/**
 *
 * @author Daniel Lesmes
 */
public class player extends Sprite implements Drawable{
     /**
     * Es la interfaz que permite redibujar los cambios
     */
    private Drawable drawable;
    public final int GROWTH_FACTOR = 10;
    private int step;
    private static final int GRAVITY = 1;
    private static final int JUMP_FORCE = -15;
    private int yspeed=0;

    public player(int x, int y) {
        super(x, y, 75, 75);
        step=10;
    }

    @Override
    public void draw(Graphics g, ImageObserver Window) {
        ImageIcon imagen = new ImageIcon(getClass().getResource("king.png"));
        g.drawImage(imagen.getImage(), getX(), getY(), getWidth(), getHeight(), Window);
    }
    
    public void handleKey(int key)
    {
        if(key == KeyEvent.VK_LEFT |
           key == KeyEvent.VK_SPACE |
           key == KeyEvent.VK_RIGHT)
        {
            move(key);
        }
            //if(move(key))
                //if(Drawable != null)
                    //drawable.redraw();
    }
    public void move(int direction){
        
        if(direction == KeyEvent.VK_LEFT)
            x -= step;
            
        if(direction == KeyEvent.VK_RIGHT)
            x += step;
            
        if(direction == KeyEvent.VK_SPACE)
            jump();
            
    }
    
   @Override
    public void redraw() {
        drawable.redraw();
    }

    public void setdrawable(Drawable drawable) {
        this.drawable = drawable;
    }
    public void jump() {
        if (yspeed == 0) {
            yspeed = JUMP_FORCE;
        }
    }
    
    public void update() {
        yspeed += GRAVITY;
        y += yspeed;
    }
    
    public Rectangle getBounds() {
        return new Rectangle(x, y, 75, 75);
    }
    public void land(int platformY) {
        y = platformY - 75;
        yspeed = 0;
    }
    
}
