/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones.banco.excepciones;

/**
 *
 * @author estuam
 */
public class MontoNegativoException extends RuntimeException{
    public MontoNegativoException(double monto){
        super(monto+" no puede ser un monto negativo");
    }
}
