/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.edu.co.elementos;

/**
 *
 * @author Daniel Lesmes
 */
public class Backward extends Comando {

    private int distance;

    public Backward(int distance) {
        this.distance = distance;
    }

    @Override
    public void execute(Tortuga tortuga) {
        tortuga.backWard(distance);
    }



    
    
}
