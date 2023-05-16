/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.edu.co.elementos;

import java.util.ArrayList;

/**
 *
 * @author Daniel Lesmes
 */
public class Reset extends Comando {


    public void reset(ArrayList<String> commandhystory){
        commandhystory.clear();
        mitorTortuga.getRastros().clear();
    }

    
}
