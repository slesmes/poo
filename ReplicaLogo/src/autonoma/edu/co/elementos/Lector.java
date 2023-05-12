/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.edu.co.elementos;

import autonoma.edu.co.gui.LenguajeVentana;
import java.util.ArrayList;


public class Lector {
    private Tortuga tortuga;
    private LenguajeVentana lenguajeVentana;
    private ArrayList<String> commandHistory;
    private Comando comando;

    public Lector(Tortuga tortuga,LenguajeVentana lenguajeVentana) {
        this.tortuga = tortuga;
        this.lenguajeVentana = lenguajeVentana;
        this.commandHistory = new ArrayList<String>();
    }

    public void runCommand(String command) {
        commandHistory.add(command);
        String[] parts = command.toLowerCase().split(" ");
        String block = null;
        if (parts.length>2){
        block = command.substring(command.indexOf("[") + 1, command.indexOf("]"));
        }
        if (parts[0].equals("forward") || parts[0].equals("fd")){
            int distance = Integer.parseInt(parts[1]);
            tortuga.forward(distance);
        }else if(parts[0].equals("backward") || parts[0].equals("bd")){
            int distance2 = Integer.parseInt(parts[1]);
            tortuga.backWard(distance2);
        }else if (parts[0].equals("rightturn") || parts[0].equals("rt")){
            int grado = Integer.parseInt(parts[1]);
            tortuga.rightTurn(grado);
        }else if (parts[0].equals("leftturn") || parts[0].equals("lt")){
            int grado2 = Integer.parseInt(parts[1]);
            tortuga.leftTurn(grado2);
        }else if (parts[0].equals("setcolor") || parts[0].equals("sc")){
            tortuga.setColor(parts[1]);
        }else if (parts[0].equals("repeat")){
            tortuga.repetir_movimientos(block,parts[1]);
        }else{
            System.out.println("Comando no reconocido");
        }
    }

    public ArrayList<String> getCommandHistory() {
        return commandHistory;
    }
   
}
