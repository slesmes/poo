/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.edu.co.elementos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 *
 * @author Daniel Lesmes
 */
public class Save extends Comando {

    public void guardar_archivo(String nombre,ArrayList<String> comandos) throws IOException {
        RandomAccessFile nuevo_archivo = new RandomAccessFile(nombre+".txt", "rw");
        nuevo_archivo.seek(nuevo_archivo.length());
        for (String Comando_actual:comandos){
            nuevo_archivo.writeBytes(Comando_actual);
            nuevo_archivo.writeBytes(System.lineSeparator());
        }
        nuevo_archivo.close();
    }

    


   
    
}
