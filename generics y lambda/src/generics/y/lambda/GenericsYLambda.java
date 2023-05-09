/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package generics.y.lambda;

import java.util.LinkedList;

/**
 *
 * @author estuam
 */
public class GenericsYLambda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Productos producto1 = new Productos("aguacate", 3275.0, 217);
        LinkedList<Productos> x = new LinkedList<>();
        x.add(new Productos("manzana", 2000.0, 300));
        x.add(new Productos("cereal", 35000.0, 450));
        x.add(new Productos("pan", 5750.0, 120));
        x.add(new Productos("atun", 40000.0, 543));
        x.add(new Productos("galleta", 23000.0, 378));
        x.add(new Productos("azucar", 12467.0, 381));
        x.add(new Productos("carne", 47560.0, 623));
        x.add(producto1);
        
        
        Tienda tienda1 = new Tienda(x);
        tienda1.verInventario();
        System.out.println("el producto papaya "+tienda1.estaenelinventario("papaya"));
       tienda1.productoscantidadmenor(350);
        System.out.println("el total de dinero es: "+tienda1.totaldinero());
        tienda1.aumentarprecio(producto1, 200);
        System.out.println("el precio aumentado de "+producto1.getNombre()+" es igual a "+producto1.getPrecio());
        
    }
        
    
    
        
}
