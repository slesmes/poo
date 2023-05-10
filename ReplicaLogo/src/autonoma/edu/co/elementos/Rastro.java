/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.edu.co.elementos;

/**
 *
 * @author Daniel Lesmes
 */
public class Rastro {
    private int  initX;
    private int  initY;
    private int  endX;
    private int endY;

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
    
    
    
    
}
