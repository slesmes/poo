/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package excepciones;

import excepciones.banco.Cuenta;
import excepciones.banco.excepciones.MontoNegativoException;

/**
 *
 * @author estuam
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cuenta c = new Cuenta(0);
        
        try{
            c.consignar(-1);    
        }
        catch(MontoNegativoException e){
            System.out.println("OH OH");
            
            //e.printStackTrace(); imprimir exceptions 
            
            System.out.println(e.getMessage());
        }
        
        System.out.println("Saldo: "+ c.obtenerSaldo());
    }
    
}
