/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.edu.co.elementos;

/**
 * Lleva a la tortuga a posición inicial
 *
 * @author Santiago Lesmes Marín
 * @author María José Muñoz Posada
 * @version 1.0.0
 */
public class Home extends Comando {

    /**
     * Mueve la tortuga a su posición inicial.
     */
    public void home() {
        mitorTortuga.x = mitorTortuga.getPosicioninicialx();
        mitorTortuga.y = mitorTortuga.getPosicioninicialy();
    }

}
