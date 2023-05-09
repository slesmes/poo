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
 *
 * @author Daniel Lesmes
 */
public class Patio extends Sprite {
    
    private Tortuga tortuga;
    
    public Patio(int width, int height) {
        super(0, 0, width, height);
        tortuga = new Tortuga(width / 2, height / 2);
    }

    @Override
    public void draw(Graphics g,ImageObserver lenguajeVentana) {
        getTortuga().draw(g,lenguajeVentana);
        g.setColor(Color.GREEN);

    }

    /**
     * @return the tortuga
     */
    public Tortuga getTortuga() {
        return tortuga;
    }
    
}
