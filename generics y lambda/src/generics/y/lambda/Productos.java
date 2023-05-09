/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package generics.y.lambda;

/**
 *
 * @author estuam
 */
public class Productos {
    private String nombre;
    private double precio;
    private int cantidad;

    public Productos(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public int getCantidad() {
        return cantidad;
    }
    
    public void pedir(int cantidad){
        
    }
    
    public void vender(int cantidad){
        
    }
    
    public void aumentarprecio(double monto){
        this.precio += monto;
    }

    /**
     * @return the cantidad
     */
    
    
    
    
    
}
