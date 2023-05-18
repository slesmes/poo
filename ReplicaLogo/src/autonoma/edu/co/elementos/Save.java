/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.edu.co.elementos;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 * Guarda las instrucciones actual a un archivo
 *
 * @author Santiago Lesmes Marín
 * @author María José Muñoz Posada
 * @version 1.0.0
 */
public class Save extends Comando {

    /**
     * Guarda los comandos en un archivo de texto.
     *
     * @param nombre el nombre del archivo a crear
     * @param comandos la lista de comandos a guardar en el archivo
     * @throws IOException si ocurre un error al escribir en el archivo
     */
    public void guardar_archivo(String nombre, ArrayList<String> comandos) throws IOException {
        RandomAccessFile nuevo_archivo = new RandomAccessFile(nombre + ".txt", "rw");
        nuevo_archivo.seek(nuevo_archivo.length());
        for (String Comando_actual : comandos) {
            nuevo_archivo.writeBytes(Comando_actual);
            nuevo_archivo.writeBytes(System.lineSeparator());
        }
        nuevo_archivo.close();
    }

}
