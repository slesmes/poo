/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package generics.y.lambda;


import java.util.List;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author estuam
 */
public class Tienda {
    private List<Productos> Productos;

    public Tienda(List<Productos> Productos) {
        this.Productos = Productos;
    }
    

    public void verInventario(){
        this.Productos.stream().forEach(x->System.out.println("nombre: "+x.getNombre()));
        this.Productos.stream().forEach(x->System.out.println("precio: "+x.getPrecio()));
        this.Productos.stream().forEach(x->System.out.println("cantidad: "+x.getCantidad()));
        
    }
    
    public void aumentarprecio(Productos p, double monton){
        this.Productos.stream().filter(x->x.equals(p)).forEach(q->q.aumentarprecio(monton));
        
    }
    
    public boolean estaenelinventario(String p){
        return this.Productos.stream().anyMatch(a->a.getNombre().equals(p));
    }
    
    public void productoscantidadmenor(int cantidad){
        List<Productos> productos= this.Productos.stream().filter(i->i.getCantidad()<=cantidad).collect(toList());
        System.out.println("los productos menores a la cantidad "+cantidad);
        productos.forEach(x->System.out.println("son: "+x.getNombre()));
    }
    
    public double totaldinero(){
        double total;
        total = this.Productos.stream().mapToDouble(x->x.getPrecio()*x.getCantidad()).sum();
        return total;
        
    }
}
