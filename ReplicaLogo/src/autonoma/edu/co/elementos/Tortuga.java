/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.edu.co.elementos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author Daniel Lesmes
 */
public class Tortuga extends Sprite {

    private int angle;
    private int oldX;
    private int oldY;
    private List<Rastro> rastros;
    private String ColorRastro = "000000";

    public Tortuga(int x, int y) {
        super(x - 25, y - 25, 50, 50);
        this.angle = 270;
        this.rastros = new ArrayList<>();
    }

    @Override
    public void draw(Graphics g, ImageObserver lenguajeVentana) {
        ImageIcon imagen = new ImageIcon(getClass().getResource("tortugaLogo.png"));
        g.drawImage(imagen.getImage(), getX(), getY(), getWidth(), getHeight(), lenguajeVentana);
        Graphics2D g2d = (Graphics2D) g;
        dibujarRastros(g);
    }

    public void addLine(int x, int y, int oldx, int oldy) {
        Rastro line = new Rastro(oldx, oldy, x, y);
        rastros.add(line);
    }

    public void dibujarRastros(Graphics g) {
        for (Rastro actual : rastros) {
            g.setColor(Color.decode(this.pasar_a_codigo()));
            g.drawLine(actual.getInitX(), actual.getInitY(), actual.getEndX(), actual.getEndY());
        }
    }

    public void forward(int distance) {
        int newX = x + (int) (distance * Math.cos(Math.toRadians(angle)));
        int newY = y + (int) (distance * Math.sin(Math.toRadians(angle)));
        oldY = y;
        oldX = x;
        x = newX;
        y = newY;
        addLine(oldX, oldY, x, y);
    }

    public void backWard(int distance) {
        forward(-distance);
    }

    public void leftTurn(int degrees) {
        angle = (angle - degrees + 360) % 360;
    }

    public void rightTurn(int degrees) {
        angle = (angle + degrees) % 360;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle % 360;
    }

    public void setColor(String color) {
        this.ColorRastro = color;
    }

    public String pasar_a_codigo() {
        switch (this.ColorRastro) {
            case "magenta":
                return "#FF00FF";
            case "orange":
                return "#FF8000";
            case "pink":
                return "#FF0080";
            case "white":
                return "#FFFFFF";
            case "yellow":
                return "#FFFF00";
            case "black":
                return "#000000";
            case "blue":
                return "#0000FF";
            case "cyan":
                return "#00FFFF";
            case "gray":
                return "#9B9B9B";
            case "green":
                return "#00FF00";
            default:
                return "#000000";
        }
    }

    public void repetir_movimientos(String comandos, String repeticiones) {
        String[] instrucciones = comandos.split(";");
        for (int j = 0; j < Integer.parseInt(repeticiones); j++) {
            for (int i = 0; i < instrucciones.length; i++) {
                interpretar_movimiento(instrucciones[i]);
            }
        }
    }

    public void interpretar_movimiento(String comando) {
        String[] componentes = comando.toLowerCase().split(" ");
        System.out.println(componentes[0]);
        switch (componentes[0]) {
            case "fd":
                int distancia = Integer.parseInt(componentes[1]);
                forward(distancia);
                break;
            case "bd":
                int distancia2 = Integer.parseInt(componentes[1]);
                backWard(distancia2);
                break;
            case "lt":
                int angle = Integer.parseInt(componentes[1]);
                leftTurn(angle);
                break;
            case "rt":
                int angle2 = Integer.parseInt(componentes[1]);
                rightTurn(angle2);
                break;
        }

    }
}
