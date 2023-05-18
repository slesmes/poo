/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.edu.co.elementos;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Carga un archivo de instrucciones al contexto actual
 *
 * @author Santiago Lesmes Marín
 * @author María José Muñoz Posada
 * @version 1.0.0
 */
public class Load extends Comando {

    /**
     * Ejecuta los comandos almacenados en un archivo.
     *
     * @param archivo el archivo que contiene los comandos a ejecutar
     * @throws IOException si ocurre un error al leer el archivo
     */
    public void ejecutar_comandos(RandomAccessFile archivo) throws IOException {
        String comando = archivo.readLine();
        while (comando != null) {
            mitorTortuga.interpretar_movimiento(comando);
            comando = archivo.readLine();
        }
    }

}
