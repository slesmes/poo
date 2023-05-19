/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package elements;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Daniel Lesmes
 */
public class player extends Sprite implements Drawable {

    /**
     * Es la interfaz que permite redibujar los cambios
     */
    private Drawable drawable;
    public final int GROWTH_FACTOR = 10;
    private int step;
    private static final int GRAVITY = 1;
    private float JUMP_FORCE = -40;
    private float yspeed = 0;
    private Timer time;
    private boolean ONGROUND = true;
    private boolean jumping = false;

    public player(int x, int y) {
        super(x, y, 75, 75);
        step = 10;
        time = new Timer(100, acciones);
    }

    @Override
    public void draw(Graphics g, ImageObserver Window) {
        ImageIcon imagen = new ImageIcon(getClass().getResource("king.png"));
        g.drawImage(imagen.getImage(), getX(), getY(), getWidth(), getHeight(), Window);
    }

    public void handleKey(int key) {
        if (key == KeyEvent.VK_LEFT
                | key == KeyEvent.VK_RIGHT) {
            move(key);
            redraw();
        }
    }

    public void handleKeyUp(int key) {
        if (key == KeyEvent.VK_SPACE) {
            up(key);
        }
    }
    //if(move(key))
    //if(Drawable != null)
    //drawable.redraw();

    public void move(int direction) {

        if (direction == KeyEvent.VK_LEFT) {
            x -= step;
        }

        if (direction == KeyEvent.VK_RIGHT) {
            x += step;
        }
        

    }

    public void up(int direction) {
        if (direction == KeyEvent.VK_SPACE) {
            jumping = true;
            time.start();
        }
    }

    @Override
    public void redraw() {
        drawable.redraw();
    }

    public void setdrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public void jump() {
        if (yspeed == 0 && ONGROUND) {
            Jump_force();
        }
    }

    public void Jump_force() {
        if (!jumping) {
            time.stop();
            yspeed = getJUMP_FORCE();
        }
    }

    public void restartJumpForce() {
        time.restart();
        time.stop();
    }

    private ActionListener acciones = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JUMP_FORCE--;
            //if (JUMP_FORCE < -25) {
                //setJUMP_FORCE(-25);
                //time.stop();
            //}
        }
    };

    public void update(int Alturaventana) {
        yspeed += GRAVITY;
        y += yspeed;

        if (y > Alturaventana - this.height) {
            y = Alturaventana - this.height;
            yspeed = 0;
        }
        if(!ONGROUND){
            yspeed+=GRAVITY;
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 75, 75);
    }

    public void land(int platformY) {
        y = platformY - this.height;
        yspeed = 0;
    }

    /**
     * @param ONGROUND the ONGROUND to set
     */
    public void setONGROUND(boolean ONGROUND) {
        this.ONGROUND = ONGROUND;
    }

    /**
     * @param jumping the jumping to set
     */
    public void setJumping(boolean jumping) {
        this.jumping = jumping;
    }

    /**
     * @return the JUMP_FORCE
     */
    public float getJUMP_FORCE() {
        return JUMP_FORCE;
    }

    /**
     * @return the ONGROUND
     */
    public boolean isONGROUND() {
        return ONGROUND;
    }

    /**
     * @param JUMP_FORCE the JUMP_FORCE to set
     */
    public void setJUMP_FORCE(float JUMP_FORCE) {
        this.JUMP_FORCE = JUMP_FORCE;
    }

}
