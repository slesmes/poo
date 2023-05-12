/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.edu.co.elementos;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Daniel Lesmes
 */
public class Load extends Comando {

    @Override
    public void execute(String parametro) {
        
    }
    public void ejecutar_comandos(RandomAccessFile archivo) throws IOException{
        String comando = archivo.readLine();
        while(comando != null){
            mitorTortuga.interpretar_movimiento(comando);
            comando = archivo.readLine();
        }
    }

   

   
    
}
