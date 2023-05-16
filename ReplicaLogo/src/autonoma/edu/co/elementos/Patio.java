/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.edu.co.elementos;

import autonoma.edu.co.gui.LenguajeVentana;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.ImageObserver;

/**
 * Representa el lugar donde la tortuga se mueve y deja su rastro.
 *
 * @author Santiago Lesmes Marín
 * @author María José Muñoz Posada
 * @version 1.0.0
 */
public class Patio extends Sprite implements Dimensionable, drawable {

    /**
     *  Es la figuraGrafica que se mueve dentro de esta clase
     */
    private Tortuga tortuga;
    /**
     *  Es la interfaz que permite redibujar los cambios 
     */
    private drawable drawable;

    public Patio(int width, int height) {
        super(0, 0, width, height);
        tortuga = new Tortuga(width / 2, height / 2);
        tortuga.setArea(this);
        tortuga.setdrawable(this);
    }

    @Override
    public void draw(Graphics g, ImageObserver lenguajeVentana) {
        getTortuga().draw(g, lenguajeVentana);
        g.setColor(Color.GREEN);
    }

    /**
     * @return the tortuga
     */
    public Tortuga getTortuga() {
        return tortuga;
    }

    @Override
    public void redraw() {
        drawable.redraw();
    }

    public void setdrawable(drawable drawable) {
        this.drawable = drawable;
    }
}
