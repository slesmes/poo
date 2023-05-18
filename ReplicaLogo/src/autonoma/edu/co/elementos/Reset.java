/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.edu.co.elementos;

import java.util.ArrayList;

/**
 * Limpia todo y deja la tortuga en posición inicial
 *
 * @author Santiago Lesmes Marín
 * @author María José Muñoz Posada
 * @version 1.0.0
 */
public class Reset extends Comando {

    /**
     * Reinicia el estado de la tortuga.
     *
     * @param commandhystory Es la lista dle historial de comandos
     */
    public void reset(ArrayList<String> commandhystory) {
        commandhystory.clear();
        mitorTortuga.getRastros().clear();
        mitorTortuga.setAngle(270);
        mitorTortuga.setColorRastro("#000000");
    }

}
