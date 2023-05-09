/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones.banco;


import excepciones.banco.excepciones.MontoNegativoException;
import excepciones.banco.excepciones.SaldoInsuficienteException;

/**
 *
 * @author estuam
 */
public class Cuenta {
    private double saldo;

    public Cuenta(double saldo) {
        this.saldo = 0;
    }
    
    public double obtenerSaldo(){
        return saldo;
    }
    
    public void consignar(double monto){
        if(monto<= 0)
            throw new MontoNegativoException(monto);
        saldo += monto;
    }
    
    public void retirar( double monto){
        if(monto<= 0)
            throw new MontoNegativoException(monto);
        if (monto > saldo){
            SaldoInsuficienteException e = new SaldoInsuficienteException();
            throw e;
        }
        saldo -= monto;
    }
    
    
}
