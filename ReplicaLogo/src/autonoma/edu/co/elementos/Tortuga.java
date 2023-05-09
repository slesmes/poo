/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.edu.co.elementos;

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;

/**
 *
 * @author Daniel Lesmes
 */
public class Tortuga extends Sprite {

    private int angle;
    private boolean dejarrastro = true;

    public Tortuga(int x, int y) {
        super(x - 25, y - 25, 50, 50);
        this.angle = 270;
    }

    @Override
    public void draw(Graphics g, ImageObserver lenguajeVentana) {
        ImageIcon imagen = new ImageIcon(getClass().getResource("tortugaLogo.png"));
        g.drawImage(imagen.getImage(), getX(), getY(), getWidth(), getHeight(), lenguajeVentana);
    }

    public void forward(int distance) {
        int newX = x + (int) (distance * Math.cos(Math.toRadians(angle)));
        int newY = y + (int) (distance * Math.sin(Math.toRadians(angle)));
        x = newX;
        y = newY;

    }

    public void backWard(int distance) {
        forward(-distance);
    }

    public void leftTurn(int degrees) {
        angle = (angle - degrees + 360) % 360;
        ImageIcon imagen = new ImageIcon(getClass().getResource("tortugaLogo.png"));
    }

    public void rightTurn(int degrees) {
        angle = (angle + degrees) % 360;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle % 360;
    }
    


}
