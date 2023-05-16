/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.edu.co.elementos;

import autonoma.edu.co.gui.LenguajeVentana;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Recibe e interpreta las instrucciones solicitadas.
 *
 * @author Santiago Lesmes Marín
 * @author María José Muñoz Posada
 * @version 1.0.0
 */
public class Lector {

    /**
     * Figura que realiza las intrucciones de movimiento.
     */
    private Tortuga tortuga;
    /**
     * Contexto grafico donde se visualizan las instrucciones.
     */
    private LenguajeVentana lenguajeVentana;
    /**
     * Catalogo donde se almacenan las instrucciones realizadas, tanto validas
     * como no validas.
     */
    private ArrayList<String> commandHistory;
    /**
     * Orden que el usuario puede solicitar.
     */
    private Comando comando;

    public Lector(Tortuga tortuga, LenguajeVentana lenguajeVentana) {
        this.tortuga = tortuga;
        this.lenguajeVentana = lenguajeVentana;
        this.commandHistory = new ArrayList<String>();
    }

    /**
     * Valida y ejecuta las instrucciones ingresadas por el usuario.
     *
     * @param command Instruccion que el usuario ingresa.
     */
    public void runCommand(String command) {
        commandHistory.add(command);
        String[] parts = command.toLowerCase().split(" ");
        String block = null;
        if (parts.length > 2) {
            block = command.substring(command.indexOf("[") + 1, command.indexOf("]"));
        }
        if (parts[0].equals("forward") || parts[0].equals("fd")) {
            int distance = Integer.parseInt(parts[1]);
            tortuga.forward(distance);
        } else if (parts[0].equals("backward") || parts[0].equals("bd")) {
            int distance2 = Integer.parseInt(parts[1]);
            tortuga.backWard(distance2);
        } else if (parts[0].equals("rightturn") || parts[0].equals("rt")) {
            int grado = Integer.parseInt(parts[1]);
            tortuga.rightTurn(grado);
        } else if (parts[0].equals("leftturn") || parts[0].equals("lt")) {
            int grado2 = Integer.parseInt(parts[1]);
            tortuga.leftTurn(grado2);
        } else if (parts[0].equals("setcolor") || parts[0].equals("sc")) {
            tortuga.setColor(parts[1]);
        } else if (parts[0].equals("repeat")) {
            tortuga.repetir_movimientos(block, parts[1]);
        } else if (parts[0].equals("load") || parts[0].equals("l")) {
            leerArchivo(parts[1]);
        } else if (parts[0].equals("save") || parts[0].equals("s")) {
            verificarArchivoaGuardar(parts[1]);
        } else if (parts[0].equals("reset") || parts[0].equals("r")) {
            Reset resetear = new Reset();
            resetear.setMitorTortuga(tortuga);
            resetear.reset(this.commandHistory);
            Home casa = new Home();
            casa.setMitorTortuga(tortuga);
            casa.home();
        } else if (parts[0].equals("home") || parts[0].equals("h")) {
            Home casa = new Home();
            casa.setMitorTortuga(tortuga);
            casa.home();
        } else {
            System.out.println("Comando no reconocido");
        }
    }

    public ArrayList<String> getCommandHistory() {
        return commandHistory;
    }

    /**
     * Valida si un archivo existe y lo interpreta.
     *
     * @param nombreArchivo Es el nombre del archivo a interpretar.
     * @exception FileNotFoundException Si el archivo no se encuentra.
     * @exception IOException Si el archivo es nulo.
     */
    public void leerArchivo(String nombreArchivo) {
        try {
            RandomAccessFile archivoComandos = new RandomAccessFile(nombreArchivo + ".txt", "r");
            Load load = new Load();
            load.setMitorTortuga(tortuga);
            load.ejecutar_comandos(archivoComandos);
        } catch (FileNotFoundException ex) {
            System.out.println("archivo no encontrado");
        } catch (IOException ex) {
            System.out.println("Archivo vacio");
        }

    }

    /**
     *Verifica y guarda el archivo con el nombre especificado
     * @param nombre Es el nombre con el que se va a guaradar el archivo.
     * @throws  IOException Si ocurre un error al guardar el archivo.
     */
    public void verificarArchivoaGuardar(String nombre) {
        Save guardar = new Save();
        try {
            guardar.guardar_archivo(nombre, this.commandHistory);
        } catch (IOException ex) {
            Logger.getLogger(Lector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
