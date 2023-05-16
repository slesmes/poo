/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.edu.co.elementos;

/**
 * Camino que deja la figura al realizar un movimiento.
 *
 * @author Santiago Lesmes Marín
 * @author María José Muñoz Posada
 * @version 1.0.0
 */
public class Rastro {
    /**
     * Coordenada en X de la ubicación inicial de la figura.
     */
    private int  initX;
    /**
     * Coordenada en Y de la ubicación inicial de la figura.
     */
    private int  initY;
    /**
     * Coordenada en X de la ubicación de la figura despues de un movimiento.
     */
    private int  endX;
    /**
     * Coordenada en Y de la ubicación de la figura despues de un movimiento.
     */
    private int endY;
     /**
     * Color por defecto del camino(negro)
     */
    private String Color="#000000";

    public Rastro(int initX, int initY, int endX, int endY) {
        this.initX = initX;
        this.initY = initY;
        this.endX = endX;
        this.endY = endY;
    }

    

    /**
     * @return the initX
     */
    public int getInitX() {
        return initX;
    }

    /**
     * @return the initY
     */
    public int getInitY() {
        return initY;
    }

    /**
     * @return the endX
     */
    public int getEndX() {
        return endX;
    }

    /**
     * @return the endY
     */
    public int getEndY() {
        return endY;
    }

    /**
     * @param initX the initX to set
     */
    public void setInitX(int initX) {
        this.initX = initX;
    }

    /**
     * @param initY the initY to set
     */
    public void setInitY(int initY) {
        this.initY = initY;
    }

    /**
     * @param endX the endX to set
     */
    public void setEndX(int endX) {
        this.endX = endX;
    }

    /**
     * @param endY the endY to set
     */
    public void setEndY(int endY) {
        this.endY = endY;
    }

    /**
     * @return the Color
     */
    public String getColor() {
        return Color;
    }

    /**
     * @param Color the Color to set
     */
    public void setColor(String Color) {
        this.Color = Color;
    }

    /**
     * @return the Color
     */

    /**
     * @param Color the Color to set
     */
    
    
    
    
    
}
