/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.edu.co.elementos;

/**
 *
 * @author Daniel Lesmes
 */
public class Home extends Comando {

    public void home() {
        mitorTortuga.x = mitorTortuga.getPosicioninicialx();
        mitorTortuga.y = mitorTortuga.getPosicioninicialy();
    }

}
