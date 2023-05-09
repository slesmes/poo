/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.edu.co.elementos;

/**
 *
 * @author Daniel Lesmes
 */
public class RightTurn extends Comando {

    private int degrees;

    public RightTurn(int degrees) {
        this.degrees = degrees;
    }

    @Override
    public void execute(Tortuga tortuga) {
        tortuga.rightTurn(degrees);
    }
  
}
