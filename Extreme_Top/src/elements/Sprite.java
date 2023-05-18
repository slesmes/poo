/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package elements;

import java.awt.Graphics;
import java.awt.image.ImageObserver;

/**
 *
 * @author Daniel Lesmes
 */
public abstract class Sprite {

    /**
     * Es cualquier figura dibujable en la pantalla.
     *
     * @author Santiago Lesmes Marín
     * @author María José Muñoz Posada
     * @version 1.0.0
     */

    /**
     * Coordenada en X de la ubicación del componente
     */
    protected int x;
    /**
     * Coordenada en Y de la ubicación del componente
     */
    protected int y;
    /**
     * Ancho de la ubicación del componente
     */
    protected int width;
    /**
     * Alto de la ubicación del componente
     */
    protected int height;
    protected Dimensionable area;

    public Sprite(int x, int y, int width, int height) {
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
    }

    /**
     * Diseña en la pantalla los compenentes.
     *
     * @param g La libreria Graphics que nos permite diseñar.
     * @param Window Contexto en donde se dibujan los componentes
     */
    public abstract void draw(Graphics g, ImageObserver Window);

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setArea(Dimensionable area) {
        this.area = area;
    }

}

